/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.f$1$1;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;

public class f$1
implements MoblinkActionListener {
    public final /* synthetic */ Platform$ShareParams a;
    public final /* synthetic */ f b;

    public f$1(f f10, Platform$ShareParams platform$ShareParams) {
        this.b = f10;
        this.a = platform$ShareParams;
    }

    public void onError(Throwable throwable) {
        d d10 = f.b(this.b);
        if (d10 != null) {
            d10 = f.b(this.b);
            Platform platform = f.a(this.b);
            int n10 = 9;
            d10.onError(platform, n10, throwable);
        }
    }

    public void onResult(Object object) {
        Object object2 = Uri.parse((String)this.a.getTitleUrl()).getEncodedQuery();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = this.a.getTitleUrl();
            stringBuilder.append(string2);
            string2 = "&mobid=";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            ((InnerShareParams)object2).setTitleUrl((String)object);
        } else {
            object2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = this.a.getTitleUrl();
            stringBuilder.append(string3);
            string3 = "?mobid=";
            stringBuilder.append(string3);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            ((InnerShareParams)object2).setTitleUrl((String)object);
        }
        object = new f$1$1(this);
        ((Thread)object).start();
    }
}

