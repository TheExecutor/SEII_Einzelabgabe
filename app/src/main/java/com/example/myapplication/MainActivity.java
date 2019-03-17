package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity  {
    public static Button btnSendToServer;
    public static Button btnSortMatNumber;
    public static EditText etxtMatNumber;
    public static TextView txtvSortedMatNumber;
    public static TextView txtvAnswerFromServer;

    MyTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendToServer = findViewById(R.id.btnSendToServer);
        btnSortMatNumber = findViewById(R.id.btnSortMatNumber);

        etxtMatNumber = findViewById(R.id.etxtMatNumber);

        txtvSortedMatNumber = findViewById(R.id.txtvSortedMatNumber);

        txtvAnswerFromServer = findViewById(R.id.txtAnswerFromServer);

        btnSortMatNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matNumber = etxtMatNumber.getText().toString();
                List<Integer> unsortedMatNumber = new ArrayList<>();
                List<Integer> matNumberWithoutPrimes = new ArrayList<>();

                for (int i = 0; i < matNumber.length(); i++) {
                    unsortedMatNumber.add(Character.getNumericValue(matNumber.charAt(i)));
                }

                for (int number:unsortedMatNumber) {
                    int checkNumber = number;
                    if (!isPrime(checkNumber)) {
                        matNumberWithoutPrimes.add(checkNumber);
                    }
                }

                Collections.sort(matNumberWithoutPrimes);
                printSortedMatNumber(matNumberWithoutPrimes);
            }
        });

        btnSendToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matNumber = etxtMatNumber.getText().toString();
                myTask = new MyTask();
                myTask.execute(matNumber);

                try {
                    String answerFromServer = myTask.get();
                    txtvAnswerFromServer.setText(answerFromServer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void printSortedMatNumber(List<Integer> matNumberWithoutPrimes) {
        StringBuilder builder = new StringBuilder();
        for (int value : matNumberWithoutPrimes) {
            builder.append(value);
        }

        txtvSortedMatNumber.setText(builder.toString());
    }

    private boolean isPrime(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
