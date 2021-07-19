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
import androidx.navigation.Navigator$Extras;

public abstract class Navigator {
    public abstract NavDestination createDestination();

    public abstract NavDestination navigate(NavDestination var1, Bundle var2, NavOptions var3, Navigator$Extras var4);

    public void onRestoreState(Bundle bundle) {
    }

    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();
}

