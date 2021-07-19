/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

public abstract class e
implements Handler.Callback {
    public final Handler a;

    public e() {
        Handler handler;
        this.a = handler = MobHandlerThread.newHandler(this);
    }

    public void a(int n10, int n11, Object object) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = n10;
        message.arg2 = n11;
        message.obj = object;
        this.a.sendMessage(message);
    }

    public void a(Message message) {
    }

    public abstract void b(Message var1);

    public void c(Message message) {
    }

    public void e() {
        this.a(0, 0, null);
    }

    public final boolean handleMessage(Message message) {
        int n10 = message.what;
        int n11 = -2;
        if (n10 != n11) {
            n11 = -1;
            if (n10 != n11) {
                this.b(message);
            } else {
                this.a(message);
            }
        } else {
            this.c(message);
        }
        return false;
    }
}

