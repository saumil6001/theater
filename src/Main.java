import com.company.Color;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Theater pvr=new Theater(8,8);
    public static void main(String[] args) {


        System.out.println(Color.RED + "\t\t\t Welcome to " + Theater.getName() +
                            "\n ============================================"+Color.RESET );

        run();
    }




    public static void printInstruction(){

        System.out.println(Color.GREEN+"""

                        Please chose from following.
                        \t1. Print Seat List
                        \t2. Reserve Seat
                        \t3. Cancel Seat Reservation
                        \t4. Print Instruction
                        \t5. Available Seats for Reservation
                        \t6. Print Seat List in Price Order (Low to High) 
                        \t7. Quit\s

                        """+ Color.RESET
                   );

    }






    public static void run () {
        printInstruction();
        boolean quit= false;

        while(!quit){

            int choice;

            try {
                System.out.println("Please Enter Choice :  ");
                choice= scanner.nextInt();

            } catch (InputMismatchException ignored) {
                System.out.println(Color.RED+"Check Entry "+Color.RESET);
                scanner.next();
                printInstruction();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    pvr.printSeatList();
                }

                case 2 -> {
                    System.out.print( "Enter seat number to reserve: ");
                    String seat= scanner.next().toUpperCase();
                    seat+=scanner.nextLine();
                    System.out.println(seat);
                    pvr.reserveSeat(seat);
                }
                case 3 -> {
                    System.out.print("Enter seat number to cancel Reservation : ");
                    String seat = scanner.next().toUpperCase();
                    seat+=scanner.nextLine();
                    System.out.println(seat);
                    pvr.cancelSeatReservation(seat);
                }
                case 4 -> printInstruction();
                case 5 -> pvr.availableSeat();
                case 6 -> pvr.printListPriceOrder();
                case 7 -> quit = true;
                default -> System.out.println(Color.RED+"Enter correct choice."+Color.RESET);
            }
        }
    }
}









// Created Text File Using PrintSeatList Code
// read  test file in Constructor intend of following Constructor code of Theater Constructor


