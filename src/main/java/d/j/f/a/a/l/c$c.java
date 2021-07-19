/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.webkit.SslErrorHandler
 */
package d.j.f.a.a.l;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;

public class c$c
implements DialogInterface.OnClickListener {
    private final SslErrorHandler a;

    public c$c(SslErrorHandler sslErrorHandler) {
        this.a = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        this.a.proceed();
    }
}

