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

class Linkedlist
{
    Link head;

    public Linkedlist()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void insertFirst(int data)
    {
        Link nl = new Link(data);
        nl.next = head;
        head = nl;
    }

    public void deleteFirst()
    {
        Link temp = head;
        head = temp.next;
        return;
    }

    public void displayList()
    {
        Link current = head;
        System.out.print("Stack => ");
        while (current != null) 
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

public class LinkStack
{
    private Linkedlist li;

    public LinkStack()
    {
        li = new Linkedlist();
    }

    public void push(int j)
    {
        li.insertFirst(j);
    }

    public void pop()
    {
        li.deleteFirst();
    }

    public void displayStack()
    {
        li.displayList();
    }

    public static void main(String args[])
    {
        LinkStack stack = new LinkStack();
        Scanner scan = new Scanner(System.in);
        boolean quit = false;

        while(!quit)
        {
            System.out.println("\nSelect from options");
            System.out.println("1. Push \n2. Pop \n3. Display stack \n4. Exit");
            System.out.print("Option => ");
            int value = scan.nextInt(); 
            switch(value)
            {
                case 1:
                    System.out.print("Element => ");
                    int key = scan.nextInt();
                    stack.push(key);
                    stack.displayStack();
                    break;

                case 2:
                    stack.pop();
                    stack.displayStack();
                    break;

                case 3:
                    stack.displayStack();
                    break;
                
                case 4:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}