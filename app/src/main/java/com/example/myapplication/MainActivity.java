package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendToServer = findViewById(R.id.btnSendToServer);
        Button btnSortMatNumber = findViewById(R.id.btnSortMatNumber);

        final EditText etxtMatNumber = findViewById(R.id.etxtMatNumber);

        final TextView txtvSortedMatNumber = findViewById(R.id.txtvSortedMatNumber);

        btnSortMatNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String matNumber = "";
                List<Integer> unsortedMatNumber = new ArrayList<>();
                List<Integer> matNumberWithoutPrimes = new ArrayList<>();
                Integer[] sortedMatNumber = null;
                matNumber = etxtMatNumber.getText().toString();

                for (int i = 0; i < matNumber.length(); i++) {
                    unsortedMatNumber.add(Character.getNumericValue(matNumber.charAt(i)));
                }

                for (int number:unsortedMatNumber) {
                    int checkNumber = number;
                    if (!isPrime(checkNumber)) {
                        matNumberWithoutPrimes.add(checkNumber);
                    }
                }
                sortedMatNumber = matNumberWithoutPrimes.toArray(new Integer[matNumberWithoutPrimes.size()]);
                Arrays.sort(sortedMatNumber);

                StringBuilder builder = new StringBuilder();
                for (int value : sortedMatNumber) {
                    builder.append(value);
                }

                txtvSortedMatNumber.setText(builder.toString());

            }
        });

        btnSendToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
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
