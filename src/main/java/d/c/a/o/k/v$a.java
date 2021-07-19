/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.c.a.o.k;

import android.os.Handler;
import android.os.Message;
import d.c.a.o.k.s;

public final class v$a
implements Handler.Callback {
    public static final int a = 1;

    public boolean handleMessage(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            ((s)message.obj).recycle();
            return n11 != 0;
        }
        return false;
    }
}

