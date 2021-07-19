/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;

public class v$b
implements d {
    private final Object a;

    public v$b(Object object) {
        this.a = object;
    }

    public Class a() {
        return this.a.getClass();
    }

    public void b() {
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        object = this.a;
        d$a.e(object);
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

