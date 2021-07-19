/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.view.ViewGroup
 */
package d.v.c.s0.i7;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import d.v.c.s0.i7.k;
import d.v.c.s0.i7.k$d;
import m.a.a;

public class k$e
implements Runnable {
    private k$d a;
    private boolean b;

    public k$e(k$d k$d) {
        this.a = k$d;
    }

    public boolean a() {
        return this.b;
    }

    public void run() {
        this.b = true;
        Object object = this.a;
        Object object2 = ((k$d)object).a;
        object2 = ((k)object2).b;
        int n10 = ((k$d)object).c;
        ViewGroup viewGroup = ((k$d)object).b;
        object2 = object2.inflate(n10, viewGroup, false);
        try {
            ((k$d)object).d = object2;
        }
        catch (RuntimeException runtimeException) {
            object2 = new StringBuilder();
            String string2 = "Failed to inflate resource in the background! Retrying on the UI thread";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(runtimeException);
            object = ((StringBuilder)object2).toString();
            object2 = new Object[]{};
            m.a.a.x((String)object, (Object[])object2);
        }
        object = this.a;
        Message.obtain((Handler)object.a.c, (int)0, (Object)object).sendToTarget();
    }
}

