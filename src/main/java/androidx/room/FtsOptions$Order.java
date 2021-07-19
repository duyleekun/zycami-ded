/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public final class FtsOptions$Order
extends Enum {
    private static final /* synthetic */ FtsOptions$Order[] $VALUES;
    public static final /* enum */ FtsOptions$Order ASC;
    public static final /* enum */ FtsOptions$Order DESC;

    static {
        FtsOptions$Order ftsOptions$Order;
        FtsOptions$Order ftsOptions$Order2;
        ASC = ftsOptions$Order2 = new FtsOptions$Order("ASC", 0);
        int n10 = 1;
        DESC = ftsOptions$Order = new FtsOptions$Order("DESC", n10);
        FtsOptions$Order[] ftsOptions$OrderArray = new FtsOptions$Order[2];
        ftsOptions$OrderArray[0] = ftsOptions$Order2;
        ftsOptions$OrderArray[n10] = ftsOptions$Order;
        $VALUES = ftsOptions$OrderArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FtsOptions$Order() {
        void var2_-1;
        void var1_-1;
    }

    public static FtsOptions$Order valueOf(String string2) {
        return Enum.valueOf(FtsOptions$Order.class, string2);
    }

    public static FtsOptions$Order[] values() {
        return (FtsOptions$Order[])$VALUES.clone();
    }
}

