/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 */
package com.airbnb.lottie.model.layer;

import android.graphics.Paint;
import com.airbnb.lottie.model.layer.TextLayer;

public class TextLayer$2
extends Paint {
    public final /* synthetic */ TextLayer this$0;

    public TextLayer$2(TextLayer textLayer, int n10) {
        this.this$0 = textLayer;
        super(n10);
        textLayer = Paint.Style.STROKE;
        this.setStyle((Paint.Style)textLayer);
    }
}

