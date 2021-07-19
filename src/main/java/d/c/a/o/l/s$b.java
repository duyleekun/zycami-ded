/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.l;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.s;

public class s$b
implements o {
    private final Resources a;

    public s$b(Resources resources) {
        this.a = resources;
    }

    public void a() {
    }

    public n c(r object) {
        Resources resources = this.a;
        object = ((r)object).d(Uri.class, ParcelFileDescriptor.class);
        s s10 = new s(resources, (n)object);
        return s10;
    }
}

