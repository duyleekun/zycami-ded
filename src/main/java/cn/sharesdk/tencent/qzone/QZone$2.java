/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.tencent.qzone.QZone;
import java.util.HashMap;

public class QZone$2
implements PlatformActionListener {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ Platform$ShareParams b;
    public final /* synthetic */ QZone c;

    public QZone$2(QZone qZone, PlatformActionListener platformActionListener, Platform$ShareParams platform$ShareParams) {
        this.c = qZone;
        this.a = platformActionListener;
        this.b = platform$ShareParams;
    }

    public void onCancel(Platform platform, int n10) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            int n11 = 9;
            platformActionListener.onCancel(platform, n11);
        }
    }

    public void onComplete(Platform platform, int n10, HashMap hashMap) {
        platform = this.c;
        Object object = this.a;
        platform.setPlatformActionListener((PlatformActionListener)object);
        platform = this.c;
        object = this.b;
        ((QZone)platform).doShare((Platform$ShareParams)object);
    }

    public void onError(Platform platform, int n10, Throwable throwable) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            int n11 = 9;
            platformActionListener.onError(platform, n11, throwable);
        }
    }
}

