/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.graphics.Color
 *  android.text.TextUtils
 *  android.util.SparseArray
 */
package d.v.c.i1;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.SpeedUseCase;
import com.zhiyun.editorsdk.TransitionUseCase;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import com.zhiyun.editorsdk.decoration.StickerUseCase;
import com.zhiyun.editorsdk.decoration.TextUseCase;
import com.zhiyun.editorsdk.draft.DraftUseCase;
import com.zhiyun.editorsdk.frame.FrameEffectUseCase;
import com.zhiyun.editorsdk.frame.FrameSizeUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase;
import com.zhiyun.editorsdk.fundation.IUseCase;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editorsdk.fundation.UseCases;
import com.zhiyun.editorsdk.voice.MusicUseCase;
import com.zhiyun.editorsdk.voice.RecordUseCase;
import com.zhiyun.editorsdk.voice.VoiceUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.d0;
import d.v.c.i1.g1;
import d.v.c.i1.h1;
import d.v.c.i1.i2$b;
import d.v.c.i1.i2$c;
import d.v.c.i1.i2$d;
import d.v.c.i1.j1;
import d.v.c.i1.k2;
import d.v.c.i1.n1;
import d.v.c.m0;
import d.v.c.u1.m.a1;
import d.v.e.c;
import d.v.e.c$a;
import d.v.e.f;
import d.v.e.h.a;
import d.v.e.i.j;
import d.v.e.l.o1;
import d.v.e.l.s1;
import d.v.h.d.d$a;
import d.v.h.e.d;
import d.v.h.e.e;
import d.v.h.h.a$a;
import d.v.h.k.b;
import d.v.v.g.g;
import d.v.v.q.h;
import e.a.f0;
import e.a.i0;
import e.a.p0;
import e.a.z;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class i2
extends AndroidViewModel {
    private static final int U = 150;
    public static final long V = 1000L;
    public static final long W = 10L;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int a0 = 0;
    public static final int b0 = 1;
    public static final int c0 = 2;
    public static final int d0 = 3;
    public static final int e0 = 4;
    public static final int f0 = 5;
    private MutableLiveData A;
    private MutableLiveData B;
    private MutableLiveData C;
    private MutableLiveData D;
    private j E;
    private a1 F;
    public final MainUseCase G;
    private EditorUseCase H;
    private VoiceUseCase I;
    private MusicUseCase J;
    private RecordUseCase K;
    private SpeedUseCase L;
    private FrameSizeUseCase M;
    private FrameEffectUseCase N;
    private TextUseCase O;
    private StickerUseCase P;
    private TransitionUseCase Q;
    private DraftUseCase R;
    private d.v.h.e.b S;
    private c$a T;
    private e.a.s0.a a;
    private j b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;
    private MutableLiveData j;
    private MutableLiveData k;
    private j l;
    private MutableLiveData m;
    private MutableLiveData n;
    private MutableLiveData o;
    private j p;
    private MutableLiveData q;
    private MutableLiveData r;
    private MutableLiveData s;
    private MutableLiveData t;
    private MutableLiveData u;
    private MutableLiveData v;
    private MutableLiveData w;
    private final MutableLiveData x;
    private final MutableLiveData y;
    private MutableLiveData z;

    public i2(Application object) {
        super((Application)object);
        super();
        this.a = object;
        super();
        this.b = object;
        Object object2 = Boolean.FALSE;
        super(object2);
        this.c = object;
        super(object2);
        this.d = object;
        super(object2);
        this.e = object;
        super(object2);
        this.f = object;
        Boolean bl2 = Boolean.TRUE;
        super(bl2);
        this.g = object;
        super(object2);
        this.h = object;
        super(bl2);
        this.i = object;
        super(bl2);
        this.j = object;
        super(bl2);
        this.k = object;
        super();
        this.l = object;
        Number number = 0L;
        super(number);
        this.m = object;
        super();
        this.n = object;
        number = Float.valueOf(0.0f);
        super(number);
        this.o = object;
        super();
        this.p = object;
        number = -1;
        super(number);
        this.q = object;
        super();
        this.r = object;
        super();
        this.s = object;
        super();
        this.t = object;
        super();
        this.u = object;
        super();
        this.v = object;
        super();
        this.w = object;
        super();
        this.x = object;
        super();
        this.y = object;
        super(object2);
        this.z = object;
        super(bl2);
        this.A = object;
        super(object2);
        this.B = object;
        super(object2);
        this.C = object;
        super("");
        this.D = object;
        super();
        this.E = object;
        super(this);
        this.S = object;
        super(this);
        this.T = object;
        super();
        this.G = object;
        this.y3();
        object = d.v.e.c.b();
        object2 = this.T;
        ((c)object).a((c$a)object2);
    }

    private void V2() {
        Object object = this.R;
        if (object == null) {
            return;
        }
        boolean bl2 = this.A0();
        if (bl2) {
            object = this.R;
            long l10 = this.F.w().getDraft().getDraftId();
            object = ((DraftUseCase)object).b(l10);
            Object object2 = new g1(this);
            object = ((i0)object).a0((e.a.v0.g)object2);
            object2 = d.v.e.k.e.f();
            object = ((i0)object).s((p0)object2);
            ((i0)object).a();
        } else {
            long l11 = 0L;
            this.z3(l11);
        }
    }

    private void W3() {
        boolean bl2 = this.A0();
        if (bl2) {
            Object object = this.F;
            Object object2 = this.G;
            ((a1)object).h((MainUseCase)object2);
            object = this.r;
            object2 = this.F.B();
            d.v.e.i.h.e((MutableLiveData)object, object2);
            object = this.v;
            object2 = this.F.A();
            d.v.e.i.h.e((MutableLiveData)object, object2);
            object = this.t;
            object2 = this.F.C();
            d.v.e.i.h.e((MutableLiveData)object, object2);
            object = this.u;
            object2 = this.F.E();
            d.v.e.i.h.e((MutableLiveData)object, object2);
            object = this.s;
            boolean bl3 = this.F.D();
            object2 = bl3;
            d.v.e.i.h.e((MutableLiveData)object, object2);
            object = this.b;
            object2 = Boolean.TRUE;
            d.v.e.i.h.e((MutableLiveData)object, object2);
        }
    }

    public static /* synthetic */ MutableLiveData b(i2 i22) {
        return i22.x;
    }

    public static /* synthetic */ MutableLiveData c(i2 i22) {
        return i22.y;
    }

    private void c4() {
        List list = this.C1();
        int n10 = list.size();
        int n11 = 0;
        int n12 = 1;
        if (n10 <= n12) {
            this.N3(false, false);
            return;
        }
        n10 = this.S0();
        int n13 = n10 > 0 ? n12 : 0;
        List list2 = this.C1();
        int n14 = list2.size() - n12;
        if (n10 < n14) {
            n11 = n12;
        }
        this.N3(n13 != 0, n11 != 0);
    }

    public static /* synthetic */ j d(i2 i22) {
        return i22.p;
    }

    public static /* synthetic */ MutableLiveData e(i2 i22) {
        return i22.m;
    }

    public static /* synthetic */ MutableLiveData f(i2 i22) {
        return i22.n;
    }

    private void f2() {
        Object object = (VoiceUseCase)this.G.K(VoiceUseCase.class);
        this.I = object;
        object = (MusicUseCase)this.G.K(MusicUseCase.class);
        this.J = object;
        object = (RecordUseCase)this.G.K(RecordUseCase.class);
        this.K = object;
        object = (SpeedUseCase)this.G.K(SpeedUseCase.class);
        this.L = object;
        object = (FrameSizeUseCase)this.G.K(FrameSizeUseCase.class);
        this.M = object;
        object = (FrameEffectUseCase)this.G.K(FrameEffectUseCase.class);
        this.N = object;
        object = (TextUseCase)this.G.K(TextUseCase.class);
        this.O = object;
        object = (StickerUseCase)this.G.K(StickerUseCase.class);
        this.P = object;
        object = (TransitionUseCase)this.G.K(TransitionUseCase.class);
        this.Q = object;
        this.R = object = new DraftUseCase();
    }

    public static /* synthetic */ void g(i2 i22) {
        i22.c4();
    }

    public static /* synthetic */ void i(i2 i22) {
        i22.f2();
    }

    public static /* synthetic */ void j(i2 i22) {
        i22.W3();
    }

    public static /* synthetic */ void k(i2 i22) {
        i22.V2();
    }

    public static /* synthetic */ MutableLiveData l(i2 i22) {
        return i22.d;
    }

    public static /* synthetic */ MutableLiveData m(i2 i22) {
        return i22.o;
    }

    public static /* synthetic */ j n(i2 i22) {
        return i22.l;
    }

    public static /* synthetic */ String[] n2(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ MutableLiveData o(i2 i22) {
        return i22.w;
    }

    private /* synthetic */ void o2() {
        k2 k22 = k2.e();
        boolean bl2 = k22.b();
        if (bl2) {
            return;
        }
        k2.e().j(true);
        this.z3(0x40000000L);
        this.x2(3);
    }

    private /* synthetic */ void q2(int n10, boolean bl2, Long l10) {
        this.E3(n10);
        n10 = bl2 ^ 1;
        this.O3(n10 != 0);
    }

    private /* synthetic */ void s2(e.a.s0.b object) {
        object = this.F.w().clone();
        this.W2((TemplatePOJO)object, 0L, true);
    }

    private void y3() {
        EditorUseCase editorUseCase;
        this.H = editorUseCase = this.G.G();
        i2$c i2$c = new i2$c(this);
        editorUseCase.h(i2$c);
    }

    public boolean A(int n10) {
        TransitionUseCase transitionUseCase = this.Q;
        boolean bl2 = UseCases.b(transitionUseCase);
        if (bl2) {
            return false;
        }
        return this.Q.g(n10);
    }

    public boolean A0() {
        boolean bl2;
        a1 a12 = this.F;
        if (a12 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            a12 = null;
        }
        return bl2;
    }

    public boolean A1() {
        boolean bl2;
        Object object = this.z.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.z.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void A2() {
        this.G.X();
        this.I3();
    }

    public void A3(long l10, Consumer consumer) {
        DraftUseCase draftUseCase;
        MainUseCase mainUseCase = this.G;
        boolean bl2 = mainUseCase.R();
        if (bl2 && (draftUseCase = this.R) != null) {
            List list = this.C1();
            mainUseCase = this.G;
            long l11 = mainUseCase.J();
            int n10 = this.C0();
            boolean bl3 = this.n1();
            boolean bl4 = this.p1();
            boolean bl5 = this.u1();
            int n11 = this.j1();
            float f10 = this.i1();
            boolean bl6 = this.q1();
            boolean bl7 = this.s1();
            d.v.h.f.a a10 = this.h1();
            List list2 = this.H1();
            List list3 = this.O1();
            List list4 = this.Z1();
            List list5 = this.b2();
            boolean bl8 = this.w1();
            int n12 = this.k1();
            draftUseCase.v(l10, list, l11, n10, bl3, bl4, bl5, n11, f10, bl6, bl7, a10, list2, list3, list4, list5, bl8, n12, consumer);
        }
    }

    public List B0() {
        Object object = this.P;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.P.i();
        return object;
    }

    public double B1() {
        double d10;
        SpeedUseCase speedUseCase = this.L;
        boolean bl2 = UseCases.b(speedUseCase);
        if (bl2) {
            d10 = 1.0;
        } else {
            speedUseCase = this.L;
            int n10 = this.S0();
            d10 = speedUseCase.j(n10);
        }
        return d10;
    }

    public void B2() {
        this.G.Y();
        this.I3();
    }

    public boolean B3() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (!bl2 && !(bl2 = (recordUseCase = this.K).r())) {
            recordUseCase = this.K;
            File file = d.v.c.d0.b(EditConfig$ResourceType.RECORD);
            long l10 = this.G.E();
            return recordUseCase.y(file, l10);
        }
        return false;
    }

    public int C0() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n10 = UseCases.b(frameSizeUseCase);
        if (n10 != 0) {
            n10 = 0;
            frameSizeUseCase = null;
        } else {
            frameSizeUseCase = this.M;
            n10 = frameSizeUseCase.k();
        }
        return n10;
    }

    public List C1() {
        return this.G.H();
    }

    public void C2() {
        int n10 = this.S0();
        if (n10 == 0) {
            return;
        }
        this.G.Z();
        this.I3();
        this.b4();
    }

    public boolean C3() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.z();
    }

    public float D0(int n10, boolean bl2) {
        float f10 = bl2 ? this.I1(n10) : this.P1(n10);
        return f10;
    }

    public float D1() {
        float f10;
        boolean bl2;
        Object object = this.s.getValue();
        if (object == null) {
            bl2 = false;
            f10 = 0.0f;
            object = null;
        } else {
            object = (Boolean)this.s.getValue();
            bl2 = (Boolean)object;
        }
        f10 = bl2 ? this.i1() : this.O0();
        return f10;
    }

    public boolean D2() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.t();
    }

    public void D3(boolean bl2) {
        MutableLiveData mutableLiveData = this.G0();
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public MutableLiveData E0() {
        return this.f;
    }

    public float E1(int n10) {
        float f10;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            voiceUseCase = this.I;
            f10 = voiceUseCase.h(n10);
        }
        return f10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean E2() {
        void var2_8;
        void var2_4;
        Object object = this.r.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var2_4 != false) {
            boolean bl3 = this.G2();
        } else {
            int n10 = this.S0();
            boolean bl4 = this.F2(n10);
        }
        return (boolean)var2_8;
    }

    public void E3(int n10) {
        Boolean bl2 = Boolean.TRUE;
        MutableLiveData mutableLiveData = this.J0();
        Boolean bl3 = Boolean.FALSE;
        d.v.e.i.h.g(mutableLiveData, bl3);
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    MutableLiveData mutableLiveData2 = this.I0();
                    d.v.e.i.h.g(mutableLiveData2, bl3);
                }
            } else {
                MutableLiveData mutableLiveData3 = this.I0();
                d.v.e.i.h.g(mutableLiveData3, bl2);
            }
        } else {
            MutableLiveData mutableLiveData4 = this.J0();
            d.v.e.i.h.g(mutableLiveData4, bl2);
        }
    }

    public boolean F() {
        long l10;
        long l11;
        long l12;
        int n10 = this.H0();
        n10 = n10 != 0 && (n10 = (l12 = (l11 = this.d2()) - (l10 = 1800000000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public MutableLiveData F0() {
        return this.e;
    }

    public long F1(int n10) {
        long l10;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            l10 = 0L;
        } else {
            voiceUseCase = this.I;
            l10 = voiceUseCase.j(n10);
        }
        return l10;
    }

    public boolean F2(int n10) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameEffectUseCase = this.N).k(n10, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public void F3(DecorationType object, boolean n10, boolean bl2) {
        int[] nArray = i2$d.a;
        int n11 = ((Enum)object).ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12 && n11 != (n12 = 2)) {
            n10 = 3;
            if ((n11 == n10 || n11 == (n10 = 4)) && (n11 = (int)(UseCases.b((IUseCase)(object = this.P)) ? 1 : 0)) == 0) {
                if (bl2) {
                    object = this.P;
                    ((StickerUseCase)object).k();
                } else {
                    object = this.P;
                    ((StickerUseCase)object).q();
                }
            }
        } else {
            object = this.O;
            n11 = (int)(UseCases.b((IUseCase)object) ? 1 : 0);
            if (n11 == 0) {
                if (n10 != 0) {
                    object = this.O;
                    ((TextUseCase)object).j();
                } else {
                    object = this.O;
                    ((TextUseCase)object).o();
                }
            }
        }
    }

    public boolean G() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.h();
    }

    public MutableLiveData G0() {
        return this.c;
    }

    public long G1(int n10) {
        long l10;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            l10 = 0L;
        } else {
            voiceUseCase = this.I;
            l10 = voiceUseCase.k(n10);
        }
        return l10;
    }

    public boolean G2() {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        boolean bl3 = true;
        if (bl2 || !(bl2 = (frameEffectUseCase = this.N).l(bl3))) {
            bl3 = false;
        }
        return bl3;
    }

    public boolean G3() {
        boolean bl2;
        Object object = this.r.getValue();
        boolean bl3 = false;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            bl2 = (Boolean)object;
        }
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl4 = UseCases.b(frameEffectUseCase);
        if (!bl4 && (bl2 = (frameEffectUseCase = this.N).s(bl2))) {
            bl3 = true;
        }
        return bl3;
    }

    public void H() {
        this.G.m();
    }

    public boolean H0() {
        boolean bl2;
        Object object = this.G0().getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.G0().getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public List H1() {
        Object object = this.J;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.J.m();
        return object;
    }

    public void H2() {
        int n10;
        long l10;
        Object object = this.P;
        int n11 = UseCases.b((IUseCase)object);
        if (n11 != 0) {
            return;
        }
        object = this.Z1();
        n11 = DecorationUseCases.b((List)object, l10 = this.U0());
        if (n11 == (n10 = -1)) {
            return;
        }
        this.P.m(n11);
    }

    public boolean H3() {
        boolean bl2;
        Object object = this.v.getValue();
        boolean bl3 = false;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.v.getValue();
            bl2 = (Boolean)object;
        }
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl4 = UseCases.b(frameEffectUseCase);
        if (!bl4 && (bl2 = (frameEffectUseCase = this.N).t(bl2))) {
            bl3 = true;
        }
        return bl3;
    }

    public void I() {
        this.G.n();
    }

    public MutableLiveData I0() {
        return this.h;
    }

    public float I1(int n10) {
        float f10;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            voiceUseCase = this.I;
            f10 = voiceUseCase.l(n10);
        }
        return f10;
    }

    public void I2(int n10) {
        StickerUseCase stickerUseCase = this.P;
        int n11 = UseCases.b(stickerUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = -1;
        if (n10 == n11) {
            return;
        }
        this.P.m(n10);
    }

    public void I3() {
        MutableLiveData mutableLiveData = this.x1();
        Boolean bl2 = this.G.S();
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    public boolean J(int n10, String string2) {
        return this.K(n10, string2, true);
    }

    public MutableLiveData J0() {
        return this.g;
    }

    public MutableLiveData J1() {
        return this.k;
    }

    public void J2() {
        int n10 = this.a2();
        this.K2(n10);
    }

    public boolean J3() {
        boolean bl2;
        Object object = this.s.getValue();
        boolean bl3 = false;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.s.getValue();
            bl2 = (Boolean)object;
        }
        VoiceUseCase voiceUseCase = this.I;
        boolean bl4 = UseCases.b(voiceUseCase);
        if (!bl4 && (bl2 = (voiceUseCase = this.I).s(bl2))) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean K(int n10, String string2, boolean bl2) {
        SpeedUseCase speedUseCase = this.L;
        boolean bl3 = UseCases.b(speedUseCase);
        if (bl3) {
            return false;
        }
        speedUseCase = this.L;
        if ((n10 = (int)(speedUseCase.f(n10, string2, bl2) ? 1 : 0)) != 0) {
            this.i4();
        }
        return n10 != 0;
    }

    public String K0() {
        int n10 = this.S0();
        return this.L0(n10);
    }

    public MutableLiveData K1() {
        return this.j;
    }

    public void K2(int n10) {
        TextUseCase textUseCase = this.O;
        int n11 = UseCases.b(textUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = -1;
        if (n10 == n11) {
            return;
        }
        this.O.l(n10);
    }

    public void K3() {
        this.G.m0();
        this.I3();
    }

    public boolean L(String string2) {
        int n10 = this.S0();
        return this.J(n10, string2);
    }

    public String L0(int n10) {
        SpeedUseCase speedUseCase = this.L;
        boolean bl2 = UseCases.b(speedUseCase);
        if (bl2) {
            return "";
        }
        return this.L.h(n10);
    }

    public MutableLiveData L1() {
        return this.o;
    }

    public void L2() {
        int n10;
        TextUseCase textUseCase = this.O;
        int n11 = UseCases.b(textUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = this.a2();
        if (n11 == (n10 = -1)) {
            return;
        }
        this.O.p(n11, null);
    }

    public void L3(boolean bl2) {
        MutableLiveData mutableLiveData = this.J1();
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    /*
     * WARNING - void declaration
     */
    public boolean M(int n10) {
        void var3_5;
        Object object = this.r.getValue();
        if (object == null) {
            boolean n11 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var3_5 != false) {
            n10 = (int)(this.P(n10) ? 1 : 0);
        } else {
            int n11 = this.S0();
            n10 = (int)(this.N(n11, n10) ? 1 : 0);
        }
        return n10 != 0;
    }

    public d.v.h.f.a M0() {
        int n10 = this.S0();
        return this.f1(n10);
    }

    public MutableLiveData M1() {
        return this.D;
    }

    public boolean M2(int n10, boolean bl2) {
        TransitionUseCase transitionUseCase = this.Q;
        boolean bl3 = UseCases.b(transitionUseCase);
        if (bl3) {
            return false;
        }
        n10 = (int)(this.Q.j(n10, bl2) ? 1 : 0);
        this.I3();
        return n10 != 0;
    }

    public void M3(boolean bl2) {
        MutableLiveData mutableLiveData = this.K1();
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public boolean N(int n10, int n11) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        n10 = !bl2 && (n10 = (int)((frameEffectUseCase = this.N).e(n11, n10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int N0() {
        int n10 = this.S0();
        return this.T1(n10);
    }

    public MutableLiveData N1() {
        return this.i;
    }

    public boolean N2(int n10, boolean bl2) {
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            return this.J.r(n10);
        }
        RecordUseCase recordUseCase = this.K;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.v(n10);
    }

    public void N3(boolean bl2, boolean bl3) {
        MutableLiveData mutableLiveData = this.F0();
        Object object = bl2;
        d.v.e.i.h.g(mutableLiveData, object);
        object = this.E0();
        Boolean bl4 = bl3;
        d.v.e.i.h.g((MutableLiveData)object, bl4);
    }

    public float O0() {
        int n10 = this.S0();
        return this.E1(n10);
    }

    public List O1() {
        Object object = this.K;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.K.p();
        return object;
    }

    public boolean O2(boolean bl2) {
        int n10 = bl2 ? d.v.v.q.h.m() : d.v.v.q.h.o();
        return this.N2(n10, bl2);
    }

    public void O3(boolean bl2) {
        MutableLiveData mutableLiveData = this.N1();
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public boolean P(int n10) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        n10 = !bl2 && (n10 = (int)((frameEffectUseCase = this.N).d(n10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int P0() {
        int n10 = this.S0();
        return this.i2(n10);
    }

    public float P1(int n10) {
        float f10;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            voiceUseCase = this.I;
            f10 = voiceUseCase.m(n10);
        }
        return f10;
    }

    public boolean P2(String object, String string2) {
        MusicUseCase musicUseCase = this.J;
        int n10 = UseCases.b(musicUseCase);
        if (n10 == 0 && (n10 = d.v.j.b.b((String)object)) == 0) {
            int n11;
            n10 = d.v.v.q.h.m();
            if (n10 != (n11 = -1)) {
                long l10 = d.v.v.q.h.F(n10);
                long l11 = d.v.v.q.h.D(n10);
                d.v.h.h.b b10 = (d.v.h.h.b)this.H1().get(n10);
                d.v.h.h.b b11 = new d.v.h.h.b();
                Object object2 = l10;
                object2 = b11.p((Long)object2);
                long l12 = 0L;
                object2 = ((d.v.h.h.b)object2).x(l12);
                d.v.h.h.b b12 = ((d.v.h.h.b)object2).r(l11 -= l10);
                float f10 = b10.n();
                b12 = b12.y(f10);
                object = b12.v((String)object).u(string2);
                string2 = b10.a();
                ((d.v.h.b)object).b(string2);
                object = b11.k();
                long l13 = d.v.v.q.h.C((String)object);
                l10 = -1;
                n11 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
                if (n11 == 0) {
                    return false;
                }
                b11.q(l13);
                return this.J.t(n10, b11);
            }
            return this.s((String)object, string2);
        }
        return false;
    }

    public void P3(boolean bl2) {
        this.G.n0(bl2);
    }

    public boolean Q(float f10) {
        boolean bl2;
        VoiceUseCase voiceUseCase = this.I;
        boolean bl3 = UseCases.b(voiceUseCase);
        if (!bl3 && (bl2 = (voiceUseCase = this.I).a(f10))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    public int Q0() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n10 = (int)(UseCases.b(frameSizeUseCase) ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            frameSizeUseCase = null;
        } else {
            frameSizeUseCase = this.M;
            int n11 = this.S0();
            n10 = frameSizeUseCase.l(n11);
        }
        return n10;
    }

    public j Q1() {
        return this.p;
    }

    public void Q2(DecorationType decorationType, long l10, String string2, String string3, float f10, boolean bl2, e e10) {
        i2 i22 = this;
        e e11 = e10;
        Object object = this.P;
        boolean bl3 = UseCases.b((IUseCase)object);
        if (bl3) {
            if (e10 != null) {
                e10.a();
            }
            return;
        }
        object = this.W0();
        if (object != null) {
            int n10;
            long l11;
            Object object2 = this.Z1();
            int n11 = DecorationUseCases.b(object2, l11 = this.U0());
            if (n11 == (n10 = -1)) {
                object = this;
                object2 = decorationType;
                l11 = l10;
                this.u(decorationType, l10, string2, string3, f10, e10);
            } else {
                object = ((d.v.h.d.c)object).t();
                if (!bl2) {
                    l11 = 0L;
                    ((d.v.h.d.a)object).p(l11);
                }
                ((d.v.h.d.c)object).N(string3).K(string2).M(l10).o(decorationType);
                StickerUseCase stickerUseCase = i22.P;
                stickerUseCase.p(n11, (d.v.h.d.c)object, e11);
            }
        } else {
            object = this;
            DecorationType decorationType2 = decorationType;
            long l12 = l10;
            this.u(decorationType, l10, string2, string3, f10, e10);
        }
    }

    public boolean Q3() {
        boolean bl2;
        Object object = this.t.getValue();
        boolean bl3 = false;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.t.getValue();
            bl2 = (Boolean)object;
        }
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl4 = UseCases.b(frameSizeUseCase);
        if (!bl4 && (bl2 = (frameSizeUseCase = this.M).z(bl2))) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean R(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameSizeUseCase = this.M).c(n10, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public j R0() {
        return this.l;
    }

    public MutableLiveData R1() {
        return this.q;
    }

    public void R2(d.v.h.d.c object, e e10) {
        Object object2 = this.P;
        int n10 = UseCases.b((IUseCase)object2);
        if (n10 != 0) {
            return;
        }
        object2 = this.W0();
        if (object2 != null) {
            int n11;
            long l10;
            object2 = this.Z1();
            n10 = DecorationUseCases.b((List)object2, l10 = this.U0());
            if (n10 != (n11 = -1)) {
                if (object == null) {
                    object = this.P;
                    ((StickerUseCase)object).m(n10);
                    e10.b();
                } else {
                    StickerUseCase stickerUseCase = this.P;
                    stickerUseCase.p(n10, (d.v.h.d.c)object, e10);
                }
            }
        } else {
            object2 = this.P;
            ((StickerUseCase)object2).e((d.v.h.d.c)object, e10);
        }
        e10.b();
    }

    public void R3(boolean bl2) {
        StickerUseCase stickerUseCase = this.P;
        boolean bl3 = UseCases.b(stickerUseCase);
        if (!bl3) {
            if (bl2) {
                StickerUseCase stickerUseCase2 = this.P;
                stickerUseCase2.k();
            } else {
                StickerUseCase stickerUseCase3 = this.P;
                stickerUseCase3.q();
            }
        }
    }

    public boolean S(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameSizeUseCase = this.M).g(n10, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public int S0() {
        return this.G.F();
    }

    /*
     * WARNING - void declaration
     */
    public int S1() {
        void var2_7;
        void var2_4;
        Object object = this.t.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.t.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var2_4 != false) {
            int n10 = this.j1();
        } else {
            int n11 = this.N0();
        }
        return (int)var2_7;
    }

    public void S2(d.v.h.d.d d10) {
        int n10;
        TextUseCase textUseCase = this.O;
        int n11 = UseCases.b(textUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = this.a2();
        if (n11 == (n10 = -1)) {
            this.x(d10);
        } else if (d10 == null) {
            this.K2(n11);
        } else {
            TextUseCase textUseCase2 = this.O;
            textUseCase2.n(n11, d10);
        }
    }

    public void S3(boolean bl2) {
        TextUseCase textUseCase = this.O;
        boolean bl3 = UseCases.b(textUseCase);
        if (!bl3) {
            if (bl2) {
                TextUseCase textUseCase2 = this.O;
                textUseCase2.j();
            } else {
                TextUseCase textUseCase3 = this.O;
                textUseCase3.o();
            }
        }
    }

    public boolean T(int n10, int n11, boolean bl2) {
        return this.G.o(n10, n11, bl2);
    }

    public MutableLiveData T0() {
        return this.m;
    }

    public int T1(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            n10 = 0;
        } else {
            frameSizeUseCase = this.M;
            n10 = frameSizeUseCase.p(n10);
        }
        return n10;
    }

    public void T2() {
        MainUseCase mainUseCase = this.G;
        int n10 = this.S0();
        i2$b i2$b = new i2$b(this);
        mainUseCase.d0(n10, i2$b);
    }

    public boolean T3(int n10, boolean bl2, b b10) {
        boolean bl3 = true;
        if (bl2 && b10 != null) {
            return this.y(n10, b10, bl3);
        }
        return this.M2(n10, bl3);
    }

    /*
     * WARNING - void declaration
     */
    public boolean U(float f10) {
        void var3_5;
        Object object = this.s.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.s.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var3_5 != false) {
            return this.Q(f10);
        }
        int n10 = this.S0();
        return this.V(n10, f10);
    }

    public long U0() {
        return this.G.E();
    }

    public MutableLiveData U1() {
        return this.C;
    }

    public void U2(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n11 = UseCases.b(frameSizeUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = this.S0();
        int n12 = 180;
        if (n10 > n12) {
            n10 = n12;
        }
        if (n10 < (n12 = -180)) {
            n10 = n12;
        }
        this.M.w(n11, n10, true);
    }

    public boolean U3() {
        boolean bl2;
        Object object = this.u.getValue();
        boolean bl3 = false;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.u.getValue();
            bl2 = (Boolean)object;
        }
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl4 = UseCases.b(frameSizeUseCase);
        if (!bl4 && (bl2 = (frameSizeUseCase = this.M).A(bl2))) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean V(int n10, float f10) {
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        n10 = !bl2 && (n10 = (int)((voiceUseCase = this.I).b(n10, f10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public int V0() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n10 = (int)(UseCases.b(frameSizeUseCase) ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            frameSizeUseCase = null;
        } else {
            frameSizeUseCase = this.M;
            int n11 = this.S0();
            n10 = frameSizeUseCase.m(n11);
        }
        return n10;
    }

    public j V1() {
        return this.E;
    }

    public void V3(int n10, int n11, int n12) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        this.M.e(n10, n11, n12);
    }

    public void W(g g10) {
        this.G.q(g10);
    }

    public d.v.h.d.c W0() {
        int n10;
        long l10;
        List list = this.Z1();
        int n11 = DecorationUseCases.b(list, l10 = this.U0());
        if (n11 == (n10 = -1)) {
            return null;
        }
        return (d.v.h.d.c)list.get(n11);
    }

    public double W1() {
        int n10 = this.S0();
        return this.X1(n10);
    }

    public void W2(TemplatePOJO templatePOJO, long l10, boolean bl2) {
        DraftUseCase draftUseCase = this.R;
        if (draftUseCase == null) {
            return;
        }
        draftUseCase.s(templatePOJO, l10, bl2);
    }

    public boolean X(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        n10 = !bl2 && (n10 = (int)((frameSizeUseCase = this.M).a(n10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public d.v.h.d.d X0() {
        int n10;
        List list = this.b2();
        int n11 = this.a2();
        if (n11 == (n10 = -1)) {
            return null;
        }
        return (d.v.h.d.d)list.get(n11);
    }

    public double X1(int n10) {
        double d10;
        SpeedUseCase speedUseCase = this.L;
        boolean bl2 = UseCases.b(speedUseCase);
        if (bl2) {
            d10 = 1.0;
        } else {
            speedUseCase = this.L;
            d10 = speedUseCase.i(n10);
        }
        return d10;
    }

    public void X2(int n10, float f10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        this.M.x(n10, f10);
    }

    public void X3(DecorationType object, int n10, Long l10, long l11) {
        Object object2 = this.O;
        Object object3 = UseCases.b((IUseCase)object2);
        if (object3 != 0) {
            return;
        }
        object2 = i2$d.a;
        Object object4 = ((Enum)object).ordinal();
        object3 = 1;
        if ((object4 = (Object)object2[object4]) == object3 || object4 == (object3 = 2)) {
            object = this.O;
            ((TextUseCase)object).y(n10, l10, l11);
        }
    }

    public void Y(int n10, d.v.c.p1.d d10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (!bl2) {
            frameSizeUseCase = this.M;
            int n11 = (int)d10.f();
            int bl3 = (int)d10.g();
            frameSizeUseCase.e(n10, n11, bl3);
            frameSizeUseCase = this.M;
            n11 = d10.b();
            boolean bl4 = true;
            frameSizeUseCase.u(n10, n11, bl4);
            frameSizeUseCase = this.M;
            float f10 = d10.d();
            float f11 = d10.e();
            frameSizeUseCase.y(n10, f10, f11);
            frameSizeUseCase = this.M;
            int n12 = d10.c();
            frameSizeUseCase.w(n10, n12, bl4);
        }
    }

    public MutableLiveData Y0() {
        return this.w;
    }

    public int Y1() {
        List list = this.B0();
        long l10 = this.U0();
        return DecorationUseCases.b(list, l10);
    }

    public boolean Y2() {
        long l10 = this.U0();
        return this.a3(l10);
    }

    public void Y3(DecorationType decorationType, int n10, long l10, long l11) {
        long l12 = l11 - l10;
        Long l13 = l10;
        this.X3(decorationType, n10, l13, l12);
    }

    public void Z(d.v.c.p1.d d10) {
        int n10 = this.S0();
        this.Y(n10, d10);
    }

    public LiveData Z0() {
        return this.b;
    }

    public List Z1() {
        Object object = this.P;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.P.i();
        return object;
    }

    public boolean Z2(int n10) {
        MainUseCase mainUseCase = this.G;
        long l10 = mainUseCase.I(n10);
        if ((n10 = (int)(this.a3(l10) ? 1 : 0)) != 0) {
            this.b4();
        }
        return n10 != 0;
    }

    public void Z3() {
        this.H.n();
    }

    /*
     * WARNING - void declaration
     */
    public boolean a0(int n10) {
        void var3_5;
        Object object = this.t.getValue();
        if (object == null) {
            boolean n11 = false;
            object = null;
        } else {
            object = (Boolean)this.t.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var3_5 != false) {
            n10 = (int)(this.R(n10) ? 1 : 0);
        } else {
            int n11 = this.S0();
            n10 = (int)(this.b0(n11, n10) ? 1 : 0);
        }
        return n10 != 0;
    }

    public MainUseCase a1() {
        return this.G;
    }

    public int a2() {
        List list = this.b2();
        long l10 = this.U0();
        return DecorationUseCases.b(list, l10);
    }

    public boolean a3(long l10) {
        this.A2();
        MainUseCase mainUseCase = this.G;
        boolean bl2 = mainUseCase.e0(l10);
        if (bl2) {
            this.b4();
        }
        return bl2;
    }

    public void a4() {
        MusicUseCase musicUseCase = this.J;
        boolean bl2 = UseCases.b(musicUseCase);
        if (bl2) {
            return;
        }
        this.J.a(false);
    }

    public boolean b0(int n10, int n11) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameSizeUseCase = this.M).b(n10, n11, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public MutableLiveData b1() {
        return this.A;
    }

    public List b2() {
        Object object = this.O;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.O.i();
        return object;
    }

    public void b3(long l10) {
        j j10 = this.E;
        Long l11 = l10;
        d.v.e.i.h.g(j10, l11);
    }

    public void b4() {
        this.H.p();
    }

    public boolean c0(double d10) {
        int n10 = this.S0();
        return this.d0(n10, d10);
    }

    public boolean c1() {
        return (Boolean)this.A.getValue();
    }

    public MutableLiveData c2() {
        return this.n;
    }

    public void c3(int n10, d.v.h.f.a a10) {
        FrameEffectUseCase frameEffectUseCase;
        boolean bl2;
        if (a10 != null && !(bl2 = UseCases.b(frameEffectUseCase = this.N))) {
            frameEffectUseCase = this.N;
            a10 = a10.m();
            boolean bl3 = true;
            frameEffectUseCase.n(n10, (SparseArray)a10, bl3);
        }
    }

    public boolean d0(int n10, double d10) {
        SpeedUseCase speedUseCase = this.L;
        boolean bl2 = UseCases.b(speedUseCase);
        if (bl2) {
            return false;
        }
        speedUseCase = this.L;
        if ((n10 = (int)(speedUseCase.k(d10, n10) ? 1 : 0)) != 0) {
            this.i4();
        }
        return n10 != 0;
    }

    public d.v.h.f.a d1() {
        boolean bl2;
        Object object = this.r.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            bl2 = (Boolean)object;
        }
        object = bl2 ? this.h1() : this.M0();
        return object;
    }

    public long d2() {
        return this.G.J();
    }

    /*
     * WARNING - void declaration
     */
    public void d3(d.v.h.f.a a10) {
        void var3_5;
        Object object = this.v.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.v.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var3_5 != false) {
            this.l3(a10);
        } else {
            int n10 = this.S0();
            this.c3(n10, a10);
        }
    }

    public void d4(int n10, long l10, long l11) {
        StickerUseCase stickerUseCase = this.P;
        boolean bl2 = UseCases.b(stickerUseCase);
        if (bl2) {
            return;
        }
        stickerUseCase = this.P;
        Long l12 = l10;
        stickerUseCase.s(n10, l12, l11 -= l10);
    }

    public boolean e0(int n10, long l10, boolean bl2) {
        TransitionUseCase transitionUseCase = this.Q;
        boolean bl3 = UseCases.b(transitionUseCase);
        if (bl3) {
            return false;
        }
        return this.Q.h(n10, l10, bl2);
    }

    public d.v.h.f.a e1() {
        boolean bl2;
        Object object = this.v.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.v.getValue();
            bl2 = (Boolean)object;
        }
        object = bl2 ? this.h1() : this.M0();
        return object;
    }

    public b e2(int n10) {
        List list = this.G.H();
        boolean bl2 = d.v.j.b.h(n10, list);
        if (bl2) {
            b b10 = new b();
            return b10;
        }
        return ((d)this.G.H().get(n10)).N();
    }

    public boolean e3(int n10, float f10, boolean bl2) {
        n10 = bl2 ? (int)(this.q3(n10, f10) ? 1 : 0) : (int)(this.t3(n10, f10) ? 1 : 0);
        return n10 != 0;
    }

    public void e4(int n10, int n11) {
        int n12;
        TextUseCase textUseCase = this.O;
        int n13 = UseCases.b(textUseCase);
        if (n13 != 0) {
            return;
        }
        n13 = this.a2();
        if (n13 == (n12 = -1)) {
            return;
        }
        int[] nArray = DecorationUseCases.a(n10);
        TextUseCase textUseCase2 = this.O;
        n11 = n11 * 255 / 100;
        int n14 = nArray[1];
        int n15 = nArray[2];
        n10 = nArray[3];
        n10 = Color.argb((int)n11, (int)n14, (int)n15, (int)n10);
        textUseCase2.r(n13, n10);
    }

    /*
     * WARNING - void declaration
     */
    public boolean f0(int n10) {
        void var3_5;
        Object object = this.u.getValue();
        if (object == null) {
            boolean n11 = false;
            object = null;
        } else {
            object = (Boolean)this.u.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var3_5 != false) {
            n10 = (int)(this.S(n10) ? 1 : 0);
        } else {
            int n11 = this.S0();
            n10 = (int)(this.g0(n11, n10) ? 1 : 0);
        }
        return n10 != 0;
    }

    public d.v.h.f.a f1(int n10) {
        d.v.h.f.a a10;
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        if (bl2) {
            a10 = new d.v.h.f.a();
        } else {
            frameEffectUseCase = this.N;
            a10 = frameEffectUseCase.i(n10);
        }
        return a10;
    }

    public void f3(boolean bl2) {
        this.G.g0(bl2);
    }

    public void f4(String string2) {
        int n10;
        TextUseCase textUseCase = this.O;
        int n11 = UseCases.b(textUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = this.a2();
        if (n11 == (n10 = -1)) {
            return;
        }
        this.O.t(n11, string2);
        ((d.v.h.d.d)this.b2().get(n11)).F(false);
    }

    public boolean g0(int n10, int n11) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameSizeUseCase = this.M).f(n10, n11, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public MutableLiveData g1() {
        return this.B;
    }

    public List g2(TemplatePOJO object) {
        boolean bl2;
        Object object2 = this.F;
        if (object2 != null && object != null && !(bl2 = d.v.j.b.f((List)(object2 = ((TemplatePOJO)object).getTemplateVideoList())))) {
            int n10;
            object = ((TemplatePOJO)object).getTemplateVideoList();
            object2 = object.stream();
            Object object3 = n1.a;
            object2 = object2.map(object3);
            object3 = j1.a;
            object2 = (String[])object2.toArray((IntFunction<A[]>)object3);
            object2 = this.F.D0((String[])object2);
            object3 = null;
            for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                d.v.h.e.a a10 = (d.v.h.e.a)object2.get(i10);
                String string2 = ((TemplateVideo)object.get(i10)).getCustomerUUID();
                a10.b(string2);
                a10 = (d.v.h.e.a)object2.get(i10);
                boolean bl3 = ((TemplateVideo)object.get(i10)).isReverse();
                a10 = a10.n(bl3);
                string2 = ((TemplateVideo)object.get(i10)).getReversePath();
                a10.o(string2);
            }
            return object2;
        }
        return Collections.emptyList();
    }

    public void g3(boolean bl2) {
        boolean bl3 = this.c1();
        if (bl2 != bl3) {
            MutableLiveData mutableLiveData = this.A;
            Boolean bl4 = bl2;
            d.v.e.i.h.e(mutableLiveData, bl4);
        }
    }

    public void g4(String string2, int n10) {
        int n11;
        TextUseCase textUseCase = this.O;
        int n12 = UseCases.b(textUseCase);
        if (n12 != 0) {
            return;
        }
        n12 = this.a2();
        if (n12 == (n11 = -1)) {
            return;
        }
        this.O.v(n12, string2, n10);
    }

    public void h0() {
        this.G.r();
    }

    public d.v.h.f.a h1() {
        Object object = this.N;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? new d.v.h.f.a() : this.N.h();
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public int h2() {
        void var2_7;
        void var2_4;
        Object object = this.u.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.u.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var2_4 != false) {
            int n10 = this.k1();
        } else {
            int n11 = this.P0();
        }
        return (int)var2_7;
    }

    public boolean h3(int n10, d.v.h.f.a a10) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameEffectUseCase = this.N).a(n10, a10, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public void h4(String object) {
        TextUseCase textUseCase = this.O;
        int n10 = UseCases.b(textUseCase);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)object)) == 0) {
            int n11;
            n10 = this.a2();
            if (n10 == (n11 = -1)) {
                return;
            }
            TextUseCase textUseCase2 = this.O;
            d$a d$a = new d$a();
            object = d$a.c((String)object);
            textUseCase2.p(n10, (d$a)object);
        }
    }

    public boolean i0() {
        MainUseCase mainUseCase = this.G;
        long l10 = this.U0();
        return mainUseCase.v(l10);
    }

    public float i1() {
        float f10;
        VoiceUseCase voiceUseCase = this.I;
        int n10 = UseCases.b(voiceUseCase);
        if (n10 != 0) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            voiceUseCase = this.I;
            f10 = voiceUseCase.g();
        }
        return f10;
    }

    public int i2(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            n10 = 0;
        } else {
            frameSizeUseCase = this.M;
            n10 = frameSizeUseCase.s(n10);
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean i3(d.v.h.f.a a10) {
        boolean bl2;
        void var3_5;
        Object object = this.r.getValue();
        if (object == null) {
            boolean n10 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            boolean bl3 = (Boolean)object;
        }
        if (var3_5 != false) {
            bl2 = this.m3(a10);
        } else {
            int n10 = this.S0();
            bl2 = this.h3(n10, a10);
        }
        return bl2;
    }

    public void i4() {
        this.Z3();
        this.b4();
    }

    public boolean j0(int n10, long l10) {
        return this.G.t(n10, l10);
    }

    public int j1() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n10 = UseCases.b(frameSizeUseCase);
        if (n10 != 0) {
            n10 = 0;
            frameSizeUseCase = null;
        } else {
            frameSizeUseCase = this.M;
            n10 = frameSizeUseCase.o();
        }
        return n10;
    }

    public void j2(TemplatePOJO templatePOJO) {
        a1 a12;
        this.F = a12 = new a1(templatePOJO, false);
    }

    /*
     * WARNING - void declaration
     */
    public boolean j3(int n10, int n11) {
        void var4_6;
        Object object = this.v.getValue();
        if (object == null) {
            boolean n12 = false;
            object = null;
        } else {
            object = (Boolean)this.v.getValue();
            boolean bl2 = (Boolean)object;
        }
        if (var4_6 != false) {
            n10 = (int)(this.n3(n10, n11) ? 1 : 0);
        } else {
            int n12 = this.S0();
            n10 = (int)(this.k3(n12, n10, n11) ? 1 : 0);
        }
        return n10 != 0;
    }

    public boolean j4(int n10, Long l10, boolean bl2) {
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            return this.J.v(n10, l10);
        }
        RecordUseCase recordUseCase = this.K;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.A(n10, l10);
    }

    public boolean k0(long l10) {
        return this.G.v(l10);
    }

    public int k1() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        int n10 = UseCases.b(frameSizeUseCase);
        if (n10 != 0) {
            n10 = 0;
            frameSizeUseCase = null;
        } else {
            frameSizeUseCase = this.M;
            n10 = frameSizeUseCase.r();
        }
        return n10;
    }

    public void k2(PlayerWrapperView object, List list) {
        MainUseCase mainUseCase = this.G;
        int n10 = this.A0();
        if (n10 != 0) {
            a1 a12 = this.F;
            n10 = a12.u();
        } else {
            n10 = -1;
        }
        d.v.h.e.b b10 = this.S;
        mainUseCase.N((PlayerWrapperView)((Object)object), list, n10, b10);
        object = this.G;
        int n11 = o1.c(d.v.e.f.a().c().getResources(), 2131099762);
        ((MainUseCase)object).h0(n11);
    }

    public boolean k3(int n10, int n11, int n12) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameEffectUseCase = this.N).o(n10, n11, n12, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public boolean l0(long l10, boolean bl2) {
        int n10;
        int n11 = bl2 ? d.v.v.q.h.m() : d.v.v.q.h.o();
        if (n11 == (n10 = -1)) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            return this.J.g(n11, l10);
        }
        RecordUseCase recordUseCase = this.K;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.i(n11, l10);
    }

    public MutableLiveData l1() {
        return this.x;
    }

    public boolean l2() {
        return d.v.e.h.a.c((Boolean)this.x.getValue());
    }

    public void l3(d.v.h.f.a a10) {
        FrameEffectUseCase frameEffectUseCase;
        boolean bl2;
        if (a10 != null && !(bl2 = UseCases.b(frameEffectUseCase = this.N))) {
            frameEffectUseCase = this.N;
            a10 = a10.m();
            boolean bl3 = true;
            frameEffectUseCase.r((SparseArray)a10, bl3);
        }
    }

    public boolean m0(long l10, boolean bl2) {
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            return this.J.h(l10);
        }
        RecordUseCase recordUseCase = this.K;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.j(l10);
    }

    public MutableLiveData m1() {
        return this.r;
    }

    public boolean m2() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (!bl2 && (bl2 = (recordUseCase = this.K).r())) {
            bl2 = true;
        } else {
            bl2 = false;
            recordUseCase = null;
        }
        return bl2;
    }

    public boolean m3(d.v.h.f.a a10) {
        boolean bl2;
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl3 = UseCases.b(frameEffectUseCase);
        boolean bl4 = true;
        if (bl3 || !(bl2 = (frameEffectUseCase = this.N).b(a10, bl4))) {
            bl4 = false;
        }
        return bl4;
    }

    public boolean n0(boolean bl2) {
        long l10 = this.U0();
        return this.m0(l10, bl2);
    }

    public boolean n1() {
        boolean bl2;
        Object object = this.r.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.r.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public boolean n3(int n10, int n11) {
        FrameEffectUseCase frameEffectUseCase = this.N;
        boolean bl2 = UseCases.b(frameEffectUseCase);
        boolean bl3 = true;
        if (bl2 || (n10 = (int)((frameEffectUseCase = this.N).p(n10, n11, bl3) ? 1 : 0)) == 0) {
            bl3 = false;
        }
        return bl3;
    }

    public void o0() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        this.M.i();
    }

    public MutableLiveData o1() {
        return this.v;
    }

    public void o3(int n10, long l10) {
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            return;
        }
        this.I.q(n10, l10);
    }

    public void onCleared() {
        super.onCleared();
        this.a.e();
        this.G.B();
        c c10 = d.v.e.c.b();
        c$a c$a = this.T;
        c10.f(c$a);
    }

    public void p(d.v.h.e.a a10) {
        this.G.i(a10, true);
        this.Z3();
    }

    public boolean p0(int n10) {
        MainUseCase mainUseCase = this.G;
        if ((n10 = (int)(mainUseCase.w(n10) ? 1 : 0)) != 0) {
            this.i4();
        }
        return n10 != 0;
    }

    public boolean p1() {
        boolean bl2;
        Object object = this.v.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.v.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public /* synthetic */ void p2() {
        this.o2();
    }

    public void p3(int n10, long l10) {
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        if (bl2) {
            return;
        }
        this.I.r(n10, l10);
    }

    public void q0(int n10) {
        StickerUseCase stickerUseCase = this.P;
        int n11 = UseCases.b(stickerUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = -1;
        if (n10 == n11) {
            return;
        }
        this.P.g(n10);
    }

    public boolean q1() {
        float f10;
        int n10 = this.s1();
        if (n10 != 0 && (n10 = Float.compare(f10 = this.i1(), 0.0f)) == 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public boolean q3(int n10, float f10) {
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        n10 = !bl2 && (n10 = (int)((voiceUseCase = this.I).d(n10, f10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void r(d.v.h.e.a a10, boolean bl2) {
        this.G.i(a10, bl2);
        this.Z3();
    }

    public void r0(int n10) {
        TextUseCase textUseCase = this.O;
        int n11 = UseCases.b(textUseCase);
        if (n11 != 0) {
            return;
        }
        n11 = -1;
        if (n10 == n11) {
            return;
        }
        this.O.g(n10);
        DecorationType decorationType = DecorationType.FONT;
        this.F3(decorationType, false, true);
    }

    public MutableLiveData r1() {
        return this.s;
    }

    public /* synthetic */ void r2(int n10, boolean bl2, Long l10) {
        this.q2(n10, bl2, l10);
    }

    public void r3(String string2) {
        d.v.e.i.h.g(this.D, string2);
    }

    public boolean s(String object, String string2) {
        Object object2 = this.J;
        Object object3 = UseCases.b((IUseCase)object2);
        if (!object3 && !(object3 = d.v.j.b.b((String)object))) {
            long l10;
            long l11 = d.v.v.q.h.C((String)object);
            long l12 = l11 - (l10 = (long)-1);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object3) {
                return false;
            }
            object2 = new d.v.h.h.b();
            object = ((d.v.h.h.b)object2).v((String)object);
            object2 = this.G.E();
            object = ((d.v.h.h.b)object).p((Long)object2).x(0L).r(l11).q(l11).u(string2).y(1.0f);
            return this.J.e((d.v.h.h.b)object);
        }
        return false;
    }

    public boolean s0(int n10, long l10, long l11) {
        MainUseCase mainUseCase = this.G;
        if ((n10 = (int)(mainUseCase.z(n10, l10, l11) ? 1 : 0)) != 0) {
            this.i4();
        }
        return n10 != 0;
    }

    public boolean s1() {
        boolean bl2;
        Object object = this.s.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.s.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void s3(a$a a$a) {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return;
        }
        this.K.x(a$a);
    }

    public boolean t(List list) {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.g(list);
    }

    public boolean t0(int n10, long l10, long l11, long l12, boolean bl2, boolean bl3) {
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            n11 = (int)(UseCases.b(musicUseCase) ? 1 : 0);
            if (n11 != 0) {
                return false;
            }
            return this.J.j(n10, l10, l11, l12, bl3);
        }
        RecordUseCase recordUseCase = this.K;
        n11 = (int)(UseCases.b(recordUseCase) ? 1 : 0);
        if (n11 != 0) {
            return false;
        }
        return this.K.l(n10, l10, l11, l12, bl3);
    }

    public MutableLiveData t1() {
        return this.t;
    }

    public /* synthetic */ void t2(e.a.s0.b b10) {
        this.s2(b10);
    }

    public boolean t3(int n10, float f10) {
        VoiceUseCase voiceUseCase = this.I;
        boolean bl2 = UseCases.b(voiceUseCase);
        n10 = !bl2 && (n10 = (int)((voiceUseCase = this.I).e(n10, f10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void u(DecorationType object, long l10, String string2, String string3, float f10, e e10) {
        Object object2 = this.P;
        boolean bl2 = UseCases.b((IUseCase)object2);
        if (bl2) {
            return;
        }
        object2 = new d.v.h.d.c(null, null, 0L, (DecorationType)((Object)object));
        object = ((d.v.h.d.c)object2).K(string2).M(l10).J(f10).N(string3);
        Long l11 = this.G.E();
        ((d.v.h.d.a)object).m(l11);
        this.P.e((d.v.h.d.c)object2, e10);
    }

    public boolean u0(int n10, long l10, long l11, boolean bl2, boolean bl3) {
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.J;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            return this.J.l(n10, l10, l11, bl3);
        }
        RecordUseCase recordUseCase = this.K;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        return this.K.n(n10, l10, l11, bl3);
    }

    public boolean u1() {
        boolean bl2;
        Object object = this.t.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.t.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public boolean u2(int n10, long l10) {
        return this.G.T(n10, l10);
    }

    public void u3(MutableLiveData mutableLiveData) {
        this.q = mutableLiveData;
    }

    public void v(d.v.h.d.c c10) {
        StickerUseCase stickerUseCase = this.P;
        boolean bl2 = UseCases.b(stickerUseCase);
        if (bl2) {
            return;
        }
        this.P.e(c10, null);
    }

    public boolean v0(long l10, long l11, boolean bl2) {
        int n10 = bl2 ? d.v.v.q.h.m() : d.v.v.q.h.o();
        return this.u0(n10, l10, l11, bl2, false);
    }

    public MutableLiveData v1() {
        return this.u;
    }

    public void v2(int n10) {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        frameSizeUseCase = this.M;
        int n11 = this.S0();
        frameSizeUseCase.u(n11, n10, true);
    }

    public void v3(int n10) {
        MutableLiveData mutableLiveData = this.q;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public void w(Context object) {
        Object object2 = this.O;
        boolean bl2 = UseCases.b((IUseCase)object2);
        if (bl2) {
            return;
        }
        object = d.v.f.i.g.m(object, 2131952109);
        object2 = new d.v.h.d.d(null, null, 0L);
        object = ((d.v.h.d.d)object2).J((String)object);
        int bl3 = m0.c;
        object = object.H(bl3).I(-1);
        boolean bl4 = true;
        object = object.F(bl4);
        Long l10 = this.G.E();
        object.m(l10);
        this.O.e((d.v.h.d.d)object2);
        object = DecorationType.FONT;
        this.F3((DecorationType)((Object)object), false, bl4);
    }

    public boolean w0(long l10, long l11, boolean bl2, boolean bl3) {
        int n10 = bl2 ? d.v.v.q.h.m() : d.v.v.q.h.o();
        return this.u0(n10, l10, l11, bl2, bl3);
    }

    public boolean w1() {
        boolean bl2;
        Object object = this.u.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.u.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void w2() {
        List list;
        int n10;
        int n11 = this.S0();
        if (n11 == (n10 = (list = this.C1()).size() + -1)) {
            return;
        }
        this.G.W();
        this.I3();
        this.b4();
    }

    public void w3(boolean bl2) {
        MutableLiveData mutableLiveData = this.C;
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public void x(d.v.h.d.d d10) {
        TextUseCase textUseCase = this.O;
        boolean bl2 = UseCases.b(textUseCase);
        if (!bl2 && d10 != null) {
            textUseCase = this.O;
            textUseCase.e(d10);
        }
    }

    public void x0() {
        int n10 = this.S0();
        this.y0(n10);
    }

    public MutableLiveData x1() {
        return this.d;
    }

    public void x2(int n10) {
        Object object;
        int n11 = 1;
        if (n10 == n11) {
            boolean bl2;
            object = this.C1().iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = (d)object.next();
                String string2 = ((d.v.h.e.a)object2).g();
                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                if (bl3) continue;
                object2 = ((d.v.h.e.a)object2).g();
                s1.h((String)object2);
            }
        }
        if ((object = this.R) != null && (n11 = (int)(((MainUseCase)(object = this.G)).R() ? 1 : 0)) != 0) {
            object = this.R;
            ((DraftUseCase)object).q(n10);
        }
    }

    public void x3(long l10, long l11) {
        this.G.i0(l10, l11);
    }

    public boolean y(int n10, b b10, boolean bl2) {
        TransitionUseCase transitionUseCase = this.Q;
        boolean bl3 = UseCases.b(transitionUseCase);
        if (bl3) {
            return false;
        }
        transitionUseCase = this.Q;
        if ((n10 = (int)(transitionUseCase.e(n10, b10, bl2) ? 1 : 0)) != 0) {
            this.I3();
        }
        return n10 != 0;
    }

    public boolean y0(int n10) {
        MainUseCase mainUseCase = this.G;
        if ((n10 = (int)(mainUseCase.b0(n10) ? 1 : 0)) != 0) {
            this.i4();
        }
        return n10 != 0;
    }

    public Boolean y1() {
        Object object = this.d.getValue();
        object = object == null ? Boolean.FALSE : (Boolean)this.d.getValue();
        return object;
    }

    public void y2(int n10, boolean bl2, boolean bl3) {
        this.a.e();
        this.f3(bl3);
        Object object = TimeUnit.MILLISECONDS;
        object = e.a.z.O6(150L, (TimeUnit)((Object)object));
        Object object2 = d.v.e.k.e.h(this.a);
        object = ((z)object).z0((f0)object2);
        object2 = new h1(this, n10, bl2);
        ((z)object).d((e.a.v0.g)object2);
    }

    public boolean z() {
        RecordUseCase recordUseCase = this.K;
        boolean bl2 = UseCases.b(recordUseCase);
        if (!bl2 && (bl2 = (recordUseCase = this.K).q())) {
            bl2 = true;
        } else {
            bl2 = false;
            recordUseCase = null;
        }
        return bl2;
    }

    public void z0() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        frameSizeUseCase = this.M;
        int n10 = this.S0();
        frameSizeUseCase.j(n10);
    }

    public MutableLiveData z1() {
        return this.z;
    }

    public void z2() {
        FrameSizeUseCase frameSizeUseCase = this.M;
        boolean bl2 = UseCases.b(frameSizeUseCase);
        if (bl2) {
            return;
        }
        this.M.v();
    }

    public void z3(long l10) {
        this.A3(l10, null);
    }
}

