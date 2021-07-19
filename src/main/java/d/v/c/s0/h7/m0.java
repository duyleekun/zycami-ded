/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.c.s0.h7;

import android.util.SparseArray;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.s0.h7.a0;
import d.v.c.s0.h7.b0;
import d.v.c.s0.h7.c0;
import d.v.c.s0.h7.d0;
import d.v.c.s0.h7.e0;
import d.v.c.s0.h7.f0;
import d.v.c.s0.h7.g0;
import d.v.c.s0.h7.m0$a;
import d.v.c.s0.h7.y;
import d.v.c.s0.h7.z;
import d.v.e.h.a;
import d.v.e.h.e;
import d.v.e.i.h;
import d.v.e.l.c1;
import d.v.e.l.s1;
import d.v.j.e.c;
import d.v.j.g.x;
import java.io.File;
import java.lang.constant.Constable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;
import k.d;
import kotlin.io.FilesKt__UtilsKt;

public class m0
extends ViewModel {
    private MutableLiveData a;
    private CameraSet$StoryState b;
    private SparseArray c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MediatorLiveData i;
    private MutableLiveData j;
    private LiveData k;
    public File l;
    public MediatorLiveData m;
    private Long n;
    private Long o;

    public m0() {
        MediatorLiveData mediatorLiveData;
        Object object;
        this.a = object = new MutableLiveData();
        object = CameraSet$StoryState.NONE;
        this.b = object;
        this.c = object;
        this.d = object = new MutableLiveData();
        this.e = object = new MutableLiveData();
        this.f = object = new MutableLiveData();
        this.g = object = new MutableLiveData();
        this.h = object = new MutableLiveData();
        super();
        this.i = object;
        this.j = object = new MutableLiveData();
        this.l = null;
        this.m = mediatorLiveData = new MediatorLiveData();
        this.n = null;
        this.o = null;
        object = d.v.j.e.c.a().g().g1();
        mediatorLiveData = this.m;
        a0 a02 = new a0(this);
        mediatorLiveData.addSource((LiveData)object, a02);
    }

    private /* synthetic */ d.v.h.e.a N(int n10) {
        return (d.v.h.e.a)this.c.valueAt(n10);
    }

    public static /* synthetic */ void Q(d.v.h.e.a object) {
        object = ((d.v.h.e.a)object).e();
        File file = new File((String)object);
        FilesKt__UtilsKt.V(file.getParentFile());
    }

    public static /* synthetic */ void R(TemplateData templateData) {
        d.v.j.e.c.a().r(templateData);
    }

    public static /* synthetic */ long S(Long l10) {
        return l10;
    }

    private /* synthetic */ void T(Long l10) {
        this.n = l10 = d.v.e.h.e.c(l10);
        this.Y();
    }

    private /* synthetic */ void V(TemplatePOJO templatePOJO) {
        MediatorLiveData mediatorLiveData = this.i;
        LiveData liveData = this.k;
        mediatorLiveData.removeSource(liveData);
        d.v.j.g.b0.b(templatePOJO);
        this.i.setValue(templatePOJO);
    }

    public static /* synthetic */ void X(long l10) {
        d.v.j.e.c.a().g().A0(l10, false);
    }

    private void Y() {
        Object object;
        Constable constable = this.o;
        if (constable != null && (object = this.n) != null) {
            long l10;
            object = this.m;
            long l11 = constable;
            long l12 = l11 - (l10 = (constable = this.n).longValue());
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                object2 = 1;
            } else {
                object2 = 0;
                constable = null;
            }
            constable = Boolean.valueOf((boolean)object2);
            ((MutableLiveData)object).setValue(constable);
        }
    }

    public static /* synthetic */ Long b(m0 m02, Long l10) {
        m02.o = l10;
        return l10;
    }

    public static /* synthetic */ void c(m0 m02) {
        m02.Y();
    }

    public MutableLiveData A() {
        return this.g;
    }

    public boolean F() {
        return d.v.e.h.a.d((Boolean)this.g.getValue(), false);
    }

    public SparseArray G() {
        return this.c;
    }

    public void H() {
        d d10 = d.v.j.e.c.a().i().a().d();
        m0$a m0$a = new m0$a(this);
        d10.h(m0$a);
    }

    public boolean I() {
        boolean bl2;
        CameraSet$StoryState cameraSet$StoryState;
        CameraSet$StoryState cameraSet$StoryState2 = this.v();
        if (cameraSet$StoryState2 == (cameraSet$StoryState = CameraSet$StoryState.STORY_DRAFT)) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$StoryState2 = null;
        }
        return bl2;
    }

    public boolean J(CameraSet$Mode enum_, CameraSet$StoryState cameraSet$StoryState) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.story;
        if (cameraSet$Mode == enum_ && cameraSet$StoryState != (enum_ = CameraSet$StoryState.STORY_RECORD)) {
            bl2 = true;
        } else {
            bl2 = false;
            enum_ = null;
        }
        return bl2;
    }

    public boolean K(CameraSet$Mode enum_, CameraSet$StoryState cameraSet$StoryState) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.story;
        if (cameraSet$Mode == enum_ && cameraSet$StoryState == (enum_ = CameraSet$StoryState.STORY_RECORD)) {
            bl2 = true;
        } else {
            bl2 = false;
            enum_ = null;
        }
        return bl2;
    }

    public boolean L(CameraSet$Mode cameraSet$Mode) {
        CameraSet$StoryState cameraSet$StoryState;
        boolean bl2;
        Enum enum_ = CameraSet$Mode.story;
        if (enum_ == cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode = null;
        }
        enum_ = this.b;
        CameraSet$StoryState cameraSet$StoryState2 = CameraSet$StoryState.NONE;
        if (enum_ != cameraSet$StoryState2 && enum_ == (cameraSet$StoryState = this.v())) {
            return bl2;
        }
        if (bl2) {
            enum_ = CameraSet$StoryState.STORY_LIST;
            this.g0((CameraSet$StoryState)enum_);
        } else {
            this.g0(cameraSet$StoryState2);
        }
        return bl2;
    }

    public boolean M(TemplatePOJO templatePOJO) {
        return x.v(templatePOJO);
    }

    public /* synthetic */ d.v.h.e.a P(int n10) {
        return this.N(n10);
    }

    public /* synthetic */ void U(Long l10) {
        this.T(l10);
    }

    public /* synthetic */ void W(TemplatePOJO templatePOJO) {
        this.V(templatePOJO);
    }

    public void Z(String object) {
        boolean bl2 = s1.q((String)object);
        if (bl2) {
            SparseArray sparseArray = this.c;
            int n10 = this.j();
            d.v.h.e.a a10 = new d.v.h.e.a();
            object = a10.l((String)object);
            sparseArray.put(n10, object);
        }
    }

    public void a0(int n10) {
        this.c.remove(n10);
    }

    public void b0() {
        this.c.clear();
        MutableLiveData mutableLiveData = this.d;
        Integer n10 = 0;
        mutableLiveData.setValue(n10);
    }

    public void c0(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public int d(long l10) {
        Object object = this.o();
        if (object == null) {
            return 0;
        }
        Integer n10 = this.j();
        object = ((TemplatePOJO)object).getTemplateVideoList();
        int n11 = n10;
        long l11 = d.v.j.g.b0.h((TemplateVideo)object.get(n11));
        return (int)(l10 * (long)100 / l11);
    }

    public void d0(int n10) {
        MutableLiveData mutableLiveData = this.j;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public void e() {
        int n10 = this.c.size();
        Object object = IntStream.range(0, n10);
        Object object2 = new d0(this);
        object = object.mapToObj(object2).findFirst();
        object2 = b0.a;
        ((Optional)object).ifPresent(object2);
    }

    public void e0(LiveData liveData) {
        Object object;
        LiveData liveData2 = this.k;
        if (liveData2 != null) {
            object = this.i;
            ((MediatorLiveData)object).removeSource(liveData2);
        }
        this.k = liveData;
        liveData2 = this.i;
        object = new z(this);
        ((MediatorLiveData)liveData2).addSource(liveData, (Observer)object);
    }

    public void f(TemplateData templateData) {
        Executor executor = c1.b().a();
        e0 e02 = new e0(templateData);
        executor.execute(e02);
    }

    public void f0(long l10) {
        Executor executor = c1.b().a();
        c0 c02 = new c0(l10);
        executor.execute(c02);
    }

    public int[] g(int n10) {
        int n11;
        Object object = this.o();
        int n12 = 0;
        TemplateVideo templateVideo = null;
        if (object == null) {
            return null;
        }
        object = ((TemplatePOJO)object).getTemplateVideoList();
        if (n10 >= 0 && n10 < (n11 = object.size())) {
            int n13;
            Object object2;
            templateVideo = (TemplateVideo)object.get(n10);
            long l10 = d.v.j.g.b0.h(templateVideo);
            long l11 = 0L;
            if (n10 != 0) {
                object = object.stream();
                l11 = n10;
                object2 = object.limit(l11);
                object = f0.a;
                object2 = object2.map(object);
                object = y.a;
                object2 = object2.mapToLong(object);
                l11 = object2.sum();
                l10 += l11;
            }
            object2 = new int[2];
            long l12 = 1000L;
            object2[0] = n13 = (int)(l11 / l12);
            n12 = (int)(l10 / l12);
            object2[1] = n12;
            return object2;
        }
        return null;
    }

    public void g0(CameraSet$StoryState object) {
        CameraSet$StoryState cameraSet$StoryState;
        this.a.setValue(object);
        this.b = cameraSet$StoryState = this.v();
        cameraSet$StoryState = CameraSet$StoryState.NONE;
        if (object == cameraSet$StoryState) {
            object = this.j;
            cameraSet$StoryState = null;
            ((MutableLiveData)object).setValue(null);
        }
    }

    public void h0(boolean bl2) {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public LiveData i() {
        return this.d;
    }

    public void i0(boolean bl2) {
        MutableLiveData mutableLiveData = this.g;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public int j() {
        return d.v.e.h.d.d((Integer)this.d.getValue(), 0);
    }

    public String k() {
        int n10;
        Object object = this.c;
        String string2 = null;
        if (object != null && (n10 = object.size()) != 0) {
            object = this.c;
            int n11 = this.j();
            if ((object = (d.v.h.e.a)object.get(n11)) != null) {
                string2 = ((d.v.h.e.a)object).e();
            }
        }
        return string2;
    }

    public LiveData l() {
        return this.j;
    }

    public int m() {
        return d.v.e.h.d.d((Integer)this.j.getValue(), -1);
    }

    public LiveData n() {
        return this.i;
    }

    public TemplatePOJO o() {
        return (TemplatePOJO)this.i.getValue();
    }

    public long[] p() {
        Object object = this.o();
        if (object == null) {
            object = new long[0];
        } else {
            object = this.o().getTemplateVideoList().stream();
            g0 g02 = g0.a;
            object = object.mapToLong(g02).toArray();
        }
        return object;
    }

    public int[] r() {
        int n10;
        int[] nArray = new int[]{};
        SparseArray sparseArray = this.c;
        if (sparseArray != null && (n10 = sparseArray.size()) != 0) {
            int n11 = this.c.size();
            nArray = new int[n11];
            for (int i10 = 0; i10 < (n10 = (sparseArray = this.c).size()); ++i10) {
                sparseArray = this.c;
                nArray[i10] = n10 = sparseArray.keyAt(i10);
            }
        }
        return nArray;
    }

    public MutableLiveData s() {
        return this.e;
    }

    public MutableLiveData t() {
        return this.h;
    }

    public MutableLiveData u() {
        return this.a;
    }

    public CameraSet$StoryState v() {
        Object object = this.a.getValue();
        object = object == null ? CameraSet$StoryState.NONE : (CameraSet$StoryState)((Object)this.a.getValue());
        return object;
    }

    public TemplateData w() {
        Object object = this.o();
        object = object == null ? null : this.o().getTemplateData();
        return object;
    }

    public List x() {
        Object object = this.o();
        object = object == null ? null : this.o().getTemplateVideoList();
        return object;
    }

    public LiveData y() {
        return this.f;
    }

    public boolean z() {
        return d.v.e.h.a.d((Boolean)this.f.getValue(), false);
    }
}

