/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$1;

public final class Cue$Builder {
    private Bitmap bitmap;
    private float bitmapHeight;
    private float line;
    private int lineAnchor;
    private int lineType;
    private float position;
    private int positionAnchor;
    private float size;
    private CharSequence text;
    private Layout.Alignment textAlignment;
    private float textSize;
    private int textSizeType;
    private int verticalType;
    private int windowColor;
    private boolean windowColorSet;

    public Cue$Builder() {
        int n10;
        float f10;
        this.text = null;
        this.bitmap = null;
        this.textAlignment = null;
        this.line = f10 = -3.4028235E38f;
        this.lineType = n10 = -1 << -1;
        this.lineAnchor = n10;
        this.position = f10;
        this.positionAnchor = n10;
        this.textSizeType = n10;
        this.textSize = f10;
        this.size = f10;
        this.bitmapHeight = f10;
        this.windowColorSet = false;
        this.windowColor = -16777216;
        this.verticalType = n10;
    }

    private Cue$Builder(Cue cue) {
        int n10;
        int n11;
        float f10;
        CharSequence charSequence;
        this.text = charSequence = cue.text;
        charSequence = cue.bitmap;
        this.bitmap = charSequence;
        charSequence = cue.textAlignment;
        this.textAlignment = charSequence;
        this.line = f10 = cue.line;
        this.lineType = n11 = cue.lineType;
        this.lineAnchor = n11 = cue.lineAnchor;
        this.position = f10 = cue.position;
        this.positionAnchor = n11 = cue.positionAnchor;
        this.textSizeType = n11 = cue.textSizeType;
        this.textSize = f10 = cue.textSize;
        this.size = f10 = cue.size;
        this.bitmapHeight = f10 = cue.bitmapHeight;
        n11 = (int)(cue.windowColorSet ? 1 : 0);
        this.windowColorSet = n11;
        this.windowColor = n11 = cue.windowColor;
        this.verticalType = n10 = cue.verticalType;
    }

    public /* synthetic */ Cue$Builder(Cue cue, Cue$1 cue$1) {
        this(cue);
    }

    public Cue build() {
        CharSequence charSequence = this.text;
        Layout.Alignment alignment = this.textAlignment;
        Bitmap bitmap = this.bitmap;
        float f10 = this.line;
        int n10 = this.lineType;
        int n11 = this.lineAnchor;
        float f11 = this.position;
        int n12 = this.positionAnchor;
        int n13 = this.textSizeType;
        float f12 = this.textSize;
        float f13 = this.size;
        float f14 = this.bitmapHeight;
        boolean bl2 = this.windowColorSet;
        int n14 = this.windowColor;
        int n15 = this.verticalType;
        Cue cue = new Cue(charSequence, alignment, bitmap, f10, n10, n11, f11, n12, n13, f12, f13, f14, bl2, n14, n15, null);
        return cue;
    }

    public Cue$Builder clearWindowColor() {
        this.windowColorSet = false;
        return this;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public float getBitmapHeight() {
        return this.bitmapHeight;
    }

    public float getLine() {
        return this.line;
    }

    public int getLineAnchor() {
        return this.lineAnchor;
    }

    public int getLineType() {
        return this.lineType;
    }

    public float getPosition() {
        return this.position;
    }

    public int getPositionAnchor() {
        return this.positionAnchor;
    }

    public float getSize() {
        return this.size;
    }

    public CharSequence getText() {
        return this.text;
    }

    public Layout.Alignment getTextAlignment() {
        return this.textAlignment;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public int getTextSizeType() {
        return this.textSizeType;
    }

    public int getVerticalType() {
        return this.verticalType;
    }

    public int getWindowColor() {
        return this.windowColor;
    }

    public boolean isWindowColorSet() {
        return this.windowColorSet;
    }

    public Cue$Builder setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        return this;
    }

    public Cue$Builder setBitmapHeight(float f10) {
        this.bitmapHeight = f10;
        return this;
    }

    public Cue$Builder setLine(float f10, int n10) {
        this.line = f10;
        this.lineType = n10;
        return this;
    }

    public Cue$Builder setLineAnchor(int n10) {
        this.lineAnchor = n10;
        return this;
    }

    public Cue$Builder setPosition(float f10) {
        this.position = f10;
        return this;
    }

    public Cue$Builder setPositionAnchor(int n10) {
        this.positionAnchor = n10;
        return this;
    }

    public Cue$Builder setSize(float f10) {
        this.size = f10;
        return this;
    }

    public Cue$Builder setText(CharSequence charSequence) {
        this.text = charSequence;
        return this;
    }

    public Cue$Builder setTextAlignment(Layout.Alignment alignment) {
        this.textAlignment = alignment;
        return this;
    }

    public Cue$Builder setTextSize(float f10, int n10) {
        this.textSize = f10;
        this.textSizeType = n10;
        return this;
    }

    public Cue$Builder setVerticalType(int n10) {
        this.verticalType = n10;
        return this;
    }

    public Cue$Builder setWindowColor(int n10) {
        this.windowColor = n10;
        this.windowColorSet = true;
        return this;
    }
}

