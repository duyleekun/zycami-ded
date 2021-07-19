/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.ui;

import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.rtmp.ui.TXDashBoard;

public class TXCloudVideoView$1
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ TXCloudVideoView e;

    public TXCloudVideoView$1(TXCloudVideoView tXCloudVideoView, float f10, float f11, float f12, float f13) {
        this.e = tXCloudVideoView;
        this.a = f10;
        this.b = f11;
        this.c = f12;
        this.d = f13;
    }

    public void run() {
        TXCloudVideoView tXCloudVideoView = this.e;
        float f10 = tXCloudVideoView.getWidth();
        float f11 = this.a;
        TXCloudVideoView.access$002(tXCloudVideoView, f10 *= f11);
        tXCloudVideoView = this.e;
        f10 = tXCloudVideoView.getWidth();
        f11 = this.b;
        TXCloudVideoView.access$102(tXCloudVideoView, f10 *= f11);
        tXCloudVideoView = this.e;
        f10 = tXCloudVideoView.getHeight();
        f11 = this.c;
        TXCloudVideoView.access$202(tXCloudVideoView, f10 *= f11);
        tXCloudVideoView = this.e;
        int n10 = tXCloudVideoView.getHeight();
        f10 = n10;
        f11 = this.d;
        TXCloudVideoView.access$302(tXCloudVideoView, f10 *= f11);
        tXCloudVideoView = this.e;
        TXDashBoard tXDashBoard = tXCloudVideoView.mDashBoard;
        if (tXDashBoard != null) {
            float f12 = TXCloudVideoView.access$000(tXCloudVideoView);
            int n11 = (int)f12;
            TXCloudVideoView tXCloudVideoView2 = this.e;
            f11 = TXCloudVideoView.access$200(tXCloudVideoView2);
            int n12 = (int)f11;
            TXCloudVideoView tXCloudVideoView3 = this.e;
            float f13 = TXCloudVideoView.access$100(tXCloudVideoView3);
            int n13 = (int)f13;
            TXCloudVideoView tXCloudVideoView4 = this.e;
            float f14 = TXCloudVideoView.access$300(tXCloudVideoView4);
            int n14 = (int)f14;
            tXDashBoard.a(n11, n12, n13, n14);
        }
    }
}

