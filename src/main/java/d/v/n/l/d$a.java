/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.webkit.URLUtil
 */
package d.v.n.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.zhiyun.live.LiveLoginActivity;
import com.zhiyun.live.data.api.entity.ThirdpartyInfo;
import d.v.n.k.a;
import d.v.n.l.d;

public class d$a
extends a {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ d d;

    public d$a(d d10, Activity activity) {
        this.d = d10;
        this.c = activity;
    }

    public void a(ThirdpartyInfo object) {
        d d10 = this.d;
        d10.a = object;
        object = d10.d;
        if (object != null) {
            boolean bl2;
            object = d.v.n.l.d.i().a.uri;
            boolean bl3 = URLUtil.isHttpsUrl((String)object);
            if (!bl3 && !(bl2 = URLUtil.isHttpUrl((String)object))) {
                object = this.d.d;
                object.a();
            } else {
                d10 = this.c;
                Class<LiveLoginActivity> clazz = LiveLoginActivity.class;
                object = new Intent((Context)d10, clazz);
                d10 = this.c;
                int n10 = 379;
                d10.startActivityForResult((Intent)object, n10);
            }
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.d.d;
        if (object != null) {
            object.a();
        }
    }
}

