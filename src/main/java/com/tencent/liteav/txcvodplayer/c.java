/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.tencent.liteav.txcvodplayer;

import android.view.View;
import java.lang.ref.WeakReference;

public final class c {
    private WeakReference a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i = 0;

    public c(View view) {
        WeakReference<View> weakReference;
        this.a = weakReference = new WeakReference<View>(view);
    }

    public int a() {
        return this.g;
    }

    public void a(int n10) {
        this.f = n10;
    }

    public void a(int n10, int n11) {
        this.b = n10;
        this.c = n11;
    }

    public int b() {
        return this.h;
    }

    public void b(int n10) {
        this.i = n10;
    }

    public void b(int n10, int n11) {
        this.d = n10;
        this.e = n11;
    }

    /*
     * Unable to fully structure code
     */
    public void c(int var1_1, int var2_2) {
        block25: {
            block26: {
                block27: {
                    block31: {
                        block32: {
                            block30: {
                                block28: {
                                    block29: {
                                        var3_3 = this.f;
                                        var4_4 = 270;
                                        var5_5 = 3.78E-43f;
                                        var6_6 = 90;
                                        var7_7 = 1.26E-43f;
                                        if (var3_3 == var6_6 || var3_3 == var4_4) {
                                            var8_8 = var2_2;
                                            var2_2 = var1_1;
                                            var1_1 = var8_8;
                                        }
                                        var3_3 = View.getDefaultSize((int)this.b, (int)var1_1);
                                        var9_9 = View.getDefaultSize((int)this.c, (int)var2_2);
                                        var10_10 = this.i;
                                        var11_11 = 3;
                                        if (var10_10 == var11_11) break block25;
                                        var10_10 = this.b;
                                        if (var10_10 <= 0 || (var10_10 = this.c) <= 0) break block26;
                                        var3_3 = View.MeasureSpec.getMode((int)var1_1);
                                        var1_1 = View.MeasureSpec.getSize((int)var1_1);
                                        var9_9 = View.MeasureSpec.getMode((int)var2_2);
                                        var2_2 = View.MeasureSpec.getSize((int)var2_2);
                                        var10_10 = -1 << -1;
                                        var12_12 = -0.0f;
                                        if (var3_3 != var10_10 || var9_9 != var10_10) break block27;
                                        var13_13 = var1_1;
                                        var14_14 = var2_2;
                                        var12_12 = var13_13 / var14_14;
                                        var11_11 = this.i;
                                        var15_15 = 5;
                                        var16_16 = 4;
                                        if (var11_11 == var16_16) break block28;
                                        if (var11_11 == var15_15) break block29;
                                        var4_4 = this.b;
                                        var5_5 = var4_4;
                                        var7_7 = this.c;
                                        var5_5 /= var7_7;
                                        var6_6 = this.d;
                                        if (var6_6 > 0 && (var17_17 = this.e) > 0) {
                                            var7_7 = var6_6;
                                            var5_5 *= var7_7;
                                            var7_7 = var17_17;
                                            var5_5 /= var7_7;
                                        }
                                        break block30;
                                    }
                                    var17_18 = 1068149419;
                                    var18_19 = 1.3333334f;
                                    var19_20 = this.f;
                                    if (var19_20 != var6_6 && var19_20 != var4_4) ** GOTO lbl-1000
                                    var4_4 = 1061158912;
                                    var5_5 = 0.75f;
                                    break block30;
                                }
                                var17_18 = 1071877689;
                                var18_19 = 1.7777778f;
                                var19_21 = this.f;
                                if (var19_21 != var6_6 && var19_21 != var4_4) lbl-1000:
                                // 2 sources

                                {
                                    var4_4 = var17_18;
                                    var5_5 = var18_19;
                                } else {
                                    var4_4 = 1058013184;
                                    var5_5 = 0.5625f;
                                }
                            }
                            var6_6 = (int)(var5_5 == var12_12 ? 0 : (var5_5 > var12_12 ? 1 : -1));
                            var10_10 = 1;
                            var12_12 = 1.4E-45f;
                            if (var6_6 > 0) {
                                var6_6 = var10_10;
                                var7_7 = var12_12;
                            } else {
                                var6_6 = 0;
                                var7_7 = 0.0f;
                            }
                            if (var11_11 == 0) break block31;
                            if (var11_11 == var10_10) break block32;
                            if (var11_11 == var16_16 || var11_11 == var15_15) break block31;
                            if (var6_6 != 0) {
                                var1_1 = Math.min(this.b, var1_1);
                                var20_22 = (float)var1_1 / var5_5;
                                var2_2 = (int)var20_22;
                            } else {
                                var1_1 = Math.min(this.c, var2_2);
                                var20_23 = (float)var1_1 * var5_5;
                                var8_8 = (int)var20_23;
                                var2_2 = var1_1;
                                var1_1 = var8_8;
                            }
                            break block25;
                        }
                        if (var6_6 == 0) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                    }
                    if (var6_6 != 0) lbl-1000:
                    // 2 sources

                    {
                        var2_2 = (int)(var13_13 /= var5_5);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var1_1 = (int)(var14_14 *= var5_5);
                    }
                    break block25;
                }
                var4_4 = 0x40000000;
                var5_5 = 2.0f;
                if (var3_3 == var4_4 && var9_9 == var4_4) {
                    var3_3 = this.b;
                    var4_4 = var3_3 * var2_2;
                    var6_6 = this.c;
                    var9_9 = var1_1 * var6_6;
                    if (var4_4 < var9_9) {
                        var1_1 = (var3_3 *= var2_2) / var6_6;
                    } else {
                        var4_4 = var3_3 * var2_2;
                        var9_9 = var1_1 * var6_6;
                        if (var4_4 > var9_9) {
                            var2_2 = (var6_6 *= var1_1) / var3_3;
                        }
                    }
                } else if (var3_3 == var4_4) {
                    var3_3 = this.c * var1_1;
                    var4_4 = this.b;
                    if (var9_9 != var10_10 || (var3_3 /= var4_4) <= var2_2) {
                        var2_2 = var3_3;
                    }
                } else if (var9_9 == var4_4) {
                    var4_4 = this.b * var2_2;
                    var6_6 = this.c;
                    if (var3_3 != var10_10 || (var4_4 /= var6_6) <= var1_1) {
                        var1_1 = var4_4;
                    }
                } else {
                    var4_4 = this.b;
                    var6_6 = this.c;
                    if (var9_9 == var10_10 && var6_6 > var2_2) {
                        var9_9 = var2_2 * var4_4 / var6_6;
                    } else {
                        var9_9 = var4_4;
                        var2_2 = var6_6;
                    }
                    if (var3_3 == var10_10 && var9_9 > var1_1) {
                        var2_2 = (var6_6 *= var1_1) / var4_4;
                    } else {
                        var1_1 = var9_9;
                    }
                }
                break block25;
            }
            var1_1 = var3_3;
            var2_2 = var9_9;
        }
        this.g = var1_1;
        this.h = var2_2;
    }
}

