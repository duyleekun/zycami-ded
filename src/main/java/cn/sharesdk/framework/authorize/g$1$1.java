/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Instrumentation
 */
package cn.sharesdk.framework.authorize;

import android.app.Instrumentation;
import cn.sharesdk.framework.authorize.g$1;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;

public class g$1$1
extends Thread {
    public final /* synthetic */ g$1 a;

    public g$1$1(g$1 var1_1) {
        this.a = var1_1;
    }

    public void run() {
        Instrumentation instrumentation = new Instrumentation();
        int n10 = 4;
        try {
            instrumentation.sendKeyDownUpSync(n10);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.w(throwable);
            Object object = this.a.a.a.getAuthorizeListener();
            if (object != null) {
                object.onCancel();
            }
            object = this.a.a;
            ((FakeActivity)object).finish();
        }
    }
}

