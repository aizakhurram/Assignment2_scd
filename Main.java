import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;
class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
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
            node.setNext(top);
            top = node;
            size++;
    }
    public T pop() throws EmptyStackException{
        if (isEmpty()){
             throw new EmptyStackException();
        }
        T data = top.getData();
        top = top.getNext();
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
public class Main{
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stack Size: ");
        int stackSize = scanner.nextInt();
        scanner.nextLine(); 

        GenericStack<Integer> intStack = new GenericStack<>();

        System.out.println("Enter Stack Values");
        for (int i = 0; i < stackSize; i++) {
            int item = scanner.nextInt();
            intStack.push(item);
        }

        System.out.println("Perform Stack Operations");
        scanner.nextLine();
        do {
            String operation = scanner.nextLine();
            switch (operation) {
                case "pop":
                    try {
                        System.out.println("Popped: " + intStack.pop());
                    } catch (EmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "size":
                    System.out.println("Stack size: " + intStack.size());
                    break;
                case "isEmpty":
                    if (intStack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case "push":
                 System.out.println("Enter the value you want to push in stack: ");
                 int val=scanner.nextInt();
                 intStack.push(val);
                  System.out.println("value pushed");
                    break;
                case "Quit":
                    System.out.println("Program Exited!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid operation.");
            }
        }while(true);
    }
    }
