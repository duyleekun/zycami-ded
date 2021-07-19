/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.tencent.qzone.QZone;
import java.util.HashMap;

public class QZone$3
implements PlatformActionListener {
    public final /* synthetic */ Platform$ShareParams a;
    public final /* synthetic */ QZone b;

    public QZone$3(QZone qZone, Platform$ShareParams platform$ShareParams) {
        this.b = qZone;
        this.a = platform$ShareParams;
    }

    public void onCancel(Platform object, int n10) {
        object = QZone.p(this.b);
        if (object != null) {
            object = QZone.q(this.b);
            QZone qZone = this.b;
            int n11 = 9;
            object.onCancel(qZone, n11);
        }
    }

    public void onComplete(Platform object, int n10, HashMap hashMap) {
        object = QZone.n(this.b);
        if (object != null) {
            object = this.a;
            hashMap.put("ShareParams", object);
            object = QZone.o(this.b);
            QZone qZone = this.b;
            int n11 = 9;
            object.onComplete(qZone, n11, hashMap);
        }
    }

    public void onError(Platform object, int n10, Throwable throwable) {
        object = QZone.l(this.b);
        if (object != null) {
            object = QZone.m(this.b);
            QZone qZone = this.b;
            int n11 = 9;
            object.onError(qZone, n11, throwable);
        }
    }
}

