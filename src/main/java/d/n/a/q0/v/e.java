/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.v.k;
import d.n.a.q0.v.m;
import java.util.Arrays;

public class e {
    private final m[] a;
    private final boolean b;

    public e(m ... mArray) {
        int n10;
        this.a = mArray;
        boolean bl2 = false;
        if (mArray != null && (n10 = mArray.length) != 0) {
            for (m m10 : mArray) {
                boolean bl3 = m10.b();
                if (bl3) {
                    continue;
                }
                break;
            }
        } else {
            bl2 = true;
        }
        this.b = bl2;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b(k k10) {
        int n10;
        m[] mArray = this.a;
        boolean bl2 = true;
        if (mArray != null && (n10 = mArray.length) != 0) {
            for (m m10 : mArray) {
                boolean bl3 = m10.a(k10);
                if (!bl3) continue;
                return bl2;
            }
            return false;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("emulatedFilters=");
        String string2 = Arrays.toString(this.a);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

