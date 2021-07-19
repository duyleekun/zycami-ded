/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsLiveWindow$InternalVideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameInfo;

public class NvsLiveWindow$1
implements NvsLiveWindow$InternalVideoFrameCallback {
    public final /* synthetic */ NvsLiveWindow this$0;

    public NvsLiveWindow$1(NvsLiveWindow nvsLiveWindow) {
        this.this$0 = nvsLiveWindow;
    }

    public void onVideoFrameRendered(NvsLiveWindow$VideoFrameInfo nvsLiveWindow$VideoFrameInfo) {
        NvsLiveWindow$VideoFrameCallback nvsLiveWindow$VideoFrameCallback = NvsLiveWindow.access$000(this.this$0);
        if (nvsLiveWindow$VideoFrameCallback != null) {
            nvsLiveWindow$VideoFrameCallback.onVideoFrameRendered(nvsLiveWindow$VideoFrameInfo);
        }
    }
}

