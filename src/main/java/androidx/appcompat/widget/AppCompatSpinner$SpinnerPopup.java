/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.widget.ListAdapter
 */
package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;

public interface AppCompatSpinner$SpinnerPopup {
    public void dismiss();

    public Drawable getBackground();

    public CharSequence getHintText();

    public int getHorizontalOffset();

    public int getHorizontalOriginalOffset();

    public int getVerticalOffset();

    public boolean isShowing();

    public void setAdapter(ListAdapter var1);

    public void setBackgroundDrawable(Drawable var1);

    public void setHorizontalOffset(int var1);

    public void setHorizontalOriginalOffset(int var1);

    public void setPromptText(CharSequence var1);

    public void setVerticalOffset(int var1);

    public void show(int var1, int var2);
}

