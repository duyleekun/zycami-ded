/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.dialog.more;

import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;

public class SetStabilizerFragment$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        KeyFunc keyFunc;
        int n12 = KeyFunc.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            keyFunc = KeyFunc.APP_CUSTOM_MENU;
            n11 = keyFunc.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            keyFunc = KeyFunc.APP_PHOTO_VIDEO;
            n11 = keyFunc.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

