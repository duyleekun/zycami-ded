/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.i1;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.i1.b2;
import d.v.c.i1.q2;
import d.v.c.x1.l;
import d.v.e.h.a;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.e.l.m2$d;

public class q2$b
implements View.OnTouchListener {
    public int a;
    public int b;
    public final /* synthetic */ q2 c;

    public q2$b(q2 q22) {
        this.c = q22;
    }

    private /* synthetic */ void a(View view) {
        q2.l(this.c, view);
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouch(View var1_1, MotionEvent var2_2) {
        block17: {
            block15: {
                block16: {
                    var3_3 = q2.a(this.c);
                    m2.a((m2$d)var3_3);
                    var4_4 = var2_2.getAction();
                    var5_5 = 1;
                    if (var4_4 == 0) break block15;
                    var6_6 = 2;
                    var7_7 = 2.8E-45f;
                    if (var4_4 == var5_5) break block16;
                    if (var4_4 == var6_6) {
                        var3_3 = (Boolean)q2.i((q2)this.c).n.getValue();
                        var4_4 = (int)d.v.e.h.a.c((Boolean)var3_3);
                        var6_6 = 0;
                        var7_7 = 0.0f;
                        var8_8 = null;
                        if (var4_4 == 0) {
                            return false;
                        }
                        var9_9 = var2_2.getRawX();
                        var4_4 = (int)var9_9;
                        var10_11 = this.a;
                        var4_4 -= var10_11;
                        var11_13 = var2_2.getRawY();
                        var10_11 = (int)var11_13;
                        var12_15 = this.b;
                        var10_11 -= var12_15;
                        var12_15 = var1_1 /* !! */ .getLeft() + var4_4;
                        var13_16 = var1_1 /* !! */ .getTop() + var10_11;
                        var14_17 = var1_1 /* !! */ .getRight() + var4_4;
                        var4_4 = var1_1 /* !! */ .getBottom() + var10_11;
                        if (var12_15 < 0) {
                            var10_11 = var1_1 /* !! */ .getWidth();
                            var14_17 = var10_11 + 0;
                        } else {
                            var6_6 = var12_15;
                        }
                        var15_18 = this.c;
                        var10_11 = q2.j(var15_18);
                        if (var14_17 > var10_11) {
                            var8_8 = this.c;
                            var14_17 = q2.j(var8_8);
                            var6_6 = var1_1 /* !! */ .getWidth();
                            var6_6 = var14_17 - var6_6;
                        }
                        var10_11 = 1117519872;
                        var11_13 = 78.0f;
                        var12_15 = h2.b(var11_13);
                        if (var13_16 < var12_15) {
                            var13_16 = h2.b(var11_13);
                            var4_4 = var1_1 /* !! */ .getHeight() + var13_16;
                        }
                        var16_20 = this.c;
                        var12_15 = q2.k(var16_20);
                        var17_21 = h2.b(var11_13);
                        if (var4_4 > (var12_15 -= var17_21)) {
                            var3_3 = this.c;
                            var4_4 = q2.k((q2)var3_3);
                            var10_11 = h2.b(var11_13);
                            var4_4 -= var10_11;
                            var10_11 = var1_1 /* !! */ .getHeight();
                            var13_16 = var4_4 - var10_11;
                        }
                        var1_1 /* !! */ .layout(var6_6, var13_16, var14_17, var4_4);
                        this.a = var18_22 = (int)var2_2.getRawX();
                        var19_25 = var2_2.getRawY();
                        this.b = var18_22 = (int)var19_25;
                    }
                    break block17;
                }
                var9_10 = var2_2.getRawX();
                var4_4 = (int)var9_10;
                var20_27 = var2_2.getRawY();
                var21_28 = (int)var20_27;
                var10_12 = q2.c(this.c);
                var4_4 -= var10_12;
                var15_19 = this.c;
                var10_12 = q2.e(var15_19);
                var21_28 -= var10_12;
                var4_4 = Math.abs(var4_4);
                var21_28 = Math.abs(var21_28);
                var22_30 = System.currentTimeMillis();
                var24_31 = this.c;
                var25_32 = q2.g(var24_31);
                cfr_temp_0 = (var22_30 -= var25_32) - (var25_32 = 200L);
                var10_12 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var10_12 >= 0) ** GOTO lbl-1000
                var10_12 = 20;
                var11_14 = 2.8E-44f;
                if (var4_4 < var10_12 && var21_28 < var10_12) {
                    var2_2 = (Boolean)q2.i((q2)this.c).n.getValue();
                    var21_28 = (int)d.v.e.h.a.c((Boolean)var2_2);
                    if (var21_28 != 0) {
                        var2_2 = this.c;
                        q2.l((q2)var2_2, var1_1 /* !! */ );
                        var21_28 = 2131363198;
                        var20_27 = 1.8346198E38f;
                        l.a(var1_1 /* !! */ , var21_28);
                    } else {
                        var2_2 = q2.i((q2)this.c).n;
                        var3_3 = Boolean.TRUE;
                        var2_2.setValue(var3_3);
                        var21_28 = this.a;
                        var3_3 = this.c;
                        var4_4 = q2.j((q2)var3_3) / var6_6;
                        var6_6 = 0x42000000;
                        var7_7 = 32.0f;
                        if (var21_28 < var4_4) {
                            var21_28 = var1_1 /* !! */ .getLeft();
                            var4_4 = h2.b(var7_7);
                            var21_28 += var4_4;
                            var4_4 = var1_1 /* !! */ .getTop();
                            var10_12 = var1_1 /* !! */ .getRight();
                            var6_6 = h2.b(var7_7);
                            var10_12 += var6_6;
                            var6_6 = var1_1 /* !! */ .getBottom();
                            var1_1 /* !! */ .layout(var21_28, var4_4, var10_12, var6_6);
                        } else {
                            var21_28 = var1_1 /* !! */ .getLeft();
                            var4_4 = h2.b(var7_7);
                            var21_28 -= var4_4;
                            var4_4 = var1_1 /* !! */ .getTop();
                            var10_12 = var1_1 /* !! */ .getRight();
                            var6_6 = h2.b(var7_7);
                            var10_12 -= var6_6;
                            var6_6 = var1_1 /* !! */ .getBottom();
                            var1_1 /* !! */ .layout(var21_28, var4_4, var10_12, var6_6);
                        }
                        var2_2 = this.c;
                        var27_33 = 3000L;
                        var3_3 = new b2(this, var1_1 /* !! */ );
                        var3_3 = m2.Y(var27_33, (m2$b)var3_3);
                        q2.b((q2)var2_2, (m2$d)var3_3);
                    }
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = q2.i((q2)this.c).n;
                    var3_3 = Boolean.FALSE;
                    var2_2.setValue(var3_3);
                    var21_28 = this.a;
                    var3_3 = this.c;
                    var4_4 = q2.j((q2)var3_3) / var6_6;
                    var6_6 = 0x41400000;
                    var7_7 = 12.0f;
                    if (var21_28 < var4_4) {
                        var21_28 = -h2.b(var7_7);
                        var4_4 = var1_1 /* !! */ .getTop();
                        var15_19 = this.c;
                        var10_12 = q2.m(var15_19);
                        var6_6 = h2.b(var7_7);
                        var10_12 -= var6_6;
                        var6_6 = var1_1 /* !! */ .getBottom();
                        var1_1 /* !! */ .layout(var21_28, var4_4, var10_12, var6_6);
                    } else {
                        var2_2 = this.c;
                        var21_28 = q2.j((q2)var2_2);
                        var3_3 = this.c;
                        var4_4 = q2.m((q2)var3_3);
                        var21_28 -= var4_4;
                        var4_4 = h2.b(var7_7);
                        var21_28 += var4_4;
                        var4_4 = var1_1 /* !! */ .getTop();
                        var15_19 = this.c;
                        var10_12 = q2.j(var15_19);
                        var6_6 = h2.b(var7_7);
                        var10_12 += var6_6;
                        var6_6 = var1_1 /* !! */ .getBottom();
                        var1_1 /* !! */ .layout(var21_28, var4_4, var10_12, var6_6);
                    }
                }
                var2_2 = q2.i(this.c);
                var2_2.o = var4_4 = var1_1 /* !! */ .getTop();
                var2_2 = q2.i(this.c);
                var2_2.p = var4_4 = var1_1 /* !! */ .getBottom();
                var2_2 = q2.i(this.c);
                var2_2.q = var4_4 = var1_1 /* !! */ .getLeft();
                var2_2 = q2.i(this.c);
                var2_2.r = var18_23 = var1_1 /* !! */ .getRight();
                break block17;
            }
            this.a = var18_24 = (int)var2_2.getRawX();
            var19_26 = var2_2.getRawY();
            this.b = var18_24 = (int)var19_26;
            var1_1 /* !! */  = this.c;
            var21_29 = this.a;
            q2.d((q2)var1_1 /* !! */ , var21_29);
            var1_1 /* !! */  = this.c;
            var21_29 = this.b;
            q2.f((q2)var1_1 /* !! */ , var21_29);
            var1_1 /* !! */  = this.c;
            var27_34 = System.currentTimeMillis();
            q2.h((q2)var1_1 /* !! */ , var27_34);
        }
        return (boolean)var5_5;
    }
}

