/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

public final class zzlr
extends Enum {
    public static final /* enum */ zzlr zzaea;
    public static final /* enum */ zzlr zzaeb;
    public static final /* enum */ zzlr zzaec;
    public static final /* enum */ zzlr zzaed;
    public static final /* enum */ zzlr zzaee;
    public static final /* enum */ zzlr zzaef;
    public static final /* enum */ zzlr zzaeg;
    public static final /* enum */ zzlr zzaeh;
    public static final /* enum */ zzlr zzaei;
    private static final /* synthetic */ zzlr[] zzaej;
    private final Object zzzk;

    static {
        zzlr zzlr2;
        zzlr zzlr3;
        zzlr zzlr4;
        Object object = 0;
        zzaea = zzlr4 = new zzlr("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new zzlr("LONG", n10, object2);
        zzaeb = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new zzlr("FLOAT", n11, object3);
        zzaec = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new zzlr("DOUBLE", n12, object4);
        zzaed = object3;
        Object object5 = Boolean.FALSE;
        object4 = new zzlr("BOOLEAN", 4, object5);
        zzaee = object4;
        object5 = new zzlr("STRING", 5, (Object)"");
        zzaef = object5;
        Object object6 = zzgs.zztt;
        zzaeg = zzlr3 = new zzlr("BYTE_STRING", 6, object6);
        object6 = new zzlr("ENUM", 7, null);
        zzaeh = object6;
        int n13 = 8;
        zzaei = zzlr2 = new zzlr("MESSAGE", n13, null);
        zzlr[] zzlrArray = new zzlr[9];
        zzlrArray[0] = zzlr4;
        zzlrArray[n10] = object;
        zzlrArray[n11] = object2;
        zzlrArray[n12] = object3;
        zzlrArray[4] = object4;
        zzlrArray[5] = object5;
        zzlrArray[6] = zzlr3;
        zzlrArray[7] = object6;
        zzlrArray[n13] = zzlr2;
        zzaej = zzlrArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzlr() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzzk = var3_1;
    }

    public static zzlr[] values() {
        return (zzlr[])zzaej.clone();
    }
}

