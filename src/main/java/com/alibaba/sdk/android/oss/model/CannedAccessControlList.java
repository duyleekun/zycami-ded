/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public final class CannedAccessControlList
extends Enum {
    private static final /* synthetic */ CannedAccessControlList[] $VALUES;
    public static final /* enum */ CannedAccessControlList Default;
    public static final /* enum */ CannedAccessControlList Private;
    public static final /* enum */ CannedAccessControlList PublicRead;
    public static final /* enum */ CannedAccessControlList PublicReadWrite;
    private String ACLString;

    static {
        CannedAccessControlList cannedAccessControlList;
        CannedAccessControlList cannedAccessControlList2;
        CannedAccessControlList cannedAccessControlList3;
        CannedAccessControlList cannedAccessControlList4;
        Private = cannedAccessControlList4 = new CannedAccessControlList("Private", 0, "private");
        int n10 = 1;
        PublicRead = cannedAccessControlList3 = new CannedAccessControlList("PublicRead", n10, "public-read");
        int n11 = 2;
        PublicReadWrite = cannedAccessControlList2 = new CannedAccessControlList("PublicReadWrite", n11, "public-read-write");
        int n12 = 3;
        Default = cannedAccessControlList = new CannedAccessControlList("Default", n12, "default");
        CannedAccessControlList[] cannedAccessControlListArray = new CannedAccessControlList[4];
        cannedAccessControlListArray[0] = cannedAccessControlList4;
        cannedAccessControlListArray[n10] = cannedAccessControlList3;
        cannedAccessControlListArray[n11] = cannedAccessControlList2;
        cannedAccessControlListArray[n12] = cannedAccessControlList;
        $VALUES = cannedAccessControlListArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CannedAccessControlList() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.ACLString = var3_1;
    }

    public static CannedAccessControlList parseACL(String string2) {
        CannedAccessControlList cannedAccessControlList2;
        block2: {
            for (CannedAccessControlList cannedAccessControlList2 : CannedAccessControlList.values()) {
                String string3 = cannedAccessControlList2.toString();
                boolean bl2 = string3.equals(string2);
                if (!bl2) {
                    continue;
                }
                break block2;
            }
            cannedAccessControlList2 = null;
        }
        return cannedAccessControlList2;
    }

    public static CannedAccessControlList valueOf(String string2) {
        return Enum.valueOf(CannedAccessControlList.class, string2);
    }

    public static CannedAccessControlList[] values() {
        return (CannedAccessControlList[])$VALUES.clone();
    }

    public String toString() {
        return this.ACLString;
    }
}

