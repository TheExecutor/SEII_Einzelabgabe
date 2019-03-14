package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendToServer = findViewById(R.id.btnSendToServer);
        Button btnSortMatNumber = findViewById(R.id.btnSortMatNumber);

        final EditText etxtMatNumber = findViewById(R.id.etxtMatNumber);

        final TextView txtvSortedMatNumber = findViewById(R.id.txtvSortedMatNumber);
    }
}
