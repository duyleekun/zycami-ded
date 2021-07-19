/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.r.a;

import android.os.Handler;
import android.os.Message;
import d.r.a.h;
import d.r.a.u.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class h$a
implements Handler.Callback {
    public final /* synthetic */ h a;

    public h$a(h h10) {
        this.a = h10;
    }

    public final boolean handleMessage(Message object) {
        String string2 = "AidlManager";
        if (object == null) {
            s.a(string2, "handleMessage error : msg is null");
            return false;
        }
        int n10 = ((Message)object).what;
        int n11 = 2;
        int n12 = 1;
        if (n10 != n12) {
            if (n10 != n11) {
                String string3 = "unknow msg what [";
                StringBuilder stringBuilder = new StringBuilder(string3);
                int n13 = ((Message)object).what;
                stringBuilder.append(n13);
                stringBuilder.append("]");
                object = stringBuilder.toString();
                s.h(string2, (String)object);
            } else {
                int n14;
                object = h.b(this.a);
                int n15 = ((AtomicInteger)object).get();
                if (n15 == (n14 = 4)) {
                    object = this.a;
                    h.i((h)object);
                }
                object = this.a;
                h.f((h)object);
            }
        } else {
            s.a(string2, "In connect, bind core service time out");
            object = h.b(this.a);
            int n16 = ((AtomicInteger)object).get();
            if (n16 == n11) {
                object = this.a;
                h.f((h)object);
            }
        }
        return n12;
    }
}

