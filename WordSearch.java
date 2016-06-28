import java.io.*;
import java.util.Scanner;


public class WordSearch {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int m,n =0;
		System.out.println("Enter the array row size: ");
		m = sc.nextInt();
		System.out.println("Enter the array column size: ");
	  n = sc.nextInt();
	  System.out.println("row value: " + m + " & Column value: " + n);

		System.out.println("Enter the values in the grid: ");
		sc.nextLine();

		char[][] grid = new char[m][n];

	  for(int j=0;j<n;j++)
	  {
		  grid[j] = sc.nextLine().toCharArray();
	  }

		System.out.println("Printing the values in the grid: ");
	  for (int i=0;i<m;i++)
	  {
		 for(int k=0;k<n;k++)
		 {
			 System.out.print(grid[i][k]);
		 }
		System.out.println();
	  }
   	System.out.println("Enter the pattern to search : ");
		String wordtosearch = sc.nextLine();
   	patternSearch(grid,wordtosearch);

	}

	static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };


	public static boolean search2D(char[][] grid, int row, int col, String word){
	    // If first character of word doesn't match with
	    // given starting point in grid.
		char[] mychar = new char[word.length()];
		mychar = word.toCharArray();
		int R = grid.length;
		int C = grid[0].length;

    if (grid[row][col] != mychar[0])
      return false;

    int len = word.length();

    // Search word in all 8 directions starting from (row,col)
    for (int dir = 0; dir < 8; dir++)
    {
        // Initialize starting point for current direction
        int k, rd = row + x[dir], cd = col + y[dir];

        // First character is already checked, match remaining
        // characters
        for (k = 1; k < len; k++)
        {
            // If out of bound break
            if (rd >= R || rd < 0 || cd >= C || cd < 0)
                break;

            // If not matched,  break
            if (grid[rd][cd] != mychar[k])
                break;

            //  Moving in particular direction
            rd += x[dir];
            cd += y[dir];
        }

        // If all character matched, then value of must
        // be equal to length of word
        if (k == len)
            return true;
    }
    return false;
	}

	public static void patternSearch(char[][] grid, String word){
	    // Consider every point as starting point and search
	    // given word
		int R = grid.length;
		int C = grid[0].length;
		boolean flag = true;
		int count = 0;
	    for (int row = 0; row < R; row++)
	    {
	       for (int col = 0; col < C; col++)
	       {
	          if (search2D(grid, row, col, word)){
	             	System.out.println("Yes, Pattern found at : " +row+ " , " + col + "!!!");
	          	count=1;
	          }
	          else
	        	flag = false;
	       }
	    }

	  if(!flag && count==0)
		  System.out.println("Pattern not found!!!");
	}

}
