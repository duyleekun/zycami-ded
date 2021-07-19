/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.draft.withdraw;

import androidx.core.util.Pair;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.SpeedUseCase;
import com.zhiyun.editorsdk.fundation.IUseCase;
import com.zhiyun.editorsdk.fundation.UseCases;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import com.zhiyun.editorsdk.voice.MusicUseCase;
import com.zhiyun.editorsdk.voice.RecordUseCase;
import com.zhiyun.editorsdk.voice.VoiceUseCase;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.i.b.k.a;
import d.v.i.b.k.a1;
import d.v.i.b.k.b;
import d.v.i.b.k.b0;
import d.v.i.b.k.c0;
import d.v.i.b.k.c1;
import d.v.i.b.k.d0;
import d.v.i.b.k.d1;
import d.v.i.b.k.e;
import d.v.i.b.k.e0;
import d.v.i.b.k.f;
import d.v.i.b.k.f0;
import d.v.i.b.k.g;
import d.v.i.b.k.g0;
import d.v.i.b.k.h;
import d.v.i.b.k.h0;
import d.v.i.b.k.i;
import d.v.i.b.k.i0;
import d.v.i.b.k.j;
import d.v.i.b.k.j0;
import d.v.i.b.k.k;
import d.v.i.b.k.k0;
import d.v.i.b.k.l;
import d.v.i.b.k.l0;
import d.v.i.b.k.m;
import d.v.i.b.k.m0;
import d.v.i.b.k.n;
import d.v.i.b.k.n0;
import d.v.i.b.k.o;
import d.v.i.b.k.o0;
import d.v.i.b.k.p;
import d.v.i.b.k.p0;
import d.v.i.b.k.q;
import d.v.i.b.k.q0;
import d.v.i.b.k.r;
import d.v.i.b.k.r0;
import d.v.i.b.k.s;
import d.v.i.b.k.s0;
import d.v.i.b.k.t;
import d.v.i.b.k.t0;
import d.v.i.b.k.u;
import d.v.i.b.k.u0;
import d.v.i.b.k.v;
import d.v.i.b.k.v0;
import d.v.i.b.k.w;
import d.v.i.b.k.w0;
import d.v.i.b.k.x;
import d.v.i.b.k.x0;
import d.v.i.b.k.y;
import d.v.i.b.k.y0;
import d.v.i.b.k.z;
import d.v.i.b.k.z0;
import d.v.j.e.g.a0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WithdrawTemplateUseCase
extends TemplateUseCase {
    private void A0(List object) {
        int n10 = this.c.size();
        Object object2 = IntStream.range(0, n10);
        d.v.i.b.k.a0 a02 = new d.v.i.b.k.a0(this, (List)object);
        object = object2.filter(a02);
        object2 = new g0(this);
        object.forEach((IntConsumer)object2);
    }

    private /* synthetic */ boolean A1(List object, int n10) {
        object = ((TemplateVideo)object.get(n10)).getRotate();
        TemplateRotate templateRotate = ((TemplateVideo)this.c.get(n10)).getRotate();
        return ((TemplateRotate)object).equals(templateRotate) ^ true;
    }

    private void A2(String[] object, String[] object2, IntConsumer intConsumer) {
        object = this.L0((String[])object2, (String[])object);
        int n10 = object.size();
        object2 = IntStream.range(0, n10);
        r0 r02 = new r0((List)object);
        object2.map(r02).forEach(intConsumer);
    }

    private /* synthetic */ void C1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.V(n10, templateVideo, false);
    }

    private /* synthetic */ boolean E1(List object, int n10) {
        object = ((TemplateVideo)object.get(n10)).getRotateFrame();
        TemplateRotateFrame templateRotateFrame = ((TemplateVideo)this.c.get(n10)).getRotateFrame();
        return ((TemplateRotateFrame)object).equals(templateRotateFrame) ^ true;
    }

    private int E2(Object[] objectArray, int n10, int n11, Object object) {
        int n12 = objectArray.length;
        n12 = (int)(this.w2(n12, n10, n11) ? 1 : 0);
        int n13 = -1;
        if (n12 != 0) {
            return n13;
        }
        while (n10 <= n11) {
            Comparable comparable = (Comparable)objectArray[n10];
            n12 = comparable.compareTo(object);
            if (n12 == 0) {
                n13 = n10;
                break;
            }
            ++n10;
        }
        return n13;
    }

    private void F0(List object, TemplateGlobal object2) {
        int n10 = this.c.size();
        Object object3 = IntStream.range(0, n10);
        r r10 = new r(this, (List)object);
        object = object3.filter(r10);
        object3 = new w(this);
        object.forEach((IntConsumer)object3);
        object = ((TemplateGlobal)object2).getRoi();
        object2 = this.b.getRoi();
        boolean bl2 = ((TemplateRoi)object).equals(object2);
        if (!bl2) {
            this.R(false);
        }
        this.g0();
    }

    private /* synthetic */ void G1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.W(n10, templateVideo, false);
    }

    private /* synthetic */ boolean I1(List object, int n10) {
        boolean bl2;
        int n11;
        float f10;
        object = (TemplateVideo)object.get(n10);
        List list = this.c;
        Object object2 = (TemplateVideo)list.get(n10);
        float f11 = ((TemplateVideo)object).getRate();
        int n12 = Float.compare(f11, f10 = ((TemplateVideo)object2).getRate());
        if (n12 == 0 && (n12 = ((TemplateVideo)object).getRateType()) == (n11 = ((TemplateVideo)object2).getRateType()) && (bl2 = ((String)(object = ((TemplateVideo)object).getBezierRate())).equals(object2 = ((TemplateVideo)object2).getBezierRate()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void K1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.X(n10, templateVideo);
    }

    private List L0(String[] object, String[] object2) {
        int n10 = ((String[])object2).length;
        Object object3 = IntStream.range(0, n10).boxed();
        Object object4 = Collectors.toList();
        object3 = object3.collect(object4);
        object4 = new AtomicInteger(0);
        object = Arrays.stream(object);
        t t10 = new t(this, (String[])object2, (AtomicInteger)object4);
        object = object.map(t10);
        object3.getClass();
        object2 = new b((List)object3);
        object.forEach(object2);
        return object3;
    }

    private List M0(a0 stream, a0 collector) {
        int n10;
        collector = ((a0)((Object)collector)).a().getTemplateVideoList();
        stream = ((a0)((Object)stream)).a().getTemplateVideoList();
        int n11 = collector.size();
        if (n11 != (n10 = stream.size())) {
            return Collections.emptyList();
        }
        n10 = collector.size();
        IntStream intStream = IntStream.range(0, n10);
        l l10 = new l((List)((Object)collector), (List)((Object)stream));
        stream = intStream.filter(l10).boxed();
        collector = Collectors.toList();
        return stream.collect(collector);
    }

    public static /* synthetic */ boolean M1(List object, List object2, int n10) {
        boolean bl2;
        object = ((TemplateVideo)object.get(n10)).getTransition();
        object2 = ((TemplateVideo)object2.get(n10)).getTransition();
        if (object != null && (bl2 = ((TemplateTransition)object).equals(object2))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private List N0(a0 stream, a0 collector) {
        int n10;
        collector = ((a0)((Object)collector)).a().getTemplateVideoList();
        stream = ((a0)((Object)stream)).a().getTemplateVideoList();
        int n11 = collector.size();
        if (n11 != (n10 = stream.size())) {
            return Collections.emptyList();
        }
        n10 = collector.size();
        IntStream intStream = IntStream.range(0, n10);
        x0 x02 = new x0((List)((Object)collector), (List)((Object)stream));
        stream = intStream.filter(x02).boxed();
        collector = Collectors.toList();
        return stream.collect(collector);
    }

    private /* synthetic */ void N1(List object, int n10) {
        object = (TemplateVideo)object.get(n10);
        this.Z(n10, (TemplateVideo)object);
    }

    private Pair O0(List stringArray, List stringArray2) {
        stringArray = stringArray.stream();
        Object object = d1.a;
        stringArray = stringArray.map(object);
        i0 i02 = i0.a;
        stringArray = (String[])stringArray.toArray(i02);
        stringArray2 = stringArray2.stream().map(object);
        object = q0.a;
        stringArray2 = (String[])stringArray2.toArray((IntFunction<A[]>)object);
        return Pair.create(stringArray, stringArray2);
    }

    private Pair P0(a0 object, a0 object2, boolean bl2) {
        object = ((a0)object).a().getTemplateStickerList();
        object2 = ((a0)object2).a().getTemplateStickerList();
        j j10 = new j(bl2);
        object = Optional.ofNullable(object);
        Object object3 = Collections.emptyList();
        object = ((Optional)object).orElse(object3).stream().filter(j10);
        object3 = Collectors.toList();
        object = (List)object.collect(object3);
        object2 = Optional.ofNullable(object2);
        object3 = Collections.emptyList();
        object2 = ((Optional)object2).orElse(object3).stream().filter(j10);
        object3 = Collectors.toList();
        object2 = (List)object2.collect(object3);
        return Pair.create(object, object2);
    }

    public static /* synthetic */ boolean P1(Integer n10) {
        int n11 = n10;
        int n12 = 1;
        if ((n11 -= n12) < 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private Pair Q0(a0 object, a0 object2, boolean bl2) {
        object = this.P0((a0)object, (a0)object2, bl2);
        object2 = (List)((Pair)object).first;
        object = (List)((Pair)object).second;
        return this.O0((List)object2, (List)object);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void Q1(a0 object, boolean bl2, Integer n10) {
        void var3_4;
        Object object2 = this.S0((a0)object, bl2);
        int n11 = var3_4.intValue();
        long l10 = d.v.j.g.b0.d((TemplateAudioData)(object2 = (TemplateAudioData)object2.get(n11)));
        int n12 = this.H0(l10, bl2);
        if (n12 != 0) {
            n12 = var3_4.intValue();
            List list = bl2 ? this.n.m() : this.o.p();
            object = this.S0((a0)object, bl2);
            int n13 = var3_4.intValue();
            object = ((TemplateAudioData)object.get(n13)).getCustomerUUID();
            d.v.v.q.h.o0(n12, list, (String)object);
        }
    }

    private Pair R0(a0 object, a0 object2) {
        object = ((a0)object).a().getTemplateVideoList();
        object2 = ((a0)object2).a().getTemplateVideoList();
        return this.O0((List)object, (List)object2);
    }

    private List S0(a0 list, boolean bl2) {
        if (bl2) {
            list = Optional.ofNullable(((a0)((Object)list)).a().getTemplateMusicList());
            List list2 = Collections.emptyList();
            list = ((Optional)((Object)list)).orElse(list2);
        } else {
            list = Optional.ofNullable(((a0)((Object)list)).a().getTemplateRecordingList());
            List list3 = Collections.emptyList();
            list = ((Optional)((Object)list)).orElse(list3);
        }
        return list;
    }

    public static /* synthetic */ boolean S1(Integer n10) {
        int n11 = n10;
        int n12 = 1;
        if ((n11 -= n12) < 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private Pair T0(a0 object, a0 object2, boolean bl2) {
        object = this.S0((a0)object, bl2);
        object2 = this.S0((a0)object2, bl2);
        return Pair.create(object, object2);
    }

    private /* synthetic */ void T1(a0 a02, boolean bl2, a0 a03, Integer n10) {
        Object object = this.S0(a02, bl2);
        int n11 = n10;
        int n12 = 1;
        Object object2 = d.v.j.g.b0.e((TemplateAudioData)object.get(n11 -= n12));
        long l10 = object2[0];
        n11 = n10;
        long l11 = d.v.j.g.b0.e((TemplateAudioData)object.get(n11))[n12];
        int n13 = n10;
        this.B2(n13, bl2);
        n13 = n10;
        n11 = n13 + -1;
        object = this.S0(a02, bl2);
        int n14 = n10 - n12;
        long l12 = d.v.j.g.b0.d((TemplateAudioData)object.get(n14));
        object = this;
        this.J0(n11, l12, l10, l11, bl2);
        if (bl2) {
            object = a03;
            object = this.S0(a03, n12 != 0);
            n11 = n10 - n12;
            object = (TemplateAudioData)object.get(n11);
            object2 = this.m;
            n14 = n10 - n12;
            long l13 = ((TemplateAudioData)object).getFadeIn().getEndTime();
            TemplateAudioTransition templateAudioTransition = ((TemplateAudioData)object).getFadeIn();
            long l14 = templateAudioTransition.getStartTime();
            ((VoiceUseCase)object2).q(n14, l13 -= l14);
            object2 = this.m;
            n14 = n10 - n12;
            TemplateAudioTransition templateAudioTransition2 = ((TemplateAudioData)object).getFadeout();
            l13 = templateAudioTransition2.getEndTime();
            object = ((TemplateAudioData)object).getFadeout();
            l14 = ((TemplateAudioTransition)object).getStartTime();
            ((VoiceUseCase)object2).r(n14, l13 -= l14);
        }
    }

    private Pair U0(a0 object, a0 object2, boolean bl2) {
        object = this.T0((a0)object, (a0)object2, bl2);
        object2 = (List)((Pair)object).first;
        object = (List)((Pair)object).second;
        return this.O0((List)object2, (List)object);
    }

    private /* synthetic */ void V0(Pair object, String[] object2, a0 a02, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            Object[] objectArray = object = object.first;
            objectArray = object;
            int n12 = ((String[])object).length;
            object2 = object2[n10];
            n12 = this.E2(objectArray, 0, n12, object2);
            object2 = a02.a().getTemplateStickerList();
            object = (TemplateSticker)object2.get(n12);
            this.j0((TemplateSticker)object);
        }
    }

    private /* synthetic */ void V1(a0 object, boolean bl2, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            object = (TemplateAudioData)this.S0((a0)object, bl2).get(n10);
            object = this.l((TemplateAudioData)object);
            this.m0((d.v.h.h.b)object, bl2);
        }
    }

    private /* synthetic */ void X0(boolean bl2, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            String string2 = bl2 ? "gif" : "text";
            this.I(string2, n10);
        }
    }

    private /* synthetic */ void X1(boolean bl2, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            this.B2(n10, bl2);
        }
    }

    public static /* synthetic */ boolean Z0(List object, List list, int n10) {
        object = (TemplateSticker)object.get(n10);
        list = list.get(n10);
        return ((TemplateSticker)object).equals(list) ^ true;
    }

    public static /* synthetic */ boolean Z1(List object, List list, int n10) {
        object = (TemplateAudioData)object.get(n10);
        list = list.get(n10);
        return ((TemplateAudioData)object).equals(list) ^ true;
    }

    private /* synthetic */ void a1(List object, List list, int n10) {
        object = (TemplateSticker)object.get(n10);
        String string2 = ((TemplateSticker)object).getType();
        this.h0(string2, n10, (TemplateSticker)object, list);
    }

    private /* synthetic */ void a2(List object, List object2, boolean bl2, int n10) {
        object = (TemplateAudioData)object.get(n10);
        object2 = (TemplateAudioData)object2.get(n10);
        object = ((TemplateAudioData)object).getName();
        Object object3 = ((TemplateAudioData)object2).getName();
        boolean bl3 = ((String)object).equals(object3) ^ true;
        object2 = this.l((TemplateAudioData)object2);
        if (bl3) {
            this.C2((d.v.h.h.b)object2);
        } else {
            object = ((d.v.h.h.b)object2).d();
            long l10 = (Long)object;
            long l11 = ((d.v.h.h.b)object2).m();
            long l12 = ((d.v.h.h.b)object2).f();
            object3 = this;
            this.J0(n10, l10, l11, l12, bl2);
            if (bl2) {
                object = this.m;
                float f10 = ((d.v.h.h.b)object2).n();
                ((VoiceUseCase)object).d(n10, f10);
                object = this.m;
                long l13 = ((d.v.h.h.b)object2).g();
                ((VoiceUseCase)object).q(n10, l13);
                object = this.m;
                long l14 = ((d.v.h.h.b)object2).i();
                ((VoiceUseCase)object).r(n10, l14);
            } else {
                object = this.m;
                float f11 = ((d.v.h.h.b)object2).n();
                ((VoiceUseCase)object).e(n10, f11);
            }
        }
    }

    private /* synthetic */ boolean c1(List object, int n10) {
        object = ((TemplateVideo)object.get(n10)).getFilter();
        TemplateFilter templateFilter = ((TemplateVideo)this.c.get(n10)).getFilter();
        return ((TemplateFilter)object).equals(templateFilter) ^ true;
    }

    private /* synthetic */ boolean c2(List object, int n10) {
        object = ((TemplateVideo)object.get(n10)).getRoi();
        TemplateRoi templateRoi = ((TemplateVideo)this.c.get(n10)).getRoi();
        return ((TemplateRoi)object).equals(templateRoi) ^ true;
    }

    private /* synthetic */ void e1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.L(n10, templateVideo, false);
    }

    private /* synthetic */ void e2(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.b0(n10, templateVideo, false);
    }

    private /* synthetic */ boolean g1(List object, int n10) {
        object = ((TemplateVideo)object.get(n10)).getEffect();
        TemplateEffect templateEffect = ((TemplateVideo)this.c.get(n10)).getEffect();
        return ((TemplateEffect)object).equals(templateEffect) ^ true;
    }

    private /* synthetic */ Integer g2(String[] stringArray, AtomicInteger atomicInteger, String string2) {
        int n10;
        int n11;
        int n12 = atomicInteger.get();
        int n13 = this.E2(stringArray, n12, n11 = stringArray.length + -1, string2);
        if (n13 != (n10 = -1)) {
            atomicInteger.set(n13);
        }
        return atomicInteger.get();
    }

    private /* synthetic */ void i1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.M(n10, templateVideo, false);
    }

    public static /* synthetic */ boolean i2(List object, List object2, int n10) {
        boolean bl2;
        boolean bl3;
        String string2;
        object = (TemplateVideo)object.get(n10);
        object2 = (TemplateVideo)object2.get(n10);
        String string3 = ((TemplateVideo)object).getVideoPath();
        n10 = (int)(string3.equals(string2 = ((TemplateVideo)object2).getVideoPath()) ? 1 : 0);
        if (n10 != 0 && (bl3 = ((TemplateVideo)object).isReverse()) == (bl2 = ((TemplateVideo)object2).isReverse())) {
            bl3 = false;
            object = null;
        } else {
            bl3 = true;
        }
        return bl3;
    }

    private void j0(TemplateSticker templateSticker) {
        List list = this.s();
        this.a(list, templateSticker, false);
    }

    public static /* synthetic */ boolean j2(List object, List object2, int n10) {
        long l10;
        long l11;
        object = (TemplateVideo)object.get(n10);
        object2 = (TemplateVideo)object2.get(n10);
        long l12 = d.v.j.g.b0.h((TemplateVideo)object);
        long l13 = d.v.j.g.b0.h((TemplateVideo)object2);
        n10 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1));
        int n11 = 0;
        int n12 = 1;
        if ((n10 = n10 == 0 ? n12 : 0) == 0) {
            return n12 != 0;
        }
        l13 = d.v.j.g.b0.n((TemplateVideo)object);
        long l14 = l13 - (l11 = d.v.j.g.b0.n((TemplateVideo)object2));
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        n10 = n10 == 0 ? n12 : 0;
        if (n10 == 0) {
            return n12 != 0;
        }
        l13 = d.v.j.g.b0.j((TemplateVideo)object);
        long l15 = l13 - (l10 = d.v.j.g.b0.j((TemplateVideo)object2));
        Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object3 == false) {
            n11 = n12;
        }
        return n11 ^ true;
    }

    public static /* synthetic */ boolean k1(Integer n10) {
        int n11 = n10;
        int n12 = 1;
        if ((n11 -= n12) < 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ String[] k2(int n10) {
        return new String[n10];
    }

    private void l0(String[] object, String[] object2, IntConsumer intConsumer) {
        object = this.L0((String[])object, (String[])object2).stream();
        intConsumer.getClass();
        object2 = new a(intConsumer);
        object.forEach(object2);
    }

    private /* synthetic */ void l1(a0 object, Integer n10) {
        Object object2 = ((a0)object).a().getTemplateVideoList();
        int n11 = n10 + -1;
        object2 = (TemplateVideo)object2.get(n11);
        long l10 = d.v.j.g.b0.i((TemplateVideo)object2);
        int n12 = n10 + -1;
        int n13 = this.G0(n12, l10);
        if (n13 != 0) {
            n13 = n10;
            List list = this.l.H();
            object = ((a0)object).a().getTemplateVideoList();
            int n14 = n10;
            object = ((TemplateVideo)object.get(n14)).getCustomerUUID();
            d.v.v.q.h.o0(n13, list, (String)object);
        }
    }

    public static /* synthetic */ String[] l2(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ boolean m2(boolean bl2, TemplateSticker object) {
        if (bl2) {
            String string2 = "image";
            String string3 = ((TemplateSticker)object).getType();
            bl2 = string2.equals(string3);
            if (!bl2 && !(bl2 = ((String)(object = "gif")).equals(string3 = ((TemplateSticker)object).getType()))) {
                bl2 = false;
                string3 = null;
            } else {
                bl2 = true;
            }
            return bl2;
        }
        String string4 = ((TemplateSticker)object).getType();
        return "text".equals(string4);
    }

    public static /* synthetic */ boolean n1(Integer n10) {
        int n11 = n10;
        int n12 = 1;
        if ((n11 -= n12) < 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ String[] n2(int n10) {
        return new String[n10];
    }

    private /* synthetic */ void o1(a0 object, a0 object2, Integer n10) {
        object = ((a0)object).a().getTemplateVideoList();
        int n11 = n10;
        int n12 = 1;
        object = ((TemplateVideo)object.get(n11 -= n12)).clone();
        long l10 = d.v.j.g.b0.o((TemplateVideo)object);
        long l11 = d.v.j.g.b0.k((TemplateVideo)object);
        int n13 = n10 + -1;
        this.I0(n13, l10, l11);
        n11 = ((TemplateVideo)object).getRateType();
        if (n11 == n12) {
            SpeedUseCase speedUseCase = this.p;
            int n14 = n10 - n12;
            String string2 = ((TemplateVideo)object).getBezierRate();
            speedUseCase.f(n14, string2, false);
        }
        n11 = n10;
        this.K0(n11);
        object2 = ((a0)object2).a().getTemplateVideoList();
        n11 = n10;
        object2 = ((TemplateVideo)object2.get(n11)).getTransition();
        ((TemplateVideo)object).setTransition((TemplateTransition)object2);
        int n15 = n10 - n12;
        this.Z(n15, (TemplateVideo)object);
    }

    public static /* synthetic */ boolean o2(List object, int n10) {
        boolean bl2;
        if ((object = ((TemplateVideo)object.get(n10)).getTransition()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void p0(List object, TemplateGlobal object2) {
        int n10 = this.c.size();
        Object object3 = IntStream.range(0, n10);
        k0 k02 = new k0(this, (List)object);
        object = object3.filter(k02);
        object3 = new y0(this);
        object.forEach((IntConsumer)object3);
        object = ((TemplateGlobal)object2).getFilter();
        object2 = this.b.getFilter();
        boolean bl2 = ((TemplateFilter)object).equals(object2);
        if (!bl2) {
            this.N(false);
        }
        this.c0();
    }

    private /* synthetic */ void p2(List object, int n10) {
        object = (TemplateVideo)object.get(n10);
        this.Z(n10, (TemplateVideo)object);
    }

    private void q0(List object, TemplateGlobal object2) {
        int n10 = this.c.size();
        Object object3 = IntStream.range(0, n10);
        p0 p02 = new p0(this, (List)object);
        object = object3.filter(p02);
        object3 = new f0(this);
        object.forEach((IntConsumer)object3);
        object = ((TemplateGlobal)object2).getEffect();
        object2 = this.b.getEffect();
        boolean bl2 = ((TemplateEffect)object).equals(object2);
        if (!bl2) {
            this.O(false);
        }
        this.d0();
    }

    private /* synthetic */ void q1(a0 object, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            object = (TemplateVideo)((a0)object).a().getTemplateVideoList().get(n10);
            d.v.h.e.a a10 = this.k((TemplateVideo)object);
            this.k0(n10, a10);
            this.i0(n10, (TemplateVideo)object);
        }
    }

    private /* synthetic */ void r2(List object, List list, int n10) {
        String string2 = ((TemplateSticker)object.get(n10)).getType();
        object = (TemplateSticker)object.get(n10);
        this.h0(string2, n10, (TemplateSticker)object, list);
    }

    private /* synthetic */ void s1(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            this.K0(n10);
        }
    }

    private /* synthetic */ void t2(List object, boolean bl2, int n10) {
        object = (TemplateAudioData)object.get(n10);
        long[] lArray = d.v.j.g.b0.e((TemplateAudioData)object);
        long l10 = d.v.j.g.b0.d((TemplateAudioData)object);
        long l11 = lArray[0];
        long l12 = lArray[1];
        this.J0(n10, l10, l11, l12, bl2);
    }

    private /* synthetic */ void u1(a0 object, Integer n10) {
        object = ((a0)object).a().getTemplateVideoList();
        int n11 = n10;
        object = (TemplateVideo)object.get(n11);
        long l10 = d.v.j.g.b0.o((TemplateVideo)object);
        long l11 = d.v.j.g.b0.k((TemplateVideo)object);
        int n12 = n10;
        this.I0(n12, l10, l11);
    }

    public static /* synthetic */ int v2(List list, int n10) {
        int n11 = list.size() + -1 - n10;
        return (Integer)list.get(n11);
    }

    private /* synthetic */ void w1(String[] object, String[][] stringArray, int n10) {
        int n11;
        Object object2 = object[n10];
        String[] stringArray2 = stringArray[0][n10];
        boolean n112 = ((String)object2).equals(stringArray2);
        if (n112) {
            return;
        }
        object2 = stringArray[0];
        stringArray2 = stringArray[0];
        int n12 = stringArray2.length + -1;
        int n13 = this.E2((Object[])object2, n10, n12, object = object[n10]);
        if (n13 == (n11 = -1)) {
            object = new Object[]{};
            m.a.a.i("\u9700\u8981\u4ea4\u6362\u7684\u4f4d\u7f6e\u672a\u627e\u5230", (Object[])object);
            return;
        }
        object2 = this.l;
        if ((n13 = (int)(((MainUseCase)object2).o(n13, n10, false) ? 1 : 0)) != 0) {
            object = this.l.H().stream();
            Object object3 = d.v.i.b.k.f.a;
            object = object.map(object3);
            object3 = n0.a;
            object = (String[])object.toArray((IntFunction<A[]>)object3);
            stringArray[0] = object;
        }
    }

    private boolean w2(int n10, int n11, int n12) {
        Object[] objectArray;
        boolean bl2;
        int n13 = 2;
        boolean bl3 = true;
        if (n11 > n12) {
            Object[] objectArray2 = new Object[n13];
            Integer n14 = n11;
            objectArray2[0] = n14;
            n14 = n12;
            objectArray2[bl3] = n14;
            m.a.a.i("fromIndex:%d > toIndex:%d", objectArray2);
            return bl3;
        }
        if (n11 < 0) {
            bl2 = bl3;
        } else {
            bl2 = false;
            objectArray = null;
        }
        boolean bl4 = n12 > n10 ? bl3 : false;
        if (bl2 |= bl4) {
            objectArray = new Object[3];
            Integer n15 = n11;
            objectArray[0] = n15;
            Integer n16 = n10;
            objectArray[bl3] = n16;
            n16 = n12;
            objectArray[n13] = n16;
            m.a.a.i("out of range,fromIndex:%d,arrayLength:%d,toIndex:%d", objectArray);
            return bl3;
        }
        return false;
    }

    private void x0() {
        int n10 = this.c.size();
        IntStream intStream = IntStream.range(0, n10);
        y y10 = new y(this);
        intStream.forEach(y10);
        this.Q();
        this.e0();
    }

    private void x2(a0 object, a0 a02) {
        Object object2 = a02.a().getTemplateVideoList();
        int n10 = object2.size();
        Object object3 = IntStream.range(0, n10);
        Object object4 = new u((List)object2);
        object3 = object3.filter((IntPredicate)object4);
        object4 = new v(this, (List)object2);
        object3.forEach((IntConsumer)object4);
        boolean bl2 = true;
        object3 = this.P0((a0)object, a02, bl2);
        object4 = (List)((Pair)object3).first;
        int n11 = object4.size();
        List list = (List)((Pair)object3).second;
        int n12 = list.size();
        if (n11 != n12) {
            this.n0((a0)object, a02, bl2);
            object3 = (List)((Pair)object3).second;
            this.y2((List)object3);
        } else {
            this.o0((a0)object, a02, bl2);
        }
        object3 = this.P0((a0)object, a02, false);
        object4 = (List)((Pair)object3).first;
        n11 = object4.size();
        list = (List)((Pair)object3).second;
        n12 = list.size();
        if (n11 != n12) {
            this.n0((a0)object, a02, false);
            object3 = (List)((Pair)object3).second;
            this.y2((List)object3);
        } else {
            this.o0((a0)object, a02, false);
        }
        object3 = this.T0((a0)object, a02, bl2);
        object4 = (List)((Pair)object3).first;
        n11 = object4.size();
        list = (List)((Pair)object3).second;
        n12 = list.size();
        if (n11 != n12) {
            this.D0((a0)object, a02, false);
            object3 = (List)((Pair)object3).second;
            this.z2((List)object3, bl2);
        } else {
            this.E0((a0)object, a02, bl2);
        }
        object2 = this.T0((a0)object, a02, false);
        object3 = (List)((Pair)object2).first;
        n10 = object3.size();
        object4 = (List)((Pair)object2).second;
        n11 = object4.size();
        if (n10 != n11) {
            this.D0((a0)object, a02, false);
            object = (List)((Pair)object2).second;
            this.z2((List)object, false);
        } else {
            this.E0((a0)object, a02, false);
        }
    }

    private void y0(List object, TemplateGlobal object2) {
        int n10 = this.c.size();
        Object object3 = IntStream.range(0, n10);
        d0 d02 = new d0(this, (List)object);
        object = object3.filter(d02);
        object3 = new q(this);
        object.forEach((IntConsumer)object3);
        object = ((TemplateGlobal)object2).getRotate();
        object2 = this.b.getRotate();
        boolean bl2 = ((TemplateRotate)object).equals(object2);
        if (!bl2) {
            this.P(false);
        }
        this.f0();
    }

    private /* synthetic */ void y1(int n10) {
        TemplateVideo templateVideo = (TemplateVideo)this.c.get(n10);
        this.a0(n10, templateVideo);
    }

    private void y2(List list) {
        List list2 = this.s();
        int n10 = list.size();
        IntStream intStream = IntStream.range(0, n10);
        o o10 = new o(this, list, list2);
        intStream.forEach(o10);
    }

    private void z0(List object) {
        int n10 = this.c.size();
        Object object2 = IntStream.range(0, n10);
        w0 w02 = new w0(this, (List)object);
        object = object2.filter(w02);
        object2 = new h0(this);
        object.forEach((IntConsumer)object2);
    }

    private void z2(List list, boolean bl2) {
        int n10 = list.size();
        IntStream intStream = IntStream.range(0, n10);
        u0 u02 = new u0(this, list, bl2);
        intStream.forEach(u02);
    }

    public boolean B0(a0 object, a0 object2) {
        int n10;
        object2 = ((a0)object2).a().getTemplateVideoList();
        object = ((a0)object).a().getTemplateVideoList();
        int n11 = object2.size();
        if (n11 != (n10 = object.size())) {
            return false;
        }
        n11 = object2.size();
        Object object3 = IntStream.range(0, n11);
        x x10 = new x((List)object2, (List)object);
        object = object3.filter(x10);
        object3 = new n(this, (List)object2);
        object.forEach((IntConsumer)object3);
        return true;
    }

    public /* synthetic */ boolean B1(List list, int n10) {
        return this.A1(list, n10);
    }

    public boolean B2(int n10, boolean bl2) {
        boolean bl3 = false;
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.n;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            musicUseCase = this.n;
            bl3 = TemplateUseCase.w;
            return musicUseCase.s(n10, bl3);
        }
        RecordUseCase recordUseCase = this.o;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        recordUseCase = this.o;
        bl3 = TemplateUseCase.w;
        return recordUseCase.w(n10, bl3);
    }

    public boolean C0(a0 stream, a0 a02, boolean bl2) {
        Object object = this.U0((a0)((Object)stream), a02, bl2);
        Object object2 = (String[])((Pair)object).first;
        object = (String[])((Pair)object).second;
        int n10 = ((String[])object2).length;
        int n11 = ((String[])object).length;
        int n12 = 1;
        if ((n10 = n10 < n11 ? n12 : 0) != 0) {
            stream = this.L0((String[])object2, (String[])object).stream();
            object = s0.a;
            stream = stream.filter(object);
            object = new m0(this, a02, bl2);
            stream.forEach(object);
        } else {
            object = this.L0((String[])object, (String[])object2).stream();
            object2 = z0.a;
            object = object.filter(object2);
            object2 = new m(this, (a0)((Object)stream), bl2, a02);
            object.forEach(object2);
        }
        return n12 != 0;
    }

    public boolean C2(d.v.h.h.b b10) {
        int n10;
        Long l10 = b10.d();
        long l11 = l10;
        int n11 = d.v.v.q.h.E(l11);
        if (n11 != (n10 = -1)) {
            MusicUseCase musicUseCase = this.n;
            boolean bl2 = TemplateUseCase.w;
            return musicUseCase.u(n11, b10, bl2);
        }
        return this.m0(b10, true);
    }

    public boolean D0(a0 stringArray, a0 object, boolean bl2) {
        p p10;
        stringArray = this.U0((a0)stringArray, (a0)object, bl2);
        String[] stringArray2 = (String[])stringArray.first;
        stringArray = (String[])stringArray.second;
        int n10 = stringArray2.length;
        int n11 = stringArray.length;
        int n12 = 1;
        if (n10 < n11) {
            n10 = n12;
        } else {
            n10 = 0;
            p10 = null;
        }
        if (n10) {
            p10 = new p(this, (a0)object, bl2);
            this.l0(stringArray2, stringArray, p10);
        } else {
            object = new t0(this, bl2);
            this.A2(stringArray2, stringArray, (IntConsumer)object);
        }
        return n12;
    }

    public /* synthetic */ void D1(int n10) {
        this.C1(n10);
    }

    public boolean D2(int n10) {
        this.l.d0(n10, null);
        return true;
    }

    public boolean E0(a0 object, a0 object2, boolean bl2) {
        int n10;
        object = this.S0((a0)object, bl2).stream();
        Object object3 = c1.a;
        object = object.map(object3);
        Object object4 = Collectors.toList();
        object = object.collect(object4);
        object2 = this.S0((a0)object2, bl2).stream().map(object3);
        object3 = Collectors.toList();
        object2 = (List)object2.collect(object3);
        int n11 = object.size();
        if (n11 != (n10 = object2.size())) {
            return false;
        }
        n11 = object2.size();
        object3 = IntStream.range(0, n11);
        object4 = new o0((List)object, (List)object2);
        object3 = object3.filter((IntPredicate)object4);
        object4 = new g(this, (List)object, (List)object2, bl2);
        object3.forEach((IntConsumer)object4);
        return true;
    }

    public /* synthetic */ boolean F1(List list, int n10) {
        return this.E1(list, n10);
    }

    public boolean G0(int n10, long l10) {
        MainUseCase mainUseCase = this.l;
        boolean bl2 = TemplateUseCase.w;
        return mainUseCase.u(n10, l10, bl2);
    }

    public boolean H0(long l10, boolean bl2) {
        boolean bl3 = false;
        if (bl2) {
            MusicUseCase musicUseCase = this.n;
            bl2 = UseCases.b(musicUseCase);
            if (bl2) {
                return false;
            }
            musicUseCase = this.n;
            bl3 = TemplateUseCase.w;
            return musicUseCase.i(l10, bl3);
        }
        RecordUseCase recordUseCase = this.o;
        bl2 = UseCases.b(recordUseCase);
        if (bl2) {
            return false;
        }
        recordUseCase = this.o;
        bl3 = TemplateUseCase.w;
        return recordUseCase.k(l10, bl3);
    }

    public /* synthetic */ void H1(int n10) {
        this.G1(n10);
    }

    public boolean I0(int n10, long l10, long l11) {
        MainUseCase mainUseCase = this.l;
        boolean bl2 = TemplateUseCase.w;
        return mainUseCase.A(n10, l10, l11, bl2);
    }

    public boolean J0(int n10, long l10, long l11, long l12, boolean bl2) {
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        if (bl2) {
            MusicUseCase musicUseCase = this.n;
            n11 = (int)(UseCases.b(musicUseCase) ? 1 : 0);
            if (n11 != 0) {
                return false;
            }
            MusicUseCase musicUseCase2 = this.n;
            boolean bl3 = TemplateUseCase.w;
            return musicUseCase2.k(n10, l10, l11, l12, false, bl3);
        }
        RecordUseCase recordUseCase = this.o;
        n11 = (int)(UseCases.b(recordUseCase) ? 1 : 0);
        if (n11 != 0) {
            return false;
        }
        RecordUseCase recordUseCase2 = this.o;
        boolean bl4 = TemplateUseCase.w;
        return recordUseCase2.m(n10, l10, l11, l12, false, bl4);
    }

    public /* synthetic */ boolean J1(List list, int n10) {
        return this.I1(list, n10);
    }

    public boolean K0(int n10) {
        MainUseCase mainUseCase = this.l;
        boolean bl2 = TemplateUseCase.w;
        return mainUseCase.c0(n10, bl2);
    }

    public /* synthetic */ void L1(int n10) {
        this.K1(n10);
    }

    public /* synthetic */ void O1(List list, int n10) {
        this.N1(list, n10);
    }

    public /* synthetic */ void R1(a0 a02, boolean bl2, Integer n10) {
        this.Q1(a02, bl2, n10);
    }

    public /* synthetic */ void U1(a0 a02, boolean bl2, a0 a03, Integer n10) {
        this.T1(a02, bl2, a03, n10);
    }

    public /* synthetic */ void W0(Pair pair, String[] stringArray, a0 a02, int n10) {
        this.V0(pair, stringArray, a02, n10);
    }

    public /* synthetic */ void W1(a0 a02, boolean bl2, int n10) {
        this.V1(a02, bl2, n10);
    }

    public /* synthetic */ void Y0(boolean bl2, int n10) {
        this.X0(bl2, n10);
    }

    public /* synthetic */ void Y1(boolean bl2, int n10) {
        this.X1(bl2, n10);
    }

    public /* synthetic */ void b1(List list, List list2, int n10) {
        this.a1(list, list2, n10);
    }

    public /* synthetic */ void b2(List list, List list2, boolean bl2, int n10) {
        this.a2(list, list2, bl2, n10);
    }

    public /* synthetic */ boolean d1(List list, int n10) {
        return this.c1(list, n10);
    }

    public /* synthetic */ boolean d2(List list, int n10) {
        return this.c2(list, n10);
    }

    public /* synthetic */ void f1(int n10) {
        this.e1(n10);
    }

    public /* synthetic */ void f2(int n10) {
        this.e2(n10);
    }

    public /* synthetic */ boolean h1(List list, int n10) {
        return this.g1(list, n10);
    }

    public /* synthetic */ Integer h2(String[] stringArray, AtomicInteger atomicInteger, String string2) {
        return this.g2(stringArray, atomicInteger, string2);
    }

    public /* synthetic */ void j1(int n10) {
        this.i1(n10);
    }

    public void k0(int n10, d.v.h.e.a a10) {
        MainUseCase mainUseCase = this.l;
        boolean bl2 = TemplateUseCase.w;
        mainUseCase.h(n10, a10, bl2);
    }

    public boolean m0(d.v.h.h.b b10, boolean bl2) {
        boolean bl3;
        Object object;
        boolean bl4;
        boolean bl5 = false;
        if (!(!bl2 ? (bl4 = UseCases.b((IUseCase)(object = this.o))) || (bl4 = d.v.j.b.b((String)(object = b10.k()))) : (bl3 = UseCases.b((IUseCase)(object = this.n))))) {
            boolean bl6;
            long l10;
            object = b10.k();
            long l11 = d.v.v.q.h.C((String)object);
            long l12 = l11 - (l10 = (long)-1);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                return false;
            }
            b10.q(l11);
            if (bl2) {
                MusicUseCase musicUseCase = this.n;
                bl5 = TemplateUseCase.w;
                bl6 = musicUseCase.f(b10, bl5);
            } else {
                RecordUseCase recordUseCase = this.o;
                bl5 = TemplateUseCase.w;
                bl6 = recordUseCase.f(b10, bl5);
            }
            return bl6;
        }
        return false;
    }

    public /* synthetic */ void m1(a0 a02, Integer n10) {
        this.l1(a02, n10);
    }

    public boolean n0(a0 stringArray, a0 object, boolean bl2) {
        Object object2;
        stringArray = this.Q0((a0)stringArray, (a0)object, bl2);
        String[] stringArray2 = (String[])stringArray.first;
        stringArray = (String[])stringArray.second;
        int n10 = stringArray2.length;
        int n11 = stringArray.length;
        int n12 = 1;
        if (n10 < n11) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10) {
            Object object3 = ((a0)object).a().getTemplateStickerList();
            object2 = Collections.emptyList();
            object3 = this.O0((List)object3, (List)object2);
            object2 = ((a0)object).a();
            this.Y((TemplatePOJO)object2);
            object2 = new z(this, (Pair)object3, stringArray, (a0)object);
            this.l0(stringArray2, stringArray, (IntConsumer)object2);
        } else {
            object = new v0(this, bl2);
            this.A2(stringArray2, stringArray, (IntConsumer)object);
        }
        return n12;
    }

    public boolean o0(a0 object, a0 object2, boolean bl2) {
        int n10;
        object = this.P0((a0)object, (a0)object2, bl2);
        Object object3 = ((List)((Pair)object).first).stream();
        Object object4 = d.v.i.b.k.e.a;
        object3 = object3.map(object4);
        Object object5 = Collectors.toList();
        object3 = object3.collect(object5);
        object = ((List)((Pair)object).second).stream().map(object4);
        object4 = Collectors.toList();
        object = (List)object.collect(object4);
        int n11 = object3.size();
        if (n11 != (n10 = object.size())) {
            return false;
        }
        object2 = ((a0)object2).a();
        this.Y((TemplatePOJO)object2);
        object2 = this.s();
        n11 = object3.size();
        object4 = IntStream.range(0, n11);
        object5 = new e0((List)object3, (List)object);
        object3 = object4.filter((IntPredicate)object5);
        object4 = new k(this, (List)object, (List)object2);
        object3.forEach((IntConsumer)object4);
        return true;
    }

    public /* synthetic */ void p1(a0 a02, a0 a03, Integer n10) {
        this.o1(a02, a03, n10);
    }

    public /* synthetic */ void q2(List list, int n10) {
        this.p2(list, n10);
    }

    public boolean r0(long l10, a0 a02, a0 a03, d.v.e.g.e e10) {
        Object object = a03.a();
        this.Y((TemplatePOJO)object);
        object = a02.a().getTemplateVideoList();
        TemplateGlobal templateGlobal = a02.a().getTemplateGlobal();
        long l11 = 1L & l10;
        long l12 = 0L;
        Object object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object2 != false) {
            this.U();
        } else {
            l11 = (long)2 & l10;
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false) {
                this.p0((List)object, templateGlobal);
            } else {
                l11 = (long)4 & l10;
                long l14 = l11 - l12;
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 != false) {
                    this.A0((List)object);
                    this.x2(a02, a03);
                } else {
                    long l15 = (long)8 & l10;
                    long l16 = l15 - l12;
                    Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object3 != false) {
                        this.x0();
                    } else {
                        l15 = (long)16 & l10;
                        long l17 = l15 - l12;
                        object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                        if (object3 != false) {
                            this.y0((List)object, templateGlobal);
                            this.z0((List)object);
                        } else {
                            l15 = (long)64 & l10;
                            long l18 = l15 - l12;
                            object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                            if (object3 != false) {
                                this.q0((List)object, templateGlobal);
                            } else {
                                l15 = 32;
                                long l19 = (l10 &= l15) - l12;
                                Object object4 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                                if (object4 != false) {
                                    this.F0((List)object, templateGlobal);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (e10 != null) {
            e10.a();
        }
        return true;
    }

    public /* synthetic */ void r1(a0 a02, int n10) {
        this.q1(a02, n10);
    }

    public boolean s0(a0 a02, a0 a03) {
        Object object = this.R0(a02, a03);
        Object object2 = (String[])((Pair)object).first;
        object = (String[])((Pair)object).second;
        int n10 = ((String[])object2).length;
        int n11 = ((String[])object).length;
        int n12 = 1;
        if ((n10 = n10 < n11 ? n12 : 0) != 0) {
            object = this.L0((String[])object2, (String[])object).stream();
            object2 = d.v.i.b.k.i.a;
            object = object.filter(object2);
            object2 = new h(this, a03);
            object.forEach(object2);
        } else {
            object = this.L0((String[])object, (String[])object2).stream();
            object2 = a1.a;
            object = object.filter(object2);
            object2 = new s(this, a03, a02);
            object.forEach(object2);
        }
        this.x2(a02, a03);
        return n12 != 0;
    }

    public /* synthetic */ void s2(List list, List list2, int n10) {
        this.r2(list, list2, n10);
    }

    public boolean t0(a0 object, a0 a02) {
        j0 j02;
        String[] stringArray = this.R0((a0)object, a02);
        String[] stringArray2 = (String[])stringArray.first;
        stringArray = (String[])stringArray.second;
        int n10 = stringArray2.length;
        int n11 = stringArray.length;
        int n12 = 1;
        if (n10 < n11) {
            n10 = n12;
        } else {
            n10 = 0;
            j02 = null;
        }
        if (n10) {
            j02 = new j0(this, a02);
            this.l0(stringArray2, stringArray, j02);
            this.x2((a0)object, a02);
        } else {
            object = new b0(this);
            this.A2(stringArray2, stringArray, (IntConsumer)object);
        }
        return n12;
    }

    public /* synthetic */ void t1(int n10) {
        this.s1(n10);
    }

    public boolean u0(a0 a02, a0 a03) {
        Object object = this.N0(a02, a03);
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return false;
        }
        object = object.stream();
        l0 l02 = new l0(this, a03);
        object.forEach(l02);
        this.x2(a02, a03);
        return true;
    }

    public /* synthetic */ void u2(List list, boolean bl2, int n10) {
        this.t2(list, bl2, n10);
    }

    public boolean v0(a0 iterator2, a0 object) {
        int n10 = (iterator2 = this.M0((a0)((Object)iterator2), (a0)object)).isEmpty();
        if (n10 != 0) {
            return false;
        }
        iterator2 = iterator2.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            object = (Integer)iterator2.next();
            n10 = (Integer)object;
            this.D2(n10);
        }
        return true;
    }

    public /* synthetic */ void v1(a0 a02, Integer n10) {
        this.u1(a02, n10);
    }

    public boolean w0(a0 a02, a0 a03) {
        Object object = this.R0(a02, a03);
        String[] stringArray = ((Pair)object).second;
        String[] stringArray2 = stringArray;
        stringArray2 = stringArray;
        int n10 = stringArray2.length;
        c0 c02 = null;
        int n11 = 1;
        if (n10 != n11) {
            object = ((Pair)object).first;
            stringArray2 = object;
            stringArray2 = (String[])object;
            n10 = stringArray2.length;
            String[] stringArray3 = stringArray;
            stringArray3 = stringArray;
            int n12 = stringArray3.length;
            if (n10 == n12) {
                stringArray2 = new String[n11][];
                object = (String[])object;
                stringArray2[0] = object;
                int n13 = stringArray.length;
                object = IntStream.range(0, n13);
                c02 = new c0(this, stringArray, (String[][])stringArray2);
                object.forEach(c02);
                this.B0(a02, a03);
                return n11 != 0;
            }
        }
        return false;
    }

    public /* synthetic */ void x1(String[] stringArray, String[][] stringArray2, int n10) {
        this.w1(stringArray, stringArray2, n10);
    }

    public /* synthetic */ void z1(int n10) {
        this.y1(n10);
    }
}

