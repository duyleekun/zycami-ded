/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.h0.g;

import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.common.base.Function;

public final class d
implements Function {
    public final /* synthetic */ FragmentedMp4Extractor a;

    public /* synthetic */ d(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.a = fragmentedMp4Extractor;
    }

    public final Object apply(Object object) {
        FragmentedMp4Extractor fragmentedMp4Extractor = this.a;
        object = (Track)object;
        return fragmentedMp4Extractor.modifyTrack((Track)object);
    }
}

