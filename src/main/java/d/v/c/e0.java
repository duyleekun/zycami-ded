/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.view.View
 */
package d.v.c;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import d.c.a.c;
import d.c.a.d;
import d.v.c.h0;
import java.io.File;

public final class e0 {
    private e0() {
    }

    public static c a(Context context) {
        return c.d(context);
    }

    public static File b(Context context) {
        return c.k(context);
    }

    public static File c(Context context, String string2) {
        return c.l(context, string2);
    }

    public static void d(Context context, d d10) {
        c.p(context, d10);
    }

    public static void e(c c10) {
        c.q(c10);
    }

    public static void f() {
        c.x();
    }

    public static h0 g(Activity activity) {
        return (h0)c.B(activity);
    }

    public static h0 h(Fragment fragment) {
        return (h0)c.C(fragment);
    }

    public static h0 i(Context context) {
        return (h0)c.D(context);
    }

    public static h0 j(View view) {
        return (h0)c.E(view);
    }

    public static h0 k(androidx.fragment.app.Fragment fragment) {
        return (h0)c.F(fragment);
    }

    public static h0 l(FragmentActivity fragmentActivity) {
        return (h0)c.G(fragmentActivity);
    }
}

