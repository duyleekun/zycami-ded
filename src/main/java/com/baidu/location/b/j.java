/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.h.k;
import com.baidu.location.h.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class j {
    private static j a;
    private static String b = "Temp_in.dat";
    private static File c;
    private static StringBuffer d;
    private static boolean e;
    private static int f;
    private static int g;
    private static long h;
    private static long i;
    private static long j;
    private static double k;
    private static double l;
    private static int m;
    private static int n;
    private static int o;

    static {
        double d10;
        long l10;
        File file;
        String string2 = com.baidu.location.h.k.a;
        String string3 = b;
        c = file = new File(string2, string3);
        d = null;
        e = true;
        f = 0;
        g = 0;
        h = l10 = 0L;
        i = l10;
        j = l10;
        k = d10 = 0.0;
        l = d10;
        m = 0;
        n = 0;
        o = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a() {
        byte by2;
        int n10;
        int n11;
        int n12;
        long l10;
        Object object;
        Object object2;
        Object object3;
        block26: {
            object3 = c;
            if (object3 == null) {
                return null;
            }
            boolean bl2 = ((File)object3).exists();
            if (!bl2) {
                return null;
            }
            object2 = c;
            object = "rw";
            object3 = new RandomAccessFile((File)object2, (String)object);
            l10 = 0L;
            ((RandomAccessFile)object3).seek(l10);
            n12 = ((RandomAccessFile)object3).readInt();
            n11 = ((RandomAccessFile)object3).readInt();
            n10 = ((RandomAccessFile)object3).readInt();
            by2 = com.baidu.location.b.j.a(n12, n11, n10);
            if (by2 != 0) break block26;
            ((RandomAccessFile)object3).close();
            com.baidu.location.b.j.c();
            return null;
        }
        if (n11 != 0 && n11 != n10) {
            long l11;
            block27: {
                n10 = (n11 + -1) * 1024 + 12;
                long l12 = (long)n10 + l10;
                ((RandomAccessFile)object3).seek(l12);
                int n13 = ((RandomAccessFile)object3).readInt();
                object = new byte[n13];
                l11 = 4;
                l12 += l11;
                ((RandomAccessFile)object3).seek(l12);
                for (n10 = 0; n10 < n13; ++n10) {
                    by2 = ((RandomAccessFile)object3).readByte();
                    object[n10] = by2;
                    continue;
                }
                object2 = new String((byte[])object);
                int n14 = com.baidu.location.h.l.ah;
                n10 = 1;
                if (n12 < n14) {
                    n11 += n10;
                    break block27;
                }
                if (n11 != n14) {
                    n10 += n11;
                }
                n11 = n10;
            }
            ((RandomAccessFile)object3).seek(l11);
            ((RandomAccessFile)object3).writeInt(n11);
            ((RandomAccessFile)object3).close();
            return object2;
        }
        try {
            ((RandomAccessFile)object3).close();
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static boolean a(int n10, int n11, int n12) {
        int n13;
        int n14;
        if (n10 >= 0 && n10 <= (n14 = com.baidu.location.h.l.ah) && n11 >= 0 && n11 <= (n10 += (n13 = 1)) && n12 >= n13 && n12 <= n10 && n12 <= n14) {
            return n13 != 0;
        }
        return false;
    }

    private static void b() {
        double d10;
        long l10;
        e = true;
        d = null;
        f = 0;
        g = 0;
        h = l10 = 0L;
        i = l10;
        j = l10;
        k = d10 = 0.0;
        l = d10;
        m = 0;
        n = 0;
        o = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean c() {
        Object object;
        File file = c;
        boolean bl2 = file.exists();
        if (bl2) {
            file = c;
            file.delete();
        }
        if (!(bl2 = (file = c.getParentFile()).exists())) {
            file = c.getParentFile();
            file.mkdirs();
        }
        bl2 = false;
        file = null;
        try {
            object = c;
        }
        catch (IOException iOException) {
            return bl2;
        }
        ((File)object).createNewFile();
        File file2 = c;
        String string2 = "rw";
        object = new RandomAccessFile(file2, string2);
        long l10 = 0L;
        ((RandomAccessFile)object).seek(l10);
        ((RandomAccessFile)object).writeInt(0);
        ((RandomAccessFile)object).writeInt(0);
        int n10 = 1;
        ((RandomAccessFile)object).writeInt(n10);
        ((RandomAccessFile)object).close();
        com.baidu.location.b.j.b();
        file = c;
        return file.exists();
    }
}

