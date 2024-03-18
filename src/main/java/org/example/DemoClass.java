package org.example;

import DSA.List.DoublyLinkedList;
public class DemoClass {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        list.display();
        list.reverse();
        System.out.print("\n");
        list.insertAtPos(0, 1);
        list.display();
        list.reverse();
        System.out.print("\n");
        list.deleteAtPos(1);
        list.display();
        list.reverse();
        System.out.print("\n");
        System.out.println(list.get(0));
        System.out.print("\n");
        list.update(0, 1);
        list.display();
        list.reverse();
        System.out.print("\n");
        list.deleteAtEnd();
        list.display();
        list.reverse();
        System.out.print("\n");
        list.insertAtEnd(5);
        list.display();
        list.reverse();
        System.out.print("\n");
        System.out.println(list.search(5));
        System.out.println(list.search(10));
        System.out.print("\n");
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        for (Integer l : list) {
            System.out.println(l);
        }

        /*int val,pos;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n -------- List Menu -----------\n");
            System.out.println("1.Insert at Beginning\n");
            System.out.println("2.Display the list\n");
            System.out.println("3.Insert at specified position \n");
            System.out.println("4.Delete from specified position\n");
            System.out.println("5.Exit\n");
            System.out.println("\n--------------------------------------\n");
            System.out.println("Enter your choice:\t");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1: System.out.print("Enter the data: ");
                    val = scanner.nextInt();
                    list.add(val);
                    break;
                case 2: list.display();
                    break;
                case 3: System.out.println("Enter the pos(starts at 0): ");
                    pos = scanner.nextInt();
                    if(pos<0){
                        System.out.println("Invalid Position!!...");
                        break;
                    }
                    System.out.print("Enter the data: ");
                    val = scanner.nextInt();
                    list.insertAtPos(val,pos);
                    break;
                case 4: System.out.println("Enter the pos(starts at 0): ");
                    pos = scanner.nextInt();
                    if(pos<0){
                        System.out.println("Invalid Position!!...");
                        break;
                    }
                    list.deleteAtPos(pos);
                    break;
                case 5: System.exit(0);
                default: System.out.println("Invalid Choice!!...");
            }
        }*/
    }
}
