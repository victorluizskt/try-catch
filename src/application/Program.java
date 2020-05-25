package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Room number: ");
        int number = input.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(input.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());
        //.after já verifica se uma data é posterior a outra.
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out"
                    + "date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(input.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservartion: Reservation dates for update"
                        + " must be future dates.");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: check-out"
                        + "date must be after check-in date.");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
    }

    public static void method1() {
        System.out.println("***METHOD1 START***");
        method2();
        System.out.println("***METHON1 END***");
    }

    public static void method2() {
        System.out.println("***METHOD2 START***");
        Scanner input = new Scanner(System.in);
        try {
            String[] vect = input.nextLine().split(" ");
            int position = input.nextInt();
            System.out.println(vect[position]);
        } catch (InputMismatchException e) {
            System.out.println("Impossível acessar dado.");
            // e.printStackTrace(); mostra o rastreamento de onde os erros estão vindo.
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição não existe.");
        }
        System.out.println("***METHOD2 END***");
    }

    public static void files() throws FileNotFoundException {
        File file = new File("C:\\temp\\in.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } // bloco finally executa mesmo dando ou certo o bloco try/catch.
        finally {
            if (input != null) {
                input.close();
            }
        }
    }
}
