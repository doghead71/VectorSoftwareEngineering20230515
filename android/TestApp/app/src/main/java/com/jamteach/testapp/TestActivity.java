package com.jamteach.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent data = new Intent();
        String dataText = "I have returned data.....";
        data.setData(Uri.parse(dataText));
        setResult(RESULT_OK, data);
        finish();
    }

}