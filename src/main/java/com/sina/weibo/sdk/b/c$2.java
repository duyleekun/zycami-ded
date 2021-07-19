/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.sina.weibo.sdk.b;

import android.os.Process;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.c$d;

public final class c$2
extends c$d {
    public final /* synthetic */ c V;

    public c$2(c c10) {
        this.V = c10;
        super((byte)0);
    }

    public final Object call() {
        Process.setThreadPriority((int)this.V.T);
        return this.V.o();
    }
}

