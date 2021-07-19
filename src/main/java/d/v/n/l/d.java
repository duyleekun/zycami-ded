/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.n.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.zhiyun.common.util.Devices;
import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.LiveKwaiUserInfo;
import com.zhiyun.live.data.api.entity.LiveKwaiUserInfo$UserInfo;
import com.zhiyun.live.data.api.entity.LiveRestreamUserInfo;
import com.zhiyun.live.data.api.entity.ThirdpartyAccessTokenInfo;
import com.zhiyun.live.data.api.entity.ThirdpartyInfo;
import d.v.e.l.c1;
import d.v.e.l.m2;
import d.v.n.l.a;
import d.v.n.l.b;
import d.v.n.l.d$a;
import d.v.n.l.d$b;
import d.v.n.l.d$c;
import d.v.n.l.d$d;
import d.v.n.l.d$e;
import d.v.n.l.d$f;
import d.v.n.l.e;
import e.a.h0;
import java.io.IOException;
import k.f;
import k.r;

public class d {
    public static String e = "user_info,user_video_live";
    private static final String f = "https://open.kuaishou.com";
    private static final int g = 5;
    private static final int h = 5;
    private static final int i = 3000;
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    private static volatile d m;
    public ThirdpartyInfo a;
    private final ThirdpartyAccessTokenInfo b;
    private int c;
    public d$f d;

    private d() {
        ThirdpartyAccessTokenInfo thirdpartyAccessTokenInfo;
        this.b = thirdpartyAccessTokenInfo = new ThirdpartyAccessTokenInfo();
    }

    public static /* synthetic */ void a(d d10, String string2) {
        d10.p(string2);
    }

    public static /* synthetic */ void b(d d10, String string2, String string3) {
        d10.s(string2, string3);
    }

    public static /* synthetic */ void c(d d10, String string2, String string3) {
        d10.q(string2, string3);
    }

    public static /* synthetic */ void d(d d10, String string2) {
        d10.r(string2);
    }

    public static /* synthetic */ int e(d d10) {
        return d10.c;
    }

    public static /* synthetic */ int f(d d10, int n10) {
        d10.c = n10;
        return n10;
    }

    public static /* synthetic */ int g(d d10) {
        int n10;
        int n11 = d10.c;
        d10.c = n10 = n11 + 1;
        return n11;
    }

    private String h(String string2) {
        boolean bl2;
        string2.hashCode();
        String string3 = "restream";
        boolean bl3 = string2.equals(string3);
        string2 = !bl3 ? (!(bl2 = string2.equals(string3 = "kuaishou")) ? "" : "ks694398768641986964") : "10ff85d9-e5a8-488b-b473-7b750171ab7d";
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d i() {
        Object object = m;
        if (object != null) return m;
        object = d.class;
        synchronized (object) {
            d d10 = m;
            if (d10 != null) return m;
            m = d10 = new d();
            return m;
        }
    }

    private /* synthetic */ void l(String object, String object2) {
        int n10;
        int n11;
        Object object3 = d.v.n.j.c.a.c;
        object = object3.b((String)object, (String)object2);
        object = object.execute();
        object = ((r)object).a();
        try {
            object = (LiveKwaiUserInfo)object;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            object = null;
        }
        object2 = this.d;
        if (object2 != null && object != null && (n11 = ((LiveKwaiUserInfo)object).result) == (n10 = 1)) {
            object = ((LiveKwaiUserInfo)object).userInfo;
            object3 = ((LiveKwaiUserInfo$UserInfo)object).name;
            object = ((LiveKwaiUserInfo$UserInfo)object).head;
            object2.c((String)object3, (String)object);
        }
    }

    private /* synthetic */ void n(String object) {
        Object object2 = d.v.n.j.c.a.c;
        object = object2.g((String)object);
        object = object.execute();
        object = ((r)object).a();
        try {
            object = (LiveRestreamUserInfo)object;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            object = null;
        }
        object2 = this.d;
        if (object2 != null && object != null) {
            object = ((LiveRestreamUserInfo)object).userName;
            String string2 = "";
            object2.c((String)object, string2);
        }
    }

    private void p(String string2) {
        h0 h02 = e.a.c1.b.d();
        d$e d$e = new d$e(this, string2);
        m2.Z(3000L, h02, d$e);
    }

    private void q(String string2, String string3) {
        b b10 = new b(this, string3, string2);
        c1.b().e().execute(b10);
    }

    private void r(String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("Bearer ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        object = new a(this, string2);
        c1.b().e().execute((Runnable)object);
    }

    private void s(String string2, String object) {
        Object object2 = Devices.k((Context)d.v.e.f.a().b());
        d.v.n.j.c.a a10 = d.v.n.j.c.a.c;
        String string3 = this.h(string2);
        object = a10.i(string2, (String)object2, (String)object, string3);
        object2 = new d$c(this, string2);
        object.h((f)object2);
    }

    public void j(Activity object, String string2) {
        boolean bl2;
        Object object2 = this.d;
        if (object2 != null && (bl2 = TextUtils.isEmpty((CharSequence)(object2 = this.b.accessToken)))) {
            object2 = "CODE_CANCEL_NO_APP";
            boolean bl3 = string2.equals(object2);
            if (bl3) {
                this.u((Activity)object, "kuaishou");
                return;
            }
            object = this.d;
            object.a();
        }
    }

    public void k(String object, String object2, int n10) {
        ThirdpartyAccessTokenInfo thirdpartyAccessTokenInfo = this.b;
        thirdpartyAccessTokenInfo.openid = object;
        thirdpartyAccessTokenInfo.accessToken = object2;
        thirdpartyAccessTokenInfo.expiresIn = n10;
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        int n11 = (int)(l10 /= l11);
        thirdpartyAccessTokenInfo.expiresAt = n10 += n11;
        object = this.d;
        if (object != null) {
            object = d.v.n.l.e.d();
            object2 = Boolean.FALSE;
            String string2 = "SP_LIVE_LOGIN_WEB";
            ((e)object).e(string2, (Boolean)object2);
            object = this.b.accessToken;
            this.q((String)object, "ks680887970458072564");
            object = this.d;
            object2 = this.b;
            object.b((ThirdpartyAccessTokenInfo)object2);
        }
    }

    public /* synthetic */ void m(String string2, String string3) {
        this.l(string2, string3);
    }

    public /* synthetic */ void o(String string2) {
        this.n(string2);
    }

    public void t(LivePlatform livePlatform, String object) {
        Object object2 = Devices.k((Context)d.v.e.f.a().b());
        d.v.n.j.c.a a10 = d.v.n.j.c.a.c;
        String string2 = livePlatform.getPlatformName();
        String string3 = livePlatform.getPlatformName();
        string3 = this.h(string3);
        object = a10.j(string2, (String)object2, (String)object, string3);
        object2 = new d$d(this, livePlatform);
        object.h((f)object2);
    }

    public void u(Activity activity, String object) {
        this.c = 0;
        Object object2 = Devices.k((Context)d.v.e.f.a().b());
        String string2 = this.h((String)object);
        object = d.v.n.j.c.a.c.e((String)object, (String)object2, string2);
        object2 = new d$a(this, activity);
        object.h((f)object2);
    }

    public void v() {
        Object object = d.v.n.j.c.a.c;
        int n10 = this.a.sessionId;
        object = object.k(n10);
        d$b d$b = new d$b(this);
        object.h(d$b);
    }

    public void w(d$f d$f) {
        this.d = d$f;
    }
}

