/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.location.LocationManager
 */
package d.n.a.q0.x;

import android.content.ContentResolver;
import android.location.LocationManager;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.k;

public final class l
implements e {
    private final c a;
    private final c b;

    public l(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static l a(c c10, c c11) {
        l l10 = new l(c10, c11);
        return l10;
    }

    public static k c(ContentResolver contentResolver, LocationManager locationManager) {
        k k10 = new k(contentResolver, locationManager);
        return k10;
    }

    public k b() {
        ContentResolver contentResolver = (ContentResolver)this.a.get();
        LocationManager locationManager = (LocationManager)this.b.get();
        k k10 = new k(contentResolver, locationManager);
        return k10;
    }
}

