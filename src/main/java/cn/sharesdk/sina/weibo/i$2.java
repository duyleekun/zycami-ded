/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.sina.weibo.i;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class i$2
implements AuthorizeListener {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ Platform$ShareParams b;
    public final /* synthetic */ i c;

    public i$2(i i10, PlatformActionListener platformActionListener, Platform$ShareParams platform$ShareParams) {
        this.c = i10;
        this.a = platformActionListener;
        this.b = platform$ShareParams;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            Platform platform = i.j(this.c);
            int n10 = 9;
            platformActionListener.onCancel(platform, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete(Bundle object) {
        Object object2;
        Object object3;
        Object object4 = this.a;
        if (object4 != null) {
            object4 = new HashMap();
            object3 = this.b;
            ((HashMap)object4).put("ShareParams", object3);
            object3 = this.a;
            object2 = i.e(this.c);
            int n10 = 9;
            object3.onComplete((Platform)object2, n10, (HashMap)object4);
        }
        if (object == null) return;
        object4 = object.getString("uid");
        object3 = object.getString("access_token");
        object2 = "expire_in";
        object = object.getString((String)object2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            i.a(this.c, (String)object3);
            object3 = i.g(this.c).getDb();
            object2 = i.f(this.c);
            ((PlatformDb)object3).putToken((String)object2);
        }
        object3 = i.h(this.c).getDb();
        ((PlatformDb)object3).putUserId((String)object4);
        try {
            long l10 = ResHelper.parseLong((String)object);
            object = this.c;
            object = i.i((i)object);
            object = ((Platform)object).getDb();
            ((PlatformDb)object).putExpiresIn(l10);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = this.a;
        if (platformActionListener != null) {
            Platform platform = i.d(this.c);
            int n10 = 9;
            platformActionListener.onError(platform, n10, throwable);
        }
    }
}

