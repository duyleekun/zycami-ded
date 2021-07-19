/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Message
 */
package d.c.a.o.m.h;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import d.c.a.s.j.e;
import d.c.a.s.k.f;

public class g$a
extends e {
    private final Handler d;
    public final int e;
    private final long f;
    private Bitmap g;

    public g$a(Handler handler, int n10, long l10) {
        this.d = handler;
        this.e = n10;
        this.f = l10;
    }

    public void i(Drawable drawable2) {
        this.g = null;
    }

    public Bitmap n() {
        return this.g;
    }

    public void o(Bitmap bitmap, f f10) {
        this.g = bitmap;
        bitmap = this.d.obtainMessage(1, (Object)this);
        f10 = this.d;
        long l10 = this.f;
        f10.sendMessageAtTime((Message)bitmap, l10);
    }
}

