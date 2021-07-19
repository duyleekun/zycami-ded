/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint$FontMetrics
 */
package com.cdv.text;

import android.graphics.Paint;
import com.cdv.text.NvAndroidTextLayout$1;
import com.cdv.text.NvAndroidTextLayout$VerticalLayoutContext$LineInfo;
import java.util.ArrayList;

public class NvAndroidTextLayout$VerticalLayoutContext {
    public int currentGlyphCountInLine;
    public float currentLineHeight;
    public boolean firstLine;
    public float height;
    public ArrayList lineInfoArray;
    public float width;
    public float xCenter;
    public float xOrigin;
    public float yOrigin;

    private NvAndroidTextLayout$VerticalLayoutContext() {
        ArrayList arrayList;
        this.lineInfoArray = arrayList = new ArrayList();
    }

    public /* synthetic */ NvAndroidTextLayout$VerticalLayoutContext(NvAndroidTextLayout$1 nvAndroidTextLayout$1) {
        this();
    }

    public void moveToNextLine(Paint.FontMetrics fontMetrics, float f10, float f11) {
        float f12;
        float f13;
        NvAndroidTextLayout$VerticalLayoutContext$LineInfo nvAndroidTextLayout$VerticalLayoutContext$LineInfo = new NvAndroidTextLayout$VerticalLayoutContext$LineInfo();
        nvAndroidTextLayout$VerticalLayoutContext$LineInfo.lineLeft = f13 = this.xOrigin;
        nvAndroidTextLayout$VerticalLayoutContext$LineInfo.lineRight = f13 += f10;
        ArrayList arrayList = this.lineInfoArray;
        arrayList.add(nvAndroidTextLayout$VerticalLayoutContext$LineInfo);
        float f14 = this.height;
        f13 = this.currentLineHeight;
        this.height = f14 = Math.max(f14, f13);
        f14 = this.xOrigin;
        f13 = f10 + f11;
        this.xOrigin = f14 -= f13;
        this.xCenter = f14 = this.xCenter - f13;
        this.yOrigin = f12 = -fontMetrics.ascent;
        this.currentLineHeight = 0.0f;
        f12 = 0.0f;
        fontMetrics = null;
        this.currentGlyphCountInLine = 0;
        this.width = f14 = this.width + f10;
        boolean bl2 = this.firstLine;
        if (!bl2) {
            this.width = f14 += f11;
        } else {
            this.firstLine = false;
        }
    }
}

