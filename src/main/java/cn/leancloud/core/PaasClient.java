/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.AppRouter;
import cn.leancloud.core.LoggingInterceptor;
import cn.leancloud.core.PaasClient$1;
import cn.leancloud.core.PushClient;
import cn.leancloud.core.RequestPaddingInterceptor;
import cn.leancloud.core.StorageClient;
import cn.leancloud.network.DNSDetoxicant;
import cn.leancloud.service.APIService;
import cn.leancloud.service.PushService;
import e.a.v0.g;
import g.p;
import g.u;
import g.z;
import g.z$a;
import java.util.concurrent.TimeUnit;
import k.e$a;
import k.h$a;
import k.s$b;

public class PaasClient {
    private static APIService apiService;
    private static z globalHttpClient;
    private static PushClient pushClient;
    private static PushService pushService;
    private static StorageClient storageClient;

    public static /* synthetic */ APIService access$000() {
        return apiService;
    }

    public static /* synthetic */ APIService access$002(APIService aPIService) {
        apiService = aPIService;
        return aPIService;
    }

    public static /* synthetic */ StorageClient access$102(StorageClient storageClient) {
        PaasClient.storageClient = storageClient;
        return storageClient;
    }

    public static z getGlobalOkHttpClient() {
        Object object = globalHttpClient;
        if (object == null) {
            object = new z$a();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            object = ((z$a)object).k(15, timeUnit);
            long l10 = 10;
            object = ((z$a)object).j0(l10, timeUnit).R0(l10, timeUnit);
            Object object2 = new RequestPaddingInterceptor();
            object = ((z$a)object).c((u)object2);
            object2 = new LoggingInterceptor();
            object = ((z$a)object).c((u)object2);
            object2 = new DNSDetoxicant();
            globalHttpClient = object = ((z$a)object).q((p)object2).f();
        }
        return globalHttpClient;
    }

    public static PushClient getPushClient() {
        Object object = pushService;
        if (object == null) {
            object = PaasClient.getGlobalOkHttpClient();
            Object object2 = AppRouter.getInstance();
            Object object3 = AVOSCloud.getApplicationId();
            Object object4 = AVOSService.PUSH;
            object2 = (String)((AppRouter)object2).getEndpoint((String)object3, (AVOSService)((Object)object4)).r();
            object3 = new s$b();
            object2 = ((s$b)object3).c((String)object2);
            object3 = AppConfiguration.getRetrofitConverterFactory();
            object2 = ((s$b)object2).b((h$a)object3);
            object3 = k.x.a.g.d();
            pushService = object = (PushService)((s$b)object2).a((e$a)object3).j((z)object).f().g(PushService.class);
            boolean bl2 = AppConfiguration.isAsynchronized();
            object4 = AppConfiguration.getDefaultScheduler();
            pushClient = object2 = new PushClient((PushService)object, bl2, (AppConfiguration$SchedulerCreator)object4);
        }
        return pushClient;
    }

    public static StorageClient getStorageClient() {
        Object object = apiService;
        if (object == null) {
            object = PaasClient.getGlobalOkHttpClient();
            Object object2 = AppRouter.getInstance();
            Object object3 = AVOSCloud.getApplicationId();
            Object object4 = AVOSService.API;
            object2 = (String)((AppRouter)object2).getEndpoint((String)object3, (AVOSService)((Object)object4)).r();
            object3 = new s$b();
            object2 = ((s$b)object3).c((String)object2);
            object3 = AppConfiguration.getRetrofitConverterFactory();
            object2 = ((s$b)object2).b((h$a)object3);
            object3 = k.x.a.g.d();
            apiService = (APIService)((s$b)object2).a((e$a)object3).j((z)object).f().g(APIService.class);
            object2 = apiService;
            boolean bl2 = AppConfiguration.isAsynchronized();
            object4 = AppConfiguration.getDefaultScheduler();
            storageClient = object = new StorageClient((APIService)object2, bl2, (AppConfiguration$SchedulerCreator)object4);
        }
        return storageClient;
    }

    public static void initializeGlobalClient() {
        Object object = apiService;
        if (object == null) {
            object = AppRouter.getInstance();
            Object object2 = AVOSCloud.getApplicationId();
            AVOSService aVOSService = AVOSService.API;
            object = ((AppRouter)object).getEndpoint((String)object2, aVOSService);
            object2 = new PaasClient$1();
            ((e.a.z)object).d((g)object2);
        }
    }
}

