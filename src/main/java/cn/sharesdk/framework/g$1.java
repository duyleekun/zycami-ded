/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.SslErrorHandler
 */
package cn.sharesdk.framework;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
import cn.sharesdk.framework.g;

public class g$1
implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler a;
    public final /* synthetic */ g b;

    public g$1(g g10, SslErrorHandler sslErrorHandler) {
        this.b = g10;
        this.a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        dialogInterface.dismiss();
        this.a.cancel();
    }
}

