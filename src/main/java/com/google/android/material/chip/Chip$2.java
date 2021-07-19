/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package com.google.android.material.chip;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;

public class Chip$2
extends ViewOutlineProvider {
    public final /* synthetic */ Chip this$0;

    public Chip$2(Chip chip) {
        this.this$0 = chip;
    }

    public void getOutline(View object, Outline outline) {
        object = Chip.access$000(this.this$0);
        if (object != null) {
            object = Chip.access$000(this.this$0);
            ((ChipDrawable)object).getOutline(outline);
        } else {
            object = null;
            outline.setAlpha(0.0f);
        }
    }
}

