/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

public final class ActivationViewModel$ProcessStatus
extends Enum {
    public static final /* enum */ ActivationViewModel$ProcessStatus PROCESS_STATUS_FAIL;
    public static final /* enum */ ActivationViewModel$ProcessStatus PROCESS_STATUS_ING;
    public static final /* enum */ ActivationViewModel$ProcessStatus PROCESS_STATUS_NONE;
    public static final /* enum */ ActivationViewModel$ProcessStatus PROCESS_STATUS_SUCCESS;
    private static final /* synthetic */ ActivationViewModel$ProcessStatus[] a;

    static {
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus;
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus2;
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus3;
        ActivationViewModel$ProcessStatus activationViewModel$ProcessStatus4;
        PROCESS_STATUS_NONE = activationViewModel$ProcessStatus4 = new ActivationViewModel$ProcessStatus("PROCESS_STATUS_NONE", 0);
        int n10 = 1;
        PROCESS_STATUS_ING = activationViewModel$ProcessStatus3 = new ActivationViewModel$ProcessStatus("PROCESS_STATUS_ING", n10);
        int n11 = 2;
        PROCESS_STATUS_FAIL = activationViewModel$ProcessStatus2 = new ActivationViewModel$ProcessStatus("PROCESS_STATUS_FAIL", n11);
        int n12 = 3;
        PROCESS_STATUS_SUCCESS = activationViewModel$ProcessStatus = new ActivationViewModel$ProcessStatus("PROCESS_STATUS_SUCCESS", n12);
        ActivationViewModel$ProcessStatus[] activationViewModel$ProcessStatusArray = new ActivationViewModel$ProcessStatus[4];
        activationViewModel$ProcessStatusArray[0] = activationViewModel$ProcessStatus4;
        activationViewModel$ProcessStatusArray[n10] = activationViewModel$ProcessStatus3;
        activationViewModel$ProcessStatusArray[n11] = activationViewModel$ProcessStatus2;
        activationViewModel$ProcessStatusArray[n12] = activationViewModel$ProcessStatus;
        a = activationViewModel$ProcessStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ActivationViewModel$ProcessStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static ActivationViewModel$ProcessStatus valueOf(String string2) {
        return Enum.valueOf(ActivationViewModel$ProcessStatus.class, string2);
    }

    public static ActivationViewModel$ProcessStatus[] values() {
        return (ActivationViewModel$ProcessStatus[])a.clone();
    }
}

