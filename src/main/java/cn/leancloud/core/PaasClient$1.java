/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.service.APIService;
import g.z;
import k.e$a;
import k.h$a;
import k.s$b;
import k.x.a.g;

public final class PaasClient$1
implements e.a.v0.g {
    public void accept(String object) {
        Object object2 = PaasClient.getGlobalOkHttpClient();
        Object object3 = new s$b();
        object = ((s$b)object3).c((String)object);
        object3 = AppConfiguration.getRetrofitConverterFactory();
        object = ((s$b)object).b((h$a)object3);
        object3 = g.d();
        PaasClient.access$002((APIService)((s$b)object).a((e$a)object3).j((z)object2).f().g(APIService.class));
        object2 = PaasClient.access$000();
        boolean bl2 = AppConfiguration.isAsynchronized();
        AppConfiguration$SchedulerCreator appConfiguration$SchedulerCreator = AppConfiguration.getDefaultScheduler();
        object = new StorageClient((APIService)object2, bl2, appConfiguration$SchedulerCreator);
        PaasClient.access$102((StorageClient)object);
    }
}

