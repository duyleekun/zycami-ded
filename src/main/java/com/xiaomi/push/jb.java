/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ix;
import com.xiaomi.push.je$a;
import com.xiaomi.push.ji;
import com.xiaomi.push.jk;
import com.xiaomi.push.jr;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jb {
    private final ji a;
    private final jr a;

    public jb() {
        je$a je$a = new je$a();
        this(je$a);
    }

    public jb(jk object) {
        jr jr2;
        this.a = jr2 = new jr();
        this.a = object = object.a(jr2);
    }

    public void a(ix ix2, byte[] object) {
        try {
            jr jr2 = this.a;
            jr2.a((byte[])object);
            object = this.a;
            ix2.a((ji)object);
            return;
        }
        finally {
            this.a.k();
        }
    }
}

