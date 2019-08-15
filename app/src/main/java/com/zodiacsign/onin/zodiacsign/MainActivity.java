package com.zodiacsign.onin.zodiacsign;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.hanshake.HorologyController;
import bot.box.horology.pojo.Zodiac;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Adriel MainActivity: ";
    private TextView m_BirthDate, m_ChineseZodiac, m_Zodiac;
    private ImageView m_imgZodiacSign, m_imgChineseZodiac;
    private Button btnZodiac;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int nYear, nMonth, nDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_ChineseZodiac = (TextView)findViewById(R.id.tvChineseZodiac);
        m_BirthDate = (TextView) findViewById(R.id.tvBirthdate);
        m_Zodiac = (TextView)findViewById(R.id.tvZodiac);

        m_imgChineseZodiac  = (ImageView)findViewById(R.id.ImgChineseZodiac);
        m_imgZodiacSign = (ImageView)findViewById(R.id.ImgZodiacSign);
        m_imgZodiacSign.setBackgroundResource(R.drawable.question);
        m_imgChineseZodiac.setBackgroundResource(R.drawable.question);
        Log.w(TAG,"Loading Successful! ...");
        m_BirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dg = new DatePickerDialog(
                        MainActivity.this,
                         android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                         mDateSetListener,
                         year,month,day);

               dg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dg.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                   month = month + 1;
                   nYear = year;
                   nMonth = month;
                   nDay = dayOfMonth;

                   String date =  month + "/" +  dayOfMonth + "/" + year;
                   m_BirthDate.setText(date);
            }
        };
        btnZodiac = (Button)findViewById(R.id.btnShowResult);

        btnZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sBtnText = btnZodiac.getText().toString().toUpperCase();
                String sText = m_BirthDate.getText().toString().toUpperCase();
                if(sBtnText.equals("ZODIAC SIGN") == true  && sText.equals("ENTER YOUR BIRTHDATE") == false ) {
                    ZodiacSign z = new ZodiacSign(MainActivity.this);
                    String sChineseZodiac = z.GetChineseZodiacSign(nYear);
                    String sZodiacSign = z.GetZodiacSign(nMonth, nDay);
                    //m_ChineseZodiac.setText(sChineseZodiac);
                    //m_Zodiac.setText(sZodiacSign);
                    m_BirthDate.setEnabled(false);
                    btnZodiac.setText("RESET");
                   // BackgroundTask backgroundTask = new BackgroundTask(MainActivity.this);
                    ///backgroundTask.execute(sZodiacSign);


                  /*  Horoscope hGemini = new Horoscope.Zodiac(MainActivity.this)
                            .requestSunSign(SUNSIGN.GEMINI)
                            .requestDuration(DURATION.TODAY)
                            .showLoader(true)
                            .isDebuggable(true)
                            .fetchHoroscope();
                    HorologyController cGemini = new HorologyController(new Response() {
                        @Override
                        public void onResponseObtained(Zodiac zodiac) {
                            String horoscope = zodiac.getHoroscope();
                            String sunsign = zodiac.getSunSign();
                            String date = zodiac.getDate();
                            Log.w(TAG,horoscope);
                        }


                        @Override
                        public void onErrorObtained(String error_msg) {
                            Log.w(TAG,error_msg);
                        }
                    });
                    cGemini.requestConstellations(hGemini);*/
                } else if (sBtnText == "RESET") {
                    m_BirthDate.setEnabled(true);
                    m_BirthDate.setText("Enter your Birthdate");
                    m_imgZodiacSign.setBackgroundResource(R.drawable.question);
                    m_imgChineseZodiac.setBackgroundResource(R.drawable.question);
                    btnZodiac.setText("ZODIAC SIGN");
                }



            }
        });
    }
}
