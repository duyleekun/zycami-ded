/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.je$a;
import com.xiaomi.push.ji;
import com.xiaomi.push.jo;
import com.xiaomi.push.js;

public class jo$a
extends je$a {
    public jo$a() {
        super(false, true);
    }

    public jo$a(boolean bl2, boolean bl3, int n10) {
        super(bl2, bl3, n10);
    }

    public ji a(js js2) {
        boolean bl2 = this.a;
        boolean bl3 = this.b;
        jo jo2 = new jo(js2, bl2, bl3);
        int n10 = this.a;
        if (n10 != 0) {
            jo2.b(n10);
        }
        return jo2;
    }
}

