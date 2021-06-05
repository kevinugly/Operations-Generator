public class SinglyLinkedList 
{
    static class Node
    {
        Double value;
        Node next;
        Node(Double v)
        {
            value = v;
        }
        
        Node(Double v, Node n)
        {
            next = n;
            value = v;
        }
        
        public Double getValue()
        {
            return value;
        }
        
        public Node getNext()
        {
            return next;
        }
        
        public void setNext(Node n)
        {
            next = n;
        }
    }
    Node head = null;
    Node tail = null;
    private int size = 0;
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public Double first()
    {
        if(isEmpty())
        {
            return null;
        }
        return head.getValue();
    }
    
    public Node getNextVal()
    {
        return head.next;
    }
    
    public Double last()
    {
        if(isEmpty())
        {
            return null;
        }
        return tail.getValue();
    }
    
    public void addLast(Double v) 
    {
        Node newest = new Node(v, null);
        if (isEmpty( ))
        {
            head = newest;
        }
        else
        {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    
    public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.value + " ");
            n = n.next;
        }
    }
}
