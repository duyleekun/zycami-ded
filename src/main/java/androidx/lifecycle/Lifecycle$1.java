/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;

public class Lifecycle$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14;
        Object object4;
        int n15;
        Object object5;
        int n16 = Lifecycle$Event.values().length;
        int[] nArray = new int[n16];
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = nArray;
        int n17 = 1;
        try {
            object5 = Lifecycle$Event.ON_CREATE;
            n15 = object5.ordinal();
            nArray[n15] = n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n16 = 2;
        try {
            object5 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            object4 = Lifecycle$Event.ON_STOP;
            n14 = object4.ordinal();
            object5[n14] = (Lifecycle$Event)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 3;
        try {
            object4 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            object3 = Lifecycle$Event.ON_START;
            n13 = object3.ordinal();
            object4[n13] = (Lifecycle$Event)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 4;
        try {
            object3 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            object2 = Lifecycle$Event.ON_PAUSE;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (Lifecycle$Event)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 5;
        try {
            object2 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            enum_ = Lifecycle$Event.ON_RESUME;
            n11 = enum_.ordinal();
            object2[n11] = (Lifecycle$Event)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            enum_ = Lifecycle$Event.ON_DESTROY;
            n11 = enum_.ordinal();
            n10 = 6;
            object2[n11] = (Lifecycle$Event)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            enum_ = Lifecycle$Event.ON_ANY;
            n11 = enum_.ordinal();
            n10 = 7;
            object2[n11] = (Lifecycle$Event)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = Lifecycle$State.values().length;
        object2 = new int[n12];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = (int[])object2;
        try {
            enum_ = Lifecycle$State.CREATED;
            n11 = enum_.ordinal();
            object2[n11] = (Lifecycle$Event)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            object2 = Lifecycle$State.STARTED;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            object = (Object)Lifecycle$State.RESUMED;
            n17 = ((Enum)object).ordinal();
            nArray[n17] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            object = Lifecycle$State.DESTROYED;
            n17 = ((Enum)object).ordinal();
            nArray[n17] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            object = Lifecycle$State.INITIALIZED;
            n17 = ((Enum)object).ordinal();
            nArray[n17] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

