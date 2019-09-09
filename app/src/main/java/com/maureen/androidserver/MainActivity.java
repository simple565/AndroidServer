package com.maureen.androidserver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

/**
 * @Author Lianml
 * @Create 2019-09-07 11:58
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private NanohttpdServer mNanohttpdServer;
    private AndroidAsyncUtil mAndroidAsyncUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAndroidAsyncUtil = new AndroidAsyncUtil(MainActivity.this, 8080);
        Button asOpenBtn = findViewById(R.id.async_open);
        asOpenBtn.setOnClickListener(this);
        Button asCloseBtn = findViewById(R.id.async_close);
        asCloseBtn.setOnClickListener(this);
        Button nanoOpenBtn = findViewById(R.id.nano_open);
        nanoOpenBtn.setOnClickListener(this);
        Button nanoCloseBtn = findViewById(R.id.async_close);
        nanoCloseBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.async_open:
                mAndroidAsyncUtil.startServer();
                break;
            case R.id.async_close:
                mAndroidAsyncUtil.stopServer();
                break;
            case R.id.nano_open:
                mNanohttpdServer = new NanohttpdServer(MainActivity.this, 8080);
                try {
                    mNanohttpdServer.start();
                    Toast.makeText(MainActivity.this, "服务开启", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nano_close:
                mNanohttpdServer.stop();
                break;
            default:
                break;
        }
    }
}

