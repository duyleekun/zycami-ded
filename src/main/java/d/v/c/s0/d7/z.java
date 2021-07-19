/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package d.v.c.s0.d7;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.android.CameraView;
import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.ReStreamPlatform;
import d.v.c.s0.d7.a0;
import d.v.c.s0.d7.t;
import d.v.c.s0.d7.z$b;
import d.v.c.s0.d7.z$c;
import d.v.c.s0.d7.z$e;
import d.v.c.s0.t6;
import d.v.e.i.h;
import d.v.e.l.k2;
import d.v.f.i.g;
import d.v.n.i;
import d.v.n.i$g;
import d.v.n.j.a;
import d.v.n.j.b;
import d.v.n.l.d$f;
import java.lang.constant.Constable;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class z
extends AndroidViewModel {
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 4;
    public static final int Q = 5;
    public static final int R = 6;
    public static final int S = 7;
    public static final int T = 8;
    public static final int U = 0;
    public static final int V = 1;
    public static final int W = 2;
    public static final int X = 3;
    private final MutableLiveData A;
    private final MutableLiveData B;
    private final MutableLiveData C;
    private final MutableLiveData D;
    private final MutableLiveData E;
    public final MutableLiveData F;
    public final MutableLiveData G;
    private final LiveData H;
    private i I;
    private final i$g J;
    private final d$f K;
    public final ArrayDeque a;
    private LivePlatform b;
    private AccountManager$AuthData c;
    private String d;
    public int e;
    private Timer f;
    private int g;
    private int h;
    private long i;
    private String j;
    public int k;
    public int l;
    public final MutableLiveData m;
    public final MutableLiveData n;
    public final MutableLiveData o;
    public final MutableLiveData p;
    private final MutableLiveData q;
    private final MutableLiveData r;
    private final MutableLiveData s;
    private final MutableLiveData t;
    private final MutableLiveData u;
    private final MutableLiveData v;
    private final MutableLiveData w;
    private final MutableLiveData x;
    private final MutableLiveData y;
    private final MutableLiveData z;

    public z(Application object) {
        super((Application)object);
        int n10;
        super();
        this.a = object;
        object = LivePlatform.RTMP;
        this.b = object;
        this.k = n10 = 3;
        this.l = n10;
        super();
        this.m = object;
        super();
        this.n = object;
        super();
        this.o = object;
        super();
        this.p = object;
        Object object2 = new MutableLiveData();
        this.q = object2;
        object2 = new MutableLiveData();
        this.r = object2;
        object2 = new MutableLiveData();
        this.s = object2;
        object2 = new MutableLiveData();
        this.t = object2;
        Boolean bl2 = Boolean.FALSE;
        object2 = new MutableLiveData(bl2);
        this.u = object2;
        object2 = new MutableLiveData();
        this.v = object2;
        object2 = new MutableLiveData(bl2);
        this.w = object2;
        object2 = new MutableLiveData(bl2);
        this.x = object2;
        object2 = new MutableLiveData(bl2);
        this.y = object2;
        object2 = new MutableLiveData();
        this.z = object2;
        object2 = new MutableLiveData();
        this.A = object2;
        object2 = new MutableLiveData();
        this.B = object2;
        object2 = new MutableLiveData();
        this.C = object2;
        object2 = new MutableLiveData();
        this.D = object2;
        object2 = new MutableLiveData();
        this.E = object2;
        object2 = new MutableLiveData();
        this.F = object2;
        object2 = new MutableLiveData();
        this.G = object2;
        object2 = d.v.c.s0.d7.t.a;
        object = Transformations.map((LiveData)object, (Function)object2);
        this.H = object;
        super(this);
        this.J = object;
        super(this);
        this.K = object;
    }

    private String F(int n10) {
        if (n10 == 0) {
            return "00:00:00";
        }
        int n11 = n10 / 3600;
        int n12 = n10 % 3600 / 60;
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[3];
        Integer n13 = n11;
        objectArray[0] = n13;
        Integer n14 = n12;
        objectArray[1] = n14;
        Integer n15 = n10 %= 60;
        objectArray[2] = n15;
        return String.format(locale, "%02d:%02d:%02d", objectArray);
    }

    public static /* synthetic */ String b(z z10, String string2) {
        z10.d = string2;
        return string2;
    }

    public static /* synthetic */ MutableLiveData c(z z10) {
        return z10.B;
    }

    public static /* synthetic */ MutableLiveData d(z z10) {
        return z10.D;
    }

    public static /* synthetic */ MutableLiveData e(z z10) {
        return z10.w;
    }

    public static /* synthetic */ MutableLiveData f(z z10) {
        return z10.E;
    }

    public static /* synthetic */ LivePlatform g(z z10) {
        return z10.b;
    }

    public static /* synthetic */ AccountManager$AuthData i(z z10) {
        return z10.c;
    }

    public static /* synthetic */ AccountManager$AuthData j(z z10, AccountManager$AuthData accountManager$AuthData) {
        z10.c = accountManager$AuthData;
        return accountManager$AuthData;
    }

    private String j0(Resources resources) {
        float f10 = k2.e();
        float f11 = 1.07374182E9f;
        float f12 = (float)k2.S() / f11;
        Object[] objectArray = new Object[2];
        Float f13 = Float.valueOf(f10 /= f11);
        objectArray[0] = f13;
        f13 = Float.valueOf(f12);
        objectArray[1] = f13;
        return d.v.f.i.g.p(resources, 2131952474, objectArray);
    }

    public static /* synthetic */ MutableLiveData k(z z10) {
        return z10.r;
    }

    public static /* synthetic */ long l(z z10, long l10) {
        z10.i = l10;
        return l10;
    }

    public static /* synthetic */ void m(z z10) {
        z10.s0();
    }

    public static /* synthetic */ MutableLiveData n(z z10) {
        return z10.q;
    }

    public static /* synthetic */ int o(z z10) {
        return z10.g;
    }

    public static /* synthetic */ String o0(b object) {
        CharSequence charSequence;
        String string2 = "";
        if (object != null && (charSequence = ((b)object).p()) != null && (charSequence = ((b)object).f()) != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("\t(");
            String string3 = ((b)object).p();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append("/");
            object = ((b)object).f().replace(" ", string2);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(")");
            return ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    public static /* synthetic */ int p(z z10) {
        int n10;
        int n11 = z10.g;
        z10.g = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ String r(z z10, int n10) {
        return z10.F(n10);
    }

    private void r0() {
        this.i = 0L;
        this.h = 0;
        this.e = 0;
        this.g = 0;
    }

    private void s0() {
        b b10 = this.K();
        String string2 = this.c.avatar;
        b10.C(string2);
        string2 = this.c.nickname;
        b10.P(string2);
        this.p.postValue(b10);
    }

    private ThirdPlatform v(String object) {
        object.hashCode();
        String string2 = "weibo";
        boolean bl2 = object.equals(string2);
        if (!bl2) {
            string2 = "facebook";
            boolean bl3 = object.equals(string2);
            if (!bl3) {
                bl3 = false;
                object = null;
            } else {
                object = ThirdPlatform.FACEBOOK;
            }
        } else {
            object = ThirdPlatform.WEIBO;
        }
        if (object != null) {
            bl2 = true;
            ((ThirdPlatform)((Object)object)).setWebLogin(bl2);
        }
        return object;
    }

    public MutableLiveData A() {
        return this.r;
    }

    public void A0() {
        Object object = this.d;
        int n10 = this.m0((String)object);
        if (n10 == 0) {
            return;
        }
        object = this.y;
        Object object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        object = this.K();
        n10 = ((b)object).z();
        object2 = this.K();
        int n11 = ((b)object2).g();
        b b10 = this.K();
        int n12 = b10.e();
        b b11 = this.K();
        int n13 = b11.b();
        int n14 = 0x100000;
        n13 *= n14;
        Object object3 = this.p.getValue();
        if (object3 != null) {
            object = (b)this.p.getValue();
            n10 = ((b)object).z();
            object2 = (b)this.p.getValue();
            n11 = ((b)object2).g();
            b10 = (b)this.p.getValue();
            n12 = b10.e();
            b11 = (b)this.p.getValue();
            n13 = b11.b() * n14;
        }
        i i10 = this.I;
        object3 = this.d;
        boolean bl2 = d.v.e.h.a.c((Boolean)this.v.getValue());
        z$b z$b = new z$b(this);
        i10.v((String)object3, n10, n11, n12, n13, 2, 44100, bl2, z$b);
    }

    public void B0() {
        Object object = this.I;
        boolean bl2 = ((i)object).l();
        if (bl2) {
            return;
        }
        object = t6.i();
        this.j = object;
        Object object2 = this.I;
        ((i)object2).w((String)object);
        object = this.F;
        object2 = Boolean.TRUE;
        try {
            d.v.e.i.h.g((MutableLiveData)object, object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void C0() {
        Timer timer = this.f;
        if (timer != null) {
            this.t();
        }
        this.f = timer = new Timer();
        z$e z$e = new z$e(this);
        this.f.schedule((TimerTask)z$e, 0L, 1000L);
    }

    public void D0() {
        this.y0(8);
        this.E0();
        MutableLiveData mutableLiveData = this.G;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.postValue(bl2);
    }

    public void E0() {
        Object object = this.n;
        Object object2 = 0;
        ((MutableLiveData)object).postValue(object2);
        this.t();
        object = (Boolean)this.F.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2) {
            this.F0();
        }
        object = this.I;
        object2 = this.b;
        ((i)object).x((LivePlatform)((Object)object2));
    }

    public void F0() {
        int n10 = this.h;
        int n11 = this.e;
        n10 += n11;
        this.h = n10;
        n10 = 0;
        Object object = null;
        this.e = 0;
        object = this.F;
        Object object2 = Boolean.FALSE;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.I;
        ((i)object).y();
        object = this.getApplication();
        object2 = this.j;
        try {
            t6.b((Context)object, (String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public MutableLiveData G() {
        return this.F;
    }

    public MutableLiveData H() {
        return this.x;
    }

    public MutableLiveData I() {
        return this.z;
    }

    public d$f J() {
        return this.K;
    }

    public b K() {
        b b10 = (b)this.p.getValue();
        if (b10 == null) {
            b10 = new b();
            b10.d0(720);
            b10.I(1280);
            b10.D(1);
            b10.G(30);
            Boolean bl2 = d.v.n.j.a.j;
            int n10 = bl2.booleanValue();
            b10.O(n10 != 0);
            n10 = 5;
            b10.R(n10);
        }
        return b10;
    }

    public MutableLiveData L() {
        return this.y;
    }

    public LivePlatform M() {
        return this.b;
    }

    public MutableLiveData N() {
        return this.B;
    }

    public MutableLiveData P() {
        return this.C;
    }

    public String Q() {
        int n10 = this.h;
        return this.F(n10);
    }

    public MutableLiveData R() {
        return this.E;
    }

    public MutableLiveData S() {
        return this.u;
    }

    public MutableLiveData T() {
        return this.s;
    }

    public MutableLiveData U() {
        return this.t;
    }

    public MutableLiveData V() {
        return this.v;
    }

    public MutableLiveData W() {
        return this.w;
    }

    public MutableLiveData X() {
        return this.o;
    }

    public int Y() {
        int n10;
        Object object = this.o.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.o.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public b Z(Resources object) {
        b b10 = this.K();
        int n10 = 1;
        Object object2 = new Object[n10];
        Integer n11 = b10.z();
        object2[0] = n11;
        object2 = d.v.f.i.g.p(object, 2131952473, object2);
        b10.a0((String)object2);
        object2 = new Object[n10];
        n11 = b10.b();
        object2[0] = n11;
        object2 = d.v.f.i.g.p(object, 2131952468, object2);
        b10.V((String)object2);
        Object object3 = new Object[n10];
        object3[0] = object2 = Integer.valueOf(b10.e());
        object3 = d.v.f.i.g.p(object, 2131952469, object3);
        b10.W((String)object3);
        object = this.j0((Resources)object);
        b10.b0((String)object);
        return b10;
    }

    public MutableLiveData a0() {
        return this.n;
    }

    public int b0() {
        int n10;
        Object object = this.n.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.n.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public MutableLiveData c0() {
        return this.q;
    }

    public String d0() {
        int n10 = this.g;
        return this.F(n10);
    }

    public MutableLiveData e0() {
        return this.D;
    }

    public LiveData f0() {
        return this.H;
    }

    public String g0() {
        long l10 = this.i;
        long l11 = 0x100000L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return "KB";
        }
        l11 = 0x40000000L;
        long l13 = l10 - l11;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 < 0) {
            return "MB";
        }
        return "GB";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public float h0() {
        float f10;
        float f11;
        long l10 = this.i;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return 0.0f;
        }
        l11 = 0x100000L;
        long l13 = l10 - l11;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 < 0) {
            f11 = l10;
            f10 = 1024.0f;
            return f11 / f10;
        }
        l11 = 0x40000000L;
        long l14 = l10 - l11;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 < 0) {
            f11 = l10;
            f10 = 8;
            return f11 / f10;
        }
        f11 = l10;
        f10 = 1.07374182E9f;
        return f11 / f10;
    }

    public ReStreamPlatform[] i0() {
        return this.I.k();
    }

    public String k0() {
        return this.d;
    }

    public void l0(Context context, CameraView cameraView) {
        i i10;
        i$g i$g = this.J;
        this.I = i10 = new i(context, cameraView, i$g);
    }

    public boolean m0(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && (bl2 = string2.startsWith(string3 = "rtmp://"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public Boolean n0() {
        AccountManager$AuthData accountManager$AuthData;
        String string2 = "";
        String string3 = "";
        String string4 = "";
        Object object = accountManager$AuthData;
        this.c = accountManager$AuthData = new AccountManager$AuthData("", "", string2, string3, string4);
        object = a0.e();
        String string5 = this.b.getPlatformName();
        AccountManager$AuthData accountManager$AuthData2 = this.c;
        this.c = object = ((a0)object).d(string5, accountManager$AuthData2);
        this.s0();
        object = this.c.access_token;
        boolean n10 = TextUtils.isEmpty((CharSequence)object);
        if (!n10) {
            void var8_12;
            long l10 = System.currentTimeMillis() / 1000L;
            accountManager$AuthData2 = this.c;
            long l11 = accountManager$AuthData2.expires_at;
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                boolean bl2 = true;
            } else {
                boolean bl3 = false;
                object = null;
            }
            return (boolean)var8_12;
        }
        return Boolean.FALSE;
    }

    public void p0() {
        i i10 = this.I;
        String string2 = this.y().access_token;
        i10.t(string2);
    }

    public void q0(int n10, boolean bl2) {
        i i10 = this.I;
        String string2 = this.y().access_token;
        i10.u(string2, n10, bl2);
    }

    public void s() {
        this.p.setValue(null);
        MutableLiveData mutableLiveData = this.p;
        Object object = this.K();
        mutableLiveData.setValue(object);
        this.z.setValue("");
        mutableLiveData = this.A;
        object = Boolean.FALSE;
        mutableLiveData.setValue(object);
        this.u.setValue(object);
        this.w.setValue(object);
        this.v.setValue(object);
    }

    public void t() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            timer = null;
            this.f = null;
        }
    }

    public void t0(boolean bl2) {
        MutableLiveData mutableLiveData = this.G;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void u() {
        boolean bl2;
        this.r0();
        Object object = this.M();
        Object object2 = LivePlatform.RTMP;
        if (object == object2) {
            object = this.a0();
            object2 = 3;
            ((MutableLiveData)object).setValue(object2);
            return;
        }
        object = d.v.a.f.c.b.N().i();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((UserInfo)object).getToken())))) {
            object2 = this.n;
            Object object3 = 2;
            ((MutableLiveData)object2).postValue(object3);
            object2 = this.K();
            object3 = this.I;
            String string2 = this.M().getPlatformName();
            String string3 = ((b)object2).l();
            String string4 = ((b)object2).i();
            int n10 = ((b)object2).z();
            int n11 = ((b)object2).g();
            int n12 = ((UserInfo)object).getId();
            String string5 = ((UserInfo)object).getToken();
            String string6 = ((b)object2).d();
            String string7 = this.c.access_token;
            ((i)object3).g(string2, string3, string4, n10, n11, n12, string5, string6, string7);
            return;
        }
        object = this.r;
        object2 = 10002;
        ((MutableLiveData)object).postValue(object2);
    }

    public void u0(String string2) {
        this.z.setValue(string2);
    }

    public void v0(LivePlatform livePlatform) {
        this.b = livePlatform;
    }

    public void w() {
        this.s();
        this.a.clear();
        MutableLiveData mutableLiveData = this.o;
        Constable constable = 0;
        mutableLiveData.setValue(constable);
        mutableLiveData = this.y;
        constable = Boolean.FALSE;
        mutableLiveData.setValue(constable);
    }

    public void w0(int n10) {
        int n11;
        this.k = n10;
        int n12 = 0;
        n10 = n10 != 0 && n10 != (n11 = 2) ? 0 : 1;
        if (n10 == 0) {
            n12 = 3;
        }
        this.l = n12;
    }

    public void x(boolean bl2) {
        Object object = this.n0();
        boolean bl3 = (Boolean)object;
        if (bl3 && !bl2) {
            MutableLiveData mutableLiveData = this.q;
            object = Boolean.TRUE;
            mutableLiveData.postValue(object);
            this.s0();
        } else {
            Object object2 = this.b.getPlatformName();
            object2 = this.v((String)object2);
            object = d.v.a.f.c.b.N();
            z$c z$c = new z$c(this);
            ((d.v.a.f.c.b)object).o((ThirdPlatform)((Object)object2), z$c);
        }
    }

    public void x0(String string2) {
        this.d = string2;
    }

    public AccountManager$AuthData y() {
        return this.c;
    }

    public void y0(int n10) {
        Object object = this.o;
        Integer n11 = n10;
        d.v.e.i.h.g((MutableLiveData)object, n11);
        object = this.a;
        n11 = n10;
        ((ArrayDeque)object).push(n11);
        if (n10 == 0) {
            ArrayDeque arrayDeque = this.a;
            arrayDeque.clear();
        }
    }

    public String z() {
        Application application = this.getApplication();
        String string2 = "clipboard";
        if ((application = ((ClipboardManager)application.getSystemService(string2)).getPrimaryClip()) != null) {
            string2 = null;
            Object object = application.getItemAt(0);
            if (object != null && (object = application.getItemAt(0).getText()) != null) {
                return application.getItemAt(0).getText().toString();
            }
        }
        return "";
    }

    public void z0() {
        Object object = this.a;
        int n10 = ((ArrayDeque)object).size();
        if (n10 > 0) {
            this.a.pop();
            object = this.o;
            Object object2 = this.a.getFirst();
            ((MutableLiveData)object).setValue(object2);
            object = this.y;
            object2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(object2);
            n10 = this.Y();
            int n11 = 2;
            if (n10 < n11) {
                this.s();
            }
        }
    }
}

