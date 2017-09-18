import java.util.HashSet;

public class MergeKLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		
		l1.next=new ListNode(5);
		l1.next.next=new ListNode(8);
		
		l2.next=new ListNode(7);
		l2.next.next=new ListNode(9);
		
		l3.next=new ListNode(4);
		l3.next.next=new ListNode(6);
		l3.next.next.next=new ListNode(10);
		
		ListNode[] lists={l1,l2,l3};
		
		ListNode fin=mergeKLists(lists);
		
		HashSet<Integer> set=new HashSet<Integer>();
		
		while(fin!=null)
		{
			System.out.print(fin.val+" ");
			fin=fin.next;
		}
	}
	
    public static ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null||lists.length==0)
        {
        	return null;
        }
        if(lists.length==1) return lists[0];
        ListNode aux=new ListNode(Integer.MAX_VALUE);
        ListNode head=aux;
        ListNode l1=lists[0];
        ListNode l2=lists[1];
        
        ListNode[] update=new ListNode[lists.length-1];
        
        while(l1!=null && l2!=null)
        {
        	if(l1.val<l2.val){ 
        		aux.val=l1.val;
        		l1=l1.next;
        	}
        	else {
        		aux.val=l2.val;
        		l2=l2.next;
        	}
        	aux.next=new ListNode(Integer.MAX_VALUE);
        	aux=aux.next;
        }
        while(l1!=null)
        {
        	aux.val=l1.val;
    		l1=l1.next;
    		aux.next=new ListNode(Integer.MAX_VALUE);
        	aux=aux.next;
        }
        
        while(l2!=null)
        {
        	aux.val=l2.val;
    		l2=l2.next;
    		aux.next=new ListNode(Integer.MAX_VALUE);
        	aux=aux.next;
        }
        
        
        update[0]=head;
        
        for(int i=2,j=1;i<lists.length;i++,j++)
        {
        	update[j]=lists[i];
        }
		
        aux=mergeKLists(update);
        
//        ListNode dude=aux;
//        while(dude.next!=null)
//        {
//        	if(dude.val==Integer.MAX_VALUE)
//        	{
//        		dude.next=null;
//        	}
//        	dude=dude.next;
//        }
        return aux;
    }
}
