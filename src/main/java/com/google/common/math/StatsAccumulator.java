/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

public final class StatsAccumulator {
    private long count = 0L;
    private double max;
    private double mean;
    private double min;
    private double sumOfSquaresOfDeltas;

    public StatsAccumulator() {
        double d10;
        this.mean = d10 = 0.0;
        this.sumOfSquaresOfDeltas = d10;
        this.min = d10 = 0.0 / 0.0;
        this.max = d10;
    }

    public static double calculateNewMeanNonFinite(double d10, double d11) {
        double d12;
        boolean bl2 = Doubles.isFinite(d10);
        if (bl2) {
            return d11;
        }
        bl2 = Doubles.isFinite(d11);
        if (!bl2 && (d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1)) != false) {
            d10 = 0.0 / 0.0;
        }
        return d10;
    }

    private void merge(long l10, double d10, double d11, double d12, double d13) {
        StatsAccumulator statsAccumulator = this;
        double d14 = d10;
        double d15 = d12;
        double d16 = d13;
        long l11 = this.count;
        long l12 = 0L;
        double d17 = 0.0;
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object == false) {
            this.count = l10;
            this.mean = d10;
            this.sumOfSquaresOfDeltas = d11;
            this.min = d12;
            this.max = d13;
        } else {
            double d18;
            this.count = l11 += l10;
            double d19 = this.mean;
            boolean bl2 = Doubles.isFinite(d19);
            if (bl2 && (bl2 = Doubles.isFinite(d10))) {
                d19 = this.mean;
                d17 = d10 - d19;
                d18 = l10;
                double d20 = d17 * d18;
                long l13 = this.count;
                d16 = l13;
                this.mean = d19 += (d20 /= d16);
                d16 = this.sumOfSquaresOfDeltas;
                d14 = d10 - d19;
                d17 = d17 * d14 * d18;
                d18 = d11 + d17;
                this.sumOfSquaresOfDeltas = d16 += d18;
            } else {
                statsAccumulator.mean = d18 = StatsAccumulator.calculateNewMeanNonFinite(statsAccumulator.mean, d14);
                statsAccumulator.sumOfSquaresOfDeltas = d18 = 0.0 / 0.0;
            }
            statsAccumulator.min = d18 = Math.min(statsAccumulator.min, d15);
            d18 = statsAccumulator.max;
            d14 = d13;
            statsAccumulator.max = d18 = Math.max(d18, d13);
        }
    }

    public void add(double d10) {
        long l10 = this.count;
        long l11 = 0L;
        double d11 = 0.0;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        double d12 = 0.0 / 0.0;
        long l13 = 1L;
        if (l12 == false) {
            this.count = l13;
            this.mean = d10;
            this.min = d10;
            this.max = d10;
            boolean bl2 = Doubles.isFinite(d10);
            if (!bl2) {
                this.sumOfSquaresOfDeltas = d12;
            }
        } else {
            double d13;
            this.count = l10 += l13;
            boolean bl3 = Doubles.isFinite(d10);
            if (bl3 && (bl3 = Doubles.isFinite(d13 = this.mean))) {
                d13 = this.mean;
                d11 = d10 - d13;
                long l14 = this.count;
                double d14 = l14;
                d14 = d11 / d14;
                this.mean = d13 += d14;
                d14 = this.sumOfSquaresOfDeltas;
                d13 = d10 - d13;
                this.sumOfSquaresOfDeltas = d14 += (d11 *= d13);
            } else {
                this.mean = d13 = StatsAccumulator.calculateNewMeanNonFinite(this.mean, d10);
                this.sumOfSquaresOfDeltas = d12;
            }
            this.min = d13 = Math.min(this.min, d10);
            d13 = this.max;
            this.max = d10 = Math.max(d13, d10);
        }
    }

    public void addAll(Stats stats) {
        long l10;
        long l11 = stats.count();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        l10 = stats.count();
        double d10 = stats.mean();
        double d11 = stats.sumOfSquaresOfDeltas();
        double d12 = stats.min();
        double d13 = stats.max();
        this.merge(l10, d10, d11, d12, d13);
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        long l10;
        long l11 = statsAccumulator.count();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        l10 = statsAccumulator.count();
        double d10 = statsAccumulator.mean();
        double d11 = statsAccumulator.sumOfSquaresOfDeltas();
        double d12 = statsAccumulator.min();
        double d13 = statsAccumulator.max();
        this.merge(l10, d10, d11, d12, d13);
    }

    public void addAll(Iterable object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Number number = (Number)object.next();
            double d10 = number.doubleValue();
            this.add(d10);
        }
    }

    public void addAll(Iterator iterator2) {
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Number number = (Number)iterator2.next();
            double d10 = number.doubleValue();
            this.add(d10);
        }
    }

    public void addAll(double ... dArray) {
        for (double d10 : dArray) {
            this.add(d10);
        }
    }

    public void addAll(int ... nArray) {
        for (int n10 : nArray) {
            double d10 = n10;
            this.add(d10);
        }
    }

    public void addAll(long ... lArray) {
        for (long l10 : lArray) {
            double d10 = l10;
            this.add(d10);
        }
    }

    public long count() {
        return this.count;
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

    public final double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }

    public final double populationVariance() {
        long l10 = this.count;
        long l11 = 0L;
        double d10 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
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
        d10 = this.count;
        return d11 / d10;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(this.sampleVariance());
    }

    public final double sampleVariance() {
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

    public Stats snapshot() {
        long l10 = this.count;
        double d10 = this.mean;
        double d11 = this.sumOfSquaresOfDeltas;
        double d12 = this.min;
        double d13 = this.max;
        Stats stats = new Stats(l10, d10, d11, d12, d13);
        return stats;
    }

    public final double sum() {
        double d10 = this.mean;
        double d11 = this.count;
        return d10 * d11;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }
}

