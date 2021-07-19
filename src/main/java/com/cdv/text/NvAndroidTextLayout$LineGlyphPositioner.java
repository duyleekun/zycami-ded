/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.cdv.text;

import android.util.Log;
import com.cdv.text.NvAndroidTextLayout$InternalGlyphInfo;
import java.util.ArrayList;

public class NvAndroidTextLayout$LineGlyphPositioner {
    public boolean allLtr;
    public int glyphIndexInLine = 0;
    public ArrayList lineInternalGlyphInfoArray;

    public NvAndroidTextLayout$LineGlyphPositioner(ArrayList arrayList, boolean bl2) {
        this.lineInternalGlyphInfoArray = arrayList;
        this.allLtr = bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private float internalNextGlyphPosition() {
        float f10;
        float f11;
        Object object = this.lineInternalGlyphInfoArray;
        int n10 = this.glyphIndexInLine;
        object = (NvAndroidTextLayout$InternalGlyphInfo)((ArrayList)object).get(n10);
        n10 = (int)(this.allLtr ? 1 : 0);
        if (n10 != 0) {
            return ((NvAndroidTextLayout$InternalGlyphInfo)object).primaryHorizontal;
        }
        float f12 = ((NvAndroidTextLayout$InternalGlyphInfo)object).primaryHorizontal;
        float f13 = ((NvAndroidTextLayout$InternalGlyphInfo)object).secondaryHorizontal;
        float f14 = f12 - f13;
        Object object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object2 == false) {
            boolean bl2 = ((NvAndroidTextLayout$InternalGlyphInfo)object).isRtl;
            if (!bl2) {
                return f12;
            }
            f11 = ((NvAndroidTextLayout$InternalGlyphInfo)object).advance;
            return f12 - f11;
        }
        int n11 = this.glyphIndexInLine;
        if (n11 == 0) {
            boolean bl3 = ((NvAndroidTextLayout$InternalGlyphInfo)object).isRtl;
            if (!bl3) {
                return f12;
            }
            f10 = ((NvAndroidTextLayout$InternalGlyphInfo)object).advance;
            return f13 - f10;
        }
        Object object3 = this.lineInternalGlyphInfoArray;
        int n12 = n11 + -1;
        object3 = (NvAndroidTextLayout$InternalGlyphInfo)((ArrayList)object3).get(n12);
        boolean bl4 = ((NvAndroidTextLayout$InternalGlyphInfo)object).isRtl;
        if (!bl4) {
            f13 = ((NvAndroidTextLayout$InternalGlyphInfo)object).primaryHorizontal;
            f12 = ((NvAndroidTextLayout$InternalGlyphInfo)object3).primaryHorizontal;
            float f15 = f13 - f12;
            n10 = (int)(f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1));
            if (n10 >= 0) return f13;
            return ((NvAndroidTextLayout$InternalGlyphInfo)object).secondaryHorizontal;
        }
        f13 = ((NvAndroidTextLayout$InternalGlyphInfo)object).primaryHorizontal;
        f12 = ((NvAndroidTextLayout$InternalGlyphInfo)object3).primaryHorizontal;
        float f16 = f13 - f12;
        n10 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1));
        if (n10 < 0) {
            f10 = ((NvAndroidTextLayout$InternalGlyphInfo)object).advance;
            return f13 - f10;
        }
        f12 = ((NvAndroidTextLayout$InternalGlyphInfo)object).secondaryHorizontal;
        f11 = ((NvAndroidTextLayout$InternalGlyphInfo)object).advance;
        return f12 - f11;
    }

    public float nextGlyphPosition() {
        int n10 = this.glyphIndexInLine;
        ArrayList arrayList = this.lineInternalGlyphInfoArray;
        int n11 = arrayList.size();
        if (n10 >= n11) {
            Log.e((String)"NvAndroidTextLayout", (String)"LineGlyphPositioner: glyph index out of range!");
            return 0.0f;
        }
        float f10 = this.internalNextGlyphPosition();
        this.glyphIndexInLine = n11 = this.glyphIndexInLine + 1;
        return f10;
    }
}

