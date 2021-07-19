/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioAttributes$1;
import com.google.android.exoplayer2.audio.AudioAttributes$Builder;
import com.google.android.exoplayer2.util.Util;

public final class AudioAttributes {
    public static final AudioAttributes DEFAULT;
    public final int allowedCapturePolicy;
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    static {
        AudioAttributes$Builder audioAttributes$Builder = new AudioAttributes$Builder();
        DEFAULT = audioAttributes$Builder.build();
    }

    private AudioAttributes(int n10, int n11, int n12, int n13) {
        this.contentType = n10;
        this.flags = n11;
        this.usage = n12;
        this.allowedCapturePolicy = n13;
    }

    public /* synthetic */ AudioAttributes(int n10, int n11, int n12, int n13, AudioAttributes$1 audioAttributes$1) {
        this(n10, n11, n12, n13);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<AudioAttributes> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = AudioAttributes.class) == (clazz = object.getClass())) {
            int n10;
            object = (AudioAttributes)object;
            int n11 = this.contentType;
            int n12 = ((AudioAttributes)object).contentType;
            if (n11 != n12 || (n11 = this.flags) != (n12 = ((AudioAttributes)object).flags) || (n11 = this.usage) != (n12 = ((AudioAttributes)object).usage) || (n11 = this.allowedCapturePolicy) != (n10 = ((AudioAttributes)object).allowedCapturePolicy)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public android.media.AudioAttributes getAudioAttributesV21() {
        android.media.AudioAttributes audioAttributes = this.audioAttributesV21;
        if (audioAttributes == null) {
            audioAttributes = new AudioAttributes.Builder();
            int n10 = this.contentType;
            audioAttributes = audioAttributes.setContentType(n10);
            n10 = this.flags;
            audioAttributes = audioAttributes.setFlags(n10);
            n10 = this.usage;
            audioAttributes = audioAttributes.setUsage(n10);
            n10 = Util.SDK_INT;
            int n11 = 29;
            if (n10 >= n11) {
                n10 = this.allowedCapturePolicy;
                audioAttributes.setAllowedCapturePolicy(n10);
            }
            this.audioAttributesV21 = audioAttributes = audioAttributes.build();
        }
        return this.audioAttributesV21;
    }

    public int hashCode() {
        int n10 = this.contentType;
        int n11 = (527 + n10) * 31;
        n10 = this.flags;
        n11 = (n11 + n10) * 31;
        n10 = this.usage;
        n11 = (n11 + n10) * 31;
        n10 = this.allowedCapturePolicy;
        return n11 + n10;
    }
}

