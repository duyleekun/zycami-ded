/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.RectF
 */
package com.cdv.text;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public class NvAndroidTextLayout$GlyphInfo {
    public RectF bounding;
    public boolean colorGlyph = false;
    public boolean decorativeGlyph = false;
    public int endCharIdx = 0;
    public Path glyphPath;
    public boolean isRtl = false;
    public int lineEnd = 0;
    public int lineStart = 0;
    public boolean mayHaveContextualForm = false;
    public boolean noShape = false;
    public PointF pos;
    public int startCharIdx = 0;
    public RectF typographicBounding;
}

