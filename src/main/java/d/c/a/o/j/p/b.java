/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.c.a.o.j.p;

import android.net.Uri;

public final class b {
    private static final int a = 512;
    private static final int b = 384;

    private b() {
    }

    public static boolean a(Uri uri) {
        boolean bl2;
        boolean bl3 = d.c.a.o.j.p.b.b(uri);
        if (bl3 && !(bl2 = d.c.a.o.j.p.b.e(uri))) {
            bl2 = true;
        } else {
            bl2 = false;
            uri = null;
        }
        return bl2;
    }

    public static boolean b(Uri object) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        if (object != null && (bl3 = (string3 = "content").equals(string2 = object.getScheme())) && (bl2 = (string2 = "media").equals(object = object.getAuthority()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean c(Uri uri) {
        boolean bl2;
        boolean bl3 = d.c.a.o.j.p.b.b(uri);
        if (bl3 && (bl2 = d.c.a.o.j.p.b.e(uri))) {
            bl2 = true;
        } else {
            bl2 = false;
            uri = null;
        }
        return bl2;
    }

    public static boolean d(int n10, int n11) {
        int n12 = -1 << -1;
        n10 = n10 != n12 && n11 != n12 && n10 <= (n12 = 512) && n11 <= (n10 = 384) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}

