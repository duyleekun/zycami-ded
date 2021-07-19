/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.drm;

import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.Map;

public final class WidevineUtil {
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    private WidevineUtil() {
    }

    private static long getDurationRemainingSec(Map object, String string2) {
        block5: {
            if (object != null) {
                try {
                    object = object.get(string2);
                }
                catch (NumberFormatException numberFormatException) {}
                object = (String)object;
                if (object == null) break block5;
                return Long.parseLong((String)object);
            }
        }
        return -9223372036854775807L;
    }

    public static Pair getLicenseDurationRemainingSec(DrmSession object) {
        if ((object = object.queryKeyStatus()) == null) {
            return null;
        }
        Long l10 = WidevineUtil.getDurationRemainingSec((Map)object, PROPERTY_LICENSE_DURATION_REMAINING);
        object = WidevineUtil.getDurationRemainingSec((Map)object, PROPERTY_PLAYBACK_DURATION_REMAINING);
        Pair pair = new Pair((Object)l10, object);
        return pair;
    }
}

