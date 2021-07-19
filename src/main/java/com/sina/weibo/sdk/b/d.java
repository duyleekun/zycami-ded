/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.e$a;

public final class d
extends c {
    private Context ae;
    private ChatObject af;
    private com.sina.weibo.sdk.net.c ag;
    private Throwable ah;

    public d(Context context, ChatObject chatObject, com.sina.weibo.sdk.net.c c10) {
        this.ae = context;
        this.af = chatObject;
        this.ag = c10;
    }

    private String q() {
        Object object = a.a();
        Object object2 = new e$a();
        Object object3 = "http://i.open.t.sina.com.cn/mobilesdk/sendmessage.php";
        ((e$a)object2).url = object3;
        object3 = "app_key";
        String string2 = ((AuthInfo)object).getAppKey();
        object2 = ((e$a)object2).b((String)object3, string2);
        object3 = "platform";
        string2 = "2";
        object2 = ((e$a)object2).b((String)object3, string2);
        object3 = "android_pack";
        string2 = ((AuthInfo)object).getPackageName();
        object2 = ((e$a)object2).b((String)object3, string2);
        object3 = "android_sign";
        object = ((AuthInfo)object).getHash();
        object = ((e$a)object2).b((String)object3, object);
        object2 = "display_name";
        object3 = this.af;
        object3 = ((ChatObject)object3).content;
        object = ((e$a)object).b((String)object2, object3);
        object2 = "image_url";
        object3 = this.af;
        object3 = ((ChatObject)object3).image_url;
        object = ((e$a)object).b((String)object2, object3);
        object2 = "url";
        object3 = this.af;
        object3 = ((ChatObject)object3).url;
        object = ((e$a)object).b((String)object2, object3);
        object2 = "summary";
        object3 = this.af;
        object3 = ((ChatObject)object3).summary;
        object = ((e$a)object).b((String)object2, object3);
        object = ((e$a)object).i();
        object2 = new b();
        object = object2.a((com.sina.weibo.sdk.net.d)object);
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

