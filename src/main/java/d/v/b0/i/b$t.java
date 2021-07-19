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

public class b$t
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public b$t(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        String string2 = d.v.b0.i.b.x0();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setMaxHumans() called with: maxHumans = [");
        int n10 = this.a;
        charSequence.append(n10);
        charSequence.append("]");
        charSequence = charSequence.toString();
        Log.d((String)string2, (String)charSequence);
        faceunity.fuSetMaxFaces(this.a);
    }
}

