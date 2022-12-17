
package com.hw.pa;

import java.util.*;
public class ProgramAssignment1
{
	public static void main(String[] args) {
		//Scanner class in java is used to accept inputs at run time
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Value of X");
		int X=scanner.nextInt();
		System.out.println("Enter Value of Y");
		int Y=scanner.nextInt();
		System.out.println("Enter Value of n");
		int n=scanner.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		int[] c=new int[n];
		for(int i=0;i<n;i++)
		{
			//Here a and b are the rectangle cloth cut dimensions
			//c will be the selling price
			System.out.println("Enter Value of a,b,c");
			a[i]=scanner.nextInt();
			b[i]=scanner.nextInt();
			c[i]=scanner.nextInt();
		}
		long maxProfit = calculateMaxProfit(X,Y,a,b,c);
		System.out.println(maxProfit);
	}
	static long calculateMaxProfit(int X, int Y,int a[],int b[],int c[])
	{
		
		long CUT[][]=new long[X+1][Y+1];
		for(int m=1;m<=X;m++)
		{
			for(int n=1;n<=Y;n++)
			{
				//Do vertical and Do Horizontal cuts
				for(int mcut=1;mcut<m;mcut++)
				{
					CUT[m][n] = Math.max(CUT[m][n], CUT[mcut][n] + CUT[m - mcut][n]);
				}
				for(int ncut=1;ncut<n;ncut++)
				{
					CUT[m][n] = Math.max(CUT[m][n], CUT[m][ncut] + CUT[m][n - ncut]);
				}
				
				for(int j=0;j<c.length;j++)
				{
					if((a[j]==m && b[j]==n) || (a[j]==n && b[j]==m))
					{ 
						CUT[m][n] = Math.max(CUT[m][n], c[j]);
					}
//					else if(a[j]==n && b[j]==m)
//					{
//						CUT[n][m] = Math.max(CUT[n][m], c[j]);
//					}
				}
			}
		}
		return CUT[X][Y];
	}
	
}

/* 
TC: #1

Enter Value of X
64
Enter Value of Y
10
Enter Value of n
5
Enter Value of a,b,c
2
4
16
Enter Value of a,b,c
4
2
20
Enter Value of a,b,c
1
1
1
Enter Value of a,b,c
21
23
50
Enter Value of a,b,c
12
21
30

TC: #2
Enter Value of Y
81
Enter Value of n
6
Enter Value of a,b,c
2
3
8
Enter Value of a,b,c
4
5
30
Enter Value of a,b,c
1
4
9
Enter Value of a,b,c
12
15
17
Enter Value of a,b,c
6
6
12
Enter Value of a,b,c
4
6
10

TC: #3
Enter Value of X
118
Enter Value of Y
34
Enter Value of n
5
Enter Value of a,b,c
19
2
12
Enter Value of a,b,c
4
32
50
Enter Value of a,b,c
15
20
100
Enter Value of a,b,c
2
23
100
Enter Value of a,b,c
4
3
12
*/
