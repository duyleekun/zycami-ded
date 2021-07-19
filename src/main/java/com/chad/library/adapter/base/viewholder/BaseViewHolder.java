/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.util.SparseArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.chad.library.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import f.h2.t.f0;

public class BaseViewHolder
extends RecyclerView$ViewHolder {
    private final SparseArray views;

    public BaseViewHolder(View view) {
        f0.q(view, "view");
        super(view);
        super();
        this.views = view;
    }

    public View findView(int n10) {
        return this.itemView.findViewById(n10);
    }

    public ViewDataBinding getBinding() {
        return DataBindingUtil.getBinding(this.itemView);
    }

    public View getView(int n10) {
        Object object = this.getViewOrNull(n10);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No view found with id ");
        ((StringBuilder)object).append(n10);
        String string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public View getViewOrNull(int n10) {
        View view;
        View view2 = (View)this.views.get(n10);
        if (view2 == null && (view = this.itemView.findViewById(n10)) != null) {
            this.views.put(n10, (Object)view);
            return view;
        }
        n10 = view2 instanceof View;
        if (n10 == 0) {
            view2 = null;
        }
        return view2;
    }

    public BaseViewHolder setBackgroundColor(int n10, int n11) {
        this.getView(n10).setBackgroundColor(n11);
        return this;
    }

    public BaseViewHolder setBackgroundResource(int n10, int n11) {
        this.getView(n10).setBackgroundResource(n11);
        return this;
    }

    public BaseViewHolder setEnabled(int n10, boolean bl2) {
        this.getView(n10).setEnabled(bl2);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public BaseViewHolder setGone(int n10, boolean bl2) {
        void var2_5;
        View view = this.getView(n10);
        if (bl2) {
            int n11 = 8;
        } else {
            boolean bl3 = false;
        }
        view.setVisibility((int)var2_5);
        return this;
    }

    public BaseViewHolder setImageBitmap(int n10, Bitmap bitmap) {
        ((ImageView)this.getView(n10)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int n10, Drawable drawable2) {
        ((ImageView)this.getView(n10)).setImageDrawable(drawable2);
        return this;
    }

    public BaseViewHolder setImageResource(int n10, int n11) {
        ((ImageView)this.getView(n10)).setImageResource(n11);
        return this;
    }

    public BaseViewHolder setText(int n10, int n11) {
        ((TextView)this.getView(n10)).setText(n11);
        return this;
    }

    public BaseViewHolder setText(int n10, CharSequence charSequence) {
        ((TextView)this.getView(n10)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int n10, int n11) {
        ((TextView)this.getView(n10)).setTextColor(n11);
        return this;
    }

    public BaseViewHolder setTextColorRes(int n10, int n11) {
        TextView textView = (TextView)this.getView(n10);
        View view = this.itemView;
        f0.h(view, "itemView");
        n11 = view.getResources().getColor(n11);
        textView.setTextColor(n11);
        return this;
    }

    public BaseViewHolder setVisible(int n10, boolean n11) {
        View view = this.getView(n10);
        n11 = n11 != 0 ? 0 : 4;
        view.setVisibility(n11);
        return this;
    }
}

