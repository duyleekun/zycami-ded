/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;

public class DialogCompat {
    private DialogCompat() {
    }

    public static View requireViewById(Dialog object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            return object.requireViewById(n10);
        }
        if ((object = object.findViewById(n10)) != null) {
            return object;
        }
        object = new IllegalArgumentException("ID does not reference a View inside this Dialog");
        throw object;
    }
}

