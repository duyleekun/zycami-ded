/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.v.q;

import android.graphics.Bitmap;
import d.m.a.b;
import d.m.a.b$a;
import d.v.v.q.f;
import d.v.v.q.f$d;

public class f$a
implements b$a {
    public final /* synthetic */ b a;
    public final /* synthetic */ f$d b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f d;

    public f$a(f f10, b b10, f$d f$d, String string2) {
        this.d = f10;
        this.a = b10;
        this.b = f$d;
        this.c = string2;
    }

    public void a(Bitmap bitmap) {
    }

    public void b(boolean bl2) {
        long l10 = this.a.f() * 1000;
        f$d f$d = this.b;
        String string2 = this.c;
        f$d.a(string2, l10, bl2);
    }
}

