/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.d;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class d$3
implements PlatformActionListener {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ d d;

    public d$3(d d10, PlatformActionListener platformActionListener, int n10, Object object) {
        this.d = d10;
        this.a = platformActionListener;
        this.b = n10;
        this.c = object;
    }

    public void onCancel(Platform platform, int n10) {
        PlatformActionListener platformActionListener = this.d;
        PlatformActionListener platformActionListener2 = this.a;
        cn.sharesdk.framework.d.a((d)platformActionListener, platformActionListener2);
        platformActionListener = cn.sharesdk.framework.d.a(this.d);
        if (platformActionListener != null) {
            platformActionListener = cn.sharesdk.framework.d.a(this.d);
            int n11 = this.b;
            platformActionListener.onCancel(platform, n11);
        }
    }

    public void onComplete(Platform platform, int n10, HashMap object) {
        Object object2;
        n10 = (int)(ShareSDK.getEnableAuthTag() ? 1 : 0);
        if (n10 != 0) {
            object2 = new Hashon();
            object = f.c().b();
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((Hashon)object2).fromHashMap((HashMap)object)));
            if (!bl2) {
                object = platform.getDb();
                String string2 = "userTags";
                ((PlatformDb)object).put(string2, (String)object2);
            }
        }
        object2 = this.d;
        object = this.a;
        cn.sharesdk.framework.d.a((d)object2, (PlatformActionListener)object);
        n10 = this.b;
        object = this.c;
        platform.afterRegister(n10, object);
    }

    public void onError(Platform platform, int n10, Throwable throwable) {
        PlatformActionListener platformActionListener = this.d;
        PlatformActionListener platformActionListener2 = this.a;
        cn.sharesdk.framework.d.a((d)platformActionListener, platformActionListener2);
        platformActionListener = cn.sharesdk.framework.d.a(this.d);
        if (platformActionListener != null) {
            platformActionListener = cn.sharesdk.framework.d.a(this.d);
            platformActionListener.onError(platform, n10, throwable);
        }
    }
}

