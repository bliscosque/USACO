import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: bliscos1
LANG: JAVA
TASK: ride
*/
public class ride {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer l1 = new StringTokenizer(f.readLine());
		
		String p1 = l1.nextToken();
		//System.out.println(p1);
		long prod1 = 1;
		for (int i = 0; i < p1.length(); i++) {
			//System.out.println(conv(p1.charAt(i)));
			prod1*=conv(p1.charAt(i));
		}
		StringTokenizer l2 = new StringTokenizer(f.readLine());
		System.out.println(prod1);
		
		String p2 = l2.nextToken();
		//System.out.println(p2);
		long prod2 = 1;
		for (int i = 0; i < p2.length(); i++) {
			//System.out.println(conv(p2.charAt(i)));
			prod2*=conv(p2.charAt(i));
		}
		System.out.println(prod2);
		if (prod1%47==prod2%47) {
			 out.println("GO");
		}
		else
			out.println("STAY");
		out.close(); // close the output file
	}

	private static int conv(char c) {
		return c - 'A' + 1;
	}
}
