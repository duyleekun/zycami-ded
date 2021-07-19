/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

public final class OSSUtils$MetadataDirective
extends Enum {
    private static final /* synthetic */ OSSUtils$MetadataDirective[] $VALUES;
    public static final /* enum */ OSSUtils$MetadataDirective COPY;
    public static final /* enum */ OSSUtils$MetadataDirective REPLACE;
    private final String directiveAsString;

    static {
        OSSUtils$MetadataDirective oSSUtils$MetadataDirective;
        Object object = "COPY";
        COPY = oSSUtils$MetadataDirective = new OSSUtils$MetadataDirective(object, 0, object);
        OSSUtils$MetadataDirective[] oSSUtils$MetadataDirectiveArray = "REPLACE";
        int n10 = 1;
        object = new OSSUtils$MetadataDirective((String)oSSUtils$MetadataDirectiveArray, n10, (String)oSSUtils$MetadataDirectiveArray);
        REPLACE = object;
        oSSUtils$MetadataDirectiveArray = new OSSUtils$MetadataDirective[2];
        oSSUtils$MetadataDirectiveArray[0] = oSSUtils$MetadataDirective;
        oSSUtils$MetadataDirectiveArray[n10] = object;
        $VALUES = oSSUtils$MetadataDirectiveArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OSSUtils$MetadataDirective() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.directiveAsString = var3_1;
    }

    public static OSSUtils$MetadataDirective valueOf(String string2) {
        return Enum.valueOf(OSSUtils$MetadataDirective.class, string2);
    }

    public static OSSUtils$MetadataDirective[] values() {
        return (OSSUtils$MetadataDirective[])$VALUES.clone();
    }

    public String toString() {
        return this.directiveAsString;
    }
}

