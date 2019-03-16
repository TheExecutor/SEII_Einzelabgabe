package com.example.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyTask extends AsyncTask<String, Void, String>  {
    @Override
    protected String doInBackground(String... strings) {

        try {
            String userInput;
            String answerFromServer;

            Socket clientSocket =  new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            userInput = strings[0];

            outToServer.writeBytes(userInput + '\n');

            answerFromServer = inFromServer.readLine();

            clientSocket.close();

            return answerFromServer;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
