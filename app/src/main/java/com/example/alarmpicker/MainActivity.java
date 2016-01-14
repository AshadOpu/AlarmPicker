package com.example.alarmpicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTime, btnDate;
    TextView tvTime, tvDate;

    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;

    Calendar calendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime = (Button) findViewById(R.id.button);
        btnTime.setOnClickListener(this);
        btnDate = (Button) findViewById(R.id.button2);
        btnDate.setOnClickListener(this);

        tvTime = (TextView) findViewById(R.id.textView);
        tvDate = (TextView) findViewById(R.id.textView2);

    }


    @Override
    public void onClick(View v) {

        calendar = Calendar.getInstance();

        switch (v.getId())
        {
            case R.id.button:{

                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        timeCalendar.set(Calendar.MINUTE, minute);

                        String timestring = DateUtils.formatDateTime(MainActivity.this, timeCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);
                        tvTime.setText(timestring);
                    }
                },calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), DateFormat.is24HourFormat(MainActivity.this));

                timePickerDialog.show();
                break;
            }

            case R.id.button2:{

                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            Calendar dateCalendar = Calendar.getInstance();
                            dateCalendar.set(Calendar.YEAR, year);
                            dateCalendar.set(Calendar.MONTH, monthOfYear);
                            dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                            String dateString = DateUtils.formatDateTime(MainActivity.this, dateCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);
                            tvDate.setText(dateString);

                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
                break;
            }


        }

    }
}









/*  @Override
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
*/