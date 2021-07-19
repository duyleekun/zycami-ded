/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$LinearTransformationBuilder;
import com.google.common.math.PairedStats;
import com.google.common.math.Stats;
import com.google.common.math.StatsAccumulator;
import com.google.common.primitives.Doubles;

public final class PairedStatsAccumulator {
    private double sumOfProductsOfDeltas;
    private final StatsAccumulator xStats;
    private final StatsAccumulator yStats;

    public PairedStatsAccumulator() {
        StatsAccumulator statsAccumulator;
        this.xStats = statsAccumulator = new StatsAccumulator();
        this.yStats = statsAccumulator = new StatsAccumulator();
        this.sumOfProductsOfDeltas = 0.0;
    }

    private static double ensureInUnitRange(double d10) {
        return Doubles.constrainToRange(d10, -1.0, 1.0);
    }

    private double ensurePositive(double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d10, double d11) {
        StatsAccumulator statsAccumulator = this.xStats;
        statsAccumulator.add(d10);
        Object object = Doubles.isFinite(d10);
        if (object != 0 && (object = Doubles.isFinite(d11)) != 0) {
            statsAccumulator = this.xStats;
            long l10 = statsAccumulator.count();
            long l11 = 1L;
            double d12 = Double.MIN_VALUE;
            object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object > 0) {
                double d13 = this.sumOfProductsOfDeltas;
                d12 = this.xStats.mean();
                d10 -= d12;
                StatsAccumulator statsAccumulator2 = this.yStats;
                d12 = statsAccumulator2.mean();
                d12 = d11 - d12;
                this.sumOfProductsOfDeltas = d13 += (d10 *= d12);
            }
        } else {
            this.sumOfProductsOfDeltas = d10 = 0.0 / 0.0;
        }
        this.yStats.add(d11);
    }

    public void addAll(PairedStats serializable) {
        long l10 = ((PairedStats)serializable).count();
        long l11 = 0L;
        double d10 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            return;
        }
        StatsAccumulator statsAccumulator = this.xStats;
        Stats stats = ((PairedStats)serializable).xStats();
        statsAccumulator.addAll(stats);
        statsAccumulator = this.yStats;
        l10 = statsAccumulator.count();
        object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            double d11;
            this.sumOfProductsOfDeltas = d11 = ((PairedStats)serializable).sumOfProductsOfDeltas();
        } else {
            double d12 = this.sumOfProductsOfDeltas;
            d10 = ((PairedStats)serializable).sumOfProductsOfDeltas();
            Stats stats2 = ((PairedStats)serializable).xStats();
            double d13 = stats2.mean();
            double d14 = this.xStats.mean();
            d13 -= d14;
            Stats stats3 = ((PairedStats)serializable).yStats();
            d14 = stats3.mean();
            StatsAccumulator statsAccumulator2 = this.yStats;
            double d15 = statsAccumulator2.mean();
            d13 *= (d14 -= d15);
            long l12 = ((PairedStats)serializable).count();
            d14 = l12;
            this.sumOfProductsOfDeltas = d12 += (d10 += (d13 *= d14));
        }
        statsAccumulator = this.yStats;
        serializable = ((PairedStats)serializable).yStats();
        statsAccumulator.addAll((Stats)serializable);
    }

    public long count() {
        return this.xStats.count();
    }

    public final LinearTransformation leastSquaresFit() {
        double d10;
        Object object;
        long l10 = this.count();
        long l11 = 1L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            object = null;
        }
        Preconditions.checkState((boolean)l12);
        double d11 = this.sumOfProductsOfDeltas;
        l12 = (long)Double.isNaN(d11);
        if (l12 != false) {
            return LinearTransformation.forNaN();
        }
        object = this.xStats;
        d11 = ((StatsAccumulator)object).sumOfSquaresOfDeltas();
        double d12 = d11 - (d10 = 0.0);
        l12 = (long)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
        if (l12 > 0) {
            object = this.yStats;
            double d13 = ((StatsAccumulator)object).sumOfSquaresOfDeltas();
            double d14 = d13 - d10;
            l12 = (long)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
            if (l12 > 0) {
                d13 = this.xStats.mean();
                d10 = this.yStats.mean();
                object = LinearTransformation.mapping(d13, d10);
                double d15 = this.sumOfProductsOfDeltas / d11;
                return ((LinearTransformation$LinearTransformationBuilder)object).withSlope(d15);
            }
            return LinearTransformation.horizontal(this.yStats.mean());
        }
        object = this.yStats;
        d11 = ((StatsAccumulator)object).sumOfSquaresOfDeltas();
        double d16 = d11 - d10;
        l12 = (long)(d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1));
        if (l12 <= 0) {
            bl2 = false;
        }
        Preconditions.checkState(bl2);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        StatsAccumulator statsAccumulator;
        long l10 = this.count();
        long l11 = 1L;
        double d10 = Double.MIN_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            statsAccumulator = null;
        }
        Preconditions.checkState((boolean)l12);
        double d11 = this.sumOfProductsOfDeltas;
        l12 = (long)Double.isNaN(d11);
        if (l12 != false) {
            return 0.0 / 0.0;
        }
        d11 = this.xStats.sumOfSquaresOfDeltas();
        statsAccumulator = this.yStats;
        double d12 = statsAccumulator.sumOfSquaresOfDeltas();
        double d13 = 0.0;
        double d14 = d11 - d13;
        l12 = (long)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            statsAccumulator = null;
        }
        Preconditions.checkState((boolean)l12);
        l12 = (long)(d12 == d13 ? 0 : (d12 > d13 ? 1 : -1));
        if (l12 <= 0) {
            bl2 = false;
        }
        Preconditions.checkState(bl2);
        double d15 = this.ensurePositive(d11 *= d12);
        d10 = this.sumOfProductsOfDeltas;
        d15 = Math.sqrt(d15);
        return PairedStatsAccumulator.ensureInUnitRange(d10 / d15);
    }

    public double populationCovariance() {
        long l10 = this.count();
        long l11 = 0L;
        double d10 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        double d11 = this.sumOfProductsOfDeltas;
        d10 = this.count();
        return d11 / d10;
    }

    public final double sampleCovariance() {
        long l10 = this.count();
        long l11 = 1L;
        double d10 = Double.MIN_VALUE;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Preconditions.checkState((boolean)object);
        double d11 = this.sumOfProductsOfDeltas;
        d10 = this.count() - l11;
        return d11 / d10;
    }

    public PairedStats snapshot() {
        Stats stats = this.xStats.snapshot();
        Stats stats2 = this.yStats.snapshot();
        double d10 = this.sumOfProductsOfDeltas;
        PairedStats pairedStats = new PairedStats(stats, stats2, d10);
        return pairedStats;
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }
}

