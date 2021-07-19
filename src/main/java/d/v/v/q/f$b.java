/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.v.q;

import android.graphics.Bitmap;
import d.m.a.b$a;
import d.v.v.q.f;
import java.io.File;

public class f$b
implements b$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f c;

    public f$b(f f10, String string2, String string3) {
        this.c = f10;
        this.a = string2;
        this.b = string3;
    }

    public void a(Bitmap bitmap) {
    }

    public void b(boolean bl2) {
        if (bl2) {
            Object object = this.a;
            File file = new File((String)object);
            String string2 = this.b;
            object = new File(string2);
            file.renameTo((File)object);
        }
    }
}

