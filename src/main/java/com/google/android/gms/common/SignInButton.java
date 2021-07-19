/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 */
package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;

public final class SignInButton
extends FrameLayout
implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zaas;
    private View.OnClickListener zaat;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        n10 = 0;
        this.zaat = null;
        context = context.getTheme();
        int[] nArray = R$styleable.SignInButton;
        context = context.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        try {
            int n11 = R$styleable.SignInButton_buttonSize;
            this.mSize = n11 = context.getInt(n11, 0);
            n11 = R$styleable.SignInButton_colorScheme;
            n10 = 2;
            this.mColor = n11 = context.getInt(n11, n10);
            int n12 = this.mSize;
            n11 = this.mColor;
            this.setStyle(n12, n11);
            return;
        }
        finally {
            context.recycle();
        }
    }

    public final void onClick(View view) {
        View view2;
        View.OnClickListener onClickListener = this.zaat;
        if (onClickListener != null && view == (view2 = this.zaas)) {
            onClickListener.onClick((View)this);
        }
    }

    public final void setColorScheme(int n10) {
        int n11 = this.mSize;
        this.setStyle(n11, n10);
    }

    public final void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.zaas.setEnabled(bl2);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zaat = onClickListener;
        onClickListener = this.zaas;
        if (onClickListener != null) {
            onClickListener.setOnClickListener((View.OnClickListener)this);
        }
    }

    public final void setScopes(Scope[] scopeArray) {
        int n10 = this.mSize;
        int n11 = this.mColor;
        this.setStyle(n10, n11);
    }

    public final void setSize(int n10) {
        int n11 = this.mColor;
        this.setStyle(n10, n11);
    }

    public final void setStyle(int n10, int n11) {
        this.mSize = n10;
        this.mColor = n11;
        Context context = this.getContext();
        Object object = this.zaas;
        if (object != null) {
            this.removeView((View)object);
        }
        n11 = this.mSize;
        int n12 = this.mColor;
        object = SignInButtonCreator.createView(context, n11, n12);
        try {
            this.zaas = object;
        }
        catch (RemoteCreator$RemoteCreatorException remoteCreator$RemoteCreatorException) {
            object = "SignInButton";
            String string2 = "Sign in button not found, using placeholder instead";
            Log.w((String)object, (String)string2);
            n11 = this.mSize;
            n12 = this.mColor;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            context = context.getResources();
            signInButtonImpl.configure((Resources)context, n11, n12);
            this.zaas = signInButtonImpl;
        }
        context = this.zaas;
        this.addView((View)context);
        context = this.zaas;
        n11 = (int)(this.isEnabled() ? 1 : 0);
        context.setEnabled(n11 != 0);
        this.zaas.setOnClickListener((View.OnClickListener)this);
    }

    public final void setStyle(int n10, int n11, Scope[] scopeArray) {
        this.setStyle(n10, n11);
    }
}

