/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.active;

import com.zhiyun.device.active.ActivationViewModel$ProcessStatus;

public class ActivationPrepareFragment$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus;
        int n12 = ActivationViewModel$ProcessStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            activationViewModel$ProcessStatus = ActivationViewModel$ProcessStatus.PROCESS_STATUS_SUCCESS;
            n11 = activationViewModel$ProcessStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            activationViewModel$ProcessStatus = ActivationViewModel$ProcessStatus.PROCESS_STATUS_FAIL;
            n11 = activationViewModel$ProcessStatus.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

