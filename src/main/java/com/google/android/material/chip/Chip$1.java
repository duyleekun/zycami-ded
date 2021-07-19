/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import com.google.android.material.chip.Chip;

public class Chip$1
extends ResourcesCompat$FontCallback {
    public final /* synthetic */ Chip this$0;

    public Chip$1(Chip chip) {
        this.this$0 = chip;
    }

    public void onFontRetrievalFailed(int n10) {
    }

    public void onFontRetrieved(Typeface object) {
        object = this.this$0;
        CharSequence charSequence = ((Chip)object).getText();
        object.setText(charSequence);
        this.this$0.requestLayout();
        this.this$0.invalidate();
    }
}

