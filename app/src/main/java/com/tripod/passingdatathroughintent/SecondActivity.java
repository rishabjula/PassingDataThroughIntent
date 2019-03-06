package com.tripod.passingdatathroughintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 TextView t1;
 Button gb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = findViewById(R.id.textView);
        gb = findViewById(R.id.gobackbutton);
        Bundle message = getIntent().getExtras();

        if(message!=null)
        {
            String data = message.getString("Hello");
             int intValue = message.getInt("IntValue");

            t1.setText(data+intValue);

        }

        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReturn = getIntent();
                intentReturn.putExtra("DataReturn"," data from SecondActivity");
                setResult(RESULT_OK,intentReturn);
                finish();
            }
        });
    }
}
