/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfk;
import com.google.android.gms.internal.clearcut.zzfm;
import com.google.android.gms.internal.clearcut.zzfn;
import com.google.android.gms.internal.clearcut.zzfo;
import com.google.android.gms.internal.clearcut.zzfp;
import com.google.android.gms.internal.clearcut.zzfq;

public class zzfl
extends Enum {
    public static final /* enum */ zzfl zzqc;
    public static final /* enum */ zzfl zzqd;
    public static final /* enum */ zzfl zzqe;
    public static final /* enum */ zzfl zzqf;
    public static final /* enum */ zzfl zzqg;
    public static final /* enum */ zzfl zzqh;
    public static final /* enum */ zzfl zzqi;
    public static final /* enum */ zzfl zzqj;
    public static final /* enum */ zzfl zzqk;
    public static final /* enum */ zzfl zzql;
    public static final /* enum */ zzfl zzqm;
    public static final /* enum */ zzfl zzqn;
    public static final /* enum */ zzfl zzqo;
    public static final /* enum */ zzfl zzqp;
    public static final /* enum */ zzfl zzqq;
    public static final /* enum */ zzfl zzqr;
    public static final /* enum */ zzfl zzqs;
    public static final /* enum */ zzfl zzqt;
    private static final /* synthetic */ zzfl[] zzqw;
    private final zzfq zzqu;
    private final int zzqv;

    static {
        zzfl zzfl2;
        zzfl zzfl3;
        zzfl zzfl4;
        zzfl zzfl5;
        zzfl zzfl6;
        zzfl zzfl7;
        zzfl zzfl8;
        Enum enum_ = zzfq.zzra;
        int n10 = 1;
        zzqc = zzfl8 = new zzfl("DOUBLE", 0, (zzfq)enum_, n10);
        Enum enum_2 = zzfq.zzqz;
        int n11 = 5;
        zzqd = enum_ = new zzfl("FLOAT", n10, (zzfq)enum_2, n11);
        zzfl[] zzflArray = zzfq.zzqy;
        int n12 = 2;
        zzqe = enum_2 = new zzfl("INT64", n12, (zzfq)zzflArray, 0);
        int n13 = 3;
        zzqf = zzfl7 = new zzfl("UINT64", n13, (zzfq)zzflArray, 0);
        zzfq zzfq2 = zzfq.zzqx;
        zzqg = zzfl6 = new zzfl("INT32", 4, zzfq2, 0);
        zzqh = zzfl5 = new zzfl("FIXED64", n11, (zzfq)zzflArray, n10);
        zzqi = zzfl4 = new zzfl("FIXED32", 6, zzfq2, n11);
        zzfq zzfq3 = zzfq.zzrb;
        zzqj = zzfl3 = new zzfl("BOOL", 7, zzfq3, 0);
        zzfq3 = zzfq.zzrc;
        zzfm zzfm2 = new zzfm(zzfq3, n12);
        zzqk = zzfm2;
        zzfq3 = zzfq.zzrf;
        zzfl zzfl9 = new zzfn(zzfq3, n13);
        zzql = zzfl9;
        zzfn zzfn2 = zzfl9;
        n11 = 2;
        zzfl zzfl10 = new zzfo(zzfq3, n11);
        zzqm = zzfl10;
        zzfq3 = zzfq.zzrd;
        zzfo zzfo2 = zzfl10;
        zzfl zzfl11 = new zzfp(zzfq3, n11);
        zzqn = zzfl11;
        zzfl9 = new zzfl("UINT32", 12, zzfq2, 0);
        zzqo = zzfl9;
        zzfq3 = zzfq.zzre;
        zzfl zzfl12 = zzfl9;
        zzfp zzfp2 = zzfl11;
        zzqp = zzfl2 = new zzfl("ENUM", 13, zzfq3, 0);
        zzfl10 = new zzfl("SFIXED32", 14, zzfq2, 5);
        zzqq = zzfl10;
        zzfl zzfl13 = zzfl10;
        zzfl9 = new zzfl("SFIXED64", 15, (zzfq)zzflArray, 1);
        zzqr = zzfl9;
        zzfl10 = new zzfl("SINT32", 16, zzfq2, 0);
        zzqs = zzfl10;
        int n14 = 17;
        zzfl11 = new zzfl("SINT64", n14, (zzfq)zzflArray, 0);
        zzqt = zzfl11;
        zzflArray = new zzfl[18];
        zzflArray[0] = zzfl8;
        zzflArray[1] = enum_;
        zzflArray[2] = enum_2;
        zzflArray[3] = zzfl7;
        zzflArray[4] = zzfl6;
        zzflArray[5] = zzfl5;
        zzflArray[6] = zzfl4;
        zzflArray[7] = zzfl3;
        zzflArray[8] = zzfm2;
        zzflArray[9] = zzfn2;
        zzflArray[10] = zzfo2;
        zzflArray[11] = zzfp2;
        zzflArray[12] = zzfl12;
        zzflArray[13] = zzfl2;
        zzflArray[14] = zzfl13;
        zzflArray[15] = zzfl9;
        zzflArray[16] = zzfl10;
        zzflArray[n14] = zzfl11;
        zzqw = zzflArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzfl() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzqu = var3_1;
        this.zzqv = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ zzfl(zzfq zzfq2, int n10, zzfk zzfk2) {
        this((String)var1_-1, n10, (zzfq)((Object)zzfk2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static zzfl[] values() {
        return (zzfl[])zzqw.clone();
    }

    public final zzfq zzek() {
        return this.zzqu;
    }

    public final int zzel() {
        return this.zzqv;
    }
}

