/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.StatsAccumulator;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public final class Stats
implements Serializable {
    public static final int BYTES = 40;
    private static final long serialVersionUID;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long l10, double d10, double d11, double d12, double d13) {
        this.count = l10;
        this.mean = d10;
        this.sumOfSquaresOfDeltas = d11;
        this.min = d12;
        this.max = d13;
    }

    public static Stats fromByteArray(byte[] object) {
        ByteOrder byteOrder;
        Preconditions.checkNotNull(object);
        int n10 = ((byte[])object).length;
        int n11 = 40;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            byteOrder = null;
        }
        int n12 = ((byte[])object).length;
        Preconditions.checkArgument(n10 != 0, "Expected Stats.BYTES = %s remaining , got %s", n11, n12);
        object = ByteBuffer.wrap((byte[])object);
        byteOrder = ByteOrder.LITTLE_ENDIAN;
        return Stats.readFrom(((ByteBuffer)object).order(byteOrder));
    }

    public static double meanOf(Iterable iterable) {
        return Stats.meanOf(iterable.iterator());
    }

    public static double meanOf(Iterator iterator2) {
        boolean bl2;
        long l10;
        boolean bl3 = iterator2.hasNext();
        Preconditions.checkArgument(bl3);
        Number number = (Number)iterator2.next();
        double d10 = number.doubleValue();
        long l11 = l10 = 1L;
        while (bl2 = iterator2.hasNext()) {
            Number number2 = (Number)iterator2.next();
            double d11 = number2.doubleValue();
            l11 += l10;
            boolean bl4 = Doubles.isFinite(d11);
            if (bl4 && (bl4 = Doubles.isFinite(d10))) {
                d11 -= d10;
                double d12 = l11;
                d10 += (d11 /= d12);
                continue;
            }
            d10 = StatsAccumulator.calculateNewMeanNonFinite(d10, d11);
        }
        return d10;
    }

    public static double meanOf(double ... dArray) {
        int n10;
        int n11;
        int n12 = dArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        double d10 = dArray[0];
        for (n11 = 1; n11 < (n10 = dArray.length); ++n11) {
            double d11 = dArray[n11];
            int n13 = Doubles.isFinite(d11);
            if (n13 != 0 && (n13 = Doubles.isFinite(d10)) != 0) {
                d11 -= d10;
                n13 = n11 + 1;
                double d12 = n13;
                d10 += (d11 /= d12);
                continue;
            }
            d10 = StatsAccumulator.calculateNewMeanNonFinite(d10, d11);
        }
        return d10;
    }

    public static double meanOf(int ... nArray) {
        int n10;
        int n11;
        int n12 = nArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        n12 = nArray[0];
        double d10 = n12;
        for (n11 = 1; n11 < (n10 = nArray.length); ++n11) {
            n10 = nArray[n11];
            double d11 = n10;
            int n13 = Doubles.isFinite(d11);
            if (n13 != 0 && (n13 = Doubles.isFinite(d10)) != 0) {
                d11 -= d10;
                n13 = n11 + 1;
                double d12 = n13;
                d10 += (d11 /= d12);
                continue;
            }
            d10 = StatsAccumulator.calculateNewMeanNonFinite(d10, d11);
        }
        return d10;
    }

    public static double meanOf(long ... lArray) {
        int n10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        long l10 = lArray[0];
        double d10 = l10;
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l11 = lArray[n11];
            double d11 = l11;
            int n13 = Doubles.isFinite(d11);
            if (n13 != 0 && (n13 = Doubles.isFinite(d10)) != 0) {
                d11 -= d10;
                n13 = n11 + 1;
                double d12 = n13;
                d10 += (d11 /= d12);
                continue;
            }
            d10 = StatsAccumulator.calculateNewMeanNonFinite(d10, d11);
        }
        return d10;
    }

    public static Stats of(Iterable iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public static Stats of(Iterator iterator2) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterator2);
        return statsAccumulator.snapshot();
    }

    public static Stats of(double ... dArray) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(dArray);
        return statsAccumulator.snapshot();
    }

    public static Stats of(int ... nArray) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(nArray);
        return statsAccumulator.snapshot();
    }

    public static Stats of(long ... lArray) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(lArray);
        return statsAccumulator.snapshot();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        Stats stats;
        Preconditions.checkNotNull(byteBuffer);
        int n10 = byteBuffer.remaining();
        int n11 = 40;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            stats = null;
        }
        int n12 = byteBuffer.remaining();
        Preconditions.checkArgument(n10 != 0, "Expected at least Stats.BYTES = %s remaining , got %s", n11, n12);
        long l10 = byteBuffer.getLong();
        double d10 = byteBuffer.getDouble();
        double d11 = byteBuffer.getDouble();
        double d12 = byteBuffer.getDouble();
        double d13 = byteBuffer.getDouble();
        stats = new Stats(l10, d10, d11, d12, d13);
        return stats;
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object object) {
        long l10;
        long l11;
        long l12;
        long l13;
        double d10;
        double d11;
        long l14;
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        Class<Stats> clazz = Stats.class;
        Class<?> clazz2 = object.getClass();
        if (clazz != clazz2) {
            return false;
        }
        object = (Stats)object;
        long l15 = this.count;
        long l16 = ((Stats)object).count;
        long l17 = l15 - l16;
        Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object2 == false && (object2 = (l14 = (l15 = Double.doubleToLongBits(d11 = this.mean)) - (l16 = Double.doubleToLongBits(d10 = ((Stats)object).mean))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false && (object2 = (l13 = (l15 = Double.doubleToLongBits(d11 = this.sumOfSquaresOfDeltas)) - (l16 = Double.doubleToLongBits(d10 = ((Stats)object).sumOfSquaresOfDeltas))) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false && (object2 = (l12 = (l15 = Double.doubleToLongBits(d11 = this.min)) - (l16 = Double.doubleToLongBits(d10 = ((Stats)object).min))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false && (l11 = (l10 = (l15 = Double.doubleToLongBits(d11 = this.max)) - (l16 = Double.doubleToLongBits(d10 = ((Stats)object).max))) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        Object[] objectArray = new Object[5];
        Number number = this.count;
        objectArray[0] = number;
        number = this.mean;
        objectArray[1] = number;
        number = this.sumOfSquaresOfDeltas;
        objectArray[2] = number;
        number = this.min;
        objectArray[3] = number;
        number = this.max;
        objectArray[4] = number;
        return Objects.hashCode(objectArray);
    }

    public double max() {
        long l10 = this.count;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        return this.max;
    }

    public double mean() {
        long l10 = this.count;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        return this.mean;
    }

    public double min() {
        long l10 = this.count;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }

    public double populationVariance() {
        long l10 = this.count;
        long l11 = 0L;
        double d10 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        double d11 = this.sumOfSquaresOfDeltas;
        object = Double.isNaN(d11);
        if (object != false) {
            return 0.0 / 0.0;
        }
        l10 = this.count;
        l11 = 1L;
        d10 = Double.MIN_VALUE;
        object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            return 0.0;
        }
        d11 = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        d10 = this.count();
        return d11 / d10;
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(this.sampleVariance());
    }

    public double sampleVariance() {
        long l10 = this.count;
        long l11 = 1L;
        double d10 = Double.MIN_VALUE;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        double d11 = this.sumOfSquaresOfDeltas;
        object = Double.isNaN(d11);
        if (object != false) {
            return 0.0 / 0.0;
        }
        d11 = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        d10 = this.count - l11;
        return d11 / d10;
    }

    public double sum() {
        double d10 = this.mean;
        double d11 = this.count;
        return d10 * d11;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(40);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer = byteBuffer.order(byteOrder);
        this.writeTo(byteBuffer);
        return byteBuffer.array();
    }

    public String toString() {
        long l10 = this.count();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = "count";
        if (l12 > 0) {
            MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
            l11 = this.count;
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add(string2, l11);
            double d10 = this.mean;
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("mean", d10);
            d10 = this.populationStandardDeviation();
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("populationStandardDeviation", d10);
            d10 = this.min;
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("min", d10);
            d10 = this.max;
            return moreObjects$ToStringHelper.add("max", d10).toString();
        }
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        l11 = this.count;
        return moreObjects$ToStringHelper.add(string2, l11).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        int n10 = byteBuffer.remaining();
        int n11 = 40;
        n10 = n10 >= n11 ? 1 : 0;
        int n12 = byteBuffer.remaining();
        Preconditions.checkArgument(n10 != 0, "Expected at least Stats.BYTES = %s remaining , got %s", n11, n12);
        long l10 = this.count;
        byteBuffer = byteBuffer.putLong(l10);
        double d10 = this.mean;
        byteBuffer = byteBuffer.putDouble(d10);
        d10 = this.sumOfSquaresOfDeltas;
        byteBuffer = byteBuffer.putDouble(d10);
        d10 = this.min;
        byteBuffer = byteBuffer.putDouble(d10);
        d10 = this.max;
        byteBuffer.putDouble(d10);
    }
}

