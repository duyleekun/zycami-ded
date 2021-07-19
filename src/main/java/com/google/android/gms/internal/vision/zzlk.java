/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzll;
import com.google.android.gms.internal.vision.zzlm;
import com.google.android.gms.internal.vision.zzln;
import com.google.android.gms.internal.vision.zzlo;
import com.google.android.gms.internal.vision.zzlp;
import com.google.android.gms.internal.vision.zzlr;

public class zzlk
extends Enum {
    public static final /* enum */ zzlk zzadf;
    public static final /* enum */ zzlk zzadg;
    public static final /* enum */ zzlk zzadh;
    public static final /* enum */ zzlk zzadi;
    public static final /* enum */ zzlk zzadj;
    public static final /* enum */ zzlk zzadk;
    public static final /* enum */ zzlk zzadl;
    public static final /* enum */ zzlk zzadm;
    public static final /* enum */ zzlk zzadn;
    public static final /* enum */ zzlk zzado;
    public static final /* enum */ zzlk zzadp;
    public static final /* enum */ zzlk zzadq;
    public static final /* enum */ zzlk zzadr;
    public static final /* enum */ zzlk zzads;
    public static final /* enum */ zzlk zzadt;
    public static final /* enum */ zzlk zzadu;
    public static final /* enum */ zzlk zzadv;
    public static final /* enum */ zzlk zzadw;
    private static final /* synthetic */ zzlk[] zzadz;
    private final zzlr zzadx;
    private final int zzady;

    static {
        zzlk zzlk2;
        zzlk zzlk3;
        zzlk zzlk4;
        zzlk zzlk5;
        zzlk zzlk6;
        zzlk zzlk7;
        zzlk zzlk8;
        Enum enum_ = zzlr.zzaed;
        int n10 = 1;
        zzadf = zzlk8 = new zzlk("DOUBLE", 0, (zzlr)enum_, n10);
        Enum enum_2 = zzlr.zzaec;
        int n11 = 5;
        zzadg = enum_ = new zzlk("FLOAT", n10, (zzlr)enum_2, n11);
        zzlk[] zzlkArray = zzlr.zzaeb;
        int n12 = 2;
        zzadh = enum_2 = new zzlk("INT64", n12, (zzlr)zzlkArray, 0);
        int n13 = 3;
        zzadi = zzlk7 = new zzlk("UINT64", n13, (zzlr)zzlkArray, 0);
        zzlr zzlr2 = zzlr.zzaea;
        zzadj = zzlk6 = new zzlk("INT32", 4, zzlr2, 0);
        zzadk = zzlk5 = new zzlk("FIXED64", n11, (zzlr)zzlkArray, n10);
        zzadl = zzlk4 = new zzlk("FIXED32", 6, zzlr2, n11);
        zzlr zzlr3 = zzlr.zzaee;
        zzadm = zzlk3 = new zzlk("BOOL", 7, zzlr3, 0);
        zzlr3 = zzlr.zzaef;
        zzln zzln2 = new zzln(zzlr3, n12);
        zzadn = zzln2;
        zzlr3 = zzlr.zzaei;
        zzlk zzlk9 = new zzlm(zzlr3, n13);
        zzado = zzlk9;
        zzlm zzlm2 = zzlk9;
        n11 = 2;
        zzlk zzlk10 = new zzlp(zzlr3, n11);
        zzadp = zzlk10;
        zzlr3 = zzlr.zzaeg;
        zzlp zzlp2 = zzlk10;
        zzlk zzlk11 = new zzlo(zzlr3, n11);
        zzadq = zzlk11;
        zzlk9 = new zzlk("UINT32", 12, zzlr2, 0);
        zzadr = zzlk9;
        zzlr3 = zzlr.zzaeh;
        zzlk zzlk12 = zzlk9;
        zzlo zzlo2 = zzlk11;
        zzads = zzlk2 = new zzlk("ENUM", 13, zzlr3, 0);
        zzlk10 = new zzlk("SFIXED32", 14, zzlr2, 5);
        zzadt = zzlk10;
        zzlk zzlk13 = zzlk10;
        zzlk9 = new zzlk("SFIXED64", 15, (zzlr)zzlkArray, 1);
        zzadu = zzlk9;
        zzlk10 = new zzlk("SINT32", 16, zzlr2, 0);
        zzadv = zzlk10;
        int n14 = 17;
        zzlk11 = new zzlk("SINT64", n14, (zzlr)zzlkArray, 0);
        zzadw = zzlk11;
        zzlkArray = new zzlk[18];
        zzlkArray[0] = zzlk8;
        zzlkArray[1] = enum_;
        zzlkArray[2] = enum_2;
        zzlkArray[3] = zzlk7;
        zzlkArray[4] = zzlk6;
        zzlkArray[5] = zzlk5;
        zzlkArray[6] = zzlk4;
        zzlkArray[7] = zzlk3;
        zzlkArray[8] = zzln2;
        zzlkArray[9] = zzlm2;
        zzlkArray[10] = zzlp2;
        zzlkArray[11] = zzlo2;
        zzlkArray[12] = zzlk12;
        zzlkArray[13] = zzlk2;
        zzlkArray[14] = zzlk13;
        zzlkArray[15] = zzlk9;
        zzlkArray[16] = zzlk10;
        zzlkArray[n14] = zzlk11;
        zzadz = zzlkArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzlk() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzadx = var3_1;
        this.zzady = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ zzlk(zzlr zzlr2, int n10, zzll zzll2) {
        this((String)var1_-1, n10, (zzlr)((Object)zzll2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static zzlk[] values() {
        return (zzlk[])zzadz.clone();
    }

    public final zzlr zzjk() {
        return this.zzadx;
    }

    public final int zzjl() {
        return this.zzady;
    }
}

