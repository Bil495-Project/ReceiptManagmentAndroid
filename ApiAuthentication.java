package com.example.proje;


import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class ApiAuthentication {

    private String username;
    private String password;

    public ApiAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
        // This is important. The application may break without this line.
        System.setProperty("jsse.enableSNIExtension", "false");
    }

    public String executeForLogin() {

       return null;

    }

    public String executeForRegister() {


        JSONObject json=new JSONObject();


       return null;}

}