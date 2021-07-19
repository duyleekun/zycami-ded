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
import d.v.b0.i.b$q;
import java.util.Arrays;

public class b$q$a
implements Runnable {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ b$q b;

    public b$q$a(b$q q10, int[] nArray) {
        this.b = q10;
        this.a = nArray;
    }

    public void run() {
        int n10;
        int n11;
        Object object = d.v.b0.i.b.U0(this.b.b);
        String string2 = null;
        int n12 = object[0];
        Object object2 = d.v.b0.i.b.W0(this.b.b);
        int n13 = ((int[])object2).length;
        Object object3 = new int[n13];
        int n14 = 0;
        CharSequence charSequence = null;
        for (n11 = ((int[])object2).length + -1; n11 >= (n10 = d.v.b0.i.b.e0()); n11 += -1) {
            int n15;
            n10 = object2[n11];
            if (n10 <= 0) continue;
            n10 = n14 + 1;
            object3[n14] = n15 = object2[n11];
            n14 = n10;
        }
        object3 = Arrays.copyOfRange(object3, 0, n14);
        faceunity.fuUnBindItems(n12, object3);
        Object object4 = d.v.b0.i.b.x0();
        charSequence = new StringBuilder();
        charSequence.append("run: controller unbind ");
        String string3 = Arrays.toString(object3);
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Log.d((String)object4, (String)charSequence);
        object4 = this.a;
        faceunity.fuBindItems(n12, (int[])object4);
        object = d.v.b0.i.b.x0();
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("run: controller bind ");
        charSequence = Arrays.toString(this.a);
        ((StringBuilder)object4).append((String)charSequence);
        object4 = ((StringBuilder)object4).toString();
        Log.d((String)object, (String)object4);
        if (object3 != null) {
            n12 = ((int[])object3).length;
            object4 = null;
            for (n11 = 0; n11 < n12; ++n11) {
                n14 = object3[n11];
                faceunity.fuDestroyItem(n14);
            }
            object = d.v.b0.i.b.x0();
            object4 = new StringBuilder();
            charSequence = "run: controller destroy ";
            ((StringBuilder)object4).append((String)charSequence);
            object3 = Arrays.toString(object3);
            ((StringBuilder)object4).append((String)object3);
            object3 = ((StringBuilder)object4).toString();
            Log.d((String)object, (String)object3);
        }
        n12 = d.v.b0.i.b.e0();
        n13 = this.a.length;
        object = new int[n12 + n13];
        n13 = d.v.b0.i.b.e0();
        System.arraycopy(object2, 0, object, 0, n13);
        object2 = this.a;
        n13 = d.v.b0.i.b.e0();
        n11 = this.a.length;
        System.arraycopy(object2, 0, object, n13, n11);
        d.v.b0.i.b.X0(this.b.b, object);
        string2 = d.v.b0.i.b.x0();
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("run: final controller bind ");
        object = Arrays.toString(object);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        Log.i((String)string2, (String)object);
    }
}

