/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecyclerView$LayoutParams
extends ViewGroup.MarginLayoutParams {
    public final Rect mDecorInsets;
    public boolean mInsetsDirty;
    public boolean mPendingInvalidate;
    public RecyclerView$ViewHolder mViewHolder;

    public RecyclerView$LayoutParams(int n10, int n11) {
        super(n10, n11);
        Rect rect;
        this.mDecorInsets = rect = new Rect();
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super();
        this.mDecorInsets = context;
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        super();
        this.mDecorInsets = layoutParams;
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        super();
        this.mDecorInsets = marginLayoutParams;
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public RecyclerView$LayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        super((ViewGroup.LayoutParams)recyclerView$LayoutParams);
        super();
        this.mDecorInsets = recyclerView$LayoutParams;
        this.mInsetsDirty = true;
        this.mPendingInvalidate = false;
    }

    public int getAbsoluteAdapterPosition() {
        return this.mViewHolder.getAbsoluteAdapterPosition();
    }

    public int getBindingAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    public int getViewAdapterPosition() {
        return this.mViewHolder.getBindingAdapterPosition();
    }

    public int getViewLayoutPosition() {
        return this.mViewHolder.getLayoutPosition();
    }

    public int getViewPosition() {
        return this.mViewHolder.getPosition();
    }

    public boolean isItemChanged() {
        return this.mViewHolder.isUpdated();
    }

    public boolean isItemRemoved() {
        return this.mViewHolder.isRemoved();
    }

    public boolean isViewInvalid() {
        return this.mViewHolder.isInvalid();
    }

    public boolean viewNeedsUpdate() {
        return this.mViewHolder.needsUpdate();
    }
}

