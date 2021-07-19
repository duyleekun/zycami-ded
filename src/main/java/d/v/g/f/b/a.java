/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import androidx.room.migration.Migration;
import d.v.g.f.b.a$a;
import d.v.g.f.b.a$b;
import d.v.g.f.b.a$c;
import d.v.g.f.b.a$d;
import d.v.g.f.b.a$e;
import d.v.g.f.b.a$f;
import d.v.g.f.b.a$g;
import d.v.g.f.b.a$h;
import d.v.g.f.b.a$i;
import d.v.g.f.b.a$j;

public class a {
    public static final Migration a;
    public static final Migration b;
    public static final Migration c;
    public static final Migration d;
    public static final Migration e;
    public static final Migration f;
    public static final Migration g;
    public static final Migration h;
    public static final Migration i;
    public static final Migration j;
    public static final Migration[] k;

    static {
        int n10 = 1;
        int n11 = 2;
        a$b a$b = new a$b(n10, n11);
        a = a$b;
        int n12 = 3;
        a$c a$c = new a$c(n11, n12);
        b = a$c;
        int n13 = 4;
        a$d a$d = new a$d(n12, n13);
        c = a$d;
        int n14 = 5;
        a$e a$e = new a$e(n13, n14);
        d = a$e;
        int n15 = 6;
        a$f a$f = new a$f(n14, n15);
        e = a$f;
        int n16 = 7;
        a$g a$g = new a$g(n15, n16);
        f = a$g;
        int n17 = 8;
        a$h a$h = new a$h(n16, n17);
        g = a$h;
        n16 = 9;
        a$i a$i = new a$i(n17, n16);
        h = a$i;
        n15 = 10;
        a$j a$j = new a$j(n16, n15);
        i = a$j;
        a$a a$a = new a$a(n15, 11);
        j = a$a;
        Migration[] migrationArray = new Migration[n15];
        migrationArray[0] = a$b;
        migrationArray[n10] = a$c;
        migrationArray[n11] = a$d;
        migrationArray[n12] = a$e;
        migrationArray[n13] = a$f;
        migrationArray[5] = a$g;
        migrationArray[6] = a$h;
        migrationArray[7] = a$i;
        migrationArray[8] = a$j;
        migrationArray[9] = a$a;
        k = migrationArray;
    }
}

