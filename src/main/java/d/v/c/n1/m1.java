/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.c.n1;

import android.net.Uri;
import d.v.c.n1.j2;
import d.v.e.g.e;
import java.io.File;

public final class m1
implements Runnable {
    public final /* synthetic */ j2 a;
    public final /* synthetic */ File b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ e d;

    public /* synthetic */ m1(j2 j22, File file, Uri uri, e e10) {
        this.a = j22;
        this.b = file;
        this.c = uri;
        this.d = e10;
    }

    public final void run() {
        j2 j22 = this.a;
        File file = this.b;
        Uri uri = this.c;
        e e10 = this.d;
        j22.d0(file, uri, e10);
    }
}

