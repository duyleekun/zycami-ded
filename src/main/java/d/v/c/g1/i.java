/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.g1;

import android.content.Context;
import android.text.TextUtils;
import com.zhiyun.net.download.DownLoadHelper;
import d.v.c.g1.a;
import d.v.c.g1.b;
import d.v.c.g1.c;
import d.v.c.g1.d;
import d.v.c.g1.e;
import d.v.c.g1.f;
import d.v.c.g1.g;
import d.v.c.g1.h;
import d.v.c.g1.i$a;
import d.v.c.g1.i$b;
import d.v.c.g1.i$c;
import d.v.c.g1.i$d;
import d.v.c.g1.j;
import d.v.e.l.k2;
import d.v.e.l.p2;
import d.v.e.l.s1;
import d.v.e.l.u1;
import e.a.b0;
import e.a.c0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import l.a.q.g0.s;

public class i {
    private static final boolean g = false;
    private static final String h = "hotres";
    private static final String i = "hotres/tmp";
    private static final String j = "hotres/tmp/unzip";
    private static final String k = "hotres/translation";
    private static final int l = 2;
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private e.a.s0.a f;

    public i() {
        e.a.s0.a a10;
        this.f = a10 = new e.a.s0.a();
    }

    private /* synthetic */ void A(Throwable object) {
        int n10 = this.e;
        int n11 = 2;
        if (n10 <= n11) {
            object = this.b;
            this.k((String)object);
        } else {
            object = this.n(j);
            this.m((File)object);
        }
    }

    private void C(String object) {
        int n10;
        this.e = n10 = this.e + 1;
        this.f.e();
        object = z.t3(object);
        Object object2 = new h(this);
        object = ((z)object).H3((o)object2);
        object2 = new c(this);
        b b10 = new b(this);
        object = ((z)object).c((e.a.v0.g)object2, b10);
        this.f.b((e.a.s0.b)object);
    }

    public static /* synthetic */ int a(i i10, int n10) {
        i10.a = n10;
        return n10;
    }

    public static /* synthetic */ String b(i i10) {
        return i10.b;
    }

    public static /* synthetic */ String c(i i10, String string2) {
        i10.b = string2;
        return string2;
    }

    public static /* synthetic */ File d(i i10, String string2) {
        return i10.n(string2);
    }

    public static /* synthetic */ void e(i i10, File file) {
        i10.p(file);
    }

    public static /* synthetic */ void f(i i10, String string2) {
        i10.k(string2);
    }

    public static /* synthetic */ int g(i i10) {
        return i10.c;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean h(String object, String object2, boolean bl2) {
        void var1_8;
        Object object3;
        block10: {
            block11: {
                boolean bl3;
                if (!bl2) {
                    return s1.f((String)object, (String)object2);
                }
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) return false;
                bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (bl2) return false;
                bl2 = s1.q((String)object);
                if (!bl2) {
                    return false;
                }
                bl2 = false;
                object3 = null;
                try {
                    FileInputStream fileInputStream = new FileInputStream((String)object);
                    bl3 = true;
                    object = new FileOutputStream((String)object2, bl3);
                    object2 = fileInputStream.getChannel();
                }
                catch (Throwable throwable) {
                    object2 = null;
                    break block10;
                }
                catch (Exception exception) {
                    object2 = null;
                    break block11;
                }
                try {
                    object3 = ((FileOutputStream)object).getChannel();
                    long l10 = 0L;
                    long l11 = ((FileChannel)object2).size();
                    ((FileChannel)object2).transferTo(l10, l11, (WritableByteChannel)object3);
                }
                catch (Throwable throwable) {
                    FileChannel fileChannel = object3;
                    object3 = object2;
                    object2 = fileChannel;
                    break block10;
                }
                catch (Exception exception) {
                    FileChannel fileChannel = object3;
                    object3 = object2;
                    object2 = fileChannel;
                    break block11;
                }
                u1.a((Closeable)object2);
                u1.a((Closeable)object3);
                return bl3;
            }
            try {
                void var1_6;
                m.a.a.f((Throwable)var1_6);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block10;
            }
            u1.a(object3);
            u1.a((Closeable)object2);
            return false;
        }
        u1.a(object3);
        u1.a((Closeable)object2);
        throw var1_8;
    }

    private void i(File object) {
        CharSequence charSequence = new StringBuilder();
        Object object2 = this.n(k);
        charSequence.append(object2);
        charSequence.append("/");
        object2 = ((File)object).getName();
        String string2 = "values-";
        object2 = ((String)object2).replace(string2, "");
        charSequence.append((String)object2);
        charSequence.append(".xml");
        charSequence = charSequence.toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append("/strings.xml");
        object = ((StringBuilder)object2).toString();
        boolean bl2 = true;
        int n10 = this.h((String)object, (String)charSequence, bl2);
        for (int i10 = 0; n10 == 0 && i10 <= (n10 = 2); ++i10) {
            n10 = (int)(this.h((String)object, (String)charSequence, bl2) ? 1 : 0);
        }
    }

    private void k(String object) {
        int n10;
        this.d = n10 = this.d + 1;
        this.f.e();
        Object object2 = new f(this, (String)object);
        object = z.y1((c0)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).i4((h0)object2);
        object2 = new g(this);
        e e10 = new e(this);
        object = ((z)object).c((e.a.v0.g)object2, e10);
        this.f.b((e.a.s0.b)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void l(File object) {
        String string2;
        int n10 = ((File)object).isDirectory();
        if (n10 == 0) return;
        Object object2 = ((File)object).getName();
        n10 = ((String)object2).startsWith(string2 = "values");
        if (n10 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(object);
            string2 = "/strings.xml";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            n10 = (int)(s1.q((String)object2) ? 1 : 0);
            if (n10 != 0) {
                this.i((File)object);
                return;
            }
        }
        if ((object = ((File)object).listFiles((FileFilter)(object2 = d.v.c.g1.a.a))) == null) return;
        n10 = ((Object)object).length;
        if (n10 == 0) {
            return;
        }
        object = Arrays.stream(object);
        object2 = new d(this);
        object.forEach(object2);
    }

    private void m(File file) {
        boolean bl2 = s1.p(file);
        if (!bl2) {
            return;
        }
        File file2 = this.n(k);
        s1.g(file2);
        this.l(file);
        this.p(file2);
    }

    private File n(String string2) {
        return k2.J(string2);
    }

    public static i o() {
        return i$d.a();
    }

    private void p(File object) {
        s s10 = s.a();
        Context context = d.v.e.f.a().c();
        object = ((File)object).getPath();
        i$c i$c = new i$c(this);
        s10.b(context, (String)object, i$c);
        s.a().c("en");
    }

    public static /* synthetic */ void q(i i10, File file) {
        i10.l(file);
    }

    private /* synthetic */ void r(String string2, b0 b02) {
        Object object = i;
        s1.g(this.n((String)object));
        object = this.n((String)object);
        DownLoadHelper downLoadHelper = DownLoadHelper.getInstance();
        object = ((File)object).getAbsolutePath();
        i$b i$b = new i$b(this, b02);
        downLoadHelper.startThreadPoolDownLoad(string2, (String)object, "res.zip", i$b);
    }

    private /* synthetic */ void t(Throwable object) {
        int n10 = this.d;
        int n11 = 2;
        if (n10 <= n11) {
            object = this.b;
            this.k((String)object);
        } else {
            object = this.n(k);
            this.p((File)object);
        }
    }

    public static /* synthetic */ void v(i i10, String string2) {
        i10.C(string2);
    }

    private /* synthetic */ File w(String object) {
        File file = this.n(j);
        CharSequence charSequence = new StringBuilder();
        String string2 = file.getAbsolutePath();
        charSequence.append(string2);
        string2 = File.separator;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        boolean bl2 = p2.c((String)object, (String)charSequence);
        if (bl2) {
            return file;
        }
        object = new IllegalAccessException("\u8d44\u6e90\u89e3\u538b\u5f02\u5e38......");
        throw object;
    }

    private /* synthetic */ void y(File file) {
        this.m(file);
        d.v.c.g1.j.B(this.a);
    }

    public /* synthetic */ void B(Throwable throwable) {
        this.A(throwable);
    }

    public void j() {
        int n10;
        this.c = n10 = this.c + 1;
        Object object = d.v.c.v0.l.a.a;
        int n11 = d.v.c.g1.j.A();
        object = object.d("Android", "zycami", n11);
        i$a i$a = new i$a(this);
        object.h(i$a);
    }

    public /* synthetic */ void s(String string2, b0 b02) {
        this.r(string2, b02);
    }

    public /* synthetic */ void u(Throwable throwable) {
        this.t(throwable);
    }

    public /* synthetic */ File x(String string2) {
        return this.w(string2);
    }

    public /* synthetic */ void z(File file) {
        this.y(file);
    }
}

