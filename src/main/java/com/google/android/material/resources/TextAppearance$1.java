/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.text.TextPaint
 */
package com.google.android.material.resources;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import com.google.android.material.resources.TextAppearance;

public class TextAppearance$1
extends ResourcesCompat$FontCallback {
    public final /* synthetic */ TextAppearance this$0;
    public final /* synthetic */ ResourcesCompat$FontCallback val$callback;
    public final /* synthetic */ TextPaint val$textPaint;

    public TextAppearance$1(TextAppearance textAppearance, TextPaint textPaint, ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        this.this$0 = textAppearance;
        this.val$textPaint = textPaint;
        this.val$callback = resourcesCompat$FontCallback;
    }

    public void onFontRetrievalFailed(int n10) {
        TextAppearance.access$200(this.this$0);
        TextAppearance.access$102(this.this$0, true);
        this.val$callback.onFontRetrievalFailed(n10);
    }

    public void onFontRetrieved(Typeface typeface) {
        TextAppearance textAppearance = this.this$0;
        int n10 = textAppearance.textStyle;
        Typeface typeface2 = Typeface.create((Typeface)typeface, (int)n10);
        TextAppearance.access$002(textAppearance, typeface2);
        textAppearance = this.this$0;
        typeface2 = this.val$textPaint;
        textAppearance.updateTextPaintMeasureState((TextPaint)typeface2, typeface);
        TextAppearance.access$102(this.this$0, true);
        this.val$callback.onFontRetrieved(typeface);
    }
}

