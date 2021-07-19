/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 */
package androidx.databinding.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewAdded;
import androidx.databinding.adapters.ViewGroupBindingAdapter$OnChildViewRemoved;

public final class ViewGroupBindingAdapter$1
implements ViewGroup.OnHierarchyChangeListener {
    public final /* synthetic */ ViewGroupBindingAdapter$OnChildViewAdded val$added;
    public final /* synthetic */ ViewGroupBindingAdapter$OnChildViewRemoved val$removed;

    public ViewGroupBindingAdapter$1(ViewGroupBindingAdapter$OnChildViewAdded onChildViewAdded, ViewGroupBindingAdapter$OnChildViewRemoved onChildViewRemoved) {
        this.val$added = onChildViewAdded;
        this.val$removed = onChildViewRemoved;
    }

    public void onChildViewAdded(View view, View view2) {
        ViewGroupBindingAdapter$OnChildViewAdded viewGroupBindingAdapter$OnChildViewAdded = this.val$added;
        if (viewGroupBindingAdapter$OnChildViewAdded != null) {
            viewGroupBindingAdapter$OnChildViewAdded.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        ViewGroupBindingAdapter$OnChildViewRemoved viewGroupBindingAdapter$OnChildViewRemoved = this.val$removed;
        if (viewGroupBindingAdapter$OnChildViewRemoved != null) {
            viewGroupBindingAdapter$OnChildViewRemoved.onChildViewRemoved(view, view2);
        }
    }
}

