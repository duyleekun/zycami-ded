/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package cn.sharesdk.framework.authorize;

import android.view.animation.Interpolator;
import cn.sharesdk.framework.authorize.g$1;

public class g$a
implements Interpolator {
    private float[] a;

    private g$a() {
        float[] fArray;
        float[] fArray2 = fArray = new float[101];
        float[] fArray3 = fArray;
        fArray2[0] = 0.0f;
        fArray3[1] = 0.02692683f;
        fArray2[2] = 0.053847015f;
        fArray3[3] = 0.080753915f;
        fArray2[4] = 0.10764089f;
        fArray3[5] = 0.13450131f;
        fArray2[6] = 0.16132854f;
        fArray3[7] = 0.18811597f;
        fArray2[8] = 0.21485697f;
        fArray3[9] = 0.24154496f;
        fArray2[10] = 0.26817337f;
        fArray3[11] = 0.2947356f;
        fArray2[12] = 0.3212251f;
        fArray3[13] = 0.34763536f;
        fArray2[14] = 0.37395984f;
        fArray3[15] = 0.40019205f;
        fArray2[16] = 0.42632553f;
        fArray3[17] = 0.4523538f;
        fArray2[18] = 0.47827047f;
        fArray3[19] = 0.50406915f;
        fArray2[20] = 0.52974343f;
        fArray3[21] = 0.555287f;
        fArray2[22] = 0.5806936f;
        fArray3[23] = 0.60595685f;
        fArray2[24] = 0.6310707f;
        fArray3[25] = 0.65602875f;
        fArray2[26] = 0.68082494f;
        fArray3[27] = 0.70545316f;
        fArray2[28] = 0.72990733f;
        fArray3[29] = 0.75418144f;
        fArray2[30] = 0.7782694f;
        fArray3[31] = 0.8021654f;
        fArray2[32] = 0.8258634f;
        fArray3[33] = 0.8493577f;
        fArray2[34] = 0.8726424f;
        fArray3[35] = 0.89571184f;
        fArray2[36] = 0.9185602f;
        fArray3[37] = 0.94118196f;
        fArray2[38] = 0.9635715f;
        fArray3[39] = 0.9857233f;
        fArray2[40] = 1.0076319f;
        fArray3[41] = 1.0292919f;
        fArray2[42] = 1.0506978f;
        fArray3[43] = 1.0718446f;
        fArray2[44] = 1.0927268f;
        fArray3[45] = 1.1133395f;
        fArray2[46] = 1.1336775f;
        fArray3[47] = 1.1537358f;
        fArray2[48] = 1.1735094f;
        fArray3[49] = 1.1929934f;
        fArray2[50] = 1.1893399f;
        fArray3[51] = 1.1728106f;
        fArray2[52] = 1.1565471f;
        fArray3[53] = 1.1405534f;
        fArray2[54] = 1.1248333f;
        fArray3[55] = 1.1093911f;
        fArray2[56] = 1.0942302f;
        fArray3[57] = 1.0793544f;
        fArray2[58] = 1.0647675f;
        fArray3[59] = 1.050473f;
        fArray2[60] = 1.0364745f;
        fArray3[61] = 1.0227754f;
        fArray2[62] = 1.0093791f;
        fArray3[63] = 0.99628896f;
        fArray2[64] = 0.9835081f;
        fArray3[65] = 0.9710398f;
        fArray2[66] = 0.958887f;
        fArray3[67] = 0.9470527f;
        fArray2[68] = 0.93553996f;
        fArray3[69] = 0.9243516f;
        fArray2[70] = 0.91349024f;
        fArray3[71] = 0.90295863f;
        fArray2[72] = 0.90482706f;
        fArray3[73] = 0.9114033f;
        fArray2[74] = 0.91775465f;
        fArray3[75] = 0.9238795f;
        fArray2[76] = 0.9297765f;
        fArray3[77] = 0.93544406f;
        fArray2[78] = 0.9408808f;
        fArray3[79] = 0.94608533f;
        fArray2[80] = 0.95105654f;
        fArray3[81] = 0.955793f;
        fArray2[82] = 0.9602937f;
        fArray3[83] = 0.9645574f;
        fArray2[84] = 0.96858317f;
        fArray3[85] = 0.9723699f;
        fArray2[86] = 0.97591674f;
        fArray3[87] = 0.97922283f;
        fArray2[88] = 0.9822872f;
        fArray3[89] = 0.9851093f;
        fArray2[90] = 0.98768836f;
        fArray3[91] = 0.9900237f;
        fArray2[92] = 0.9921147f;
        fArray3[93] = 0.993961f;
        fArray2[94] = 0.99556196f;
        fArray3[95] = 0.9969173f;
        fArray2[96] = 0.9980267f;
        fArray3[97] = 0.99888986f;
        fArray2[98] = 0.99950653f;
        fArray3[99] = 0.9998766f;
        fArray3[100] = 1.0f;
        this.a = fArray;
    }

    public /* synthetic */ g$a(g$1 g$1) {
        this();
    }

    public float getInterpolation(float f10) {
        int n10 = 1120403456;
        float f11 = 100.0f;
        int n11 = (int)(f10 *= f11);
        if (n11 < 0) {
            n11 = 0;
            f10 = 0.0f;
        }
        n10 = 100;
        f11 = 1.4E-43f;
        if (n11 > n10) {
            n11 = n10;
            f10 = f11;
        }
        return this.a[n11];
    }
}

