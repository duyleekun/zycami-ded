/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public final class RecyclerView$Adapter$StateRestorationPolicy
extends Enum {
    private static final /* synthetic */ RecyclerView$Adapter$StateRestorationPolicy[] $VALUES;
    public static final /* enum */ RecyclerView$Adapter$StateRestorationPolicy ALLOW;
    public static final /* enum */ RecyclerView$Adapter$StateRestorationPolicy PREVENT;
    public static final /* enum */ RecyclerView$Adapter$StateRestorationPolicy PREVENT_WHEN_EMPTY;

    static {
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy;
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy2;
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy3;
        ALLOW = recyclerView$Adapter$StateRestorationPolicy3 = new RecyclerView$Adapter$StateRestorationPolicy("ALLOW", 0);
        int n10 = 1;
        PREVENT_WHEN_EMPTY = recyclerView$Adapter$StateRestorationPolicy2 = new RecyclerView$Adapter$StateRestorationPolicy("PREVENT_WHEN_EMPTY", n10);
        int n11 = 2;
        PREVENT = recyclerView$Adapter$StateRestorationPolicy = new RecyclerView$Adapter$StateRestorationPolicy("PREVENT", n11);
        RecyclerView$Adapter$StateRestorationPolicy[] recyclerView$Adapter$StateRestorationPolicyArray = new RecyclerView$Adapter$StateRestorationPolicy[3];
        recyclerView$Adapter$StateRestorationPolicyArray[0] = recyclerView$Adapter$StateRestorationPolicy3;
        recyclerView$Adapter$StateRestorationPolicyArray[n10] = recyclerView$Adapter$StateRestorationPolicy2;
        recyclerView$Adapter$StateRestorationPolicyArray[n11] = recyclerView$Adapter$StateRestorationPolicy;
        $VALUES = recyclerView$Adapter$StateRestorationPolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RecyclerView$Adapter$StateRestorationPolicy() {
        void var2_-1;
        void var1_-1;
    }

    public static RecyclerView$Adapter$StateRestorationPolicy valueOf(String string2) {
        return Enum.valueOf(RecyclerView$Adapter$StateRestorationPolicy.class, string2);
    }

    public static RecyclerView$Adapter$StateRestorationPolicy[] values() {
        return (RecyclerView$Adapter$StateRestorationPolicy[])$VALUES.clone();
    }
}

