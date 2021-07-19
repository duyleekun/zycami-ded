/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

public final class zzee {
    private final String info;
    private int position;

    public zzee(String string2) {
        this.info = string2;
        this.position = 0;
    }

    public final boolean hasNext() {
        int n10 = this.position;
        String string2 = this.info;
        int n11 = string2.length();
        return n10 < n11;
    }

    public final int next() {
        int n10;
        int n11;
        String string2 = this.info;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        int n13 = string2.charAt(n12);
        if (n13 < (n12 = 55296)) {
            return n13;
        }
        n13 &= 0x1FFF;
        n11 = 13;
        while (true) {
            int n14;
            String string3 = this.info;
            int n15 = this.position;
            this.position = n14 = n15 + 1;
            n10 = string3.charAt(n15);
            if (n10 < n12) break;
            n10 = (n10 & 0x1FFF) << n11;
            n13 |= n10;
            n11 += 13;
        }
        n12 = n10 << n11;
        return n13 | n12;
    }
}

