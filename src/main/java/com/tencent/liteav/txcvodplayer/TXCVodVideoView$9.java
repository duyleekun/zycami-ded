/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Message
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Bundle;
import android.os.Message;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$9
implements IMediaPlayer$OnVideoSizeChangedListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$9(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onVideoSizeChanged(IMediaPlayer object, int n10, int n11, int n12, int n13) {
        Bundle bundle;
        Object object2;
        Object object3 = this.a;
        n12 = TXCVodVideoView.b(object3);
        n13 = 16;
        if (n12 != n11 && (n11 = Math.abs(n12 = TXCVodVideoView.b(object3 = this.a) - n11)) > n13 || (n11 = TXCVodVideoView.c(object2 = this.a)) != n10 && (n10 = Math.abs(n11 = TXCVodVideoView.c(object2 = this.a) - n10)) > n13) {
            n10 = 1;
        } else {
            n10 = 0;
            bundle = null;
        }
        object2 = this.a;
        n12 = object.getVideoWidth();
        TXCVodVideoView.a(object2, n12);
        object2 = this.a;
        n12 = object.getVideoHeight();
        TXCVodVideoView.b(object2, n12);
        object2 = this.a;
        n12 = object.getVideoSarNum();
        TXCVodVideoView.c(object2, n12);
        object2 = this.a;
        int n14 = object.getVideoSarDen();
        TXCVodVideoView.d(object2, n14);
        object = this.a;
        n14 = TXCVodVideoView.c((TXCVodVideoView)((Object)object));
        if (n14 != 0 && (n14 = TXCVodVideoView.b((TXCVodVideoView)((Object)(object = this.a)))) != 0) {
            object = TXCVodVideoView.a(this.a);
            if (object != null) {
                object = TXCVodVideoView.a(this.a);
                n11 = TXCVodVideoView.c(this.a);
                n12 = TXCVodVideoView.b(this.a);
                object.setVideoSize(n11, n12);
                object = TXCVodVideoView.a(this.a);
                object2 = this.a;
                n11 = TXCVodVideoView.d(object2);
                object3 = this.a;
                n12 = TXCVodVideoView.e(object3);
                object.setVideoSampleAspectRatio(n11, n12);
            }
            object = this.a;
            object.requestLayout();
        }
        if (n10 != 0) {
            object = new Message();
            ((Message)object).what = 101;
            ((Message)object).arg1 = n10 = 2009;
            bundle = new Bundle();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Resolution change:");
            n12 = TXCVodVideoView.c(this.a);
            ((StringBuilder)object2).append(n12);
            ((StringBuilder)object2).append("*");
            n12 = TXCVodVideoView.b(this.a);
            ((StringBuilder)object2).append(n12);
            object2 = ((StringBuilder)object2).toString();
            bundle.putString("description", (String)object2);
            n11 = TXCVodVideoView.c(this.a);
            bundle.putInt("EVT_PARAM1", n11);
            object2 = this.a;
            n11 = TXCVodVideoView.b(object2);
            object3 = "EVT_PARAM2";
            bundle.putInt((String)object3, n11);
            object.setData(bundle);
            bundle = TXCVodVideoView.f(this.a);
            if (bundle != null) {
                bundle = TXCVodVideoView.f(this.a);
                bundle.sendMessage((Message)object);
            }
        }
    }
}

