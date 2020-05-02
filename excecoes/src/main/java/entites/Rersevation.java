package entites;

import model.exception.domainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rersevation {

    /*
    The number of room
     */
    private  Integer roomNumber;
    /**
     * date of  checkin reservation
     */
    private Date checkin;
    /**
     * date of checkout
     */
    private Date checkout;
    private  static  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    public Rersevation(Integer roomNumber, Date checkin, Date checkout)  throws domainException {
        if (!checkout.after(checkin)) {
            throw  new  domainException("Erro of reservation checkout date must be after checkIn");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    /**
     *
     * @return
     */
    public Date getCheckout() {
        return checkout;
    }

    /**
     * during in day od checkout and checkIn
     * @return days
     */
    public long duration(){
        // calcular a diferenca em mile segundos
        long diff=checkout.getTime()-checkin.getTime();
        //  converte mil segundos para dias
       return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public void   updateDates(Date checkin,Date checkout)throws domainException{
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            throw  new domainException("Error in reservation: Reservation dates for update must be future dates");

        }
        if (!checkout.after(checkin)) {
            throw  new  domainException("Erro of reservation checkout date must be after checkIn");
        }
            this.checkin = checkin;
            this.checkout = checkout;


    }

    @Override
    public java.lang.String toString() {
        return "Rersevation{" +
                "roomNumber=" + roomNumber +
                ", checkin=" + sdf.format(checkin) +
                ", checkout=" +sdf.format(checkout)+
                " "+duration()+" nigth "+
                '}';
    }
}
