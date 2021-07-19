/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate;

import com.zhiyun.editortemplate.TemEditorConfig$SmartType$1;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$2;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$3;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$4;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$5;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$6;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType$7;
import com.zhiyun.editortemplate.TemEditorConfig$a;
import d.v.e.j.a;

public abstract class TemEditorConfig$SmartType
extends Enum
implements a {
    public static final /* enum */ TemEditorConfig$SmartType SMART;
    public static final /* enum */ TemEditorConfig$SmartType SMART_DIY_TRACK;
    public static final /* enum */ TemEditorConfig$SmartType SMART_EDITOR;
    public static final /* enum */ TemEditorConfig$SmartType SMART_LOCAL;
    public static final /* enum */ TemEditorConfig$SmartType SMART_TEMPLATE;
    public static final /* enum */ TemEditorConfig$SmartType SMART_TRACK;
    public static final /* enum */ TemEditorConfig$SmartType SMART_TRACK_CHAIN;
    private static final /* synthetic */ TemEditorConfig$SmartType[] a;
    private final String mName;

    static {
        Object object = "SMART";
        TemEditorConfig$SmartType$1 temEditorConfig$SmartType$1 = new TemEditorConfig$SmartType$1((String)object);
        SMART = temEditorConfig$SmartType$1;
        Object object2 = "SMART_EDITOR";
        int n10 = 1;
        SMART_EDITOR = object = new TemEditorConfig$SmartType$2((String)object2);
        Object object3 = "SMART_TEMPLATE";
        int n11 = 2;
        SMART_TEMPLATE = object2 = new TemEditorConfig$SmartType$3((String)object3);
        Object object4 = "SMART_LOCAL";
        int n12 = 3;
        SMART_LOCAL = object3 = new TemEditorConfig$SmartType$4((String)object4);
        Object object5 = "SMART_TRACK";
        int n13 = 4;
        SMART_TRACK = object4 = new TemEditorConfig$SmartType$5((String)object5);
        Object object6 = "SMART_TRACK_CHAIN";
        int n14 = 5;
        SMART_TRACK_CHAIN = object5 = new TemEditorConfig$SmartType$6((String)object6);
        TemEditorConfig$SmartType[] temEditorConfig$SmartTypeArray = "SMART_DIY_TRACK";
        int n15 = 6;
        SMART_DIY_TRACK = object6 = new TemEditorConfig$SmartType$7((String)temEditorConfig$SmartTypeArray);
        temEditorConfig$SmartTypeArray = new TemEditorConfig$SmartType[7];
        temEditorConfig$SmartTypeArray[0] = temEditorConfig$SmartType$1;
        temEditorConfig$SmartTypeArray[n10] = object;
        temEditorConfig$SmartTypeArray[n11] = object2;
        temEditorConfig$SmartTypeArray[n12] = object3;
        temEditorConfig$SmartTypeArray[n13] = object4;
        temEditorConfig$SmartTypeArray[n14] = object5;
        temEditorConfig$SmartTypeArray[n15] = object6;
        a = temEditorConfig$SmartTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TemEditorConfig$SmartType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ TemEditorConfig$SmartType(String string2, TemEditorConfig$a temEditorConfig$a) {
        this((String)var1_-1, (int)temEditorConfig$a, (String)var3_2);
        void var3_2;
        void var1_-1;
    }

    public static TemEditorConfig$SmartType valueOf(String string2) {
        return Enum.valueOf(TemEditorConfig$SmartType.class, string2);
    }

    public static TemEditorConfig$SmartType[] values() {
        return (TemEditorConfig$SmartType[])a.clone();
    }

    public String getType() {
        return this.mName;
    }
}

