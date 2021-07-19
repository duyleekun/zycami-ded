/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R$id;
import com.yalantis.ucrop.R$layout;
import com.yalantis.ucrop.R$styleable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView$a;
import com.yalantis.ucrop.view.UCropView$b;
import d.t.a.f.c;
import d.t.a.f.d;
import d.t.a.j.a;

public class UCropView
extends FrameLayout {
    private GestureCropImageView a;
    private final OverlayView b;

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object = LayoutInflater.from((Context)context);
        int n11 = R$layout.ucrop_view;
        object.inflate(n11, (ViewGroup)this, true);
        n10 = R$id.image_view_crop;
        object = (GestureCropImageView)this.findViewById(n10);
        this.a = object;
        n10 = R$id.view_overlay;
        object = (OverlayView)this.findViewById(n10);
        this.b = object;
        int[] nArray = R$styleable.ucrop_UCropView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        ((OverlayView)((Object)object)).h((TypedArray)context);
        this.a.z((TypedArray)context);
        context.recycle();
        this.d();
    }

    public static /* synthetic */ OverlayView a(UCropView uCropView) {
        return uCropView.b;
    }

    public static /* synthetic */ GestureCropImageView b(UCropView uCropView) {
        return uCropView.a;
    }

    private void d() {
        Object object = this.a;
        Object object2 = new UCropView$a(this);
        ((a)object).setCropBoundsChangeListener((c)object2);
        object = this.b;
        object2 = new UCropView$b(this);
        ((OverlayView)((Object)object)).setOverlayViewChangeListener((d)object2);
    }

    public void c() {
        GestureCropImageView gestureCropImageView = this.a;
        this.removeView((View)gestureCropImageView);
        Context context = this.getContext();
        this.a = gestureCropImageView = new GestureCropImageView(context);
        this.d();
        gestureCropImageView = this.a;
        context = this.getOverlayView().getCropViewRect();
        gestureCropImageView.setCropRect((RectF)context);
        gestureCropImageView = this.a;
        this.addView((View)gestureCropImageView, 0);
    }

    public GestureCropImageView getCropImageView() {
        return this.a;
    }

    public OverlayView getOverlayView() {
        return this.b;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

