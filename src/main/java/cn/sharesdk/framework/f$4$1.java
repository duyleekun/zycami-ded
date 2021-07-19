/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ProvicyCanContinue$OnBusinessListener;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$4;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.commons.dialog.PolicyThrowable;

public class f$4$1
implements ProvicyCanContinue$OnBusinessListener {
    public final /* synthetic */ f$4 a;

    public f$4$1(f$4 f$4) {
        this.a = f$4;
    }

    public void onContinue() {
        boolean bl2 = cn.sharesdk.framework.a.a();
        if (!bl2) {
            f f10 = this.a.c;
            d d10 = f.b(f10);
            f$4 f$4 = this.a;
            int n10 = f$4.a;
            f.b(f10, d10, n10);
        } else {
            Object object = f.a(this.a.c);
            Object object2 = this.a;
            int n11 = ((f$4)object2).a;
            object2 = ((f$4)object2).b;
            bl2 = ((Platform)object).checkAuthorize(n11, object2);
            if (bl2) {
                object = this.a;
                object2 = ((f$4)object).c;
                n11 = ((f$4)object).a;
                object = ((f$4)object).b;
                ((f)object2).b(n11, object);
            }
        }
        SSDKLog.b().w("\u7528\u6237\u4f7f\u7528\u7684\u662f\u5e26\u6846\u9690\u79c1\u7248\u672c newThreadJob 002");
    }

    public void onError(Throwable throwable) {
        d d10 = f.b(this.a.c);
        if (d10 != null) {
            d10 = f.b(this.a.c);
            Platform platform = f.a(this.a.c);
            f$4 f$4 = this.a;
            int n10 = f$4.a;
            d10.onError(platform, n10, throwable);
        }
    }

    public void onStop() {
        d d10 = f.b(this.a.c);
        if (d10 != null) {
            d10 = f.b(this.a.c);
            Platform platform = f.a(this.a.c);
            f$4 f$4 = this.a;
            int n10 = f$4.a;
            PolicyThrowable policyThrowable = new PolicyThrowable();
            d10.onError(platform, n10, policyThrowable);
        }
    }
}

