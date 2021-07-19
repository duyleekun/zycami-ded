/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.tencent.rtmp.ui;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.rtmp.ui.TXCloudVideoView$1;

public class TXCloudVideoView$a
implements Runnable {
    public final /* synthetic */ TXCloudVideoView a;
    private View b;
    private MotionEvent c;

    private TXCloudVideoView$a(TXCloudVideoView tXCloudVideoView) {
        this.a = tXCloudVideoView;
    }

    public /* synthetic */ TXCloudVideoView$a(TXCloudVideoView tXCloudVideoView, TXCloudVideoView$1 tXCloudVideoView$1) {
        this(tXCloudVideoView);
    }

    public void a(MotionEvent motionEvent) {
        this.c = motionEvent;
    }

    public void a(View view) {
        this.b = view;
    }

    public void run() {
        MotionEvent motionEvent;
        float f10;
        int n10;
        float f11;
        MotionEvent motionEvent2;
        boolean bl2;
        Object object = TXCloudVideoView.access$400(this.a);
        if (object != null && (bl2 = TXCloudVideoView.access$700((TXCloudVideoView)((Object)(object = this.a))))) {
            object = TXCloudVideoView.access$400(this.a);
            motionEvent2 = this.c;
            f11 = motionEvent2.getX();
            n10 = this.b.getWidth();
            f10 = n10;
            f11 /= f10;
            motionEvent = this.c;
            f10 = motionEvent.getY();
            View view = this.b;
            int n11 = view.getHeight();
            float f12 = n11;
            object.a(f11, f10 /= f12);
        }
        if (bl2 = TXCloudVideoView.access$700((TXCloudVideoView)((Object)(object = this.a)))) {
            object = this.a;
            motionEvent2 = this.c;
            f11 = motionEvent2.getX();
            int n12 = (int)f11;
            motionEvent = this.c;
            f10 = motionEvent.getY();
            n10 = (int)f10;
            ((TXCloudVideoView)((Object)object)).onTouchFocus(n12, n10);
        }
    }
}

