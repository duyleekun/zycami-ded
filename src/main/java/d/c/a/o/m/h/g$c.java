/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.c.a.o.m.h;

import android.os.Handler;
import android.os.Message;
import d.c.a.i;
import d.c.a.o.m.h.g;
import d.c.a.o.m.h.g$a;
import d.c.a.s.j.p;

public class g$c
implements Handler.Callback {
    public static final int b = 1;
    public static final int c = 2;
    public final /* synthetic */ g a;

    public g$c(g g10) {
        this.a = g10;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = (g$a)object.obj;
            this.a.o((g$a)object);
            return n11 != 0;
        }
        n11 = 2;
        if (n10 == n11) {
            object = (g$a)object.obj;
            i i10 = this.a.d;
            i10.z((p)object);
        }
        return false;
    }
}

