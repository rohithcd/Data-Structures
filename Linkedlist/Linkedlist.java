import java.util.Scanner;

class Link
{
    public int data;
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

public class Linkedlist
{
    private Link head;

    public Linkedlist()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void insertFirst(int d)
    {
        Link nl = new Link(d);
        nl.next = head;
        head = nl;
    }

    public void deleteFirst()
    {
        Link temp = head;
        head = temp.next;
        return;
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

    public Link delete(int key)
    {
        Link current = head;
        Link previous = head;

        while(current.data!=key)
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


    public void displayList()
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

    public static void main(String args[])
    {
        Linkedlist list = new Linkedlist();
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        while(!quit)
        {
            System.out.println("\nSelect from options");
            System.out.println("1. Insert Element First \n2. Search element \n3. Delete First element \n4. Delete element \n5. Display List \n6. Exit");
            System.out.print("Option => ");
            int value = scan.nextInt(); 
            switch(value)
            {
                case 1:
                    System.out.print("Element => ");
                    int key1 = scan.nextInt();
                    list.insertFirst(key1);
                    list.displayList();
                    break;

                case 2:
                    System.out.print("Element => ");
                    int key2 = scan.nextInt();
                    list.search(key2);
                    list.displayList();
                    break;

                case 3:
                    list.deleteFirst();
                    list.displayList();
                    break;

                case 4:
                    System.out.print("Element => ");
                    int key3 = scan.nextInt();
                    list.delete(key3);
                    list.displayList();
                    break;

                case 5:
                    list.displayList();
                    break;

                case 6:
                    quit = true;
                    break;
                    
                default:
                    System.out.println("Invalid Option");
            }
        }

        scan.close();
    } 
}