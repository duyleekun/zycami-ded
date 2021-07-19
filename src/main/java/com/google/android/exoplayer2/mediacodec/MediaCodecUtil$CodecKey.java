/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.mediacodec;

import android.text.TextUtils;

public final class MediaCodecUtil$CodecKey {
    public final String mimeType;
    public final boolean secure;
    public final boolean tunneling;

    public MediaCodecUtil$CodecKey(String string2, boolean bl2, boolean bl3) {
        this.mimeType = string2;
        this.secure = bl2;
        this.tunneling = bl3;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = object.getClass()) == (object2 = MediaCodecUtil$CodecKey.class)) {
            boolean bl3;
            boolean bl4;
            object = (MediaCodecUtil$CodecKey)object;
            object3 = this.mimeType;
            object2 = ((MediaCodecUtil$CodecKey)object).mimeType;
            boolean bl5 = TextUtils.equals((CharSequence)object3, (CharSequence)object2);
            if (!bl5 || (bl5 = this.secure) != (bl4 = ((MediaCodecUtil$CodecKey)object).secure) || (bl5 = this.tunneling) != (bl3 = ((MediaCodecUtil$CodecKey)object).tunneling)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        String string2 = this.mimeType;
        int n10 = string2.hashCode();
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        int n12 = this.secure;
        int n13 = 1231;
        int n14 = 1237;
        float f10 = 1.733E-42f;
        n12 = n12 != 0 ? n13 : n14;
        n10 = (n10 + n12) * n11;
        n11 = (int)(this.tunneling ? 1 : 0);
        if (n11 == 0) {
            n13 = n14;
        }
        return n10 + n13;
    }
}

