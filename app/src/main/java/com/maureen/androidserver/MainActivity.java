package com.maureen.androidserver;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

/**
 * @Author Lianml
 * @Create 2019-09-07 11:58
 */
public class MainActivity extends AppCompatActivity {
    private NanohttpdServer mNanohttpdServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void createNanoHttpdServer(int port, NanohttpdServer nanohttpdServer) {
        nanohttpdServer = new NanohttpdServer(8080);
        try {
            nanohttpdServer.start();
            Toast.makeText(MainActivity.this,"服务开启",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAndroidAsyncServer(){

    }
}
