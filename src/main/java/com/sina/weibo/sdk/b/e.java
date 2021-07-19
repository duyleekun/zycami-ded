/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.e$a;

public final class e
extends c {
    private Context ae;
    private com.sina.weibo.sdk.net.c ag;
    private Throwable ah;
    private String ai;
    private String aj;
    private String appKey;

    public e(Context context, String string2, String string3, String string4, com.sina.weibo.sdk.net.c c10) {
        this.ae = context;
        this.ai = string2;
        this.appKey = string3;
        this.aj = string4;
        this.ag = c10;
    }

    private String d(String string2) {
        Context context = this.ae;
        String string3 = this.getAid();
        String string4 = this.aj;
        String string5 = this.appKey;
        return HttpManager.a(context, string3, string4, string5, string2);
    }

    private String getAid() {
        Context context = this.ae;
        String string2 = this.appKey;
        return com.sina.weibo.sdk.c.e.f(context, string2);
    }

    private String q() {
        Object object = "oauth_sign";
        Object object2 = "oauth_timestamp";
        Object object3 = "aid";
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        l10 /= l11;
        String string2 = String.valueOf(l10);
        e$a e$a = new e$a();
        String string3 = "https://service.weibo.com/share/mobilesdk_uppic.php";
        e$a.url = string3;
        string3 = this.getAid();
        e$a = e$a.a((String)object3, string3);
        e$a = e$a.a((String)object2, string2);
        string3 = this.d(string2);
        e$a = e$a.a((String)object, string3);
        string3 = "appKey";
        String string4 = this.appKey;
        e$a = e$a.b(string3, string4);
        string3 = this.getAid();
        object3 = e$a.b((String)object3, string3);
        object2 = ((e$a)object3).b((String)object2, string2);
        object3 = this.d(string2);
        object = ((e$a)object2).b((String)object, object3);
        object2 = "img";
        object3 = this.ai;
        object = ((e$a)object).b((String)object2, object3);
        object = ((e$a)object).i();
        object2 = new b();
        object = object2.a((d)object);
        try {
            object = object.j();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            this.ah = throwable;
            object = null;
        }
        return object;
    }

    public final /* synthetic */ Object o() {
        return this.q();
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        object = (String)object;
        Object object2 = this.ah;
        if (object2 != null) {
            object = this.ag;
            if (object != null) {
                object.onError((Throwable)object2);
            }
            return;
        }
        object2 = this.ag;
        if (object2 != null) {
            object2.a(object);
        }
    }
}

