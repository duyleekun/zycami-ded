/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.b;

import com.quvideo.mobile.external.platform.httpcore.OooO0o;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO;
import com.quvideo.mobile.external.platform.log.OooO00o;
import d.o.a.a.b.b.a;
import d.o.a.a.b.b.b$a;
import g.a0$a;
import g.j;
import g.u;
import g.z;
import g.z$a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k.e$a;
import k.h$a;
import k.s;
import k.s$b;
import k.x.a.g;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor$Level;

public class b {
    private Map a;
    private j b;

    public b() {
        Object object = new HashMap();
        this.a = object;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.b = object = new j(10, 10, timeUnit);
    }

    private s b(OooO0OO object, boolean bl2) {
        boolean bl3;
        Object object2;
        boolean bl4 = d.o.a.a.b.b.a.f;
        Object object3 = "QuVideoHttpCore";
        if (bl4) {
            object2 = "->initRetrofit";
            OooO00o.OooO00o((String)object3, (String)object2);
        }
        d.o.a.a.b.b.a.g().e();
        object2 = new z$a();
        Object object4 = this.b;
        ((z$a)object2).m((j)object4);
        object4 = TimeUnit.SECONDS;
        long l10 = 20;
        ((z$a)object2).k(l10, (TimeUnit)((Object)object4));
        object4 = d.o.a.a.b.b.a.g().a();
        if (object4 != null && (bl3 = d.o.a.a.b.b.a.f)) {
            OooO00o.OooO00o((String)object3, "->init HttpLoggingInterceptor");
            object3 = new HttpLoggingInterceptor();
            object4 = HttpLoggingInterceptor$Level.BODY;
            ((HttpLoggingInterceptor)object3).g((HttpLoggingInterceptor$Level)((Object)object4));
            ((z$a)object2).c((u)object3);
        }
        object3 = new b$a(this);
        ((z$a)object2).c((u)object3);
        object3 = new s$b();
        object2 = ((z$a)object2).f();
        ((s$b)object3).j((z)object2);
        if (bl2) {
            Object object5 = k.y.a.a.a();
            object5 = ((s$b)object3).b((h$a)object5);
            object2 = g.d();
            ((s$b)object5).a((e$a)object2);
        }
        object = ((OooO0OO)object).OooO0O0().OooO00o();
        ((s$b)object3).c((String)object);
        return ((s$b)object3).f();
    }

    public static /* synthetic */ void c(b b10, a0$a a0$a) {
        b10.d(a0$a);
    }

    private void d(a0$a a0$a) {
        String string2;
        boolean bl2 = d.o.a.a.b.b.a.f;
        if (bl2) {
            string2 = "QuVideoHttpCore";
            String string3 = "->initHeader";
            OooO00o.OooO00o(string2, string3);
        }
        a0$a.a("Content-Type", "application/json");
        a0$a.a("module", "foreign-server");
        a0$a.a("version", "1");
        a0$a.a("rpcType", "dubbo");
        string2 = String.valueOf(System.currentTimeMillis());
        a0$a.a("timestamp", string2);
    }

    public Object a(Class object, String object2, boolean bl2) {
        synchronized (this) {
            block45: {
                Object object3 = d.o.a.a.b.b.a.g();
                object3 = ((a)object3).a();
                object3 = object3.OooO00o((String)object2);
                if (object3 == null) break block45;
                Object object4 = ((OooO0OO)object3).OooO0O0();
                if (object4 == null) break block45;
                object4 = ((OooO0OO)object3).OooO0O0();
                object4 = ((OooO0o)object4).OooO00o();
                if (object4 == null) break block45;
                object4 = ((OooO0OO)object3).OooO0O0();
                object4 = ((OooO0o)object4).OooO00o();
                Object object5 = new StringBuilder();
                String string2 = ((Class)object).getName();
                ((StringBuilder)object5).append(string2);
                string2 = "-";
                ((StringBuilder)object5).append(string2);
                ((StringBuilder)object5).append((String)object4);
                object4 = "-";
                ((StringBuilder)object5).append((String)object4);
                ((StringBuilder)object5).append(bl2);
                object4 = ((StringBuilder)object5).toString();
                object5 = this.a;
                object5 = object5.get(object4);
                if (object5 == null) {
                    boolean bl3 = d.o.a.a.b.b.a.f;
                    if (bl3) {
                        object5 = new StringBuilder();
                        string2 = "getServiceInstance new =";
                        ((StringBuilder)object5).append(string2);
                        ((StringBuilder)object5).append((String)object4);
                        string2 = ",url=";
                        ((StringBuilder)object5).append(string2);
                        ((StringBuilder)object5).append((String)object2);
                        object2 = ((StringBuilder)object5).toString();
                        object5 = "QuVideoHttpCore";
                        OooO00o.OooO00o((String)object5, (String)object2);
                    }
                    object2 = this.a;
                    s s10 = this.b((OooO0OO)object3, bl2);
                    object = s10.g((Class)object);
                    object2.put(object4, object);
                } else {
                    boolean bl4 = d.o.a.a.b.b.a.f;
                    if (bl4) {
                        object = new StringBuilder();
                        String string3 = "getServiceInstance cache =";
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append((String)object4);
                        string3 = ",url=";
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append((String)object2);
                        object = ((StringBuilder)object).toString();
                        object2 = "QuVideoHttpCore";
                        OooO00o.OooO00o((String)object2, (String)object);
                    }
                }
                object = this.a;
                object = object.get(object4);
                return object;
            }
            object2 = "APIServiceFactory httpParams or getDomain or getPlatformDomain == null";
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
    }
}

