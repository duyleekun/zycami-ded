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

public class b$e
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ double b;
    public final /* synthetic */ b c;

    public b$e(b b10, String string2, double d10) {
        this.c = b10;
        this.a = string2;
        this.b = d10;
    }

    public void run() {
        int n10;
        Object object = d.v.b0.i.b.U0(this.c);
        int n11 = object[n10 = 7];
        if (n11 > 0) {
            CharSequence charSequence = this.a;
            double d10 = this.b;
            faceunity.fuItemSetParam(n11, (String)charSequence, d10);
            object = d.v.b0.i.b.x0();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("makeup: set param key: ");
            String string2 = this.a;
            ((StringBuilder)charSequence).append(string2);
            string2 = ", value: ";
            ((StringBuilder)charSequence).append(string2);
            d10 = this.b;
            ((StringBuilder)charSequence).append(d10);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.v((String)object, (String)charSequence);
        }
    }
}

