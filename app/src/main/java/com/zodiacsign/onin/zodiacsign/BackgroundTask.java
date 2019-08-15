package com.zodiacsign.onin.zodiacsign;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import bot.box.horology.annotation.DURATION;
import bot.box.horology.annotation.SUNSIGN;
import bot.box.horology.api.Horoscope;
import bot.box.horology.delegate.Response;
import bot.box.horology.hanshake.HorologyController;
import bot.box.horology.pojo.Zodiac;

public class BackgroundTask extends AsyncTask<String,Void,String>
{
    Context ctx;
    private static final String TAG = "Adriel MainActivity: ";
    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        Horoscope hGemini = new Horoscope.Zodiac(ctx)
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
        cGemini.requestConstellations(hGemini);


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
