/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.SparseArray
 */
package com.zhiyun.editorsdk.template;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.SpeedUseCase;
import com.zhiyun.editorsdk.TransitionUseCase;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import com.zhiyun.editorsdk.decoration.StickerUseCase;
import com.zhiyun.editorsdk.decoration.TextUseCase;
import com.zhiyun.editorsdk.frame.FrameEffectUseCase;
import com.zhiyun.editorsdk.frame.FrameSizeUseCase;
import com.zhiyun.editorsdk.fundation.IUseCase;
import com.zhiyun.editorsdk.template.StickerBean;
import com.zhiyun.editorsdk.voice.MusicUseCase;
import com.zhiyun.editorsdk.voice.RecordUseCase;
import com.zhiyun.editorsdk.voice.VoiceUseCase;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$FilterType;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.editortemplate.TemEditorConfig$TemplateType;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
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
import d.v.e.f;
import d.v.e.h.c;
import d.v.e.l.h2;
import d.v.h.d.a$a;
import d.v.h.d.d$a;
import d.v.h.e.d;
import d.v.i.c.a;
import d.v.i.c.b;
import d.v.j.g.b0;
import d.v.v.q.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class TemplateUseCase {
    public static boolean w = false;
    public TemplatePOJO a;
    public TemplateGlobal b;
    public List c;
    public List d;
    public List e;
    public List f;
    public TemplatePOJO g;
    public TemplateGlobal h;
    public List i;
    public List j;
    public List k;
    public MainUseCase l;
    public VoiceUseCase m;
    public MusicUseCase n;
    public RecordUseCase o;
    public SpeedUseCase p;
    public FrameSizeUseCase q;
    public FrameEffectUseCase r;
    public TextUseCase s;
    public StickerUseCase t;
    public TransitionUseCase u;
    private List v;

    public TemplateUseCase() {
        ArrayList arrayList;
        this.v = arrayList = new ArrayList();
    }

    public static /* synthetic */ boolean F(TemplateSticker object, StickerBean object2) {
        boolean bl2;
        String string2 = ((TemplateSticker)object).getType();
        string2.hashCode();
        String string3 = "gif";
        boolean bl3 = string2.equals(string3);
        if (!bl3) {
            string3 = "image";
            boolean bl4 = string2.equals(string3);
            if (!bl4) {
                bl2 = false;
                object = null;
            } else {
                object = ((TemplateSticker)object).getImageName();
                object2 = ((StickerBean)object2).a();
                bl2 = ((String)object).equals(object2);
            }
        } else {
            object = ((TemplateSticker)object).getGifName();
            object2 = ((StickerBean)object2).a();
            bl2 = ((String)object).equals(object2);
        }
        return bl2;
    }

    public static /* synthetic */ void G(AtomicReference serializable, AtomicReference atomicReference, StickerBean stickerBean) {
        Float f10 = Float.valueOf(stickerBean.b());
        serializable.set(f10);
        serializable = Long.valueOf(stickerBean.c());
        atomicReference.set(serializable);
    }

    private void c(TemplateSticker object, boolean bl2, List list, boolean bl3) {
        if ((object = this.m((TemplateSticker)object, bl2, list, bl3)) == null) {
            return;
        }
        StickerUseCase stickerUseCase = this.t;
        bl3 = w;
        stickerUseCase.f((d.v.h.d.c)object, null, bl3);
    }

    private void f(TemplateSticker object) {
        if ((object = this.n((TemplateSticker)object)) == null) {
            return;
        }
        Object object2 = ((d.v.h.d.d)object).t().b();
        Object object3 = new d$a();
        ((d.v.h.d.d)object).B((d$a)object3);
        object3 = this.s;
        boolean bl2 = w;
        ((TextUseCase)object3).f((d.v.h.d.d)object, bl2);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3 && !(bl3 = d.v.j.b.b((String)object2))) {
            object3 = this.s.i();
            object = ((d.v.h.d.a)object).e();
            long l10 = (Long)object;
            long l11 = 1L;
            int n10 = DecorationUseCases.b((List)object3, l10 += l11);
            object3 = this.s;
            d$a d$a = new d$a();
            object2 = d$a.c((String)object2);
            bl2 = w;
            ((TextUseCase)object3).q(n10, (d$a)object2, bl2);
        }
    }

    private boolean g(long l10) {
        long l11 = d.v.v.q.h.z();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private String j(String string2) {
        String string3 = TemEditorConfig.c(TemEditorConfig$SmartType.SMART_LOCAL, string2);
        boolean bl2 = d.v.j.b.b(string3);
        if (bl2) {
            string3 = TemEditorConfig.c(EditConfig$ResourceType.MUSIC, string2);
        }
        return string3;
    }

    private d.v.h.d.d n(TemplateSticker object) {
        boolean bl2;
        Object object2 = this.o((TemplateSticker)object);
        long l10 = this.b.getTimebase();
        Object object3 = b0.g((TemplateSticker)object, l10);
        float f10 = 0.0f;
        long l11 = object3[0];
        boolean n10 = this.g(l11);
        int n11 = 0;
        float f11 = 0.0f;
        Object object4 = null;
        if (!n10) {
            return null;
        }
        int n12 = 1;
        long l12 = object3[n12];
        long l13 = object3[0];
        long l14 = (l12 -= l13) - (l13 = 0L);
        Object object5 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object5 <= 0) {
            return null;
        }
        long l15 = object3[0];
        Object object6 = l15;
        l13 = object3[n12];
        long l16 = object3[0];
        d.v.h.d.d d10 = new d.v.h.d.d((a$a)object2, (Long)object6, l13 -= l16);
        object2 = ((TemplateSticker)object).getTextCaptionName();
        if (object2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
            bl2 = ((TemplateSticker)object).isTextCaptionLocalSource();
            if (bl2) {
                object3 = EditConfig$ResourceType.CAPTION;
                object2 = TemEditorConfig.c((d.v.e.j.a)object3, (String)object2);
            }
        } else {
            object2 = "";
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)object2)) && (bl2 = d.v.j.b.b((String)object2))) {
            return null;
        }
        bl2 = ((TemplateSticker)object).isLocalSource();
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object3 = (Object)((TemplateSticker)object).getTextFontName())))) {
            object3 = EditConfig$ResourceType.FONT;
            object6 = ((TemplateSticker)object).getTextFontName();
            object3 = TemEditorConfig.c((d.v.e.j.a)object3, (String)object6);
        } else {
            object3 = ((TemplateSticker)object).getTextFontName();
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl3 && (bl3 = d.v.j.b.b((String)object3))) {
            return null;
        }
        object3 = d10.G((String)object3);
        object4 = ((TemplateSticker)object).getTextContent();
        object3 = object3.J((String)object4);
        n11 = h2.g(((TemplateSticker)object).getTextFontSize());
        object3 = object3.H(n11);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("#");
        object6 = ((TemplateSticker)object).getTextColor();
        ((StringBuilder)object4).append((String)object6);
        n11 = Color.parseColor((String)((StringBuilder)object4).toString());
        object3 = object3.I(n11);
        object4 = new d$a();
        object2 = ((d$a)object4).c((String)object2);
        object2 = object3.B((d$a)object2);
        float f12 = ((TemplateSticker)object).getAngle();
        object2 = ((d.v.h.d.a)object2).l(f12);
        object3 = new float[2];
        f11 = ((TemplateSticker)object).getScale();
        object3[0] = (long)f11;
        f10 = ((TemplateSticker)object).getScale();
        object3[n12] = (long)f10;
        object2 = ((d.v.h.d.a)object2).q((float[])object3);
        object = ((TemplateBaseData)object).getCustomerUUID();
        ((d.v.h.b)object2).b((String)object);
        return d10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private a$a o(TemplateSticker object) {
        String string2 = ((TemplateSticker)object).getCenter();
        String string3 = ",";
        String[] stringArray = string2.split(string3);
        int n10 = stringArray.length;
        a$a a$a = null;
        int n11 = 2;
        if (n10 != n11) {
            return null;
        }
        n10 = 0;
        float f10 = 0.0f;
        string3 = null;
        try {
            string3 = stringArray[0];
        }
        catch (Exception exception) {
            return a$a;
        }
        f10 = Float.parseFloat(string3);
        n11 = 1;
        String string4 = stringArray[n11];
        float f11 = Float.parseFloat(string4);
        a$a a$a2 = new a$a(f10, f11);
        return a$a2;
    }

    private d.v.h.f.a p(TemplateFilter templateFilter) {
        FrameEffectUseCase frameEffectUseCase = this.r;
        Object object = templateFilter.getName();
        int n10 = frameEffectUseCase.g((String)object);
        object = null;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        n11 = 1;
        String string2 = n10 != n11 ? (n10 != (n11 = 2) ? "" : TemEditorConfig.b(TemEditorConfig$FilterType.FILTER_LUT)) : TemEditorConfig.b(TemEditorConfig$FilterType.FILTER_FX);
        boolean bl2 = templateFilter.isLocalSource();
        if (bl2 && n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = templateFilter.getName();
            stringBuilder.append(string2);
            string2 = d.v.e.j.b.d(stringBuilder.toString());
        } else {
            string2 = templateFilter.getName();
        }
        if (n10 != 0 && (bl2 = d.v.j.b.b(string2))) {
            return null;
        }
        object = new d.v.h.f.a();
        if (n10 == 0) {
            ((d.v.h.f.a)object).w(string2);
        } else {
            ((d.v.h.f.a)object).x(string2);
        }
        ((d.v.h.f.a)object).u(0);
        ((d.v.h.f.a)object).z(n10);
        int n12 = (int)(templateFilter.getStrength() * 100.0f);
        ((d.v.h.f.a)object).y(n12);
        return object;
    }

    private SparseArray r(TemplateEffect object) {
        Float f10;
        float f11;
        Float f12;
        int n10;
        int n11 = EditConfig$a.m.length;
        SparseArray sparseArray = new SparseArray(n11);
        n11 = 0;
        float f13 = 0.0f;
        Float f14 = null;
        int n12 = 1;
        float f15 = Float.MIN_VALUE;
        n10 = object != null && (n10 = ((TemplateEffect)object).isEnable()) != 0 ? 0 : n12;
        float f16 = 0.0f;
        if (n10 != 0) {
            f12 = null;
            f11 = 0.0f;
        } else {
            f11 = ((TemplateEffect)object).getExposure();
        }
        f12 = Float.valueOf(f11);
        sparseArray.put(0, (Object)f12);
        if (n10 != 0) {
            n11 = 0;
            f14 = null;
            f13 = 0.0f;
        } else {
            f13 = ((TemplateEffect)object).getContrast();
        }
        f14 = Float.valueOf(f13);
        sparseArray.put(n12, (Object)f14);
        n11 = 2;
        f13 = 2.8E-45f;
        if (n10 != 0) {
            n12 = 0;
            f10 = null;
            f15 = 0.0f;
        } else {
            f15 = ((TemplateEffect)object).getSaturation();
        }
        f10 = Float.valueOf(f15);
        sparseArray.put(n11, (Object)f10);
        n11 = 3;
        f13 = 4.2E-45f;
        if (n10 != 0) {
            n12 = 0;
            f10 = null;
            f15 = 0.0f;
        } else {
            f15 = ((TemplateEffect)object).getTemperature();
        }
        f10 = Float.valueOf(f15);
        sparseArray.put(n11, (Object)f10);
        n11 = 4;
        f13 = 5.6E-45f;
        if (n10 != 0) {
            n12 = 0;
            f10 = null;
            f15 = 0.0f;
        } else {
            f15 = ((TemplateEffect)object).getHue();
        }
        f10 = Float.valueOf(f15);
        sparseArray.put(n11, (Object)f10);
        n11 = 5;
        f13 = 7.0E-45f;
        if (n10 != 0) {
            n12 = 0;
            f10 = null;
            f15 = 0.0f;
        } else {
            f15 = ((TemplateEffect)object).getVignette();
        }
        f10 = Float.valueOf(f15);
        sparseArray.put(n11, (Object)f10);
        n11 = 6;
        f13 = 8.4E-45f;
        if (n10 == 0) {
            f16 = ((TemplateEffect)object).getSharpen();
        }
        object = Float.valueOf(f16);
        sparseArray.put(n11, object);
        return sparseArray;
    }

    private MediaType v(String string2) {
        String string3 = ".mp4";
        boolean bl2 = string2.endsWith(string3);
        if (bl2) {
            return MediaType.VIDEO;
        }
        string3 = ".gif";
        boolean bl3 = string2.endsWith(string3);
        if (bl3) {
            return MediaType.GIF;
        }
        return MediaType.IMAGE;
    }

    private d.v.h.k.b x(TemplateVideo object) {
        int n10;
        Object object2;
        Object object3 = ((TemplateVideo)object).getTransition();
        d.v.h.k.b b10 = new d.v.h.k.b();
        if (object3 != null && (object2 = ((TemplateTransition)object3).getName()) != null && (n10 = TextUtils.isEmpty((CharSequence)(object2 = ((TemplateTransition)object3).getName()))) == 0) {
            int n11;
            object2 = this.u;
            Object object4 = ((TemplateTransition)object3).getName();
            n10 = ((TransitionUseCase)object2).i((String)object4);
            if (n10 == (n11 = -1)) {
                return b10;
            }
            long l10 = b0.r((TemplateVideo)object);
            boolean bl2 = ((TemplateTransition)object3).isLocalSource();
            int n12 = 1;
            if (bl2 && n10 != n12) {
                EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.TRANSITION;
                object3 = ((TemplateTransition)object3).getName();
                object3 = TemEditorConfig.c(editConfig$ResourceType, (String)object3);
            } else {
                object3 = ((TemplateTransition)object3).getName();
            }
            if (n10 != n12 && (bl2 = d.v.j.b.b((String)object3))) {
                return b10;
            }
            b10.f(l10);
            b10.j(n10);
            object = ((TemplateVideo)object).getTransition().getThumb();
            n11 = (int)(b0.u((String)object) ? 1 : 0);
            if (n11 != 0) {
                object = b0.w((String)object);
            }
            object4 = EditConfig$ResourceType.TRANSITION;
            object = TemEditorConfig.c((d.v.e.j.a)object4, (String)object);
            b10.i((String)object);
            if (n10 == n12) {
                b10.g((String)object3);
            } else {
                b10.h((String)object3);
            }
        }
        return b10;
    }

    private void y() {
        IUseCase iUseCase;
        this.m = iUseCase = (VoiceUseCase)this.l.K(VoiceUseCase.class);
        iUseCase = (MusicUseCase)this.l.K(MusicUseCase.class);
        this.n = iUseCase;
        iUseCase = (RecordUseCase)this.l.K(RecordUseCase.class);
        this.o = iUseCase;
        iUseCase = (SpeedUseCase)this.l.K(SpeedUseCase.class);
        this.p = iUseCase;
        iUseCase = (FrameSizeUseCase)this.l.K(FrameSizeUseCase.class);
        this.q = iUseCase;
        iUseCase = (FrameEffectUseCase)this.l.K(FrameEffectUseCase.class);
        this.r = iUseCase;
        iUseCase = (TextUseCase)this.l.K(TextUseCase.class);
        this.s = iUseCase;
        iUseCase = (StickerUseCase)this.l.K(StickerUseCase.class);
        this.t = iUseCase;
        iUseCase = (TransitionUseCase)this.l.K(TransitionUseCase.class);
        this.u = iUseCase;
    }

    private boolean z() {
        int n10;
        int n11;
        ArrayList arrayList;
        d.v.h.e.a[] aArray = this.g.getTemplateVideoList();
        this.k = arrayList = new ArrayList();
        int n12 = 0;
        arrayList = null;
        Object object = null;
        for (n11 = 0; n11 < (n10 = aArray.size()); ++n11) {
            Object object2;
            Object object3 = (TemplateVideo)aArray.get(n11);
            boolean bl2 = ((TemplateVideo)object3).isLocalSource();
            if (bl2) {
                object2 = TemEditorConfig$TemplateType.EOV;
                object3 = ((TemplateVideo)object3).getVideoPath();
                object3 = TemEditorConfig.c((d.v.e.j.a)object2, (String)object3);
            } else {
                object3 = ((TemplateVideo)object3).getVideoPath();
            }
            object2 = new Object[]{object3};
            Object object4 = "path = %s";
            m.a.a.b(object4, (Object[])object2);
            bl2 = d.v.j.b.b((String)object3);
            if (bl2) continue;
            object2 = new d.v.h.e.a();
            ((d.v.h.e.a)object2).l((String)object3);
            object4 = this.v((String)object3);
            ((d.v.h.e.a)object2).m((MediaType)((Object)object4));
            ((d.v.h.e.a)object2).p((String)object3);
            object3 = this.k;
            object3.add(object2);
        }
        int n13 = this.k.size();
        aArray = new d.v.h.e.a[n13];
        while (n12 < (n11 = (object = this.k).size())) {
            aArray[n12] = object = (d.v.h.e.a)this.k.get(n12);
            ++n12;
        }
        return this.l.P(aArray);
    }

    public boolean A() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = ((TemplateGlobal)object).getEffect()) != null && (bl2 = ((TemplateEffect)(object = this.b.getEffect())).isEnable())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean B() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = ((TemplateGlobal)object).getFilter()) != null && (bl2 = ((TemplateFilter)(object = this.b.getFilter())).isEnable())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean C() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = ((TemplateGlobal)object).getRotate()) != null && (bl2 = ((TemplateRotate)(object = this.b.getRotate())).isEnable())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean D() {
        boolean bl2;
        TemplateGlobal templateGlobal = this.b;
        if (templateGlobal != null && (bl2 = templateGlobal.isVoiceEnable())) {
            bl2 = true;
        } else {
            bl2 = false;
            templateGlobal = null;
        }
        return bl2;
    }

    public boolean E() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (object = ((TemplateGlobal)object).getRoi()) != null && (bl2 = ((TemplateRoi)(object = this.b.getRoi())).isEnable())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void H() {
        CallChangeUseCase callChangeUseCase = this.s;
        boolean bl2 = w;
        ((TextUseCase)callChangeUseCase).k(bl2);
        callChangeUseCase = this.t;
        bl2 = w;
        ((StickerUseCase)callChangeUseCase).l(bl2);
    }

    public void I(String object, int n10) {
        ((String)object).hashCode();
        int bl2 = ((String)object).hashCode();
        int n11 = -1;
        switch (bl2) {
            default: {
                break;
            }
            case 100313435: {
                String string4 = "image";
                boolean bl5 = ((String)object).equals(string4);
                if (!bl5) break;
                n11 = 2;
                break;
            }
            case 3556653: {
                String string2 = "text";
                boolean bl3 = ((String)object).equals(string2);
                if (!bl3) break;
                n11 = 1;
                break;
            }
            case 102340: {
                String string3 = "gif";
                boolean bl4 = ((String)object).equals(string3);
                if (!bl4) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                break;
            }
            case 1: {
                object = this.s;
                boolean bl5 = w;
                ((TextUseCase)object).m(n10, bl5);
                break;
            }
            case 0: 
            case 2: {
                object = this.t;
                boolean bl6 = w;
                ((StickerUseCase)object).o(n10, bl6);
            }
        }
    }

    public void J(TemplateGlobal templateGlobal) {
        this.h = templateGlobal;
    }

    public boolean K(TemplatePOJO object) {
        this.g = object;
        this.h = object = ((TemplatePOJO)object).getTemplateGlobal();
        this.i = object = this.g.getTemplateVideoList();
        this.j = object = this.g.getTemplateStickerList();
        return this.z();
    }

    public void L(int n10, TemplateVideo object, boolean bl2) {
        String string2;
        boolean bl3;
        if ((object = ((TemplateVideo)object).getFilter()) != null && ((bl3 = ((TemplateFilter)object).isEnable()) || !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = ((TemplateFilter)object).getName()))))) {
            bl3 = false;
            string2 = null;
        } else {
            bl3 = true;
        }
        if (bl3) {
            this.r.k(n10, bl2);
            return;
        }
        if ((object = this.p((TemplateFilter)object)) == null) {
            this.r.k(n10, bl2);
            return;
        }
        this.r.a(n10, (d.v.h.f.a)object, bl2);
    }

    public void M(int n10, TemplateVideo object, boolean bl2) {
        object = ((TemplateVideo)object).getEffect();
        object = this.r((TemplateEffect)object);
        this.r.n(n10, (SparseArray)object, bl2);
    }

    public void N(boolean bl2) {
        String string2;
        boolean bl3;
        Object object = this.b.getFilter();
        if (object != null && ((bl3 = ((TemplateFilter)object).isEnable()) || !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = ((TemplateFilter)object).getName()))))) {
            bl3 = false;
            string2 = null;
        } else {
            bl3 = true;
        }
        if (bl3) {
            this.r.l(bl2);
            return;
        }
        if ((object = this.p((TemplateFilter)object)) == null) {
            this.r.l(bl2);
            return;
        }
        this.r.b((d.v.h.f.a)object, bl2);
    }

    public void O(boolean bl2) {
        TemplateEffect templateEffect = this.b.getEffect();
        templateEffect = this.r(templateEffect);
        this.r.r((SparseArray)templateEffect, bl2);
    }

    public void P(boolean bl2) {
        TemplateRotate templateRotate = this.b.getRotate();
        if (templateRotate == null) {
            this.q.c(0, bl2);
            return;
        }
        int n10 = templateRotate.getRotate();
        this.q.c(n10, bl2);
    }

    public void Q() {
        boolean bl2 = this.b.isMute();
        float f10 = this.b.getVolume();
        this.m.a(f10);
        this.m.p(bl2);
    }

    public void R(boolean bl2) {
        TemplateRoi templateRoi = this.b.getRoi();
        if (templateRoi == null) {
            this.q.g(0, bl2);
            return;
        }
        int n10 = b0.s(templateRoi);
        this.q.g(n10, bl2);
    }

    public void S(List list) {
        this.v.clear();
        this.v.addAll(list);
    }

    public boolean T(int n10, boolean bl2) {
        return this.m.o(n10, bl2);
    }

    public void U() {
        FrameSizeUseCase frameSizeUseCase = this.q;
        int n10 = this.u();
        frameSizeUseCase.a(n10);
    }

    public void V(int n10, TemplateVideo object, boolean bl2) {
        if ((object = ((TemplateVideo)object).getRotate()) == null) {
            this.q.b(n10, 0, bl2);
            return;
        }
        int n11 = ((TemplateRotate)object).getRotate();
        this.q.b(n10, n11, bl2);
    }

    public void W(int n10, TemplateVideo object, boolean bl2) {
        Object object2;
        float f10;
        int n11;
        object = ((TemplateVideo)object).getRotateFrame();
        int n12 = 1065353216;
        float f11 = 1.0f;
        int n13 = 0;
        float f12 = 0.0f;
        String string2 = null;
        if (object == null) {
            this.q.x(n10, f11);
            this.q.e(n10, 0, 0);
            this.q.w(n10, 0, bl2);
            this.q.u(n10, 0, bl2);
            return;
        }
        Object object3 = ((TemplateRotateFrame)object).getScale();
        String string3 = ",";
        int n14 = 1;
        float f13 = Float.MIN_VALUE;
        int n15 = 2;
        float f14 = 2.8E-45f;
        if (object3 != null) {
            object3 = ((TemplateRotateFrame)object).getScale().split(string3);
            int n16 = ((String[])object3).length;
            if (n16 == n15) {
                String string4 = object3[0];
                float f15 = d.v.e.h.c.b(string4, f11);
                f11 = d.v.e.h.c.b(object3[n14], f11);
                object3 = this.q;
                float f16 = Math.abs(f15);
                float f17 = Math.abs(f11);
                ((FrameSizeUseCase)object3).y(n10, f16, f17);
                n11 = 0;
                f10 = 0.0f;
                object3 = null;
                float f18 = f15 - 0.0f;
                n16 = (int)(f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1));
                if (n16 < 0) {
                    float f19 = f11 - 0.0f;
                    n12 = (int)(f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1));
                    if (n12 < 0) {
                        n12 = 3;
                        f11 = 4.2E-45f;
                    } else {
                        n12 = n15;
                        f11 = f14;
                    }
                } else {
                    float f20 = f11 - 0.0f;
                    n12 = (int)(f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1));
                    if (n12 < 0) {
                        n12 = n14;
                        f11 = f13;
                    } else {
                        n12 = 0;
                        object2 = null;
                        f11 = 0.0f;
                    }
                }
                object3 = this.q;
                ((FrameSizeUseCase)object3).u(n10, n12, bl2);
            }
        } else {
            object3 = this.q;
            ((FrameSizeUseCase)object3).x(n10, f11);
        }
        if ((n12 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((TemplateRotateFrame)object).getCenter())) ? 1 : 0)) == 0) {
            object2 = ((TemplateRotateFrame)object).getCenter().split(string3);
            n11 = ((String[])object2).length;
            if (n11 == n15) {
                string2 = object2[0];
                f12 = d.v.e.h.c.a(string2);
                object2 = object2[n14];
                f11 = d.v.e.h.c.a((String)object2);
                object3 = d.v.v.q.h.c0();
                int n17 = object3.getWidth();
                float f21 = n17;
                n14 = 0x3F000000;
                f13 = 0.5f;
                n13 = (int)(f21 *= (f12 -= f13));
                n11 = object3.getHeight();
                f10 = n11;
                n12 = (int)(f10 *= (f11 -= f13));
                object3 = this.q;
                ((FrameSizeUseCase)object3).e(n10, n13, n12);
            }
        } else {
            object2 = this.q;
            ((FrameSizeUseCase)object2).e(n10, 0, 0);
        }
        object2 = this.q;
        int n18 = ((TemplateRotateFrame)object).getRotate();
        ((FrameSizeUseCase)object2).w(n10, n18, bl2);
    }

    public void X(int n10, TemplateVideo object) {
        int n11 = ((TemplateVideo)object).getRateType();
        if (n11 == 0) {
            float f10;
            float f11 = ((TemplateVideo)object).getRate();
            float f12 = f11 - (f10 = 1.0f);
            n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n11 == 0) {
                SpeedUseCase speedUseCase = this.p;
                double d10 = f11;
                boolean bl2 = w;
                speedUseCase.l(d10, n10, bl2);
                return;
            }
            double d11 = f11;
            Object[] objectArray = this.p;
            double d12 = objectArray.j(n10);
            double d13 = d11 - d12;
            n11 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
            if (n11 > 0) {
                n11 = 1;
                f10 = Float.MIN_VALUE;
                objectArray = new Object[n11];
                objectArray[0] = object = Float.valueOf(f11);
                object = "\u500d\u901f\u8d85\u8fc7\u6700\u5927\u500d\u901f,%s";
                m.a.a.i((String)object, objectArray);
                f11 = (float)d12;
            }
            objectArray = this.p;
            double d14 = f11;
            boolean bl3 = w;
            objectArray.l(d14, n10, bl3);
        } else {
            object = ((TemplateVideo)object).getBezierRate();
            SpeedUseCase speedUseCase = this.p;
            boolean bl4 = w;
            speedUseCase.g(n10, (String)object, false, bl4);
        }
    }

    public void Y(TemplatePOJO object) {
        int n10;
        boolean bl2;
        this.a = object;
        Object object2 = ((TemplatePOJO)object).getTemplateGlobal();
        this.b = object2;
        this.c = object2 = ((TemplatePOJO)object).getTemplateVideoList();
        this.d = object2 = ((TemplatePOJO)object).getTemplateStickerList();
        this.e = object2 = ((TemplatePOJO)object).getTemplateMusicList();
        this.f = object = ((TemplatePOJO)object).getTemplateRecordingList();
        object = this.b;
        if (object != null && !(bl2 = d.v.j.b.f((List)(object = this.c)))) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("\u6a21\u677f\u4fe1\u606f\u9519\u8bef,TemplateGlobal is null: ");
        Object object3 = this.b;
        if (object3 == null) {
            n10 = 1;
        } else {
            n10 = 0;
            object3 = null;
        }
        ((StringBuilder)object2).append(n10 != 0);
        ((StringBuilder)object2).append("or videoList: ");
        object3 = this.c;
        if (object3 == null) {
            object3 = "null";
        } else {
            n10 = object3.size();
            object3 = n10;
        }
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public void Z(int n10, TemplateVideo object) {
        int n11;
        Object object2;
        Object object3 = ((TemplateVideo)object).getTransition();
        if (object3 != null && (object2 = ((TemplateTransition)object3).getName()) != null && (n11 = TextUtils.isEmpty((CharSequence)(object2 = ((TemplateTransition)object3).getName()))) == 0) {
            Object object4;
            long l10;
            int n12;
            object2 = this.u;
            Object object5 = ((TemplateTransition)object3).getName();
            n11 = ((TransitionUseCase)object2).i((String)object5);
            if (n11 == (n12 = -1)) {
                return;
            }
            long l11 = b0.r((TemplateVideo)object);
            long l12 = l11 - (l10 = d.v.v.q.h.T(n10));
            Object object6 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object6 > 0) {
                l11 = l10;
            }
            boolean bl2 = ((TemplateTransition)object3).isLocalSource();
            int n13 = 1;
            if (bl2 && n11 != n13) {
                object4 = EditConfig$ResourceType.TRANSITION;
                object3 = ((TemplateTransition)object3).getName();
                object3 = TemEditorConfig.c((d.v.e.j.a)object4, (String)object3);
            } else {
                object3 = ((TemplateTransition)object3).getName();
            }
            if (n11 != n13 && (bl2 = d.v.j.b.b((String)object3))) {
                return;
            }
            object4 = new d.v.h.k.b();
            ((d.v.h.k.b)object4).f(l11);
            ((d.v.h.k.b)object4).j(n11);
            object5 = EditConfig$ResourceType.TRANSITION;
            object = ((TemplateVideo)object).getTransition().getThumb();
            object = TemEditorConfig.c((d.v.e.j.a)object5, (String)object);
            ((d.v.h.k.b)object4).i((String)object);
            if (n11 == n13) {
                ((d.v.h.k.b)object4).g((String)object3);
            } else {
                ((d.v.h.k.b)object4).h((String)object3);
            }
            object = this.u;
            boolean bl3 = ((TransitionUseCase)object).g(n10);
            if (bl3) {
                object = this.u;
                boolean bl4 = w;
                ((TransitionUseCase)object).f(n10, (d.v.h.k.b)object4, false, bl4);
            }
            return;
        }
        object = this.u;
        boolean bl5 = w;
        ((TransitionUseCase)object).k(n10, false, bl5);
    }

    public void a(List list, TemplateSticker templateSticker, boolean bl2) {
        String string2 = templateSticker.getType();
        string2.hashCode();
        int n10 = string2.hashCode();
        String string3 = "image";
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 100313435: {
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case 3556653: {
                String string4 = "text";
                n10 = (int)(string2.equals(string4) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case 102340: {
                String string5 = "gif";
                n10 = (int)(string2.equals(string5) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                break;
            }
            case 1: {
                this.f(templateSticker);
                break;
            }
            case 0: 
            case 2: {
                boolean bl3 = string3.equals(string2);
                this.c(templateSticker, bl3, list, bl2);
            }
        }
    }

    public boolean a0(int n10, TemplateVideo templateVideo) {
        float f10 = templateVideo.getVolume();
        boolean bl2 = templateVideo.isMute();
        VoiceUseCase voiceUseCase = this.m;
        boolean bl3 = voiceUseCase.b(n10, f10);
        if (bl2) {
            bl2 = true;
            float f11 = Float.MIN_VALUE;
            if (bl3 && (n10 = (int)(this.T(n10, bl2) ? 1 : 0)) != 0) {
                bl3 = bl2;
                f10 = f11;
            } else {
                n10 = 0;
                bl3 = false;
                f10 = 0.0f;
            }
        }
        return bl3;
    }

    public void b() {
        boolean bl2;
        Object object = this.e;
        boolean bl3 = d.v.j.b.f((List)object);
        if (bl3) {
            object = this.n;
            boolean bl4 = w;
            ((MusicUseCase)object).q(bl4);
            return;
        }
        object = this.e.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (TemplateMusic)object.next();
            if ((object2 = this.l((TemplateAudioData)object2)) == null) continue;
            MusicUseCase musicUseCase = this.n;
            boolean bl5 = w;
            musicUseCase.f((d.v.h.h.b)object2, bl5);
        }
    }

    public void b0(int n10, TemplateVideo object, boolean bl2) {
        if ((object = ((TemplateVideo)object).getRoi()) == null) {
            this.q.f(n10, 0, bl2);
            return;
        }
        int n11 = b0.s((TemplateRoi)object);
        this.q.f(n10, n11, bl2);
    }

    public void c0() {
        FrameEffectUseCase frameEffectUseCase = this.r;
        boolean bl2 = this.B();
        frameEffectUseCase.s(bl2);
    }

    public void d() {
        boolean bl2;
        Object object = this.f;
        boolean bl3 = d.v.j.b.f((List)object);
        if (bl3) {
            object = this.o;
            boolean bl4 = w;
            ((RecordUseCase)object).u(bl4);
            return;
        }
        object = this.f.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (TemplateRecording)object.next();
            if ((object2 = this.l((TemplateAudioData)object2)) == null) continue;
            RecordUseCase recordUseCase = this.o;
            recordUseCase.e((d.v.h.h.b)object2);
        }
    }

    public void d0() {
        FrameEffectUseCase frameEffectUseCase = this.r;
        boolean bl2 = this.A();
        frameEffectUseCase.t(bl2);
    }

    public void e(boolean bl2) {
        boolean bl3;
        List list = bl2 ? this.j : this.d;
        boolean bl4 = d.v.j.b.f(list);
        if (bl4) {
            this.H();
            return;
        }
        list = this.s();
        Object object = bl2 ? this.j : this.d;
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            TemplateSticker templateSticker = (TemplateSticker)object.next();
            this.a(list, templateSticker, bl2);
        }
    }

    public void e0() {
        VoiceUseCase voiceUseCase = this.m;
        boolean bl2 = this.D();
        voiceUseCase.s(bl2);
    }

    public void f0() {
        FrameSizeUseCase frameSizeUseCase = this.q;
        boolean bl2 = this.C();
        frameSizeUseCase.z(bl2);
    }

    public void g0() {
        FrameSizeUseCase frameSizeUseCase = this.q;
        boolean bl2 = this.E();
        frameSizeUseCase.A(bl2);
    }

    public void h(MainUseCase mainUseCase) {
        this.l = mainUseCase;
        this.y();
    }

    public void h0(String object, int n10, TemplateSticker object2, List list) {
        StickerUseCase stickerUseCase;
        String string2;
        ((String)object).hashCode();
        int n11 = ((String)object).hashCode();
        String string3 = "image";
        int n12 = -1;
        switch (n11) {
            default: {
                break;
            }
            case 100313435: {
                n11 = (int)(((String)object).equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n12 = 2;
                break;
            }
            case 3556653: {
                string2 = "text";
                n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                if (n11 == 0) break;
                n12 = 1;
                break;
            }
            case 102340: {
                string2 = "gif";
                n11 = (int)(((String)object).equals(string2) ? 1 : 0);
                if (n11 == 0) break;
                n12 = 0;
                stickerUseCase = null;
            }
        }
        n11 = 0;
        string2 = null;
        switch (n12) {
            default: {
                break;
            }
            case 1: {
                object = this.s;
                object2 = this.n((TemplateSticker)object2);
                boolean bl2 = w;
                ((TextUseCase)object).x(n10, (d.v.h.d.d)object2, null, bl2);
                break;
            }
            case 0: 
            case 2: {
                stickerUseCase = this.t;
                boolean bl3 = string3.equals(object);
                object = this.m((TemplateSticker)object2, bl3, list, false);
                boolean bl4 = w;
                stickerUseCase.r(n10, (d.v.h.d.c)object, null, bl4);
            }
        }
    }

    public void i(int n10, TemplateVideo templateVideo) {
        long l10;
        long l11 = b0.n(templateVideo);
        long l12 = l11 - (l10 = b0.j(templateVideo));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return;
        }
        MainUseCase mainUseCase = this.l;
        boolean bl2 = w;
        mainUseCase.A(n10, l11, l10, bl2);
    }

    public void i0(int n10, TemplateVideo templateVideo) {
        this.i(n10, templateVideo);
        this.a0(n10, templateVideo);
        this.X(n10, templateVideo);
        boolean bl2 = true;
        this.V(n10, templateVideo, bl2);
        this.W(n10, templateVideo, bl2);
        this.b0(n10, templateVideo, bl2);
        this.L(n10, templateVideo, bl2);
        this.M(n10, templateVideo, bl2);
        this.Z(n10, templateVideo);
    }

    public d.v.h.e.a k(TemplateVideo object) {
        Object object2;
        Object object3 = ((TemplateVideo)object).getVideoPath();
        MediaType mediaType = MediaType.VIDEO;
        long l10 = d.v.v.q.h.Z((String)object3);
        if (object3 != null) {
            boolean bl2;
            boolean bl3;
            object2 = d.v.e.f.a().c().getContentResolver();
            Object object4 = Uri.parse((String)object3);
            if ((object2 = object2.getType((Uri)object4)) != null && (bl3 = ((String)object2).startsWith((String)(object4 = "image/")))) {
                mediaType = MediaType.IMAGE;
                l10 = ((TemplateVideo)object).getDuration();
            }
            if (bl2 = ((String)(object4 = "image/gif")).equalsIgnoreCase((String)object2)) {
                mediaType = MediaType.GIF;
                l10 = ((TemplateVideo)object).getDuration();
            }
        }
        object2 = new d.v.h.e.a();
        object3 = ((d.v.h.e.a)object2).l((String)object3).p((String)object3).m(mediaType).k(l10);
        object = ((TemplateBaseData)object).getCustomerUUID();
        ((d.v.h.b)object3).b((String)object);
        return object3;
    }

    public d.v.h.h.b l(TemplateAudioData object) {
        boolean bl2;
        Object object2;
        d.v.h.h.b b10 = null;
        if (object != null && (object2 = object.getName()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.getName())))) {
            bl2 = object.isLocalSource();
            if (bl2) {
                object2 = object.getName();
                object2 = this.j((String)object2);
            } else {
                object2 = object.getName();
            }
            boolean bl3 = d.v.j.b.b((String)object2);
            if (bl3) {
                return null;
            }
            Object object3 = b0.e((TemplateAudioData)object);
            long l10 = b0.d((TemplateAudioData)object);
            int n10 = 1;
            long l11 = object3[n10];
            Long l12 = null;
            long l13 = object3[0];
            long l14 = (l11 -= l13) - (l13 = 0L);
            Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 <= 0) {
                object = new Object[2];
                object[0] = object2 = Long.valueOf(object3[0]);
                object[n10] = object2 = Long.valueOf(object3[n10]);
                m.a.a.i("\u5f55\u97f3\u65f6\u95f4\u8bbe\u7f6e\u4e0d\u6b63\u786e,\u5f00\u59cb\u65f6\u95f4\uff1a%d\uff0c\u7ed3\u675f\u65f6\u95f4\uff1a%d", object);
                return null;
            }
            l11 = object3[0];
            long l15 = object3[n10];
            l12 = l10;
            object3 = b10;
            Object object5 = object2;
            long l16 = l11;
            l11 = l15;
            b10 = new d.v.h.h.b((String)object2, l16, l15, l12);
            long l17 = d.v.v.q.h.C((String)object2);
            b10.q(l17);
            float f10 = object.getVolume();
            b10.y(f10);
            object2 = object.getTitle();
            b10.u((String)object2);
            bl2 = object.isMute();
            b10.w(bl2);
            object2 = object.getFadeIn();
            if (object2 == null) {
                l17 = l13;
            } else {
                object2 = object.getFadeIn();
                l17 = ((TemplateAudioTransition)object2).getEndTime();
                object5 = object.getFadeIn();
                l10 = ((TemplateAudioTransition)object5).getStartTime();
                l17 -= l10;
            }
            b10.s(l17);
            object2 = object.getFadeout();
            if (object2 != null) {
                object2 = object.getFadeout();
                l17 = ((TemplateAudioTransition)object2).getEndTime();
                object5 = object.getFadeout();
                l10 = ((TemplateAudioTransition)object5).getStartTime();
                l13 = l17 - l10;
            }
            b10.t(l13);
            object = object.getCustomerUUID();
            b10.b((String)object);
        }
        return b10;
    }

    public d.v.h.d.c m(TemplateSticker templateSticker, boolean bl2, List list, boolean bl3) {
        boolean bl4;
        Object object;
        TemplateUseCase templateUseCase = this;
        Object object2 = templateSticker;
        d.v.h.d.c c10 = null;
        if (templateSticker != null && (!bl2 || (object = templateSticker.getImageName()) != null && !(bl4 = TextUtils.isEmpty((CharSequence)(object = templateSticker.getImageName())))) && (bl2 || (object = templateSticker.getGifName()) != null && !(bl4 = TextUtils.isEmpty((CharSequence)(object = templateSticker.getGifName()))))) {
            Object object3;
            Object object4;
            object = bl3 ? templateUseCase.h : templateUseCase.b;
            long l10 = ((TemplateGlobal)object).getTimebase();
            object = b0.g((TemplateSticker)object2, l10);
            float f10 = 0.0f;
            a a10 = null;
            Object object5 = object[0];
            boolean bl5 = templateUseCase.g((long)object5);
            if (!bl5) {
                return null;
            }
            String string2 = bl3 ? TemEditorConfig.b(TemEditorConfig$TemplateType.EOV) : TemEditorConfig.b(EditConfig$ResourceType.STICKER);
            float f11 = 0.667f;
            Serializable serializable = Float.valueOf(f11);
            AtomicReference<Float> atomicReference = new AtomicReference<Float>((Float)serializable);
            long l11 = templateSticker.getStickerTypeId();
            Optional optional = l11;
            serializable = new AtomicReference(optional);
            if (list != null) {
                optional = list.stream();
                object4 = new b((TemplateSticker)object2);
                optional = optional.filter(object4).findFirst();
                object4 = new d.v.i.c.c(atomicReference, (AtomicReference)serializable);
                optional.ifPresent(object4);
            }
            a$a a$a = this.o(templateSticker);
            int n10 = 1;
            reference var27_24 = object[n10];
            Object object6 = object[0];
            reference cfr_temp_0 = (var27_24 -= object6) - (object6 = (Object)0L);
            Object object7 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
            if (object7 <= 0) {
                return null;
            }
            object4 = bl2 ? templateSticker.getImageName() : templateSticker.getGifName();
            boolean bl6 = templateSticker.isLocalSource();
            if (bl6) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object4);
                string2 = ((StringBuilder)object3).toString();
                object4 = d.v.e.j.b.d(string2);
            }
            if (bl5 = d.v.j.b.b((String)object4)) {
                return null;
            }
            object6 = object[0];
            Long l12 = (long)object6;
            reference var35_30 = object[n10];
            Object object8 = object[0];
            object = bl2 ? DecorationType.IMAGE_PASTER : DecorationType.GIF_PASTER;
            object3 = c10;
            c10 = new d.v.h.d.c(a$a, l12, (long)(var35_30 -= object8), (DecorationType)((Object)object));
            object = templateSticker.getCustomerUUID();
            c10.b((String)object);
            object = new float[2];
            float f12 = templateSticker.getScale();
            object[0] = f12;
            f10 = templateSticker.getScale();
            object[n10] = f10;
            c10.q((float[])object);
            float f13 = atomicReference.get().floatValue();
            c10.J(f13);
            object = Optional.ofNullable(((AtomicReference)serializable).get());
            a10 = new a(c10);
            ((Optional)object).ifPresent(a10);
            f13 = templateSticker.getAngle();
            c10.l(f13);
            c10.K((String)object4);
            object2 = templateSticker.getThumbUrl();
            bl4 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl4) {
                bl4 = b0.u((String)object2);
                if (bl4) {
                    object2 = b0.w((String)object2);
                }
                object = EditConfig$ResourceType.STICKER;
                object2 = TemEditorConfig.c((d.v.e.j.a)object, (String)object2);
            }
            if ((bl4 = TextUtils.isEmpty((CharSequence)object2)) || (bl4 = ((String)object2).startsWith((String)(object = "http"))) || !(bl4 = d.v.j.b.b((String)object2))) {
                object4 = object2;
            }
            c10.N((String)object4);
        }
        return c10;
    }

    public d.v.h.f.a q(TemplateFilter object, TemplateEffect templateEffect) {
        String string2;
        boolean bl2;
        if (object != null && ((bl2 = ((TemplateFilter)object).isEnable()) || !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((TemplateFilter)object).getName()))))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        object = !bl2 ? this.p((TemplateFilter)object) : null;
        if (object == null) {
            object = new d.v.h.f.a();
        }
        templateEffect = this.r(templateEffect);
        ((d.v.h.f.a)object).B((SparseArray)templateEffect);
        return object;
    }

    public List s() {
        return this.v;
    }

    /*
     * WARNING - void declaration
     */
    public d t(TemplateVideo templateVideo) {
        String string2;
        Object object;
        TemplateUseCase templateUseCase = this;
        boolean bl2 = templateVideo.isLocalSource();
        if (bl2) {
            object = TemEditorConfig$TemplateType.EOV;
            string2 = templateVideo.getVideoPath();
            object = TemEditorConfig.c((d.v.e.j.a)object, string2);
        } else {
            object = templateVideo.getVideoPath();
        }
        boolean bl3 = d.v.j.b.b((String)object);
        if (!bl3) {
            void var21_33;
            double d10;
            void var6_10;
            Object object2;
            float f10;
            int n10;
            int n11 = templateVideo.getRateType();
            int n12 = 1;
            float f11 = Float.MIN_VALUE;
            int n13 = 0;
            float f12 = 0.0f;
            Object object3 = null;
            if (n11 == n12) {
                int n14 = n12;
            } else {
                boolean bl4 = false;
                string2 = null;
            }
            Object object4 = templateVideo.getRotateFrame();
            int n15 = 1065353216;
            float f13 = 1.0f;
            String string3 = "0.5\uff0c0.5";
            if (object4 != null) {
                int n16;
                n10 = ((TemplateRotateFrame)object4).getRotate();
                Object object5 = ((TemplateRotateFrame)object4).getScale();
                int n17 = 2;
                float f14 = 2.8E-45f;
                String string4 = ",";
                if (object5 != null && (n16 = ((String[])(object5 = ((TemplateRotateFrame)object4).getScale().split(string4))).length) == n17) {
                    String string5 = object5[0];
                    float f15 = d.v.e.h.c.b(string5, f13);
                    object5 = object5[n12];
                    f13 = d.v.e.h.c.b((String)object5, f13);
                    float f16 = f15 - 0.0f;
                    Object object6 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                    if (object6 < 0) {
                        float f17 = f13 - 0.0f;
                        object6 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                        if (object6 < 0) {
                            object6 = 3;
                            float f18 = 4.2E-45f;
                            f10 = f13;
                            f13 = f15;
                            float f19 = object6;
                            f15 = f18;
                        } else {
                            f10 = f13;
                            f13 = f15;
                            int n18 = n17;
                            f15 = f14;
                        }
                    } else {
                        float f20 = f13 - 0.0f;
                        object6 = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
                        if (object6 < 0) {
                            f10 = f13;
                            f13 = f15;
                            int n19 = n12;
                            f15 = f11;
                        } else {
                            f10 = f13;
                            f13 = f15;
                            boolean bl5 = false;
                            string5 = null;
                            f15 = 0.0f;
                        }
                    }
                } else {
                    boolean bl6 = false;
                    Object var22_35 = null;
                    float f21 = 0.0f;
                    int n20 = n15;
                    f10 = f13;
                }
                String string6 = ((TemplateRotateFrame)object4).getCenter();
                int n21 = TextUtils.isEmpty((CharSequence)string6);
                if (n21 == 0 && (n21 = ((String[])(object4 = ((TemplateRotateFrame)object4).getCenter().split(string4))).length) == n17) {
                    float f22 = d.v.e.h.c.a(object4[0]);
                    object2 = object4[n12];
                    f11 = d.v.e.h.c.a((String)object2);
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append(f22);
                    ((StringBuilder)object4).append(string4);
                    ((StringBuilder)object4).append(f11);
                    string3 = ((StringBuilder)object4).toString();
                }
            } else {
                n10 = 0;
                boolean bl7 = false;
                Object var22_36 = null;
                float f23 = 0.0f;
                int n22 = n15;
                f10 = f13;
            }
            object2 = new d();
            object4 = ((d.v.h.e.a)object2).l((String)object);
            MediaType mediaType = templateUseCase.v((String)object);
            ((d.v.h.e.a)object4).m(mediaType).p((String)object);
            long l10 = b0.n(templateVideo);
            object = ((d)object2).k0(l10);
            l10 = b0.j(templateVideo);
            object = ((d)object).W(l10);
            float f24 = templateVideo.getVolume();
            object = ((d)object).q0(f24);
            int n23 = templateVideo.isMute();
            object = ((d)object).f0(n23 != 0);
            object4 = templateVideo.getRotate();
            if (object4 == null) {
                n23 = 0;
                object4 = null;
                f24 = 0.0f;
            } else {
                object4 = templateVideo.getRotate();
                n23 = ((TemplateRotate)object4).getRotate();
            }
            object = ((d)object).b0(n23);
            object4 = templateVideo.getRoi();
            if (object4 != null) {
                object3 = templateVideo.getRoi();
                n13 = b0.s((TemplateRoi)object3);
            }
            object = ((d)object).d0(n13);
            object3 = this.x(templateVideo);
            object = ((d)object).o0((d.v.h.k.b)object3);
            object3 = templateVideo.getFilter();
            object4 = templateVideo.getEffect();
            object3 = templateUseCase.q((TemplateFilter)object3, (TemplateEffect)object4);
            object = ((d)object).Z((d.v.h.f.a)object3).p0((boolean)var6_10);
            if (var6_10 != false) {
                d10 = 1.0;
            } else {
                f12 = templateVideo.getRate();
                d10 = f12;
            }
            object = ((d)object).j0(d10);
            string2 = var6_10 != false ? templateVideo.getBezierRate() : "";
            ((d)object).V(string2).h0(f13).i0(f10).U(string3).e0((int)var21_33).g0(n10).m0(0.0f).n0(0.0f);
            return object2;
        }
        return null;
    }

    public int u() {
        String string2 = this.b.getRender();
        int n10 = this.b.getDisplayType();
        return b0.m(string2, n10);
    }

    public TemplatePOJO w() {
        return this.a;
    }
}

