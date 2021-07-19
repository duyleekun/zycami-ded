/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.b1.t;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.draft.withdraw.WithdrawTemplateUseCase;
import com.zhiyun.editorsdk.draft.withdraw.WithdrawUseCase;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.b1.t.a;
import d.v.c.b1.t.b;
import d.v.c.b1.t.c;
import d.v.c.b1.t.d;
import d.v.c.b1.t.e;
import d.v.c.i1.i2;
import d.v.e.i.h;
import d.v.e.l.n2;
import d.v.j.e.g.a0;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class g
extends i2 {
    private MutableLiveData g0;
    private MutableLiveData h0;
    private final WithdrawUseCase i0;
    private WithdrawTemplateUseCase j0;
    private final d.v.h.e.b k0;

    public g(Application object) {
        super((Application)object);
        super();
        this.g0 = object;
        super();
        this.h0 = object;
        super(this);
        this.k0 = object;
        super();
        this.i0 = object;
        b b10 = new b(this);
        ((WithdrawUseCase)object).k(b10);
    }

    private void B4() {
        MutableLiveData mutableLiveData = this.g0;
        Boolean bl2 = this.i0.b();
        h.g(mutableLiveData, bl2);
        mutableLiveData = this.h0;
        bl2 = this.i0.a();
        h.g(mutableLiveData, bl2);
    }

    public static /* synthetic */ WithdrawTemplateUseCase k4(g g10) {
        return g10.j0;
    }

    public static /* synthetic */ WithdrawTemplateUseCase l4(g g10, WithdrawTemplateUseCase withdrawTemplateUseCase) {
        g10.j0 = withdrawTemplateUseCase;
        return withdrawTemplateUseCase;
    }

    public static /* synthetic */ MainUseCase m4(g g10) {
        return g10.G;
    }

    /*
     * Enabled aggressive block sorting
     */
    private OptionalInt n4(long l10, a0 a02, a0 a03) {
        int n10;
        int n11;
        block7: {
            block5: {
                int n12;
                block10: {
                    boolean bl2;
                    long l11;
                    block4: {
                        long l12;
                        block9: {
                            block8: {
                                block6: {
                                    long l13 = 0x1DC000L & l10;
                                    l11 = 0L;
                                    long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                                    n11 = 2131952042;
                                    n12 = 2131952043;
                                    bl2 = true;
                                    n10 = -1;
                                    if (l14 == false) break block4;
                                    long l15 = 0x1C000L & l10;
                                    long l16 = l15 - l11;
                                    Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                    if (object == false) {
                                        bl2 = false;
                                    }
                                    WithdrawTemplateUseCase withdrawTemplateUseCase = this.j0;
                                    boolean bl3 = withdrawTemplateUseCase.n0(a02, a03, bl2);
                                    if (!bl3) break block5;
                                    l12 = 16384L;
                                    long l17 = l10 - l12;
                                    Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                                    if (object2 != false) break block6;
                                    n11 = 2131952011;
                                    break block7;
                                }
                                l12 = 32768L;
                                long l18 = l10 - l12;
                                Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                                if (object == false) break block7;
                                l12 = 65536L;
                                long l19 = l10 - l12;
                                Object object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                                if (object3 != false) break block8;
                                n11 = 2131952026;
                                break block7;
                            }
                            l12 = 262144L;
                            long l20 = l10 - l12;
                            Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                            if (object != false) break block9;
                            n11 = 2131952012;
                            break block7;
                        }
                        l12 = 524288L;
                        long l21 = l10 - l12;
                        Object object = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                        if (object == false) break block10;
                        l12 = 0x100000L;
                        long l22 = l10 - l12;
                        Object object4 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                        if (object4 != false) break block5;
                        n11 = 2131952027;
                        break block7;
                    }
                    long l23 = 0x220000L & l10;
                    long l24 = l23 - l11;
                    Object object = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
                    if (object == false) break block5;
                    l23 = 131072L;
                    long l25 = (l10 &= l23) - l11;
                    Object object5 = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
                    if (object5 == false) {
                        bl2 = false;
                    }
                    WithdrawTemplateUseCase withdrawTemplateUseCase = this.j0;
                    boolean bl4 = withdrawTemplateUseCase.o0(a02, a03, bl2);
                    if (!bl4) break block5;
                    if (bl2) break block7;
                }
                n11 = n12;
                break block7;
            }
            n11 = n10;
        }
        if (n11 != n10) return OptionalInt.of(n11);
        return OptionalInt.empty();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private OptionalInt o4(long var1_1, a0 var3_2, a0 var4_3) {
        var5_4 = 64;
        var7_5 = var1_1 == var5_4 ? 0 : (var1_1 < var5_4 ? -1 : 1);
        var8_6 = -1;
        if (var7_5 > 0 || !(var11_9 /* !! */  = (var9_7 = this.j0).r0(var1_1, var3_2, var4_3, var10_8 = new d(this)))) ** GOTO lbl-1000
        var12_10 = 1L & var1_1;
        var14_11 = 0L;
        cfr_temp_0 = var12_10 - var14_11;
        var11_9 /* !! */  = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var11_9 /* !! */ ) {
            var16_12 = 2131952081;
        } else {
            var12_10 = (long)2 & var1_1;
            cfr_temp_1 = var12_10 - var14_11;
            var11_9 /* !! */  = cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
            if (var11_9 /* !! */ ) {
                var16_12 = 2131952051;
            } else {
                var12_10 = (long)4 & var1_1;
                cfr_temp_2 = var12_10 - var14_11;
                var11_9 /* !! */  = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
                if (var11_9 /* !! */ ) {
                    var16_12 = 2131952095;
                } else {
                    var12_10 = (long)8 & var1_1;
                    cfr_temp_3 = var12_10 - var14_11;
                    var11_9 /* !! */  = cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1);
                    if (var11_9 /* !! */ ) {
                        var16_12 = 2131952114;
                    } else {
                        var12_10 = (long)16 & var1_1;
                        cfr_temp_4 = var12_10 - var14_11;
                        var11_9 /* !! */  = cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1);
                        if (var11_9 /* !! */ ) {
                            var16_12 = 2131952087;
                        } else {
                            var12_10 = var1_1 & var5_4;
                            cfr_temp_5 = var12_10 - var14_11;
                            var11_9 /* !! */  = cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
                            if (var11_9 /* !! */ ) {
                                var16_12 = 2131952054;
                            } else {
                                var12_10 = 32;
                                cfr_temp_6 = (var1_1 &= var12_10) - var14_11;
                                var16_12 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                                if (var16_12 != 0) {
                                    var16_12 = 2131952115;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var16_12 = var8_6;
                                }
                            }
                        }
                    }
                }
            }
        }
        var17_13 = var16_12 == var8_6 ? OptionalInt.empty() : OptionalInt.of(var16_12);
        return var17_13;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private OptionalInt p4(long var1_1, a0 var3_2, a0 var4_3) {
        block3: {
            block8: {
                block7: {
                    block6: {
                        block5: {
                            block4: {
                                block2: {
                                    var5_4 = 128L & var1_1;
                                    var7_5 = 0L;
                                    var9_6 /* !! */  = var5_4 == var7_5 ? 0 : (var5_4 < var7_5 ? -1 : 1);
                                    var10_7 = -1;
                                    if (var9_6 /* !! */  == false) break block2;
                                    var11_8 = this.j0;
                                    var12_9 = var11_8.B0(var3_2, var4_3);
                                    if (var12_9 == 0) ** GOTO lbl-1000
                                    var12_9 = 2131952112;
                                    this.Y2();
                                    break block3;
                                }
                                var13_10 = 256L & var1_1;
                                cfr_temp_0 = var13_10 - var7_5;
                                var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                if (var9_6 /* !! */  == false) break block4;
                                var11_8 = this.j0;
                                var12_9 = (int)var11_8.w0(var3_2, var4_3);
                                var12_9 = var12_9 != 0 ? 2131952094 : var10_7;
                                this.Z2(0);
                                break block3;
                            }
                            var13_10 = 1536L & var1_1;
                            cfr_temp_1 = var13_10 - var7_5;
                            var9_6 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                            if (var9_6 /* !! */  == false) break block5;
                            var15_11 = this.j0;
                            var16_12 = var15_11.t0(var3_2, var4_3);
                            if (!var16_12) ** GOTO lbl-1000
                            var17_13 = 1024L;
                            cfr_temp_2 = (var1_1 &= var17_13) - var7_5;
                            var12_9 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                            var12_9 = var12_9 != 0 ? 2131951903 : 2131951724;
                            this.i4();
                            this.Y2();
                            break block3;
                        }
                        var13_10 = 4096L & var1_1;
                        cfr_temp_3 = var13_10 - var7_5;
                        var9_6 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                        if (var9_6 /* !! */  == false) break block6;
                        var11_8 = this.j0;
                        var12_9 = (int)var11_8.s0(var3_2, var4_3);
                        if (var12_9 == 0) ** GOTO lbl-1000
                        var12_9 = 2131952020;
                        this.i4();
                        break block3;
                    }
                    var13_10 = 8192L & var1_1;
                    cfr_temp_4 = var13_10 - var7_5;
                    var9_6 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                    if (var9_6 /* !! */  == false) break block7;
                    var11_8 = this.j0;
                    var12_9 = (int)var11_8.u0(var3_2, var4_3);
                    var12_9 = var12_9 != 0 ? 2131952028 : var10_7;
                    this.i4();
                    break block3;
                }
                var13_10 = 2048L & var1_1;
                cfr_temp_5 = var13_10 - var7_5;
                var9_6 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                if (var9_6 /* !! */  == false) break block8;
                var11_8 = this.j0;
                var12_9 = (int)var11_8.t0(var3_2, var4_3);
                if (var12_9 == 0) ** GOTO lbl-1000
                var12_9 = 2131951918;
                this.i4();
                this.Y2();
                break block3;
            }
            var13_10 = 0x80000000L;
            cfr_temp_6 = (var1_1 &= var13_10) - var7_5;
            var12_9 = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
            if (var12_9 != 0 && (var12_9 = (int)(var11_8 = this.j0).v0(var3_2, var4_3)) != 0) {
                var12_9 = 2131952086;
                this.i4();
                this.Y2();
            } else lbl-1000:
            // 5 sources

            {
                var12_9 = var10_7;
            }
        }
        var11_8 = var12_9 == var10_7 ? OptionalInt.empty() : OptionalInt.of(var12_9);
        return var11_8;
    }

    /*
     * Enabled aggressive block sorting
     */
    private OptionalInt q4(long l10, a0 a02, a0 a03) {
        int n10;
        int n11;
        block7: {
            block5: {
                int n12;
                block8: {
                    boolean bl2;
                    long l11;
                    Object object;
                    long l12;
                    long l13;
                    block9: {
                        int n13;
                        block4: {
                            block6: {
                                long l14 = 0x3C00000L & l10;
                                l13 = 0L;
                                l12 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
                                n13 = 1;
                                l12 = l12 != false ? (long)n13 : (long)0;
                                long l15 = 0xCC00000L & l10;
                                long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
                                n11 = -1;
                                n10 = 2131952040;
                                n12 = 2131952041;
                                if (l16 == false) break block4;
                                long l17 = 0x8800000L;
                                long l18 = (l10 &= l17) - l13;
                                Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                                if (object2 == false) {
                                    n13 = 0;
                                }
                                object = this.j0;
                                boolean bl3 = ((WithdrawTemplateUseCase)object).D0(a02, a03, (boolean)l12);
                                if (!bl3) break block5;
                                if (l12 == false) break block6;
                                if (n13 == 0) {
                                    n10 = 2131952008;
                                }
                                break block7;
                            }
                            if (n13 != 0) break block8;
                            n10 = 2131952009;
                            break block7;
                        }
                        l11 = 0x11000000L & l10;
                        long l19 = l11 - l13;
                        n13 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                        if (n13 == 0) break block9;
                        object = this.j0;
                        boolean bl4 = ((WithdrawTemplateUseCase)object).C0(a02, a03, (boolean)l12);
                        if (!bl4) break block5;
                        if (l12 == false) break block8;
                        break block7;
                    }
                    l11 = 0x22000000L;
                    long l20 = (l10 &= l11) - l13;
                    Object object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                    if (object3 == false || !(bl2 = ((WithdrawTemplateUseCase)(object = this.j0)).E0(a02, a03, (boolean)l12))) break block5;
                    if (l12 != false) break block7;
                }
                n10 = n12;
                break block7;
            }
            n10 = n11;
        }
        if (n10 != n11) return OptionalInt.of(n10);
        return OptionalInt.empty();
    }

    private void r4(long l10, a0 a02, a0 a03, IntConsumer intConsumer) {
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        OptionalInt optionalInt = this.o4(l10, a02, a03);
        a a10 = new a(atomicInteger);
        optionalInt.ifPresent(a10);
        optionalInt = this.p4(l10, a02, a03);
        a10 = new a(atomicInteger);
        optionalInt.ifPresent(a10);
        optionalInt = this.n4(l10, a02, a03);
        a10 = new a(atomicInteger);
        optionalInt.ifPresent(a10);
        Object object = this.q4(l10, a02, a03);
        a a11 = new a(atomicInteger);
        ((OptionalInt)object).ifPresent(a11);
        object = a03.a();
        long l11 = a03.b();
        this.W2((TemplatePOJO)object, l11, false);
        int n10 = atomicInteger.get();
        intConsumer.accept(n10);
    }

    public static /* synthetic */ void u4(g g10) {
        g10.B4();
    }

    private /* synthetic */ void v4() {
        this.i4();
        MutableLiveData mutableLiveData = this.m1();
        Boolean bl2 = this.j0.B();
        h.e(mutableLiveData, bl2);
        mutableLiveData = this.r1();
        bl2 = this.j0.D();
        h.e(mutableLiveData, bl2);
        mutableLiveData = this.o1();
        bl2 = this.j0.A();
        h.e(mutableLiveData, bl2);
        mutableLiveData = this.t1();
        bl2 = this.j0.C();
        h.e(mutableLiveData, bl2);
        mutableLiveData = this.v1();
        bl2 = this.j0.E();
        h.e(mutableLiveData, bl2);
    }

    private /* synthetic */ void x4(Context object, int n10) {
        this.B4();
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = d.v.f.i.g.m(object, 2131952082);
        stringBuilder.append(string2);
        object = d.v.f.i.g.m(object, n10);
        stringBuilder.append((String)object);
        n2.e(stringBuilder.toString());
    }

    private /* synthetic */ void z4(Context object, int n10) {
        this.B4();
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = d.v.f.i.g.m(object, 2131952113);
        stringBuilder.append(string2);
        object = d.v.f.i.g.m(object, n10);
        stringBuilder.append((String)object);
        n2.e(stringBuilder.toString());
    }

    public /* synthetic */ void A4(Context context, int n10) {
        this.z4(context, n10);
    }

    public void C4(Context context) {
        a0 a02;
        a0 a03 = a02 = this.i0.d().orElse(null);
        a03 = a02;
        a0 a04 = a02 = this.i0.f().orElse(null);
        a04 = a02;
        if (a04 != null && a03 != null) {
            long l10 = a04.b();
            e e10 = new e(this, context);
            this.r4(l10, a03, a04, e10);
        }
    }

    public void D4(Context context) {
        a0 a02;
        a0 a03 = a02 = this.i0.d().orElse(null);
        a03 = a02;
        a0 a04 = a02 = this.i0.g().orElse(null);
        a04 = a02;
        if (a04 != null && a03 != null) {
            long l10 = a03.b();
            c c10 = new c(this, context);
            this.r4(l10, a03, a04, c10);
        }
    }

    public void k2(PlayerWrapperView playerWrapperView, List list) {
        MainUseCase mainUseCase = this.G;
        d.v.h.e.b b10 = this.k0;
        mainUseCase.f(b10);
        super.k2(playerWrapperView, list);
    }

    public void onCleared() {
        super.onCleared();
        this.i0.c();
    }

    public MutableLiveData s4() {
        return this.h0;
    }

    public MutableLiveData t4() {
        return this.g0;
    }

    public /* synthetic */ void w4() {
        this.v4();
    }

    public /* synthetic */ void y4(Context context, int n10) {
        this.x4(context, n10);
    }
}

