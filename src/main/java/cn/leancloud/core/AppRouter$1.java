/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppRouter;
import cn.leancloud.core.AppRouter$4;
import cn.leancloud.service.AppAccessEndpoint;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;

public class AppRouter$1
implements o {
    public final /* synthetic */ AppRouter this$0;
    public final /* synthetic */ AVOSService val$service;

    public AppRouter$1(AppRouter appRouter, AVOSService aVOSService) {
        this.this$0 = appRouter;
        this.val$service = aVOSService;
    }

    public String apply(AppAccessEndpoint object) {
        Object object2 = AppRouter$4.$SwitchMap$cn$leancloud$core$AVOSService;
        Object object3 = this.val$service;
        int n10 = object3.ordinal();
        int n11 = object2[n10];
        object = n11 != (n10 = 1) ? (n11 != (n10 = 2) ? (n11 != (n10 = 3) ? (n11 != (n10 = 4) ? (n11 != (n10 = 5) ? "" : ((AppAccessEndpoint)object).getStatsServer()) : ((AppAccessEndpoint)object).getRtmRouterServer()) : ((AppAccessEndpoint)object).getPushServer()) : ((AppAccessEndpoint)object).getEngineServer()) : ((AppAccessEndpoint)object).getApiServer();
        n11 = (int)(StringUtil.isEmpty((String)object) ? 1 : 0);
        if (n11 == 0 && (n11 = (int)(((String)object).startsWith((String)(object2 = (Object)"http")) ? 1 : 0)) == 0) {
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            object3 = "https://";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
        }
        return object;
    }
}

