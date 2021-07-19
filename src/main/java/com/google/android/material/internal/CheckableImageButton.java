/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.Checkable
 *  android.widget.ImageButton
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;

public class CheckableImageButton
extends AppCompatImageButton
implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED;
    private boolean checked;

    static {
        int[] nArray = new int[]{0x10100A0};
        DRAWABLE_STATE_CHECKED = nArray;
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.imageButtonStyle;
        this(context, attributeSet, n10);
    }

    public CheckableImageButton(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super(this);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)object);
    }

    public boolean isChecked() {
        return this.checked;
    }

    public int[] onCreateDrawableState(int n10) {
        boolean bl2 = this.checked;
        if (bl2) {
            int[] nArray = DRAWABLE_STATE_CHECKED;
            int n11 = nArray.length;
            return ImageButton.mergeDrawableStates((int[])super.onCreateDrawableState(n10 += n11), (int[])nArray);
        }
        return super.onCreateDrawableState(n10);
    }

    public void setChecked(boolean bl2) {
        boolean bl3 = this.checked;
        if (bl3 != bl2) {
            this.checked = bl2;
            this.refreshDrawableState();
            int n10 = 2048;
            this.sendAccessibilityEvent(n10);
        }
    }

    public void toggle() {
        boolean bl2 = this.checked ^ true;
        this.setChecked(bl2);
    }
}

