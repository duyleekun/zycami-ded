/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.PushClient$1;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.service.PushService;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.Map;

public class PushClient {
    private boolean asynchronized = false;
    private AppConfiguration$SchedulerCreator defaultCreator = null;
    private PushService service = null;

    public PushClient(PushService object, boolean bl2, AppConfiguration$SchedulerCreator appConfiguration$SchedulerCreator) {
        boolean bl3;
        this.service = object;
        this.asynchronized = bl3 = AppConfiguration.isAsynchronized();
        this.defaultCreator = object = AppConfiguration.getDefaultScheduler();
        PaasClient.getGlobalOkHttpClient();
    }

    private z wrapObservable(z z10) {
        Object object;
        if (z10 == null) {
            return null;
        }
        boolean bl2 = this.asynchronized;
        if (bl2) {
            object = b.d();
            z10 = z10.L5((h0)object);
        }
        if ((object = this.defaultCreator) != null) {
            object = object.create();
            z10 = z10.i4((h0)object);
        }
        object = new PushClient$1(this);
        return z10.n4((o)object);
    }

    public z sendPushRequest(Map object) {
        PushService pushService = this.service;
        object = JSONObject$Builder.create((Map)object);
        object = pushService.sendPushRequest((JSONObject)object);
        return this.wrapObservable((z)object);
    }
}

