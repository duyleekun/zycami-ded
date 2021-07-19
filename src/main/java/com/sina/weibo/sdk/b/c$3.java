/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.sina.weibo.sdk.b;

import android.os.Handler;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.c$a;
import com.sina.weibo.sdk.b.c$c;
import com.sina.weibo.sdk.b.c$d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public final class c$3
extends c$c {
    public final /* synthetic */ c V;

    public c$3(c c10, c$d c$d) {
        this.V = c10;
        super(c10, c$d);
    }

    public final int compareTo(Object object) {
        return 0;
    }

    public final void done() {
        int n10;
        Handler handler;
        c c10;
        String string2 = "An error occur while execute doInBackground().";
        try {
            string2 = this.get();
            c10 = this.V;
            handler = c10.x;
            n10 = 1;
        }
        catch (Throwable throwable) {
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
        catch (CancellationException cancellationException) {
            string2 = this.V.x;
            c c11 = this.V;
            c$a c$a = new c$a(c11, null);
            string2.obtainMessage(3, (Object)c$a).sendToTarget();
            return;
        }
        catch (ExecutionException executionException) {
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
        catch (InterruptedException interruptedException) {
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        c$a c$a = new c$a(c10, objectArray);
        handler.obtainMessage(n10, (Object)c$a).sendToTarget();
        return;
    }
}

