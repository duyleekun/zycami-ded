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
import d.j.f.a.a.j.g;
import d.j.f.a.a.j.o.a;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.f;
import d.j.f.a.a.j.o.i;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.net.ssl.X509TrustManager;

public class h {
    private static final String a = "SecureX509SingleInstance";
    private static volatile d.j.f.a.a.j.i b;

    private h() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d.j.f.a.a.j.i a(Context object) {
        long l10 = System.currentTimeMillis();
        Objects.requireNonNull(object, "context is null");
        e.b(object);
        Object object2 = b;
        if (object2 == null) {
            object2 = h.class;
            synchronized (object2) {
                Object object3 = b;
                if (object3 == null) {
                    Object[] objectArray;
                    Object object4;
                    object3 = d.j.f.a.a.j.o.a.o(object);
                    if (object3 == null) {
                        object3 = a;
                        object4 = "get assets bks";
                        i.e((String)object3, (String)object4);
                        object3 = object.getAssets();
                        object4 = "hmsrootcas.bks";
                        object3 = object3.open((String)object4);
                    } else {
                        object4 = a;
                        objectArray = "get files bks";
                        i.e((String)object4, (String)objectArray);
                    }
                    objectArray = "";
                    b = object4 = new d.j.f.a.a.j.i((InputStream)object3, (String)objectArray);
                    object3 = new f();
                    object4 = AsyncTask.THREAD_POOL_EXECUTOR;
                    int n10 = 1;
                    objectArray = new Context[n10];
                    objectArray[0] = object;
                    object3.executeOnExecutor((Executor)object4, objectArray);
                }
            }
        }
        object = a;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("SecureX509TrustManager getInstance: cost : ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append(" ms");
        String string2 = ((StringBuilder)object2).toString();
        i.b((String)object, string2);
        return b;
    }

    public static void b(InputStream object) {
        d.j.f.a.a.j.i i10;
        String string2 = a;
        String string3 = "update bks";
        i.e(string2, string3);
        long l10 = System.currentTimeMillis();
        if (object != null && (i10 = b) != null) {
            String string4 = "";
            b = i10 = new d.j.f.a.a.j.i((InputStream)object, string4);
            g.b(b);
            object = b;
            d.j.f.a.a.j.f.b((X509TrustManager)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("SecureX509TrustManager update bks cost : ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append(" ms");
        object = ((StringBuilder)object).toString();
        i.e(string2, (String)object);
    }
}

