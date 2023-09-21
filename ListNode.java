public class ListNode<E>
{
    private E value;
    private ListNode<E> next;
    
    //constructor(s)
    public ListNode(E val)
    {
        value = val;
        next = null;
    }
    
    public ListNode(E val, ListNode<E> nectNode)
    {
        value = val; 
        next = nectNode;
    }
    
    public E getValue()
    {
        return value;
    }
    
    public ListNode<E> getNext()
    {
        return next;
    }
    
    public boolean hasNext()
    {
        return (next != null);
    }
    
    public void setValue(E newVal)
    {
        value = newVal;
    }
    
    public void setNext(ListNode<E> newNext)
    {
        next = newNext;
    }
    public String toString() {
        return value.toString(); 
    }

}
