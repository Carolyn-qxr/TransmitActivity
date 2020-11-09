package com.example.transmitactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity implements View.OnClickListener {
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        str = bundle.getString("name");
        Toast.makeText(AnotherActivity.this,"传递成功"+str,Toast.LENGTH_LONG).show();
        Button back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name",str);
        setResult(1,intent);
        finish();
    }
}