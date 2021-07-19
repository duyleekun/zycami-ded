/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.d;
import java.lang.ref.WeakReference;

public class TXCVodVideoView$a
extends Handler {
    private final WeakReference a;
    private final int b;

    public TXCVodVideoView$a(TXCVodVideoView tXCVodVideoView, Looper object) {
        super(object);
        this.b = 500;
        super(tXCVodVideoView);
        this.a = object;
    }

    public void handleMessage(Message object) {
        Object object2;
        Object object3 = (TXCVodVideoView)((Object)this.a.get());
        if (object3 != null && (object2 = TXCVodVideoView.y(object3)) != null) {
            int n10 = ((Message)object).what;
            switch (n10) {
                default: {
                    break;
                }
                case 103: {
                    int n11 = object3.getCurrentPosition();
                    long l10 = n11;
                    object = new Bundle();
                    int n12 = object3.getBufferDuration();
                    long l11 = n12;
                    int n13 = object3.getDuration();
                    long l12 = n13;
                    long l13 = 1000L;
                    int n14 = (int)(l10 / l13);
                    object.putInt("EVT_PLAY_PROGRESS", n14);
                    long l14 = l12 / l13;
                    n14 = (int)l14;
                    String string2 = "EVT_PLAY_DURATION";
                    object.putInt(string2, n14);
                    l13 = l11 / l13;
                    int n15 = (int)l13;
                    String string3 = "EVT_PLAYABLE_DURATION";
                    object.putInt(string3, n15);
                    n10 = (int)l10;
                    object.putInt("EVT_PLAY_PROGRESS_MS", n10);
                    n10 = (int)l12;
                    object.putInt("EVT_PLAY_DURATION_MS", n10);
                    n10 = (int)l11;
                    String string4 = "EVT_PLAYABLE_DURATION_MS";
                    object.putInt(string4, n10);
                    object2 = TXCVodVideoView.y(object3);
                    int n16 = 2005;
                    float f10 = 2.81E-42f;
                    object2.a(n16, (Bundle)object);
                    object = TXCVodVideoView.w(object3);
                    if (object == null) break;
                    n11 = 103;
                    this.removeMessages(n11);
                    object2 = TXCVodVideoView.s(object3);
                    n10 = ((d)object2).l;
                    if (n10 <= 0) {
                        object2 = TXCVodVideoView.s(object3);
                        n16 = 500;
                        f10 = 7.0E-43f;
                        ((d)object2).l = n16;
                    }
                    object3 = TXCVodVideoView.s(object3);
                    int n17 = ((d)object3).l;
                    long l15 = n17;
                    this.sendEmptyMessageDelayed(n11, l15);
                    break;
                }
                case 102: {
                    TXCVodVideoView.t(object3);
                    int n18 = 2103;
                    object2 = "VOD network reconnected";
                    String string5 = "reconnect";
                    TXCVodVideoView.a(object3, n18, (String)object2, string5);
                    break;
                }
                case 101: {
                    n10 = ((Message)object).arg1;
                    object3 = TXCVodVideoView.y(object3);
                    object = object.getData();
                    object3.a(n10, (Bundle)object);
                    break;
                }
                case 100: {
                    object = object3.getUnwrappedMediaPlayer();
                    if (object == null) {
                        return;
                    }
                    object = (IjkMediaPlayer)object;
                    float f11 = ((IjkMediaPlayer)object).getVideoOutputFramesPerSecond();
                    float f12 = ((IjkMediaPlayer)object).getVideoDecodeFramesPerSecond();
                    long l16 = ((IjkMediaPlayer)object).getVideoCachedBytes();
                    long l17 = ((IjkMediaPlayer)object).getAudioCachedBytes();
                    l16 += l17;
                    l17 = ((IjkMediaPlayer)object).getBitRate();
                    long l18 = ((IjkMediaPlayer)object).getTcpSpeed();
                    object = new Bundle();
                    String string6 = "fps";
                    object.putFloat(string6, f11);
                    object.putFloat("dps", f12);
                    object.putLong("cachedBytes", l16);
                    object.putLong("bitRate", l17);
                    object2 = "tcpSpeed";
                    object.putLong((String)object2, l18);
                    object3 = TXCVodVideoView.y(object3);
                    object3.a((Bundle)object);
                    int n19 = 100;
                    this.removeMessages(n19);
                    long l19 = 500L;
                    this.sendEmptyMessageDelayed(n19, l19);
                }
            }
        }
    }
}

