/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import com.airbnb.lottie.model.DocumentData$Justification;

public class DocumentData {
    public final float baselineShift;
    public final int color;
    public final String fontName;
    public final DocumentData$Justification justification;
    public final float lineHeight;
    public final float size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final float strokeWidth;
    public final String text;
    public final int tracking;

    public DocumentData(String string2, String string3, float f10, DocumentData$Justification documentData$Justification, int n10, float f11, float f12, int n11, int n12, float f13, boolean bl2) {
        this.text = string2;
        this.fontName = string3;
        this.size = f10;
        this.justification = documentData$Justification;
        this.tracking = n10;
        this.lineHeight = f11;
        this.baselineShift = f12;
        this.color = n11;
        this.strokeColor = n12;
        this.strokeWidth = f13;
        this.strokeOverFill = bl2;
    }

    public int hashCode() {
        int n10 = this.text.hashCode() * 31;
        int n11 = this.fontName.hashCode();
        float f10 = (n10 + n11) * 31;
        float f11 = this.size;
        n10 = (int)(f10 + f11) * 31;
        n11 = this.justification.ordinal();
        n10 = (n10 + n11) * 31;
        n11 = this.tracking;
        n10 += n11;
        long l10 = Float.floatToRawIntBits(this.lineHeight);
        n10 *= 31;
        long l11 = l10 >>> 32;
        n11 = (int)(l10 ^ l11);
        n10 = (n10 + n11) * 31;
        n11 = this.color;
        return n10 + n11;
    }
}

