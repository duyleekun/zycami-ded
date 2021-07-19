/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a;

public final class e {
    public final String a;
    public final int b;
    public final int c;
    public final long d;

    public e(String string2, int n10, int n11, long l10) {
        this.a = string2;
        this.b = n10;
        int n12 = 600;
        if (n11 < n12) {
            n11 = n12;
        }
        this.c = n11;
        this.d = l10;
    }

    public boolean a() {
        int n10 = this.b;
        int n11 = 5;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (n10 = object instanceof e) != 0) {
            long l10;
            long l11;
            long l12;
            long l13;
            int n11;
            object = (e)object;
            String string2 = this.a;
            String string3 = ((e)object).a;
            n10 = string2.equals(string3);
            if (n10 == 0 || (n10 = this.b) != (n11 = ((e)object).b) || (n10 = this.c) != (n11 = ((e)object).c) || (l13 = (l12 = (l11 = this.d) - (l10 = ((e)object).d)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }
}

