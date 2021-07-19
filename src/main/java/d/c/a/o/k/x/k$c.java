/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import d.c.a.o.k.x.k$a;
import java.util.Collections;
import java.util.Set;

public class k$c
implements k$a {
    private final Set a;

    private k$c() {
        Set set = new Set();
        this.a = set = Collections.synchronizedSet(set);
    }

    public void a(Bitmap object) {
        Set set = this.a;
        boolean bl2 = set.contains(object);
        if (bl2) {
            this.a.remove(object);
            return;
        }
        object = new IllegalStateException("Cannot remove bitmap not in tracker");
        throw object;
    }

    public void b(Bitmap object) {
        Object object2 = this.a;
        boolean bl2 = object2.contains(object);
        if (!bl2) {
            this.a.add(object);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't add already added bitmap: ");
        stringBuilder.append(object);
        stringBuilder.append(" [");
        int n10 = object.getWidth();
        stringBuilder.append(n10);
        stringBuilder.append("x");
        int n11 = object.getHeight();
        stringBuilder.append(n11);
        stringBuilder.append("]");
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }
}

