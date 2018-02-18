package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TakeAway extends AppCompatActivity {
    //Inisialisasi attribute dan variable
    Button Pesan;
    EditText Nama;
    int hour, minute, mYear, mMonth, mDay;
    static final int TIME_DIALOG_ID = 0;
    static final int DATE_DIALOG_ID = 1;
    private EditText txtDate;
    private EditText txtTime;
    private String[] arrMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        txtDate = (EditText) findViewById(R.id.editText6);
        txtTime = (EditText) findViewById(R.id.editText7);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Pesan = (Button) findViewById(R.id.btnPesan);
        Nama = (EditText) findViewById(R.id.editText2);

        //membuat aksi pada tombol Choose the food
        Pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Z = Nama.getText().toString();
                if (Z == null) {
                    Toast toast = Toast.makeText(TakeAway.this, "Lengkapi Identitas Terlebih Dahulu!", Toast.LENGTH_LONG);
                    toast.show();

                } else {
                    Intent intent = new Intent(TakeAway.this, Menu.class);
                    startActivity(intent);
                }
            }
        });

        txtDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });

        txtTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(TIME_DIALOG_ID);
                return true;
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                        this, mTimeSetListener, hour, minute, true);
            case DATE_DIALOG_ID:
                return new DatePickerDialog(
                        this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }
    //agar pada saat txtDate disentuh itu muncul dialog datepicker maka kita harus memasang OnTouchListener agar dapat menangkap event ontouch yang akan memanggil mehod yang menampilkan dialog DatePicker
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0", 2) + ", " + mYear;
            txtDate.setText(sdate);
        }
    };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
            hour = hourOfDay;
            minute = minuteOfHour;
            String stime = LPad("" + hour, "0", 2) + ":" + LPad("" + hour, "0", 2);
            txtTime.setText(stime);
        }
    };
    //method LPad yang gunanya adalah apabila kita memilih  Tanggal 01, jika kita ingin tetap 01 yang tampil di txtDate maka kita harus menggunakan LPad. Kalau kita tidak menggunakan LPad maka yang tampil di txtDate adalah 1
    private static String LPad(String schar, String spad, int len) {
        String sret = schar;
        for (int i = sret.length(); i < len; i++) {
            sret = spad + sret;
        }
        return new String(sret);


    }
}
