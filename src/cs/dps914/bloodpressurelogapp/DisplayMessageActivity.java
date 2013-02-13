package cs.dps914.bloodpressurelogapp;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class DisplayMessageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        
     // Get the message from the intent
        Intent intent = getIntent();
        //String message = intent.getStringExtra(Input_Blood_Pressure_Values.EXTRA_MESSAGE);
        
     // Create the text view
        //TextView textView = new TextView(this);
        //textView.setTextSize(10);
        //textView.setText(message);
        //textView.setHeight(5);
        //textView.setWidth(5);

        // Set the text view as the activity layout
        //setContentView(textView);
        
        //DatabaseHandler db = new DatabaseHandler(this);

        // Reading all data
        //Log.d("Reading: ", "Reading all data..");
        //List<Data> data = db.getAllData();       

        //for (Data cn : data) {
          //  String log = "Id: "+cn.getID()
            //		+" ,Systolic: " + cn.getSystolic() 
            	//	+ " ,Diastolic: " + cn.getDiastolic()
            		//+" ,HeartRate: " + cn.getHeartRate()
            	//	+" ,Date Stored: " + cn.getDateStored();
                // Writing data to log            
        //Log.d("Data: ", log);
        //Toast.makeText(DisplayMessageActivity.this, ""+log, Toast.LENGTH_LONG).show();
        }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_message, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ScatterGraphHandler (View view){
    	ScatterGraph scatter = new ScatterGraph();
    	Intent scatterIntent = scatter.getIntent(this);
    	startActivity(scatterIntent);
    }
    
    public void LineGraphHandler (View view){
    	LineGraph line = new LineGraph();
    	Intent lineIntent = line.getIntent(this);
    	startActivity(lineIntent);
    }
    
    public void BarGraphHandler (View view){
    	BarGraph bars = new BarGraph();
    	Intent barIntent = bars.getIntent(this);
    	startActivity(barIntent);
    }
}
