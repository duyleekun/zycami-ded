/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.v.b0.i;

import android.util.Log;
import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$p
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ b b;

    public b$p(b b10, float f10) {
        this.b = b10;
        this.a = f10;
    }

    public void run() {
        int[] nArray = d.v.b0.i.b.U0(this.b);
        int n10 = 1;
        float f10 = Float.MIN_VALUE;
        int n11 = nArray[n10];
        if (n11 > 0) {
            String string2 = d.v.b0.i.b.x0();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("setEdgeDistance: ");
            float f11 = this.a;
            charSequence.append(f11);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
            f10 = this.a;
            double d10 = f10;
            String string3 = "edge_distance";
            faceunity.fuItemSetParam(n11, string3, d10);
        }
    }
}

