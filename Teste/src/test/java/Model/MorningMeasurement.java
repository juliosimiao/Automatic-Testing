package Model;

import java.util.Date;

/**
 * Created by Julio on 15.6.2017.
 */
public class MorningMeasurement {

    private int weight;
    private int bodyFatPercentage;
    private int restingHeartRateLyingDown;
    private int restingHeartRateStanding;
    private int bloodPressureSystolic;
    private int bloodPressureDiastolic;
    private Date date;
    private int hours;
    private int minutes;

    private MorningMeasurement(int weight,int bodyFatPercentage,int restingHeartRateLyingDown,int restingHeartRateStanding,
                               int bloodPressureSystolic,int bloodPressureDiastolic,Date date, int hours,int minutes){
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
        this.restingHeartRateLyingDown = restingHeartRateLyingDown;
        this.restingHeartRateStanding = restingHeartRateStanding;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.bloodPressureDiastolic = bloodPressureDiastolic;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getWeight() {
        return weight;
    }

    public int getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public int getRestingHeartRateLyingDown() {
        return restingHeartRateLyingDown;
    }

    public int getRestingHeartRateStanding() {
        return restingHeartRateStanding;
    }

    public int getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public int getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
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

    public void setBodyFatPercentage(int bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public void setRestingHeartRateLyingDown(int restingHeartRateLyingDown) {
        this.restingHeartRateLyingDown = restingHeartRateLyingDown;
    }

    public void setRestingHeartRateStanding(int restingHeartRateStanding) {
        this.restingHeartRateStanding = restingHeartRateStanding;
    }

    public void setBloodPressureSystolic(int bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public void setBloodPressureDiastolic(int bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
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
        return "Weight: "+getWeight()+"Body Fat Percentage: "+getBodyFatPercentage()+" Resting Heart Rate Lying Down: "
                +getRestingHeartRateLyingDown()+" Resting Heart Rate Standing: "+getRestingHeartRateStanding()
                +" Blood Pressure Systolic: "+getBloodPressureSystolic()+ " Blood Pressure Diastolic: "
                +getBloodPressureDiastolic()+" Date: "+getDate()+" Time "+getHours()+":"+getMinutes();
    }
}
