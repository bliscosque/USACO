import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*
ID: bliscos1
LANG: JAVA
TASK: friday
*/

public class friday {
	public static void main(String[] args) {
		int[] diaMes={31,28,31,30,31,30,31,31,30,31,30,31};
		int[] dias =new int[8];
		
		try (BufferedReader br = new BufferedReader(new FileReader("friday.in"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("friday.out"))) {
		int anos=Integer.parseInt(br.readLine());
		
		int anoAt=1900;
		int diaAt=1; //Monday
		for (int i =0;i<anos;i++) {
			//ajustando fevereiro
			if (isLeapYear(anoAt)) {
				diaMes[1] =29;
				//System.out.println("isLeap:" + anoAt);	
			}
			else diaMes[1]=28;
			
			for (int m=0;m<12;m++) {
				for (int d=1;d<=diaMes[m];d++) {
					if (d==13) {
						dias[diaAt]++;
						//System.out.println("ano: " + anoAt+ " mes: " + m + " dia: "+ d + " d semana: " + diaAt);
					}
					diaAt++;
					if (diaAt==8) diaAt=1;
				}
			}
			
			anoAt++;
		}
		System.out.println(Arrays.toString(dias));
		bw.write(dias[6] + " "+ dias[7] + " " + dias[1] + " "+ dias[2] + " " + dias[3] + " "+ dias[4] + " " + dias[5] + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static boolean isLeapYear(int ano) {
		
		if (ano%100==0) {
			if (ano%400==0) return true;
			else return false;
		}
		if (ano%4==0) {
			return true;
		}
		else return false;
	}
}
