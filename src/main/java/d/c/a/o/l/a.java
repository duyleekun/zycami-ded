/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.net.Uri
 */
package d.c.a.o.l;

import android.content.res.AssetManager;
import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.a$a;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;

public class a
implements n {
    private static final String c = "android_asset";
    private static final String d = "file:///android_asset/";
    private static final int e = 22;
    private final AssetManager a;
    private final a$a b;

    public a(AssetManager assetManager, a$a a$a) {
        this.a = assetManager;
        this.b = a$a;
    }

    public n$a c(Uri object, int n10, int n11, f c10) {
        String string2 = object.toString();
        n11 = e;
        string2 = string2.substring(n11);
        c10 = new e(object);
        object = this.b;
        AssetManager assetManager = this.a;
        object = object.b(assetManager, string2);
        n$a n$a = new n$a(c10, (d)object);
        return n$a;
    }

    public boolean d(Uri object) {
        boolean bl2;
        Object object2 = object.getScheme();
        boolean bl3 = "file".equals(object2);
        boolean bl4 = false;
        if (bl3 && !(bl3 = (object2 = object.getPathSegments()).isEmpty()) && (bl2 = ((String)(object2 = c)).equals(object = object.getPathSegments().get(0)))) {
            bl4 = true;
        }
        return bl4;
    }
}

