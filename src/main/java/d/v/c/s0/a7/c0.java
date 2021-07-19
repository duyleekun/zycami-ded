/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.s0.a7;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import d.v.c.s0.a7.f1;

public final class c0
implements NavController$OnDestinationChangedListener {
    public final /* synthetic */ f1 a;

    public /* synthetic */ c0(f1 f12) {
        this.a = f12;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.a.K(navController, navDestination, bundle);
    }
}

