/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

public class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart;

    public RtlSpacingHelper() {
        int n10;
        this.mStart = n10 = -1 << -1;
        this.mEnd = n10;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getEnd() {
        int n10 = this.mIsRtl;
        n10 = n10 != 0 ? this.mLeft : this.mRight;
        return n10;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        int n10 = this.mIsRtl;
        n10 = n10 != 0 ? this.mRight : this.mLeft;
        return n10;
    }

    public void setAbsolute(int n10, int n11) {
        this.mIsRelative = false;
        int n12 = -1 << -1;
        if (n10 != n12) {
            this.mExplicitLeft = n10;
            this.mLeft = n10;
        }
        if (n11 != n12) {
            this.mExplicitRight = n11;
            this.mRight = n11;
        }
    }

    public void setDirection(boolean n10) {
        int n11 = this.mIsRtl;
        if (n10 == n11) {
            return;
        }
        this.mIsRtl = n10;
        n11 = this.mIsRelative;
        if (n11 != 0) {
            n11 = -1 << -1;
            if (n10 != 0) {
                n10 = this.mEnd;
                if (n10 == n11) {
                    n10 = this.mExplicitLeft;
                }
                this.mLeft = n10;
                n10 = this.mStart;
                if (n10 == n11) {
                    n10 = this.mExplicitRight;
                }
                this.mRight = n10;
            } else {
                n10 = this.mStart;
                if (n10 == n11) {
                    n10 = this.mExplicitLeft;
                }
                this.mLeft = n10;
                n10 = this.mEnd;
                if (n10 == n11) {
                    n10 = this.mExplicitRight;
                }
                this.mRight = n10;
            }
        } else {
            n10 = this.mExplicitLeft;
            this.mLeft = n10;
            this.mRight = n10 = this.mExplicitRight;
        }
    }

    public void setRelative(int n10, int n11) {
        this.mStart = n10;
        this.mEnd = n11;
        this.mIsRelative = true;
        boolean bl2 = this.mIsRtl;
        int n12 = -1 << -1;
        if (bl2) {
            if (n11 != n12) {
                this.mLeft = n11;
            }
            if (n10 != n12) {
                this.mRight = n10;
            }
        } else {
            if (n10 != n12) {
                this.mLeft = n10;
            }
            if (n11 != n12) {
                this.mRight = n11;
            }
        }
    }
}

