/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qq;

import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.c;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class c$3
extends RxMob$Subscriber {
    public final /* synthetic */ c a;

    public c$3(c c10) {
        this.a = c10;
    }

    public void onCompleted() {
        int n10;
        Object object = c.c(this.a);
        if (object != null && (n10 = ((String)(object = c.c(this.a))).length()) > 0) {
            object = this.a;
            String string2 = c.c((c)object);
            String string3 = "";
            string2 = string2.replace("callback( ", string3);
            c.a((c)object, string2);
            object = this.a;
            string2 = c.c((c)object);
            Object object2 = " );";
            string2 = string2.replace((CharSequence)object2, string3);
            c.a((c)object, string2);
            object = new Hashon();
            string2 = c.c(this.a);
            object = ((Hashon)object).fromJson(string2);
            string2 = "unionid";
            boolean bl2 = ((HashMap)object).containsKey(string2);
            if (bl2) {
                object = (String)((HashMap)object).get(string2);
                object2 = c.d(this.a).getDb();
                ((PlatformDb)object2).put(string2, (String)object);
            } else {
                object = c.e(this.a).getDb();
                ((PlatformDb)object).put(string2, string3);
            }
        }
    }

    public void onError(Throwable object) {
        c.f(this.a).getDb().put("unionid", "");
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("qq auth,get unionId fail", objectArray);
    }
}

