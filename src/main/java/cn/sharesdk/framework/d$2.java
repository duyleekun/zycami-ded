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
import cn.sharesdk.framework.b.b.b;
import cn.sharesdk.framework.b.b.c;
import cn.sharesdk.framework.d;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class d$2
implements PlatformActionListener {
    public final /* synthetic */ PlatformActionListener a;
    public final /* synthetic */ int b;
    public final /* synthetic */ HashMap c;
    public final /* synthetic */ d d;

    public d$2(d d10, PlatformActionListener platformActionListener, int n10, HashMap hashMap) {
        this.d = d10;
        this.a = platformActionListener;
        this.b = n10;
        this.c = hashMap;
    }

    public void onCancel(Platform platform, int n10) {
        PlatformActionListener platformActionListener = this.d;
        PlatformActionListener platformActionListener2 = this.a;
        cn.sharesdk.framework.d.a((d)platformActionListener, platformActionListener2);
        platformActionListener = cn.sharesdk.framework.d.a(this.d);
        if (platformActionListener != null) {
            platformActionListener = cn.sharesdk.framework.d.a(this.d);
            int n11 = this.b;
            HashMap hashMap = this.c;
            platformActionListener.onComplete(platform, n11, hashMap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete(Platform object, int n10, HashMap object2) {
        Object object3;
        int n11;
        Object object4 = this.d;
        Object object5 = this.a;
        cn.sharesdk.framework.d.a((d)object4, (PlatformActionListener)object5);
        object4 = cn.sharesdk.framework.d.a(this.d);
        if (object4 != null) {
            block7: {
                try {
                    n10 = (int)(ShareSDK.getEnableAuthTag() ? 1 : 0);
                    if (n10 == 0) break block7;
                    object4 = new Hashon();
                    object5 = f.c();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)(object4 = ((Hashon)object4).fromHashMap((HashMap)(object5 = ((f)object5).b())))) ? 1 : 0);
                    if (n11 == 0) {
                        object5 = ((Platform)object).getDb();
                        object3 = "userTags";
                        ((PlatformDb)object5).put((String)object3, (String)object4);
                    }
                }
                catch (Exception exception) {}
            }
            object4 = cn.sharesdk.framework.d.a(this.d);
            n11 = this.b;
            object3 = this.c;
            object4.onComplete((Platform)object, n11, (HashMap)object3);
        }
        object4 = new b();
        ((b)object4).a = n11 = ((Platform)object).getPlatformId();
        object3 = "TencentWeibo";
        object5 = ((Platform)object).getName();
        n11 = (int)(((String)object3).equals(object5) ? 1 : 0);
        if (n11 != 0) {
            object5 = ((Platform)object).getDb();
            object3 = "name";
            object5 = ((PlatformDb)object5).get((String)object3);
        } else {
            object5 = ((Platform)object).getDb().getUserId();
        }
        ((b)object4).b = object5;
        object5 = new Hashon();
        ((b)object4).c = object2 = ((Hashon)object5).fromHashMap((HashMap)object2);
        object2 = this.d;
        ((b)object4).d = object = cn.sharesdk.framework.d.a((d)object2, (Platform)object);
        object = cn.sharesdk.framework.b.d.a();
        if (object != null) {
            ((cn.sharesdk.framework.b.d)object).a((c)object4);
        }
    }

    public void onError(Platform platform, int n10, Throwable object) {
        SSDKLog.b().w((Throwable)object);
        PlatformActionListener platformActionListener = this.d;
        object = this.a;
        cn.sharesdk.framework.d.a((d)platformActionListener, (PlatformActionListener)object);
        platformActionListener = cn.sharesdk.framework.d.a(this.d);
        if (platformActionListener != null) {
            platformActionListener = cn.sharesdk.framework.d.a(this.d);
            int n11 = this.b;
            HashMap hashMap = this.c;
            platformActionListener.onComplete(platform, n11, hashMap);
        }
    }
}

