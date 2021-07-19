/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.b.a;

import com.quvideo.mobile.external.component.cloudengine.core.OooO00o;
import com.quvideo.mobile.external.component.cloudengine.model.VideoConfig;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnVideoListener;
import d.o.a.a.a.b.a.h;

public final class c
implements h {
    public final /* synthetic */ OooO00o a;
    public final /* synthetic */ VideoConfig b;
    public final /* synthetic */ OnVideoListener c;

    public /* synthetic */ c(OooO00o oooO00o, VideoConfig videoConfig, OnVideoListener onVideoListener) {
        this.a = oooO00o;
        this.b = videoConfig;
        this.c = onVideoListener;
    }

    public final void OooO00o() {
        OooO00o oooO00o = this.a;
        VideoConfig videoConfig = this.b;
        OnVideoListener onVideoListener = this.c;
        OooO00o.c(oooO00o, videoConfig, onVideoListener);
    }
}

