/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate;

import com.zhiyun.editortemplate.TemEditorConfig$FilterType$1;
import com.zhiyun.editortemplate.TemEditorConfig$FilterType$2;
import com.zhiyun.editortemplate.TemEditorConfig$FilterType$3;
import com.zhiyun.editortemplate.TemEditorConfig$a;
import d.v.e.j.a;

public abstract class TemEditorConfig$FilterType
extends Enum
implements a {
    public static final /* enum */ TemEditorConfig$FilterType FILTER;
    public static final /* enum */ TemEditorConfig$FilterType FILTER_FX;
    public static final /* enum */ TemEditorConfig$FilterType FILTER_LUT;
    private static final /* synthetic */ TemEditorConfig$FilterType[] a;
    private final String mName;

    static {
        Object object = "FILTER";
        TemEditorConfig$FilterType$1 temEditorConfig$FilterType$1 = new TemEditorConfig$FilterType$1((String)object);
        FILTER = temEditorConfig$FilterType$1;
        Object object2 = "FILTER_LUT";
        int n10 = 1;
        FILTER_LUT = object = new TemEditorConfig$FilterType$2((String)object2);
        TemEditorConfig$FilterType[] temEditorConfig$FilterTypeArray = "FILTER_FX";
        int n11 = 2;
        FILTER_FX = object2 = new TemEditorConfig$FilterType$3((String)temEditorConfig$FilterTypeArray);
        temEditorConfig$FilterTypeArray = new TemEditorConfig$FilterType[3];
        temEditorConfig$FilterTypeArray[0] = temEditorConfig$FilterType$1;
        temEditorConfig$FilterTypeArray[n10] = object;
        temEditorConfig$FilterTypeArray[n11] = object2;
        a = temEditorConfig$FilterTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TemEditorConfig$FilterType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ TemEditorConfig$FilterType(String string2, TemEditorConfig$a temEditorConfig$a) {
        this((String)var1_-1, (int)temEditorConfig$a, (String)var3_2);
        void var3_2;
        void var1_-1;
    }

    public static TemEditorConfig$FilterType valueOf(String string2) {
        return Enum.valueOf(TemEditorConfig$FilterType.class, string2);
    }

    public static TemEditorConfig$FilterType[] values() {
        return (TemEditorConfig$FilterType[])a.clone();
    }

    public String getType() {
        return this.mName;
    }
}

