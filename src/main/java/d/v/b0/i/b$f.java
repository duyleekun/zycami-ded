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
import java.util.Arrays;

public class b$f
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ double[] b;
    public final /* synthetic */ b c;

    public b$f(b b10, String string2, double[] dArray) {
        this.c = b10;
        this.a = string2;
        this.b = dArray;
    }

    public void run() {
        int n10;
        Object object = d.v.b0.i.b.U0(this.c);
        int n11 = object[n10 = 7];
        if (n11 > 0) {
            CharSequence charSequence = this.a;
            Object object2 = this.b;
            faceunity.fuItemSetParam(n11, (String)charSequence, object2);
            object = d.v.b0.i.b.x0();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("makeup: set param key: ");
            object2 = this.a;
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(", value: ");
            object2 = Arrays.toString(this.b);
            ((StringBuilder)charSequence).append((String)object2);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.v((String)object, (String)charSequence);
        }
    }
}

