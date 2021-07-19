/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ProvicyCanContinue;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$4$1;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.tools.log.NLog;

public class f$4
extends Thread {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ f c;

    public f$4(f f10, int n10, Object object) {
        this.c = f10;
        this.a = n10;
        this.b = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n10;
        block12: {
            n10 = MobSDK.isForb();
            if (n10 == 0) break block12;
            f f10 = this.c;
            d d10 = f.b(f10);
            int n11 = this.a;
            f.a(f10, d10, n11);
            return;
        }
        try {
            Object object;
            n10 = MobSDK.isAuth();
            int n12 = 1;
            if (n10 != n12 && n10 != (n12 = 2)) {
                Object object2 = this.c;
                if ((object2 = f.b((f)object2)) == null) return;
                object2 = this.c;
                object2 = f.b((f)object2);
                Object object3 = this.c;
                object3 = f.a((f)object3);
                int n13 = this.a;
                PolicyThrowable policyThrowable = new PolicyThrowable();
                ((d)object2).onError((Platform)object3, n13, policyThrowable);
                return;
            }
            n10 = (int)(cn.sharesdk.framework.a.a() ? 1 : 0);
            if (n10 == 0) {
                f f11 = this.c;
                d d11 = f.b(f11);
                int n14 = this.a;
                f.b(f11, d11, n14);
                return;
            }
            Object object4 = this.c;
            n10 = (int)(((Platform)(object4 = f.a((f)object4))).checkAuthorize(n12 = this.a, object = this.b) ? 1 : 0);
            if (n10 == 0) return;
            object4 = this.c;
            n12 = this.a;
            object = this.b;
            ((f)object4).b(n12, object);
            object4 = SSDKLog.b();
            String string2 = "\u7528\u6237\u4f7f\u7528\u7684\u662f\u65e0\u5f39\u6846\u9690\u79c1\u7248\u672c newThreadJob 002";
            ((NLog)object4).w(string2);
            return;
        }
        catch (Throwable throwable) {
            try {
                ProvicyCanContinue provicyCanContinue = ProvicyCanContinue.a();
                f$4$1 f$4$1 = new f$4$1(this);
                provicyCanContinue.a(f$4$1);
                return;
            }
            catch (Throwable throwable2) {
                try {
                    Object object;
                    Object object5;
                    Object object6;
                    boolean bl2 = cn.sharesdk.framework.a.a();
                    if (!bl2) {
                        object6 = this.c;
                        object5 = f.b((f)object6);
                        int n15 = this.a;
                        f.b((f)object6, (d)object5, n15);
                    } else {
                        int n16;
                        object6 = this.c;
                        bl2 = ((Platform)(object6 = f.a((f)object6))).checkAuthorize(n16 = this.a, object = this.b);
                        if (bl2) {
                            object6 = this.c;
                            n16 = this.a;
                            object = this.b;
                            ((f)object6).b(n16, object);
                        }
                    }
                    object6 = SSDKLog.b();
                    object5 = new StringBuilder();
                    object = "\u7528\u6237\u4f7f\u7528\u7684\u662f\u975e\u9690\u79c1\u7248\u672c newThreadJob 002 ";
                    ((StringBuilder)object5).append((String)object);
                    ((StringBuilder)object5).append(throwable2);
                    String string3 = ((StringBuilder)object5).toString();
                    ((NLog)object6).w(string3);
                    return;
                }
                catch (Throwable throwable3) {
                    NLog nLog = SSDKLog.b();
                    Object[] objectArray = new StringBuilder();
                    String string4 = "new Thread(getThreadName(action)) ";
                    objectArray.append(string4);
                    objectArray.append(throwable3);
                    String string5 = objectArray.toString();
                    boolean bl3 = false;
                    objectArray = new Object[]{};
                    nLog.d(string5, objectArray);
                }
            }
        }
    }
}

