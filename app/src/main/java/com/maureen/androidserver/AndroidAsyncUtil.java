package com.maureen.androidserver;

import android.content.Context;

import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description AndroidAsync工具类
 * @Author Lianml
 * @Create 2019-09-07 12:01
 */
public class AndroidAsyncUtil {
    private AsyncHttpServer asyncHttpServer;
    private int port;
    private Context mContext;

    public AndroidAsyncUtil(Context context, int port) {
        this.port = port;
        this.mContext = context;
    }

    public void startServer() {
        asyncHttpServer = new AsyncHttpServer();
        asyncHttpServer.listen(port);
        asyncHttpServer.get("/deviceinfo.apk", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                //response.send("Hello World!");
                try {
                    InputStream inputStream = mContext.getResources().openRawResource(R.raw.debug);
                    response.sendStream(inputStream, inputStream.available());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void stopServer() {
        asyncHttpServer.stop();
    }

}
