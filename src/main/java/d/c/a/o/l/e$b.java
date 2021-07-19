/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.l.e$a;
import java.io.IOException;

public final class e$b
implements d {
    private final String a;
    private final e$a b;
    private Object c;

    public e$b(String string2, e$a e$a) {
        this.a = string2;
        this.b = e$a;
    }

    public Class a() {
        return this.b.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        e$a e$a;
        try {
            e$a = this.b;
        }
        catch (IOException iOException) {
            return;
        }
        Object object = this.c;
        e$a.b(object);
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        object = this.b;
        String string2 = this.a;
        object = object.decode(string2);
        this.c = object;
        try {
            d$a.e(object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            d$a.c(illegalArgumentException);
        }
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

