/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.editorsdk.draft;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.draft.withdraw.WithdrawUseCase;
import com.zhiyun.editortemplate.data.api.entity.template.Description;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.e.k.e;
import d.v.e.l.c2;
import d.v.e.l.h2;
import d.v.e.l.j2;
import d.v.e.l.l2;
import d.v.h.e.d;
import d.v.h.k.b;
import d.v.i.b.a;
import d.v.i.b.c;
import d.v.i.b.f;
import d.v.i.b.h;
import d.v.i.b.i;
import d.v.i.b.j;
import d.v.j.e.g.a0;
import d.v.j.e.g.y;
import d.v.j.e.g.z;
import d.v.j.g.b0;
import e.a.i0;
import e.a.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DraftUseCase {
    private final z a;
    private final WithdrawUseCase b;
    private Executor c;

    public DraftUseCase() {
        Object object = new j2();
        this.c = object;
        this.a = object = y.q();
        this.b = object = new WithdrawUseCase();
    }

    private List A(List object) {
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            object = null;
        } else {
            object = object.stream();
            Object object2 = new f(this);
            object = object.map(object2);
            object2 = Collectors.toList();
            object = (List)object.collect(object2);
        }
        return object;
    }

    private List B(List object) {
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            object = null;
        } else {
            object = object.stream();
            Object object2 = new d.v.i.b.b(this);
            object = object.map(object2);
            object2 = Collectors.toList();
            object = (List)object.collect(object2);
        }
        return object;
    }

    private TemplateRoi C(boolean bl2, int n10) {
        return b0.q(n10);
    }

    private TemplateRotate D(boolean bl2, int n10) {
        TemplateRotate templateRotate = new TemplateRotate(bl2, n10);
        return templateRotate;
    }

    private TemplateRotateFrame E(d d10) {
        CharSequence charSequence = new StringBuilder();
        float f10 = d10.G();
        charSequence.append(f10);
        charSequence.append(",");
        f10 = d10.H();
        charSequence.append(f10);
        charSequence = charSequence.toString();
        String string2 = d10.s();
        int n10 = d10.F();
        TemplateRotateFrame templateRotateFrame = new TemplateRotateFrame(string2, (String)charSequence, n10);
        return templateRotateFrame;
    }

    private TemplateSticker F(d.v.h.d.c c10, d.v.h.d.d d10) {
        Object object;
        Object object2 = null;
        if (c10 == null && d10 == null) {
            return null;
        }
        Object object3 = ",";
        boolean bl2 = false;
        Object object4 = null;
        if (c10 != null) {
            long l10 = c10.e();
            long l11 = c10.e();
            long l12 = c10.i();
            float f10 = c10.d();
            Object object5 = new StringBuilder();
            float f11 = c10.f().a;
            object5.append(f11);
            object5.append((String)object3);
            float f12 = c10.f().b;
            object5.append(f12);
            String string2 = object5.toString();
            object3 = c10.g();
            object5 = DecorationType.GIF_PASTER;
            object3 = object3 == object5 ? "gif" : "image";
            Object object6 = object3;
            long l13 = c10.z();
            float f13 = c10.j()[0];
            float f14 = 0.0f;
            boolean bl3 = false;
            f12 = 0.0f;
            object3 = null;
            Object var25_34 = null;
            Object var26_36 = null;
            Object var27_38 = null;
            boolean bl4 = true;
            object4 = c10.g();
            object2 = DecorationType.IMAGE_PASTER;
            object2 = object4 == object2 ? b0.w(c10.x()) : null;
            object4 = c10.g();
            Object object7 = object4 == object5 ? (object4 = b0.w(c10.x())) : null;
            String string3 = b0.w(c10.A());
            boolean bl5 = b0.u(c10.x());
            object5 = object;
            object4 = object;
            object = new TemplateSticker(l10, l11 += l12, f10, string2, (String)object6, l13, f13, 0.0f, null, null, null, null, bl4, (String)object2, (String)object7, string3, bl5);
            object2 = c10.a();
            ((TemplateBaseData)object).setCustomerUUID((String)object2);
        } else {
            long l14 = d10.e();
            long l15 = d10.e();
            long l16 = d10.i();
            l15 += l16;
            float f15 = d10.d();
            Object object8 = new StringBuilder();
            float f16 = d10.f().a;
            object8.append(f16);
            object8.append((String)object3);
            float f17 = d10.f().b;
            object8.append(f17);
            String string4 = object8.toString();
            long l17 = 0L;
            float f18 = d10.j()[0];
            f17 = d10.w();
            float f19 = h2.e(f17);
            object = b0.w(d10.v());
            int n10 = d10.x();
            String string5 = Integer.toHexString(n10).toUpperCase();
            String string6 = d10.y();
            object3 = d10.t();
            Object object9 = object3 == null ? null : (object3 = b0.w(d10.t().b()));
            object3 = d10.t();
            if (object3 == null || (n10 = (int)(b0.u((String)(object3 = d10.t().b())) ? 1 : 0)) != 0) {
                bl2 = true;
            }
            boolean bl6 = bl2;
            Object var29_43 = null;
            Object var30_45 = null;
            boolean bl7 = b0.u(d10.v());
            String string7 = "text";
            object8 = object2;
            object2 = new TemplateSticker(l14, l15, f15, string4, string7, l17, f18, f19, (String)object, string5, string6, (String)object9, bl2, null, null, null, bl7);
            object3 = d10.a();
            ((TemplateBaseData)object2).setCustomerUUID((String)object3);
            object = object2;
        }
        return object;
    }

    private List G(List object, List collector) {
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2 && (bl2 = d.v.j.b.f((List)((Object)collector)))) {
            boolean bl3 = false;
            object = null;
        } else {
            boolean bl4;
            ArrayList arrayList = new ArrayList();
            boolean bl5 = d.v.j.b.f((List)object);
            if (!bl5) {
                object = object.stream();
                Object object2 = new d.v.i.b.d(this);
                object = object.map(object2);
                object2 = Collectors.toList();
                object = (Collection)object.collect(object2);
                arrayList.addAll(object);
            }
            if (!(bl4 = d.v.j.b.f((List)((Object)collector)))) {
                object = collector.stream();
                collector = new Collector(this);
                object = object.map(collector);
                collector = Collectors.toList();
                object = object.collect(collector);
                arrayList.addAll(object);
            }
            object = arrayList;
        }
        return object;
    }

    private List H(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, List object) {
        object = object.stream();
        c c10 = new c(this, bl6, bl2, bl3, bl4, bl5);
        Stream stream = object.map(c10);
        Collector collector = Collectors.toList();
        return stream.collect(collector);
    }

    private TemplatePOJO a(TemplateData templateData, TemplateGlobal templateGlobal, List list, List list2, List list3, List list4) {
        TemplatePOJO templatePOJO = new TemplatePOJO();
        templatePOJO.setTemplateData(templateData);
        templatePOJO.setTemplateGlobal(templateGlobal);
        templatePOJO.setTemplateMusicList(list3);
        templatePOJO.setTemplateRecordingList(list4);
        templatePOJO.setTemplateStickerList(list2);
        templatePOJO.setTemplateVideoList(list);
        return templatePOJO;
    }

    private boolean c(TemplatePOJO templatePOJO) {
        Object object = this.b.d().orElse(null);
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        if ((object = ((a0)object).a()) == null) {
            return bl2;
        }
        object = ((TemplatePOJO)object).clone();
        ((TemplatePOJO)object).setDraft(null);
        ((TemplatePOJO)object).setTemplate(null);
        ((TemplatePOJO)object).setWithdraw(null);
        List list = ((TemplatePOJO)object).getTemplateMusicList();
        boolean bl3 = d.v.j.b.f(list);
        if (bl3) {
            ((TemplatePOJO)object).setTemplateMusicList(null);
        }
        if (bl3 = d.v.j.b.f(list = ((TemplatePOJO)object).getTemplateRecordingList())) {
            ((TemplatePOJO)object).setTemplateRecordingList(null);
        }
        if (bl3 = d.v.j.b.f(list = ((TemplatePOJO)object).getTemplateVideoList())) {
            ((TemplatePOJO)object).setTemplateVideoList(null);
        }
        if (bl3 = d.v.j.b.f(list = ((TemplatePOJO)object).getTemplateStickerList())) {
            ((TemplatePOJO)object).setTemplateStickerList(null);
        }
        ((TemplatePOJO)object).setScriptTrackPOJOList(null);
        return templatePOJO.equals(object) ^ bl2;
    }

    private /* synthetic */ void e(List object, long l10, int n10, boolean bl2, float f10, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n11, d.v.h.f.a a10, boolean bl7, int n12, List list, List list2, List list3, List list4, List list5, long l11, Consumer consumer) {
        Consumer consumer2 = consumer;
        Object list6 = object;
        Object object2 = ((d)object.get(0)).i();
        int bl8 = object.size();
        TemplateData templateData = this.x((String)object2, bl8, l10);
        object2 = this;
        TemplateGlobal templateGlobal = this.w(l10, n10, bl2, f10, bl3, bl4, bl5, bl6, n11, a10, bl7, n12);
        boolean bl9 = bl2;
        object2 = this.H(bl2, bl5, bl6, bl7, bl4, list);
        list6 = list2;
        list6 = this.A(list2);
        List list7 = list3;
        list7 = this.B(list3);
        List list8 = list4;
        list8 = this.G(list4, list5);
        object = this;
        boolean bl10 = this.c((TemplatePOJO)(object2 = this.a(templateData, templateGlobal, (List)object2, list8, (List)list6, list7)));
        if (bl10) {
            boolean bl11 = true;
            this.s((TemplatePOJO)object2, l11, bl11);
        }
        if (consumer2 != null) {
            object2 = Boolean.TRUE;
            consumer2.accept(object2);
        }
    }

    private /* synthetic */ TemplateMusic g(d.v.h.h.b b10) {
        TemplateMusic templateMusic;
        DraftUseCase draftUseCase = this;
        Object object = b10;
        String string2 = b0.w(b10.k());
        String string3 = b10.j();
        Object object2 = b10.d();
        long l10 = (Long)object2;
        long l11 = b10.m();
        long l12 = b10.f();
        float f10 = b10.n();
        float f11 = b10.n();
        int n10 = Float.compare(f11, 0.0f);
        boolean bl2 = true;
        boolean bl3 = n10 == 0 ? bl2 : false;
        boolean bl4 = b0.u(b10.k());
        TemplateAudioTransition templateAudioTransition = draftUseCase.t(0, (d.v.h.h.b)object);
        TemplateAudioTransition templateAudioTransition2 = draftUseCase.t((int)(bl2 ? 1 : 0), (d.v.h.h.b)object);
        object2 = templateMusic;
        TemplateAudioTransition templateAudioTransition3 = templateAudioTransition;
        templateAudioTransition = templateAudioTransition2;
        templateMusic = new TemplateMusic(string2, string3, l10, l11, l12, 1000000L, f10, bl3, bl4, templateAudioTransition3, templateAudioTransition2);
        object = b10.a();
        templateMusic.setCustomerUUID((String)object);
        return templateMusic;
    }

    private /* synthetic */ TemplateRecording i(d.v.h.h.b b10) {
        TemplateRecording templateRecording;
        DraftUseCase draftUseCase = this;
        Object object = b10;
        String string2 = b0.w(b10.k());
        String string3 = b10.j();
        Object object2 = b10.d();
        long l10 = (Long)object2;
        long l11 = b10.m();
        long l12 = b10.f();
        float f10 = b10.n();
        float f11 = b10.n();
        int n10 = Float.compare(f11, 0.0f);
        boolean bl2 = true;
        boolean bl3 = n10 == 0 ? bl2 : false;
        boolean bl4 = b0.u(b10.k());
        TemplateAudioTransition templateAudioTransition = draftUseCase.t(0, (d.v.h.h.b)object);
        TemplateAudioTransition templateAudioTransition2 = draftUseCase.t((int)(bl2 ? 1 : 0), (d.v.h.h.b)object);
        object2 = templateRecording;
        TemplateAudioTransition templateAudioTransition3 = templateAudioTransition;
        templateAudioTransition = templateAudioTransition2;
        templateRecording = new TemplateRecording(string2, string3, l10, l11, l12, 1000000L, f10, bl3, bl4, templateAudioTransition3, templateAudioTransition2);
        object = b10.a();
        templateRecording.setCustomerUUID((String)object);
        return templateRecording;
    }

    private /* synthetic */ TemplateSticker k(d.v.h.d.c c10) {
        return this.F(c10, null);
    }

    private /* synthetic */ TemplateSticker m(d.v.h.d.d d10) {
        return this.F(null, d10);
    }

    private /* synthetic */ TemplateVideo o(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, d d10) {
        TemplateTransition templateTransition;
        String string2;
        int n10;
        DraftUseCase draftUseCase = this;
        Object object = d10.w();
        Object object2 = d10.N();
        int n11 = 1;
        if (object2 != null && ((n10 = TextUtils.isEmpty((CharSequence)(string2 = ((b)object2).b()))) == 0 || (n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = ((b)object2).c())) ? 1 : 0)) == 0)) {
            n10 = ((b)object2).e();
            string2 = n10 == n11 ? ((b)object2).b() : ((b)object2).c();
            String string3 = b0.w(string2);
            long l10 = ((b)object2).a();
            long l11 = 1000000L;
            boolean bl7 = b0.u(string2);
            object2 = ((b)object2).d();
            String string4 = b0.w((String)object2);
            templateTransition = new TemplateTransition(string3, l10, l11, bl7, string4);
        } else {
            templateTransition = null;
        }
        long l12 = d10.J();
        long l13 = d10.u();
        long l14 = d10.d();
        boolean bl8 = d10.Q();
        float f10 = d10.O();
        boolean bl9 = bl2 ^ true;
        float f11 = (float)d10.I();
        int n12 = d10.R();
        String string5 = d10.t();
        int n13 = bl3 ^ 1;
        TemplateFilter templateFilter = draftUseCase.z(n13 != 0, (d.v.h.f.a)object);
        n13 = bl4 ^ 1;
        TemplateEffect templateEffect = draftUseCase.y(n13 != 0, (d.v.h.f.a)object);
        boolean bl10 = bl5 ^ true;
        n13 = d10.y();
        TemplateRotate templateRotate = draftUseCase.D(bl10, n13);
        bl10 = bl6 ^ true;
        n11 = d10.A();
        TemplateRoi templateRoi = draftUseCase.C(bl10, n11);
        object = d10;
        TemplateRotateFrame templateRotateFrame = draftUseCase.E(d10);
        String string6 = d10.e();
        boolean bl11 = b0.u(d10.e());
        boolean bl12 = d10.j();
        String string7 = d10.g();
        object2 = new TemplateVideo(1000000L, l12, l13, l14, bl8, f10, bl9, f11, n12, string5, templateFilter, templateEffect, templateRotate, templateTransition, templateRoi, templateRotateFrame, string6, bl11, bl12, string7);
        object = d10.a();
        ((TemplateBaseData)object2).setCustomerUUID((String)object);
        return object2;
    }

    private TemplateAudioTransition t(int n10, d.v.h.h.b b10) {
        if (n10 == 0) {
            TemplateAudioTransition templateAudioTransition;
            long l10 = b10.g();
            float f10 = b10.n();
            TemplateAudioTransition templateAudioTransition2 = templateAudioTransition;
            templateAudioTransition = new TemplateAudioTransition(0L, l10, 0.0f, f10);
            return templateAudioTransition;
        }
        long l11 = b10.e();
        long l12 = b10.i();
        long l13 = l11 - l12;
        long l14 = b10.e();
        float f11 = b10.n();
        TemplateAudioTransition templateAudioTransition = new TemplateAudioTransition(l13, l14, f11, 0.0f);
        return templateAudioTransition;
    }

    private TemplateGlobal w(long l10, int n10, boolean bl2, float f10, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n11, d.v.h.f.a a10, boolean bl7, int n12) {
        DraftUseCase draftUseCase = this;
        int n13 = n10;
        d.v.h.f.a a11 = a10;
        String[] stringArray = EditConfig$a.l;
        String string2 = stringArray[n10];
        int n14 = 6;
        n13 = n10 == n14 ? 1 : 0;
        int n15 = n13;
        n13 = (int)(bl2 ? 1 : 0);
        TemplateFilter templateFilter = draftUseCase.z(bl2, a11);
        n13 = (int)(bl5 ? 1 : 0);
        TemplateEffect templateEffect = draftUseCase.y(bl5, a11);
        n13 = (int)(bl6 ? 1 : 0);
        TemplateRotate templateRotate = draftUseCase.D(bl6, n11);
        n13 = (int)(bl7 ? 1 : 0);
        TemplateRoi templateRoi = draftUseCase.C(bl7, n12);
        TemplateGlobal templateGlobal = new TemplateGlobal(l10, 1000000L, string2, n15, f10, bl3, bl4, templateFilter, templateEffect, templateRotate, templateRoi);
        return templateGlobal;
    }

    private TemplateData x(String string2, int n10, long l10) {
        TemplateData templateData = new TemplateData();
        templateData.setTemplateUseType(2);
        templateData.setCoverUrl(string2);
        templateData.setVideoCount(n10);
        double d10 = l2.a(l10, 3);
        templateData.setVideoTime(d10);
        return templateData;
    }

    private TemplateEffect y(boolean bl2, d.v.h.f.a a10) {
        a10 = a10.m();
        float f10 = ((Float)a10.get(2)).floatValue();
        float f11 = ((Float)a10.get(1)).floatValue();
        float f12 = ((Float)a10.get(3)).floatValue();
        float f13 = ((Float)a10.get(4)).floatValue();
        float f14 = ((Float)a10.get(0)).floatValue();
        float f15 = ((Float)a10.get(5)).floatValue();
        float f16 = ((Float)a10.get(6)).floatValue();
        TemplateEffect templateEffect = new TemplateEffect(bl2, f10, f11, f12, f13, f14, f15, f16);
        return templateEffect;
    }

    private TemplateFilter z(boolean bl2, d.v.h.f.a a10) {
        int n10 = a10.l();
        String string2 = n10 == 0 ? a10.i() : a10.j();
        String string3 = b0.w(string2);
        n10 = (int)(b0.u(string2) ? 1 : 0);
        float f10 = c2.d((float)a10.k() * 0.01f, 1);
        TemplateFilter templateFilter = new TemplateFilter(bl2, string3, n10 != 0, f10);
        return templateFilter;
    }

    public i0 I(long l10, String string2) {
        return this.a.b(l10, string2);
    }

    public i0 b(long l10) {
        i0 i02 = this.a.g(l10);
        p0 p02 = e.f();
        return i02.s(p02);
    }

    public LiveData d() {
        return this.a.h();
    }

    public /* synthetic */ void f(List list, long l10, int n10, boolean bl2, float f10, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n11, d.v.h.f.a a10, boolean bl7, int n12, List list2, List list3, List list4, List list5, List list6, long l11, Consumer consumer) {
        this.e(list, l10, n10, bl2, f10, bl3, bl4, bl5, bl6, n11, a10, bl7, n12, list2, list3, list4, list5, list6, l11, consumer);
    }

    public /* synthetic */ TemplateMusic h(d.v.h.h.b b10) {
        return this.g(b10);
    }

    public /* synthetic */ TemplateRecording j(d.v.h.h.b b10) {
        return this.i(b10);
    }

    public /* synthetic */ TemplateSticker l(d.v.h.d.c c10) {
        return this.k(c10);
    }

    public /* synthetic */ TemplateSticker n(d.v.h.d.d d10) {
        return this.m(d10);
    }

    public /* synthetic */ TemplateVideo p(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, d d10) {
        return this.o(bl2, bl3, bl4, bl5, bl6, d10);
    }

    public void q(int n10) {
        this.a.c(n10);
    }

    public void r(String string2, String string3, Description description) {
        this.a.i(string2, string3, description);
    }

    public void s(TemplatePOJO templatePOJO, long l10, boolean bl2) {
        Object object = this.a;
        Optional optional = this.b.d();
        object.f(templatePOJO, optional);
        long l11 = 0x40000000L & l10;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false && bl2) {
            WithdrawUseCase withdrawUseCase = this.b;
            object = new a0(templatePOJO, l10);
            withdrawUseCase.j((a0)object);
        }
    }

    public void u(long l10, List list, long l11, int n10, boolean bl2, boolean bl3, boolean bl4, int n11, float f10, boolean bl5, boolean bl6, d.v.h.f.a a10, List list2, List list3, List list4, List list5, boolean bl7, int n12) {
        this.v(l10, list, l11, n10, bl2, bl3, bl4, n11, f10, bl5, bl6, a10, list2, list3, list4, list5, bl7, n12, null);
    }

    public void v(long l10, List list, long l11, int n10, boolean bl2, boolean bl3, boolean bl4, int n11, float f10, boolean bl5, boolean bl6, d.v.h.f.a a10, List list2, List list3, List list4, List list5, boolean bl7, int n12, Consumer consumer) {
        d.v.i.b.e e10;
        List list6;
        List list7;
        Stream stream;
        Object object;
        Stream stream2;
        boolean bl8 = d.v.j.b.f(list);
        if (bl8) {
            return;
        }
        Object object2 = list.stream();
        Object object3 = j.a;
        object2 = object2.map(object3);
        object3 = Collectors.toList();
        Object object4 = object2 = object2.collect(object3);
        object4 = (List)object2;
        bl8 = d.v.j.b.f(list2);
        object3 = null;
        if (bl8) {
            stream2 = null;
        } else {
            object2 = list2.stream();
            object = h.a;
            object2 = object2.map(object);
            object = Collectors.toList();
            object2 = (List)object2.collect(object);
            stream2 = object2;
        }
        bl8 = d.v.j.b.f(list3);
        if (bl8) {
            stream = null;
        } else {
            object2 = list3.stream();
            object = h.a;
            object2 = object2.map(object);
            object = Collectors.toList();
            object2 = (List)object2.collect(object);
            stream = object2;
        }
        bl8 = d.v.j.b.f(list4);
        if (bl8) {
            list7 = null;
        } else {
            object2 = list4.stream();
            object = d.v.i.b.a.a;
            object2 = object2.map(object);
            object = Collectors.toList();
            object2 = object2.collect(object);
            list7 = object2;
        }
        bl8 = d.v.j.b.f(list5);
        if (bl8) {
            list6 = null;
        } else {
            object2 = list5.stream();
            object3 = i.a;
            object2 = object2.map(object3);
            object3 = Collectors.toList();
            object2 = object2.collect(object3);
            list6 = object2;
        }
        d.v.h.f.a a11 = a10.a();
        object2 = this;
        Executor executor = this.c;
        object3 = e10;
        object = this;
        object2 = e10;
        object2 = executor;
        e10 = new d.v.i.b.e(this, (List)object4, l11, n10, bl2, f10, bl5, bl6, bl3, bl4, n11, a11, bl7, n12, list, (List)((Object)stream2), (List)((Object)stream), list7, list6, l10, consumer);
        executor.execute(e10);
    }
}

