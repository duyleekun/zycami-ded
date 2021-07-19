/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$r
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public b$r(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        int[] nArray = d.v.b0.i.b.U0(this.b);
        int n10 = 0;
        double[] dArray = null;
        int n11 = nArray[0];
        if (n11 > 0) {
            int n12 = this.a;
            int n13 = 1;
            if (n12 == n13) {
                n10 = n13;
            }
            String string2 = "reset_all";
            double d10 = 0.0;
            String string3 = "target_angle";
            int n14 = 3;
            String string4 = "target_position";
            if (n10 != 0) {
                double[] dArray2 = dArray = new double[n14];
                dArray[0] = 0.0;
                dArray2[1] = 58.14;
                dArray2[2] = -618.94;
                faceunity.fuItemSetParam(n11, string4, dArray);
                faceunity.fuItemSetParam(n11, string3, d10);
                d10 = 3.0;
                faceunity.fuItemSetParam(n11, string2, d10);
            } else {
                double[] dArray3 = dArray = new double[n14];
                dArray[0] = 0.0;
                dArray3[1] = 11.76;
                dArray3[2] = -183.89;
                faceunity.fuItemSetParam(n11, string4, dArray);
                faceunity.fuItemSetParam(n11, string3, d10);
                d10 = 6.0;
                faceunity.fuItemSetParam(n11, string2, d10);
            }
            n10 = this.a;
            double d11 = n10;
            String string5 = "human_3d_track_set_scene";
            faceunity.fuItemSetParam(n11, string5, d11);
        }
    }
}

