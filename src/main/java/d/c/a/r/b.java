/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final List a;

    public b() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void a(ImageHeaderParser imageHeaderParser) {
        synchronized (this) {
            List list = this.a;
            list.add(imageHeaderParser);
            return;
        }
    }

    public List b() {
        synchronized (this) {
            List list = this.a;
            return list;
        }
    }
}

