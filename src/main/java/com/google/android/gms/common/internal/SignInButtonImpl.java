/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.Button
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl
extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zaa(int n10, int n11, int n12, int n13) {
        if (n10 != 0) {
            n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    return n13;
                }
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Unknown color scheme: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            return n12;
        }
        return n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void configure(Resources object, int n10, int n11) {
        int n12;
        int n13;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        this.setTypeface(typeface);
        this.setTextSize(14.0f);
        typeface = object.getDisplayMetrics();
        float f10 = typeface.density * 48.0f;
        float f11 = 0.5f;
        int n14 = (int)(f10 += f11);
        this.setMinHeight(n14);
        this.setMinWidth(n14);
        n14 = R$drawable.common_google_signin_btn_icon_dark;
        int n15 = R$drawable.common_google_signin_btn_icon_light;
        n14 = SignInButtonImpl.zaa(n13, n14, n15, n15);
        n15 = R$drawable.common_google_signin_btn_text_dark;
        int n16 = R$drawable.common_google_signin_btn_text_light;
        n15 = SignInButtonImpl.zaa(n13, n15, n16, n16);
        String string2 = "Unknown button size: ";
        int n17 = 32;
        int n18 = 2;
        int n19 = 1;
        if (n12 != 0 && n12 != n19) {
            if (n12 != n18) {
                StringBuilder stringBuilder = new StringBuilder(n17);
                stringBuilder.append(string2);
                stringBuilder.append(n12);
                String string3 = stringBuilder.toString();
                IllegalStateException illegalStateException = new IllegalStateException(string3);
                throw illegalStateException;
            }
        } else {
            n14 = n15;
        }
        typeface = DrawableCompat.wrap(object.getDrawable(n14));
        n15 = R$color.common_google_signin_btn_tint;
        ColorStateList colorStateList = object.getColorStateList(n15);
        DrawableCompat.setTintList((Drawable)typeface, colorStateList);
        colorStateList = PorterDuff.Mode.SRC_ATOP;
        DrawableCompat.setTintMode((Drawable)typeface, (PorterDuff.Mode)colorStateList);
        this.setBackgroundDrawable((Drawable)typeface);
        n14 = R$color.common_google_signin_btn_text_dark;
        n15 = R$color.common_google_signin_btn_text_light;
        n13 = SignInButtonImpl.zaa(n13, n14, n15, n15);
        Object object2 = (ColorStateList)Preconditions.checkNotNull(object.getColorStateList(n13));
        this.setTextColor((ColorStateList)object2);
        n13 = 0;
        object2 = null;
        if (n12 != 0) {
            if (n12 != n19) {
                if (n12 != n18) {
                    object2 = new StringBuilder(n17);
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(n12);
                    String string4 = ((StringBuilder)object2).toString();
                    IllegalStateException illegalStateException = new IllegalStateException(string4);
                    throw illegalStateException;
                }
                this.setText(null);
            } else {
                n12 = R$string.common_signin_button_text_long;
                String string5 = object.getString(n12);
                this.setText(string5);
            }
        } else {
            n12 = R$string.common_signin_button_text;
            String string6 = object.getString(n12);
            this.setText(string6);
        }
        this.setTransformationMethod(null);
        Context context = this.getContext();
        int n20 = DeviceProperties.isWearable(context);
        if (n20 != 0) {
            n20 = 19;
            this.setGravity(n20);
        }
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        int n10 = signInButtonConfig.getButtonSize();
        int n11 = signInButtonConfig.getColorScheme();
        this.configure(resources, n10, n11);
    }
}

