/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k.y;

import android.util.Log;
import d.c.a.l.a$e;
import d.c.a.o.k.y.a;
import d.c.a.o.k.y.a$b;
import d.c.a.o.k.y.c;
import d.c.a.o.k.y.m;
import java.io.File;
import java.io.IOException;

public class e
implements a {
    private static final String f = "DiskLruCacheWrapper";
    private static final int g = 1;
    private static final int h = 1;
    private static e i;
    private final m a;
    private final File b;
    private final long c;
    private final c d;
    private d.c.a.l.a e;

    public e(File object, long l10) {
        c c10;
        this.d = c10 = new c();
        this.b = object;
        this.c = l10;
        this.a = object = new m();
    }

    public static a d(File file, long l10) {
        e e10 = new e(file, l10);
        return e10;
    }

    public static a e(File object, long l10) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            e e10 = i;
            if (e10 == null) {
                i = e10 = new e((File)object, l10);
            }
            object = i;
            return object;
        }
    }

    private d.c.a.l.a f() {
        synchronized (this) {
            Object object = this.e;
            if (object == null) {
                object = this.b;
                long l10 = this.c;
                int n10 = 1;
                this.e = object = d.c.a.l.a.B0((File)object, n10, n10, l10);
            }
            object = this.e;
            return object;
        }
    }

    private void g() {
        synchronized (this) {
            Object var1_1 = null;
            this.e = null;
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(d.c.a.o.c var1_1, a$b var2_4) {
        var3_6 = "DiskLruCacheWrapper";
        var4_7 = this.a.b((d.c.a.o.c)var1_1);
        var5_8 = this.d;
        var5_8.a(var4_7);
        var6_9 = 2;
        var6_9 = (int)Log.isLoggable((String)var3_6, (int)var6_9);
        if (var6_9 != 0) {
            var5_8 = new StringBuilder();
            var7_10 = "Put: Obtained: ";
            var5_8.append(var7_10);
            var5_8.append(var4_7);
            var7_10 = " for for Key: ";
            var5_8.append(var7_10);
            var5_8.append(var1_1);
            var1_1 = var5_8.toString();
            Log.v((String)var3_6, (String)var1_1);
        }
        try {
            var1_1 = this.f();
            var5_8 = var1_1.w0(var4_7);
            if (var5_8 != null) {
                this.d.b(var4_7);
                return;
            }
        }
        catch (IOException var1_2) {
            var8_11 = 5;
            var8_11 = (int)Log.isLoggable((String)var3_6, (int)var8_11);
            if (var8_11 == 0) return;
            var2_4 = "Unable to put to disk cache";
            Log.w((String)var3_6, (String)var2_4, (Throwable)var1_2);
            return;
        }
        {
            var1_1 = var1_1.t0(var4_7);
            if (var1_1 == null) ** GOTO lbl-1000
            var6_9 = 0;
            var5_8 = null;
        }
        try {
            var5_8 = var1_1.f(0);
            var8_11 = (int)var2_4.a((File)var5_8);
            if (var8_11 == 0) return;
            var1_1.e();
            return;
        }
        finally {
            var1_1.b();
        }
lbl-1000:
        // 1 sources

        {
            var2_4 = new StringBuilder();
            var5_8 = "Had two simultaneous puts for: ";
            var2_4.append((String)var5_8);
            var2_4.append(var4_7);
            var2_4 = var2_4.toString();
            var1_1 = new IllegalStateException((String)var2_4);
            throw var1_1;
        }
    }

    public File b(d.c.a.o.c object) {
        block5: {
            Object object2;
            Object object3 = this.a.b((d.c.a.o.c)object);
            String string2 = f;
            boolean bl2 = Log.isLoggable((String)string2, (int)2);
            if (bl2) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Get: Obtained: ");
                ((StringBuilder)object2).append((String)object3);
                String string3 = " for for Key: ";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                Log.v((String)string2, (String)object);
            }
            object = null;
            object2 = this.f();
            object3 = ((d.c.a.l.a)object2).w0((String)object3);
            if (object3 == null) break block5;
            bl2 = false;
            object2 = null;
            try {
                object = ((a$e)object3).b(0);
            }
            catch (IOException iOException) {
                bl2 = Log.isLoggable((String)string2, (int)5);
                if (!bl2) break block5;
                object2 = "Unable to get from disk cache";
                Log.w((String)string2, (String)object2, (Throwable)iOException);
            }
        }
        return object;
    }

    public void c(d.c.a.o.c object) {
        block3: {
            Object object2 = this.a;
            object = ((m)object2).b((d.c.a.o.c)object);
            object2 = this.f();
            try {
                ((d.c.a.l.a)object2).G0((String)object);
            }
            catch (IOException iOException) {
                String string2 = f;
                boolean bl2 = Log.isLoggable((String)string2, (int)5);
                if (!bl2) break block3;
                object2 = "Unable to delete from disk cache";
                Log.w((String)string2, (String)object2, (Throwable)iOException);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        synchronized (this) {
            var1_1 = this.f();
            var1_1.r0();
lbl5:
            // 3 sources

            while (true) {
                this.g();
                return;
            }
            {
                catch (Throwable var1_2) {
                }
                catch (IOException var1_3) {}
                var2_4 = "DiskLruCacheWrapper";
                var3_5 = 5;
                var4_6 = Log.isLoggable((String)var2_4, (int)var3_5);
                if (!var4_6) ** GOTO lbl5
                var2_4 = "DiskLruCacheWrapper";
                var5_7 = "Unable to clear disk cache or disk cache cleared externally";
                Log.w((String)var2_4, (String)var5_7, (Throwable)var1_3);
                ** continue;
            }
            this.g();
            throw var1_2;
        }
    }
}

