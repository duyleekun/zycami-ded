/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation$1;
import androidx.navigation.Navigation$2;
import androidx.navigation.R$id;
import java.lang.ref.WeakReference;

public final class Navigation {
    private Navigation() {
    }

    public static View.OnClickListener createNavigateOnClickListener(int n10) {
        return Navigation.createNavigateOnClickListener(n10, null);
    }

    public static View.OnClickListener createNavigateOnClickListener(int n10, Bundle bundle) {
        Navigation$1 navigation$1 = new Navigation$1(n10, bundle);
        return navigation$1;
    }

    public static View.OnClickListener createNavigateOnClickListener(NavDirections navDirections) {
        Navigation$2 navigation$2 = new Navigation$2(navDirections);
        return navigation$2;
    }

    public static NavController findNavController(Activity object, int n10) {
        Object object2 = Navigation.findViewNavController(ActivityCompat.requireViewById(object, n10));
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Activity ");
        stringBuilder.append(object);
        stringBuilder.append(" does not have a NavController set on ");
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public static NavController findNavController(View object) {
        Object object2 = Navigation.findViewNavController(object);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" does not have a NavController set");
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    private static NavController findViewNavController(View view) {
        while (view != null) {
            NavController navController = Navigation.getViewNavController(view);
            if (navController != null) {
                return navController;
            }
            boolean bl2 = (view = view.getParent()) instanceof View;
            if (bl2) continue;
            view = null;
        }
        return null;
    }

    private static NavController getViewNavController(View object) {
        int n10 = R$id.nav_controller_view_tag;
        object = (n10 = (object = object.getTag(n10)) instanceof WeakReference) != 0 ? (NavController)((WeakReference)object).get() : ((n10 = object instanceof NavController) != 0 ? (NavController)object : null);
        return object;
    }

    public static void setViewNavController(View view, NavController navController) {
        int n10 = R$id.nav_controller_view_tag;
        view.setTag(n10, (Object)navController);
    }
}

