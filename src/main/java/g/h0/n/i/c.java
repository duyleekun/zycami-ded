/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package g.h0.n.i;

import android.util.Log;
import f.h2.t.f0;
import f.x1.t0;
import g.h0.n.i.d;
import g.z;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

public final class c {
    private static final int a = 4000;
    private static final CopyOnWriteArraySet b;
    private static final Map c;
    public static final c d;

    static {
        Serializable serializable = new c();
        d = serializable;
        serializable = new CopyOnWriteArraySet();
        b = serializable;
        serializable = new LinkedHashMap();
        Object object = z.class.getPackage();
        object = object != null ? ((Package)object).getName() : null;
        if (object != null) {
            String string2 = "OkHttp";
            serializable.put(object, string2);
        }
        object = z.class.getName();
        f0.o(object, "OkHttpClient::class.java.name");
        serializable.put(object, "okhttp.OkHttpClient");
        object = g.h0.l.c.class.getName();
        f0.o(object, "Http2::class.java.name");
        serializable.put(object, "okhttp.Http2");
        object = g.h0.h.d.class.getName();
        f0.o(object, "TaskRunner::class.java.name");
        serializable.put(object, "okhttp.TaskRunner");
        serializable.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        c = t0.D0((Map)((Object)serializable));
    }

    private c() {
    }

    private final void c(String object, String object2) {
        CopyOnWriteArraySet copyOnWriteArraySet = b;
        int n10 = copyOnWriteArraySet.add(object = Logger.getLogger((String)object));
        if (n10 != 0) {
            boolean bl2;
            f0.o(object, "logger");
            copyOnWriteArraySet = null;
            ((Logger)object).setUseParentHandlers(false);
            n10 = Log.isLoggable((String)object2, (int)3);
            object2 = n10 != 0 ? Level.FINE : ((bl2 = Log.isLoggable((String)object2, (int)(n10 = 4))) ? Level.INFO : Level.WARNING);
            ((Logger)object).setLevel((Level)object2);
            object2 = g.h0.n.i.d.a;
            ((Logger)object).addHandler((Handler)object2);
        }
    }

    private final String d(String string2) {
        String string3 = (String)c.get(string2);
        if (string3 == null) {
            int n10 = 23;
            string3 = StringsKt___StringsKt.C8(string2, n10);
        }
        return string3;
    }

    public final void a(String string2, int n10, String string3, Throwable object) {
        f0.p(string2, "loggerName");
        CharSequence charSequence = "message";
        f0.p(string3, (String)charSequence);
        string2 = this.d(string2);
        int n11 = Log.isLoggable((String)string2, (int)n10);
        if (n11 != 0) {
            if (object != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append("\n");
                string3 = Log.getStackTraceString((Throwable)object);
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
            }
            int n12 = 0;
            object = null;
            int n13 = string3.length();
            block0: while (n12 < n13) {
                int n14;
                int n15 = 4;
                charSequence = string3;
                n11 = StringsKt__StringsKt.i3(string3, '\n', n12, false, n15, null);
                if (n11 == (n14 = -1)) {
                    n11 = n13;
                }
                while (true) {
                    n14 = n12 + 4000;
                    n14 = Math.min(n11, n14);
                    Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
                    object = string3.substring(n12, n14);
                    String string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                    f0.o(object, string4);
                    Log.println((int)n10, (String)string2, (String)object);
                    if (n14 >= n11) {
                        n12 = n14 + 1;
                        continue block0;
                    }
                    n12 = n14;
                }
            }
        }
    }

    public final void b() {
        boolean bl2;
        Iterator iterator2 = c.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            String string2 = (String)object.getKey();
            object = (String)object.getValue();
            this.c(string2, (String)object);
        }
    }
}

