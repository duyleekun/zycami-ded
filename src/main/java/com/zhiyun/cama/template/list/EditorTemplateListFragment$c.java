/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.list;

import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import com.zhiyun.editortemplate.data.resource.Status;

public class EditorTemplateListFragment$c {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object;
        int n13 = Status.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object = Status.CACHE;
            n12 = ((Enum)object).ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object = b;
            enum_ = Status.LOADING;
            n11 = enum_.ordinal();
            object[n11] = (Status)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = Status.SUCCESS;
            n11 = enum_.ordinal();
            n10 = 3;
            object[n11] = (Status)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = Status.ERROR;
            n11 = enum_.ordinal();
            n10 = 4;
            object[n11] = (Status)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = DeviceViewModel$NetWorkEvent.values().length;
        object = new int[n12];
        a = (int[])object;
        try {
            enum_ = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_CONNECTED;
            n11 = enum_.ordinal();
            object[n11] = (Status)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            int[] nArray2 = a;
            object = DeviceViewModel$NetWorkEvent.NET_WORK_MOBILE_CONNECTED;
            n12 = ((Enum)object).ordinal();
            nArray2[n12] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

