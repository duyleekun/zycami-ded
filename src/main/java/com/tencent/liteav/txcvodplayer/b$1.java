/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.ijk.media.player.MediaPlayerProxy;
import com.tencent.liteav.txcvodplayer.b;

public class b$1
extends Handler {
    public final /* synthetic */ b a;

    public b$1(b b10) {
        this.a = b10;
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = this.a;
            Object object2 = null;
            if ((object = b.a((b)object)) != null) {
                Object object3;
                object = b.a(this.a);
                n10 = object instanceof IjkMediaPlayer;
                if (n10 != 0) {
                    object = b.a(this.a);
                    object2 = object;
                    object2 = (IjkMediaPlayer)object;
                } else {
                    object = b.a(this.a);
                    n10 = object instanceof MediaPlayerProxy;
                    if (n10 != 0 && (object = ((MediaPlayerProxy)b.a(this.a)).getInternalMediaPlayer()) != null && (object3 = object instanceof IjkMediaPlayer) != 0) {
                        object2 = object;
                        object2 = (IjkMediaPlayer)object;
                    }
                }
                if (object2 != null) {
                    float f10;
                    float f11;
                    float f12 = ((IjkMediaPlayer)object2).getRate();
                    float f13 = Math.abs(((IjkMediaPlayer)object2).getAVDiff());
                    float f14 = f13 - (f11 = 0.5f);
                    object3 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                    if (object3 > 0 && (object3 = (Object)((f10 = f12 - (f13 = 1.0f)) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) > 0) {
                        double d10 = f12;
                        double d11 = (d10 - 1.0) / 2.0;
                        double d12 = 0.25;
                        d11 = Math.min(d11, d12);
                        f12 = (float)(d10 -= d11);
                        ((IjkMediaPlayer)object2).setRate(f12);
                        object2 = new StringBuilder();
                        String string2 = "downside rate ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(f12);
                        object = ((StringBuilder)object2).toString();
                        object2 = "RateHelper";
                        Log.w((String)object2, (String)object);
                        b.b(this.a).removeMessages(n11);
                        object = b.b(this.a);
                        long l10 = 3000L;
                        object.sendEmptyMessageDelayed(n11, l10);
                    } else {
                        b.b(this.a).removeMessages(n11);
                        object = b.b(this.a);
                        long l11 = 500L;
                        object.sendEmptyMessageDelayed(n11, l11);
                    }
                }
            }
        }
    }
}

