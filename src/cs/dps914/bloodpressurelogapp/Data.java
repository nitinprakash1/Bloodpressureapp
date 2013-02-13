package cs.dps914.bloodpressurelogapp;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
//import java.util.Calendar;
//import java.util.Date;

public class Data {
 
    //private variables
    int _id;
    int _systolic;
    int _diastolic;
    int _heartrate;
    DateTime _datetime;
 
    // Empty constructor
    public Data(){
 
    }
    // constructor
    public Data(int _id, int _systolic, int _diastolic, int _heartrate, DateTime _datetime){
        this._id = _id;
        this._systolic = _systolic;
        this._diastolic = _diastolic;
        this._heartrate = _heartrate;
        //DateTimeFormatter format = null;
        this._datetime = new DateTime();
    }
 
    // constructor
    public Data(int _systolic, int _diastolic, int _heartrate, DateTime _datetime){
        this._systolic = _systolic;
        this._diastolic = _diastolic;
        this._heartrate = _heartrate;
        //DateTimeFormatter format = null;
        //this._datetime = format.parseDateTime("yyyyMMdd");
        this._datetime = new DateTime();
    }
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting ID
    public void setID(int _id){
        this._id = _id;
    }
 
    // getting systolic value
    public int getSystolic(){
        return this._systolic;
    }
 
    // setting systolic value
    public void setSystolic(int _systolic){
        this._systolic = _systolic;
    }
 
    // getting diastolic value
    public int getDiastolic(){
        return this._diastolic;
    }
 
    // setting diastolic value
    public void setDiastolic(int _diastolic){
        this._diastolic = _diastolic;
    }
    
    // getting heart rate value
    public int getHeartRate(){
        return this._heartrate;
    }
 
    // setting heart rate value
    public void setHeartRate(int _heartrate){
        this._heartrate = _heartrate;
    }
    
    // getting date value
    public String getDateStored(){
    	
    	//String dateString = String.valueOf(this._datetime);
    	//DateTimeFormatter dateStringFormat = DateTimeFormat.forPattern("yyyyMMdd HHmm");
    	//this._datetime = dateStringFormat.parseDateTime(dateString);
    	return String.valueOf(this._datetime);
        
    }
 
    // setting date value
    public void setDateStored(DateTime _datetime){
        this._datetime = _datetime;
    }
}