/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.net.Uri
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.a;
import com.mob.tools.FakeActivity;

public class a$1
extends WebViewClient {
    public final /* synthetic */ a a;

    public a$1(a a10) {
        this.a = a10;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String object) {
        block9: {
            if (object != null) {
                String string2 = "download://";
                boolean bl2 = ((String)object).startsWith(string2);
                if (!bl2) break block9;
                object = this.a;
                object = cn.sharesdk.tencent.qq.a.a((a)object);
                object = Uri.parse((String)object);
                String string3 = "android.intent.action.VIEW";
                string2 = new Intent(string3, (Uri)object);
                object = this.a;
                try {
                    ((FakeActivity)object).startActivity((Intent)string2);
                    return true;
                }
                catch (Throwable throwable) {
                    SSDKLog.b().d(throwable);
                    cn.sharesdk.tencent.qq.a.b(this.a).onFailed(throwable);
                    a a10 = this.a;
                    string2 = null;
                    cn.sharesdk.tencent.qq.a.a(a10, null);
                    a10 = this.a;
                    a10.a();
                }
            }
        }
        return false;
    }
}

