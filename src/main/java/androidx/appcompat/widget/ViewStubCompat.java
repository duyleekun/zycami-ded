/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ViewStubCompat$OnInflateListener;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
extends View {
    private ViewStubCompat$OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource = 0;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int[] nArray = R$styleable.ViewStubCompat;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        int n11 = R$styleable.ViewStubCompat_android_inflatedId;
        n10 = -1;
        this.mInflatedId = n11 = context.getResourceId(n11, n10);
        n11 = R$styleable.ViewStubCompat_android_layout;
        this.mLayoutResource = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.ViewStubCompat_android_id;
        n11 = context.getResourceId(n11, n10);
        this.setId(n11);
        context.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        Object object = this.getParent();
        int n10 = object instanceof ViewGroup;
        if (n10 != 0) {
            n10 = this.mLayoutResource;
            if (n10 != 0) {
                object = (ViewGroup)object;
                LayoutInflater layoutInflater = this.mInflater;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from((Context)this.getContext());
                }
                int n11 = this.mLayoutResource;
                ViewGroup.LayoutParams layoutParams = null;
                layoutInflater = layoutInflater.inflate(n11, (ViewGroup)object, false);
                n11 = this.mInflatedId;
                int n12 = -1;
                if (n11 != n12) {
                    layoutInflater.setId(n11);
                }
                n11 = object.indexOfChild((View)this);
                object.removeViewInLayout((View)this);
                layoutParams = this.getLayoutParams();
                if (layoutParams != null) {
                    object.addView((View)layoutInflater, n11, layoutParams);
                } else {
                    object.addView((View)layoutInflater, n11);
                }
                object = new WeakReference(layoutInflater);
                this.mInflatedViewRef = object;
                object = this.mInflateListener;
                if (object != null) {
                    object.onInflate(this, (View)layoutInflater);
                }
                return layoutInflater;
            }
            object = new IllegalArgumentException("ViewStub must have a valid layoutResource");
            throw object;
        }
        object = new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        throw object;
    }

    public void onMeasure(int n10, int n11) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int n10) {
        this.mInflatedId = n10;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int n10) {
        this.mLayoutResource = n10;
    }

    public void setOnInflateListener(ViewStubCompat$OnInflateListener viewStubCompat$OnInflateListener) {
        this.mInflateListener = viewStubCompat$OnInflateListener;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setVisibility(int n10) {
        WeakReference weakReference = this.mInflatedViewRef;
        if (weakReference != null) {
            if ((weakReference = (View)weakReference.get()) != null) {
                weakReference.setVisibility(n10);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("setVisibility called on un-referenced view");
            throw illegalStateException;
        }
        super.setVisibility(n10);
        if (n10 != 0) {
            int n11 = 4;
            if (n10 != n11) return;
        }
        this.inflate();
    }
}

