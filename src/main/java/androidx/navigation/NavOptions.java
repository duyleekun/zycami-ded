/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

public final class NavOptions {
    private int mEnterAnim;
    private int mExitAnim;
    private int mPopEnterAnim;
    private int mPopExitAnim;
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    public NavOptions(boolean bl2, int n10, boolean bl3, int n11, int n12, int n13, int n14) {
        this.mSingleTop = bl2;
        this.mPopUpTo = n10;
        this.mPopUpToInclusive = bl3;
        this.mEnterAnim = n11;
        this.mExitAnim = n12;
        this.mPopEnterAnim = n13;
        this.mPopExitAnim = n14;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<NavOptions> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = NavOptions.class) == (clazz = object.getClass())) {
            int n10;
            object = (NavOptions)object;
            int n11 = this.mSingleTop;
            int n12 = ((NavOptions)object).mSingleTop;
            if (n11 != n12 || (n11 = this.mPopUpTo) != (n12 = ((NavOptions)object).mPopUpTo) || (n11 = (int)(this.mPopUpToInclusive ? 1 : 0)) != (n12 = (int)(((NavOptions)object).mPopUpToInclusive ? 1 : 0)) || (n11 = this.mEnterAnim) != (n12 = ((NavOptions)object).mEnterAnim) || (n11 = this.mExitAnim) != (n12 = ((NavOptions)object).mExitAnim) || (n11 = this.mPopEnterAnim) != (n12 = ((NavOptions)object).mPopEnterAnim) || (n11 = this.mPopExitAnim) != (n10 = ((NavOptions)object).mPopExitAnim)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    public int getExitAnim() {
        return this.mExitAnim;
    }

    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public int hashCode() {
        int n10 = this.shouldLaunchSingleTop() * 31;
        int n11 = this.getPopUpTo();
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.isPopUpToInclusive() ? 1 : 0);
        n10 = (n10 + n11) * 31;
        n11 = this.getEnterAnim();
        n10 = (n10 + n11) * 31;
        n11 = this.getExitAnim();
        n10 = (n10 + n11) * 31;
        n11 = this.getPopEnterAnim();
        n10 = (n10 + n11) * 31;
        n11 = this.getPopExitAnim();
        return n10 + n11;
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }
}

