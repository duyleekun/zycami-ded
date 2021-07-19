/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import com.zhiyun.net.NetConfiguration;
import g.u;
import g.z;
import g.z$a;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import k.h$a;
import k.s;
import k.s$b;
import k.y.a.a;

public class RetrofitService {
    private static final RetrofitService sService;
    private s retrofit;

    static {
        RetrofitService retrofitService;
        sService = retrofitService = new RetrofitService();
    }

    private RetrofitService() {
        Object object = NetConfiguration.create();
        this.retrofit = object = this.initRetrofit((NetConfiguration)object);
    }

    public static Object create(Class clazz) {
        return RetrofitService.sService.retrofit.g(clazz);
    }

    private s initRetrofit(NetConfiguration object) {
        boolean bl2;
        Object object2 = new z$a();
        long l10 = ((NetConfiguration)object).getTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object2 = ((z$a)object2).k(l10, timeUnit);
        l10 = ((NetConfiguration)object).getTimeout();
        object2 = ((z$a)object2).j0(l10, timeUnit);
        l10 = ((NetConfiguration)object).getTimeout();
        object2 = ((z$a)object2).R0(l10, timeUnit);
        Object object3 = ((NetConfiguration)object).getRequestInterceptor();
        object2 = ((z$a)object2).c((u)object3);
        object3 = ((NetConfiguration)object).getChangeTimeoutInterceptor();
        object2 = ((z$a)object2).c((u)object3);
        object3 = Proxy.NO_PROXY;
        object2 = ((z$a)object2).g0((Proxy)object3);
        object3 = ((NetConfiguration)object).getHostInterceptor();
        if (object3 != null) {
            object3 = ((NetConfiguration)object).getHostInterceptor();
            ((z$a)object2).c((u)object3);
        }
        if (bl2 = ((NetConfiguration)(object3 = NetConfiguration.create())).isLogEnable()) {
            object3 = ((NetConfiguration)object).getLogInterceptor();
            ((z$a)object2).c((u)object3);
        }
        object2 = ((z$a)object2).f();
        object3 = new s$b();
        object2 = ((s$b)object3).j((z)object2);
        object = ((NetConfiguration)object).getHost();
        object = ((s$b)object2).c((String)object);
        object2 = a.a();
        return ((s$b)object).b((h$a)object2).f();
    }
}

