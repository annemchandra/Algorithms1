package com.hw.pa;

import java.util.Scanner;
import java.util.Stack;

public class ProgramAssignment2 {
    public static void main(String []args) 
    {
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter String of ()");

        String enterString = scanner.nextLine(); 
        System.out.println("Length of Longest String of (): "+ findLongestPar(enterString));
    }
    public static int findLongestPar(String s) {
    	//I have used Stack to store the indices of the characters
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
       // System.out.println(st);
        int validparelegth = 0;
        // loop iterates for characters in String
        for(int loop = 0; loop < s.length(); loop++)
        {
        	//push '(' if found
            if(s.charAt(loop) == '(')
                st.push(loop);
            else if(s.charAt(loop) == ')')
            {    
  /*pop the top element from the stack if the character is ')' 
   and calculate the length of the longest valid parentheses */
                st.pop();
                //check if stack is empty, so found string of()
                //System.out.println(st.empty());
                if(st.empty())
                    st.push(loop);
                else
                	//System.out.println(validparelegth);
                	//System.out.println(loop);
                	//System.out.println(st.peek());
                	validparelegth = Math.max(validparelegth, loop - st.peek());     
            }
        }
        return validparelegth;
    }
}