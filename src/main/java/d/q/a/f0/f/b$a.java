/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.f0.f;

import androidx.lifecycle.Lifecycle$Event;

public class b$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Lifecycle$Event lifecycle$Event;
        int n12 = Lifecycle$Event.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            lifecycle$Event = Lifecycle$Event.ON_CREATE;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$Event = Lifecycle$Event.ON_START;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$Event = Lifecycle$Event.ON_RESUME;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$Event = Lifecycle$Event.ON_PAUSE;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$Event = Lifecycle$Event.ON_STOP;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lifecycle$Event = Lifecycle$Event.ON_DESTROY;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

