/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

public final class InspectableProperty$ValueType
extends Enum {
    private static final /* synthetic */ InspectableProperty$ValueType[] $VALUES;
    public static final /* enum */ InspectableProperty$ValueType COLOR;
    public static final /* enum */ InspectableProperty$ValueType GRAVITY;
    public static final /* enum */ InspectableProperty$ValueType INFERRED;
    public static final /* enum */ InspectableProperty$ValueType INT_ENUM;
    public static final /* enum */ InspectableProperty$ValueType INT_FLAG;
    public static final /* enum */ InspectableProperty$ValueType NONE;
    public static final /* enum */ InspectableProperty$ValueType RESOURCE_ID;

    static {
        InspectableProperty$ValueType inspectableProperty$ValueType;
        InspectableProperty$ValueType inspectableProperty$ValueType2;
        InspectableProperty$ValueType inspectableProperty$ValueType3;
        InspectableProperty$ValueType inspectableProperty$ValueType4;
        InspectableProperty$ValueType inspectableProperty$ValueType5;
        InspectableProperty$ValueType inspectableProperty$ValueType6;
        InspectableProperty$ValueType inspectableProperty$ValueType7;
        NONE = inspectableProperty$ValueType7 = new InspectableProperty$ValueType("NONE", 0);
        int n10 = 1;
        INFERRED = inspectableProperty$ValueType6 = new InspectableProperty$ValueType("INFERRED", n10);
        int n11 = 2;
        INT_ENUM = inspectableProperty$ValueType5 = new InspectableProperty$ValueType("INT_ENUM", n11);
        int n12 = 3;
        INT_FLAG = inspectableProperty$ValueType4 = new InspectableProperty$ValueType("INT_FLAG", n12);
        int n13 = 4;
        COLOR = inspectableProperty$ValueType3 = new InspectableProperty$ValueType("COLOR", n13);
        int n14 = 5;
        GRAVITY = inspectableProperty$ValueType2 = new InspectableProperty$ValueType("GRAVITY", n14);
        int n15 = 6;
        RESOURCE_ID = inspectableProperty$ValueType = new InspectableProperty$ValueType("RESOURCE_ID", n15);
        InspectableProperty$ValueType[] inspectableProperty$ValueTypeArray = new InspectableProperty$ValueType[7];
        inspectableProperty$ValueTypeArray[0] = inspectableProperty$ValueType7;
        inspectableProperty$ValueTypeArray[n10] = inspectableProperty$ValueType6;
        inspectableProperty$ValueTypeArray[n11] = inspectableProperty$ValueType5;
        inspectableProperty$ValueTypeArray[n12] = inspectableProperty$ValueType4;
        inspectableProperty$ValueTypeArray[n13] = inspectableProperty$ValueType3;
        inspectableProperty$ValueTypeArray[n14] = inspectableProperty$ValueType2;
        inspectableProperty$ValueTypeArray[n15] = inspectableProperty$ValueType;
        $VALUES = inspectableProperty$ValueTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private InspectableProperty$ValueType() {
        void var2_-1;
        void var1_-1;
    }

    public static InspectableProperty$ValueType valueOf(String string2) {
        return Enum.valueOf(InspectableProperty$ValueType.class, string2);
    }

    public static InspectableProperty$ValueType[] values() {
        return (InspectableProperty$ValueType[])$VALUES.clone();
    }
}

