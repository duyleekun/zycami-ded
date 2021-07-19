/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import com.zhiyun.cama.camera.ble.BleViewModel$JoystickEvent;

public class e1$c {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent;
        int n12 = BleViewModel$JoystickEvent.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            bleViewModel$JoystickEvent = BleViewModel$JoystickEvent.UP;
            n11 = bleViewModel$JoystickEvent.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            bleViewModel$JoystickEvent = BleViewModel$JoystickEvent.DOWN;
            n11 = bleViewModel$JoystickEvent.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            bleViewModel$JoystickEvent = BleViewModel$JoystickEvent.LEFT;
            n11 = bleViewModel$JoystickEvent.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            bleViewModel$JoystickEvent = BleViewModel$JoystickEvent.RIGHT;
            n11 = bleViewModel$JoystickEvent.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

