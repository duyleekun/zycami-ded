/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService;
import cn.sharesdk.framework.utils.QRCodeUtil.j;
import java.lang.ref.WeakReference;

public class QRCodeService$a
extends Handler {
    private final WeakReference a;

    public QRCodeService$a(j j10) {
        Object object = Looper.getMainLooper();
        super(object);
        super(j10);
        this.a = object;
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == n11) {
            object = ((j)this.a.get()).a();
            if (object == null) {
                object = new Exception("bitmap gernerate error!!!");
                QRCodeService.a().onError((Throwable)object);
                return;
            }
            QRCodeListener qRCodeListener = QRCodeService.a();
            qRCodeListener.onSuccess((Bitmap)object);
        }
    }
}

