/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.ijk.media.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ijk.media.player.IjkDownloadCenter;
import com.tencent.ijk.media.player.IjkDownloadCenter$NativeEvent;
import com.tencent.ijk.media.player.IjkDownloadMedia;
import java.lang.ref.WeakReference;

public class IjkDownloadCenter$EventHandler
extends Handler {
    private final WeakReference mWeakCenter;

    public IjkDownloadCenter$EventHandler(IjkDownloadCenter ijkDownloadCenter, Looper object) {
        super(object);
        super(ijkDownloadCenter);
        this.mWeakCenter = object;
    }

    public void handleMessage(Message object) {
        Object object2;
        IjkDownloadCenter ijkDownloadCenter = (IjkDownloadCenter)this.mWeakCenter.get();
        if (ijkDownloadCenter != null && (object2 = IjkDownloadCenter.access$000(ijkDownloadCenter)) != null) {
            object2 = (IjkDownloadCenter$NativeEvent)((Message)object).obj;
            IjkDownloadMedia ijkDownloadMedia = ((IjkDownloadCenter$NativeEvent)object2).media;
            if (ijkDownloadMedia == null) {
                return;
            }
            int n10 = ((Message)object).what;
            int n11 = 100;
            if (n10 != n11) {
                n11 = 300;
                if (n10 != n11) {
                    n11 = 500;
                    if (n10 != n11) {
                        int n12 = 600;
                        if (n10 != n12) {
                            n12 = 900;
                            if (n10 == n12) {
                                object = IjkDownloadCenter.access$000(ijkDownloadCenter);
                                object.downloadProgress(ijkDownloadCenter, ijkDownloadMedia);
                            }
                        } else {
                            object = IjkDownloadCenter.access$000(ijkDownloadCenter);
                            object.downloadFinish(ijkDownloadCenter, ijkDownloadMedia);
                        }
                    } else {
                        object = IjkDownloadCenter.access$000(ijkDownloadCenter);
                        n11 = ((IjkDownloadCenter$NativeEvent)object2).error;
                        object2 = ((IjkDownloadCenter$NativeEvent)object2).reason;
                        object.downloadError(ijkDownloadCenter, ijkDownloadMedia, n11, (String)object2);
                    }
                } else {
                    object = IjkDownloadCenter.access$000(ijkDownloadCenter);
                    object.downloadEnd(ijkDownloadCenter, ijkDownloadMedia);
                }
            } else {
                object = IjkDownloadCenter.access$000(ijkDownloadCenter);
                object.downloadBegin(ijkDownloadCenter, ijkDownloadMedia);
            }
        }
    }
}

