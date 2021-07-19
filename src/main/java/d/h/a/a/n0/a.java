/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.n0;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;

public final class a
implements OutputBuffer$Owner {
    public final /* synthetic */ SimpleSubtitleDecoder a;

    public /* synthetic */ a(SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.a = simpleSubtitleDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        SimpleSubtitleDecoder simpleSubtitleDecoder = this.a;
        outputBuffer = (SubtitleOutputBuffer)outputBuffer;
        SimpleSubtitleDecoder.a(simpleSubtitleDecoder, outputBuffer);
    }
}

