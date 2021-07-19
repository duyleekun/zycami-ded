/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AppRouter;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConnectionManager$3$1;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.s0.b;
import e.a.z;

public class AVConnectionManager$3
implements g0 {
    public final /* synthetic */ AVConnectionManager this$0;
    public final /* synthetic */ AppRouter val$appRouter;
    public final /* synthetic */ String val$installationId;

    public AVConnectionManager$3(AVConnectionManager aVConnectionManager, AppRouter appRouter, String string2) {
        this.this$0 = aVConnectionManager;
        this.val$appRouter = appRouter;
        this.val$installationId = string2;
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        AVLogger aVLogger = AVConnectionManager.access$100();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to get RTM Endpoint. cause: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.e((String)object);
        AVConnectionManager.access$300(this.this$0);
    }

    public void onNext(String object) {
        Object string2;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            AVConnectionManager.access$100().e("failed to get RTM Endpoint. cause: push router url is emptry.");
            AVConnectionManager.access$300(this.this$0);
            return;
        }
        Object object2 = "http";
        bl2 = ((String)object).startsWith((String)object2);
        if (!bl2) {
            object2 = new StringBuilder();
            string2 = "https://";
            ((StringBuilder)object2).append((String)string2);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
        }
        string2 = object;
        object2 = this.val$appRouter;
        String string3 = AVOSCloud.getApplicationId();
        String string4 = this.val$installationId;
        int n10 = 1;
        object = this.this$0;
        boolean bl3 = AVConnectionManager.access$000((AVConnectionManager)object);
        boolean bl4 = true;
        if (bl3 >= bl4) {
            boolean bl5 = false;
            object = null;
            bl4 = false;
        }
        object = ((AppRouter)object2).fetchRTMConnectionServer((String)string2, string3, string4, n10, bl4);
        object2 = new AVConnectionManager$3$1(this);
        ((z)object).subscribe((g0)object2);
    }

    public void onSubscribe(b b10) {
    }
}

