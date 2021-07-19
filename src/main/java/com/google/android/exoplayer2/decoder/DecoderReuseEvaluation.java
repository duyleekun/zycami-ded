/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;

public final class DecoderReuseEvaluation {
    public static final int DISCARD_REASON_APP_OVERRIDE = 4;
    public static final int DISCARD_REASON_AUDIO_CHANNEL_COUNT_CHANGED = 4096;
    public static final int DISCARD_REASON_AUDIO_ENCODING_CHANGED = 16384;
    public static final int DISCARD_REASON_AUDIO_SAMPLE_RATE_CHANGED = 8192;
    public static final int DISCARD_REASON_DRM_SESSION_CHANGED = 128;
    public static final int DISCARD_REASON_INITIALIZATION_DATA_CHANGED = 32;
    public static final int DISCARD_REASON_MAX_INPUT_SIZE_EXCEEDED = 64;
    public static final int DISCARD_REASON_MIME_TYPE_CHANGED = 8;
    public static final int DISCARD_REASON_OPERATING_RATE_CHANGED = 16;
    public static final int DISCARD_REASON_REUSE_NOT_IMPLEMENTED = 1;
    public static final int DISCARD_REASON_VIDEO_COLOR_INFO_CHANGED = 2048;
    public static final int DISCARD_REASON_VIDEO_MAX_RESOLUTION_EXCEEDED = 256;
    public static final int DISCARD_REASON_VIDEO_RESOLUTION_CHANGED = 512;
    public static final int DISCARD_REASON_VIDEO_ROTATION_CHANGED = 1024;
    public static final int DISCARD_REASON_WORKAROUND = 2;
    public static final int REUSE_RESULT_NO = 0;
    public static final int REUSE_RESULT_YES_WITHOUT_RECONFIGURATION = 3;
    public static final int REUSE_RESULT_YES_WITH_FLUSH = 1;
    public static final int REUSE_RESULT_YES_WITH_RECONFIGURATION = 2;
    public final String decoderName;
    public final int discardReasons;
    public final Format newFormat;
    public final Format oldFormat;
    public final int result;

    public DecoderReuseEvaluation(String object, Format format, Format format2, int n10, int n11) {
        boolean bl2 = n10 == 0 || n11 == 0;
        Assertions.checkArgument(bl2);
        object = Assertions.checkNotEmpty((String)object);
        this.decoderName = object;
        this.oldFormat = object = (Format)Assertions.checkNotNull(format);
        this.newFormat = object = (Format)Assertions.checkNotNull(format2);
        this.result = n10;
        this.discardReasons = n11;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = DecoderReuseEvaluation.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (DecoderReuseEvaluation)object;
            int n10 = this.result;
            int n11 = ((DecoderReuseEvaluation)object).result;
            if (n10 != n11 || (n10 = this.discardReasons) != (n11 = ((DecoderReuseEvaluation)object).discardReasons) || (n10 = (int)(((String)(object3 = this.decoderName)).equals(object2 = ((DecoderReuseEvaluation)object).decoderName) ? 1 : 0)) == 0 || (n10 = (int)(((Format)(object3 = this.oldFormat)).equals(object2 = ((DecoderReuseEvaluation)object).oldFormat) ? 1 : 0)) == 0 || !(bl3 = ((Format)(object3 = this.newFormat)).equals(object = ((DecoderReuseEvaluation)object).newFormat))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.result;
        int n11 = (527 + n10) * 31;
        n10 = this.discardReasons;
        n11 = (n11 + n10) * 31;
        n10 = this.decoderName.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.oldFormat.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.newFormat.hashCode();
        return n11 + n10;
    }
}

