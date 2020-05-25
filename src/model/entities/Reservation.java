package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author victor
 */
public class Reservation {

    /*
    Atributtes
     */
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /*
    Construct
     */
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /*
    Getters and Setters
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    /*
    Metodos
     */
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // Converte as duas datas para millisegundos;       
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // A classe TimeUnit faz a conversão de millisegundos para dias.
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Error in reservartion: Reservation dates for update"
                    + " must be future dates";
        }
        if (!checkOut.after(checkIn)) {
            return "Error in reservation: check-out"
                    + "date must be after check-in date.";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    /*
    toString
     */
    @Override
    public String toString() {
        return "Room " + this.roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights.";
    }

}
