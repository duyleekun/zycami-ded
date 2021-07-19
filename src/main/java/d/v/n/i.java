/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.n;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zhiyun.android.CameraView;
import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.LiveChannelActive;
import com.zhiyun.live.data.api.entity.LiveInfo;
import com.zhiyun.live.data.api.entity.ReStreamChannel;
import com.zhiyun.live.data.api.entity.ReStreamPlatform;
import com.zhiyun.renderengine.business.display.DisplayRender;
import com.zhiyun.renderengine.business.display.DisplayRender$x;
import d.v.d.i.g.j;
import d.v.d.i.g.l;
import d.v.e.l.c1;
import d.v.n.c;
import d.v.n.d;
import d.v.n.e;
import d.v.n.f;
import d.v.n.i$a;
import d.v.n.i$b;
import d.v.n.i$c;
import d.v.n.i$d;
import d.v.n.i$e;
import d.v.n.i$f;
import d.v.n.i$g;
import d.v.n.j.c.a;
import d.v.o.f.b;
import d.v.o.f.c$a;
import g.b0;
import g.v;
import g.w$c;
import java.io.File;
import java.util.Optional;
import k.r;

public class i {
    private final b a;
    private final DisplayRender b;
    private final d.v.d.i.d.c c;
    private final d.v.d.i.d.d d;
    private final d.v.d.i.g.f e;
    private final l f;
    private final j g;
    private LiveInfo h;
    private ReStreamChannel[] i;
    private ReStreamPlatform[] j;
    private final i$g k;
    private String l;
    private String m;
    private int n;
    private String o;
    private final DisplayRender$x p;
    private final d.v.d.i.a.c$a q;
    private final d.v.o.f.e r;

    public i(Context object, CameraView cameraView, i$g i$g) {
        Object object2 = new i$a(this);
        this.p = object2;
        this.q = object2 = new i$b(this);
        this.r = object2 = new i$c(this);
        this.a = object2 = new d.v.o.g.a((Context)object);
        object = cameraView.getDisplayRender();
        this.b = object;
        object = cameraView.getLivePcm();
        this.c = object;
        object = cameraView.getLiveRecord();
        this.d = object;
        object = cameraView.getRecordControl();
        this.e = object;
        object = cameraView.getRecordStatus();
        this.f = object;
        object = cameraView.getRecordPath();
        this.g = object;
        this.k = i$g;
    }

    public static /* synthetic */ b a(i i10) {
        return i10.a;
    }

    public static /* synthetic */ d.v.d.i.d.c b(i i10) {
        return i10.c;
    }

    public static /* synthetic */ i$g c(i i10) {
        return i10.k;
    }

    public static /* synthetic */ ReStreamChannel[] d(i i10) {
        return i10.i;
    }

    public static /* synthetic */ LiveInfo e(i i10) {
        return i10.h;
    }

    public static /* synthetic */ LiveInfo f(i i10, LiveInfo liveInfo) {
        i10.h = liveInfo;
        return liveInfo;
    }

    private void h(String object, String object2) {
        v v10 = v.j("application/octet-stream");
        b0 b02 = b0.create(this.m, v10);
        b0 b03 = b0.create(this.l, v10);
        b0 b04 = b0.create(String.valueOf(this.n), v10);
        b0 b05 = b0.create(this.o, v10);
        b0 b06 = b0.create((String)object, v10);
        w$c c10 = this.i((String)object2);
        object = d.v.n.j.c.a.c.f(b02, b03, b04, b05, b06, c10);
        object2 = new i$e(this);
        object.h((k.f)object2);
    }

    private w$c i(String object) {
        boolean bl2;
        String string2 = "kuaishou";
        Object object2 = this.l;
        boolean bl3 = TextUtils.equals((CharSequence)string2, (CharSequence)object2);
        if (bl3 && (bl2 = ((File)(object2 = new File((String)object))).exists())) {
            object = v.j("application/octet-stream");
            object = b0.create((File)object2, (v)object);
            object2 = ((File)object2).getName();
            string2 = "file";
            object = w$c.g(string2, (String)object2, (b0)object);
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    private void j() {
        Object object = this.h;
        if (object == null) {
            return;
        }
        Object object2 = d.v.n.j.c.a.c;
        String string2 = ((LiveInfo)object).getLiveVideoId();
        String string3 = this.l;
        String string4 = this.m;
        String string5 = String.valueOf(this.n);
        String string6 = this.o;
        object = object2.d(string2, string3, string4, string5, string6, "ks680887970458072564", "zhiyun");
        object2 = new i$f(this);
        object.h((k.f)object2);
    }

    private /* synthetic */ void m(String object) {
        int n10;
        ReStreamPlatform[] reStreamPlatformArray = new StringBuilder();
        String string2 = "Bearer ";
        reStreamPlatformArray.append(string2);
        reStreamPlatformArray.append((String)object);
        object = reStreamPlatformArray.toString();
        reStreamPlatformArray = d.v.n.j.c.a.c;
        object = reStreamPlatformArray.c((String)object);
        object = object.execute();
        object = ((r)object).a();
        object = (ReStreamChannel[])object;
        this.i = object;
        object = reStreamPlatformArray.h();
        object = object.execute();
        object = ((r)object).a();
        object = (ReStreamPlatform[])object;
        try {
            this.j = object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object = this.i;
        if (object != null && (n10 = ((ReStreamChannel[])object).length) > 0 && (reStreamPlatformArray = this.j) != null && (n10 = reStreamPlatformArray.length) > 0) {
            this.k.a((ReStreamChannel[])object);
            return;
        }
        this.k.c(377);
    }

    private /* synthetic */ void o(DisplayRender displayRender) {
        DisplayRender$x displayRender$x = this.p;
        displayRender.t0(displayRender$x);
    }

    private /* synthetic */ void q(DisplayRender displayRender) {
        DisplayRender$x displayRender$x = this.p;
        displayRender.t0(displayRender$x);
    }

    public static /* synthetic */ void s(DisplayRender displayRender) {
        displayRender.t0(null);
    }

    public void g(String object, String object2, String object3, int n10, int n11, int n12, String string2, String string3, String string4) {
        int n13;
        String string5;
        int n14;
        int n15;
        block13: {
            this.l = object;
            this.m = string4;
            this.n = n12;
            this.o = string2;
            n12 = ((String)object).hashCode();
            n15 = 2;
            n14 = 1;
            switch (n12) {
                default: {
                    break;
                }
                case 1138387213: {
                    string5 = "kuaishou";
                    n13 = (int)(((String)object).equals(string5) ? 1 : 0);
                    if (n13 == 0) break;
                    n13 = n14;
                    break block13;
                }
                case 497130182: {
                    string5 = "facebook";
                    n13 = (int)(((String)object).equals(string5) ? 1 : 0);
                    if (n13 == 0) break;
                    n13 = 3;
                    break block13;
                }
                case 113011944: {
                    string5 = "weibo";
                    n13 = (int)(((String)object).equals(string5) ? 1 : 0);
                    if (n13 == 0) break;
                    n13 = 0;
                    object = null;
                    break block13;
                }
                case -336549005: {
                    string5 = "restream";
                    n13 = (int)(((String)object).equals(string5) ? 1 : 0);
                    if (n13 == 0) break;
                    n13 = n15;
                    break block13;
                }
            }
            n13 = -1;
        }
        if (n13 != 0) {
            if (n13 != n14) {
                if (n13 == n15) {
                    object = "";
                    this.h((String)object, string3);
                }
            } else {
                object = new JsonObject();
                ((JsonObject)object).addProperty("streamType", "video");
                ((JsonObject)object).addProperty("caption", (String)object2);
                object2 = d.v.n.l.e.d();
                object3 = Boolean.FALSE;
                boolean bl2 = ((d.v.n.l.e)object2).c("SP_LIVE_LOGIN_WEB", (Boolean)object3);
                object3 = "bizId";
                String string6 = "appid";
                if (bl2) {
                    ((JsonObject)object).addProperty(string6, "ks694398768641986964");
                    object2 = "zhiyunweb";
                    ((JsonObject)object).addProperty((String)object3, (String)object2);
                } else {
                    ((JsonObject)object).addProperty(string6, "ks680887970458072564");
                    object2 = "zhiyun";
                    ((JsonObject)object).addProperty((String)object3, (String)object2);
                }
                object = ((JsonElement)object).toString();
                this.h((String)object, string3);
            }
        } else {
            object = new JsonObject();
            string5 = "title";
            ((JsonObject)object).addProperty(string5, (String)object2);
            object2 = n10;
            ((JsonObject)object).addProperty("width", (Number)object2);
            object2 = n11;
            String string7 = "height";
            ((JsonObject)object).addProperty(string7, (Number)object2);
            object2 = "summary";
            ((JsonObject)object).addProperty((String)object2, (String)object3);
            object = ((JsonElement)object).toString();
            this.h((String)object, string3);
        }
    }

    public ReStreamPlatform[] k() {
        return this.j;
    }

    public boolean l() {
        return this.f.q();
    }

    public /* synthetic */ void n(String string2) {
        this.m(string2);
    }

    public /* synthetic */ void p(DisplayRender displayRender) {
        this.o(displayRender);
    }

    public /* synthetic */ void r(DisplayRender displayRender) {
        this.q(displayRender);
    }

    public void t(String string2) {
        d d10 = new d(this, string2);
        c1.b().e().execute(d10);
    }

    public void u(String object, int n10, boolean bl2) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Bearer ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new LiveChannelActive();
        ((LiveChannelActive)object2).setActive(bl2 ^= true);
        Object object3 = d.v.n.j.c.a.c;
        String string2 = String.valueOf(n10);
        object = object3.a((String)object, "application/json", string2, (LiveChannelActive)object2);
        object3 = new i$d(this, n10);
        object.h((k.f)object3);
    }

    public void v(String object, int n10, int n11, int n12, int n13, int n14, int n15, boolean bl2, d.v.o.f.d d10) {
        c$a c$a = new c$a();
        Object object2 = c$a.q(n10).p(n11).s(n12).r(n13).l(n14).m(n15).n();
        this.a.m((d.v.o.f.c)object2);
        this.a.k(d10);
        this.a.b(bl2);
        object2 = Optional.of(this.b);
        c c10 = new c(this);
        ((Optional)object2).ifPresent(c10);
        this.a.i((String)object);
        object = Optional.of(this.b);
        object2 = new f(this);
        ((Optional)object).ifPresent(object2);
        object = this.a;
        if (object != null) {
            object2 = this.r;
            object.h((d.v.o.f.e)object2);
        }
    }

    public void w(String object) {
        this.g.q((String)object);
        object = this.e;
        Integer n10 = 0;
        ((d.v.d.i.g.f)object).n(n10);
    }

    public void x(LivePlatform object) {
        Object object2 = Optional.of(this.a);
        d.v.n.a a10 = d.v.n.a.a;
        object2.ifPresent(a10);
        object2 = LivePlatform.RTMP;
        if (object != object2) {
            this.j();
        }
        object = Optional.of(this.b);
        object2 = d.v.n.e.a;
        ((Optional)object).ifPresent(object2);
        object = this.a;
        if (object != null) {
            object2 = null;
            object.h(null);
        }
    }

    public void y() {
        d.v.d.i.g.f f10 = this.e;
        Integer n10 = 2;
        f10.n(n10);
    }
}

