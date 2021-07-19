/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.other;

public final class UpgradeLink
extends Enum {
    public static final /* enum */ UpgradeLink BLE;
    public static final /* enum */ UpgradeLink WIFI;
    private static final /* synthetic */ UpgradeLink[] a;

    static {
        UpgradeLink upgradeLink;
        UpgradeLink upgradeLink2;
        BLE = upgradeLink2 = new UpgradeLink("BLE", 0);
        int n10 = 1;
        WIFI = upgradeLink = new UpgradeLink("WIFI", n10);
        UpgradeLink[] upgradeLinkArray = new UpgradeLink[2];
        upgradeLinkArray[0] = upgradeLink2;
        upgradeLinkArray[n10] = upgradeLink;
        a = upgradeLinkArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UpgradeLink() {
        void var2_-1;
        void var1_-1;
    }

    public static UpgradeLink valueOf(String string2) {
        return Enum.valueOf(UpgradeLink.class, string2);
    }

    public static UpgradeLink[] values() {
        return (UpgradeLink[])a.clone();
    }
}

