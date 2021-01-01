import com.company.Color;
import com.sun.source.doctree.ThrowsTree;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Theater {

    private static final String name = "PVR";
    private List<Seat> seat = new LinkedList<>();
    private int seatsPerRow;
    private Comparator<Seat> priceOrder = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {

            if (seat1.getPrice() == seat2.getPrice()) {
                return seat1.seatName.compareTo(seat2.seatName);
            }
            return (int) seat1.getPrice() - (int) seat2.getPrice();
        }
    };




public Theater(int numRow, int seatsPerRow ) {

    this.seatsPerRow =seatsPerRow;
    double price;
    numRow='A'+(numRow-1);


    for (char numRows='A';numRows<=numRow ;numRows++ ){
        for(int seats=1;seats<=seatsPerRow;seats++ ){

            if (numRows < 'C' ){
                if (seats<3 || seats>6) {
                    price= 13;
                }else {
                    price= 15;
                }

            } else if (numRows>'F') {

                if (seats<3 || seats>6) {
                    price= 8;
                }else {
                    price= 9;
                }

            } else {

                if (seats<3 || seats>6) {
                    price= 10;
                }else {
                    price= 12;
                }
            }

            String seatName = numRows + String.format("%02d", seats, price);




            seat.add(new Theater.Seat(seatName, price));
        }
    }

}



    public static String getName() {
        return name;
    }

    public void availableSeat() {

        System.out.print("Seats : ");
        for (Seat seats : this.seat) {

            if (!seats.isReserved) {
                System.out.print(seats + "\t");
            }
        }
        System.out.println();

    }

    public boolean reserveSeat(String seat) {

        int cmv = findSeat(seat);
        System.out.println(cmv);
        if (cmv >= 0) {
            Seat reserveSeat = this.seat.get(cmv);
            reserveSeat.reserve();
            return true;
        } else {
            System.out.println(seat + " Seat does not Exist");
            return false;
        }
    }

    public boolean cancelSeatReservation(String seat) {

        int cmv = findSeat(seat);
        if (cmv >= 0) {
            Seat cancelReservedSeat = this.seat.get(cmv);
            cancelReservedSeat.cancelReservation();
            return true;
        } else {
            System.out.println(seat + " Seat does not Exist");
            return false;
        }
    }

    public int findSeat(String seats) {
        Seat findSeat = new Seat(seats, 0);
        int cmv = Collections.binarySearch(getSeat(), findSeat);
        return cmv;
    }

    public void printListPriceOrder() {

        List<Seat> priceSet = new LinkedList<>(getSeat());
//        priceSet.get(0).reserve();
//        priceSet.add(new Seat("B", 8));
//        priceSet.add(new Seat("A", 8));

        Collections.sort(priceSet, priceOrder);
//        System.out.println(priceSet);
//        Collections.reverse(priceSet);
//        System.out.println(priceSet);
//        Collections.shuffle(priceSet);
//        System.out.println(priceSet);

//
//        System.out.println(seat.size());
//        System.out.println(priceSet.size());
//

        System.out.print("Seats : ");
        for (Seat seats : priceSet) {
//            if (!seats.isReserved) {
            System.out.print(seats + "\t");
//            }
        }
        System.out.println();
    }

    public void printSeatList() {

        System.out.println("Seats : ");

            for (int i = 0; i < seat.size(); i++) {

                Seat seats = seat.get(i);
                String seatName;


                if (seats.isReserved()) {
                    seatName = Color.RED+seats.getSeatName() + " "+"$"+ seats.getPrice();
                } else {
                    seatName = Color.BLUE+seats.getSeatName() + " "+"$"+ seats.getPrice();
                }
                System.out.print(seatName + "\t");

                if (!(i == 0)) {
                    if ((i + 1) % seatsPerRow == 0) {
                        System.out.println();
                    }
                }
            }
        System.out.println(Color.RESET);
    }

    public List<Seat> getSeat() {
        return seat;
    }


    private class Seat implements Comparable<Seat> {
        private String seatName;
        private double price;
        private boolean isReserved = false;


        public Seat(String seatName, double price) {
            this.seatName = seatName;
            this.price = price;
        }

//
//        public Seat(String seatName) {
//         this.seatName=seatName;
//
//        }

        public boolean isReserved() {
            return isReserved;
        }

        public double getPrice() {
            return price;
        }

        public void reserve() {

            if (!isReserved) {
                isReserved = true;
                System.out.println(getSeatName() + " Seat reserved" + "\nPlease Pay : $" + getPrice());

            } else {
                System.out.println(getSeatName() + " Seat already reserved");
            }
        }

        public void cancelReservation() {
            if (isReserved) {
                isReserved = false;
                System.out.println(getSeatName() + " Seat reservation Cancelled.");
            } else {
                System.out.println(getSeatName() + " Seat is not reserved yet.");
            }
        }

        @Override
        public int compareTo(Seat seats) {
            return this.seatName.compareTo(seats.getSeatName());
        }

        public String getSeatName() {
            return seatName;
        }

    }


}
