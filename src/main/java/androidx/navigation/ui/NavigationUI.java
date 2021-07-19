/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.navigation.ui;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator$Destination;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptions$Builder;
import androidx.navigation.ui.ActionBarOnDestinationChangedListener;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration$Builder;
import androidx.navigation.ui.CollapsingToolbarOnDestinationChangedListener;
import androidx.navigation.ui.NavigationUI$1;
import androidx.navigation.ui.NavigationUI$2;
import androidx.navigation.ui.NavigationUI$4;
import androidx.navigation.ui.NavigationUI$6;
import androidx.navigation.ui.R$anim;
import androidx.navigation.ui.R$animator;
import androidx.navigation.ui.ToolbarOnDestinationChangedListener;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class NavigationUI {
    private NavigationUI() {
    }

    public static BottomSheetBehavior findBottomSheetBehavior(View object) {
        Object object2 = object.getLayoutParams();
        boolean bl2 = object2 instanceof CoordinatorLayout$LayoutParams;
        if (!bl2) {
            boolean bl3 = (object = object.getParent()) instanceof View;
            if (bl3) {
                return NavigationUI.findBottomSheetBehavior(object);
            }
            return null;
        }
        object = ((CoordinatorLayout$LayoutParams)((Object)(object2 = (CoordinatorLayout$LayoutParams)((Object)object2)))).getBehavior();
        boolean bl4 = object instanceof BottomSheetBehavior;
        if (!bl4) {
            return null;
        }
        return (BottomSheetBehavior)object;
    }

    public static NavDestination findStartDestination(NavGraph navDestination) {
        int n10;
        while ((n10 = navDestination instanceof NavGraph) != 0) {
            n10 = navDestination.getStartDestination();
            navDestination = navDestination.findNode(n10);
        }
        return navDestination;
    }

    public static boolean matchDestination(NavDestination navDestination, int n10) {
        NavGraph navGraph;
        int n11;
        while ((n11 = navDestination.getId()) != n10 && (navGraph = navDestination.getParent()) != null) {
            navDestination = navDestination.getParent();
        }
        int n12 = navDestination.getId();
        if (n12 == n10) {
            n12 = 1;
        } else {
            n12 = 0;
            navDestination = null;
        }
        return n12 != 0;
    }

    public static boolean matchDestinations(NavDestination navDestination, Set set) {
        do {
            Integer n10;
            boolean bl2;
            if (!(bl2 = set.contains(n10 = Integer.valueOf(navDestination.getId())))) continue;
            return true;
        } while ((navDestination = navDestination.getParent()) != null);
        return false;
    }

    public static boolean navigateUp(NavController navController, Openable object) {
        NavGraph navGraph = navController.getGraph();
        AppBarConfiguration$Builder appBarConfiguration$Builder = new AppBarConfiguration$Builder(navGraph);
        object = appBarConfiguration$Builder.setOpenableLayout((Openable)object).build();
        return NavigationUI.navigateUp(navController, (AppBarConfiguration)object);
    }

    public static boolean navigateUp(NavController object, AppBarConfiguration appBarConfiguration) {
        boolean bl2;
        Openable openable = appBarConfiguration.getOpenableLayout();
        NavDestination navDestination = ((NavController)object).getCurrentDestination();
        Set set = appBarConfiguration.getTopLevelDestinations();
        boolean bl3 = true;
        if (openable != null && navDestination != null && (bl2 = NavigationUI.matchDestinations(navDestination, set))) {
            openable.open();
            return bl3;
        }
        boolean bl4 = ((NavController)object).navigateUp();
        if (bl4) {
            return bl3;
        }
        object = appBarConfiguration.getFallbackOnNavigateUpListener();
        if (object != null) {
            return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
        }
        return false;
    }

    public static boolean onNavDestinationSelected(MenuItem menuItem, NavController navController) {
        int n10;
        Object object = new NavOptions$Builder();
        boolean bl2 = true;
        object = ((NavOptions$Builder)object).setLaunchSingleTop(bl2);
        Object object2 = navController.getCurrentDestination().getParent();
        int n11 = menuItem.getItemId();
        int n12 = (object2 = ((NavGraph)object2).findNode(n11)) instanceof ActivityNavigator.Destination;
        if (n12 != 0) {
            n12 = R$anim.nav_default_enter_anim;
            object2 = ((NavOptions$Builder)object).setEnterAnim(n12);
            n11 = R$anim.nav_default_exit_anim;
            object2 = ((NavOptions$Builder)object2).setExitAnim(n11);
            n11 = R$anim.nav_default_pop_enter_anim;
            object2 = ((NavOptions$Builder)object2).setPopEnterAnim(n11);
            n11 = R$anim.nav_default_pop_exit_anim;
            ((NavOptions$Builder)object2).setPopExitAnim(n11);
        } else {
            n12 = R$animator.nav_default_enter_anim;
            object2 = ((NavOptions$Builder)object).setEnterAnim(n12);
            n11 = R$animator.nav_default_exit_anim;
            object2 = ((NavOptions$Builder)object2).setExitAnim(n11);
            n11 = R$animator.nav_default_pop_enter_anim;
            object2 = ((NavOptions$Builder)object2).setPopEnterAnim(n11);
            n11 = R$animator.nav_default_pop_exit_anim;
            ((NavOptions$Builder)object2).setPopExitAnim(n11);
        }
        n12 = menuItem.getOrder() & 0x30000;
        n11 = 0;
        if (n12 == 0) {
            object2 = NavigationUI.findStartDestination(navController.getGraph());
            n12 = ((NavDestination)object2).getId();
            ((NavOptions$Builder)object).setPopUpTo(n12, false);
        }
        object = ((NavOptions$Builder)object).build();
        try {
            n10 = menuItem.getItemId();
            n12 = 0;
            object2 = null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
        navController.navigate(n10, null, (NavOptions)object);
        return bl2;
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController) {
        NavGraph navGraph = navController.getGraph();
        Object object = new AppBarConfiguration$Builder(navGraph);
        object = ((AppBarConfiguration$Builder)object).build();
        NavigationUI.setupActionBarWithNavController(appCompatActivity, navController, (AppBarConfiguration)object);
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, Openable object) {
        NavGraph navGraph = navController.getGraph();
        AppBarConfiguration$Builder appBarConfiguration$Builder = new AppBarConfiguration$Builder(navGraph);
        object = appBarConfiguration$Builder.setOpenableLayout((Openable)object).build();
        NavigationUI.setupActionBarWithNavController(appCompatActivity, navController, (AppBarConfiguration)object);
    }

    public static void setupActionBarWithNavController(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration) {
        ActionBarOnDestinationChangedListener actionBarOnDestinationChangedListener = new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration);
        navController.addOnDestinationChangedListener(actionBarOnDestinationChangedListener);
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController) {
        NavGraph navGraph = navController.getGraph();
        Object object = new AppBarConfiguration$Builder(navGraph);
        object = ((AppBarConfiguration$Builder)object).build();
        NavigationUI.setupWithNavController(toolbar, navController, (AppBarConfiguration)object);
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController, Openable object) {
        NavGraph navGraph = navController.getGraph();
        AppBarConfiguration$Builder appBarConfiguration$Builder = new AppBarConfiguration$Builder(navGraph);
        object = appBarConfiguration$Builder.setOpenableLayout((Openable)object).build();
        NavigationUI.setupWithNavController(toolbar, navController, (AppBarConfiguration)object);
    }

    public static void setupWithNavController(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        Object object = new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration);
        navController.addOnDestinationChangedListener((NavController$OnDestinationChangedListener)object);
        object = new NavigationUI$1(navController, appBarConfiguration);
        toolbar.setNavigationOnClickListener((View.OnClickListener)object);
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController) {
        NavGraph navGraph = navController.getGraph();
        Object object = new AppBarConfiguration$Builder(navGraph);
        object = ((AppBarConfiguration$Builder)object).build();
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, (AppBarConfiguration)object);
    }

    public static void setupWithNavController(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, Openable object) {
        NavGraph navGraph = navController.getGraph();
        AppBarConfiguration$Builder appBarConfiguration$Builder = new AppBarConfiguration$Builder(navGraph);
        object = appBarConfiguration$Builder.setOpenableLayout((Openable)object).build();
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, (AppBarConfiguration)object);
    }

    public static void setupWithNavController(CollapsingToolbarLayout object, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration) {
        CollapsingToolbarOnDestinationChangedListener collapsingToolbarOnDestinationChangedListener = new CollapsingToolbarOnDestinationChangedListener((CollapsingToolbarLayout)((Object)object), toolbar, appBarConfiguration);
        navController.addOnDestinationChangedListener(collapsingToolbarOnDestinationChangedListener);
        object = new NavigationUI$2(navController, appBarConfiguration);
        toolbar.setNavigationOnClickListener((View.OnClickListener)object);
    }

    public static void setupWithNavController(BottomNavigationView object, NavController navController) {
        WeakReference<BottomNavigationView> weakReference = new WeakReference<BottomNavigationView>(navController);
        object.setOnNavigationItemSelectedListener((BottomNavigationView$OnNavigationItemSelectedListener)((Object)weakReference));
        weakReference = new WeakReference<BottomNavigationView>((BottomNavigationView)((Object)object));
        object = new NavigationUI$6(weakReference, navController);
        navController.addOnDestinationChangedListener((NavController$OnDestinationChangedListener)object);
    }

    public static void setupWithNavController(NavigationView object, NavController navController) {
        WeakReference<NavigationView> weakReference = new WeakReference<NavigationView>(navController, object);
        object.setNavigationItemSelectedListener((NavigationView$OnNavigationItemSelectedListener)((Object)weakReference));
        weakReference = new WeakReference<NavigationView>((NavigationView)((Object)object));
        object = new NavigationUI$4(weakReference, navController);
        navController.addOnDestinationChangedListener((NavController$OnDestinationChangedListener)object);
    }
}

