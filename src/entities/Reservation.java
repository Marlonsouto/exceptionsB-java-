package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

   private Integer numberRomm;
   private Date checkIn;
   private Date checkOut;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer numberRomm, Date checkIn, Date checkOut) {
        this.numberRomm = numberRomm;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumberRomm() {
        return numberRomm;
    }

    public void setNumberRomm(Integer numberRomm) {
        this.numberRomm = numberRomm;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkIn.getTime() - checkOut.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public String update(Date checkIn, Date checkOut ){

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now) ){
            return "Error in reservation the checkin or checkout must be futures dates";
        } if (!checkOut.after(checkIn)){
            return "dates checkout must be affter checkin";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString() {
        return "Reservation :" +
                "numberRomm=" + numberRomm +
                ", checkIn=" + sdf.format(checkIn) +
                ", checkOut=" + sdf.format(checkOut) +
                duration()+ "nights"
                ;
    }
}
