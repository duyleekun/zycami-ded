/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import com.zhiyun.editortemplate.data.resource.Status;

public class EditorTemplateEndingFragment$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Status status;
        int n12 = Status.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            status = Status.CACHE;
            n11 = status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.LOADING;
            n11 = status.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.SUCCESS;
            n11 = status.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.ERROR;
            n11 = status.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

