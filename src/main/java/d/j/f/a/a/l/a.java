/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.webkit.WebView
 */
package d.j.f.a.a.l;

import android.util.Log;
import android.webkit.WebView;
import d.j.f.a.a.k.n;
import d.j.f.a.a.k.o;
import d.j.f.a.a.l.a$a;
import java.util.concurrent.CountDownLatch;

public class a {
    private static final String c = "SafeGetUrl";
    private static final long d = 200L;
    private String a;
    private WebView b;

    public a() {
    }

    public a(WebView webView) {
        this.b = webView;
    }

    public static /* synthetic */ WebView a(a a10) {
        return a10.b;
    }

    public String b() {
        Object object = this.b;
        if (object == null) {
            return "";
        }
        boolean bl2 = n.a();
        if (bl2) {
            return this.b.getUrl();
        }
        int n10 = 1;
        object = new CountDownLatch(n10);
        Object object2 = new a$a(this, (CountDownLatch)object);
        o.a((Runnable)object2);
        try {
            ((CountDownLatch)object).await();
        }
        catch (InterruptedException interruptedException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("getUrlMethod: InterruptedException ");
            String string2 = interruptedException.getMessage();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            string2 = c;
            Log.e((String)string2, (String)object2, (Throwable)interruptedException);
        }
        return this.a;
    }

    public WebView c() {
        return this.b;
    }

    public void d(String string2) {
        this.a = string2;
    }

    public void e(WebView webView) {
        this.b = webView;
    }
}

