/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.res.Resources;
import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter
extends SpinnerAdapter {
    public Resources.Theme getDropDownViewTheme();

    public void setDropDownViewTheme(Resources.Theme var1);
}

