package qualifyingCodeJam;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BathroomStalls {
	
	private static int max;
	private static int min;
	
	private static class Node {
		int LS;
		int RS;
		public Node(int ls, int rs) {
			LS = ls;
			RS = rs;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			long p = in.nextLong();
			long q = in.nextLong();
			solveMin(p,q);
			System.out.println("Case #" + i + ": " + max + " " + min + "\n");
		}
		
		/**try {
			BufferedReader rd = new BufferedReader(new FileReader("C-small-1-attempt0.txt"));
			File file = new File("output.txt");
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			String temp = rd.readLine();
			int T = Integer.parseInt(temp);
		    for (int C = 1; C <= T; C++) {
		    	String temp1 = rd.readLine();
		    	String[] digits = temp1.split(" ");
		    	int p = Integer.parseInt(digits[0]);
		    	int q = Integer.parseInt(digits[1]);
		    	solveMin(p,q);
		    	writer.write("Case #" + C + ": " + max + " " + min + "\n");
		    }
		    writer.flush();
		    writer.close();
		    rd.close();
		} catch (IOException ex) {
			System.out.println("file not found");
		}**/
	}
	
	private static void solveMin(long p, long q) {
		boolean[] br = new boolean[(int)p+2];
		br[0] = true;
		br[(int)p+1] = true;
		while(q != 0) {
			Node t1 = new Node(0,0);
			int index = 0;
			for(int i = 1; i < p+1; i++) {
				Node t2 = new Node(0,0);
				if(br[i] == true) continue;
				else {
					int x1 = i-1;
					int x2 = i+1;
					while (br[x1] != true) {
						t2.LS++;
						x1--;
					}
					while(br[x2] != true) {
						t2.RS++;
						x2++;
					}
					if(Math.min(t2.LS,t2.RS) > Math.min(t1.LS, t1.RS)) {
						t1.LS = t2.LS;
						t1.RS = t2.RS;
						index = i;
					} else if(Math.min(t2.LS,t2.RS) == Math.min(t1.LS, t1.RS)) {
						if(Math.max(t2.LS,t2.RS) > Math.max(t1.LS, t1.RS)) {
							t1.LS = t2.LS;
							t1.RS = t2.RS;
							index = i;
						} 
					}
				}	
			}
			//System.out.println(t1.LS + " " + t1.RS);
			br[index] = true;
			q--;
			max = Math.max(t1.LS, t1.RS);
			min = Math.min(t1.LS, t1.RS);
		}
	}
}
