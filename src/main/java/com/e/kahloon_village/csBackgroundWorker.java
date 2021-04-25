package com.e.kahloon_village;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

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

import androidx.core.content.ContextCompat;

public class csBackgroundWorker extends AsyncTask<String,Void,String> {
    String type;
    String login_url;
    Context context;
    AlertDialog alertDialog;
    String mID;
    String firstName;
    csBackgroundWorker(Context ctx){
            context = ctx;
    }



    @Override
    protected String doInBackground(String... voids) {
        type = voids[0];
        mID = voids[1];
        firstName = voids[2];
    switch(type){

        case "Front_Officer":{
            login_url = "http://10.0.2.2/login1.php";
            try {
                String front_ID = voids[1];
                String front_first_name = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("frontID", "UTF-8") + "=" + URLEncoder.encode(front_ID, "UTF-8") + "&"
                        + URLEncoder.encode("frontFirstName", "UTF-8") + "=" + URLEncoder.encode(front_first_name, "UTF-8");
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

        case "Employee":{
            login_url = "http://10.0.2.2/login3.php";
            try {
                String emp_ID = voids[1];
                String emp_first_name = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("employeeID", "UTF-8") + "=" + URLEncoder.encode(emp_ID, "UTF-8") + "&"
                        + URLEncoder.encode("employeeFirstName", "UTF-8") + "=" + URLEncoder.encode(emp_first_name, "UTF-8");
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
            login_url = "http://10.0.2.2/login4.php";
            try {
                String tech_ID = voids[1];
                String tech_first_name = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("technicianID", "UTF-8") + "=" + URLEncoder.encode(tech_ID, "UTF-8") + "&"
                        + URLEncoder.encode("technicianFirstName", "UTF-8") + "=" + URLEncoder.encode(tech_first_name, "UTF-8");
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
            login_url = "http://10.0.2.2/login5.php";
            try {
                String cln_ID = voids[1];
                String cln_first_name = voids[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("cleanerID", "UTF-8") + "=" + URLEncoder.encode(cln_ID, "UTF-8") + "&"
                        + URLEncoder.encode("cleanerFirstName", "UTF-8") + "=" + URLEncoder.encode(cln_first_name, "UTF-8");
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
        alertDialog.setTitle(" Login Status");
    }

    @Override
    protected void onPostExecute(String result) {

        if (result.equals("login success")) {
            Bundle b3 = new Bundle();
            switch (type) {

                case "Front_Officer":
                    Toast toast1 = Toast.makeText(context, " Front Officer logged in Successfully", Toast.LENGTH_SHORT);
                    Intent intent1 = new Intent(context, frtTask.class);
                    Bundle b1 = new Bundle();
                    b1.putString("type", type);
                    b1.putString("ID",mID);
                    b1.putString("FirstName",firstName);
                    intent1.putExtras(b1);
                    context.startActivity(intent1);
                    break;

                case "Employee":
                    Toast toast3 = Toast.makeText(context, " Employee logged in Successfully", Toast.LENGTH_SHORT);
                    Intent intent3 = new Intent(context, empTask.class);

                    b3.putString("type", type);
                    b3.putString("ID",mID);
                    b3.putString("FirstName",firstName);
                    intent3.putExtras(b3);
                    context.startActivity(intent3);
                    break;
                case "Technician":
                    Toast toast4 = Toast.makeText(context, " Technician logged in Successfully", Toast.LENGTH_SHORT);
                    Intent intent4 = new Intent(context, empTask.class);

                    b3.putString("type", type);
                    b3.putString("ID",mID);
                    b3.putString("FirstName",firstName);
                    intent4.putExtras(b3);
                    context.startActivity(intent4);
                    break;
                case "Cleaner":
                    Toast toast5 = Toast.makeText(context, " Cleaner logged in Successfully", Toast.LENGTH_SHORT);
                    Intent intent5 = new Intent(context, empTask.class);

                    b3.putString("type", type);
                    b3.putString("ID",mID);
                    b3.putString("FirstName",firstName);
                    intent5.putExtras(b3);
                    context.startActivity(intent5);
                    break;
            }}
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
