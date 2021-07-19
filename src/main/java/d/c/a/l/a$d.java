/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.a;
import d.c.a.l.a$a;
import d.c.a.l.a$c;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class a$d {
    private final String a;
    private final long[] b;
    public File[] c;
    public File[] d;
    private boolean e;
    private a$c f;
    private long g;
    public final /* synthetic */ a h;

    private a$d(a a10, String string2) {
        int n10;
        this.h = a10;
        this.a = string2;
        Object object = new long[d.c.a.l.a.B(a10)];
        this.b = object;
        object = new File[d.c.a.l.a.B(a10)];
        this.c = (File[])object;
        int n11 = d.c.a.l.a.B(a10);
        object = new File[n11];
        this.d = (File[])object;
        object = new StringBuilder;
        super(string2);
        ((StringBuilder)object).append('.');
        int n12 = ((StringBuilder)object).length();
        for (int i10 = 0; i10 < (n10 = d.c.a.l.a.B(a10)); ++i10) {
            File file;
            ((StringBuilder)object).append(i10);
            File[] fileArray = this.c;
            File file2 = d.c.a.l.a.D(a10);
            String string3 = ((StringBuilder)object).toString();
            fileArray[i10] = file = new File(file2, string3);
            ((StringBuilder)object).append(".tmp");
            fileArray = this.d;
            file2 = d.c.a.l.a.D(a10);
            string3 = ((StringBuilder)object).toString();
            fileArray[i10] = file = new File(file2, string3);
            ((StringBuilder)object).setLength(n12);
        }
    }

    public /* synthetic */ a$d(a a10, String string2, a$a a$a) {
        this(a10, string2);
    }

    public static /* synthetic */ long[] a(a$d a$d) {
        return a$d.b;
    }

    public static /* synthetic */ String b(a$d a$d) {
        return a$d.a;
    }

    public static /* synthetic */ long c(a$d a$d) {
        return a$d.g;
    }

    public static /* synthetic */ long d(a$d a$d, long l10) {
        a$d.g = l10;
        return l10;
    }

    public static /* synthetic */ boolean e(a$d a$d) {
        return a$d.e;
    }

    public static /* synthetic */ boolean f(a$d a$d, boolean bl2) {
        a$d.e = bl2;
        return bl2;
    }

    public static /* synthetic */ a$c g(a$d a$d) {
        return a$d.f;
    }

    public static /* synthetic */ a$c h(a$d a$d, a$c a$c) {
        a$d.f = a$c;
        return a$c;
    }

    public static /* synthetic */ void i(a$d a$d, String[] stringArray) {
        a$d.n(stringArray);
    }

    private IOException m(String[] object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal line: ");
        object = Arrays.toString(object);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void n(String[] stringArray) {
        int n10 = stringArray.length;
        Object object = this.h;
        int n11 = d.c.a.l.a.B((a)object);
        if (n10 != n11) {
            throw this.m(stringArray);
        }
        n10 = 0;
        try {
            while (true) {
                if (n10 >= (n11 = stringArray.length)) {
                    return;
                }
                object = this.b;
                String string2 = stringArray[n10];
                long l10 = Long.parseLong(string2);
                object[n10] = l10;
                ++n10;
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw this.m(stringArray);
        }
    }

    public File j(int n10) {
        return this.c[n10];
    }

    public File k(int n10) {
        return this.d[n10];
    }

    public String l() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long l10 : this.b) {
            char c10 = ' ';
            stringBuilder.append(c10);
            stringBuilder.append(l10);
        }
        return stringBuilder.toString();
    }
}

