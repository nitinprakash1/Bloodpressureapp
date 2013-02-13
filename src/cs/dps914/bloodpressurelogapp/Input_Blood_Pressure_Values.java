package cs.dps914.bloodpressurelogapp;

import org.joda.time.DateTime;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;

//import android.support.v4.view.ViewPager;
//import android.view.Gravity;
//import android.view.LayoutInflater;
import android.view.Menu;

import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.TextView;

public class Input_Blood_Pressure_Values extends FragmentActivity implements ActionBar.TabListener {

	public final static String EXTRA_MESSAGE = "cs.dps914.bloodpressurelogapp.MESSAGE";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_blood_pressure_values);
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_input_blood_pressure_values, menu);
        return true;
    }

    

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    
    
    public void saveData(View view){

        final EditText editTxt1;
        final EditText editTxt2;
        final EditText editTxt3;
        //Button button1;
        DateTime dt;
    	
        editTxt1   = (EditText)findViewById(R.id.editText1);
        //if(editTxt1.getText().toString().length()==0)
        	//editTxt1.setError("Enter a value!");
        editTxt2   = (EditText)findViewById(R.id.editText2);
        //if(editTxt2.getText().toString().length()==0)
        	//editTxt2.setError("Enter a value!");
        editTxt3   = (EditText)findViewById(R.id.editText3);
        //if(editTxt3.getText().toString().length()==0)
        	//editTxt3.setError("Enter a value!");
        
        /*editTxt1.addTextChangedListener(new TextValidator(editTxt1) {
            @Override
            public void validate(TextView textView, String text) {
            	int min = 80;
            	int max = 200;
               if(Integer.parseInt(text) < min || Integer.parseInt(text) > max){
            	   Toast.makeText(Input_Blood_Pressure_Values.this, "Out of Range", Toast.LENGTH_LONG).show();
                   //Toast.makeText(DisplayMessageActivity.this, ""+log, Toast.LENGTH_LONG).show();
               }
            }
        });
        
        editTxt2.addTextChangedListener(new TextValidator(editTxt2) {
            @Override
            public void validate(TextView textView, String text) {
            	int min = 50;
            	int max = 120;
            	if(Integer.parseInt(text) < min || Integer.parseInt(text) > max){
             	   Toast.makeText(Input_Blood_Pressure_Values.this, "Out of Range", Toast.LENGTH_LONG).show();
               }
            	
            }
        });
        
        editTxt3.addTextChangedListener(new TextValidator(editTxt3) {
            @Override
            public void validate(TextView textView, String text) {
            	int min = 30;
            	int max = 200;
            	if(Integer.parseInt(text) < min || Integer.parseInt(text) > max){
             	   Toast.makeText(Input_Blood_Pressure_Values.this, "Out of Range", Toast.LENGTH_LONG).show();
               }
            }
        });*/
            
        int text1 = Integer.valueOf(editTxt1.getText().toString());
        int text2 = Integer.valueOf(editTxt2.getText().toString());
        int text3 = Integer.valueOf(editTxt3.getText().toString());
        dt = new DateTime();
        Data a = new Data(text1,text2,text3, dt);
        
        DatabaseHandler b = new DatabaseHandler(this);
        b.addData(a);
        
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        
        //String message = "Data Saved!";
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    	
    }
    
    public void viewGraphs(View view){
    	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	
    	startActivity(intent);
    }
    
    public void viewData(View view)
    {
    	Intent intent = new Intent(this, ViewData.class);
    	startActivity(intent);
    }
}
