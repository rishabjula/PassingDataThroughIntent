package com.tripod.passingdatathroughintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = findViewById(R.id.textView);
        Bundle message = getIntent().getExtras();

        if(message!=null)
        {
            String data = message.getString("Hello");
             int intValue = message.getInt("IntValue");

            t1.setText(data+intValue);

        }
    }
}
