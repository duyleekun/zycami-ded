/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CodecException
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.util.Util;

public class MediaCodecRenderer$DecoderInitializationException
extends Exception {
    private static final int CUSTOM_ERROR_CODE_BASE = 16727216;
    private static final int DECODER_QUERY_ERROR = 16727218;
    private static final int NO_SUITABLE_DECODER_ERROR = 16727217;
    public final MediaCodecInfo codecInfo;
    public final String diagnosticInfo;
    public final MediaCodecRenderer$DecoderInitializationException fallbackDecoderInitializationException;
    public final String mimeType;
    public final boolean secureDecoderRequired;

    public MediaCodecRenderer$DecoderInitializationException(Format format, Throwable throwable, boolean bl2, int n10) {
        String string2 = String.valueOf(format);
        int n11 = String.valueOf(string2).length() + 36;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("Decoder init failed: [");
        stringBuilder.append(n10);
        stringBuilder.append("], ");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        String string4 = format.sampleMimeType;
        String string5 = MediaCodecRenderer$DecoderInitializationException.buildCustomDiagnosticInfo(n10);
        this(string3, throwable, string4, bl2, null, string5, null);
    }

    public MediaCodecRenderer$DecoderInitializationException(Format format, Throwable throwable, boolean bl2, MediaCodecInfo mediaCodecInfo) {
        Object object = mediaCodecInfo.name;
        String string2 = String.valueOf(format);
        int n10 = String.valueOf(object).length() + 23;
        int n11 = String.valueOf(string2).length();
        CharSequence charSequence = new StringBuilder(n10 += n11);
        Object object2 = "Decoder init failed: ";
        charSequence.append((String)object2);
        charSequence.append((String)object);
        object = ", ";
        charSequence.append((String)object);
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = format.sampleMimeType;
        int n12 = Util.SDK_INT;
        n10 = 21;
        if (n12 >= n10) {
            object = MediaCodecRenderer$DecoderInitializationException.getDiagnosticInfoV21(throwable);
        } else {
            n12 = 0;
            object = null;
        }
        String string3 = object;
        object = this;
        object2 = throwable;
        this(string2, throwable, (String)charSequence, bl2, mediaCodecInfo, string3, null);
    }

    private MediaCodecRenderer$DecoderInitializationException(String string2, Throwable throwable, String string3, boolean bl2, MediaCodecInfo mediaCodecInfo, String string4, MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException) {
        super(string2, throwable);
        this.mimeType = string3;
        this.secureDecoderRequired = bl2;
        this.codecInfo = mediaCodecInfo;
        this.diagnosticInfo = string4;
        this.fallbackDecoderInitializationException = mediaCodecRenderer$DecoderInitializationException;
    }

    public static /* synthetic */ MediaCodecRenderer$DecoderInitializationException access$000(MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException, MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException2) {
        return mediaCodecRenderer$DecoderInitializationException.copyWithFallbackException(mediaCodecRenderer$DecoderInitializationException2);
    }

    private static String buildCustomDiagnosticInfo(int n10) {
        String string2 = n10 < 0 ? "neg_" : "";
        n10 = Math.abs(n10);
        int n11 = string2.length() + 71;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private MediaCodecRenderer$DecoderInitializationException copyWithFallbackException(MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException) {
        String string2 = this.getMessage();
        Throwable throwable = this.getCause();
        String string3 = this.mimeType;
        boolean bl2 = this.secureDecoderRequired;
        MediaCodecInfo mediaCodecInfo = this.codecInfo;
        String string4 = this.diagnosticInfo;
        MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException2 = new MediaCodecRenderer$DecoderInitializationException(string2, throwable, string3, bl2, mediaCodecInfo, string4, mediaCodecRenderer$DecoderInitializationException);
        return mediaCodecRenderer$DecoderInitializationException2;
    }

    private static String getDiagnosticInfoV21(Throwable throwable) {
        boolean bl2 = throwable instanceof MediaCodec.CodecException;
        if (bl2) {
            return ((MediaCodec.CodecException)throwable).getDiagnosticInfo();
        }
        return null;
    }
}

