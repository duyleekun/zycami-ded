/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.a;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;

public class f$6
extends Thread {
    public final /* synthetic */ f a;

    public f$6(f f10, String string2) {
        this.a = f10;
        super(string2);
    }

    public void run() {
        block15: {
            int n10 = MobSDK.isForb();
            if (n10 != 0) break block15;
            n10 = cn.sharesdk.framework.a.a();
            if (n10 == 0) break block15;
            n10 = MobSDK.isAuth();
            int n11 = 1;
            if (n10 != n11 && n10 != (n11 = 2)) break block15;
            Object object = this.a;
            f.c((f)object);
            object = SSDKLog.b();
            Object object2 = "\u7528\u6237\u4f7f\u7528\u7684\u662f\u65e0\u5f39\u6846\u9690\u79c1\u7248\u672c authorize 001";
            try {
                ((NLog)object).w((String)object2);
            }
            catch (Throwable throwable) {
                object2 = this.a;
                f.c((f)object2);
                object2 = SSDKLog.b();
                Object[] objectArray = new StringBuilder();
                String string2 = "\u7528\u6237\u4f7f\u7528\u7684\u662f\u53bb\u4e8c\u6b21\u5f39\u6846\u4e4b\u524d\u7684\u7248\u672c authorize 001 ";
                objectArray.append(string2);
                objectArray.append(throwable);
                String string3 = objectArray.toString();
                try {
                    ((NLog)object2).w(string3);
                }
                catch (Throwable throwable2) {
                    object2 = SSDKLog.b();
                    objectArray = new StringBuilder();
                    string2 = "authorize(final String[] permissions) ";
                    objectArray.append(string2);
                    objectArray.append(throwable2);
                    String string4 = objectArray.toString();
                    objectArray = new Object[]{};
                    ((NLog)object2).d(string4, objectArray);
                }
            }
        }
    }
}

