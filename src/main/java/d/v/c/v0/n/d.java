/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package d.v.c.v0.n;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import com.zhiyun.cama.camera.data.BeautyData;
import com.zhiyun.cama.camera.data.CameraSet$Beauty;
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.MoreDevice;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.CameraDao;
import com.zhiyun.cama.data.database.model.CameraParam;
import com.zhiyun.protocol.constants.Model;
import d.v.c.v0.n.a;
import d.v.c.v0.n.b;
import d.v.c.v0.n.c;
import d.v.c.v0.n.d$a;
import d.v.c.v0.n.d$b;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.e.f;
import d.v.e.l.c1;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class d {
    private static final String A = "remote_enable";
    private static final String B = "KEY_STORY_SAVE_ALL_VIDEO";
    private static final String C = "KEY_STORY_HIDE_SETTING";
    private static final String D = "KEY_STORY_PERSONAL_NAME";
    private static final String E = "KEY_STORY_PERSONAL_TEMPLATE_ID";
    private static final String F = "KEY_STORY_LIST_TEMPLATE_ID";
    private static final String G = "KEY_STORY_COUNT_DOWN";
    private static final String H = "KEY_STORY_MORE_DEVICE";
    private static final String I = "KEY_CONNECTED_MODEL_CODE";
    private static volatile d J;
    private static final String d = "camera_settings_preference";
    private static final String e = "camera_mode";
    private static final String f = "camera_facing";
    private static final String g = "count_down_time";
    private static final String h = "panorama";
    private static final String i = "camera_grid";
    private static final String j = "camera_frame";
    private static final String k = "gesture_mode";
    private static final String l = "beauty_data";
    private static final String m = "beauty_index";
    private static final String n = "delay_interval";
    private static final String o = "delay_time";
    private static final String p = "click_m_index";
    private static final String q = "zoom_speed";
    private static final String r = "sport_multiple";
    private static final String s = "on_gesture_control";
    private static final String t = "camera_flash";
    private static final String u = "panorama_save";
    private static final String v = "panorama_clone_count";
    private static final String w = "panorama_count_down_time";
    private static final String x = "key_first_enter_into_dynamic_zoom";
    private static final String y = "key_dynamic_zoom_target_model";
    private static final String z = "key_take_photo_mirror";
    private CameraDao a;
    private List b;
    private int c = 0;

    private d() {
        CameraDao cameraDao;
        this.a = cameraDao = DatabaseHelper.getInstance().getDataBase().cameraDao();
    }

    private void B0(String string2, String string3) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(d, 0).edit();
        editor.putString(string2, string3);
        editor.apply();
    }

    private String J(String string2, String string3) {
        return d.v.e.f.a().b().getSharedPreferences(d, 0).getString(string2, string3);
    }

    private /* synthetic */ CameraParam N(int n10, CameraSet$Mode cameraSet$Mode, CameraParam object) {
        if (object == null) {
            int n11;
            Object object2 = this.a.loadCameraParamDataList(n10);
            object = d.v.d.i.g.k.s;
            Object object3 = CameraSet$Mode.live;
            if (cameraSet$Mode == object3) {
                object = d.v.d.i.g.k.r;
            }
            boolean bl2 = true;
            if (object2 != null && (n11 = object2.size()) > 0) {
                int n12 = this.d();
                cameraSet$Mode = this.i(bl2);
                n10 = ((CameraParam)object2.get(0)).getWhiteBalance();
                object3 = new CameraParam(n12, cameraSet$Mode, (k$a)object, n10);
                return object3;
            }
            n11 = this.d();
            cameraSet$Mode = this.i(bl2);
            int n13 = this.c;
            object2 = new CameraParam(n11, cameraSet$Mode, (k$a)object, n13);
            return object2;
        }
        return object;
    }

    private /* synthetic */ void P(CameraParam cameraParam) {
        CameraDao cameraDao = this.a;
        CameraParam[] cameraParamArray = new CameraParam[]{cameraParam};
        cameraDao.insertCameraParam(cameraParamArray);
    }

    private /* synthetic */ void R(CameraParam cameraParam) {
        int n10;
        Iterator iterator2 = this.a;
        int n11 = cameraParam.getFacing();
        iterator2 = iterator2.loadCameraParamDataList(n11);
        n11 = 0;
        int n12 = 1;
        if (iterator2 != null && (n10 = iterator2.size()) > 0) {
            iterator2 = iterator2.iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                CameraParam cameraParam2 = (CameraParam)iterator2.next();
                int n13 = cameraParam.getWhiteBalance();
                cameraParam2.setWhiteBalance(n13);
                CameraDao cameraDao = this.a;
                CameraParam[] cameraParamArray = new CameraParam[n12];
                cameraParamArray[0] = cameraParam2;
                cameraDao.insertCameraParam(cameraParamArray);
            }
        }
        iterator2 = this.a;
        CameraParam[] cameraParamArray = new CameraParam[n12];
        cameraParamArray[0] = cameraParam;
        iterator2.insertCameraParam(cameraParamArray);
    }

    private void V(String string2, boolean bl2) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(d, 0).edit();
        editor.putBoolean(string2, bl2);
        editor.apply();
    }

    private boolean c(String string2, boolean bl2) {
        return d.v.e.f.a().b().getSharedPreferences(d, 0).getBoolean(string2, bl2);
    }

    private CameraSet$Mode i(boolean bl2) {
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.video;
        int n10 = cameraSet$Mode.getId();
        String string2 = e;
        n10 = this.t(string2, n10);
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.fromId(n10);
        if (bl2) {
            return cameraSet$Mode2;
        }
        if (cameraSet$Mode2 != null && (bl2 = cameraSet$Mode2.isSaveEnable())) {
            return cameraSet$Mode2;
        }
        return cameraSet$Mode;
    }

    private void j0(String string2, float f10) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(d, 0).edit();
        editor.putFloat(string2, f10);
        editor.apply();
    }

    private void l0(String string2, int n10) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(d, 0).edit();
        editor.putInt(string2, n10);
        editor.apply();
    }

    private void m0(String string2, long l10) {
        SharedPreferences.Editor editor = d.v.e.f.a().b().getSharedPreferences(d, 0).edit();
        editor.putLong(string2, l10);
        editor.apply();
    }

    private float q(String string2, float f10) {
        return d.v.e.f.a().b().getSharedPreferences(d, 0).getFloat(string2, f10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d s() {
        Object object = J;
        if (object != null) return J;
        object = d.class;
        synchronized (object) {
            d d10 = J;
            if (d10 != null) return J;
            J = d10 = new d();
            return J;
        }
    }

    private int t(String string2, int n10) {
        return d.v.e.f.a().b().getSharedPreferences(d, 0).getInt(string2, n10);
    }

    private long u(String string2, long l10) {
        return d.v.e.f.a().b().getSharedPreferences(d, 0).getLong(string2, l10);
    }

    public boolean A() {
        return this.c(u, false);
    }

    public void A0(boolean bl2) {
        this.V(B, bl2);
    }

    public String B() {
        return this.J(r, "5X");
    }

    public boolean C() {
        return this.c(G, true);
    }

    public void C0(boolean bl2) {
        this.V(z, bl2);
    }

    public boolean D() {
        return this.c(C, false);
    }

    public void D0(int n10) {
        this.l0(q, n10);
    }

    public String E() {
        return this.J(F, "");
    }

    public void E0(List object, List list) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) > 0) {
            this.b = object;
        }
        if (list != null && (n10 = list.size()) > 0) {
            object = (Integer)list.get(0);
            this.c = n10 = ((Integer)object).intValue();
        }
    }

    public MoreDevice F() {
        String string2 = MoreDevice.SMOOTH_Q3.name();
        return MoreDevice.fromName(this.J(H, string2));
    }

    public void F0(CameraParam cameraParam) {
        Executor executor = c1.b().a();
        c c10 = new c(this, cameraParam);
        executor.execute(c10);
    }

    public int G() {
        return this.t(D, 1);
    }

    public String H() {
        return this.J(E, "");
    }

    public boolean I() {
        return this.c(B, false);
    }

    public boolean K() {
        return this.c(z, false);
    }

    public int L() {
        return this.t(q, 0);
    }

    public boolean M() {
        return this.c(x, true);
    }

    public /* synthetic */ CameraParam O(int n10, CameraSet$Mode cameraSet$Mode, CameraParam cameraParam) {
        return this.N(n10, cameraSet$Mode, cameraParam);
    }

    public /* synthetic */ void Q(CameraParam cameraParam) {
        this.P(cameraParam);
    }

    public /* synthetic */ void S(CameraParam cameraParam) {
        this.R(cameraParam);
    }

    public void T(List object) {
        d$a d$a = new d$a(this);
        object = d.v.e.l.q2.c.i(d$a.getType(), (List)object);
        this.B0(l, (String)object);
    }

    public void U(int n10) {
        this.l0(m, n10);
    }

    public void W(int n10) {
        this.l0(f, n10);
    }

    public void X(int n10) {
        this.l0(t, n10);
    }

    public void Y(String string2) {
        this.B0(j, string2);
    }

    public void Z(int n10) {
        this.l0(i, n10);
    }

    public List a() {
        Object object = "";
        Object object2 = this.J(l, (String)object);
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            object = new d$b(this);
            object = ((TypeToken)object).getType();
            object2 = d.v.e.l.q2.c.b((Type)object, object2);
        } else {
            object2 = null;
        }
        if (object2 == null || (n10 = object2.size()) <= 0) {
            object2 = new Object();
            CameraSet$Beauty cameraSet$Beauty = CameraSet$Beauty.OFF;
            object = new BeautyData(cameraSet$Beauty, 0);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.AUTO;
            int n11 = 50;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.SHIN_FACE;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.EXFOLIATING;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.WHITENING;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.EYES_ENLARGED;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.LIGHT;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            cameraSet$Beauty = CameraSet$Beauty.RUDDY;
            object = new BeautyData(cameraSet$Beauty, n11);
            object2.add(object);
            this.T((List)object2);
        }
        return object2;
    }

    public void a0(CameraSet$Mode cameraSet$Mode) {
        int n10 = cameraSet$Mode.getId();
        this.l0(e, n10);
    }

    public int b() {
        return this.t(m, 0);
    }

    public void b0(CameraParam cameraParam) {
        Executor executor = c1.b().a();
        a a10 = new a(this, cameraParam);
        executor.execute(a10);
    }

    public void c0(int n10) {
        this.l0(p, n10);
    }

    public int d() {
        return this.t(f, 0);
    }

    public void d0(Model model) {
        int n10 = model.getCode();
        this.l0(I, n10);
    }

    public int e() {
        return this.t(t, 0);
    }

    public void e0(CameraSet$CountDownTime cameraSet$CountDownTime) {
        int n10 = cameraSet$CountDownTime.getTime();
        this.l0(g, n10);
    }

    public String f() {
        return this.J(j, "1.3333");
    }

    public void f0(CameraSet$DelayInterval cameraSet$DelayInterval) {
        float f10 = cameraSet$DelayInterval.getTime();
        this.j0(n, f10);
    }

    public int g() {
        return this.t(i, 0);
    }

    public void g0(CameraSet$DelayTime cameraSet$DelayTime) {
        float f10 = cameraSet$DelayTime.getTime();
        this.j0(o, f10);
    }

    public CameraSet$Mode h() {
        return this.i(false);
    }

    public void h0(DynamicZoomViewModel$TargetModel dynamicZoomViewModel$TargetModel) {
        int n10 = dynamicZoomViewModel$TargetModel.getValue();
        this.l0(y, n10);
    }

    public void i0(boolean bl2) {
        this.V(x, bl2);
    }

    public LiveData j(int n10, CameraSet$Mode cameraSet$Mode) {
        LiveData liveData = this.a.loadCameraParam(n10, cameraSet$Mode);
        b b10 = new b(this, n10, cameraSet$Mode);
        return Transformations.map(liveData, b10);
    }

    public int k() {
        return this.t(p, 0);
    }

    public void k0(int n10) {
        this.l0(k, n10);
    }

    public Model l() {
        int n10 = Model.SMOOTHX.getCode();
        return Model.from(this.t(I, n10));
    }

    public CameraSet$CountDownTime m() {
        return CameraSet$CountDownTime.fromTime(this.t(g, 0));
    }

    public CameraSet$DelayInterval n() {
        float f10 = CameraSet$DelayInterval.i_least.getTime();
        return CameraSet$DelayInterval.fromTime(this.q(n, f10));
    }

    public void n0(boolean bl2) {
        this.V(s, bl2);
    }

    public CameraSet$DelayTime o() {
        float f10 = CameraSet$DelayTime.t_infinite.getTime();
        return CameraSet$DelayTime.fromTime(this.q(o, f10));
    }

    public void o0(CameraSet$Panorama object) {
        object = object.getText();
        this.B0(h, (String)object);
    }

    public DynamicZoomViewModel$TargetModel p() {
        String string2 = y;
        int n10 = this.t(string2, 0);
        if (n10 == 0) {
            return DynamicZoomViewModel$TargetModel.FAR;
        }
        return DynamicZoomViewModel$TargetModel.NEAR;
    }

    public void p0(int n10) {
        this.l0(v, n10);
    }

    public void q0(boolean bl2) {
        this.V(u, bl2);
    }

    public int r() {
        return this.t(k, 0);
    }

    public void r0(CameraSet$CountDownTime cameraSet$CountDownTime) {
        int n10 = cameraSet$CountDownTime.getTime();
        this.l0(w, n10);
    }

    public void s0(boolean bl2) {
        this.V(A, bl2);
    }

    public void t0(String string2) {
        this.B0(r, string2);
    }

    public void u0(boolean bl2) {
        this.V(G, bl2);
    }

    public boolean v() {
        return this.c(s, false);
    }

    public void v0(boolean bl2) {
        this.V(C, bl2);
    }

    public CameraSet$Panorama w() {
        String string2 = CameraSet$Panorama.P_180.getText();
        return CameraSet$Panorama.fromText(this.J(h, string2));
    }

    public void w0(String string2) {
        this.B0(F, string2);
    }

    public int x() {
        return this.t(v, 3);
    }

    public void x0(MoreDevice object) {
        object = object.name();
        this.B0(H, (String)object);
    }

    public CameraSet$CountDownTime y() {
        return CameraSet$CountDownTime.fromTime(this.t(w, 0));
    }

    public void y0(int n10) {
        this.l0(D, n10);
    }

    public boolean z() {
        return this.c(A, true);
    }

    public void z0(String string2) {
        this.B0(E, string2);
    }
}

