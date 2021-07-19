/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 */
package d.v.d.g.c.b0;

import android.media.MediaRecorder;
import d.v.d.g.c.b0.i;
import d.v.d.h.f;
import d.v.d.i.a.a;

public class i$a
implements MediaRecorder.OnInfoListener {
    private boolean a;
    public final /* synthetic */ i b;

    public i$a(i i10) {
        this.b = i10;
    }

    public void onInfo(MediaRecorder object, int n10, int n11) {
        object = new StringBuilder();
        String string2 = " onInfo what=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        f.a((String)object);
        int n12 = 801;
        if (n10 == n12 && (n12 = (int)(this.a ? 1 : 0)) == 0) {
            n12 = 1;
            this.a = n12;
            f.a(" onInfo MAX_FILESIZE_REACHED ");
            object = this.b.S0();
            n10 = 0;
            ((a)object).l(false);
            this.b.Q0().l(false);
            this.b.f1();
            object = this.b;
            ((i)object).e1();
        }
    }
}

