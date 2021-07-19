/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ProvicyCanContinue;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$7$1;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.tools.log.NLog;

public class f$7
extends Thread {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ f b;

    public f$7(f f10, String[] stringArray) {
        this.b = f10;
        this.a = stringArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n10;
        int n11;
        block11: {
            n11 = MobSDK.isForb();
            n10 = 1;
            if (n11 == 0) break block11;
            f f10 = this.b;
            d d10 = f.b(f10);
            f.a(f10, d10, n10);
            return;
        }
        try {
            int n12;
            n11 = MobSDK.isAuth();
            if (n11 != n10 && n11 != (n12 = 2)) {
                Object object = this.b;
                if ((object = f.b((f)object)) == null) return;
                object = this.b;
                object = f.b((f)object);
                Object object2 = this.b;
                object2 = f.a((f)object2);
                PolicyThrowable policyThrowable = new PolicyThrowable();
                ((d)object).onError((Platform)object2, n10, policyThrowable);
                return;
            }
            n11 = (int)(cn.sharesdk.framework.a.a() ? 1 : 0);
            if (n11 == 0) {
                f f11 = this.b;
                d d11 = f.b(f11);
                f.b(f11, d11, n10);
                return;
            }
            Object object = this.b;
            object = f.a((f)object);
            String[] stringArray = this.a;
            ((Platform)object).doAuthorize(stringArray);
            return;
        }
        catch (Throwable throwable) {
            try {
                ProvicyCanContinue provicyCanContinue = ProvicyCanContinue.a();
                f$7$1 f$7$1 = new f$7$1(this);
                provicyCanContinue.a(f$7$1);
                return;
            }
            catch (Throwable throwable2) {
                try {
                    Object object;
                    Object object3;
                    Object object4;
                    boolean bl2 = cn.sharesdk.framework.a.a();
                    if (!bl2) {
                        object4 = this.b;
                        object3 = f.b((f)object4);
                        f.b((f)object4, (d)object3, n10);
                    } else {
                        object = this.b;
                        object = f.a((f)object);
                        object4 = this.a;
                        ((Platform)object).doAuthorize((String[])object4);
                    }
                    object = SSDKLog.b();
                    object4 = new StringBuilder();
                    object3 = "\u7528\u6237\u4f7f\u7528\u7684\u662f\u975e\u9690\u79c1\u7248\u672c authorize 002 ";
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append(throwable2);
                    String string2 = ((StringBuilder)object4).toString();
                    ((NLog)object).w(string2);
                    return;
                }
                catch (Throwable throwable3) {
                    NLog nLog = SSDKLog.b();
                    Object[] objectArray = new StringBuilder();
                    String string3 = "new Thread Platform.ACTION_AUTHORIZING ";
                    objectArray.append(string3);
                    objectArray.append(throwable3);
                    String string4 = objectArray.toString();
                    boolean bl3 = false;
                    objectArray = new Object[]{};
                    nLog.d(string4, objectArray);
                }
            }
        }
    }
}

