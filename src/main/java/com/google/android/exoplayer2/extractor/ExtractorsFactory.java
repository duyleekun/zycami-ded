/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import d.h.a.a.h0.a;
import java.util.Map;

public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = a.a;

    public static /* synthetic */ Extractor[] a() {
        return new Extractor[0];
    }

    public Extractor[] createExtractors();

    default public Extractor[] createExtractors(Uri uri, Map map) {
        return this.createExtractors();
    }
}

