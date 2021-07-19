/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 */
package d.v.d.g.c.v;

import android.media.MediaRecorder;
import d.v.d.g.c.v.j;
import d.v.d.h.f;
import d.v.d.i.a.a;

public class j$a
implements MediaRecorder.OnInfoListener {
    private boolean a;
    public final /* synthetic */ j b;

    public j$a(j j10) {
        this.b = j10;
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
            object = this.b.T0();
            n10 = 0;
            ((a)object).l(false);
            this.b.R0().l(false);
            this.b.j1();
            object = this.b;
            ((j)object).i1();
        }
    }
}

