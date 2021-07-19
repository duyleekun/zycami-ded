/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.n0.b;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;
import com.google.android.exoplayer2.text.cea.CeaDecoder$CeaOutputBuffer;

public final class b
implements OutputBuffer$Owner {
    public final /* synthetic */ CeaDecoder a;

    public /* synthetic */ b(CeaDecoder ceaDecoder) {
        this.a = ceaDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        CeaDecoder ceaDecoder = this.a;
        outputBuffer = (CeaDecoder$CeaOutputBuffer)outputBuffer;
        ceaDecoder.releaseOutputBuffer((SubtitleOutputBuffer)outputBuffer);
    }
}

