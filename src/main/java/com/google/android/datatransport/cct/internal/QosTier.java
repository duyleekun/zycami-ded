/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

public final class QosTier
extends Enum {
    private static final /* synthetic */ QosTier[] $VALUES;
    public static final /* enum */ QosTier DEFAULT;
    public static final /* enum */ QosTier FAST_IF_RADIO_AWAKE;
    public static final /* enum */ QosTier NEVER;
    public static final /* enum */ QosTier UNMETERED_ONLY;
    public static final /* enum */ QosTier UNMETERED_OR_DAILY;
    public static final /* enum */ QosTier UNRECOGNIZED;
    private static final SparseArray valueMap;
    private final int value;

    static {
        QosTier qosTier;
        QosTier qosTier2;
        QosTier qosTier3;
        QosTier qosTier4;
        QosTier qosTier5;
        QosTier qosTier6;
        DEFAULT = qosTier6 = new QosTier("DEFAULT", 0, 0);
        int n10 = 1;
        UNMETERED_ONLY = qosTier5 = new QosTier("UNMETERED_ONLY", n10, n10);
        int n11 = 2;
        UNMETERED_OR_DAILY = qosTier4 = new QosTier("UNMETERED_OR_DAILY", n11, n11);
        int n12 = 3;
        FAST_IF_RADIO_AWAKE = qosTier3 = new QosTier("FAST_IF_RADIO_AWAKE", n12, n12);
        int n13 = 4;
        NEVER = qosTier2 = new QosTier("NEVER", n13, n13);
        int n14 = 5;
        int n15 = -1;
        UNRECOGNIZED = qosTier = new QosTier("UNRECOGNIZED", n14, n15);
        SparseArray sparseArray = new QosTier[6];
        sparseArray[0] = qosTier6;
        sparseArray[n10] = qosTier5;
        sparseArray[n11] = qosTier4;
        sparseArray[n12] = qosTier3;
        sparseArray[n13] = qosTier2;
        sparseArray[n14] = qosTier;
        $VALUES = sparseArray;
        valueMap = sparseArray = new SparseArray();
        sparseArray.put(0, (Object)qosTier6);
        sparseArray.put(n10, (Object)qosTier5);
        sparseArray.put(n11, (Object)qosTier4);
        sparseArray.put(n12, (Object)qosTier3);
        sparseArray.put(n13, (Object)qosTier2);
        sparseArray.put(n15, (Object)qosTier);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private QosTier() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static QosTier forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return null;
                        }
                        return NEVER;
                    }
                    return FAST_IF_RADIO_AWAKE;
                }
                return UNMETERED_OR_DAILY;
            }
            return UNMETERED_ONLY;
        }
        return DEFAULT;
    }

    public static QosTier valueOf(String string2) {
        return Enum.valueOf(QosTier.class, string2);
    }

    public static QosTier[] values() {
        return (QosTier[])$VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }
}

