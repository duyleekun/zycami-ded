/*
 * Decompiled with CFR 0.151.
 */
package d.v.q.h;

import com.zhiyun.net.NetConfiguration;
import g.u;
import g.z;
import g.z$a;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import k.s;
import k.s$b;

public class g {
    private static final g b;
    private s a;

    static {
        g g10;
        b = g10 = new g();
    }

    private g() {
        Object object = NetConfiguration.create();
        this.a = object = this.b((NetConfiguration)object);
    }

    public static Object a(Class clazz) {
        return g.b.a.g(clazz);
    }

    private s b(NetConfiguration object) {
        Object object2 = new z$a();
        long l10 = ((NetConfiguration)object).getTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object2 = ((z$a)object2).k(l10, timeUnit);
        l10 = ((NetConfiguration)object).getTimeout();
        object2 = ((z$a)object2).j0(l10, timeUnit);
        l10 = ((NetConfiguration)object).getTimeout();
        object2 = ((z$a)object2).R0(l10, timeUnit);
        Object object3 = ((NetConfiguration)object).getRequestInterceptor();
        object2 = ((z$a)object2).c((u)object3);
        object3 = Proxy.NO_PROXY;
        object2 = ((z$a)object2).g0((Proxy)object3);
        object3 = NetConfiguration.create();
        boolean bl2 = ((NetConfiguration)object3).isLogEnable();
        if (bl2) {
            object = ((NetConfiguration)object).getLogInterceptor();
            ((z$a)object2).c((u)object);
        }
        object = ((z$a)object2).f();
        object2 = new s$b();
        return ((s$b)object2).j((z)object).c("https://collect.zhiyun-tech.com/logan_web_war/logan/").f();
    }
}

