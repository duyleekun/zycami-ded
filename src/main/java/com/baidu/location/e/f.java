/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.e.f$a;
import com.baidu.location.e.h;
import java.util.Locale;

public final class f {
    private final h a;
    private final SQLiteDatabase b;
    private final f$a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String[] i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private int t;
    private boolean u = true;
    private long v = 8000L;
    private long w;
    private long x;
    private long y;
    private long z;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public f(h object, SQLiteDatabase sQLiteDatabase) {
        f$a f$a;
        void var2_5;
        double d10;
        int n10;
        long l10;
        this.w = l10 = 5000L;
        this.x = l10;
        this.y = l10;
        this.z = l10;
        this.a = object;
        boolean bl2 = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.j = false;
        this.k = false;
        this.l = 6;
        this.m = n10 = 30;
        this.n = n10;
        l10 = 0L;
        this.o = d10 = 0.0;
        this.p = d10;
        this.q = d10;
        this.r = d10;
        this.s = d10;
        this.t = 8;
        String[] stringArray = new String[]{};
        this.i = stringArray;
        this.b = var2_5;
        n10 = 0;
        this.c = f$a = new f$a(this, null);
        if (var2_5 != null && (bl2 = var2_5.isOpen())) {
            String string2 = "CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);";
            try {
                var2_5.execSQL(string2);
            }
            catch (Exception exception) {}
        }
        this.g();
    }

    public static /* synthetic */ double a(f f10, double d10) {
        f10.o = d10;
        return d10;
    }

    public static /* synthetic */ int a(f f10, int n10) {
        f10.l = n10;
        return n10;
    }

    public static /* synthetic */ long a(f f10, long l10) {
        f10.z = l10;
        return l10;
    }

    public static /* synthetic */ boolean a(f f10) {
        return f10.d;
    }

    public static /* synthetic */ boolean a(f f10, boolean bl2) {
        f10.d = bl2;
        return bl2;
    }

    public static /* synthetic */ String[] a(f f10, String[] stringArray) {
        f10.i = stringArray;
        return stringArray;
    }

    public static /* synthetic */ double b(f f10, double d10) {
        f10.p = d10;
        return d10;
    }

    public static /* synthetic */ int b(f f10, int n10) {
        f10.n = n10;
        return n10;
    }

    public static /* synthetic */ long b(f f10, long l10) {
        f10.y = l10;
        return l10;
    }

    public static /* synthetic */ boolean b(f f10) {
        return f10.k;
    }

    public static /* synthetic */ boolean b(f f10, boolean bl2) {
        f10.e = bl2;
        return bl2;
    }

    public static /* synthetic */ double c(f f10, double d10) {
        f10.q = d10;
        return d10;
    }

    public static /* synthetic */ int c(f f10, int n10) {
        f10.m = n10;
        return n10;
    }

    public static /* synthetic */ long c(f f10, long l10) {
        f10.v = l10;
        return l10;
    }

    public static /* synthetic */ boolean c(f f10) {
        return f10.e;
    }

    public static /* synthetic */ boolean c(f f10, boolean bl2) {
        f10.f = bl2;
        return bl2;
    }

    public static /* synthetic */ double d(f f10, double d10) {
        f10.r = d10;
        return d10;
    }

    public static /* synthetic */ int d(f f10, int n10) {
        f10.t = n10;
        return n10;
    }

    public static /* synthetic */ long d(f f10, long l10) {
        f10.w = l10;
        return l10;
    }

    public static /* synthetic */ boolean d(f f10) {
        return f10.f;
    }

    public static /* synthetic */ boolean d(f f10, boolean bl2) {
        f10.g = bl2;
        return bl2;
    }

    public static /* synthetic */ double e(f f10, double d10) {
        f10.s = d10;
        return d10;
    }

    public static /* synthetic */ long e(f f10, long l10) {
        f10.x = l10;
        return l10;
    }

    public static /* synthetic */ boolean e(f f10) {
        return f10.g;
    }

    public static /* synthetic */ boolean e(f f10, boolean bl2) {
        f10.h = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean f(f f10) {
        return f10.h;
    }

    public static /* synthetic */ boolean f(f f10, boolean bl2) {
        f10.j = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean g(f f10) {
        return f10.j;
    }

    public static /* synthetic */ boolean g(f f10, boolean bl2) {
        f10.k = bl2;
        return bl2;
    }

    public static /* synthetic */ int h(f f10) {
        return f10.l;
    }

    public static /* synthetic */ double i(f f10) {
        return f10.o;
    }

    public static /* synthetic */ double j(f f10) {
        return f10.p;
    }

    public static /* synthetic */ double k(f f10) {
        return f10.q;
    }

    public static /* synthetic */ double l(f f10) {
        return f10.r;
    }

    public static /* synthetic */ double m(f f10) {
        return f10.s;
    }

    public static /* synthetic */ long n(f f10) {
        return f10.z;
    }

    public static /* synthetic */ long o(f f10) {
        return f10.y;
    }

    public static /* synthetic */ long p(f f10) {
        return f10.v;
    }

    public static /* synthetic */ long q(f f10) {
        return f10.w;
    }

    public static /* synthetic */ long r(f f10) {
        return f10.x;
    }

    public static /* synthetic */ int s(f f10) {
        return f10.n;
    }

    public static /* synthetic */ int t(f f10) {
        return f10.m;
    }

    public static /* synthetic */ int u(f f10) {
        return f10.t;
    }

    public static /* synthetic */ h v(f f10) {
        return f10.a;
    }

    public int a() {
        return this.t;
    }

    public long a(String string2) {
        boolean bl2;
        String string3 = "2G";
        boolean bl3 = string2.equals(string3);
        long l10 = bl3 ? this.v : ((bl3 = string2.equals(string3 = "3G")) ? this.w : ((bl3 = string2.equals(string3 = "4G")) ? this.x : ((bl3 = string2.equals(string3 = "WIFI")) ? this.y : ((bl2 = string2.equals(string3 = "unknown")) ? this.z : 5000L))));
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String[] object) {
        int n10;
        int n11;
        StringBuffer stringBuffer = new StringBuffer();
        Object[] objectArray = null;
        for (n11 = 0; n11 < (n10 = ((SQLiteDatabase)object).length); ++n11) {
            String string2;
            if (n11 > 0) {
                string2 = ",";
                stringBuffer.append(string2);
            }
            stringBuffer.append("(\"");
            string2 = object[n11];
            stringBuffer.append(string2);
            string2 = "\")";
            stringBuffer.append(string2);
        }
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase == null) return;
        int n12 = sQLiteDatabase.isOpen();
        if (n12 == 0) return;
        n12 = stringBuffer.length();
        if (n12 <= 0) return;
        Locale locale = Locale.US;
        n11 = 1;
        objectArray = new Object[n11];
        String string3 = stringBuffer.toString();
        objectArray[0] = string3;
        String string4 = "INSERT OR IGNORE INTO BLACK VALUES %s;";
        String string5 = String.format(locale, string4, objectArray);
        try {
            SQLiteDatabase sQLiteDatabase2 = this.b;
            sQLiteDatabase2.execSQL(string5);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public double b() {
        return this.o;
    }

    public double c() {
        return this.p;
    }

    public double d() {
        return this.q;
    }

    public double e() {
        return this.r;
    }

    public double f() {
        return this.s;
    }

    public void g() {
        f$a.a(this.c);
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.g;
    }

    public boolean k() {
        return this.e;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.u;
    }

    public int n() {
        return this.l;
    }

    public String[] o() {
        return this.i;
    }

    public int p() {
        return this.n;
    }

    public int q() {
        return this.m;
    }
}

