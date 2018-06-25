package Model;

import java.util.Date;

/**
 * Created by Julio on 15.6.2017.
 */
public class Weight {

    private int weight;
    private int waistSize;
    private int bodyFatPercentage;
    private Date date;
    private int hours;
    private int minutes;

    public Weight(int weight,int waistSize,int bodyFatPercentage,Date date, int hours,int minutes){
        this.weight = weight;
        this.waistSize = waistSize;
        this.bodyFatPercentage = bodyFatPercentage;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }


    public int getWeight() {
        return weight;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public int getBodyFatPercentage() {
        return bodyFatPercentage;
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public void setBodyFatPercentage(int bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
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
        return "Weight: "+getWeight()+ " Waist Size: " +getWaistSize() + " Body Fat Percentage "+getBodyFatPercentage()
                +" Date: "+getDate()+" Time: "+getHours()+":"+getMinutes();
    }
}
