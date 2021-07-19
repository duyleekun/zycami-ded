/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener;

public class NavigationUI$5
implements BottomNavigationView$OnNavigationItemSelectedListener {
    public final /* synthetic */ NavController val$navController;

    public NavigationUI$5(NavController navController) {
        this.val$navController = navController;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        NavController navController = this.val$navController;
        return NavigationUI.onNavDestinationSelected(menuItem, navController);
    }
}

