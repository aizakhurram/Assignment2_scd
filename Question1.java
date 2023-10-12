import java.util.EmptyStackException;
import java.util.Scanner;
class Node<T> {
    private T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getdata() {
        return data;
    }
}

class GenericStack<T>{
     public Node<T> top;
    private int size;
    public GenericStack(){
       top=null;
       size=0;
    }
   
    public void push(T data){
             Node<T> node= new Node<>(data);
            node.next=top;
            top = node;
            size++;
    }
    public T pop() throws EmptyStackException{
        if (isEmpty()){
             throw new EmptyStackException();
        }
        T data = top.getdata();
        top = top.next;
        size--;
        return data;

    }
    public boolean isEmpty(){
        if(top==null && size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return this.size;
    }
}
public class Question1{
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stack Size: ");
        int size = scanner.nextInt();
        scanner.nextLine(); 

        GenericStack<Integer> stack = new GenericStack<>();

        System.out.println("Enter Stack Values");
        for (int i = 0; i < size; i++) {
            int item = scanner.nextInt();
            stack.push(item);
        }

        System.out.println("Perform Stack Operations");
        scanner.nextLine();
        do {
            String operation = scanner.nextLine();
            switch (operation) {
                case "pop":
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (EmptyStackException e) {
                        System.out.println("Stack is Empty: "+e.getMessage());
                    }
                    break;
                case "size":
                    System.out.println("Stack size: " + stack.size());
                    break;
                case "isEmpty":
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case "push":
                 System.out.println("Enter the value you want to push in stack: ");
                 int val=scanner.nextInt();
                 stack.push(val);
                  System.out.println("value pushed");
                    break;
                case "Quit":
                    System.out.println("Program Exited!");
                    scanner.close();
                    return;
            }
        }while(true);
    }
    }
