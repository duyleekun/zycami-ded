/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;

public class NavDestination$DeepLinkMatch
implements Comparable {
    private final NavDestination mDestination;
    private final boolean mHasMatchingAction;
    private final boolean mIsExactDeepLink;
    private final Bundle mMatchingArgs;
    private final int mMimeTypeMatchLevel;

    public NavDestination$DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean bl2, boolean bl3, int n10) {
        this.mDestination = navDestination;
        this.mMatchingArgs = bundle;
        this.mIsExactDeepLink = bl2;
        this.mHasMatchingAction = bl3;
        this.mMimeTypeMatchLevel = n10;
    }

    public int compareTo(NavDestination$DeepLinkMatch navDestination$DeepLinkMatch) {
        int n10;
        Bundle bundle;
        int n11;
        int n12 = this.mIsExactDeepLink;
        int n13 = 1;
        if (n12 != 0 && (n11 = (int)(navDestination$DeepLinkMatch.mIsExactDeepLink ? 1 : 0)) == 0) {
            return n13;
        }
        n11 = -1;
        if (n12 == 0 && (n12 = navDestination$DeepLinkMatch.mIsExactDeepLink) != 0) {
            return n11;
        }
        Bundle bundle2 = this.mMatchingArgs;
        if (bundle2 != null && (bundle = navDestination$DeepLinkMatch.mMatchingArgs) == null) {
            return n13;
        }
        if (bundle2 == null && (bundle = navDestination$DeepLinkMatch.mMatchingArgs) != null) {
            return n11;
        }
        if (bundle2 != null) {
            n12 = bundle2.size();
            bundle = navDestination$DeepLinkMatch.mMatchingArgs;
            n10 = bundle.size();
            if ((n12 -= n10) > 0) {
                return n13;
            }
            if (n12 < 0) {
                return n11;
            }
        }
        if ((n12 = (int)(this.mHasMatchingAction ? 1 : 0)) != 0 && (n10 = navDestination$DeepLinkMatch.mHasMatchingAction) == 0) {
            return n13;
        }
        if (n12 == 0 && (n12 = (int)(navDestination$DeepLinkMatch.mHasMatchingAction ? 1 : 0)) != 0) {
            return n11;
        }
        n12 = this.mMimeTypeMatchLevel;
        int n14 = navDestination$DeepLinkMatch.mMimeTypeMatchLevel;
        return n12 - n14;
    }

    public NavDestination getDestination() {
        return this.mDestination;
    }

    public Bundle getMatchingArgs() {
        return this.mMatchingArgs;
    }
}

