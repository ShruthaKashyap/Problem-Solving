import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AlphabetCount {

	static ArrayList<String> list=new ArrayList<String>(); //list to contain final output

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alphaChar="abcdefghijklmnopqrstuvwxyz".toCharArray();

		String input="1123";
		
		String build="";
		
		getCharCode(input,alphaChar,0,build);
		
		int i=0;
		
		//A naive way to remove the intermediate strings added during recursion calls. FML.
		while(i<list.size()-1)
		{
			if(list.get(i).contains(list.get(i+1)))
			{
				list.remove(i+1);
			}
			else
			{
				i++;
			}
		}
		
		System.out.println(list+"\n"+list.size());
	}
	
	public static String getCharCode(String input, char[] alphaChar, int i, String build)
	{
		if(input=="")
		{
			return "";
		}
		else if(input.length()==1)
		{
			build+=alphaChar[Integer.parseInt(input)-1];
			build+=getCharCode("",alphaChar,i,build);
			
			list.add(build);

			build="";
			
			return build;
		}
		else if(input.length()==2)
		{
			//Check if the double digit substring is less than 26
			if(Integer.parseInt(input)<=26)
			{
				String temp=build;
				build+=alphaChar[Integer.parseInt(input)-1];
				build+=getCharCode("",alphaChar,i,build);
				list.add(build);
				build=temp;
				//return build;
			}
			
			//For single digit combinations
			build+=alphaChar[Integer.parseInt(input.charAt(i)+"")-1];
			build+=getCharCode(input.charAt(i+1)+"",alphaChar,i, build);
			list.add(build);
			build="";
			
			return build;
		}
		else{
		int substrInt=Integer.parseInt(input.substring(i, i+2));
			
		//Check if the double digit substring is less than 26
		if(substrInt<=26)
		{
			String temp=build;
			build+=alphaChar[substrInt-1];
			build+=getCharCode(input.substring(i+2),alphaChar,i,build);
			list.add(build);
			build=temp;
			//return build;
		}
			
		//For single digit combinations
		build+=alphaChar[Integer.parseInt(input.charAt(i)+"")-1];
		build+=getCharCode(input.substring(i+1),alphaChar,i,build);
		list.add(build);
		build="";
		
		return build;
		}
	}

}
