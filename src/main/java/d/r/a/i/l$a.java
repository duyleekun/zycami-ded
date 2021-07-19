/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.NetworkInfo$State
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import d.r.a.h$r;
import d.r.a.i.l;
import d.r.a.i.l$a$a;
import d.r.a.i.o;
import d.r.a.r.a;
import d.r.a.r.c;
import d.r.a.u.s;
import d.r.a.u.t;
import d.r.a.u.u;

public final class l$a
implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ h$r c;
    public final /* synthetic */ l d;

    public l$a(l l10, a a10, String string2, h$r r10) {
        this.d = l10;
        this.a = a10;
        this.b = string2;
        this.c = r10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void run() {
        Object object = this.d;
        Object object2 = ((o)object).d;
        object = l.d((l)object);
        Object object3 = t.b(this.a);
        boolean bl2 = object2.onNotificationMessageArrived((Context)object, (c)object3);
        object2 = "OnNotificationArrivedTask";
        if (bl2) {
            object = new StringBuilder("pkg name : ");
            object3 = l.h(this.d).getPackageName();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(" \u5e94\u7528\u4e3b\u52a8\u62e6\u622a\u901a\u77e5");
            object = ((StringBuilder)object).toString();
            s.h((String)object2, (String)object);
            s.j(l.i(this.d), "\u5e94\u7528\u4e3b\u52a8\u62e6\u622a\u901a\u77e5\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u5982\u9700\u6253\u5f00\u8bf7\u5728onNotificationMessageArrived\u4e2d\u8fd4\u56defalse");
            object = this.d;
            object2 = this.b;
            l.f((l)object, (String)object2, 2120);
            return;
        }
        Object object4 = l.j(this.d);
        a a10 = this.a;
        long l10 = this.c.f;
        object3 = this.d;
        Object object5 = ((o)object3).d;
        object3 = l.k((l)object3);
        boolean bl3 = object5.isAllowNet((Context)object3);
        l$a$a l$a$a = new l$a$a(this);
        object5 = object;
        object = new d.r.a.u.o((Context)object4, a10, l10, bl3, l$a$a);
        object3 = this.a;
        boolean bl4 = ((a)object3).O();
        object5 = this.a.l();
        boolean bl5 = TextUtils.isEmpty((CharSequence)object5);
        if (bl5) {
            object5 = this.a.f();
        }
        bl5 = TextUtils.isEmpty((CharSequence)object5);
        int n10 = 2;
        int n11 = 1;
        if (!bl5) {
            String string2 = "showCode=";
            object4 = new StringBuilder(string2);
            ((StringBuilder)object4).append(bl4);
            object4 = ((StringBuilder)object4).toString();
            s.k((String)object2, (String)object4);
            if (!bl4) {
                int n12;
                object2 = l.o(this.d);
                object3 = "mobile net unshow";
                s.e((Context)object2, (String)object3);
                object2 = u.a(l.p(this.d));
                if (object2 == null || (object3 = object2.getState()) != (object4 = NetworkInfo.State.CONNECTED)) {
                    n12 = 0;
                    object2 = null;
                } else {
                    n12 = object2.getType();
                    n12 = n12 == n11 ? n10 : (n12 == 0 ? n11 : 3);
                }
                if (n12 == n11) {
                    object5 = null;
                    this.a.a();
                    object2 = this.a;
                    ((c)object2).b();
                }
            } else {
                object2 = l.q(this.d);
                object3 = "mobile net show";
                s.e((Context)object2, (String)object3);
            }
        }
        object2 = new String[n10];
        object2[0] = object3 = this.a.g();
        object2[n11] = object5;
        object.execute((Object[])object2);
    }
}

