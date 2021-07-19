/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.a.b;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.h;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import java.util.ArrayList;

public class h$1
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ AuthorizeListener b;
    public final /* synthetic */ h c;

    public h$1(h h10, String string2, AuthorizeListener authorizeListener) {
        this.c = h10;
        this.a = string2;
        this.b = authorizeListener;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        try {
            object4 = new ArrayList();
            object3 = "appid";
            object2 = this.c;
            object2 = h.d((h)object2);
            object = new KVPair((String)object3, object2);
            ((ArrayList)object4).add(object);
            object3 = "secret";
            object2 = this.c;
            object2 = h.e((h)object2);
            object = new KVPair((String)object3, object2);
            ((ArrayList)object4).add(object);
            object3 = "code";
            object2 = this.a;
            object = new KVPair((String)object3, object2);
            ((ArrayList)object4).add(object);
            object3 = "grant_type";
            object2 = "authorization_code";
            object = new KVPair((String)object3, object2);
            ((ArrayList)object4).add(object);
            object = "https://api.weixin.qq.com/sns/oauth2/access_token";
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
            return;
        }
        object3 = this.c;
        object3 = h.c((h)object3);
        object2 = "/sns/oauth2/access_token";
        h h10 = this.c;
        int n10 = h.b(h10);
        object4 = ((b)object3).a((String)object, (ArrayList)object4, (String)object2, n10);
        {
            catch (Throwable throwable) {
                object = this.b;
                object.onError(throwable);
                return;
            }
            boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
            if (bl2) {
                object4 = this.b;
                object3 = "Authorize token is empty";
                object = new Throwable((String)object3);
                object4.onError((Throwable)object);
                return;
            }
            object = "errcode";
            bl2 = ((String)object4).contains((CharSequence)object);
            if (bl2) {
                object = this.b;
                if (object == null) return;
                object3 = new Throwable((String)object4);
                object.onError((Throwable)object3);
                return;
            }
            object = this.c;
            h.a((h)object, (String)object4);
            object4 = this.b;
            bl2 = false;
            object = null;
            object4.onComplete(null);
            return;
        }
    }
}

