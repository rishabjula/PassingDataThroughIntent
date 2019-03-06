package com.tripod.passingdatathroughintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    private final int RESULT_CODE = 2;
    TextView returnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        returnData = findViewById(R.id.dataReturnTextview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                intent.putExtra("Hello","Hello I am the message from the first activity");
                intent.putExtra("IntValue",123456);

               // startActivity(intent);

                // startActivityForResult is used when we are expecting a result for this activity from another.

                startActivityForResult(intent,RESULT_CODE);
            }
        });

    }

    //this is called when this activity is called by pressing back button from secondActivity.
    //and this method is expecting some result.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== RESULT_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                String result = data.getStringExtra("DataReturn");
                returnData.setText(result);
            }

        }
    }
}
