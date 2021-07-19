/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsMultiThumbnailSequenceView;

public class NvsMultiThumbnailSequenceView$2
implements Runnable {
    public final /* synthetic */ NvsMultiThumbnailSequenceView this$0;

    public NvsMultiThumbnailSequenceView$2(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView) {
        this.this$0 = nvsMultiThumbnailSequenceView;
    }

    public void run() {
        this.this$0.updateThumbnails();
    }
}

