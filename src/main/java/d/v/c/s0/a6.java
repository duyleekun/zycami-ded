/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.v.c.s0;

import android.net.Uri;
import d.v.c.s0.t6;
import e.a.v0.o;

public final class a6
implements o {
    public final /* synthetic */ Uri a;

    public /* synthetic */ a6(Uri uri) {
        this.a = uri;
    }

    public final Object apply(Object object) {
        Uri uri = this.a;
        object = (byte[])object;
        return t6.n(uri, (byte[])object);
    }
}

