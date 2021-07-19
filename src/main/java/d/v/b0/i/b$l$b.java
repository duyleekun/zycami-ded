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

public class b$l$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b$l c;

    public b$l$b(b$l b$l, int n10, int n11) {
        this.c = b$l;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        int n10 = this.a;
        int n11 = this.b;
        int[] nArray = new int[]{n11};
        faceunity.fuBindItems(n10, nArray);
        Log.d((String)d.v.b0.i.b.x0(), (String)"run: controller bind default bg");
    }
}

