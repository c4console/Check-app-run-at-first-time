package com.c4console.testfirsttimerun;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv_firsttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Check for app install in first time or Not, like implement Splash screen
        Boolean isFirstTimeRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE)
                .getBoolean("isFirstTimeRun",true);

        if(isFirstTimeRun){
            // App run 1st time
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstTimeRun",false).commit();
            tv_firsttime = (TextView)findViewById(R.id.tv_firsttime);
            tv_firsttime.setText("1st impression is the last Impression");
            //Toast.makeText(MainActivity.this,"First time run",Toast.LENGTH_LONG).show();
        }else{
            // When app run 2nd time
        }

    }
}
