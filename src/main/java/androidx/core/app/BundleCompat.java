/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BundleCompat$BundleCompatBaseImpl;

public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return bundle.getBinder(string2);
        }
        return BundleCompat$BundleCompatBaseImpl.getBinder(bundle, string2);
    }

    public static void putBinder(Bundle bundle, String string2, IBinder iBinder) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            bundle.putBinder(string2, iBinder);
        } else {
            BundleCompat$BundleCompatBaseImpl.putBinder(bundle, string2, iBinder);
        }
    }
}

