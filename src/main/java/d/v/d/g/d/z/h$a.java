/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 */
package d.v.d.g.d.z;

import android.media.MediaRecorder;
import d.v.d.g.d.z.a;
import d.v.d.g.d.z.h;
import d.v.d.h.f;
import d.v.d.i.g.l;

public class h$a
implements MediaRecorder.OnInfoListener {
    private boolean a;
    public final /* synthetic */ h b;

    public h$a(h h10) {
        this.b = h10;
    }

    private /* synthetic */ void a() {
        this.a = false;
        l l10 = this.b.O();
        boolean bl2 = true;
        l10.l(bl2);
        this.b.a1().l(bl2);
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
            object = this.b.s();
            a a10 = new a(this);
            long l10 = 1000L;
            object.postDelayed((Runnable)a10, l10);
            f.a(" onInfo max file size receive ");
            object = this.b.O();
            n10 = 0;
            a10 = null;
            ((d.v.d.i.a.a)object).l(false);
            this.b.a1().l(false);
            this.b.n1();
            object = this.b;
            ((h)object).m1();
        }
    }
}

