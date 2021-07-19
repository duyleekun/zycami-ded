/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;

public class sd$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState;
        int n12 = RxBleConnection$RxBleConnectionState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.CONNECTED;
            n11 = rxBleConnection$RxBleConnectionState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.DISCONNECTED;
            n11 = rxBleConnection$RxBleConnectionState.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

