/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;

public abstract class Player$DefaultEventListener
implements Player$EventListener {
    public void onTimelineChanged(Timeline timeline, int n10) {
        Object object;
        int n11;
        int n12 = timeline.getWindowCount();
        if (n12 == (n11 = 1)) {
            object = new Timeline$Window();
            n11 = 0;
            object = timeline.getWindow((int)0, (Timeline$Window)object).manifest;
        } else {
            n12 = 0;
            object = null;
        }
        this.onTimelineChanged(timeline, object, n10);
    }

    public void onTimelineChanged(Timeline timeline, Object object, int n10) {
    }
}

