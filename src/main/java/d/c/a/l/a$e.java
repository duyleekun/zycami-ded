/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.a;
import d.c.a.l.a$a;
import d.c.a.l.a$c;
import java.io.File;
import java.io.FileInputStream;

public final class a$e {
    private final String a;
    private final long b;
    private final long[] c;
    private final File[] d;
    public final /* synthetic */ a e;

    private a$e(a a10, String string2, long l10, File[] fileArray, long[] lArray) {
        this.e = a10;
        this.a = string2;
        this.b = l10;
        this.d = fileArray;
        this.c = lArray;
    }

    public /* synthetic */ a$e(a a10, String string2, long l10, File[] fileArray, long[] lArray, a$a a$a) {
        this(a10, string2, l10, fileArray, lArray);
    }

    public a$c a() {
        a a10 = this.e;
        String string2 = this.a;
        long l10 = this.b;
        return d.c.a.l.a.h(a10, string2, l10);
    }

    public File b(int n10) {
        return this.d[n10];
    }

    public long c(int n10) {
        return this.c[n10];
    }

    public String d(int n10) {
        File file = this.d[n10];
        FileInputStream fileInputStream = new FileInputStream(file);
        return d.c.a.l.a.q(fileInputStream);
    }
}

