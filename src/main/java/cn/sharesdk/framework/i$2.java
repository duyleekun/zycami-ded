/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.b.a;
import cn.sharesdk.framework.i;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import java.util.HashMap;

public class i$2
extends Thread {
    public final /* synthetic */ a a;
    public final /* synthetic */ i b;

    public i$2(i i10, a a10) {
        this.b = i10;
        this.a = a10;
    }

    public void run() {
        block11: {
            Object object = this.a;
            object = ((a)object).f();
            Object object2 = this.b;
            Object object3 = this.a;
            object2 = i.a((i)object2, (a)object3, (HashMap)object);
            if (object2 == null) break block11;
            int n10 = ((HashMap)object2).size();
            if (n10 <= 0) break block11;
            object3 = this.b;
            boolean bl2 = i.a((i)object3, (HashMap)object2);
            if (!bl2) break block11;
            object2 = this.a;
            try {
                ((a)object2).a((HashMap)object);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).w(throwable);
            }
        }
    }
}

