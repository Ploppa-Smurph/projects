/* example from @author Steven Turner CTEC-243 */
package interfaceExample;

import java.util.ArrayList;

public class InterfaceExample {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // ArrayList<String> stringList = new ArrayList<String>();   // this declaration shows the redundancy in Java, the first part declares the type of variable, the second instantiates / creates the variable

        /*  from ex01: generics --
        * DataHolder<String> d = new DataHolder<String>("Hello World!");
        * DataHolder<Integer> d2 = new DataHolder<Integer>(176);
        * DataHolder<Double> d3 = new DataHolder<>(15.04871);
        * System.out.println(d.getData() + " " + d2.getData() + " " + d3.getData());   // getData is a method we create in the DataHolder class
        */

        /* from ex02: arrayStack --

       StackInterface<Integer> myStack = new WalleyArrayStack<>();

            int i = 0;
            while(!myStack.isFull()) {
                myStack.push(i);
                i++;
            }

            while (!myStack.isEmpty()) {
                System.out.println(myStack.pop());
            }
        }

         */

        /* ex03: LinkedStack -- */
        StackInterface<Integer> myStack = new WalleyLinkedStack<>();

        int i = 0;
        while(i < 50) {
            myStack.push(i);
            i++;
        }

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

    }