/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

public final class BleViewModel$JoystickEvent
extends Enum {
    public static final /* enum */ BleViewModel$JoystickEvent DOWN;
    public static final /* enum */ BleViewModel$JoystickEvent LEFT;
    public static final /* enum */ BleViewModel$JoystickEvent RIGHT;
    public static final /* enum */ BleViewModel$JoystickEvent UP;
    private static final /* synthetic */ BleViewModel$JoystickEvent[] a;

    static {
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent;
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent2;
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent3;
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent4;
        LEFT = bleViewModel$JoystickEvent4 = new BleViewModel$JoystickEvent("LEFT", 0);
        int n10 = 1;
        UP = bleViewModel$JoystickEvent3 = new BleViewModel$JoystickEvent("UP", n10);
        int n11 = 2;
        RIGHT = bleViewModel$JoystickEvent2 = new BleViewModel$JoystickEvent("RIGHT", n11);
        int n12 = 3;
        DOWN = bleViewModel$JoystickEvent = new BleViewModel$JoystickEvent("DOWN", n12);
        BleViewModel$JoystickEvent[] bleViewModel$JoystickEventArray = new BleViewModel$JoystickEvent[4];
        bleViewModel$JoystickEventArray[0] = bleViewModel$JoystickEvent4;
        bleViewModel$JoystickEventArray[n10] = bleViewModel$JoystickEvent3;
        bleViewModel$JoystickEventArray[n11] = bleViewModel$JoystickEvent2;
        bleViewModel$JoystickEventArray[n12] = bleViewModel$JoystickEvent;
        a = bleViewModel$JoystickEventArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleViewModel$JoystickEvent() {
        void var2_-1;
        void var1_-1;
    }

    public static BleViewModel$JoystickEvent valueOf(String string2) {
        return Enum.valueOf(BleViewModel$JoystickEvent.class, string2);
    }

    public static BleViewModel$JoystickEvent[] values() {
        return (BleViewModel$JoystickEvent[])a.clone();
    }
}

