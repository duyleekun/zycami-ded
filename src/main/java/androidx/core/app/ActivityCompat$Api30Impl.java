/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.LocusId
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.Activity;
import android.content.LocusId;
import android.os.Bundle;
import androidx.core.content.LocusIdCompat;

public class ActivityCompat$Api30Impl {
    private ActivityCompat$Api30Impl() {
    }

    public static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
        locusIdCompat = locusIdCompat == null ? null : locusIdCompat.toLocusId();
        activity.setLocusContext((LocusId)locusIdCompat, bundle);
    }
}

