/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.al$b;
import com.xiaomi.push.di;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class di$b
extends al$b {
    public long a;
    public final /* synthetic */ di b;

    public di$b(di di2) {
        long l10;
        this.b = di2;
        this.a = l10 = System.currentTimeMillis();
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public final boolean b() {
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        long l12 = (l10 -= l11) - (l11 = 172800000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

