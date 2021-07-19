/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package d.l.a.g;

import android.content.Context;
import android.os.Build;

public class b {
    public static boolean a(Context context, String string2) {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n12 = 23;
        if (n11 >= n12 && (n10 = context.checkSelfPermission(string2)) != 0) {
            bl2 = false;
        }
        return bl2;
    }
}

