/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.net.Uri
 *  android.view.animation.LinearInterpolator
 */
package d.v.c.s0.h7;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.story.StoryZoom;
import com.zhiyun.cama.camera.story.StoryZoom$Type;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.stabilizer.entities.StoryAxis;
import d.q.a.d;
import d.q.a.d0;
import d.v.c.s0.h7.e;
import d.v.c.s0.h7.f;
import d.v.c.s0.h7.g;
import d.v.c.s0.h7.h;
import d.v.c.s0.h7.h0;
import d.v.c.s0.h7.i;
import d.v.c.s0.h7.j;
import d.v.c.s0.h7.j0;
import d.v.c.s0.h7.k;
import d.v.c.s0.h7.k0$a;
import d.v.c.s0.h7.k0$b;
import d.v.c.s0.h7.k0$d;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.m;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.n;
import d.v.c.s0.h7.n0;
import d.v.c.s0.h7.o;
import d.v.c.s0.h7.p;
import d.v.c.s0.h7.q;
import d.v.c.s0.h7.r;
import d.v.c.s0.h7.s;
import d.v.c.s0.h7.t;
import d.v.c.s0.h7.u;
import d.v.c.s0.h7.u0.l;
import d.v.c.s0.h7.v;
import d.v.c.s0.h7.w;
import d.v.c.s0.h7.x;
import d.v.c.s0.u6;
import d.v.e.l.a2;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.s1;
import e.a.a;
import e.a.b0;
import e.a.c1.b;
import e.a.i0;
import e.a.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class k0 {
    private static final List j;
    private static final String k = "_";
    private static final String l = "tag";
    private final long a;
    private final e.a.s0.a b;
    private final LifecycleOwner c;
    private final m0 d;
    private final l e;
    private final BleViewModel f;
    private final u6 g;
    private final File[] h;
    private boolean i;

    static {
        ArrayList<String> arrayList;
        j = arrayList = new ArrayList<String>(10);
        arrayList.add("SCRIPT_START");
        arrayList.add("SCRIPT_DIR_NAME");
        arrayList.add("SCRIPT_TITLE");
        arrayList.add("SCRIPT_ID");
        arrayList.add("SCRIPT_PART_INDEX");
        arrayList.add("SCRIPT_TAG");
    }

    public k0(LifecycleOwner fileArray, u6 u62, BleViewModel bleViewModel, m0 m02, l l10) {
        e.a.s0.a a10;
        this.a = 50000L;
        this.b = a10 = new e.a.s0.a();
        this.c = fileArray;
        this.f = bleViewModel;
        this.g = u62;
        this.d = m02;
        this.e = l10;
        boolean bl2 = l10.r();
        fileArray = k0.l(m02, bl2);
        this.h = fileArray;
        this.k(m02);
    }

    private /* synthetic */ void A(float f10, float f11, long l10, b0 b02) {
        float[] fArray = new float[]{f10, f11};
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])fArray);
        valueAnimator.setDuration(l10);
        Object object = new LinearInterpolator();
        valueAnimator.setInterpolator((TimeInterpolator)object);
        object = new k(b02);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        object = new k0$b(this, b02);
        valueAnimator.addListener((Animator.AnimatorListener)object);
        object = new t(valueAnimator);
        b02.setCancellable((e.a.v0.f)object);
        valueAnimator.start();
    }

    public static /* synthetic */ void C(b0 b02, ValueAnimator object) {
        object = (Float)object.getAnimatedValue();
        b02.onNext(object);
    }

    public static /* synthetic */ void D(ValueAnimator valueAnimator) {
        boolean bl2 = valueAnimator.isRunning();
        if (bl2) {
            valueAnimator.cancel();
        }
    }

    public static /* synthetic */ Integer E(long l10, Integer n10) {
        long l11 = n10.intValue();
        return (int)(l10 - l11);
    }

    private /* synthetic */ void F(k0$d k0$d, Integer n10) {
        boolean bl2 = this.t();
        if (bl2) {
            int n11 = n10;
            k0$d.e(n11);
        }
    }

    private /* synthetic */ Long H(Integer n10) {
        return (long)n10.intValue() * 50000L;
    }

    private /* synthetic */ void J(StoryAxis storyAxis, StoryZoom storyZoom, e.a.s0.b b10) {
        this.q(storyAxis, storyZoom);
    }

    private /* synthetic */ void L(List storyAxisArray) {
        StoryAxis[] storyAxisArray2 = new StoryAxis[]{};
        storyAxisArray = storyAxisArray.toArray(storyAxisArray2);
        this.f.w1(true, storyAxisArray);
    }

    public static /* synthetic */ void N(k0$d k0$d) {
        k0$d.g(false);
    }

    private /* synthetic */ String O(int n10) {
        return this.o(n10);
    }

    private /* synthetic */ void Q(boolean[] blArray, k0$d k0$d, int n10, boolean bl2) {
        boolean bl3 = blArray[0];
        if (!bl3) {
            k0$d.onCanceled();
            this.j(n10, false, bl2);
        }
    }

    private /* synthetic */ void S(k0$d k0$d) {
        this.i = false;
        this.f.A1();
        k0$d.c();
    }

    public static /* synthetic */ void U(k0$d k0$d, boolean bl2) {
        k0$d.g(bl2);
    }

    private /* synthetic */ void V(long l10) {
        int n10 = this.d.d(l10);
        MutableLiveData mutableLiveData = this.d.t();
        Integer n11 = n10;
        mutableLiveData.postValue(n11);
    }

    private /* synthetic */ e.a.g X(k0$d k0$d, StoryZoom object) {
        Object object2 = ((StoryZoom)object).d;
        StoryZoom$Type storyZoom$Type = StoryZoom$Type.SMOOTHLY;
        if (object2 == storyZoom$Type) {
            float f10 = ((StoryZoom)object).a;
            float f11 = ((StoryZoom)object).b;
            long l10 = ((StoryZoom)object).c;
            object = this.Z(f10, f11, l10);
            k0$d.getClass();
            object2 = new f(k0$d);
            return ((z)object).f2((e.a.v0.g)object2).k3();
        }
        float f12 = ((StoryZoom)object).b;
        k0$d.d(f12);
        return h0.a;
    }

    private z Z(float f10, float f11, long l10) {
        p p10 = new p(this, f10, f11, l10);
        return z.y1(p10);
    }

    public static /* synthetic */ boolean a(k0 k02, boolean bl2) {
        k02.i = bl2;
        return bl2;
    }

    private a a0(k0$d object, long l10, List object2) {
        object2 = this.l0((k0$d)object, (List)object2);
        object = this.d0((k0$d)object, l10);
        e.a.g[] gArray = new e.a.g[]{object2, object};
        return e.a.a.m0(gArray);
    }

    public static /* synthetic */ String b(k0 k02, int n10) {
        return k02.o(n10);
    }

    public static String b0(String string2) {
        String string3 = l;
        boolean bl2 = string2.startsWith(string3);
        if (bl2) {
            String string4 = "";
            string2 = string2.replaceAll(string3, string4);
        } else {
            string2 = null;
        }
        return string2;
    }

    public static /* synthetic */ m0 c(k0 k02) {
        return k02.d;
    }

    private a c0(k0$d k0$d, long l10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Object object = this;
        object = this.f(l10, 1L, timeUnit);
        d.v.c.s0.h7.l l11 = new d.v.c.s0.h7.l(l10);
        z z10 = ((z)object).H3(l11);
        Object object2 = e.a.q0.c.a.c();
        z10 = z10.i4((e.a.h0)object2);
        object2 = new u(this, k0$d);
        return z10.f2((e.a.v0.g)object2).k3();
    }

    private boolean d(List list, List object) {
        object = (Boolean)this.f.L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            return true;
        }
        object = this.f.x();
        float f10 = this.f.w();
        return d.v.c.s0.h7.u0.l.t(list, (Model)((Object)object), f10);
    }

    private a d0(k0$d object, long l10) {
        long l11 = l10 / 50000L;
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        object = this.f(l11, 50000L, timeUnit);
        e.a.v0.o o10 = new r(this);
        object = ((z)object).H3(o10);
        o10 = new m(this);
        object = ((z)object).E2(o10);
        Object object2 = this.k0(l10);
        object = ((a)object).n((e.a.g)object2);
        object2 = TimeUnit.MILLISECONDS;
        return ((a)object).H(100, (TimeUnit)((Object)object2));
    }

    public static Uri e(Context context, File object) {
        boolean bl2 = s1.p((File)object);
        if (!bl2) {
            return null;
        }
        Uri uri = k2.A(((File)object).getName());
        boolean bl3 = s1.Q(uri);
        if (bl3) {
            return uri;
        }
        boolean bl4 = s1.c(context, (String)(object = ((File)object).getPath()), uri);
        if (bl4) {
            a2.a(context, uri);
            return uri;
        }
        return null;
    }

    public static String[] e0(String string2) {
        return string2.split(k);
    }

    private z f(long l10, long l11, TimeUnit timeUnit) {
        z z10 = z.p3(0L, l10, 0L, l11, timeUnit);
        e e10 = d.v.c.s0.h7.e.a;
        return z10.H3(e10);
    }

    private a f0(k0$d object, int n10, boolean bl2, long l10) {
        e.a.g[] gArray = new e.a.g[]{object = this.c0((k0$d)object, l10), object = this.i(n10, bl2)};
        object = e.a.a.m0(gArray);
        Object object2 = e.a.c1.b.d();
        object = ((a)object).M0((e.a.h0)object2);
        object2 = e.a.c1.b.d();
        object = ((a)object).t0((e.a.h0)object2);
        object2 = TimeUnit.SECONDS;
        e.a.h0 h02 = e.a.c1.b.a();
        return ((a)object).I(1L, (TimeUnit)((Object)object2), h02);
    }

    private static File g() {
        String string2 = Long.toString(System.currentTimeMillis());
        File file = k2.O();
        File file2 = new File(file, string2);
        return file2;
    }

    private static File h(boolean bl2, File file, String object, String charSequence, long l10, int n10) {
        String string2;
        int n11 = 6;
        String[] stringArray = new String[n11];
        String string3 = bl2 ? "track_mode" : "script";
        stringArray[0] = string3;
        stringArray[1] = string2 = file.getName();
        stringArray[2] = object;
        object = String.valueOf(l10);
        stringArray[3] = object;
        object = Integer.toString(n10);
        stringArray[4] = object;
        stringArray[5] = charSequence;
        string3 = k0.v(stringArray);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(".mp4");
        string3 = ((StringBuilder)charSequence).toString();
        object = new File(file, string3);
        return object;
    }

    private a i(int n10, boolean bl2) {
        w w10 = new w(this, n10, bl2);
        return e.a.a.X(w10);
    }

    private String j(int n10, boolean bl2, boolean bl3) {
        File[] fileArray = this.h;
        File file = fileArray[n10];
        if (bl3) {
            File file2;
            String string2 = file.getPath();
            s1.h(string2);
            if (!bl2 && (bl3 = s1.O(file2 = file.getParentFile()))) {
                s1.g(file2);
            }
        }
        return file.getPath();
    }

    private a j0(k0$d k0$d, boolean bl2) {
        v v10 = new v(k0$d, bl2);
        return e.a.a.X(v10);
    }

    private void k(m0 object) {
        ArrayList arrayList;
        int n10;
        object = ((m0)object).o();
        Collector collector = ((TemplatePOJO)object).getScriptTrackPOJOList();
        object = ((TemplatePOJO)object).getTemplateVideoList();
        int n11 = object.size();
        if (collector == null) {
            n10 = 0;
            collector = null;
            arrayList = new ArrayList();
        } else {
            int n12 = collector.size();
            arrayList = collector;
            n10 = n12;
        }
        if (n10 == n11) {
            return;
        }
        d.v.j.e.i.c1 c12 = d.v.j.e.i.c1.z(c1.b());
        collector = IntStream.range(n10, n11);
        h h10 = new h(c12, (List)object);
        object = collector.mapToObj(h10);
        collector = Collectors.toList();
        object = object.collect(collector);
        arrayList.addAll(object);
    }

    private a k0(long l10) {
        i i10 = new i(this, l10);
        return e.a.a.X(i10);
    }

    private static File[] l(m0 object, boolean bl2) {
        Object object2 = ((m0)object).o();
        List list = ((m0)object).x();
        int n10 = l0.d((TemplatePOJO)object2);
        String string2 = k0.p(n10);
        long l10 = l0.b(n10, (TemplatePOJO)object2);
        object2 = ((TemplatePOJO)object2).getTemplateData().showTitle();
        File[] fileArray = " ";
        Object object3 = "";
        object2 = ((String)object2).replaceAll((String)fileArray, (String)object3);
        int n11 = list.size();
        n10 = (int)(k0.r((m0)object) ? 1 : 0);
        object = n10 != 0 ? ((m0)object).l : k0.g();
        fileArray = new File[n11];
        object3 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            fileArray[i10] = object3 = k0.h(bl2, (File)object, (String)object2, string2, l10, i10);
        }
        return fileArray;
    }

    private a l0(k0$d k0$d, List object) {
        object = z.W2((Iterable)object);
        n n10 = new n(this, k0$d);
        return ((z)object).V0(n10);
    }

    public static int m(String string2) {
        return j.indexOf(string2);
    }

    public static Pair n(m0 object, l object2) {
        int n10;
        boolean bl2;
        int bl3 = ((m0)object).j();
        Object object3 = bl3;
        object = ((m0)object).o();
        object = ((l)object2).o((TemplatePOJO)object);
        object2 = null;
        if (object != null && !(bl2 = (object = ((TemplatePOJO)object).getScriptTrackPOJOList()).isEmpty()) && (object = (ScriptTrackPOJO)object.get(n10 = ((Integer)object3).intValue())) != null) {
            object3 = n0.g(((ScriptTrackPOJO)object).getScriptTrackPointList());
            object = n0.h(((ScriptTrackPOJO)object).getScriptTrackPointList());
            bl2 = object3.isEmpty();
            if (bl2) {
                object3 = Boolean.FALSE;
            } else {
                boolean bl4 = ((j0)object3.get((int)0)).a;
                object3 = bl4;
            }
            bl2 = object.isEmpty();
            if (!bl2) {
                object = (StoryZoom)object.get(0);
                float f10 = ((StoryZoom)object).b;
                object2 = Float.valueOf(f10);
            }
            object = object2;
            object2 = object3;
        } else {
            object = null;
            float f11 = 0.0f;
        }
        return Pair.create(object2, object);
    }

    private String o(int n10) {
        File file = this.h[n10];
        s1.c0(file.getParentFile());
        return file.getPath();
    }

    private static String p(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l);
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private void q(StoryAxis storyAxis, StoryZoom object) {
        object = this.f;
        StoryAxis[] storyAxisArray = new StoryAxis[]{storyAxis};
        ((BleViewModel)object).w1(false, storyAxisArray);
    }

    private static boolean r(m0 m02) {
        return m02.I();
    }

    public static boolean s(int n10) {
        List list;
        int n11 = 5;
        n10 = n10 != n11 && n10 != (n11 = (list = j).size()) ? 0 : 1;
        return n10 != 0;
    }

    private boolean t() {
        return d.v.e.h.a.d((Boolean)this.g.A0().getValue(), true);
    }

    private static String v(String ... stringArray) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            String string2 = stringArray[i10];
            stringBuilder.append(string2);
            n10 = stringArray.length + -1;
            if (i10 >= n10) continue;
            string2 = k;
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ a w(k0 k02, long l10) {
        return k02.k0(l10);
    }

    private /* synthetic */ void x(int n10, boolean bl2) {
        this.j(n10, true, bl2);
    }

    public static /* synthetic */ ScriptTrackPOJO z(d.v.j.e.i.c1 object, List list, int n10) {
        object = ((d.v.j.e.i.c1)object).a();
        List list2 = ((ScriptTrackPOJO)object).getScriptTrackPointList();
        long l10 = d.v.j.g.b0.h((TemplateVideo)list.get(n10)) / 1000L;
        ScriptTrackPoint scriptTrackPoint = new ScriptTrackPoint("unmove", l10);
        list2.add(scriptTrackPoint);
        return object;
    }

    public /* synthetic */ void B(float f10, float f11, long l10, b0 b02) {
        this.A(f10, f11, l10, b02);
    }

    public /* synthetic */ void G(k0$d k0$d, Integer n10) {
        this.F(k0$d, n10);
    }

    public /* synthetic */ Long I(Integer n10) {
        return this.H(n10);
    }

    public /* synthetic */ void K(StoryAxis storyAxis, StoryZoom storyZoom, e.a.s0.b b10) {
        this.J(storyAxis, storyZoom, b10);
    }

    public /* synthetic */ void M(List list) {
        this.L(list);
    }

    public /* synthetic */ String P(int n10) {
        return this.O(n10);
    }

    public /* synthetic */ void R(boolean[] blArray, k0$d k0$d, int n10, boolean bl2) {
        this.Q(blArray, k0$d, n10, bl2);
    }

    public /* synthetic */ void T(k0$d k0$d) {
        this.S(k0$d);
    }

    public /* synthetic */ void W(long l10) {
        this.V(l10);
    }

    public /* synthetic */ e.a.g Y(k0$d k0$d, StoryZoom storyZoom) {
        return this.X(k0$d, storyZoom);
    }

    public boolean g0(int n10, boolean bl2, int n11, long l10, k0$d k0$d) {
        Object object;
        int n12;
        k0 k02 = this;
        int n13 = n10;
        long l11 = l10;
        k0$d k0$d2 = k0$d;
        Object object2 = this.d;
        int n14 = ((m0)object2).j();
        if (n14 != n10) {
            object2 = this.d;
            ((m0)object2).c0(n10);
        }
        object2 = k02.e;
        Object object3 = k02.d.o();
        object2 = ((l)object2).p((TemplatePOJO)object3, l11);
        object3 = k02.d.x();
        int n15 = k02.d((List)(object2 = ((TemplatePOJO)object2).getScriptTrackPOJOList()), (List)object3);
        if (n15 == 0) {
            return false;
        }
        object3 = (TemplateVideo)object3.get(n13);
        object2 = (ScriptTrackPOJO)object2.get(n13);
        Object object4 = ((ScriptTrackPOJO)object2).getScriptTrackPointList();
        Object object5 = n0.g((List)object4);
        Object object6 = n0.h(((ScriptTrackPOJO)object2).getScriptTrackPointList());
        Object object7 = object2 = object5.remove(0);
        object7 = (StoryAxis)object2;
        n14 = (int)(object6.isEmpty() ? 1 : 0);
        if (n14 != 0) {
            n14 = 0;
            object2 = null;
        } else {
            object2 = (StoryZoom)object6.remove(0);
        }
        Object object8 = object2;
        long l12 = d.v.j.g.b0.h((TemplateVideo)object3);
        long l13 = 0L;
        n15 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        if (n15 >= 0) {
            l12 = Math.min(l12, l11);
        }
        l13 = l12;
        boolean bl3 = true;
        object4 = new boolean[bl3];
        object4[0] = false;
        if (n11 >= 0) {
            n12 = n11;
        } else if (object7 != null) {
            l11 = ((StoryAxis)object7).wait;
            l12 = 1000L;
            n12 = (int)(l11 /= l12);
        } else {
            n12 = 0;
            object = null;
        }
        l12 = n12;
        object = this;
        Object object9 = k0$d;
        n14 = n10;
        object = this.f0(k0$d, n10, bl2, l12);
        object9 = new j(k02, (StoryAxis)object7, (StoryZoom)object8);
        object = ((a)object).T((e.a.v0.g)object9);
        object9 = e.a.q0.c.a.c();
        object = ((a)object).t0((e.a.h0)object9);
        object9 = k02.j0(k0$d2, bl3);
        object = ((a)object).n((e.a.g)object9);
        object9 = new s(k02, (List)object5);
        object = ((a)object).O((e.a.v0.a)object9);
        object9 = k02.a0(k0$d2, l13, (List)object6);
        object = ((a)object).n((e.a.g)object9);
        object9 = e.a.q0.c.a.c();
        object = ((a)object).t0((e.a.h0)object9);
        object9 = new g(k0$d2);
        object = ((a)object).O((e.a.v0.a)object9);
        object9 = e.a.c1.b.d();
        object = ((a)object).t0((e.a.h0)object9);
        object9 = new o(k02, n13);
        object = ((a)object).a1((Callable)object9);
        object9 = e.a.q0.c.a.c();
        object5 = ((i0)object).O0((e.a.h0)object9);
        object = object6;
        object9 = this;
        object2 = object4;
        object3 = k0$d;
        n15 = n10;
        object6 = new x(this, (boolean[])object4, k0$d, n10, bl2);
        object = ((i0)object5).X((e.a.v0.a)object6);
        object9 = new q(k02, k0$d2);
        object = ((i0)object).W((e.a.v0.a)object9);
        object9 = d.q.a.d.a(d.q.a.f0.f.b.h(k02.c));
        object5 = object = ((i0)object).o((e.a.j0)object9);
        object5 = (d0)object;
        object = object6;
        object9 = this;
        object2 = k0$d;
        object6 = new k0$a(this, k0$d, n10, (boolean[])object4, bl2);
        object = (e.a.s0.b)((Object)object5.h((e.a.l0)object6));
        k02.b.b((e.a.s0.b)object);
        return bl3;
    }

    public boolean h0(k0$d k0$d) {
        Integer n10 = this.d.j();
        int n11 = n10;
        int n12 = this.t();
        n12 = n12 != 0 ? -1 : 1;
        return this.g0(n11, true, n12, -1, k0$d);
    }

    public void i0() {
        this.b.e();
    }

    public boolean u() {
        return this.i;
    }

    public /* synthetic */ void y(int n10, boolean bl2) {
        this.x(n10, bl2);
    }
}

