class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
class GfG
{
    
    private Node flatten2Col(Node secondLast, Node prev){
        Node last = secondLast.next;
        if(secondLast.next.next != null){
            last = flatten2Col(secondLast.next, secondLast);
        }
        
        Node curr = secondLast;
        secondLast.next = null;
        
        if(curr.data > last.data){
            Node lastNode = last;
            last = curr;
            curr = lastNode;
        }
        
        Node currTop = curr;
        
        while(curr.bottom != null){
            if(last != null && last.data < curr.bottom.data){
                Node belowLast = last.bottom;
                last.bottom = curr.bottom;
                curr.bottom = last;
                last = belowLast;
            }
            
            curr = curr.bottom;
        }
        
        curr.bottom = last;
        
        return currTop;
    }
    
    Node flatten(Node root)
    {
        if(root == null || root.next == null) return root;
	    
	    return flatten2Col(root, null);
    }
}