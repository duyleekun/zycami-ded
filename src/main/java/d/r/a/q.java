/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package d.r.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import d.r.a.u.s;

public abstract class q {
    private final Object a;
    public Context b;
    public Handler c;

    public q() {
        Object object;
        this.a = object = new Object();
        Object object2 = this.getClass().getSimpleName();
        object = new HandlerThread(object2, 1);
        object.start();
        object = object.getLooper();
        super(this, (Looper)object);
        this.c = object2;
    }

    public final void a(Context context) {
        this.b = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(Message object) {
        Object object2 = this.a;
        synchronized (object2) {
            Object object3 = this.c;
            if (object3 == null) {
                CharSequence charSequence = "Dead worker dropping a message: ";
                object3 = new StringBuilder((String)charSequence);
                int n10 = ((Message)object).what;
                ((StringBuilder)object3).append(n10);
                object = ((StringBuilder)object3).toString();
                object3 = this.getClass();
                object3 = ((Class)object3).getSimpleName();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                object = " (Thread ";
                ((StringBuilder)charSequence).append((String)object);
                object = Thread.currentThread();
                long l10 = ((Thread)object).getId();
                ((StringBuilder)charSequence).append(l10);
                object = ")";
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                s.n((String)object3, (String)object);
            } else {
                object3.sendMessage((Message)object);
            }
            return;
        }
    }

    public abstract void c(Message var1);
}

