/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.SslErrorHandler
 */
package cn.sharesdk.tencent.qzone;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
import cn.sharesdk.tencent.qzone.a;

public class a$2
implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler a;
    public final /* synthetic */ a b;

    public a$2(a a10, SslErrorHandler sslErrorHandler) {
        this.b = a10;
        this.a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        dialogInterface.dismiss();
        this.a.cancel();
    }
}

