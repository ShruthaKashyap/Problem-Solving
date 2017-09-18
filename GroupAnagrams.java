import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}
	
public static List<List<String>> groupAnagrams(String[] strs) {
        
        StringBuilder sb=new StringBuilder();
        String[] newString=strs.clone();
        
        for(String s:newString)
        {
        	Arrays.sort(s.toCharArray());
        }
        
        System.out.println(newString[0]+" "+newString[1]);
        List<List<String>> lst = new ArrayList<List<String>>();
        System.out.println(Math.log10(64));
        for(int i=0;i<newString.length;i++)
        {
        	
        	//Arrays.sort(newString[i].toCharArray());
            List<String> row = new ArrayList<String>();
            row.add(strs[i]);
            
            for(int j=i+1;j<newString.length;j++)
            { 
            	//Arrays.sort(newString[i].toCharArray());
                if(newString[i]==newString[j])
                {
                    row.add(strs[j]);
                }
            }
            
            lst.add(row);
        }
          
        return lst;
    }
}
