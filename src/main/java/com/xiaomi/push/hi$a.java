/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.hi;
import com.xiaomi.push.hl;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hi$a
implements Runnable {
    private Context a;
    private hl a;

    public hi$a(Context context, hl hl2) {
        this.a = hl2;
        this.a = context;
    }

    public void run() {
        Context context = this.a;
        hl hl2 = this.a;
        hi.b(context, hl2);
    }
}

