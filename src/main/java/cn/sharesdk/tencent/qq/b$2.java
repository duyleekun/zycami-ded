/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.SslErrorHandler
 */
package cn.sharesdk.tencent.qq;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
import cn.sharesdk.tencent.qq.b;

public class b$2
implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler a;
    public final /* synthetic */ b b;

    public b$2(b b10, SslErrorHandler sslErrorHandler) {
        this.b = b10;
        this.a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        dialogInterface.dismiss();
        this.a.cancel();
    }
}

