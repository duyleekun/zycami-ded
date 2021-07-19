/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.y0.a;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import com.zhiyun.cama.device.active.ActivationActivity;

public final class a
implements NavController$OnDestinationChangedListener {
    public final /* synthetic */ ActivationActivity a;

    public /* synthetic */ a(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.a.h(navController, navDestination, bundle);
    }
}

