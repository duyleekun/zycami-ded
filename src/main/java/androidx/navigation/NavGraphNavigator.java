/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;
import androidx.navigation.NavigatorProvider;

public class NavGraphNavigator
extends Navigator {
    private final NavigatorProvider mNavigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    public NavGraph createDestination() {
        NavGraph navGraph = new NavGraph(this);
        return navGraph;
    }

    public NavDestination navigate(NavGraph object, Bundle object2, NavOptions object3, Navigator$Extras navigator$Extras) {
        int n10 = ((NavGraph)object).getStartDestination();
        if (n10 != 0) {
            String string2 = null;
            NavDestination navDestination = ((NavGraph)object).findNode(n10, false);
            if (navDestination != null) {
                object = this.mNavigatorProvider;
                string2 = navDestination.getNavigatorName();
                object = ((NavigatorProvider)object).getNavigator(string2);
                object2 = navDestination.addInDefaultArgs((Bundle)object2);
                return ((Navigator)object).navigate(navDestination, (Bundle)object2, (NavOptions)object3, navigator$Extras);
            }
            object = ((NavGraph)object).getStartDestDisplayName();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("navigation destination ");
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(" is not a direct child of this NavGraph");
            object = ((StringBuilder)object3).toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("no start destination defined via app:startDestination for ");
        object = ((NavGraph)object).getDisplayName();
        ((StringBuilder)object3).append((String)object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public boolean popBackStack() {
        return true;
    }
}

