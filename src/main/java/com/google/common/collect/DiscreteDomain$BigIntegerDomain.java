/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;
import java.math.BigInteger;

public final class DiscreteDomain$BigIntegerDomain
extends DiscreteDomain
implements Serializable {
    private static final DiscreteDomain$BigIntegerDomain INSTANCE;
    private static final BigInteger MAX_LONG;
    private static final BigInteger MIN_LONG;
    private static final long serialVersionUID;

    static {
        DiscreteDomain$BigIntegerDomain discreteDomain$BigIntegerDomain;
        INSTANCE = discreteDomain$BigIntegerDomain = new DiscreteDomain$BigIntegerDomain();
        MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
        MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public DiscreteDomain$BigIntegerDomain() {
        super(true, null);
    }

    public static /* synthetic */ DiscreteDomain$BigIntegerDomain access$300() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger2.subtract(bigInteger);
        bigInteger2 = MIN_LONG;
        bigInteger = bigInteger.max(bigInteger2);
        bigInteger2 = MAX_LONG;
        return bigInteger.min(bigInteger2).longValue();
    }

    public BigInteger next(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        return bigInteger.add(bigInteger2);
    }

    public BigInteger offset(BigInteger bigInteger, long l10) {
        CollectPreconditions.checkNonnegative(l10, "distance");
        BigInteger bigInteger2 = BigInteger.valueOf(l10);
        return bigInteger.add(bigInteger2);
    }

    public BigInteger previous(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        return bigInteger.subtract(bigInteger2);
    }

    public String toString() {
        return "DiscreteDomain.bigIntegers()";
    }
}

