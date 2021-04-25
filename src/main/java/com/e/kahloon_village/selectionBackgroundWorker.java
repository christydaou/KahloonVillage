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

public class selectionBackgroundWorker extends AsyncTask<String,Void,String> {
    String dplace,devenetID,dempID,ddates,demptype;
    String login_url;
    Context context;
    AlertDialog alertDialog;
    String mID;
    String firstName;
    String fname,lname,natio,phone,ID,pos;
    ArrayList<String> holder = new ArrayList<>();
    selectionBackgroundWorker(Context ctx){
        context = ctx;
    }



    @Override
    protected String doInBackground(String... voids) {
        dplace = voids[0];
        mID = voids[1];
        devenetID = voids[2];
        dempID = voids[3];
        ddates = voids[4];
        demptype = voids[5];
        switch (dplace) {
                    case "Restaurant": {
                        switch (demptype) {
                            case "Employee": {
                                login_url = "http://10.0.2.2/select3.php";
                                try {

                                    URL url = new URL(login_url);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                            + URLEncoder.encode("restID", "UTF-8") + "=" + URLEncoder.encode(devenetID, "UTF-8") + "&"
                                            + URLEncoder.encode("employeeID", "UTF-8") + "=" + URLEncoder.encode(dempID, "UTF-8") + "&"
                                            + URLEncoder.encode("restRequestHrs", "UTF-8") + "=" + URLEncoder.encode(ddates, "UTF-8");

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
                            }
                            break;

                            case "Technician": {
                                login_url = "http://10.0.2.2/select4.php";
                                try {

                                    URL url = new URL(login_url);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                            + URLEncoder.encode("restID", "UTF-8") + "=" + URLEncoder.encode(devenetID, "UTF-8") + "&"
                                            + URLEncoder.encode("technicianID", "UTF-8") + "=" + URLEncoder.encode(dempID, "UTF-8") + "&"
                                            + URLEncoder.encode("sustainTime", "UTF-8") + "=" + URLEncoder.encode(ddates, "UTF-8");
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
                            }
                            break;

                            case "Cleaner": {
                                login_url = "http://10.0.2.2/select5.php";
                                try {
                                    URL url = new URL(login_url);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                            + URLEncoder.encode("restID", "UTF-8") + "=" + URLEncoder.encode(devenetID, "UTF-8") + "&"
                                            + URLEncoder.encode("cleanerID", "UTF-8") + "=" + URLEncoder.encode(dempID, "UTF-8") + "&"
                                            + URLEncoder.encode("cleanTime", "UTF-8") + "=" + URLEncoder.encode(ddates, "UTF-8");
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
                            }
                            break;
                        }
                    }
                    break;

                    case "Bungalow": {
                        switch (demptype) {

                            case "Technician": {
                                login_url = "http://10.0.2.2/select1.php";
                                try {

                                    URL url = new URL(login_url);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                            + URLEncoder.encode("bungalowID", "UTF-8") + "=" + URLEncoder.encode(devenetID, "UTF-8") + "&"
                                            + URLEncoder.encode("technicianID", "UTF-8") + "=" + URLEncoder.encode(dempID, "UTF-8") + "&"
                                            + URLEncoder.encode("repairTime", "UTF-8") + "=" + URLEncoder.encode(ddates, "UTF-8");
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
                            }
                            break;

                            case "Cleaner": {
                                login_url = "http://10.0.2.2/select6.php";
                                try {

                                    URL url = new URL(login_url);
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setRequestMethod("POST");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(mID, "UTF-8") + "&"
                                            + URLEncoder.encode("bungalowID", "UTF-8") + "=" + URLEncoder.encode(devenetID, "UTF-8") + "&"
                                            + URLEncoder.encode("cleanerID", "UTF-8") + "=" + URLEncoder.encode(dempID, "UTF-8") + "&"
                                            + URLEncoder.encode("wipeTime", "UTF-8") + "=" + URLEncoder.encode(ddates, "UTF-8");
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
                            }
                            break;
                        }
                    }
                    break;
                }

                return null;
            }



    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(" Your Profile");
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

