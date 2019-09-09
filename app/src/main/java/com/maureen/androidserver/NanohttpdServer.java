package com.maureen.androidserver;

import android.content.Context;

import java.io.InputStream;

import fi.iki.elonen.NanoHTTPD;

/**
 * @Description nanohttpd 服务
 * @Author Lianml
 * @Create 2019-09-07 11:58
 */
public class NanohttpdServer extends NanoHTTPD {
    private Context mContext;

    public NanohttpdServer(Context context, int port) {
        super(port);
        this.mContext = context;
    }

    @Override
    public Response serve(IHTTPSession session) {
        if ("/download".equals(session.getUri())) {
            InputStream inputStream = mContext.getResources().openRawResource(R.raw.debug);
            Response response = newChunkedResponse(Response.Status.OK, "application/octet-stream", inputStream);
            response.addHeader("Accept-Ranges", "application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment; filename=" + "DeviceInfo.apk");
            return response;
        } else {
            return newFixedLengthResponse("Hello World!");
        }
    }
}
