/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

public final class WidgetRun$RunType
extends Enum {
    private static final /* synthetic */ WidgetRun$RunType[] $VALUES;
    public static final /* enum */ WidgetRun$RunType CENTER;
    public static final /* enum */ WidgetRun$RunType END;
    public static final /* enum */ WidgetRun$RunType NONE;
    public static final /* enum */ WidgetRun$RunType START;

    static {
        WidgetRun$RunType widgetRun$RunType;
        WidgetRun$RunType widgetRun$RunType2;
        WidgetRun$RunType widgetRun$RunType3;
        WidgetRun$RunType widgetRun$RunType4;
        NONE = widgetRun$RunType4 = new WidgetRun$RunType("NONE", 0);
        int n10 = 1;
        START = widgetRun$RunType3 = new WidgetRun$RunType("START", n10);
        int n11 = 2;
        END = widgetRun$RunType2 = new WidgetRun$RunType("END", n11);
        int n12 = 3;
        CENTER = widgetRun$RunType = new WidgetRun$RunType("CENTER", n12);
        WidgetRun$RunType[] widgetRun$RunTypeArray = new WidgetRun$RunType[4];
        widgetRun$RunTypeArray[0] = widgetRun$RunType4;
        widgetRun$RunTypeArray[n10] = widgetRun$RunType3;
        widgetRun$RunTypeArray[n11] = widgetRun$RunType2;
        widgetRun$RunTypeArray[n12] = widgetRun$RunType;
        $VALUES = widgetRun$RunTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WidgetRun$RunType() {
        void var2_-1;
        void var1_-1;
    }

    public static WidgetRun$RunType valueOf(String string2) {
        return Enum.valueOf(WidgetRun$RunType.class, string2);
    }

    public static WidgetRun$RunType[] values() {
        return (WidgetRun$RunType[])$VALUES.clone();
    }
}

