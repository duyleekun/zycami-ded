/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavOptions;

public final class NavAction {
    private Bundle mDefaultArguments;
    private final int mDestinationId;
    private NavOptions mNavOptions;

    public NavAction(int n10) {
        this(n10, null);
    }

    public NavAction(int n10, NavOptions navOptions) {
        this(n10, navOptions, null);
    }

    public NavAction(int n10, NavOptions navOptions, Bundle bundle) {
        this.mDestinationId = n10;
        this.mNavOptions = navOptions;
        this.mDefaultArguments = bundle;
    }

    public Bundle getDefaultArguments() {
        return this.mDefaultArguments;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    public NavOptions getNavOptions() {
        return this.mNavOptions;
    }

    public void setDefaultArguments(Bundle bundle) {
        this.mDefaultArguments = bundle;
    }

    public void setNavOptions(NavOptions navOptions) {
        this.mNavOptions = navOptions;
    }
}

