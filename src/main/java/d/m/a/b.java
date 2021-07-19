/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.Log
 */
package d.m.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import d.m.a.b$a;
import d.m.a.c;
import d.m.a.e.a;
import d.m.a.e.e;
import d.m.a.g.d;
import d.m.a.g.d$b;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
implements d$b {
    public static final int A = 2;
    public static final int B = 3;
    public static final int C = 100;
    public static final int D = 101;
    public static final int E = 102;
    public static final int F = 103;
    public static final int G = 104;
    public static final int H = 105;
    public static final int I = 106;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 0;
    public static final int z = 1;
    private final String a;
    private Context b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private c h;
    private c i;
    private int j;
    private int k;
    private e l;
    private d.m.a.d.b m;
    private Bitmap n;
    private b$a o;
    private int p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private d v;

    public b(Context context) {
        long l10;
        c c10;
        this.a = "NvCafCreator";
        this.g = 2;
        int n10 = 1;
        this.h = c10 = new c(20, n10);
        this.i = c10 = new c(n10, n10);
        this.j = 0;
        this.k = 90;
        this.p = 101;
        this.q = l10 = 0L;
        this.r = l10;
        this.s = 0;
        this.t = 0;
        this.b = context;
    }

    public b(Context object, String string2, String string3, int n10, int n11, int n12, c c10, c c11, int n13) {
        long l10;
        int n14;
        c c12;
        String string4;
        this.a = string4 = "NvCafCreator";
        this.g = 2;
        int n15 = 1;
        this.h = c12 = new c(20, n15);
        this.i = c12 = new c(n15, n15);
        boolean bl2 = false;
        c12 = null;
        this.j = 0;
        this.k = 90;
        this.p = n14 = 101;
        this.q = l10 = 0L;
        this.r = l10;
        this.s = 0;
        this.t = 0;
        if (object == null) {
            Log.e((String)string4, (String)"NvCafCreator: context is null");
            return;
        }
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            if (string3 != null && !(bl2 = string3.isEmpty())) {
                int n16;
                this.b = object;
                this.c = string2;
                this.d = string3;
                this.e = n10;
                this.f = n11;
                if (c10 != null) {
                    object = this.h;
                    object.a = n16 = c10.a;
                    object.b = n16 = c10.b;
                }
                if (c11 != null) {
                    object = this.i;
                    object.a = n16 = c11.a;
                    object.b = n16 = c11.b;
                }
                this.g = n12;
                this.j = n13;
                this.c();
                this.b();
                return;
            }
            Log.e((String)string4, (String)"NvCafCreator: cafTargetPath is null");
            return;
        }
        Log.e((String)string4, (String)"NvCafCreator: sourcePath is null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        Object object = "initwebp: Input file stream is null";
        Object object2 = this.c.toLowerCase();
        boolean bl2 = ((String)object2).endsWith("webp");
        String string2 = "NvCafCreator";
        if (bl2) {
            block8: {
                block7: {
                    try {
                        object2 = this.b;
                        if (object2 == null) {
                            object2 = "initwebp: Context is null";
                            Log.e((String)string2, (String)object2);
                            return;
                        }
                        object2 = this.c;
                        String string3 = "assets:/";
                        bl2 = ((String)object2).startsWith(string3);
                        if (bl2) {
                            object2 = this.b;
                            object2 = object2.getAssets();
                            string3 = this.c;
                            int n10 = 8;
                            string3 = string3.substring(n10);
                            object2 = object2.open(string3);
                        } else {
                            string3 = this.c;
                            object2 = new FileInputStream(string3);
                        }
                        if (object2 != null) break block7;
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                        break block8;
                    }
                    Log.e((String)string2, (String)object);
                    return;
                }
                this.v = object = d.m.a.g.d.e(this.b);
                if (object != null) return;
                object = "initwebp: create mNvsWebpDecoder failed!";
            }
            Log.e((String)string2, (String)object);
            return;
        }
        object = "initwebp: Input file is not webp";
        Log.e((String)string2, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        block9: {
            String string2;
            Object object;
            block6: {
                block8: {
                    Object object2;
                    block7: {
                        block5: {
                            object = "initgif: Input file stream is null";
                            object2 = this.c.toLowerCase();
                            boolean bl2 = ((String)object2).endsWith("gif");
                            string2 = "NvCafCreator";
                            if (!bl2) break block6;
                            try {
                                object2 = this.b;
                                if (object2 == null) {
                                    object2 = "initgif: Context is null";
                                    Log.e((String)string2, (String)object2);
                                    return;
                                }
                                object2 = this.c;
                                String string3 = "assets:/";
                                bl2 = ((String)object2).startsWith(string3);
                                if (bl2) {
                                    object2 = this.b;
                                    object2 = object2.getAssets();
                                    string3 = this.c;
                                    int n10 = 8;
                                    string3 = string3.substring(n10);
                                    object2 = object2.open(string3);
                                } else {
                                    string3 = this.c;
                                    object2 = new FileInputStream(string3);
                                }
                                if (object2 != null) break block5;
                            }
                            catch (IOException iOException) {
                                iOException.printStackTrace();
                            }
                            Log.e((String)string2, (String)object);
                            return;
                        }
                        this.l = object = new e();
                        if (object != null) break block7;
                        object = "initgif: create gifDecoder failed!";
                        break block8;
                    }
                    ((e)object).h((InputStream)object2);
                    object = this.l;
                    boolean bl3 = ((e)object).g();
                    if (bl3) break block9;
                    object = "initgif: It is not a gif!";
                }
                Log.e((String)string2, (String)object);
                return;
            }
            object = "initgif: Input file is not gif";
            Log.e((String)string2, (String)object);
        }
    }

    public void a(int n10, Bitmap object, long l10) {
        int n11;
        int n12;
        if (object == null) {
            return;
        }
        Object object2 = this.o;
        if (object2 != null) {
            object2.a((Bitmap)object);
        }
        int n13 = this.s;
        long l11 = (long)n13 + l10;
        this.s = n12 = (int)l11;
        while ((n12 = this.t) < (n11 = this.s)) {
            d.m.a.d.b b10 = this.m;
            n12 = (int)(b10.d((Bitmap)object, 90) ? 1 : 0);
            n11 = this.t;
            n13 = this.u;
            this.t = n11 += n13;
        }
        object = this.v;
        int n14 = ((d)object).b;
        n12 = 1;
        if (n14 == (n10 += n12)) {
            object = this.m;
            n14 = (int)(((d.m.a.d.b)object).c() ? 1 : 0);
            String string2 = "NvCafCreator";
            if (n14 == 0) {
                object = "start: writeHeader failed!";
                Log.e((String)string2, (String)object);
            }
            if ((n14 = (int)(((d.m.a.d.b)(object = this.m)).b() ? 1 : 0)) == 0) {
                object = "start: writeFrameIndexTable failed!";
                Log.e((String)string2, (String)object);
            }
            this.s = 0;
            this.t = 0;
            this.p = n14 = 101;
            object = new StringBuilder();
            object2 = "\u89e3\u7801\u5b8c\u6210\uff0c\u603b\u5e27\u6570\u662f\uff1a";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n10);
            Object object3 = ((StringBuilder)object).toString();
            Log.d((String)string2, (String)object3);
            object3 = this.o;
            if (object3 != null) {
                object3.b(n12 != 0);
            }
        }
    }

    public boolean d(Bitmap bitmap, long l10) {
        long l11;
        long l12;
        long l13;
        Object object = this.m;
        if (object == null) {
            Log.e((String)"NvCafCreator", (String)"encodeImageData: m_cafEncoder is null!");
            return false;
        }
        if (bitmap == null) {
            return false;
        }
        object = this.h;
        int n10 = ((c)object).b;
        float f10 = n10;
        float f11 = 1000.0f;
        f10 *= f11;
        float f12 = ((c)object).a;
        int n11 = (int)(f10 /= f12);
        this.q = l13 = this.q + l10;
        while ((l12 = (l11 = (l10 = this.r) - (l13 = this.q)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            Object object2 = this.m;
            int n12 = 90;
            l12 = (long)((d.m.a.d.b)object2).d(bitmap, n12);
            l13 = this.r;
            long l14 = n11;
            this.r = l13 += l14;
            if (l12 == false) {
                return false;
            }
            object2 = this.o;
            if (object2 == null) continue;
            object2.a(bitmap);
        }
        this.p = 102;
        return true;
    }

    public boolean e() {
        Object object = this.m;
        String string2 = "NvCafCreator";
        if (object == null) {
            Log.e((String)string2, (String)"encodeImageData: m_cafEncoder is null!");
            return false;
        }
        boolean bl2 = ((d.m.a.d.b)object).c();
        if (!bl2) {
            Log.e((String)string2, (String)"start: writeHeader failed!");
            object = this.o;
            if (object != null) {
                object.b(false);
            }
            return false;
        }
        object = this.m;
        bl2 = ((d.m.a.d.b)object).b();
        if (!bl2) {
            Log.e((String)string2, (String)"start: writeFrameIndexTable failed!");
            object = this.o;
            if (object != null) {
                object.b(false);
            }
            return false;
        }
        object = this.o;
        boolean bl3 = true;
        if (object != null) {
            object.b(bl3);
        }
        this.p = 101;
        return bl3;
    }

    public int f() {
        Object object = this.h;
        int n10 = ((c)object).b;
        float f10 = n10;
        float f11 = 1000.0f;
        f10 *= f11;
        int n11 = ((c)object).a;
        float f12 = n11;
        f10 /= f12;
        object = this.m;
        if (object != null) {
            f12 = ((d.m.a.d.b)object).a();
            return (int)(f10 * f12);
        }
        return 0;
    }

    public int g() {
        return this.p;
    }

    public Bitmap h() {
        e e10 = this.l;
        if (e10 != null) {
            return e10.c();
        }
        Log.e((String)"NvCafCreator", (String)"GifDecoder is null!");
        return null;
    }

    public long i() {
        e e10 = this.l;
        if (e10 != null) {
            return e10.f();
        }
        Log.e((String)"NvCafCreator", (String)"GifDecoder is null!");
        return 0L;
    }

    public int j() {
        Object object = this.l;
        String string2 = "NvCafCreator";
        if (object != null) {
            boolean bl2 = ((e)object).g();
            if (bl2) {
                return this.l.d();
            }
            object = "Input file is not gif";
        } else {
            object = "GifDecoder is null!";
        }
        Log.e((String)string2, (String)object);
        return 0;
    }

    public void k(b$a b$a) {
        this.o = b$a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int l() {
        String string2;
        float f10;
        int n10;
        Object object;
        String string3;
        int n11;
        int n12;
        block17: {
            block16: {
                block15: {
                    n12 = this.p;
                    n11 = 101;
                    string3 = "NvCafCreator";
                    if (n12 != n11) {
                        Log.e((String)string3, (String)"start: current is running!");
                        return this.p;
                    }
                    object = this.c;
                    n10 = 105;
                    f10 = 1.47E-43f;
                    if (object != null) break block15;
                    object = "start: Input file path is null";
                    break block16;
                }
                string2 = this.d;
                if (string2 != null) break block17;
                object = "start: target file path is null";
            }
            Log.e((String)string3, (String)object);
            this.p = n10;
            return n10;
        }
        Context context = this.b;
        int n13 = this.e;
        int n14 = this.f;
        int n15 = this.g;
        c c10 = this.h;
        c c11 = this.i;
        int n16 = this.j;
        Object object2 = object;
        this.m = object = new d.m.a.d.b(context, string2, n13, n14, n15, c10, c11, n16);
        object = this.l;
        if (object != null && (object = ((e)object).e()) != null) {
            object = this.l;
            n12 = (int)(((e)object).g() ? 1 : 0);
            if (n12 == 0) {
                Log.e((String)string3, (String)"start: It is not a gif!");
                this.p = n12 = 104;
                return n12;
            }
            this.p = 102;
            object = this.h;
            f10 = ((c)object).b;
            float f11 = 1000.0f;
            f10 *= f11;
        } else {
            Log.e((String)string3, (String)"start: create gifDecoder failed!");
            this.p = n12 = 106;
            return n12;
        }
        float f12 = ((c)object).a;
        n12 = (int)(f10 /= f12);
        e e10 = this.l;
        n10 = e10.d();
        object2 = this.l.e();
        ((a)object2).x();
        context = null;
        int n17 = 0;
        string2 = null;
        n13 = 0;
        n14 = 0;
        while (true) {
            block19: {
                Object object3;
                block20: {
                    block18: {
                        if (n17 >= n10) break block18;
                        ((a)object2).e();
                        object3 = ((a)object2).r();
                        this.n = object3;
                        if (object3 == null) break block19;
                        n15 = ((a)object2).l(n17);
                        n13 += n15;
                        break block20;
                    }
                    object = this.m;
                    n12 = (int)(((d.m.a.d.b)object).c() ? 1 : 0);
                    if (n12 == 0) {
                        Log.e((String)string3, (String)"start: writeHeader failed!");
                        object = this.o;
                        if (object != null) {
                            object.b(false);
                        }
                        return this.p;
                    }
                    object = this.m;
                    n12 = (int)(((d.m.a.d.b)object).b() ? 1 : 0);
                    if (n12 == 0) {
                        Log.e((String)string3, (String)"start: writeFrameIndexTable failed!");
                        object = this.o;
                        if (object != null) {
                            object.b(false);
                        }
                        return this.p;
                    }
                    object = this.o;
                    if (object != null) {
                        boolean bl2 = true;
                        object.b(bl2);
                    }
                    this.p = n11;
                    return n11;
                }
                while (n14 < n13) {
                    object3 = this.m;
                    c10 = this.n;
                    int n18 = 90;
                    n15 = (int)(((d.m.a.d.b)object3).d((Bitmap)c10, n18) ? 1 : 0);
                    n14 += n12;
                    if (n15 == 0 || (object3 = this.o) == null) continue;
                    c10 = this.n;
                    object3.a((Bitmap)c10);
                }
            }
            ++n17;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean m(String string2, int n10, int n11, int n12, c c10, c c11, int n13) {
        int n14;
        b b10 = this;
        Object object = c10;
        c c12 = c11;
        String string3 = "NvCafCreator";
        if (string2 != null && (n14 = string2.isEmpty()) == 0) {
            d.m.a.d.b b11;
            long l10;
            int n15;
            this.d = string2;
            n14 = n10;
            this.e = n10;
            this.f = n11;
            if (c10 != null) {
                int n16;
                int n17;
                c c13 = this.h;
                c13.a = n17 = c10.a;
                c13.b = n16 = c10.b;
            }
            if (c12 != null) {
                int n18;
                object = b10.i;
                ((c)object).a = n15 = c12.a;
                ((c)object).b = n18 = c12.b;
            }
            n15 = n12;
            b10.g = n12;
            b10.j = n13;
            b10.q = l10 = 0L;
            b10.r = l10;
            c12 = b10.b;
            c c14 = b10.h;
            c c15 = b10.i;
            object = b11;
            n14 = n10;
            b10.m = b11 = new d.m.a.d.b((Context)c12, string2, n10, n11, n12, c14, c15, n13);
            if (b11 != null) {
                return true;
            }
            object = "startCafEncoder: create cafEncoder failed!";
        } else {
            object = "startCafEncoder: cafTargetPath is null";
        }
        Log.e((String)string3, (String)object);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int n() {
        Object object;
        Object object2;
        float f10;
        int n10;
        String string2;
        int n11;
        block15: {
            block13: {
                String string3;
                block14: {
                    block12: {
                        n11 = this.p;
                        string2 = "NvCafCreator";
                        n10 = 101;
                        f10 = 1.42E-43f;
                        if (n11 != n10) {
                            Log.e((String)string2, (String)"start: current is running!");
                            return this.p;
                        }
                        object2 = this.c;
                        n10 = 105;
                        f10 = 1.47E-43f;
                        if (object2 != null) break block12;
                        object2 = "start: Input file path is null";
                        break block13;
                    }
                    string3 = this.d;
                    if (string3 != null) break block14;
                    object2 = "start: target file path is null";
                    break block13;
                }
                Context context = this.b;
                int n12 = this.e;
                int n13 = this.f;
                int n14 = this.g;
                c c10 = this.h;
                c c11 = this.i;
                int n15 = this.j;
                object = object2;
                this.m = object2 = new d.m.a.d.b(context, string3, n12, n13, n14, c10, c11, n15);
                if (object2 != null) break block15;
                object2 = "start: create cafEncoder failed!";
            }
            Log.e((String)string2, (String)object2);
            this.p = n10;
            return n10;
        }
        object2 = this.v;
        if (object2 == null) {
            Log.e((String)string2, (String)"start: create gifDecoder failed!");
            this.p = n11 = 106;
            return n11;
        }
        this.p = 102;
        object2 = this.h;
        f10 = ((c)object2).b;
        float f11 = 1000.0f;
        f10 *= f11;
        float f12 = ((c)object2).a;
        this.u = n11 = (int)(f10 /= f12);
        n11 = 0;
        f12 = 0.0f;
        object2 = null;
        Object object3 = this.c.toLowerCase();
        n10 = (int)(((String)object3).endsWith((String)(object = "webp")) ? 1 : 0);
        if (n10 != 0) {
            try {
                object3 = this.c;
                object = "assets:/";
                n10 = (int)(((String)object3).startsWith((String)object) ? 1 : 0);
                if (n10 != 0) {
                    object3 = this.b;
                    object3 = object3.getAssets();
                    object = this.c;
                    int n16 = 8;
                    object = ((String)object).substring(n16);
                    object2 = object3.open((String)object);
                } else {
                    object = this.c;
                    object2 = object3 = new FileInputStream((String)object);
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object3 = "initwebp: Input file stream is null";
                Log.e((String)string2, (String)object3);
            }
        }
        this.v.f(this);
        this.v.g((InputStream)object2);
        return this.p;
    }
}

