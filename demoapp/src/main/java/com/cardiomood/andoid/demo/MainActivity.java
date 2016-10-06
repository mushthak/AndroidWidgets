package com.cardiomood.andoid.demo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;


public class MainActivity extends ActionBarActivity {

    private SpeedometerGauge speedometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedometer = (SpeedometerGauge) findViewById(R.id.speedometer);
        speedometer.setMaxSpeed(50);
        speedometer.setLabelConverter(new SpeedometerGauge.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });
        speedometer.setMaxSpeed(50);
        speedometer.setMajorTickStep(5);
        speedometer.setMinorTicks(4);
        speedometer.setMaxSpeed(50);
        speedometer.setMajorTickStep(5);
        speedometer.setMinorTicks(0);

        speedometer.addColoredRange(0, 10, ContextCompat.getColor(this,R.color.gauge_blue));
        speedometer.addColoredRange(10, 20, ContextCompat.getColor(this,R.color.gauge_lg_green));
        speedometer.addColoredRange(20, 30, ContextCompat.getColor(this,R.color.gauge_dk_green));
        speedometer.addColoredRange(30, 35, ContextCompat.getColor(this,R.color.gauge_lg_orange));
        speedometer.addColoredRange(35, 40, ContextCompat.getColor(this,R.color.gauge_dk_orange));
        speedometer.addColoredRange(40, 50, ContextCompat.getColor(this,R.color.gauge_red));
        speedometer.setSpeed(50, 1000, 300);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
