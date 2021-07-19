/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.NotificationSetupMode;

public class s0$h {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        NotificationSetupMode notificationSetupMode;
        int n12 = NotificationSetupMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            notificationSetupMode = NotificationSetupMode.COMPAT;
            n11 = notificationSetupMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            notificationSetupMode = NotificationSetupMode.QUICK_SETUP;
            n11 = notificationSetupMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            notificationSetupMode = NotificationSetupMode.DEFAULT;
            n11 = notificationSetupMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

