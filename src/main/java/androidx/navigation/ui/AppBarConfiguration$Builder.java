/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 */
package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener;
import androidx.navigation.ui.NavigationUI;
import java.util.HashSet;
import java.util.Set;

public final class AppBarConfiguration$Builder {
    private AppBarConfiguration.OnNavigateUpListener mFallbackOnNavigateUpListener;
    private Openable mOpenableLayout;
    private final Set mTopLevelDestinations;

    public AppBarConfiguration$Builder(Menu menu2) {
        HashSet hashSet;
        this.mTopLevelDestinations = hashSet = new HashSet();
        int n10 = menu2.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = menu2.getItem(i10);
            Set set = this.mTopLevelDestinations;
            int n11 = object.getItemId();
            object = n11;
            set.add(object);
        }
    }

    public AppBarConfiguration$Builder(NavGraph object) {
        HashSet<Object> hashSet;
        this.mTopLevelDestinations = hashSet = new HashSet<Object>();
        object = NavigationUI.findStartDestination((NavGraph)object).getId();
        hashSet.add(object);
    }

    public AppBarConfiguration$Builder(Set set) {
        HashSet hashSet;
        this.mTopLevelDestinations = hashSet = new HashSet();
        hashSet.addAll(set);
    }

    public AppBarConfiguration$Builder(int ... nArray) {
        HashSet hashSet;
        this.mTopLevelDestinations = hashSet = new HashSet();
        for (int n10 : nArray) {
            Set set = this.mTopLevelDestinations;
            Integer n11 = n10;
            set.add(n11);
        }
    }

    public AppBarConfiguration build() {
        Set set = this.mTopLevelDestinations;
        Openable openable = this.mOpenableLayout;
        AppBarConfiguration.OnNavigateUpListener onNavigateUpListener = this.mFallbackOnNavigateUpListener;
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration(set, openable, onNavigateUpListener, null);
        return appBarConfiguration;
    }

    public AppBarConfiguration$Builder setDrawerLayout(DrawerLayout drawerLayout) {
        this.mOpenableLayout = drawerLayout;
        return this;
    }

    public AppBarConfiguration$Builder setFallbackOnNavigateUpListener(AppBarConfiguration.OnNavigateUpListener onNavigateUpListener) {
        this.mFallbackOnNavigateUpListener = onNavigateUpListener;
        return this;
    }

    public AppBarConfiguration$Builder setOpenableLayout(Openable openable) {
        this.mOpenableLayout = openable;
        return this;
    }
}

