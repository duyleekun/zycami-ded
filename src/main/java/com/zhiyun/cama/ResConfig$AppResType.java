/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama;

import com.zhiyun.cama.ResConfig$AppResType$1;
import com.zhiyun.cama.ResConfig$AppResType$2;
import com.zhiyun.cama.ResConfig$a;
import d.v.e.j.a;

public abstract class ResConfig$AppResType
extends Enum
implements a {
    public static final /* enum */ ResConfig$AppResType APP_ASSETS;
    public static final /* enum */ ResConfig$AppResType WATERMARK;
    private static final /* synthetic */ ResConfig$AppResType[] a;
    private final String mName;

    static {
        ResConfig$AppResType$1 resConfig$AppResType$1 = new ResConfig$AppResType$1("app_assets");
        APP_ASSETS = resConfig$AppResType$1;
        int n10 = 1;
        ResConfig$AppResType$2 resConfig$AppResType$2 = new ResConfig$AppResType$2("watermark");
        WATERMARK = resConfig$AppResType$2;
        ResConfig$AppResType[] resConfig$AppResTypeArray = new ResConfig$AppResType[2];
        resConfig$AppResTypeArray[0] = resConfig$AppResType$1;
        resConfig$AppResTypeArray[n10] = resConfig$AppResType$2;
        a = resConfig$AppResTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ResConfig$AppResType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ ResConfig$AppResType(String string2, ResConfig$a resConfig$a) {
        this((String)var1_-1, (int)resConfig$a, (String)var3_2);
        void var3_2;
        void var1_-1;
    }

    public static ResConfig$AppResType valueOf(String string2) {
        return Enum.valueOf(ResConfig$AppResType.class, string2);
    }

    public static ResConfig$AppResType[] values() {
        return (ResConfig$AppResType[])a.clone();
    }

    public String getType() {
        return this.mName;
    }
}

