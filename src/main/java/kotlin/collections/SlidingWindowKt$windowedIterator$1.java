/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.b2.c;
import f.b2.j.b;
import f.h2.s.p;
import f.h2.t.f0;
import f.l2.q;
import f.n2.o;
import f.o0;
import f.q1;
import f.x1.a1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

public final class SlidingWindowKt$windowedIterator$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ Iterator $iterator;
    public final /* synthetic */ boolean $partialWindows;
    public final /* synthetic */ boolean $reuseBuffer;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    public int I$1;
    public int I$2;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SlidingWindowKt$windowedIterator$1(int n10, int n11, Iterator iterator2, boolean bl2, boolean bl3, c c10) {
        this.$size = n10;
        this.$step = n11;
        this.$iterator = iterator2;
        this.$reuseBuffer = bl2;
        this.$partialWindows = bl3;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        int n10 = this.$size;
        int n11 = this.$step;
        Iterator iterator2 = this.$iterator;
        boolean bl2 = this.$reuseBuffer;
        boolean bl3 = this.$partialWindows;
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(n10, n11, iterator2, bl2, bl3, c10);
        slidingWindowKt$windowedIterator$1.p$ = object = (o)object;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SlidingWindowKt$windowedIterator$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SlidingWindowKt$windowedIterator$1)object).invokeSuspend(object2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object invokeSuspend(Object var1_1) {
        block24: {
            block17: {
                block18: {
                    block23: {
                        block19: {
                            block20: {
                                block21: {
                                    block22: {
                                        var2_2 = b.h();
                                        var3_3 = this.label;
                                        var4_4 = 5;
                                        var5_5 = 4;
                                        var6_6 = 3;
                                        var7_7 = 2;
                                        var8_8 = 1;
                                        if (var3_3 == 0) break block17;
                                        if (var3_3 == var8_8) break block18;
                                        if (var3_3 == var7_7) break block19;
                                        if (var3_3 == var6_6) break block20;
                                        if (var3_3 == var5_5) break block21;
                                        if (var3_3 != var4_4) break block22;
                                        var2_2 = (a1)this.L$1;
                                        break block23;
                                    }
                                    var1_1 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    throw var1_1;
                                }
                                var9_9 = (a1)this.L$1;
                                var6_6 = this.I$1;
                                var7_7 = this.I$0;
                                var10_11 = (o)this.L$0;
                                o0.n(var1_1);
                                var1_1 = this;
                                ** GOTO lbl-1000
                            }
                            var9_9 = (Iterator)this.L$3;
                            var11_13 = (a1)this.L$1;
                            var12_14 = this.I$1;
                            var13_15 = this.I$0;
                            var14_16 = (o)this.L$0;
                            o0.n(var1_1);
                            var1_1 = this;
                            ** GOTO lbl135
                        }
                        var2_2 = (ArrayList)this.L$1;
                    }
                    var2_2 = (o)this.L$0;
                    o0.n(var1_1);
                    break block24;
                }
                var9_10 = (Iterator)this.L$3;
                var15_18 = (ArrayList<E>)this.L$1;
                var5_5 = this.I$1;
                var6_6 = this.I$0;
                var10_12 = (o)this.L$0;
                o0.n(var1_1);
                var16_19 = this;
                ** GOTO lbl87
            }
            o0.n(var1_1);
            var1_1 = this.p$;
            var3_3 = q.u(this.$size, 1024);
            var12_14 = this.$step;
            var13_15 = this.$size;
            if ((var12_14 -= var13_15) >= 0) {
                var15_18 = new ArrayList<E>(var3_3);
                var5_5 = 0;
                var17_21 = null;
                var18_22 = this.$iterator;
                var16_19 = this;
                var6_6 = var3_3;
                var9_10 = var18_22;
                while (var19_23 = var9_10.hasNext()) {
                    var14_17 = var9_10.next();
                    if (var5_5 > 0) {
                        var5_5 += -1;
                        continue;
                    }
                    var15_18.add(var14_17);
                    var20_25 = var15_18.size();
                    if (var20_25 != (var21_27 = var16_19.$size)) continue;
                    var16_19.L$0 = var1_1;
                    var16_19.I$0 = var6_6;
                    var16_19.I$1 = var12_14;
                    var16_19.L$1 = var15_18;
                    var16_19.I$2 = var5_5;
                    var16_19.L$2 = var14_17;
                    var16_19.L$3 = var9_10;
                    var16_19.label = var8_8;
                    var17_21 = var1_1.b(var15_18, var16_19);
                    if (var17_21 == var2_2) {
                        return var2_2;
                    }
                    var5_5 = var12_14;
                    var10_12 = var1_1;
lbl87:
                    // 2 sources

                    var22_29 = var16_19.$reuseBuffer;
                    if (var22_29) {
                        var15_18.clear();
                    } else {
                        var4_4 = var16_19.$size;
                        var1_1 = new ArrayList(var4_4);
                        var15_18 = var1_1;
                    }
                    var1_1 = var10_12;
                    var12_14 = var5_5;
                }
                var3_3 = var15_18.isEmpty() ^ var8_8;
                if (var3_3 != 0 && ((var3_3 = (int)var16_19.$partialWindows) != 0 || (var3_3 = var15_18.size()) == (var8_8 = var16_19.$size))) {
                    var16_19.L$0 = var1_1;
                    var16_19.I$0 = var6_6;
                    var16_19.I$1 = var12_14;
                    var16_19.L$1 = var15_18;
                    var16_19.I$2 = var5_5;
                    var16_19.label = var7_7;
                    if ((var1_1 = var1_1.b(var15_18, var16_19)) == var2_2) {
                        return var2_2;
                    }
                }
            } else {
                var11_13 = new a1(var3_3);
                var16_20 = this.$iterator;
                var14_16 = var1_1;
                var1_1 = this;
                var13_15 = var3_3;
                var9_9 = var16_20;
                while ((var20_26 = (int)var9_9.hasNext()) != 0) {
                    var23_30 /* !! */  = var9_9.next();
                    var11_13.k(var23_30 /* !! */ );
                    var21_28 = var11_13.n();
                    if (var21_28 == 0) continue;
                    var21_28 = var11_13.size();
                    if (var21_28 < (var24_31 = var1_1.$size)) {
                        var11_13 = var11_13.l(var24_31);
                        continue;
                    }
                    var21_28 = (int)var1_1.$reuseBuffer;
                    var25_32 /* !! */  = var21_28 != 0 ? var11_13 : new ArrayList(var11_13);
                    var1_1.L$0 = var14_16;
                    var1_1.I$0 = var13_15;
                    var1_1.I$1 = var12_14;
                    var1_1.L$1 = var11_13;
                    var1_1.L$2 = var23_30 /* !! */ ;
                    var1_1.L$3 = var9_9;
                    var1_1.label = var6_6;
                    var23_30 /* !! */  = var14_16.b(var25_32 /* !! */ , (c)var1_1);
                    if (var23_30 /* !! */  == var2_2) {
                        return var2_2;
                    }
lbl135:
                    // 3 sources

                    var20_26 = var1_1.$step;
                    var11_13.o(var20_26);
                }
                var3_3 = (int)var1_1.$partialWindows;
                if (var3_3 != 0) {
                    var9_9 = var11_13;
                    var6_6 = var12_14;
                    var7_7 = var13_15;
                    var10_11 = var14_16;
                    while ((var13_15 = var9_9.size()) > (var19_24 = var1_1.$step)) {
                        var13_15 = (int)var1_1.$reuseBuffer;
                        var16_20 = var13_15 != 0 ? var9_9 : new ArrayList(var9_9);
                        var1_1.L$0 = var10_11;
                        var1_1.I$0 = var7_7;
                        var1_1.I$1 = var6_6;
                        var1_1.L$1 = var9_9;
                        var1_1.label = var5_5;
                        if ((var16_20 = var10_11.b(var16_20, (c)var1_1)) == var2_2) {
                            return var2_2;
                        } else {
                            ** GOTO lbl-1000
                        }
                    }
                }
            }
            break block24;
lbl-1000:
            // 3 sources

            {
                var13_15 = var1_1.$step;
                var9_9.o(var13_15);
                continue;
            }
            var5_5 = var9_9.isEmpty() ^ var8_8;
            if (var5_5 != 0) {
                var1_1.L$0 = var10_11;
                var1_1.I$0 = var7_7;
                var1_1.I$1 = var6_6;
                var1_1.L$1 = var9_9;
                var1_1.label = var4_4;
                if ((var1_1 = var10_11.b(var9_9, (c)var1_1)) == var2_2) {
                    return var2_2;
                }
            }
        }
        return q1.a;
    }
}

