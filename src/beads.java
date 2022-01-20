import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
ID: bliscos1
LANG: JAVA
TASK: beads
*/
public class beads {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("beads.in"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("beads.out"))) {

			int n = Integer.parseInt(br.readLine());
			String beads = br.readLine();
			char[] beads2 = (beads + beads).toCharArray();
			int maxV = 0;
			if (beads.contains("r") && !beads.contains("b") || beads.contains("b") && !beads.contains("r")) {
				maxV = n;
				//System.out.println("maxV: " + maxV);
			} else if (beads.contains("w") && !beads.contains("b") && !beads.contains("r")) {
				maxV = n; //only w
			} else {
				for (int i = 1; i < beads2.length; i++) {
					//System.out.println("Pos: " + i);
					int count = 0;
					char color_after = beads2[i];
					if (color_after == 'w')
						for (int pos = i; pos < beads2.length; pos++) {
							if(beads2[pos]!='w') {
								color_after=beads2[pos];
								break;
							}
						}
					// direita
					for (int pos = i; pos < beads2.length; pos++) {
						if (beads2[pos] != oposite(color_after)) count++;
						else break;	
					}
					//System.out.println("direita: " + count);
					
					char color_b4 = beads2[i-1];
					if (color_b4 == 'w')
						for (int pos = i-1; pos >=0; pos--) {
							if(beads2[pos]!='w') {
								color_b4=beads2[pos];
								break;
							}
						}
					// esquerda
					for (int pos = i-1; pos >= 0; pos--) {
						if (beads2[pos] != oposite(color_b4)) count++;
						else break;
					}
					
					//System.out.println("tot: " + count);
					maxV = Math.max(maxV, count);
					//System.out.println("maxV: " + maxV);
				}
			}
			if (maxV > n) maxV=n;
			bw.write(maxV + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static char oposite(char c) {
		if (c == 'r')
			return 'b';
		else
			return 'r';
	}
}
