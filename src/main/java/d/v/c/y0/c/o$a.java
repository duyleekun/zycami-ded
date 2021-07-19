/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.c;

import com.zhiyun.device.firmware.FirmwareUpgradeViewModel$FirmwareFailType;

public class o$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        FirmwareUpgradeViewModel$FirmwareFailType firmwareUpgradeViewModel$FirmwareFailType;
        int n12 = FirmwareUpgradeViewModel$FirmwareFailType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_WIFI_DISCONNECT;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_BLE_DISCONNECT;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_GET_MODULE_FAILED;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_PREPARE_UPGRADE_FILE_FAILED;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_GET_BATTERY_FAILED;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_BATTERY_LOW;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_SCAN_OR_CONNECT_FAILED;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            firmwareUpgradeViewModel$FirmwareFailType = FirmwareUpgradeViewModel$FirmwareFailType.TYPE_FAILED_OTHER;
            n11 = firmwareUpgradeViewModel$FirmwareFailType.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

