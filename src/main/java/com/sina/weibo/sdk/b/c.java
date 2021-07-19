/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import com.sina.weibo.sdk.b.c$1;
import com.sina.weibo.sdk.b.c$b;
import com.sina.weibo.sdk.b.c$d;
import java.util.concurrent.FutureTask;

public abstract class c {
    public volatile int Q;
    public final c$d R;
    public final FutureTask S;
    public int T;
    public Object[] U;
    public Handler x;

    public c() {
        int n10;
        this.Q = n10 = c$b.Z;
        this.T = 5;
        Object object = Looper.getMainLooper();
        Object object2 = new c$1(this, (Looper)object);
        this.x = object2;
        super(this);
        this.R = object2;
        super(this, (c$d)object2);
        this.S = object;
    }

    public static /* synthetic */ void a(c c10, Object object) {
        int n10;
        c10.onPostExecute(object);
        c10.Q = n10 = c$b.ab;
    }

    public abstract Object o();

    public void onPostExecute(Object object) {
    }
}

