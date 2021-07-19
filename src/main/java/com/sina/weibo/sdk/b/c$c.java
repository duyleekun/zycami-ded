/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.b.c$d;
import java.util.concurrent.FutureTask;

public abstract class c$c
extends FutureTask
implements Comparable {
    public final /* synthetic */ c V;
    public int priority;

    public c$c(c c10, c$d c$d) {
        int n10;
        this.V = c10;
        super(c$d);
        this.priority = n10 = c$d.priority;
    }
}

