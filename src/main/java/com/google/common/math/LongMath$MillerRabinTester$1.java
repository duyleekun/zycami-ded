/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LongMath$MillerRabinTester;

public final class LongMath$MillerRabinTester$1
extends LongMath$MillerRabinTester {
    public long mulMod(long l10, long l11, long l12) {
        return l10 * l11 % l12;
    }

    public long squareMod(long l10, long l11) {
        return l10 * l10 % l11;
    }
}

