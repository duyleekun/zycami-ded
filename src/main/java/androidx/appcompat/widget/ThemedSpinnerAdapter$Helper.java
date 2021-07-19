/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.view.LayoutInflater
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.view.ContextThemeWrapper;

public final class ThemedSpinnerAdapter$Helper {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;

    public ThemedSpinnerAdapter$Helper(Context context) {
        this.mContext = context;
        context = LayoutInflater.from((Context)context);
        this.mInflater = context;
    }

    public LayoutInflater getDropDownViewInflater() {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        if (layoutInflater == null) {
            layoutInflater = this.mInflater;
        }
        return layoutInflater;
    }

    public Resources.Theme getDropDownViewTheme() {
        Object object = this.mDropDownInflater;
        object = object == null ? null : object.getContext().getTheme();
        return object;
    }

    public void setDropDownViewTheme(Resources.Theme theme) {
        if (theme == null) {
            theme = null;
            this.mDropDownInflater = null;
        } else {
            Object object = this.mContext.getTheme();
            if (theme == object) {
                theme = this.mInflater;
                this.mDropDownInflater = theme;
            } else {
                Context context = this.mContext;
                object = new ContextThemeWrapper(context, theme);
                theme = LayoutInflater.from((Context)object);
                this.mDropDownInflater = theme;
            }
        }
    }
}

