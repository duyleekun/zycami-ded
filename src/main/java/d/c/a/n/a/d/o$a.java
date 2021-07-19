/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Message
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import d.c.a.s.j.n;
import d.c.a.s.k.f;

public class o$a
extends n {
    private final Handler d;
    public final int e;
    private final long f;
    private Bitmap g;

    public o$a(Handler handler, int n10, long l10) {
        this.d = handler;
        this.e = n10;
        this.f = l10;
    }

    public Bitmap d() {
        return this.g;
    }

    public void e(Bitmap bitmap, f f10) {
        this.g = bitmap;
        bitmap = this.d.obtainMessage(1, (Object)this);
        f10 = this.d;
        long l10 = this.f;
        f10.sendMessageAtTime((Message)bitmap, l10);
    }
}

