/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.b;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class b$3
extends RxMob$Subscriber {
    public final /* synthetic */ b a;

    public b$3(b b10) {
        this.a = b10;
    }

    public void onCompleted() {
        int n10;
        Object object = b.c(this.a);
        if (object != null && (n10 = ((String)(object = b.c(this.a))).length()) > 0) {
            object = this.a;
            String string2 = b.c((b)object);
            String string3 = "";
            string2 = string2.replace("callback( ", string3);
            b.a((b)object, string2);
            object = this.a;
            string2 = b.c((b)object);
            Object object2 = " );";
            string2 = string2.replace((CharSequence)object2, string3);
            b.a((b)object, string2);
            object = new Hashon();
            string2 = b.c(this.a);
            object = ((Hashon)object).fromJson(string2);
            string2 = "unionid";
            boolean bl2 = ((HashMap)object).containsKey(string2);
            if (bl2) {
                object = (String)((HashMap)object).get(string2);
                object2 = b.d(this.a).getDb();
                ((PlatformDb)object2).put(string2, (String)object);
            } else {
                object = b.e(this.a).getDb();
                ((PlatformDb)object).put(string2, string3);
            }
        }
    }

    public void onError(Throwable object) {
        b.f(this.a).getDb().put("unionid", "");
        object = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d("qq auth, get unionId fail", objectArray);
    }
}

