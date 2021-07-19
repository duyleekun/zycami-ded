/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.r.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.r.a.m;
import d.r.a.u.s;

public final class n$a
extends Handler {
    public n$a(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message object) {
        object = ((Message)object).obj;
        boolean bl2 = object instanceof m;
        if (bl2) {
            object = (m)object;
            CharSequence charSequence = new StringBuilder("PushClientThread-handleMessage, task = ");
            charSequence.append(object);
            charSequence = charSequence.toString();
            String string2 = "PushClientThread";
            s.k(string2, (String)charSequence);
            ((m)object).run();
        }
    }
}

