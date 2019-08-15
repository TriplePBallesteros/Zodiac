package com.zodiacsign.onin.zodiacsign;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.widget.ImageView;

public class ZodiacSign {

    Context mContext;
    ZodiacSign(Context context) {
        mContext = context;
    }
    String GetZodiacSign(int nMonth,int nDay) {
        String sResult = "";
        if(mContext == null)
            return "";

        ImageView imgView = (ImageView)((Activity)mContext).findViewById(R.id.ImgZodiacSign);
        Resources res = mContext.getResources();
        String[] strZodiac = res.getStringArray(R.array.strZodiacSign);
        switch(nMonth) {
            case 1: //January
                if(nDay <=19) {
                    String[] strCapri = strZodiac[0].split(",");
                    imgView.setBackgroundResource(R.drawable.capri);
                } else {
                    String[] strAqua = strZodiac[1].split(",");
                    imgView.setBackgroundResource(R.drawable.aqua);
                }
                break;
            case 2: //February
                if(nDay <=18) {
                    String[] strAqua = strZodiac[1].split(",");
                    imgView.setBackgroundResource(R.drawable.aqua);
                } else {
                    String[] strPisces = strZodiac[2].split(",");
                    imgView.setBackgroundResource(R.drawable.pisces);
                }
                break;
            case 3: //March
                if(nDay <=20) {
                    String[] strPisces = strZodiac[2].split(",");
                    imgView.setBackgroundResource(R.drawable.pisces);
                } else {
                    String[] strAries = strZodiac[3].split(",");
                    imgView.setBackgroundResource(R.drawable.aries);
                }
                break;
            case 4: //April
                if(nDay <=19) {
                    String[] strAries = strZodiac[3].split(",");
                    imgView.setBackgroundResource(R.drawable.aries);
                } else {
                    String[] strTaurus = strZodiac[4].split(",");
                    imgView.setBackgroundResource(R.drawable.taurus);
                }
                break;
            case 5: //May
                if(nDay <=20) {
                    String[] strTaurus = strZodiac[4].split(",");
                    imgView.setBackgroundResource(R.drawable.taurus);
                } else {
                    String[] strGemini = strZodiac[5].split(",");
                    imgView.setBackgroundResource(R.drawable.gemini);
                }
                break;
            case 6: //June
                if(nDay <=20) {
                    String[] strGemini = strZodiac[5].split(",");
                    imgView.setBackgroundResource(R.drawable.gemini);
                } else {
                    String[] strCancer = strZodiac[6].split(",");
                    imgView.setBackgroundResource(R.drawable.cancer);
                }
                break;
            case 7: //July
                if(nDay <=22) {
                    String[] strCancer = strZodiac[6].split(",");
                    imgView.setBackgroundResource(R.drawable.cancer);
                } else {
                    String[] strLeo = strZodiac[7].split(",");
                    imgView.setBackgroundResource(R.drawable.leo);
                }
                break;
            case 8: //August
                if(nDay <=22) {
                    String[] strLeo = strZodiac[7].split(",");
                    imgView.setBackgroundResource(R.drawable.leo);
                } else {
                    String[] strVirgo = strZodiac[8].split(",");
                    imgView.setBackgroundResource(R.drawable.virgo);
                }
                break;
            case 9: //September
                if(nDay <=22) {
                    String[] strVirgo = strZodiac[8].split(",");
                    imgView.setBackgroundResource(R.drawable.virgo);
                } else {
                    String[] strLibra = strZodiac[9].split(",");
                    imgView.setBackgroundResource(R.drawable.libra);
                }
                break;
            case 10: //October
                if(nDay <=22) {
                    String[] strLibra = strZodiac[9].split(",");
                    imgView.setBackgroundResource(R.drawable.libra);
                } else {
                    String[] strScorpio = strZodiac[10].split(",");
                    imgView.setBackgroundResource(R.drawable.scorpio);
                }
                break;
            case 11: //November
                if(nDay <=20) {
                    String[] strScorpio = strZodiac[10].split(",");
                    imgView.setBackgroundResource(R.drawable.scorpio);
                } else {
                    String[] strSag = strZodiac[11].split(",");
                    imgView.setBackgroundResource(R.drawable.sag);
                }
                break;
            case 12: //December
                if(nDay <=22) {
                    String[] strSag = strZodiac[11].split(",");
                    imgView.setBackgroundResource(R.drawable.sag);
                } else {
                    String[] strCapri = strZodiac[0].split(",");
                    imgView.setBackgroundResource(R.drawable.capri);
                }
                break;
        }


        return  sResult;
    }
    String GetChineseZodiacSign(int nYear) {
        String sResult ="";
        int nResult = 0;
        if(mContext == null)
            return sResult;
        Resources res = mContext.getResources();
        String[] strYearAnimals =  res.getStringArray(R.array.strYearAnimal);
        nResult =(nYear - 4) % 12;
        sResult = strYearAnimals[nResult];
        Resources rs = mContext.getResources();
        ImageView imgView = (ImageView)((Activity)mContext).findViewById(R.id.ImgChineseZodiac);
        switch(nResult) {
            case 0:
                imgView.setBackgroundResource(R.drawable.rat);
                break;
            case 1:
                imgView.setBackgroundResource(R.drawable.ox);
                break;
            case 2:
                imgView.setBackgroundResource(R.drawable.tiger);
                break;
            case 3:
                imgView.setBackgroundResource(R.drawable.rabbit);
                break;
            case 4:
                imgView.setBackgroundResource(R.drawable.dragon);
                break;
            case 5:
                imgView.setBackgroundResource(R.drawable.snake);
                break;
            case 6:
                imgView.setBackgroundResource(R.drawable.horse);
                break;
            case 7:
                imgView.setBackgroundResource(R.drawable.goat);
                break;
            case 8:
                imgView.setBackgroundResource(R.drawable.monkey);
                break;
            case 9:
                imgView.setBackgroundResource(R.drawable.rooster);
                break;
            case 10:
                imgView.setBackgroundResource(R.drawable.dog);
                break;
            case 11:
                imgView.setBackgroundResource(R.drawable.pig);
                break;
        }
        return sResult;
    }


}


