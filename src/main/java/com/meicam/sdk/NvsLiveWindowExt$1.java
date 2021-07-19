/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsLiveWindow$InternalVideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameInfo;
import com.meicam.sdk.NvsLiveWindowExt;
import java.util.ArrayList;

public class NvsLiveWindowExt$1
implements NvsLiveWindow$InternalVideoFrameCallback {
    public final /* synthetic */ NvsLiveWindowExt this$0;

    public NvsLiveWindowExt$1(NvsLiveWindowExt nvsLiveWindowExt) {
        this.this$0 = nvsLiveWindowExt;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onVideoFrameRendered(NvsLiveWindow$VideoFrameInfo nvsLiveWindow$VideoFrameInfo) {
        Object object = NvsLiveWindowExt.access$000(this.this$0);
        synchronized (object) {
            Object object2;
            long l10 = nvsLiveWindow$VideoFrameInfo.frameId;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 < 0) {
                object2 = this.this$0;
                object2 = NvsLiveWindowExt.access$100((NvsLiveWindowExt)((Object)object2));
                ((ArrayList)object2).clear();
            }
            object2 = this.this$0;
            object2 = NvsLiveWindowExt.access$100((NvsLiveWindowExt)((Object)object2));
            ((ArrayList)object2).add(nvsLiveWindow$VideoFrameInfo);
            return;
        }
    }
}

