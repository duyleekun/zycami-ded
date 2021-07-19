/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ProvicyCanContinue$OnBusinessListener;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$7;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.commons.dialog.PolicyThrowable;

public class f$7$1
implements ProvicyCanContinue$OnBusinessListener {
    public final /* synthetic */ f$7 a;

    public f$7$1(f$7 f$7) {
        this.a = f$7;
    }

    public void onContinue() {
        boolean bl2 = cn.sharesdk.framework.a.a();
        if (!bl2) {
            f f10 = this.a.b;
            d d10 = f.b(f10);
            int n10 = 1;
            f.b(f10, d10, n10);
        } else {
            Platform platform = f.a(this.a.b);
            String[] stringArray = this.a.a;
            platform.doAuthorize(stringArray);
        }
        SSDKLog.b().w("\u7528\u6237\u4f7f\u7528\u7684\u662f\u5e26\u5f39\u6846\u9690\u79c1\u7248\u672c authorize 002");
    }

    public void onError(Throwable object) {
        object = f.b(this.a.b);
        if (object != null) {
            object = f.b(this.a.b);
            Platform platform = f.a(this.a.b);
            int n10 = 1;
            PolicyThrowable policyThrowable = new PolicyThrowable();
            ((d)object).onError(platform, n10, policyThrowable);
        }
    }

    public void onStop() {
        d d10 = f.b(this.a.b);
        if (d10 != null) {
            d10 = f.b(this.a.b);
            Platform platform = f.a(this.a.b);
            int n10 = 1;
            PolicyThrowable policyThrowable = new PolicyThrowable();
            d10.onError(platform, n10, policyThrowable);
        }
    }
}

