/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.Button
 */
package d.v.c.l1;

import android.widget.Button;
import d.v.c.l1.b0;
import d.v.c.l1.x;

public class x$b {
    public static final String b = "googleplay";
    public final /* synthetic */ x a;

    public x$b(x x10) {
        this.a = x10;
    }

    public void a() {
        this.a.n();
        this.a.p(true);
        this.a.q();
        this.a.o();
    }

    public void b() {
        boolean bl2;
        b0.b = bl2 = b0.b ^ true;
        Button button = this.a.e.g;
        String string2 = bl2 ? "\u70b9\u51fb\u5173\u95ed\u6d88\u8d39\u6821\u9a8c" : "\u70b9\u51fb\u5f00\u542f\u6d88\u8d39\u6821\u9a8c";
        button.setText((CharSequence)string2);
    }

    public void c() {
        boolean bl2;
        b0.a = bl2 = b0.a ^ true;
        Button button = this.a.e.f;
        String string2 = bl2 ? "\u70b9\u51fb\u5173\u95ed\u4ea4\u6613\u6821\u9a8c" : "\u70b9\u51fb\u5f00\u542f\u4ea4\u6613\u6821\u9a8c";
        button.setText((CharSequence)string2);
    }

    public void d(int n10, String string2, String string3, boolean bl2, boolean bl3) {
        x.d(this.a).L(n10, string2, string3, bl2, bl3);
    }

    public void e() {
        this.d(6, "prime_one_month", b, false, true);
    }

    public void f() {
        this.d(3, "dingyue_1", b, true, false);
    }

    public void g() {
        this.d(1, "dingyue_12", b, true, false);
    }

    public void h() {
        this.d(11, "dingyue_6", b, true, false);
    }
}

