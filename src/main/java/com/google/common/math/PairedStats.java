/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$LinearTransformationBuilder;
import com.google.common.math.Stats;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class PairedStats
implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d10) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d10;
    }

    private static double ensureInUnitRange(double d10) {
        double d11 = 1.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object >= 0) {
            return d11;
        }
        d11 = -1.0;
        double d13 = d10 - d11;
        object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object <= 0) {
            return d11;
        }
        return d10;
    }

    private static double ensurePositive(double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] object) {
        Object object2;
        Preconditions.checkNotNull(object);
        int n10 = ((byte[])object).length;
        int n11 = 88;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        int n12 = ((byte[])object).length;
        Preconditions.checkArgument(n10 != 0, "Expected PairedStats.BYTES = %s, got %s", n11, n12);
        object = ByteBuffer.wrap((byte[])object);
        object2 = ByteOrder.LITTLE_ENDIAN;
        object = ((ByteBuffer)object).order((ByteOrder)object2);
        object2 = Stats.readFrom((ByteBuffer)object);
        Stats stats = Stats.readFrom((ByteBuffer)object);
        double d10 = ((ByteBuffer)object).getDouble();
        object = new PairedStats((Stats)object2, stats, d10);
        return object;
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object object) {
        double d10;
        long l10;
        double d11;
        long l11;
        long l12;
        long l13;
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        Object object2 = PairedStats.class;
        Serializable serializable = object.getClass();
        if (object2 != serializable) {
            return false;
        }
        object = (PairedStats)object;
        object2 = this.xStats;
        serializable = ((PairedStats)object).xStats;
        boolean bl3 = ((Stats)object2).equals(serializable);
        if (bl3 && (bl3 = ((Stats)(object2 = this.yStats)).equals(serializable = ((PairedStats)object).yStats)) && (l13 = (l12 = (l11 = Double.doubleToLongBits(d11 = this.sumOfProductsOfDeltas)) - (l10 = Double.doubleToLongBits(d10 = ((PairedStats)object).sumOfProductsOfDeltas))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Serializable serializable = this.xStats;
        objectArray[0] = serializable;
        serializable = this.yStats;
        objectArray[1] = serializable;
        serializable = Double.valueOf(this.sumOfProductsOfDeltas);
        objectArray[2] = serializable;
        return Objects.hashCode(objectArray);
    }

    public LinearTransformation leastSquaresFit() {
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
        d11 = ((Stats)object).sumOfSquaresOfDeltas();
        double d12 = d11 - (d10 = 0.0);
        l12 = (long)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
        if (l12 > 0) {
            object = this.yStats;
            double d13 = ((Stats)object).sumOfSquaresOfDeltas();
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
        d11 = ((Stats)object).sumOfSquaresOfDeltas();
        double d16 = d11 - d10;
        l12 = (long)(d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1));
        if (l12 <= 0) {
            bl2 = false;
        }
        Preconditions.checkState(bl2);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        Stats stats;
        long l10 = this.count();
        long l11 = 1L;
        double d10 = Double.MIN_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            stats = null;
        }
        Preconditions.checkState((boolean)l12);
        double d11 = this.sumOfProductsOfDeltas;
        l12 = (long)Double.isNaN(d11);
        if (l12 != false) {
            return 0.0 / 0.0;
        }
        d11 = this.xStats().sumOfSquaresOfDeltas();
        stats = this.yStats();
        double d12 = stats.sumOfSquaresOfDeltas();
        double d13 = 0.0;
        double d14 = d11 - d13;
        l12 = (long)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
        if (l12 > 0) {
            l12 = (long)bl2;
        } else {
            l12 = 0;
            stats = null;
        }
        Preconditions.checkState((boolean)l12);
        l12 = (long)(d12 == d13 ? 0 : (d12 > d13 ? 1 : -1));
        if (l12 <= 0) {
            bl2 = false;
        }
        Preconditions.checkState(bl2);
        double d15 = PairedStats.ensurePositive(d11 * d12);
        d10 = this.sumOfProductsOfDeltas;
        d15 = Math.sqrt(d15);
        return PairedStats.ensureInUnitRange(d10 / d15);
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

    public double sampleCovariance() {
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

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(88);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer = byteBuffer.order(byteOrder);
        this.xStats.writeTo(byteBuffer);
        this.yStats.writeTo(byteBuffer);
        double d10 = this.sumOfProductsOfDeltas;
        byteBuffer.putDouble(d10);
        return byteBuffer.array();
    }

    public String toString() {
        long l10 = this.count();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = "yStats";
        Object object = "xStats";
        if (l12 > 0) {
            MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
            Stats stats = this.xStats;
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add((String)object, stats);
            object = this.yStats;
            moreObjects$ToStringHelper = moreObjects$ToStringHelper.add(string2, object);
            double d10 = this.populationCovariance();
            return moreObjects$ToStringHelper.add("populationCovariance", d10).toString();
        }
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        Stats stats = this.xStats;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add((String)object, stats);
        object = this.yStats;
        return moreObjects$ToStringHelper.add(string2, object).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}

