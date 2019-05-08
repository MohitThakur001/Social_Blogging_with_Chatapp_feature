package com.mohit.chatappminor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class authandchat extends AppCompatActivity {
    Button btn_log;
    Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authandchat);

        btn_log = findViewById(R.id.chat);
        btn_reg = findViewById(R.id.post);


        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(authandchat.this, Main2Activity.class);
                startActivity(intent);

            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(authandchat.this, feed.class);
                startActivity(intent2);
            }
        });
    }
}
