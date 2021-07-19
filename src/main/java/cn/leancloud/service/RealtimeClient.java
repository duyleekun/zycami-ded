/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.AppRouter;
import cn.leancloud.core.PaasClient;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.service.RealtimeClient$1;
import cn.leancloud.service.RealtimeClient$2;
import cn.leancloud.service.RealtimeClient$3;
import cn.leancloud.service.RealtimeClient$4;
import cn.leancloud.service.RealtimeClient$5;
import cn.leancloud.service.RealtimeService;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.Map;

public class RealtimeClient {
    private static RealtimeClient instance;
    private boolean asynchronized = false;
    private AppConfiguration$SchedulerCreator defaultCreator = null;
    private RealtimeService service = null;

    private RealtimeClient() {
        boolean bl2;
        this.asynchronized = bl2 = AppConfiguration.isAsynchronized();
        Object object = AppConfiguration.getDefaultScheduler();
        this.defaultCreator = object;
        object = PaasClient.getGlobalOkHttpClient();
        Object object2 = AppRouter.getInstance();
        Object object3 = AVOSCloud.getApplicationId();
        AVOSService aVOSService = AVOSService.API;
        object2 = ((AppRouter)object2).getEndpoint((String)object3, aVOSService);
        object3 = new RealtimeClient$1(this, (g.z)object);
        ((z)object2).d((g)object3);
    }

    public static /* synthetic */ RealtimeService access$002(RealtimeClient realtimeClient, RealtimeService realtimeService) {
        realtimeClient.service = realtimeService;
        return realtimeService;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RealtimeClient getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = RealtimeClient.class;
        synchronized (object) {
            RealtimeClient realtimeClient = instance;
            if (realtimeClient != null) return instance;
            instance = realtimeClient = new RealtimeClient();
            return instance;
        }
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
        object = new RealtimeClient$2(this);
        return z10.n4((o)object);
    }

    public z createSignature(Map object) {
        RealtimeService realtimeService = this.service;
        object = JSONObject$Builder.create((Map)object);
        object = realtimeService.createSignature((JSONObject)object);
        return this.wrapObservable((z)object);
    }

    public z queryMemberInfo(Map object, String object2) {
        object = this.service.queryMemberInfo((String)object2, (Map)object);
        object = this.wrapObservable((z)object);
        object2 = new RealtimeClient$3(this);
        return ((z)object).H3((o)object2);
    }

    public z subscribeLiveQuery(Map object) {
        Object object2 = this.service;
        object = JSONObject$Builder.create((Map)object);
        object = object2.subscribe((JSONObject)object);
        object = this.wrapObservable((z)object);
        object2 = new RealtimeClient$4(this);
        return ((z)object).H3((o)object2);
    }

    public z unsubscribeLiveQuery(Map object) {
        Object object2 = this.service;
        object = JSONObject$Builder.create((Map)object);
        object = object2.unsubscribe((JSONObject)object);
        object = this.wrapObservable((z)object);
        object2 = new RealtimeClient$5(this);
        return ((z)object).H3((o)object2);
    }
}

