/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.jt;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class js {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] var1, int var2, int var3);

    public void a(int n10) {
    }

    public abstract void a(byte[] var1, int var2, int var3);

    public byte[] a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] object, int n10, int n11) {
        int n12;
        int n13;
        for (n12 = 0; n12 < n11; n12 += n13) {
            n13 = n10 + n12;
            int n14 = n11 - n12;
            if ((n13 = this.a((byte[])object, n13, n14)) > 0) {
                continue;
            }
            object = new jt;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Cannot read. Remote side has closed. Tried to read ");
            charSequence.append(n11);
            charSequence.append(" bytes, but only got ");
            charSequence.append(n12);
            charSequence.append(" bytes.");
            charSequence = charSequence.toString();
            object((String)charSequence);
            throw object;
        }
        return n12;
    }
}

