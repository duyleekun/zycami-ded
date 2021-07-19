/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Log
 */
package d.m.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import d.m.a.d.c;
import d.m.a.d.d;
import d.m.a.f.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class b {
    private final String a;
    private String b;
    private a c;
    private FileChannel d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private long o;
    private int p;
    private d q;
    private int r;
    private List s;
    private int t;
    private Bitmap u;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public b(Context object, String object2, int n10, int n11, int n12, d.m.a.c c10, d.m.a.c c11, int n13) {
        int n14;
        ArrayList arrayList;
        long l10;
        int n15;
        int n16;
        this.a = "NvCafEncoder";
        this.e = n16 = 1;
        this.h = n15 = 15;
        this.i = n16;
        this.j = n16;
        this.k = n16;
        this.l = n15;
        this.m = n16;
        this.n = n16 = 90;
        this.o = l10 = 4096L;
        this.s = arrayList = new ArrayList();
        if (object == null) return;
        if (object2 == null) return;
        int n17 = ((String)object2).isEmpty();
        if (n17 != 0) {
            return;
        }
        this.b = object2;
        this.f = n10;
        this.g = n11;
        this.e = n12;
        if (c10 != null) {
            this.h = n17 = c10.a;
            this.i = n17 = c10.b;
        }
        if (c11 != null) {
            this.j = n17 = c11.a;
            this.k = n17 = c11.b;
        }
        this.m = n13;
        try {
            object2 = this.b;
            object = new File((String)object2);
            n14 = (int)(((File)object).exists() ? 1 : 0);
            if (n14 == 0) {
                ((File)object).createNewFile();
            } else {
                ((File)object).delete();
            }
            object2 = this.b;
            this.c = object = new a((String)object2);
            this.d = object = ((FileOutputStream)object).getChannel();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        n14 = 16;
        this.p = n17 = d.m.a.f.c.a(64, n14);
        this.r = n14;
        try {
            object2 = this.d;
            long l11 = n17;
            long l12 = this.o;
            ((FileChannel)object2).position(l11 += l12);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.q = object = new d();
    }

    public int a() {
        return this.l;
    }

    public boolean b() {
        a a10;
        Object object = this.d;
        if (object != null && (a10 = this.c) != null) {
            int n10 = this.t;
            long l10 = n10;
            ((FileChannel)object).position(l10);
            object = this.s;
            int n11 = object.size();
            a10 = null;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object2 = this.s;
                object2 = object2.get(n10);
                object2 = (c)object2;
                a a11 = this.c;
                long l11 = ((c)object2).a;
                a11.S(l11);
                a11 = this.c;
                int n12 = ((c)object2).b;
                a11.O(n12);
                a11 = this.c;
                int n13 = ((c)object2).c;
                a11.O(n13);
                continue;
            }
            try {
                object = this.c;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
            ((OutputStream)object).flush();
            object = this.c;
            ((FileOutputStream)object).close();
            return true;
        }
        Log.e((String)"NvCafEncoder", (String)"writeFrameIndexTable: m_outStream == null");
        return false;
    }

    public boolean c() {
        int n10;
        int n11;
        int n12;
        this.t = 0;
        Object object = this.s;
        this.l = n12 = object.size();
        long l10 = n12;
        long l11 = this.o;
        int n13 = this.r;
        long l12 = n13;
        long l13 = l10 - (l11 /= l12);
        n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        int n14 = 1;
        if (n12 <= 0) {
            n12 = this.p;
        } else {
            object = this.s;
            n11 = object.size() - n14;
            l11 = ((c)object.get((int)n11)).a;
            object = this.s;
            n13 = object.size() - n14;
            object = (c)object.get(n13);
            l12 = ((c)object).b;
            n12 = (int)(l11 += l12);
            n11 = 16;
            n12 = d.m.a.f.c.a(n12, n11);
        }
        this.t = n12;
        object = this.q;
        Object object2 = ".CAF";
        ((d)object).a = object2;
        ((d)object).b = n14;
        ((d)object).c = 64;
        n11 = this.e;
        object2 = n11 == 0 ? "JPEG" : "PNG ";
        ((d)object).d = object2;
        ((d)object).e = 0;
        ((d)object).f = n11 = this.f;
        ((d)object).g = n11 = this.g;
        ((d)object).h = n11 = this.j;
        ((d)object).i = n11 = this.k;
        ((d)object).j = n11 = this.h;
        ((d)object).k = n11 = this.i;
        ((d)object).l = n11 = this.l;
        n11 = this.m;
        ((d)object).m = n11 != n14 ? (n11 != (n10 = 2) && n11 != (n10 = 3) ? 0 : n10) : n14;
        ((d)object).n = 0;
        n11 = this.t;
        ((d)object).o = l11 = (long)n11;
        object = this.d;
        if (object != null && (object2 = this.c) != null) {
            l11 = 0L;
            try {
                ((FileChannel)object).position(l11);
                object = this.c;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
            object2 = this.q;
            object2 = ((d)object2).a;
            object2 = ((String)object2).getBytes();
            ((FileOutputStream)object).write((byte[])object2);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).b;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).c;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            object2 = ((d)object2).d;
            object2 = ((String)object2).getBytes();
            ((FileOutputStream)object).write((byte[])object2);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).e;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).f;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).g;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).h;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).i;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).j;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).k;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).l;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).m;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            n11 = ((d)object2).n;
            ((a)object).O(n11);
            object = this.c;
            object2 = this.q;
            l11 = ((d)object2).o;
            ((a)object).S(l11);
            object = this.c;
            ((OutputStream)object).flush();
            return n14 != 0;
        }
        Log.e((String)"NvCafEncoder", (String)"writeHeader: m_outStream == null");
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(Bitmap var1_1, int var2_2) {
        block7: {
            var3_3 = "NvCafEncoder";
            if (var1_1 == null) {
                var1_1 = "writeOneImage: bitmap is null";
lbl4:
                // 2 sources

                while (true) {
                    Log.e((String)var3_3, (String)var1_1);
                    return false;
                }
            }
            var4_4 = this.d;
            if (var4_4 == null || (var5_5 = this.c) == null) break block7;
            this.n = var2_2;
            try {
                var6_6 = var4_4.position();
            }
            catch (Exception v0) {
                v0.printStackTrace();
                return false;
            }
            var8_7 = (long)15 & var6_6;
            var10_8 = 0L;
            var12_9 = var8_7 == var10_8 ? 0 : (var8_7 < var10_8 ? -1 : 1);
            if (var12_9 <= 0) ** GOTO lbl28
            var12_9 = (int)var6_6;
            var13_10 = 16;
            {
                var12_9 = d.m.a.f.c.a((int)var12_9, var13_10);
                var6_6 = var12_9;
                var3_3 = this.d;
                var3_3.position(var6_6);
lbl28:
                // 2 sources

                var12_9 = var1_1.getWidth();
                var14_11 = var1_1.getHeight();
                var15_12 = this.f;
                if (var15_12 <= 0 || (var15_12 = this.g) <= 0) {
                    this.f = (int)var12_9;
                    this.g = var14_11;
                }
                if (var12_9 != (var15_12 = this.f) || var14_11 != (var12_9 = (long)this.g)) {
                    var12_9 = this.g;
                    var1_1 = d.m.a.f.c.h((Bitmap)var1_1, var15_12, (int)var12_9);
                }
                this.u = var1_1;
                var1_1 = new ByteArrayOutputStream();
                var3_3 = this.u;
                var16_13 = Bitmap.CompressFormat.PNG;
                var3_3.compress(var16_13, var2_2, (OutputStream)var1_1);
                var1_1 = var1_1.toByteArray();
                var17_14 = this.c;
                var17_14.write((byte[])var1_1);
                var17_14 = this.c;
                var17_14.flush();
                var17_14 = new c();
                var17_14.b = var18_15 = ((Bitmap)var1_1).length;
                var17_14.a = var6_6;
                var17_14.c = 0;
                var1_1 = this.s;
                var1_1.add(var17_14);
                return true;
            }
        }
        var1_1 = "writeOneImage: m_outStream == null";
        ** while (true)
    }
}

