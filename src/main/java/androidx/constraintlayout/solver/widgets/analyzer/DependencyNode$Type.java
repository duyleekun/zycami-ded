/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

public final class DependencyNode$Type
extends Enum {
    private static final /* synthetic */ DependencyNode$Type[] $VALUES;
    public static final /* enum */ DependencyNode$Type BASELINE;
    public static final /* enum */ DependencyNode$Type BOTTOM;
    public static final /* enum */ DependencyNode$Type HORIZONTAL_DIMENSION;
    public static final /* enum */ DependencyNode$Type LEFT;
    public static final /* enum */ DependencyNode$Type RIGHT;
    public static final /* enum */ DependencyNode$Type TOP;
    public static final /* enum */ DependencyNode$Type UNKNOWN;
    public static final /* enum */ DependencyNode$Type VERTICAL_DIMENSION;

    static {
        DependencyNode$Type dependencyNode$Type;
        DependencyNode$Type dependencyNode$Type2;
        DependencyNode$Type dependencyNode$Type3;
        DependencyNode$Type dependencyNode$Type4;
        DependencyNode$Type dependencyNode$Type5;
        DependencyNode$Type dependencyNode$Type6;
        DependencyNode$Type dependencyNode$Type7;
        DependencyNode$Type dependencyNode$Type8;
        UNKNOWN = dependencyNode$Type8 = new DependencyNode$Type("UNKNOWN", 0);
        int n10 = 1;
        HORIZONTAL_DIMENSION = dependencyNode$Type7 = new DependencyNode$Type("HORIZONTAL_DIMENSION", n10);
        int n11 = 2;
        VERTICAL_DIMENSION = dependencyNode$Type6 = new DependencyNode$Type("VERTICAL_DIMENSION", n11);
        int n12 = 3;
        LEFT = dependencyNode$Type5 = new DependencyNode$Type("LEFT", n12);
        int n13 = 4;
        RIGHT = dependencyNode$Type4 = new DependencyNode$Type("RIGHT", n13);
        int n14 = 5;
        TOP = dependencyNode$Type3 = new DependencyNode$Type("TOP", n14);
        BOTTOM = dependencyNode$Type2 = new DependencyNode$Type("BOTTOM", 6);
        int n15 = 7;
        BASELINE = dependencyNode$Type = new DependencyNode$Type("BASELINE", n15);
        DependencyNode$Type[] dependencyNode$TypeArray = new DependencyNode$Type[8];
        dependencyNode$TypeArray[0] = dependencyNode$Type8;
        dependencyNode$TypeArray[n10] = dependencyNode$Type7;
        dependencyNode$TypeArray[n11] = dependencyNode$Type6;
        dependencyNode$TypeArray[n12] = dependencyNode$Type5;
        dependencyNode$TypeArray[n13] = dependencyNode$Type4;
        dependencyNode$TypeArray[n14] = dependencyNode$Type3;
        dependencyNode$TypeArray[6] = dependencyNode$Type2;
        dependencyNode$TypeArray[n15] = dependencyNode$Type;
        $VALUES = dependencyNode$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DependencyNode$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static DependencyNode$Type valueOf(String string2) {
        return Enum.valueOf(DependencyNode$Type.class, string2);
    }

    public static DependencyNode$Type[] values() {
        return (DependencyNode$Type[])$VALUES.clone();
    }
}

