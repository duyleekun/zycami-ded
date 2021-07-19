/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 */
package d.j.f.a.a.j;

import android.content.Context;
import android.os.AsyncTask;
import d.j.f.a.a.j.b;
import d.j.f.a.a.j.c;
import d.j.f.a.a.j.o.a;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.g;
import d.j.f.a.a.j.o.i;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.net.ssl.X509TrustManager;

public class d {
    private static final String a = "SSFSecureX509SingleInstance";
    private static volatile d.j.f.a.a.j.i b;

    private d() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d.j.f.a.a.j.i a(Context context) {
        Objects.requireNonNull(context, "context is null");
        e.b(context);
        Object object = b;
        if (object != null) return b;
        object = d.class;
        synchronized (object) {
            Object[] objectArray;
            Object object2;
            Object object3 = b;
            if (object3 != null) return b;
            object3 = d.j.f.a.a.j.o.a.o(context);
            if (object3 == null) {
                object3 = a;
                object2 = "get assets bks";
                i.e((String)object3, (String)object2);
                object3 = context.getAssets();
                object2 = "hmsrootcas.bks";
                object3 = object3.open((String)object2);
            } else {
                object2 = a;
                objectArray = "get files bks";
                i.e((String)object2, (String)objectArray);
            }
            objectArray = "";
            int n10 = 1;
            b = object2 = new d.j.f.a.a.j.i((InputStream)object3, (String)objectArray, n10 != 0);
            object3 = new g();
            object2 = AsyncTask.THREAD_POOL_EXECUTOR;
            objectArray = new Context[n10];
            n10 = 0;
            objectArray[0] = context;
            object3.executeOnExecutor((Executor)object2, objectArray);
            return b;
        }
    }

    public static void b(InputStream object) {
        long l10;
        Object object2;
        String string2 = a;
        String string3 = "update bks";
        i.e(string2, string3);
        long l11 = System.currentTimeMillis();
        String string4 = " ms";
        if (object != null && (object2 = b) != null) {
            boolean bl2 = true;
            String string5 = "";
            object2 = new d.j.f.a.a.j.i((InputStream)object, string5, bl2);
            b = object2;
            object = new StringBuilder();
            object2 = "updateBks: new SecureX509TrustManager cost : ";
            ((StringBuilder)object).append((String)object2);
            l10 = System.currentTimeMillis() - l11;
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            i.b(string2, (String)object);
            c.b(b);
            object = b;
            d.j.f.a.a.j.b.b((X509TrustManager)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("update bks cost : ");
        l10 = System.currentTimeMillis() - l11;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(string4);
        object = ((StringBuilder)object).toString();
        i.b(string2, (String)object);
    }
}

