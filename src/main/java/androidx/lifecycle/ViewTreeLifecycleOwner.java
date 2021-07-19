/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.runtime.R$id;

public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static LifecycleOwner get(View view) {
        boolean bl2;
        int n10 = R$id.view_tree_lifecycle_owner;
        LifecycleOwner lifecycleOwner = (LifecycleOwner)view.getTag(n10);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        view = view.getParent();
        while (lifecycleOwner == null && (bl2 = view instanceof View)) {
            n10 = R$id.view_tree_lifecycle_owner;
            lifecycleOwner = (LifecycleOwner)view.getTag(n10);
            view = view.getParent();
        }
        return lifecycleOwner;
    }

    public static void set(View view, LifecycleOwner lifecycleOwner) {
        int n10 = R$id.view_tree_lifecycle_owner;
        view.setTag(n10, (Object)lifecycleOwner);
    }
}

