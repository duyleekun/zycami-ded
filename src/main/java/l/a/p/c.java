/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package l.a.p;

import android.os.Build;
import android.view.View;

public class c {
    public static boolean a(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 >= n11) {
            return view.hasOnClickListeners();
        }
        return false;
    }
}

