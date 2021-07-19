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
import d.v.b0.i.b$l;
import java.util.Arrays;

public class b$l$d
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ int[] d;
    public final /* synthetic */ b$l e;

    public b$l$d(b$l b$l, int n10, int n11, int[] nArray, int[] nArray2) {
        this.e = b$l;
        this.a = n10;
        this.b = n11;
        this.c = nArray;
        this.d = nArray2;
    }

    public void run() {
        int n10 = this.a;
        double d10 = 1.0;
        faceunity.fuItemSetParam(n10, "close_face_capture", d10);
        faceunity.fuItemSetParam(this.a, "is_close_dde", d10);
        faceunity.fuItemSetParam(this.a, "enable_human_processor", d10);
        Object object = this.e.a;
        int n11 = faceunity.fuGetCurrentRotationMode();
        d.v.b0.i.b.T0((b)object, n11);
        faceunity.fuSetDefaultRotationMode(0);
        int n12 = this.a;
        n12 = this.b;
        Object object2 = new int[]{n12, n12};
        d.v.b0.i.b.V0(this.e.a, object2);
        object2 = this.e.a;
        Object object3 = this.c;
        object2 = d.v.b0.i.b.R0((b)object2, object3);
        n12 = ((int[])object2).length;
        int n13 = this.d.length;
        object3 = new int[n12 + n13];
        n13 = ((int[])object2).length;
        System.arraycopy(object2, 0, object3, 0, n13);
        int[] nArray = this.d;
        n11 = ((int[])object2).length;
        int n14 = nArray.length;
        System.arraycopy(nArray, 0, object3, n11, n14);
        d.v.b0.i.b.X0(this.e.a, object3);
        object = d.v.b0.i.b.x0();
        object2 = new StringBuilder;
        object2();
        object2.append("run: controller default bind ");
        object3 = Arrays.toString(object3);
        object2.append((String)object3);
        object2 = object2.toString();
        Log.d((String)object, (String)object2);
        object = this.e.a;
        n11 = d.v.b0.i.b.Y0((b)object);
        ((b)object).O1(n11);
    }
}

