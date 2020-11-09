package com.example.transmitactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.start);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent  = new Intent(MainActivity.this,AnotherActivity.class);
        intent.putExtra("name","qxr");
        intent.putExtra("age",20);
        startActivityForResult(intent,1);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==1){
                Bundle bundle = data.getExtras();
                String str = bundle.getString("name");
                Toast.makeText(MainActivity.this,"回传成功"+str,Toast.LENGTH_LONG).show();
            }
        }
    }
}