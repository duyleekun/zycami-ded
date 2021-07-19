/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction$Builder;
import java.util.Collections;
import java.util.List;

public final class FocusMeteringAction {
    public static final long DEFAULT_AUTOCANCEL_DURATION = 5000L;
    public static final int DEFAULT_METERING_MODE = 7;
    public static final int FLAG_AE = 2;
    public static final int FLAG_AF = 1;
    public static final int FLAG_AWB = 4;
    private final long mAutoCancelDurationInMillis;
    private final List mMeteringPointsAe;
    private final List mMeteringPointsAf;
    private final List mMeteringPointsAwb;

    public FocusMeteringAction(FocusMeteringAction$Builder focusMeteringAction$Builder) {
        long l10;
        List list;
        this.mMeteringPointsAf = list = Collections.unmodifiableList(focusMeteringAction$Builder.mMeteringPointsAf);
        this.mMeteringPointsAe = list = Collections.unmodifiableList(focusMeteringAction$Builder.mMeteringPointsAe);
        this.mMeteringPointsAwb = list = Collections.unmodifiableList(focusMeteringAction$Builder.mMeteringPointsAwb);
        this.mAutoCancelDurationInMillis = l10 = focusMeteringAction$Builder.mAutoCancelDurationInMillis;
    }

    public long getAutoCancelDurationInMillis() {
        return this.mAutoCancelDurationInMillis;
    }

    public List getMeteringPointsAe() {
        return this.mMeteringPointsAe;
    }

    public List getMeteringPointsAf() {
        return this.mMeteringPointsAf;
    }

    public List getMeteringPointsAwb() {
        return this.mMeteringPointsAwb;
    }

    public boolean isAutoCancelEnabled() {
        long l10 = this.mAutoCancelDurationInMillis;
        long l11 = 0L;
        long l12 = l10 - l11;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        l13 = l13 > 0 ? (long)1 : (long)0;
        return (boolean)l13;
    }
}

