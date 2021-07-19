/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.SequenceableLoader;

public final class DefaultCompositeSequenceableLoaderFactory
implements CompositeSequenceableLoaderFactory {
    public SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader ... sequenceableLoaderArray) {
        CompositeSequenceableLoader compositeSequenceableLoader = new CompositeSequenceableLoader(sequenceableLoaderArray);
        return compositeSequenceableLoader;
    }
}

