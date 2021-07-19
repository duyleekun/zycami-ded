/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;

public class NavDeepLinkBuilder$PermissiveNavigatorProvider$1
extends Navigator {
    public final /* synthetic */ NavDeepLinkBuilder$PermissiveNavigatorProvider this$0;

    public NavDeepLinkBuilder$PermissiveNavigatorProvider$1(NavDeepLinkBuilder$PermissiveNavigatorProvider navDeepLinkBuilder$PermissiveNavigatorProvider) {
        this.this$0 = navDeepLinkBuilder$PermissiveNavigatorProvider;
    }

    public NavDestination createDestination() {
        NavDestination navDestination = new NavDestination("permissive");
        return navDestination;
    }

    public NavDestination navigate(NavDestination object, Bundle bundle, NavOptions navOptions, Navigator$Extras navigator$Extras) {
        object = new IllegalStateException("navigate is not supported");
        throw object;
    }

    public boolean popBackStack() {
        IllegalStateException illegalStateException = new IllegalStateException("popBackStack is not supported");
        throw illegalStateException;
    }
}

