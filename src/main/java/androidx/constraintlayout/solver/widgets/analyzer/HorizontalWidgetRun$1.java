/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType;

public class HorizontalWidgetRun$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WidgetRun$RunType widgetRun$RunType;
        int n12 = WidgetRun$RunType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = nArray;
        try {
            widgetRun$RunType = WidgetRun$RunType.START;
            n11 = widgetRun$RunType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
            widgetRun$RunType = WidgetRun$RunType.END;
            n11 = widgetRun$RunType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;
            widgetRun$RunType = WidgetRun$RunType.CENTER;
            n11 = widgetRun$RunType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

