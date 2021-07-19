/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate;

import com.zhiyun.editortemplate.TemEditorConfig$TemplateType$1;
import com.zhiyun.editortemplate.TemEditorConfig$TemplateType$2;
import com.zhiyun.editortemplate.TemEditorConfig$a;
import d.v.e.j.a;

public abstract class TemEditorConfig$TemplateType
extends Enum
implements a {
    public static final /* enum */ TemEditorConfig$TemplateType EOV;
    public static final /* enum */ TemEditorConfig$TemplateType TEMPLATE;
    private static final /* synthetic */ TemEditorConfig$TemplateType[] a;
    private final String mName;

    static {
        Object object = "EOV";
        TemEditorConfig$TemplateType$1 temEditorConfig$TemplateType$1 = new TemEditorConfig$TemplateType$1((String)object);
        EOV = temEditorConfig$TemplateType$1;
        TemEditorConfig$TemplateType[] temEditorConfig$TemplateTypeArray = "TEMPLATE";
        int n10 = 1;
        TEMPLATE = object = new TemEditorConfig$TemplateType$2((String)temEditorConfig$TemplateTypeArray);
        temEditorConfig$TemplateTypeArray = new TemEditorConfig$TemplateType[2];
        temEditorConfig$TemplateTypeArray[0] = temEditorConfig$TemplateType$1;
        temEditorConfig$TemplateTypeArray[n10] = object;
        a = temEditorConfig$TemplateTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TemEditorConfig$TemplateType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mName = var3_1;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ TemEditorConfig$TemplateType(String string2, TemEditorConfig$a temEditorConfig$a) {
        this((String)var1_-1, (int)temEditorConfig$a, (String)var3_2);
        void var3_2;
        void var1_-1;
    }

    public static TemEditorConfig$TemplateType valueOf(String string2) {
        return Enum.valueOf(TemEditorConfig$TemplateType.class, string2);
    }

    public static TemEditorConfig$TemplateType[] values() {
        return (TemEditorConfig$TemplateType[])a.clone();
    }

    public String getType() {
        return this.mName;
    }
}

