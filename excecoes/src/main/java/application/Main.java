package application;


import entites.Rersevation;
import model.exception.domainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner l=new Scanner(System.in);
        SimpleDateFormat spd= new SimpleDateFormat("dd/MM/yyyy");
        try {


            System.out.println("Room number");
            int num = l.nextInt();
            System.out.println("Check-in date dd/MM/yyyy");
            Date checkin = spd.parse(l.next());
            System.out.println("Check-out date dd/MM/yyyy");
            Date checkout = spd.parse(l.next());

            Rersevation r = new Rersevation(num, checkin, checkout);
            System.out.println(r);

            System.out.println();
            System.out.println("Enter  data to update the reservation");
            System.out.println("Check-in date dd/MM/yyyy");
            checkin = spd.parse(l.next());
            System.out.println("Check-out date dd/MM/yyyy");
            checkout = spd.parse(l.next());
            r.updateDates(checkin,checkout);
            System.out.println(r);
        }
        catch (ParseException e){
            System.out.println("invalid date format");
        }
        catch (domainException e ){
            System.out.println("error in reservation "+ e.getMessage() );

        }
        // qualquer outra xcepção inesperada mostrar a msg
        catch (RuntimeException e ){
            System.out.println("unexpected  erro" );

        }
        }
        }



