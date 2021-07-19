/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public interface ChildHelper$Callback {
    public void addView(View var1, int var2);

    public void attachViewToParent(View var1, int var2, ViewGroup.LayoutParams var3);

    public void detachViewFromParent(int var1);

    public View getChildAt(int var1);

    public int getChildCount();

    public RecyclerView$ViewHolder getChildViewHolder(View var1);

    public int indexOfChild(View var1);

    public void onEnteredHiddenState(View var1);

    public void onLeftHiddenState(View var1);

    public void removeAllViews();

    public void removeViewAt(int var1);
}

