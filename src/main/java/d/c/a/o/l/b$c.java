/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.l.b$b;

public class b$c
implements d {
    private final byte[] a;
    private final b$b b;

    public b$c(byte[] byArray, b$b b$b) {
        this.a = byArray;
        this.b = b$b;
    }

    public Class a() {
        return this.b.a();
    }

    public void b() {
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        object = this.b;
        byte[] byArray = this.a;
        object = object.b(byArray);
        d$a.e(object);
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

