/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 */
package androidx.viewpager2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public final class FragmentViewHolder
extends RecyclerView$ViewHolder {
    private FragmentViewHolder(FrameLayout frameLayout) {
        super((View)frameLayout);
    }

    public static FragmentViewHolder create(ViewGroup object) {
        object = object.getContext();
        FrameLayout frameLayout = new FrameLayout((Context)object);
        int n10 = -1;
        object = new ViewGroup.LayoutParams(n10, n10);
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
        int n11 = ViewCompat.generateViewId();
        frameLayout.setId(n11);
        frameLayout.setSaveEnabled(false);
        object = new FragmentViewHolder(frameLayout);
        return object;
    }

    public FrameLayout getContainer() {
        return (FrameLayout)this.itemView;
    }
}

