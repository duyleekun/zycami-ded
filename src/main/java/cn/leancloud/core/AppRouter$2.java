/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppRouter;
import cn.leancloud.json.JSON;
import cn.leancloud.service.AppAccessEndpoint;
import e.a.v0.o;

public class AppRouter$2
implements o {
    public final /* synthetic */ AppRouter this$0;
    public final /* synthetic */ String val$appId;

    public AppRouter$2(AppRouter appRouter, String string2) {
        this.this$0 = appRouter;
        this.val$appId = string2;
    }

    public AppAccessEndpoint apply(AppAccessEndpoint object) {
        Object object2 = AppRouter.access$000();
        Object object3 = object.toString();
        ((AVLogger)object2).d((String)object3);
        AppRouter.access$102(this.this$0, (AppAccessEndpoint)object);
        object2 = AppRouter.access$100(this.this$0);
        long l10 = ((AppAccessEndpoint)object).getTtl();
        long l11 = System.currentTimeMillis();
        long l12 = 1000L;
        ((AppAccessEndpoint)object2).setTtl(l10 += (l11 /= l12));
        object = AppConfiguration.getDefaultSetting();
        if (object != null) {
            object2 = JSON.toJSONString(AppRouter.access$100(this.this$0));
            object3 = this.this$0;
            String string2 = this.val$appId;
            boolean bl2 = true;
            object3 = ((AppRouter)object3).getPersistenceKeyZone(string2, bl2);
            string2 = this.val$appId;
            object.saveString((String)object3, string2, (String)object2);
        }
        return AppRouter.access$100(this.this$0);
    }
}

