/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MenuItem
 */
package androidx.navigation.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.ref.WeakReference;

public class NavigationUI$6
implements NavController$OnDestinationChangedListener {
    public final /* synthetic */ NavController val$navController;
    public final /* synthetic */ WeakReference val$weakReference;

    public NavigationUI$6(WeakReference weakReference, NavController navController) {
        this.val$weakReference = weakReference;
        this.val$navController = navController;
    }

    public void onDestinationChanged(NavController object, NavDestination navDestination, Bundle bundle) {
        object = (BottomNavigationView)((Object)this.val$weakReference.get());
        if (object == null) {
            this.val$navController.removeOnDestinationChangedListener(this);
            return;
        }
        object = ((BottomNavigationView)((Object)object)).getMenu();
        int n10 = object.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuItem menuItem = object.getItem(i10);
            boolean bl2 = menuItem.getItemId();
            if (!(bl2 = (boolean)NavigationUI.matchDestination(navDestination, (int)(bl2 ? 1 : 0)))) continue;
            bl2 = true;
            menuItem.setChecked(bl2);
        }
    }
}

