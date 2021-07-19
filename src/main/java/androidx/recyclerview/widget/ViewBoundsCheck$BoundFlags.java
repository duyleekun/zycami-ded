/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class ViewBoundsCheck$BoundFlags {
    public int mBoundFlags = 0;
    public int mChildEnd;
    public int mChildStart;
    public int mRvEnd;
    public int mRvStart;

    public void addFlags(int n10) {
        int n11 = this.mBoundFlags;
        this.mBoundFlags = n10 |= n11;
    }

    public boolean boundsMatch() {
        int n10;
        int n11 = this.mBoundFlags;
        int n12 = n11 & 7;
        if (n12 != 0) {
            n12 = this.mChildStart;
            n10 = this.mRvStart;
            if ((n11 &= (n12 = this.compare(n12, n10) << 0)) == 0) {
                return false;
            }
        }
        if ((n12 = (n11 = this.mBoundFlags) & 0x70) != 0) {
            n12 = this.mChildStart;
            n10 = this.mRvEnd;
            if ((n11 &= (n12 = this.compare(n12, n10) << 4)) == 0) {
                return false;
            }
        }
        if ((n12 = (n11 = this.mBoundFlags) & 0x700) != 0) {
            n12 = this.mChildEnd;
            n10 = this.mRvStart;
            if ((n11 &= (n12 = this.compare(n12, n10) << 8)) == 0) {
                return false;
            }
        }
        if ((n12 = (n11 = this.mBoundFlags) & 0x7000) != 0) {
            n12 = this.mChildEnd;
            n10 = this.mRvEnd;
            if ((n11 &= (n12 = this.compare(n12, n10) << 12)) == 0) {
                return false;
            }
        }
        return true;
    }

    public int compare(int n10, int n11) {
        if (n10 > n11) {
            return 1;
        }
        if (n10 == n11) {
            return 2;
        }
        return 4;
    }

    public void resetFlags() {
        this.mBoundFlags = 0;
    }

    public void setBounds(int n10, int n11, int n12, int n13) {
        this.mRvStart = n10;
        this.mRvEnd = n11;
        this.mChildStart = n12;
        this.mChildEnd = n13;
    }
}

