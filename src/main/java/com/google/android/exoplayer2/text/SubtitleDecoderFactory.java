/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory$1;

public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT;

    static {
        SubtitleDecoderFactory$1 subtitleDecoderFactory$1 = new SubtitleDecoderFactory$1();
        DEFAULT = subtitleDecoderFactory$1;
    }

    public SubtitleDecoder createDecoder(Format var1);

    public boolean supportsFormat(Format var1);
}

