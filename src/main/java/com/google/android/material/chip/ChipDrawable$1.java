/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import com.google.android.material.chip.ChipDrawable;

public class ChipDrawable$1
extends ResourcesCompat$FontCallback {
    public final /* synthetic */ ChipDrawable this$0;

    public ChipDrawable$1(ChipDrawable chipDrawable) {
        this.this$0 = chipDrawable;
    }

    public void onFontRetrievalFailed(int n10) {
    }

    public void onFontRetrieved(Typeface typeface) {
        ChipDrawable.access$002(this.this$0, true);
        this.this$0.onSizeChange();
        this.this$0.invalidateSelf();
    }
}

