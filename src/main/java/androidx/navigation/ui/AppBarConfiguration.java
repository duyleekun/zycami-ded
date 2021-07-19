/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration$1;
import androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener;
import java.util.Set;

public final class AppBarConfiguration {
    private final AppBarConfiguration$OnNavigateUpListener mFallbackOnNavigateUpListener;
    private final Openable mOpenableLayout;
    private final Set mTopLevelDestinations;

    private AppBarConfiguration(Set set, Openable openable, AppBarConfiguration$OnNavigateUpListener appBarConfiguration$OnNavigateUpListener) {
        this.mTopLevelDestinations = set;
        this.mOpenableLayout = openable;
        this.mFallbackOnNavigateUpListener = appBarConfiguration$OnNavigateUpListener;
    }

    public /* synthetic */ AppBarConfiguration(Set set, Openable openable, AppBarConfiguration$OnNavigateUpListener appBarConfiguration$OnNavigateUpListener, AppBarConfiguration$1 appBarConfiguration$1) {
        this(set, openable, appBarConfiguration$OnNavigateUpListener);
    }

    public DrawerLayout getDrawerLayout() {
        Openable openable = this.mOpenableLayout;
        boolean bl2 = openable instanceof DrawerLayout;
        if (bl2) {
            return (DrawerLayout)openable;
        }
        return null;
    }

    public AppBarConfiguration$OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.mFallbackOnNavigateUpListener;
    }

    public Openable getOpenableLayout() {
        return this.mOpenableLayout;
    }

    public Set getTopLevelDestinations() {
        return this.mTopLevelDestinations;
    }
}

