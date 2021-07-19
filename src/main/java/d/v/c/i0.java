/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import d.v.c.a1.a;
import d.v.c.b0;
import d.v.c.f;
import d.v.c.i0$a;
import d.v.c.i0$b;
import d.v.c.i0$c;
import d.v.c.i0$d;
import d.v.c.i0$e;
import d.v.c.m;
import d.v.c.n;
import d.v.c.o;
import d.v.c.p;
import d.v.c.r;
import d.v.c.s;
import d.v.c.v0.r.b.g;
import d.v.c.v0.s.c.e;
import d.v.c.v0.z.c.b;
import d.v.c.x;
import d.v.e.l.b2;
import d.v.e.l.c1;
import d.v.e.l.f1;
import d.v.e.l.p2;
import d.v.e.l.s1;
import d.v.j.e.c;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class i0 {
    private i0$c a;

    private i0() {
        i0$c i0$c;
        this.a = i0$c = new i0$c(null);
    }

    public /* synthetic */ i0(i0$a i0$a) {
        this();
    }

    private boolean A(String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = d.v.e.j.b.f().getAbsolutePath();
        charSequence.append(string3);
        string3 = File.separator;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        boolean bl2 = p2.c(string2, (String)charSequence);
        if (!bl2) {
            int n10 = 43000;
            String string4 = "\u89e3\u538b\u6587\u4ef6\u5931\u8d25";
            Exception exception = new Exception(string4);
            d.v.q.e.j(n10, exception, string4);
        }
        s1.h(string2);
        return bl2;
    }

    private boolean B() {
        boolean bl2 = this.f();
        i0$d.G(bl2);
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private CompletableFuture a() {
        block4: {
            var1_1 /* !! */  = this.a;
            var2_2 = new n(this);
            var1_1 /* !! */ .l((Runnable)var2_2);
            var1_1 /* !! */  = this.c();
            var2_2 = this.d();
            var3_3 = 2;
            var4_4 = 1;
            if (var1_1 /* !! */  != null || var2_2 != null) break block4;
            this.a.d(var3_3);
            var1_1 /* !! */  = new CompletableFuture<U>(this);
            var1_1 /* !! */  = CompletableFuture.supplyAsync(var1_1 /* !! */ );
            ** GOTO lbl18
        }
        if (var1_1 /* !! */  == null) {
            this.a.d(var4_4);
            var1_1 /* !! */  = new CompletableFuture<U>(this);
            var1_1 /* !! */  = var2_2.thenApplyAsync((Function)var1_1 /* !! */ );
lbl18:
            // 3 sources

            while (true) {
                var3_3 = var4_4;
                break;
            }
        } else {
            if (var2_2 == null) {
                this.a.d(var4_4);
                var2_2 = new s(this);
                var1_1 /* !! */  = var1_1 /* !! */ .thenApplyAsync((Function)var2_2);
                ** continue;
            }
            this.a.d(0);
            var5_5 = new o(this);
            var1_1 /* !! */  = var1_1 /* !! */ .thenCombineAsync((CompletionStage)var2_2, (BiFunction)var5_5);
        }
        var2_2 = this.a;
        var5_5 = new d.v.c.e(this, var3_3);
        var2_2.l((Runnable)var5_5);
        return var1_1 /* !! */ ;
    }

    private CompletableFuture c() {
        boolean bl2 = i0$d.B();
        if (bl2) {
            return null;
        }
        return CompletableFuture.supplyAsync(m.a);
    }

    private CompletableFuture d() {
        boolean bl2 = i0$d.z();
        if (bl2) {
            return null;
        }
        f f10 = new f(this);
        return CompletableFuture.supplyAsync(f10);
    }

    public static i0 e() {
        return i0$e.a();
    }

    private boolean f() {
        boolean bl2 = c.a().j();
        g.k().l();
        d.v.c.v0.y.b.e.l().m();
        e.k().m();
        b.f().g();
        d.v.c.v0.v.c.s.p().w();
        Executor executor = c1.b().d();
        x x10 = x.a;
        executor.execute(x10);
        return bl2;
    }

    private boolean g(boolean bl2) {
        i0$c i0$c = this.a;
        i0$c.r();
        i0$d.E(bl2);
        if (bl2) {
            this.a.s(1);
            return this.B();
        }
        return false;
    }

    private /* synthetic */ void h() {
        this.a.q();
    }

    private /* synthetic */ Boolean j() {
        return this.g(true);
    }

    private /* synthetic */ Boolean l(Boolean bl2) {
        boolean bl3 = bl2;
        return this.g(bl3);
    }

    private /* synthetic */ Boolean n(Boolean bl2) {
        boolean bl3 = bl2;
        return this.g(bl3);
    }

    private /* synthetic */ Boolean p(Boolean bl2, Boolean bl3) {
        boolean bl4 = bl2;
        if (bl4 && (bl4 = bl3.booleanValue())) {
            bl4 = true;
        } else {
            bl4 = false;
            bl2 = null;
        }
        return this.g(bl4);
    }

    private /* synthetic */ void r(int n10) {
        i0$c i0$c = this.a;
        int n11 = i0$c.a(i0$c);
        i0$c.p(n11);
        this.a.s(n10);
    }

    public static /* synthetic */ Boolean t() {
        String[] stringArray = b0.s;
        String string2 = d.v.e.j.b.f().getAbsolutePath();
        boolean bl2 = f1.c(stringArray, string2);
        i0$d.F(bl2);
        return bl2;
    }

    private /* synthetic */ Boolean u() {
        Object object = d.v.e.f.a().c();
        boolean bl2 = b2.m(object);
        if (!bl2) {
            return Boolean.FALSE;
        }
        object = d.v.e.j.b.f().getAbsolutePath();
        String string2 = "assets.zip";
        a a10 = d.v.c.a1.a.d();
        boolean bl3 = a10.b((String)object, string2);
        boolean bl4 = false;
        if (bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = File.separator;
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            bl2 = this.A((String)object);
        } else {
            bl2 = false;
            object = null;
        }
        if (bl3 && bl2) {
            bl4 = true;
        }
        return bl4;
    }

    private /* synthetic */ void w(Boolean object) {
        int n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
        if (n10 != 0) {
            object = this.a;
            int n11 = 100;
            ((i0$c)object).p(n11);
            this.a.n();
            object = this.a;
            ((i0$c)object).c();
            n10 = 1;
            i0$d.H(n10);
        } else {
            object = this.a;
            String string2 = "\u4fdd\u5b58\u9519\u8bef--------";
            Exception exception = new Exception(string2);
            ((i0$c)object).o(exception);
        }
        this.a.r();
    }

    private /* synthetic */ Void y(Throwable throwable) {
        this.a.o(throwable);
        this.a.r();
        return null;
    }

    public void C(i0$b i0$b) {
        if (i0$b != null) {
            i0$c i0$c = this.a;
            i0$c.m(i0$b);
        }
    }

    public boolean D() {
        boolean bl2 = i0$d.z();
        bl2 = bl2 && (bl2 = i0$d.C());
        return bl2;
    }

    public void E() {
        CompletionStage completionStage = this.a();
        Object object = new p(this);
        Executor executor = c1.b().c();
        completionStage = ((CompletableFuture)completionStage).thenAcceptAsync((Consumer)object, executor);
        object = new r(this);
        ((CompletableFuture)completionStage).exceptionally((Function)object);
    }

    public void b(i0$b i0$b) {
        if (i0$b != null) {
            i0$c i0$c = this.a;
            i0$c.b(i0$b);
        }
    }

    public /* synthetic */ void i() {
        this.h();
    }

    public /* synthetic */ Boolean k() {
        return this.j();
    }

    public /* synthetic */ Boolean m(Boolean bl2) {
        return this.l(bl2);
    }

    public /* synthetic */ Boolean o(Boolean bl2) {
        return this.n(bl2);
    }

    public /* synthetic */ Boolean q(Boolean bl2, Boolean bl3) {
        return this.p(bl2, bl3);
    }

    public /* synthetic */ void s(int n10) {
        this.r(n10);
    }

    public /* synthetic */ Boolean v() {
        return this.u();
    }

    public /* synthetic */ void x(Boolean bl2) {
        this.w(bl2);
    }

    public /* synthetic */ Void z(Throwable throwable) {
        return this.y(throwable);
    }
}

