/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.firmware;

public final class FirmwareUpgradeViewModel$FirmwareFailType
extends Enum {
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_BATTERY_LOW;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_BLE_DISCONNECT;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_FAILED_AND_NO_RETRY;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_FAILED_OTHER;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_GET_BATTERY_FAILED;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_GET_MODULE_FAILED;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_PREPARE_UPGRADE_FILE_FAILED;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_SCAN_OR_CONNECT_FAILED;
    public static final /* enum */ FirmwareUpgradeViewModel$FirmwareFailType TYPE_WIFI_DISCONNECT;
    private static final /* synthetic */ FirmwareUpgradeViewModel$FirmwareFailType[] a;

    static {
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType2;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType3;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType4;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType5;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType6;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType7;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType8;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType9;
        TYPE_WIFI_DISCONNECT = firmwareUpgradeViewModel$FirmwareFailType9 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_WIFI_DISCONNECT", 0);
        int n10 = 1;
        TYPE_BLE_DISCONNECT = firmwareUpgradeViewModel$FirmwareFailType8 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_BLE_DISCONNECT", n10);
        int n11 = 2;
        TYPE_GET_MODULE_FAILED = firmwareUpgradeViewModel$FirmwareFailType7 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_GET_MODULE_FAILED", n11);
        int n12 = 3;
        TYPE_PREPARE_UPGRADE_FILE_FAILED = firmwareUpgradeViewModel$FirmwareFailType6 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_PREPARE_UPGRADE_FILE_FAILED", n12);
        int n13 = 4;
        TYPE_GET_BATTERY_FAILED = firmwareUpgradeViewModel$FirmwareFailType5 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_GET_BATTERY_FAILED", n13);
        TYPE_BATTERY_LOW = firmwareUpgradeViewModel$FirmwareFailType4 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_BATTERY_LOW", 5);
        TYPE_SCAN_OR_CONNECT_FAILED = firmwareUpgradeViewModel$FirmwareFailType3 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_SCAN_OR_CONNECT_FAILED", 6);
        TYPE_FAILED_AND_NO_RETRY = firmwareUpgradeViewModel$FirmwareFailType2 = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_FAILED_AND_NO_RETRY", 7);
        int n14 = 8;
        TYPE_FAILED_OTHER = firmwareUpgradeViewModel$FirmwareFailType = new FirmwareUpgradeViewModel$FirmwareFailType("TYPE_FAILED_OTHER", n14);
        FirmwareUpgradeViewModel$FirmwareFailType[] firmwareUpgradeViewModel$FirmwareFailTypeArray = new FirmwareUpgradeViewModel$FirmwareFailType[9];
        firmwareUpgradeViewModel$FirmwareFailTypeArray[0] = firmwareUpgradeViewModel$FirmwareFailType9;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[n10] = firmwareUpgradeViewModel$FirmwareFailType8;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[n11] = firmwareUpgradeViewModel$FirmwareFailType7;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[n12] = firmwareUpgradeViewModel$FirmwareFailType6;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[n13] = firmwareUpgradeViewModel$FirmwareFailType5;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[5] = firmwareUpgradeViewModel$FirmwareFailType4;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[6] = firmwareUpgradeViewModel$FirmwareFailType3;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[7] = firmwareUpgradeViewModel$FirmwareFailType2;
        firmwareUpgradeViewModel$FirmwareFailTypeArray[n14] = firmwareUpgradeViewModel$FirmwareFailType;
        a = firmwareUpgradeViewModel$FirmwareFailTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FirmwareUpgradeViewModel$FirmwareFailType() {
        void var2_-1;
        void var1_-1;
    }

    public static FirmwareUpgradeViewModel$FirmwareFailType valueOf(String string2) {
        return Enum.valueOf(FirmwareUpgradeViewModel$FirmwareFailType.class, string2);
    }

    public static FirmwareUpgradeViewModel$FirmwareFailType[] values() {
        return (FirmwareUpgradeViewModel$FirmwareFailType[])a.clone();
    }
}

