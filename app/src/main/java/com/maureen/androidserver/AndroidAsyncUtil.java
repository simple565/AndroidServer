package com.maureen.androidserver;

import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

/**
 * @Description AndroidAsync工具类
 * @Author Lianml
 * @Create 2019-09-07 12:01
 */
public class AndroidAsyncUtil {
    private AsyncHttpServer asyncHttpServer;
    private int port;

    public AndroidAsyncUtil(int port) {
        this.port = port;
    }

    public void startServer(){
        asyncHttpServer = new AsyncHttpServer();
        asyncHttpServer.listen(port);
        asyncHttpServer.get("/", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {

            }
        });
    }

}
