/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppRouter;
import cn.leancloud.json.JSON;
import cn.leancloud.service.RTMConnectionServerResponse;
import e.a.v0.o;

public class AppRouter$3
implements o {
    public final /* synthetic */ AppRouter this$0;
    public final /* synthetic */ String val$appId;
    public final /* synthetic */ String val$routerHost;

    public AppRouter$3(AppRouter appRouter, String string2, String string3) {
        this.this$0 = appRouter;
        this.val$appId = string2;
        this.val$routerHost = string3;
    }

    public RTMConnectionServerResponse apply(RTMConnectionServerResponse rTMConnectionServerResponse) {
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        if (rTMConnectionServerResponse != null && systemSetting != null) {
            long l10 = rTMConnectionServerResponse.getTtl();
            long l11 = System.currentTimeMillis();
            long l12 = 1000L;
            rTMConnectionServerResponse.setTtl(l10 += (l11 /= l12));
            String string2 = JSON.toJSONString(rTMConnectionServerResponse);
            Object object = this.this$0;
            String string3 = this.val$appId;
            object = ((AppRouter)object).getPersistenceKeyZone(string3, false);
            string3 = this.val$routerHost;
            systemSetting.saveString((String)object, string3, string2);
        }
        return rTMConnectionServerResponse;
    }
}

