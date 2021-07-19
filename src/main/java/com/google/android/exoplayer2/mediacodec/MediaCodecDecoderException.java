/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CodecException
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.util.Util;

public class MediaCodecDecoderException
extends DecoderException {
    public final MediaCodecInfo codecInfo;
    public final String diagnosticInfo;

    public MediaCodecDecoderException(Throwable throwable, MediaCodecInfo mediaCodecInfo) {
        String string2;
        int n10;
        String string3 = null;
        if (mediaCodecInfo == null) {
            n10 = 0;
            string2 = null;
        } else {
            string2 = mediaCodecInfo.name;
        }
        string2 = String.valueOf(string2);
        int n11 = string2.length();
        String string4 = "Decoder failed: ";
        string2 = n11 != 0 ? string4.concat(string2) : new String(string4);
        super(string2, throwable);
        this.codecInfo = mediaCodecInfo;
        int n12 = Util.SDK_INT;
        n10 = 21;
        if (n12 >= n10) {
            string3 = MediaCodecDecoderException.getDiagnosticInfoV21(throwable);
        }
        this.diagnosticInfo = string3;
    }

    private static String getDiagnosticInfoV21(Throwable throwable) {
        boolean bl2 = throwable instanceof MediaCodec.CodecException;
        if (bl2) {
            return ((MediaCodec.CodecException)throwable).getDiagnosticInfo();
        }
        return null;
    }
}

