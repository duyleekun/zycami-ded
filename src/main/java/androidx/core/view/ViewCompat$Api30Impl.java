/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowInsetsController
 */
package androidx.core.view;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public class ViewCompat$Api30Impl {
    private ViewCompat$Api30Impl() {
    }

    public static WindowInsetsControllerCompat getWindowInsetsController(View object) {
        object = (object = object.getWindowInsetsController()) != null ? WindowInsetsControllerCompat.toWindowInsetsControllerCompat((WindowInsetsController)object) : null;
        return object;
    }
}

