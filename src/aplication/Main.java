package aplication;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("ROOM NUMBER :");
        int roomNumber = scan.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY):");
        Date checkIn = simpleDate.parse(scan.next());
        System.out.print("Check-out date (DD/MM/YYYY):");
        Date checkout = simpleDate.parse(scan.next());

        if (!checkout.after(checkIn)) {
            System.out.println("Error in reservation chek-out must be after check-in date   ");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkout);
            System.out.println("Reservation: "+ reservation);
        }








    }

}