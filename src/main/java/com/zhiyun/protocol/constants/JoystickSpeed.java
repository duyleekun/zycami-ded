/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class JoystickSpeed
extends Enum {
    private static final /* synthetic */ JoystickSpeed[] $VALUES;
    public static final /* enum */ JoystickSpeed HIGH;
    public static final /* enum */ JoystickSpeed LOW;
    public static final /* enum */ JoystickSpeed MEDIUM;
    public static final /* enum */ JoystickSpeed VALUE;
    public final int code;

    static {
        JoystickSpeed joystickSpeed;
        JoystickSpeed joystickSpeed2;
        JoystickSpeed joystickSpeed3;
        JoystickSpeed joystickSpeed4;
        VALUE = joystickSpeed4 = new JoystickSpeed("VALUE", 0, -1);
        int n10 = 1;
        LOW = joystickSpeed3 = new JoystickSpeed("LOW", n10, 0);
        int n11 = 2;
        MEDIUM = joystickSpeed2 = new JoystickSpeed("MEDIUM", n11, n10);
        int n12 = 3;
        HIGH = joystickSpeed = new JoystickSpeed("HIGH", n12, n11);
        JoystickSpeed[] joystickSpeedArray = new JoystickSpeed[4];
        joystickSpeedArray[0] = joystickSpeed4;
        joystickSpeedArray[n10] = joystickSpeed3;
        joystickSpeedArray[n11] = joystickSpeed2;
        joystickSpeedArray[n12] = joystickSpeed;
        $VALUES = joystickSpeedArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private JoystickSpeed() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static JoystickSpeed valueOf(int n10) {
        JoystickSpeed joystickSpeed = LOW;
        for (JoystickSpeed joystickSpeed2 : JoystickSpeed.values()) {
            int n11 = joystickSpeed2.code;
            if (n11 != n10) continue;
            joystickSpeed = joystickSpeed2;
            break;
        }
        return joystickSpeed;
    }

    public static JoystickSpeed valueOf(String string2) {
        return Enum.valueOf(JoystickSpeed.class, string2);
    }

    public static JoystickSpeed[] values() {
        return (JoystickSpeed[])$VALUES.clone();
    }
}

