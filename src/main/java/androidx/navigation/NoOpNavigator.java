/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;

public class NoOpNavigator
extends Navigator {
    public NavDestination createDestination() {
        NavDestination navDestination = new NavDestination(this);
        return navDestination;
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator$Extras navigator$Extras) {
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }
}

