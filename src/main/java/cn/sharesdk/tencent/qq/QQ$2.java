/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qq;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.tencent.qq.QQ;
import java.util.HashMap;

public class QQ$2
implements PlatformActionListener {
    public final /* synthetic */ QQ a;

    public QQ$2(QQ qQ) {
        this.a = qQ;
    }

    public void onCancel(Platform object, int n10) {
        object = QQ.p(this.a);
        if (object != null) {
            object = QQ.q(this.a);
            QQ qQ = this.a;
            int n11 = 9;
            object.onCancel(qQ, n11);
        }
    }

    public void onComplete(Platform hashMap, int n10, HashMap object) {
        PlatformActionListener platformActionListener;
        hashMap = new HashMap();
        if (object != null) {
            hashMap.putAll(object);
        }
        if ((platformActionListener = QQ.n(this.a)) != null) {
            platformActionListener = QQ.o(this.a);
            object = this.a;
            int n11 = 9;
            platformActionListener.onComplete((Platform)object, n11, hashMap);
        }
    }

    public void onError(Platform object, int n10, Throwable throwable) {
        object = QQ.l(this.a);
        if (object != null) {
            object = QQ.m(this.a);
            QQ qQ = this.a;
            int n11 = 9;
            object.onError(qQ, n11, throwable);
        }
    }
}

