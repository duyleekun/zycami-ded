/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.cz;
import com.xiaomi.push.fz;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gc
implements Runnable {
    public final /* synthetic */ fz a;
    public final /* synthetic */ String a;

    public gc(fz fz2, String string2) {
        this.a = fz2;
        this.a = string2;
    }

    public void run() {
        cz cz2 = cz.a();
        String string2 = this.a;
        cz2.a(string2, true);
    }
}

