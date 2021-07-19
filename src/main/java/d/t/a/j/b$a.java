/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 */
package d.t.a.j;

import android.graphics.Bitmap;
import android.util.Log;
import d.t.a.g.c;
import d.t.a.j.b;
import d.t.a.j.b$b;

public class b$a
implements d.t.a.f.b {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void a(Bitmap bitmap, c object, String string2, String string3) {
        b.b(this.a, string2);
        b.c(this.a, string3);
        b.d(this.a, (c)object);
        object = this.a;
        ((b)object).j = true;
        ((b)object).setImageBitmap(bitmap);
    }

    public void onFailure(Exception exception) {
        String string2 = "onFailure: setImageUri";
        Log.e((String)"TransformImageView", (String)string2, (Throwable)exception);
        b$b b$b = this.a.g;
        if (b$b != null) {
            b$b.c(exception);
        }
    }
}

