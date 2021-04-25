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

public class seebungalowBackgroundWorker extends AsyncTask<String,Void,String> {
    String type;
    String login_url;
    Context context;
    AlertDialog alertDialog;
    String mID;
    String firstName;
    String fname,lname,natio,phone,ID;
    ArrayList<String> holder = new ArrayList<>();
    seebungalowBackgroundWorker(Context ctx){
        context = ctx;
    }



    @Override
    protected String doInBackground(String... voids) {
        mID = voids[0];

                login_url = "http://10.0.2.2/bung_rent.php";
                try {

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8");

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

                try {

                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = null;
                    holder.clear();
                    String clientID="",bID="",checkIn="",checkOut="",availability="",rentingDate="";
                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);

                        clientID = jo.getString("clientID");
                        availability = jo.getString("availability");
                        bID = jo.getString("bungaloID");
                        checkIn = jo.getString("checkIn");
                        checkOut = jo.getString("checkOut");
                        rentingDate = jo.getString("rentingDate");
                    }
                    String message = "clientID# " + clientID + "\n" + "bungaloID: " + bID + "\n" + "Check In: " + checkIn +
                            "\n" + "checkOut: " + checkOut + "\n" + "availability: " + availability + "\n" + "rentingDate: " + rentingDate;
                    alertDialog.setMessage(message);
                    alertDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }




    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

