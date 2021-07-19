/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.ttml;

public final class TtmlRegion {
    public final float height;
    public final String id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final float width;

    public TtmlRegion(String string2) {
        this(string2, -3.4028235E38f, -3.4028235E38f, -1 << -1, -1 << -1, -3.4028235E38f, -3.4028235E38f, -1 << -1, -3.4028235E38f, -1 << -1);
    }

    public TtmlRegion(String string2, float f10, float f11, int n10, int n11, float f12, float f13, int n12, float f14, int n13) {
        this.id = string2;
        this.position = f10;
        this.line = f11;
        this.lineType = n10;
        this.lineAnchor = n11;
        this.width = f12;
        this.height = f13;
        this.textSizeType = n12;
        this.textSize = f14;
        this.verticalType = n13;
    }
}

