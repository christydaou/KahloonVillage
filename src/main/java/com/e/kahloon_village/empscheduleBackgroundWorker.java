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

public class empscheduleBackgroundWorker extends AsyncTask<String,Void,String> {
    String type;
    String login_url;
    Context context;
    AlertDialog alertDialog;
    String mID;


    ArrayList<String> holder = new ArrayList<>();
    empscheduleBackgroundWorker(Context ctx){
        context = ctx;
    }



    @Override
    protected String doInBackground(String... voids) {
        type = voids[0];
        mID = voids[1];

        switch(type){
            case "Employee":{
                login_url = "http://10.0.2.2/schedule2.php";
                try {
                    String emp_ID = voids[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("employeeID", "UTF-8") + "=" + URLEncoder.encode(emp_ID, "UTF-8");

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
                }}
            break;

            case "Technician":{
                login_url = "http://10.0.2.2/schedule1.php";
                try {
                    String tech_ID = voids[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("technicianID", "UTF-8") + "=" + URLEncoder.encode(tech_ID, "UTF-8");

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
                }}
            break;

            case "Cleaner":{
                login_url = "http://10.0.2.2/schedule.php";
                try {
                    String cln_ID = voids[1];

                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("cleanerID", "UTF-8") + "=" + URLEncoder.encode(cln_ID, "UTF-8");

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
                }}
            break;
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(" Your Schedule");
    }

    @Override
    protected void onPostExecute(String result) {
        switch (type) {
            case "Employee":
                try {

                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = null;
                    holder.clear();
                    String restID = "",restdate = "";
                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);

                        restID = jo.getString("restID");
                        restdate = jo.getString("sustainTime");
                    }
                    String message = "RestaurantID: " + restID +
                            "\n" + "Restaurant Sustain Time: " + restdate;
                    alertDialog.setMessage(message);
                    alertDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "Technician":
                try {

                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = null;
                    holder.clear();
                    String bungID = "",bungdate ="",restID = "",restdate = "";
                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);

                        bungID = jo.getString("bungalowID");
                        bungdate = jo.getString("repairTime");
                        restID = jo.getString("restID");
                        restdate = jo.getString("sustainTime");
                    }
                    String message = "BungalowID# " + bungID + "\n" + "Bungalow Repair Time: " + bungdate + "\n" + "RestaurantID: " + restID +
                            "\n" + "Restaurant Sustain Time: " + restdate;
                    alertDialog.setMessage(message);
                    alertDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "Cleaner":
                try {

                    JSONArray ja = new JSONArray(result);
                    JSONObject jo = null;
                    holder.clear();
                    String bungID = "",bungdate ="",restID = "",restdate = "";
                    for (int i = 0; i < ja.length(); i++) {
                        jo = ja.getJSONObject(i);

                        bungID = jo.getString("bungalowID");
                        bungdate = jo.getString("wipeTime");
                        restID = jo.getString("restID");
                        restdate = jo.getString("cleanTime");

                    }
                    String message = "BungalowID# " + bungID + "\n" + "Bungalow Wipe Time: " + bungdate + "\n" + "RestaurantID: " + restID +
                            "\n" + "Restaurant Clean Time: " + restdate;
                    alertDialog.setMessage(message);
                    alertDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }




    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

