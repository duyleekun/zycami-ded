/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.text.SimpleSubtitleOutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.n0.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder
extends SimpleDecoder
implements SubtitleDecoder {
    private final String name;

    public SimpleSubtitleDecoder(String string2) {
        int n10 = 2;
        DecoderInputBuffer[] decoderInputBufferArray = new SubtitleInputBuffer[n10];
        OutputBuffer[] outputBufferArray = new SubtitleOutputBuffer[n10];
        super(decoderInputBufferArray, outputBufferArray);
        this.name = string2;
        this.setInitialInputBufferSize(1024);
    }

    public static /* synthetic */ void a(SimpleSubtitleDecoder simpleSubtitleDecoder, OutputBuffer outputBuffer) {
        simpleSubtitleDecoder.releaseOutputBuffer(outputBuffer);
    }

    public final SubtitleInputBuffer createInputBuffer() {
        SubtitleInputBuffer subtitleInputBuffer = new SubtitleInputBuffer();
        return subtitleInputBuffer;
    }

    public final SubtitleOutputBuffer createOutputBuffer() {
        a a10 = new a(this);
        SimpleSubtitleOutputBuffer simpleSubtitleOutputBuffer = new SimpleSubtitleOutputBuffer(a10);
        return simpleSubtitleOutputBuffer;
    }

    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable throwable) {
        SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", throwable);
        return subtitleDecoderException;
    }

    public abstract Subtitle decode(byte[] var1, int var2, boolean var3);

    public final SubtitleDecoderException decode(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean bl2) {
        Object object;
        try {
            object = subtitleInputBuffer.data;
        }
        catch (SubtitleDecoderException subtitleDecoderException) {
            return subtitleDecoderException;
        }
        object = Assertions.checkNotNull(object);
        object = (ByteBuffer)object;
        byte[] byArray = ((ByteBuffer)object).array();
        int n10 = ((Buffer)object).limit();
        Subtitle subtitle = this.decode(byArray, n10, bl2);
        long l10 = subtitleInputBuffer.timeUs;
        long l11 = subtitleInputBuffer.subsampleOffsetUs;
        subtitleOutputBuffer.setContent(l10, subtitle, l11);
        int n11 = -1 << -1;
        subtitleOutputBuffer.clearFlag(n11);
        return null;
    }

    public final String getName() {
        return this.name;
    }

    public void setPositionUs(long l10) {
    }
}

