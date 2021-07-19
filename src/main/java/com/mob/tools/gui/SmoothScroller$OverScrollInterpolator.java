/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package com.mob.tools.gui;

import android.view.animation.Interpolator;
import com.mob.tools.gui.SmoothScroller$1;

public class SmoothScroller$OverScrollInterpolator
implements Interpolator {
    private float[] defaultInt;

    private SmoothScroller$OverScrollInterpolator() {
        float[] fArray;
        float[] fArray2 = fArray = new float[101];
        float[] fArray3 = fArray;
        fArray2[0] = 0.0f;
        fArray3[1] = 3.0E-4f;
        fArray2[2] = 0.0012f;
        fArray3[3] = 0.0026f;
        fArray2[4] = 0.0047f;
        fArray3[5] = 0.0073f;
        fArray2[6] = 0.0104f;
        fArray3[7] = 0.014f;
        fArray2[8] = 0.0182f;
        fArray3[9] = 0.0228f;
        fArray2[10] = 0.028f;
        fArray3[11] = 0.0336f;
        fArray2[12] = 0.0397f;
        fArray3[13] = 0.0463f;
        fArray2[14] = 0.0533f;
        fArray3[15] = 0.0608f;
        fArray2[16] = 0.0686f;
        fArray3[17] = 0.0769f;
        fArray2[18] = 0.0855f;
        fArray3[19] = 0.0946f;
        fArray2[20] = 0.104f;
        fArray3[21] = 0.1138f;
        fArray2[22] = 0.1239f;
        fArray3[23] = 0.1344f;
        fArray2[24] = 0.1452f;
        fArray3[25] = 0.1563f;
        fArray2[26] = 0.1676f;
        fArray3[27] = 0.1793f;
        fArray2[28] = 0.1913f;
        fArray3[29] = 0.2035f;
        fArray2[30] = 0.216f;
        fArray3[31] = 0.2287f;
        fArray2[32] = 0.2417f;
        fArray3[33] = 0.2548f;
        fArray2[34] = 0.2682f;
        fArray3[35] = 0.2817f;
        fArray2[36] = 0.2955f;
        fArray3[37] = 0.3094f;
        fArray2[38] = 0.3235f;
        fArray3[39] = 0.3377f;
        fArray2[40] = 0.352f;
        fArray3[41] = 0.3665f;
        fArray2[42] = 0.381f;
        fArray3[43] = 0.3957f;
        fArray2[44] = 0.4104f;
        fArray3[45] = 0.4253f;
        fArray2[46] = 0.4401f;
        fArray3[47] = 0.4551f;
        fArray2[48] = 0.47f;
        fArray3[49] = 0.485f;
        fArray2[50] = 0.5f;
        fArray3[51] = 0.515f;
        fArray2[52] = 0.53f;
        fArray3[53] = 0.5449f;
        fArray2[54] = 0.5599f;
        fArray3[55] = 0.5748f;
        fArray2[56] = 0.5896f;
        fArray3[57] = 0.6043f;
        fArray2[58] = 0.619f;
        fArray3[59] = 0.6335f;
        fArray2[60] = 0.648f;
        fArray3[61] = 0.6623f;
        fArray2[62] = 0.6765f;
        fArray3[63] = 0.6906f;
        fArray2[64] = 0.7045f;
        fArray3[65] = 0.7183f;
        fArray2[66] = 0.7318f;
        fArray3[67] = 0.7452f;
        fArray2[68] = 0.7583f;
        fArray3[69] = 0.7713f;
        fArray2[70] = 0.784f;
        fArray3[71] = 0.7965f;
        fArray2[72] = 0.8087f;
        fArray3[73] = 0.8207f;
        fArray2[74] = 0.8324f;
        fArray3[75] = 0.8438f;
        fArray2[76] = 0.8548f;
        fArray3[77] = 0.8656f;
        fArray2[78] = 0.8761f;
        fArray3[79] = 0.8862f;
        fArray2[80] = 0.896f;
        fArray3[81] = 0.9054f;
        fArray2[82] = 0.9145f;
        fArray3[83] = 0.9231f;
        fArray2[84] = 0.9314f;
        fArray3[85] = 0.9392f;
        fArray2[86] = 0.9467f;
        fArray3[87] = 0.9537f;
        fArray2[88] = 0.9603f;
        fArray3[89] = 0.9664f;
        fArray2[90] = 0.972f;
        fArray3[91] = 0.9772f;
        fArray2[92] = 0.9818f;
        fArray3[93] = 0.986f;
        fArray2[94] = 0.9896f;
        fArray3[95] = 0.9927f;
        fArray2[96] = 0.9953f;
        fArray3[97] = 0.9974f;
        fArray2[98] = 0.9988f;
        fArray3[99] = 0.9997f;
        fArray3[100] = 1.0f;
        this.defaultInt = fArray;
    }

    public /* synthetic */ SmoothScroller$OverScrollInterpolator(SmoothScroller$1 smoothScroller$1) {
        this();
    }

    public float getInterpolation(float f10) {
        float[] fArray = this.defaultInt;
        int n10 = (int)(f10 * 100.0f);
        return fArray[n10];
    }
}

