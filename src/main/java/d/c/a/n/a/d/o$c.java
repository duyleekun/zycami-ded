/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.c.a.n.a.d;

import android.os.Handler;
import android.os.Message;
import d.c.a.i;
import d.c.a.n.a.d.o;
import d.c.a.n.a.d.o$a;
import d.c.a.s.j.p;

public class o$c
implements Handler.Callback {
    public static final int b = 1;
    public static final int c = 2;
    public final /* synthetic */ o a;

    public o$c(o o10) {
        this.a = o10;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = (o$a)object.obj;
            this.a.p((o$a)object);
            return n11 != 0;
        }
        n11 = 2;
        if (n10 == n11) {
            object = (o$a)object.obj;
            i i10 = this.a.d;
            i10.z((p)object);
        }
        return false;
    }
}

