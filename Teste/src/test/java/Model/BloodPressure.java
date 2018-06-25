package Model;

import java.util.Date;

/**
 * Created by Julio on 15.6.2017.
 */
public class BloodPressure {

    private int heartRate;
    private int bloodPressureSystolic;
    private int getBloodPressureDialostic;
    private Date date;
    private int hours;
    private int minutes;

    private BloodPressure(int heartRate,int bloodPressureSystolic,int getBloodPressureDialostic,Date date,
                          int hours, int minutes){
        this.heartRate = heartRate;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.getBloodPressureDialostic = getBloodPressureDialostic;
        this.date = date;
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public int getBloodPressureDialostic() {
        return getBloodPressureDialostic;
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

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setBloodPressureSystolic(int bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public void setGetBloodPressureDialostic(int getBloodPressureDialostic) {
        this.getBloodPressureDialostic = getBloodPressureDialostic;
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

    public String toSring(){
        return "Blood Pressure {Heart rate: "+getHeartRate()+"Blood pressure systolic: "+getBloodPressureSystolic()
                +" Blood Pressure dialostic: "+getBloodPressureDialostic()+" Date: "+getDate()+ "Time: "+getHeartRate()
                +":"+getHours()+"}";
    }
}
