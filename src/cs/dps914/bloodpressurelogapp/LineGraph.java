package cs.dps914.bloodpressurelogapp;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;

public class LineGraph extends Activity{

	public Intent getIntent(Context context){
		
		
		DatabaseHandler db = new DatabaseHandler(context);
		List<Data> data = db.getAllData();       
		List<Integer> syst_array = new ArrayList<Integer>();
		List<Integer> diast_array = new ArrayList<Integer>();
		List<Integer> heart_array = new ArrayList<Integer>();
		List<String> dayList = new ArrayList<String>();
		
		
		
        for (Data cn : data) {
        int i = 1;
        	syst_array.add(cn.getSystolic());
        	diast_array.add(cn.getDiastolic());
        	heart_array.add(cn.getHeartRate());
        	dayList.add("Day "+ i);
        	i++;
    
        }
		
        Integer systarray [] = syst_array.toArray(new Integer[syst_array.size()]);
        Integer diastarray [] = diast_array.toArray(new Integer[diast_array.size()]);
        Integer heartarray [] = heart_array.toArray(new Integer[heart_array.size()]);
        String dayarray [] = dayList.toArray(new String[dayList.size()]);
        
		
		XYSeries series = new XYSeries("Series 1");
		int length = dayarray.length;
		for(int k=0;k<length;k++){
			series.add(k,diastarray[k]);
		}
		
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(Color.RED);
		renderer.setPointStyle(PointStyle.DIAMOND);
		renderer.setLineWidth(7);
		 
		mRenderer.setZoomButtonsVisible(true);
		mRenderer.setPanLimits(new double[] { 0, 50, 0, 120 });
		//mRenderer.setZoomLimits(new double[] { -10, 20, -10, 40 });
		mRenderer.setZoomRate(1.05f);
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.addXTextLabel(1, "Day");
		mRenderer.addYTextLabel(120, "Diastolic");
		
		//mRenderer.setYTitle("Diastolic", 1);
	    //mRenderer.setYAxisAlign(Align.RIGHT, 1);
	    //mRenderer.setYLabelsAlign(Align.LEFT, 1);

		
		
		mRenderer.addSeriesRenderer(renderer);
		
		
		return ChartFactory.getLineChartIntent(context, dataset, mRenderer);

		
	}
}
