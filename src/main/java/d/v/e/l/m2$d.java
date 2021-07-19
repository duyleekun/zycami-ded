/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import e.a.s0.b;

public class m2$d {
    private b a;

    public m2$d(b b10) {
        this.a = b10;
    }

    public void a() {
        b b10 = this.a;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.a = null;
        }
    }

    public boolean b() {
        boolean bl2;
        b b10 = this.a;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            bl2 = false;
            b10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

