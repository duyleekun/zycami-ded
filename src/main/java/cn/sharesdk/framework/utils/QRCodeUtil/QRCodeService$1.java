/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService;
import cn.sharesdk.framework.utils.QRCodeUtil.j;

public class QRCodeService$1
implements Runnable {
    public final /* synthetic */ QRCodeService a;

    public QRCodeService$1(QRCodeService qRCodeService) {
        this.a = qRCodeService;
    }

    public void run() {
        Object object = this.a;
        object = QRCodeService.a((QRCodeService)object);
        ((j)object).b();
        object = this.a;
        object = QRCodeService.b((QRCodeService)object);
        int n10 = 1;
        try {
            object.sendEmptyMessage(n10);
        }
        catch (Throwable throwable) {
            QRCodeListener qRCodeListener = QRCodeService.a();
            qRCodeListener.onError(throwable);
        }
    }
}

