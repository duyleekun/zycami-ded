/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.x1;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class l {
    public static void a(View view, int n10) {
        Navigation.findNavController(view).navigate(n10);
    }

    public static void b(View view, int n10, Bundle bundle) {
        Navigation.findNavController(view).navigate(n10, bundle);
    }

    public static void c(View view, NavDirections navDirections) {
        Navigation.findNavController(view).navigate(navDirections);
    }

    public static void d(Fragment fragment, int n10) {
        NavHostFragment.findNavController(fragment).navigate(n10);
    }

    public static void e(Fragment fragment, int n10, Bundle bundle) {
        NavHostFragment.findNavController(fragment).navigate(n10, bundle);
    }

    public static void f(Fragment fragment, NavDirections navDirections) {
        NavHostFragment.findNavController(fragment).navigate(navDirections);
    }

    public static boolean g(View view) {
        return Navigation.findNavController(view).navigateUp();
    }

    public static boolean h(Fragment fragment) {
        return NavHostFragment.findNavController(fragment).navigateUp();
    }
}

