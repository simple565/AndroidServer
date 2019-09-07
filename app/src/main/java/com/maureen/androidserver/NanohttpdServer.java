package com.maureen.androidserver;

import fi.iki.elonen.NanoHTTPD;

/**
 * @Description nanohttpd 服务
 * @Author Lianml
 * @Create 2019-09-07 11:58
 */
public class NanohttpdServer extends NanoHTTPD {

    public NanohttpdServer(int port) {
        super ( port );
    }

    @Override
    public Response serve(IHTTPSession session) {
        return super.serve ( session );
    }
}
