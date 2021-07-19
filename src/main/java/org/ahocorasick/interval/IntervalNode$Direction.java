/*
 * Decompiled with CFR 0.151.
 */
package org.ahocorasick.interval;

public final class IntervalNode$Direction
extends Enum {
    public static final /* enum */ IntervalNode$Direction LEFT;
    public static final /* enum */ IntervalNode$Direction RIGHT;
    private static final /* synthetic */ IntervalNode$Direction[] a;

    static {
        IntervalNode$Direction intervalNode$Direction;
        IntervalNode$Direction intervalNode$Direction2;
        LEFT = intervalNode$Direction2 = new IntervalNode$Direction("LEFT", 0);
        int n10 = 1;
        RIGHT = intervalNode$Direction = new IntervalNode$Direction("RIGHT", n10);
        IntervalNode$Direction[] intervalNode$DirectionArray = new IntervalNode$Direction[2];
        intervalNode$DirectionArray[0] = intervalNode$Direction2;
        intervalNode$DirectionArray[n10] = intervalNode$Direction;
        a = intervalNode$DirectionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private IntervalNode$Direction() {
        void var2_-1;
        void var1_-1;
    }

    public static IntervalNode$Direction valueOf(String string2) {
        return Enum.valueOf(IntervalNode$Direction.class, string2);
    }

    public static IntervalNode$Direction[] values() {
        return (IntervalNode$Direction[])a.clone();
    }
}

