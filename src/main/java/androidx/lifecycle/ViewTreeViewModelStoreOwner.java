/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.R$id;

public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static ViewModelStoreOwner get(View view) {
        boolean bl2;
        int n10 = R$id.view_tree_view_model_store_owner;
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner)view.getTag(n10);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        view = view.getParent();
        while (viewModelStoreOwner == null && (bl2 = view instanceof View)) {
            n10 = R$id.view_tree_view_model_store_owner;
            viewModelStoreOwner = (ViewModelStoreOwner)view.getTag(n10);
            view = view.getParent();
        }
        return viewModelStoreOwner;
    }

    public static void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        int n10 = R$id.view_tree_view_model_store_owner;
        view.setTag(n10, (Object)viewModelStoreOwner);
    }
}

