/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader$1;

public final class DefaultEbmlReader$MasterElement {
    private final long elementEndPosition;
    private final int elementId;

    private DefaultEbmlReader$MasterElement(int n10, long l10) {
        this.elementId = n10;
        this.elementEndPosition = l10;
    }

    public /* synthetic */ DefaultEbmlReader$MasterElement(int n10, long l10, DefaultEbmlReader$1 defaultEbmlReader$1) {
        this(n10, l10);
    }

    public static /* synthetic */ long access$000(DefaultEbmlReader$MasterElement defaultEbmlReader$MasterElement) {
        return defaultEbmlReader$MasterElement.elementEndPosition;
    }

    public static /* synthetic */ int access$100(DefaultEbmlReader$MasterElement defaultEbmlReader$MasterElement) {
        return defaultEbmlReader$MasterElement.elementId;
    }
}

