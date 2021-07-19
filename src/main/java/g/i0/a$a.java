/*
 * Decompiled with CFR 0.151.
 */
package g.i0;

import f.h2.t.f0;
import f.h2.t.u;
import g.e;
import g.i0.a;
import g.q;
import g.q$c;
import okhttp3.logging.HttpLoggingInterceptor$a;

public class a$a
implements q$c {
    private final HttpLoggingInterceptor$a a;

    public a$a() {
        this(null, 1, null);
    }

    public a$a(HttpLoggingInterceptor$a httpLoggingInterceptor$a) {
        f0.p(httpLoggingInterceptor$a, "logger");
        this.a = httpLoggingInterceptor$a;
    }

    public /* synthetic */ a$a(HttpLoggingInterceptor$a httpLoggingInterceptor$a, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            httpLoggingInterceptor$a = HttpLoggingInterceptor$a.a;
        }
        this(httpLoggingInterceptor$a);
    }

    public q a(e object) {
        f0.p(object, "call");
        HttpLoggingInterceptor$a httpLoggingInterceptor$a = this.a;
        object = new a(httpLoggingInterceptor$a, null);
        return object;
    }
}

