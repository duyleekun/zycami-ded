/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 */
package d.v.d.g.g.t;

import android.media.MediaRecorder;
import d.v.d.g.g.t.a;
import d.v.d.g.g.t.g;
import d.v.d.h.f;
import d.v.d.i.g.l;

public class g$a
implements MediaRecorder.OnInfoListener {
    private boolean a;
    public final /* synthetic */ g b;

    public g$a(g g10) {
        this.b = g10;
    }

    private /* synthetic */ void a() {
        this.a = false;
        l l10 = this.b.O0();
        boolean bl2 = true;
        l10.l(bl2);
        this.b.M0().l(bl2);
    }

    public /* synthetic */ void b() {
        this.a();
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
            object = g.C0(this.b);
            a a10 = new a(this);
            long l10 = 1000L;
            object.postDelayed((Runnable)a10, l10);
            f.a(" onInfo MAX_FILESIZE_REACHED ");
            object = this.b.O0();
            n10 = 0;
            a10 = null;
            ((d.v.d.i.a.a)object).l(false);
            this.b.M0().l(false);
            this.b.V0();
            object = this.b;
            ((g)object).U0();
        }
    }
}

