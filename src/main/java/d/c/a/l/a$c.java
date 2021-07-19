/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.a;
import d.c.a.l.a$a;
import d.c.a.l.a$d;
import d.c.a.l.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public final class a$c {
    private final a$d a;
    private final boolean[] b;
    private boolean c;
    public final /* synthetic */ a d;

    private a$c(a object, a$d a$d) {
        this.d = object;
        this.a = a$d;
        boolean bl2 = a$d.e(a$d);
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            int n10 = d.c.a.l.a.B((a)object);
            object = new boolean[n10];
        }
        this.b = (boolean[])object;
    }

    public /* synthetic */ a$c(a a10, a$d d10, a$a a$a) {
        this(a10, d10);
    }

    public static /* synthetic */ a$d c(a$c a$c) {
        return a$c.a;
    }

    public static /* synthetic */ boolean[] d(a$c a$c) {
        return a$c.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private InputStream h(int n10) {
        a a10 = this.d;
        synchronized (a10) {
            Object object = this.a;
            object = a$d.g((a$d)object);
            if (object != this) {
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            object = this.a;
            boolean bl2 = a$d.e((a$d)object);
            if (!bl2) {
                return null;
            }
            try {
                a$d a$d = this.a;
                File file = a$d.j(n10);
                return new FileInputStream(file);
            }
            catch (FileNotFoundException fileNotFoundException) {
                return null;
            }
        }
    }

    public void a() {
        d.c.a.l.a.E(this.d, this, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        boolean bl2 = this.c;
        if (bl2) return;
        try {
            this.a();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public void e() {
        a a10 = this.d;
        boolean bl2 = true;
        d.c.a.l.a.E(a10, this, bl2);
        this.c = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public File f(int n10) {
        a a10 = this.d;
        synchronized (a10) {
            Object object = this.a;
            object = a$d.g((a$d)object);
            if (object != this) {
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            object = this.a;
            boolean bl2 = a$d.e((a$d)object);
            if (!bl2) {
                object = this.b;
                boolean bl3 = true;
                object[n10] = bl3;
            }
            object = this.a;
            File file = ((a$d)object).k(n10);
            object = this.d;
            bl2 = ((File)(object = d.c.a.l.a.D((a)object))).exists();
            if (!bl2) {
                object = this.d;
                object = d.c.a.l.a.D((a)object);
                ((File)object).mkdirs();
            }
            return file;
        }
    }

    public String g(int n10) {
        Object object = this.h(n10);
        if (object != null) {
            object = d.c.a.l.a.q((InputStream)object);
        } else {
            n10 = 0;
            object = null;
        }
        return object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i(int n10, String string2) {
        void var2_5;
        Object object;
        block4: {
            Object object2;
            object = null;
            try {
                object2 = this.f(n10);
                FileOutputStream fileOutputStream = new FileOutputStream((File)object2);
                Charset charset = d.c.a.l.c.b;
                object2 = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block4;
            }
            try {
                ((Writer)object2).write(string2);
            }
            catch (Throwable throwable) {
                object = object2;
                break block4;
            }
            d.c.a.l.c.a((Closeable)object2);
            return;
        }
        d.c.a.l.c.a(object);
        throw var2_5;
    }
}

