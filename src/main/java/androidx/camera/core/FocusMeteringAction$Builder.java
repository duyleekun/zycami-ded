/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FocusMeteringAction$Builder {
    public long mAutoCancelDurationInMillis;
    public final List mMeteringPointsAe;
    public final List mMeteringPointsAf;
    public final List mMeteringPointsAwb;

    public FocusMeteringAction$Builder(MeteringPoint meteringPoint) {
        this(meteringPoint, 7);
    }

    public FocusMeteringAction$Builder(MeteringPoint meteringPoint, int n10) {
        ArrayList arrayList;
        this.mMeteringPointsAf = arrayList = new ArrayList();
        this.mMeteringPointsAe = arrayList = new ArrayList();
        this.mMeteringPointsAwb = arrayList = new ArrayList();
        this.mAutoCancelDurationInMillis = 5000L;
        this.addPoint(meteringPoint, n10);
    }

    public FocusMeteringAction$Builder addPoint(MeteringPoint meteringPoint) {
        return this.addPoint(meteringPoint, 7);
    }

    public FocusMeteringAction$Builder addPoint(MeteringPoint meteringPoint, int n10) {
        String string2;
        int n11;
        int n12 = 0;
        List list = null;
        int n13 = 1;
        if (meteringPoint != null) {
            n11 = n13;
        } else {
            n11 = 0;
            string2 = null;
        }
        String string3 = "Point cannot be null.";
        Preconditions.checkArgument(n11 != 0, string3);
        if (n10 >= n13 && n10 <= (n11 = 7)) {
            n12 = n13;
        }
        CharSequence charSequence = new StringBuilder();
        string2 = "Invalid metering mode ";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Preconditions.checkArgument(n12 != 0, charSequence);
        n12 = n10 & 1;
        if (n12 != 0) {
            list = this.mMeteringPointsAf;
            list.add(meteringPoint);
        }
        if ((n12 = n10 & 2) != 0) {
            list = this.mMeteringPointsAe;
            list.add(meteringPoint);
        }
        if ((n10 &= 4) != 0) {
            List list2 = this.mMeteringPointsAwb;
            list2.add(meteringPoint);
        }
        return this;
    }

    public FocusMeteringAction build() {
        FocusMeteringAction focusMeteringAction = new FocusMeteringAction(this);
        return focusMeteringAction;
    }

    public FocusMeteringAction$Builder disableAutoCancel() {
        this.mAutoCancelDurationInMillis = 0L;
        return this;
    }

    public FocusMeteringAction$Builder setAutoCancelDuration(long l10, TimeUnit timeUnit) {
        long l11 = 1L;
        long l12 = l10 - l11;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        l13 = l13 >= 0 ? (long)1 : (long)0;
        Preconditions.checkArgument((boolean)l13, "autoCancelDuration must be at least 1");
        this.mAutoCancelDurationInMillis = l10 = timeUnit.toMillis(l10);
        return this;
    }
}

