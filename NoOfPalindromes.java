/* given a string, out the number of palindromes  it contains */

import java.util.HashMap;
import java.util.HashSet;

public class NoOfPalindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPalindromeCount("aabaab")+"");
	}
	
	public static int getPalindromeCount(String s)
	{
		int count=0, x=0,y=0;
		HashSet<String> set=new HashSet<String>(); 
		
		
		for(int i=1;i<s.length();i++)
		{
			set.add(s.charAt(i)+""); //every unique character is a palindrome in itself
			
				x = i-1;
				y = i+1;

			//odd length of palindrome
				while(x>=0 && y<s.length() && s.charAt(x)==s.charAt(y))
				{
					//System.out.println(s.substring(x, y+1));
					set.add(s.substring(x, y+1));
					x--;
					y++;
				}
			
			//even

				x = i-1;
				y = i;

			//even length of palindrome
				while(x>=0 && y<s.length() && s.charAt(x)==s.charAt(y))
				{
					//System.out.println(s.substring(x, y+1));
					set.add(s.substring(x, y+1));
					x--;
					y++;
				}
		}
		
		for(String str: set)
		{
			System.out.println(str);
		}
		count=set.size();
		return count;
	}

}
