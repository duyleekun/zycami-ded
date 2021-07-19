/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.je;
import com.xiaomi.push.ji;
import com.xiaomi.push.jk;
import com.xiaomi.push.js;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class je$a
implements jk {
    public int a;
    public boolean a = false;
    public boolean b = true;

    public je$a() {
        this(false, true);
    }

    public je$a(boolean bl2, boolean bl3) {
        this(bl2, bl3, 0);
    }

    public je$a(boolean bl2, boolean bl3, int n10) {
        this.a = bl2;
        this.b = bl3;
        this.a = n10;
    }

    public ji a(js js2) {
        boolean bl2 = this.a;
        boolean bl3 = this.b;
        je je2 = new je(js2, bl2, bl3);
        int n10 = this.a;
        if (n10 != 0) {
            je2.b(n10);
        }
        return je2;
    }
}

