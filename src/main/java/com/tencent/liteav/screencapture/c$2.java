/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.screencapture;

import android.content.Context;
import com.tencent.liteav.basic.util.i$a;
import com.tencent.liteav.screencapture.c;
import com.tencent.liteav.screencapture.c$a;
import com.tencent.liteav.screencapture.c$b;

public class c$2
implements i$a {
    public final /* synthetic */ c a;

    public c$2(c c10) {
        this.a = c10;
    }

    public void onTimeout() {
        boolean bl2;
        c c10 = this.a;
        Object object = c.b(c10);
        boolean bl3 = c.a(c10, (Context)object);
        object = this.a;
        boolean bl4 = c.c((c)object);
        if (bl4 == bl3) {
            return;
        }
        c.b(this.a, bl3);
        object = c.a(this.a).values().iterator();
        while (bl2 = object.hasNext()) {
            c$b c$b = ((c$a)object.next()).d;
            if (c$b == null) continue;
            c$b.a(bl3);
        }
    }
}

