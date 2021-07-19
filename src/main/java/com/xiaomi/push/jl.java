/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.jc;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import com.xiaomi.push.jh;
import com.xiaomi.push.ji;
import com.xiaomi.push.jm;

public class jl {
    private static int a = Integer.MAX_VALUE;

    public static void a(ji ji2, byte by2) {
        int n10 = a;
        jl.a(ji2, by2, n10);
    }

    public static void a(ji object, byte by2, int n10) {
        if (n10 > 0) {
            block0 : switch (by2) {
                default: {
                    break;
                }
                case 15: {
                    int n11;
                    int n12;
                    jg jg2 = ((ji)object).a();
                    for (n12 = 0; n12 < (n11 = jg2.a); ++n12) {
                        n11 = jg2.a;
                        int n13 = n10 + -1;
                        jl.a((ji)object, (byte)n11, n13);
                    }
                    ((ji)object).i();
                    break;
                }
                case 14: {
                    byte by3;
                    int n12;
                    jm jm2 = ((ji)object).a();
                    while (n12 < (by3 = jm2.a)) {
                        by3 = jm2.a;
                        int n14 = n10 + -1;
                        jl.a((ji)object, by3, n14);
                        ++n12;
                    }
                    ((ji)object).j();
                    break;
                }
                case 13: {
                    byte by4;
                    int n12;
                    jh jh2 = ((ji)object).a();
                    while (n12 < (by4 = jh2.a)) {
                        by4 = jh2.a;
                        int n15 = n10 + -1;
                        jl.a((ji)object, by4, n15);
                        by4 = jh2.b;
                        jl.a((ji)object, by4, n15);
                        ++n12;
                    }
                    ((ji)object).h();
                    break;
                }
                case 12: {
                    int n12;
                    ((ji)object).a();
                    while (true) {
                        jf jf2 = ((ji)object).a();
                        by2 = jf2.a;
                        if (by2 == 0) {
                            ((ji)object).f();
                            break block0;
                        }
                        n12 = n10 + -1;
                        jl.a((ji)object, by2, n12);
                        ((ji)object).g();
                    }
                }
                case 11: {
                    ((ji)object).a();
                    break;
                }
                case 10: {
                    ((ji)object).a();
                    break;
                }
                case 8: {
                    ((ji)object).a();
                    break;
                }
                case 6: {
                    ((ji)object).a();
                    break;
                }
                case 4: {
                    ((ji)object).a();
                    break;
                }
                case 3: {
                    ((ji)object).a();
                    break;
                }
                case 2: {
                    ((ji)object).a();
                }
            }
            return;
        }
        object = new jc("Maximum skip depth exceeded");
        throw object;
    }
}

