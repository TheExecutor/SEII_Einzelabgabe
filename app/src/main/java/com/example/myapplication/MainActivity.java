package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

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
                int[] sortedMatNumber = new int[8];
                matNumber = etxtMatNumber.getText().toString();

                for(int i = 0; i < sortedMatNumber.length; i++){
                    sortedMatNumber[i] = Character.getNumericValue(matNumber.charAt(i));
                }

                for(int i = 0; i < sortedMatNumber.length - 1; i++){
                    Arrays.sort(sortedMatNumber);
                }

                StringBuilder builder = new StringBuilder();
                for (int value : sortedMatNumber) {
                    builder.append(value);
                }

                txtvSortedMatNumber.setText(builder.toString());
            }
        });
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
