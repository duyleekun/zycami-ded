/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$1;
import androidx.lifecycle.Lifecycle$State;

public final class Lifecycle$Event
extends Enum {
    private static final /* synthetic */ Lifecycle$Event[] $VALUES;
    public static final /* enum */ Lifecycle$Event ON_ANY;
    public static final /* enum */ Lifecycle$Event ON_CREATE;
    public static final /* enum */ Lifecycle$Event ON_DESTROY;
    public static final /* enum */ Lifecycle$Event ON_PAUSE;
    public static final /* enum */ Lifecycle$Event ON_RESUME;
    public static final /* enum */ Lifecycle$Event ON_START;
    public static final /* enum */ Lifecycle$Event ON_STOP;

    static {
        Lifecycle$Event lifecycle$Event;
        Lifecycle$Event lifecycle$Event2;
        Lifecycle$Event lifecycle$Event3;
        Lifecycle$Event lifecycle$Event4;
        Lifecycle$Event lifecycle$Event5;
        Lifecycle$Event lifecycle$Event6;
        Lifecycle$Event lifecycle$Event7;
        ON_CREATE = lifecycle$Event7 = new Lifecycle$Event("ON_CREATE", 0);
        int n10 = 1;
        ON_START = lifecycle$Event6 = new Lifecycle$Event("ON_START", n10);
        int n11 = 2;
        ON_RESUME = lifecycle$Event5 = new Lifecycle$Event("ON_RESUME", n11);
        int n12 = 3;
        ON_PAUSE = lifecycle$Event4 = new Lifecycle$Event("ON_PAUSE", n12);
        int n13 = 4;
        ON_STOP = lifecycle$Event3 = new Lifecycle$Event("ON_STOP", n13);
        int n14 = 5;
        ON_DESTROY = lifecycle$Event2 = new Lifecycle$Event("ON_DESTROY", n14);
        int n15 = 6;
        ON_ANY = lifecycle$Event = new Lifecycle$Event("ON_ANY", n15);
        Lifecycle$Event[] lifecycle$EventArray = new Lifecycle$Event[7];
        lifecycle$EventArray[0] = lifecycle$Event7;
        lifecycle$EventArray[n10] = lifecycle$Event6;
        lifecycle$EventArray[n11] = lifecycle$Event5;
        lifecycle$EventArray[n12] = lifecycle$Event4;
        lifecycle$EventArray[n13] = lifecycle$Event3;
        lifecycle$EventArray[n14] = lifecycle$Event2;
        lifecycle$EventArray[n15] = lifecycle$Event;
        $VALUES = lifecycle$EventArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Lifecycle$Event() {
        void var2_-1;
        void var1_-1;
    }

    public static Lifecycle$Event downFrom(Lifecycle$State lifecycle$State) {
        int[] nArray = Lifecycle$1.$SwitchMap$androidx$lifecycle$Lifecycle$State;
        int n10 = lifecycle$State.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return null;
                }
                return ON_PAUSE;
            }
            return ON_STOP;
        }
        return ON_DESTROY;
    }

    public static Lifecycle$Event downTo(Lifecycle$State lifecycle$State) {
        int[] nArray = Lifecycle$1.$SwitchMap$androidx$lifecycle$Lifecycle$State;
        int n10 = lifecycle$State.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    return null;
                }
                return ON_DESTROY;
            }
            return ON_PAUSE;
        }
        return ON_STOP;
    }

    public static Lifecycle$Event upFrom(Lifecycle$State lifecycle$State) {
        int[] nArray = Lifecycle$1.$SwitchMap$androidx$lifecycle$Lifecycle$State;
        int n10 = lifecycle$State.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    return null;
                }
                return ON_CREATE;
            }
            return ON_RESUME;
        }
        return ON_START;
    }

    public static Lifecycle$Event upTo(Lifecycle$State lifecycle$State) {
        int[] nArray = Lifecycle$1.$SwitchMap$androidx$lifecycle$Lifecycle$State;
        int n10 = lifecycle$State.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return null;
                }
                return ON_RESUME;
            }
            return ON_START;
        }
        return ON_CREATE;
    }

    public static Lifecycle$Event valueOf(String string2) {
        return Enum.valueOf(Lifecycle$Event.class, string2);
    }

    public static Lifecycle$Event[] values() {
        return (Lifecycle$Event[])$VALUES.clone();
    }

    public Lifecycle$State getTargetState() {
        Object object = Lifecycle$1.$SwitchMap$androidx$lifecycle$Lifecycle$Event;
        int n10 = this.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                object = new IllegalArgumentException;
                CharSequence charSequence = new StringBuilder();
                charSequence.append((Object)this);
                charSequence.append(" has no target state");
                charSequence = charSequence.toString();
                object((String)charSequence);
                throw object;
            }
            case 6: {
                return Lifecycle$State.DESTROYED;
            }
            case 5: {
                return Lifecycle$State.RESUMED;
            }
            case 3: 
            case 4: {
                return Lifecycle$State.STARTED;
            }
            case 1: 
            case 2: 
        }
        return Lifecycle$State.CREATED;
    }
}

