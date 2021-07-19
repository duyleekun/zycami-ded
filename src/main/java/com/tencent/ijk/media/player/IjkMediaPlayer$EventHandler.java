/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.ijk.media.player;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ijk.media.player.AbstractMediaPlayer;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.ijk.media.player.IjkTimedText;
import com.tencent.ijk.media.player.pragma.DebugLog;
import java.lang.ref.WeakReference;

public class IjkMediaPlayer$EventHandler
extends Handler {
    private final WeakReference mWeakPlayer;

    public IjkMediaPlayer$EventHandler(IjkMediaPlayer ijkMediaPlayer, Looper object) {
        super(object);
        super(ijkMediaPlayer);
        this.mWeakPlayer = object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void handleMessage(Message object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = (IjkMediaPlayer)this.mWeakPlayer.get();
        if (object2 != null && (l13 = (l12 = (l11 = IjkMediaPlayer.access$100((IjkMediaPlayer)object2)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            long l14;
            l13 = object.what;
            if (l13 == false) return;
            int n10 = 1;
            if (l13 == n10) {
                ((AbstractMediaPlayer)object2).notifyOnPrepared();
                return;
            }
            int n11 = 2;
            if (l13 == n11) {
                IjkMediaPlayer.access$300((IjkMediaPlayer)object2, false);
                ((AbstractMediaPlayer)object2).notifyOnCompletion();
                return;
            }
            n11 = 3;
            if (l13 != n11) {
                int n12 = 4;
                if (l13 == n12) {
                    ((AbstractMediaPlayer)object2).notifyOnSeekComplete();
                    return;
                }
                n12 = 5;
                if (l13 == n12) {
                    l13 = object.arg1;
                    IjkMediaPlayer.access$402((IjkMediaPlayer)object2, (int)l13);
                    int n13 = object.arg2;
                    IjkMediaPlayer.access$502((IjkMediaPlayer)object2, n13);
                    int n14 = IjkMediaPlayer.access$400((IjkMediaPlayer)object2);
                    l13 = IjkMediaPlayer.access$500((IjkMediaPlayer)object2);
                    n10 = IjkMediaPlayer.access$600((IjkMediaPlayer)object2);
                    n12 = IjkMediaPlayer.access$700((IjkMediaPlayer)object2);
                    ((AbstractMediaPlayer)object2).notifyOnVideoSizeChanged(n14, (int)l13, n10, n12);
                    return;
                }
                n12 = 99;
                if (l13 != n12) {
                    n10 = 100;
                    if (l13 != n10) {
                        n10 = 200;
                        if (l13 != n10) {
                            n10 = 10001;
                            if (l13 == n10) {
                                l13 = object.arg1;
                                IjkMediaPlayer.access$602((IjkMediaPlayer)object2, (int)l13);
                                int n15 = object.arg2;
                                IjkMediaPlayer.access$702((IjkMediaPlayer)object2, n15);
                                int n16 = IjkMediaPlayer.access$400((IjkMediaPlayer)object2);
                                l13 = IjkMediaPlayer.access$500((IjkMediaPlayer)object2);
                                n10 = IjkMediaPlayer.access$600((IjkMediaPlayer)object2);
                                n12 = IjkMediaPlayer.access$700((IjkMediaPlayer)object2);
                                ((AbstractMediaPlayer)object2).notifyOnVideoSizeChanged(n16, (int)l13, n10, n12);
                                return;
                            }
                            switch (l13) {
                                default: {
                                    object2 = IjkMediaPlayer.access$200();
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String string2 = "Unknown message type ";
                                    stringBuilder.append(string2);
                                    int n17 = object.what;
                                    stringBuilder.append(n17);
                                    String string3 = stringBuilder.toString();
                                    DebugLog.e((String)object2, string3);
                                    return;
                                }
                                case 212: {
                                    ((AbstractMediaPlayer)object2).notifyVideoDecoderError();
                                    return;
                                }
                                case 211: {
                                    ((AbstractMediaPlayer)object2).notifyHevcVideoDecoderError();
                                    return;
                                }
                                case 210: 
                            }
                            ((AbstractMediaPlayer)object2).notifyHLSKeyError();
                            return;
                        }
                        l13 = object.arg1;
                        if (l13 == n11) {
                            String string4 = IjkMediaPlayer.access$200();
                            String string5 = "Info: MEDIA_INFO_VIDEO_RENDERING_START\n";
                            DebugLog.i(string4, string5);
                        }
                        l13 = object.arg1;
                        int n18 = object.arg2;
                        ((AbstractMediaPlayer)object2).notifyOnInfo((int)l13, n18);
                        return;
                    }
                    String string6 = IjkMediaPlayer.access$200();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error (");
                    n12 = object.arg1;
                    stringBuilder.append(n12);
                    stringBuilder.append(",");
                    n12 = object.arg2;
                    stringBuilder.append(n12);
                    String string7 = ")";
                    stringBuilder.append(string7);
                    String string8 = stringBuilder.toString();
                    DebugLog.e(string6, string8);
                    l13 = object.arg1;
                    int n19 = object.arg2;
                    boolean bl2 = ((AbstractMediaPlayer)object2).notifyOnError((int)l13, n19);
                    if (!bl2) {
                        ((AbstractMediaPlayer)object2).notifyOnCompletion();
                    }
                    IjkMediaPlayer.access$300((IjkMediaPlayer)object2, false);
                    return;
                }
                Object object3 = object.obj;
                if (object3 == null) {
                    boolean bl3 = false;
                    Object var1_3 = null;
                    ((AbstractMediaPlayer)object2).notifyOnTimedText(null);
                    return;
                }
                Rect rect = new Rect(0, 0, n10, n10);
                String string9 = (String)object.obj;
                object3 = new IjkTimedText(rect, string9);
                ((AbstractMediaPlayer)object2).notifyOnTimedText((IjkTimedText)object3);
                return;
            }
            l11 = object.arg1;
            long l15 = l11 - l10;
            Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object4 < 0) {
                l11 = l10;
            }
            long l16 = ((IjkMediaPlayer)object2).getDuration();
            long l17 = l16 == l10 ? 0 : (l16 < l10 ? -1 : 1);
            long l18 = 100;
            if (l17 > 0) {
                l10 = (l11 *= l18) / l16;
            }
            if ((l14 = l10 == l18 ? 0 : (l10 < l18 ? -1 : 1)) < 0) {
                l18 = l10;
            }
            int n20 = (int)l18;
            ((AbstractMediaPlayer)object2).notifyOnBufferingUpdate(n20);
            return;
        }
        DebugLog.w(IjkMediaPlayer.access$200(), "IjkMediaPlayer went away with unhandled events");
    }
}

