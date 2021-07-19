/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.navigation.ui;

import android.view.MenuItem;
import android.view.View;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener;

public class NavigationUI$3
implements NavigationView$OnNavigationItemSelectedListener {
    public final /* synthetic */ NavController val$navController;
    public final /* synthetic */ NavigationView val$navigationView;

    public NavigationUI$3(NavController navController, NavigationView navigationView) {
        this.val$navController = navController;
        this.val$navigationView = navigationView;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Object object = this.val$navController;
        boolean bl2 = NavigationUI.onNavDestinationSelected(menuItem, (NavController)object);
        if (bl2) {
            object = this.val$navigationView.getParent();
            int n10 = object instanceof Openable;
            if (n10 != 0) {
                object = (Openable)object;
                object.close();
            } else {
                object = NavigationUI.findBottomSheetBehavior((View)this.val$navigationView);
                if (object != null) {
                    n10 = 5;
                    ((BottomSheetBehavior)object).setState(n10);
                }
            }
        }
        return bl2;
    }
}

