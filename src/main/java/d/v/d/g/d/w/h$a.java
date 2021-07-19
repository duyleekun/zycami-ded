/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 */
package d.v.d.g.d.w;

import android.media.MediaRecorder;
import d.v.d.g.d.w.b;
import d.v.d.g.d.w.h;
import d.v.d.h.f;
import d.v.d.i.a.a;
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
            b b10 = new b(this);
            long l10 = 1000L;
            object.postDelayed((Runnable)b10, l10);
            f.a(" onInfo max file size receive ");
            object = this.b.O();
            n10 = 0;
            b10 = null;
            ((a)object).l(false);
            this.b.a1().l(false);
            this.b.m1();
            object = this.b;
            ((h)object).l1();
        }
    }
}

