/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.a$b;

public class TXCVodVideoView$7
implements a$a {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$7(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void a(a$b object) {
        a a10;
        if ((object = object.a()) != (a10 = TXCVodVideoView.a(this.a))) {
            TXCLog.e(TXCVodVideoView.k(this.a), "onSurfaceDestroyed: unmatched render callback\n");
            return;
        }
        TXCLog.i(TXCVodVideoView.k(this.a), "onSurfaceDestroyed");
        object = this.a;
        a10 = null;
        TXCVodVideoView.a((TXCVodVideoView)((Object)object), null);
        object = TXCVodVideoView.w(this.a);
        if (object != null) {
            object = TXCVodVideoView.w(this.a);
            object.setSurface(null);
        }
        this.a.a();
    }

    public void a(a$b object, int n10, int n11) {
        Object object2;
        Object object3 = object.a();
        if (object3 != (object2 = TXCVodVideoView.a(this.a))) {
            TXCLog.e(TXCVodVideoView.k(this.a), "onSurfaceCreated: unmatched render callback\n");
            return;
        }
        object3 = TXCVodVideoView.k(this.a);
        object2 = "onSurfaceCreated";
        TXCLog.i((String)object3, (String)object2);
        TXCVodVideoView.a(this.a, object);
        object3 = TXCVodVideoView.w(this.a);
        if (object3 != null) {
            object3 = this.a;
            object2 = TXCVodVideoView.w((TXCVodVideoView)((Object)object3));
            TXCVodVideoView.a((TXCVodVideoView)((Object)object3), (IMediaPlayer)object2, object);
        } else {
            object = this.a;
            TXCVodVideoView.x((TXCVodVideoView)((Object)object));
        }
    }

    public void a(a$b object, int n10, int n11, int n12) {
        Object object2;
        Object object3;
        if ((object = object.a()) != (object3 = TXCVodVideoView.a(this.a))) {
            TXCLog.e(TXCVodVideoView.k(this.a), "onSurfaceChanged: unmatched render callback\n");
            return;
        }
        object = TXCVodVideoView.k(this.a);
        object3 = "onSurfaceChanged";
        TXCLog.i((String)object, (String)object3);
        TXCVodVideoView.l(this.a, n11);
        TXCVodVideoView.m(this.a, n12);
        object = this.a;
        int n13 = TXCVodVideoView.j((TXCVodVideoView)((Object)object));
        n10 = 1;
        int n14 = 3;
        if (n13 == n14) {
            n13 = n10;
        } else {
            n13 = 0;
            object = null;
        }
        Object object4 = TXCVodVideoView.a(this.a);
        int n15 = object4.shouldWaitForResize();
        if (n15 != 0 && ((n15 = TXCVodVideoView.c((TXCVodVideoView)((Object)(object4 = this.a)))) != n11 || (n11 = TXCVodVideoView.b((TXCVodVideoView)((Object)(object2 = this.a)))) != n12)) {
            n10 = 0;
            object3 = null;
        }
        if ((object2 = TXCVodVideoView.w(this.a)) != null && n13 != 0 && n10 != 0 && (n13 = TXCVodVideoView.j((TXCVodVideoView)((Object)(object = this.a)))) == n14) {
            object = this.a;
            ((TXCVodVideoView)((Object)object)).b();
        }
    }
}

