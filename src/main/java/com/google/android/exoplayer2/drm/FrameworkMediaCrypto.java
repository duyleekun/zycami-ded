/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class FrameworkMediaCrypto
implements ExoMediaCrypto {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC;
    public final boolean forceAllowInsecureDecoderComponents;
    public final byte[] sessionId;
    public final UUID uuid;

    static {
        boolean bl2;
        String string2 = "Amazon";
        String string3 = Util.MANUFACTURER;
        boolean bl3 = string2.equals(string3);
        if (bl3 && ((bl2 = (string2 = "AFTM").equals(string3 = Util.MODEL)) || (bl3 = (string2 = "AFTB").equals(string3)))) {
            bl3 = true;
        } else {
            bl3 = false;
            string3 = null;
        }
        WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = bl3;
    }

    public FrameworkMediaCrypto(UUID uUID, byte[] byArray, boolean bl2) {
        this.uuid = uUID;
        this.sessionId = byArray;
        this.forceAllowInsecureDecoderComponents = bl2;
    }
}

