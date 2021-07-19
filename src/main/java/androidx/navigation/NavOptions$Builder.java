/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.NavOptions;

public final class NavOptions$Builder {
    public int mEnterAnim;
    public int mExitAnim;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public int mPopUpTo;
    public boolean mPopUpToInclusive;
    public boolean mSingleTop;

    public NavOptions$Builder() {
        int n10;
        this.mPopUpTo = n10 = -1;
        this.mEnterAnim = n10;
        this.mExitAnim = n10;
        this.mPopEnterAnim = n10;
        this.mPopExitAnim = n10;
    }

    public NavOptions build() {
        boolean bl2 = this.mSingleTop;
        int n10 = this.mPopUpTo;
        boolean bl3 = this.mPopUpToInclusive;
        int n11 = this.mEnterAnim;
        int n12 = this.mExitAnim;
        int n13 = this.mPopEnterAnim;
        int n14 = this.mPopExitAnim;
        NavOptions navOptions = new NavOptions(bl2, n10, bl3, n11, n12, n13, n14);
        return navOptions;
    }

    public NavOptions$Builder setEnterAnim(int n10) {
        this.mEnterAnim = n10;
        return this;
    }

    public NavOptions$Builder setExitAnim(int n10) {
        this.mExitAnim = n10;
        return this;
    }

    public NavOptions$Builder setLaunchSingleTop(boolean bl2) {
        this.mSingleTop = bl2;
        return this;
    }

    public NavOptions$Builder setPopEnterAnim(int n10) {
        this.mPopEnterAnim = n10;
        return this;
    }

    public NavOptions$Builder setPopExitAnim(int n10) {
        this.mPopExitAnim = n10;
        return this;
    }

    public NavOptions$Builder setPopUpTo(int n10, boolean bl2) {
        this.mPopUpTo = n10;
        this.mPopUpToInclusive = bl2;
        return this;
    }
}

