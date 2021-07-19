/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import cn.sharesdk.framework.Service;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeListener;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService$1;
import cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService$a;
import cn.sharesdk.framework.utils.QRCodeUtil.j;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class QRCodeService
extends Service {
    private static QRCodeListener a;
    private j b = null;
    private QRCodeService$a c;

    public static /* synthetic */ QRCodeListener a() {
        return a;
    }

    public static /* synthetic */ j a(QRCodeService qRCodeService) {
        return qRCodeService.b;
    }

    public static /* synthetic */ QRCodeService$a b(QRCodeService qRCodeService) {
        return qRCodeService.c;
    }

    private void b() {
        Object object = this.b;
        if (object == null) {
            this.b = object = new j();
        }
        if ((object = this.c) == null) {
            j j10 = this.b;
            object = new QRCodeService$a(j10);
            this.c = object;
        }
    }

    public Bitmap generate() {
        this.b();
        return this.b.b();
    }

    public void generateAsync() {
        this.b();
        Object object = a;
        if (object == null) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d("listener can not be null when you generate bitmap in Async method", objectArray);
            return;
        }
        QRCodeService$1 qRCodeService$1 = new QRCodeService$1(this);
        object = new Thread(qRCodeService$1);
        ((Thread)object).start();
    }

    public void generateAsync(QRCodeListener qRCodeListener) {
        a = qRCodeListener;
        this.generateAsync();
    }

    public int getServiceVersionInt() {
        return 1;
    }

    public String getServiceVersionName() {
        return "QRCodeService";
    }

    public void onBind() {
        this.b();
    }

    public void setBackground(int n10) {
        this.b();
        this.b.a(n10);
    }

    public void setBackgroundBitmap(Bitmap bitmap) {
        this.b();
        this.b.a(bitmap, false);
    }

    public void setBackgroundBitmap(Bitmap bitmap, boolean bl2) {
        this.b();
        this.b.a(bitmap, bl2);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.b();
        this.b.a(drawable2, false);
    }

    public void setBackgroundDrawable(Drawable drawable2, boolean bl2) {
        this.b();
        this.b.a(drawable2, bl2);
    }

    public void setBackgroundPath(String string2) {
        this.b();
        this.b.a(string2, false);
    }

    public void setBackgroundPath(String string2, boolean bl2) {
        this.b();
        this.b.a(string2, bl2);
    }

    public void setBackgroundUrl(String string2) {
        this.b();
        this.b.b(string2, false);
    }

    public void setBackgroundUrl(String string2, boolean bl2) {
        this.b();
        this.b.b(string2, bl2);
    }

    public void setCodeColor(int n10) {
        this.b();
        this.b.c(n10);
    }

    public void setContent(String string2) {
        this.b();
        this.b.b(string2);
    }

    public void setListener(QRCodeListener qRCodeListener) {
        a = qRCodeListener;
    }

    public void setLogo(int n10) {
        this.b();
        this.b.b(n10);
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.b();
        this.b.b(bitmap, false);
    }

    public void setLogoBitmap(Bitmap bitmap, boolean bl2) {
        this.b();
        this.b.b(bitmap, bl2);
    }

    public void setLogoDrawable(Drawable drawable2) {
        this.b();
        this.b.b(drawable2, false);
    }

    public void setLogoDrawable(Drawable drawable2, boolean bl2) {
        this.b();
        this.b.b(drawable2, bl2);
    }

    public void setLogoPath(String string2) {
        this.b();
        this.b.c(string2, false);
    }

    public void setLogoPath(String string2, boolean bl2) {
        this.b();
        this.b.c(string2, bl2);
    }

    public void setLogoUrl(String string2) {
        this.b();
        this.b.d(string2, false);
    }

    public void setLogoUrl(String string2, boolean bl2) {
        this.b();
        this.b.b(string2, bl2);
    }

    public void setPoints(int n10, int n11, int n12, int n13) {
        this.b();
        this.b.a(n10, n11, n12, n13);
    }

    public void setSize(int n10, int n11) {
        this.b();
        this.b.a(n10, n11);
    }

    public void setUrl(String string2) {
        this.b();
        this.b.a(string2);
    }
}

