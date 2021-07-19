/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.c.a.s.j;

import android.os.Handler;
import android.os.Message;
import d.c.a.s.j.m;

public class m$a
implements Handler.Callback {
    public boolean handleMessage(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            ((m)message.obj).n();
            return n11 != 0;
        }
        return false;
    }
}

