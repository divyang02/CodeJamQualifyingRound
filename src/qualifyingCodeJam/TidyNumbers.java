package qualifyingCodeJam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class TidyNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader rd = new BufferedReader(new FileReader("B-large.txt"));
			File file = new File("output.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			String temp = rd.readLine();
			int T = Integer.parseInt(temp);
		    for (int C = 1; C <= T; C++) {
		    	String temp1 = rd.readLine();
		    	writer.write("Case #" + C + ": " + solve(temp1) + "\n");
		    }
		    writer.flush();
		    writer.close();
		    rd.close();
		} catch (IOException ex) {
			System.out.println("file not found");
		}
	
		/**Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			String temp = "11111110";
			System.out.println("Case #" + i + ": " + solve(temp) + "\n");
		}**/
	}
	
	private static String solve(String n) {
		if(n.length() == 1) return n;
		int j = 1;
		int i = 0;
		while(j < n.length()) {
			int bef = Character.getNumericValue(n.charAt(i));
			int aft = Character.getNumericValue(n.charAt(j));
			if(bef > aft) {
				return makeString(n, i, j);
			} else {
				i++;
				j++;
			}
		}
		return n;
	}
	
	private static String makeString(String n, int i, int j) {
		if(Character.getNumericValue(n.charAt(i)) == 1) {
			int temp = i-1;
			String make = "";
			while(temp > -1 && Character.getNumericValue(n.charAt(temp)) - 1 == 0) {
				temp--;
			}
			if(temp == -1) {
				String t = "";
				for(int k = 0; k < n.length() - 1; k++) {
					t += "9";
				}
				return t;
			} else {
				make += n.substring(0, temp);
				make += Character.getNumericValue(n.charAt(temp)) - 1;
				for(int k = j; k < n.length(); k++) {
					make += "9";
				}
			}
			return make;
		} else {
			String make = "";
			int temp = i-1;
			while(temp > -1 && Character.getNumericValue(n.charAt(i)) == Character.getNumericValue(n.charAt(temp))) {
				temp--;
			}
			temp++;
			make += n.substring(0, temp);
			make += Character.getNumericValue(n.charAt(temp)) - 1;
			for(int k = temp+1; k < n.length(); k++) {
				make += "9";
			}
			return make;
		}
	}
	
}
