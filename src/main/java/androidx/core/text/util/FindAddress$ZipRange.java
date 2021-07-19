/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text.util;

public class FindAddress$ZipRange {
    public int mException1;
    public int mException2;
    public int mHigh;
    public int mLow;

    public FindAddress$ZipRange(int n10, int n11, int n12, int n13) {
        this.mLow = n10;
        this.mHigh = n11;
        this.mException1 = n12;
        this.mException2 = n13;
    }

    public boolean matches(String string2) {
        boolean bl2 = false;
        int n10 = this.mLow;
        int n11 = Integer.parseInt(string2 = string2.substring(0, 2));
        if (n10 <= n11 && n11 <= (n10 = this.mHigh) || n11 == (n10 = this.mException1) || n11 == (n10 = this.mException2)) {
            bl2 = true;
        }
        return bl2;
    }
}

