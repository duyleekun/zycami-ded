/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

public @interface TemplateRetention$TemplateUseType {
    public static final int TEMPLATE_DRAFT = 3;
    public static final int TEMPLATE_EDITOR = 0;
    public static final int TEMPLATE_SMART = 1;
    public static final int TEMPLATE_WITHDRAW = 2;
    public static final int[] allArray;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 0;
        nArray3[1] = 1;
        nArray2[2] = 2;
        nArray3[3] = 3;
        allArray = nArray;
    }
}

