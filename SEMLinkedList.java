public class SEMLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public SEMLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(E e) {
        ListNode<E> newNode = new ListNode<E>(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }

        tail.setNext(newNode);
        tail = newNode;
        size++;
        return true;

    }

    public String toString() {
        if (size == 0) {
            return "Empty List";
        }
        String ret = "[";
        ListNode<E> pointer = head;
        while (pointer.getNext() != null) {
            ret += pointer.toString() + " -> ";
            pointer = pointer.getNext();
        }
        return ret + pointer.toString() + "]";
    }

    public int size() {
        return size;

    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            return;
        }
        ListNode<E> newNode = new ListNode<E>(element);
        ListNode<E> pointer = head;
        int i = 0;
        if(index == 0){
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        while (pointer.getNext() != null) {
            if (i + 1 == index) {
                newNode.setNext(pointer.getNext());
                pointer.setNext(newNode);
                size++;
                return;
            }
            pointer = pointer.getNext();
            i++;
        }
    }

    public void addFirst(E e) {
        ListNode<E> newNode = new ListNode<E>(e);

        newNode.setNext(head);
        head = newNode;
        size++;

    }

    public void addLast(E e) {
        ListNode<E> newNode = new ListNode<E>(e);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        int i = 0;
        ListNode<E> pointer = head;
        while (pointer != null) {
            if (i == index) {
                return pointer.getValue();
            }
            pointer = pointer.getNext();
            i++;
        }
        System.out.println();
        return null;
    }

    public E getFirst() {
        if(head == null){
            return null;
        }
        return head.getValue();
    }

    public E getLast() {
        if(tail == null){
            return null;
        }
        return tail.getValue();
    }

    public int indexOf(Object o) {
        if(head == null){
            return -1;
        }

        ListNode<E> pointer = head;
        int i = 0;
        while (pointer != null) {
            if (pointer.getValue() == o) {
                return i;
            }
            pointer = pointer.getNext();
            i++;
        }
        return -1;
    }

    public E remove() {
       E dummy = head.getValue();
        head = head.getNext();
        size--;
        return dummy;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        E temp;
        int i = 0;
        ListNode<E> pointer = head;
        if(index == 0){
            temp = head.getValue();
            head = head.getNext();
            return temp;
        }
        while (pointer.getNext() != null) {
            if (i + 1 == index) {
                temp = pointer.getNext().getValue();
                pointer.setNext(pointer.getNext().getNext());
                size--;
                return temp;
            }
            pointer = pointer.getNext();
            i++;
        }
        return null;

    }

    public E removeFirst() {
        E dummy = head.getValue();
        head = head.getNext();
        size--;
        return dummy;
    }

    public E removeLast() {
        E temp = tail.getValue();
        tail = null;
        size--;
        ListNode<E> pointer = head;
        while(pointer.getNext().hasNext()){
            pointer = pointer.getNext();
        }
        pointer.setNext(tail);
        return temp;
    }

    public E set(int index, E element) {
        if(index >= size || index < 0){
            return null;
        }

        ListNode<E> newNode = new ListNode<E>(element);
        int i = 0;
        ListNode<E> pointer = head;
        E temp;
        if(index == 0){
            temp = head.getValue();
            head = newNode;
            return temp;
        }

        while(pointer.getNext() != null){
            if(i+1 == index){
                temp = pointer.getNext().getValue();
                newNode.setNext(pointer.getNext().getNext());
                pointer.setNext(newNode);
                return temp;

            }
            pointer = pointer.getNext();
            i++;
        }
        return null;
    }
}
