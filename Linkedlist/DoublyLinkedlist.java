import java.util.Scanner;

class Link 
{
    public int data;
    public Link prev;
    public Link next;

    public Link(int d)
    {
        data = d;
        next = null;
    }

    public void displayLink()
    {
        System.out.print(data + " ");
    }
}

public class DoublyLinkedlist
{
    private Link head;
    private Link tail;

    public DoublyLinkedlist()
    {
        head = null;
        tail = null;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void insertFirst(int data)
    {
        Link nl = new Link(data);
        if(isEmpty())
        {
            head = nl;
            tail = nl;
        }
        else
        {
            nl.next = head;
            head.prev = nl;
            head = nl;
        }
    }

    public void insertAfter(int prev, int data)
    {
        Link nl = new Link(data);
        Link current = head;

        while(current != null)
        {
            if(current.data == prev)
            {
                if (current==tail)
                {
                    tail.next = nl;
                    nl.prev = tail;
                    tail = nl;
                }
                else
                {
                    nl.next = current.next;
                    current.next.prev = nl;
                    nl.prev = current;
                    current.next = nl;
                }
                break;
            }
            else
            {
                current = current.next;
            }
        }
    }

    public void insertLast(int d)
    {
        Link nl = new Link(d);
        if (isEmpty())
        {
            head = nl;
            tail = nl;
        }
        else
        {
            tail.next = nl;
            tail = nl;
        }
    }

    public void deleteFirst()
    {
        Link temp = head;
        head = temp.next;
        return;
    }

    public void deleteLast()
    {
        Link temp = tail;
		if(head == tail) 
        {
			head = null;
		} 
        else 
        {
			tail.prev.next = null;
		}

		tail = tail.prev;
		temp.prev = null;
		return;
    }

    public Link delete(int key)
    {
        Link current = head;
        Link previous = head;

        while(current.data != key)
        {
            if(current.next == null)
                return null;
            else
            {
                previous=current;
                current=current.next;
            }
        }

        if(current == head)
            head = head.next;
        else
            previous.next = current.next;
        return current;
    }

    public void search(int key)
    {
        Link current = head;
        int count = 0;
        while (current != null)
        {
            if(current.data == key)
            {
                System.out.println("Element present at index " +  count);
                return;
            }
            else
            {
                current = current.next;
                count++;
            }
        }
        System.out.println("Element not Found");
        return;
    }

    public void displayForward()
    {
        Link current = head;
        System.out.print("Linked List => ");
        while (current != null) 
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward()
    {
        Link current = tail;
        System.out.print("Linked List => ");
        while (current != null) 
        {
            current.displayLink();
            current = current.prev;
        }
        System.out.println("");
    }

    public static void main(String args[])
    {
        DoublyLinkedlist dlist = new DoublyLinkedlist();
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        while(!quit)
        {
            System.out.println("\nSelect from options");
            System.out.println("1. Insert First \t2. Insert Last \t\t3. Insert After");
            System.out.println("4. Delete First \t5. Delete Last \t\t6. Delete key");
            System.out.println("7. Display Forward \t8. Display Backward \n9. Search \n10. Exit");
            System.out.print("Option => ");
            int value = scan.nextInt(); 

            switch(value)
            {
                case 1:
                    System.out.print("Element => ");
                    int key1 = scan.nextInt();
                    dlist.insertFirst(key1);
                    dlist.displayForward();
                    break;
                
                case 2:
                    System.out.print("Element => ");
                    int key2 = scan.nextInt();
                    dlist.insertLast(key2);
                    dlist.displayForward();
                    break;

                case 3:
                    System.out.print("Append After => ");
                    int prev = scan.nextInt();
                    System.out.print("Element => ");
                    int key3 = scan.nextInt();
                    dlist.insertAfter(prev, key3);
                    dlist.displayForward();
                    break;
                

                case 4:
                    dlist.deleteFirst();
                    dlist.displayForward();
                    break; 
 
                case 5:
                    dlist.deleteLast();
                    dlist.displayForward();
                    break;

                case 6:
                    System.out.print("Element => ");
                    int key6 = scan.nextInt();
                    dlist.delete(key6);
                    dlist.displayForward();
                    break; 

                case 7:
                    dlist.displayForward();
                    break;

                case 8:
                    dlist.displayBackward();
                    break;

                case 9:
                    System.out.print("Element => ");
                    int key9 = scan.nextInt();
                    dlist.search(key9);
                    dlist.displayForward();
                    break;

                case 10:
                    quit = true;
                    break;

                default:
                    System.out.println("Select anything from given options");
            
            }
 
        } 
        scan.close();
    }
}