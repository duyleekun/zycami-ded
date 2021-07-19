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

public class b$l$c
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ b$l c;

    public b$l$c(b$l b$l, int n10, int[] nArray) {
        this.c = b$l;
        this.a = n10;
        this.b = nArray;
    }

    public void run() {
        int n10 = this.a;
        Object object = this.b;
        faceunity.fuBindItems(n10, (int[])object);
        String string2 = d.v.b0.i.b.x0();
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("run: bind gesture ");
        String string3 = Arrays.toString(this.b);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        Log.d((String)string2, (String)object);
    }
}

