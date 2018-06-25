package Model;

import java.util.Date;

/**
 * Created by Julio on 15.6.2017.
 */
public class BloodSugar {

    private int bloodSugar;
    private Date date;
    private int hours;
    private int minutes;

    private BloodSugar(int bloodSugar,Date date,int hours,int minutes){
        this.bloodSugar = bloodSugar;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getBloodSugar() {
        return bloodSugar;
    }

    public Date getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setBloodSugar(int bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String toString(){
        return "Blood Sugar: "+getBloodSugar()+" Date: "+getDate()+" Time: "+getHours()+":"+getMinutes();
    }
}
