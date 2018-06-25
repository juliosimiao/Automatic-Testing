package Model;

import java.util.Date;

/**
 * Created by Julio on 15.6.2017.
 */
public class MaxPulse {

    private int maxPulse;
    private Date date;
    private int hours;
    private int minutes;

    private MaxPulse(int maxPulse,Date date,int hours,int minutes){
        this.maxPulse = maxPulse;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getMaxPulse() {
        return maxPulse;
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

    public void setMaxPulse(int maxPulse) {
        this.maxPulse = maxPulse;
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
        return "Max Pulse: "+getMaxPulse()+" Date: "+getDate()+" Time "+getHours()+":"+getMinutes();
    }
}
