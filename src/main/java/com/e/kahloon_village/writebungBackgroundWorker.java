package com.e.kahloon_village;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class writebungBackgroundWorker extends AsyncTask<String,Void,String> {
    String dplace,devenetID,dempID,ddates,demptype;
    String login_url;
    Context context;
    AlertDialog alertDialog;
    String mID;
    String firstName;
    String fname,lname,natio,phone,ID,pos;
    String mclientID,mbungalowID,mcheckIn,mcheckOut,mavailable,mrentingdate;
    ArrayList<String> holder = new ArrayList<>();
    writebungBackgroundWorker(Context ctx){
        context = ctx;
    }



    @Override
    protected String doInBackground(String... voids) {
        mclientID = voids[0];
        mID = voids[1];
        mbungalowID = voids[2];
        mcheckIn = voids[3];
        mcheckOut= voids[4];
        mavailable = voids[5];
        mrentingdate = voids[6];

                        login_url = "http://10.0.2.2/write_bungalow.php";
                        try {

                            URL url = new URL(login_url);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setDoInput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                            String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                    + URLEncoder.encode("clientID", "UTF-8") + "=" + URLEncoder.encode(mclientID, "UTF-8") + "&"
                                    + URLEncoder.encode("bungalowID", "UTF-8") + "=" + URLEncoder.encode(mbungalowID, "UTF-8") + "&"
                                    + URLEncoder.encode("checkIn", "UTF-8") + "=" + URLEncoder.encode(mcheckIn, "UTF-8") + "&"
                                    + URLEncoder.encode("checkOut", "UTF-8") + "=" + URLEncoder.encode(mcheckOut, "UTF-8") + "&"
                                    + URLEncoder.encode("availability", "UTF-8") + "=" + URLEncoder.encode(mavailable, "UTF-8") + "&"
                                    + URLEncoder.encode("rentingDate", "UTF-8") + "=" + URLEncoder.encode(mrentingdate, "UTF-8");

                            bufferedWriter.write(post_data);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();
                            InputStream inputStream = httpURLConnection.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                            String result = "";
                            String line = "";
                            while ((line = bufferedReader.readLine()) != null) {
                                result += line;
                            }
                            bufferedReader.close();
                            inputStream.close();
                            httpURLConnection.disconnect();
                            return result;

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

        return null;
    }



    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(" Reservations");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }




    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

