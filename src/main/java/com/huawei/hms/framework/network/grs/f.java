/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener
 *  com.huawei.hms.framework.network.restclient.hwhttp.Interceptor$Chain
 *  com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain
 *  com.huawei.hms.framework.network.restclient.hwhttp.Request
 *  com.huawei.hms.framework.network.restclient.hwhttp.Response
 *  com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor
 *  com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl
 */
package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsManager;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;

public class f
implements PluginInterceptor {
    private static final String a = "f";

    public Response intercept(Interceptor.Chain chain) {
        Request request = (chain = (RealInterceptorChain)chain).request();
        String string2 = request.getUrl().getUrl();
        boolean bl2 = GrsManager.isGRSSchema(string2);
        if (bl2) {
            String string3 = a;
            Logger.v(string3, "request url is grs schema.");
            RCEventListener rCEventListener = chain.getRCEventListener();
            rCEventListener.convertGrsStart(string2);
            string2 = GrsManager.getInstance().parseGrs(string2);
            request = request.newBuilder();
            Object[] objectArray = new HttpUrl(string2);
            request = request.url((HttpUrl)objectArray).build();
            objectArray = new Object[1];
            String string4 = request.toString();
            objectArray[0] = string4;
            Logger.v(string3, "origin url is grs schema and by intercepted,and now request is:%s", objectArray);
            rCEventListener.convertGrsEnd(string2);
            return chain.proceed(request);
        }
        return chain.proceed(request);
    }

    public String pluginName() {
        return f.class.getSimpleName();
    }
}

