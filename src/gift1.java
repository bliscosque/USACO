import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/*
ID: bliscos1
LANG: JAVA
TASK: gift1
*/
public class gift1 {

	static String[] names;

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("gift1.out"))) {

			// number of people
			int n = Integer.parseInt(br.readLine());
			// names
			names = new String[n];
			int[] valores = new int[n];

			for (int i = 0; i < n; i++) {
				names[i] = br.readLine().trim();
			}

			System.out.println(Arrays.toString(names));
			String giver;
			String receiver;
			while ((giver = br.readLine()) != null) {
				int idGiver = retId(giver);
				String[] lines = br.readLine().trim().split(" ");
				int val = Integer.parseInt(lines[0]);
				int nRec = Integer.parseInt(lines[1]);

				if (nRec != 0) {
					int div = val / nRec;
					int res = val % nRec;
					valores[idGiver] -= val;
					valores[idGiver] += res;

					for (int i = 0; i < nRec; i++) {
						receiver = br.readLine();
						int id = retId(receiver);
						valores[id] += div;

					}
				}
				// System.out.println(Arrays.toString(valores));

			}
			for (int i = 0; i < names.length; i++) {
				bw.write(names[i] + " " + valores[i] + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int retId(String pessoa) {
		// System.out.println("buscando: " + pessoa);
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(pessoa)) {
				// System.out.println("id: " + i);
				return i;
			}
		}
		return -1;
	}
}
