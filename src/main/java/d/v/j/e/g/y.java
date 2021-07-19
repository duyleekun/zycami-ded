/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.text.TextUtils
 *  d.v.e.l.h1
 */
package d.v.j.e.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.common.util.Times;
import com.zhiyun.editortemplate.data.api.entity.template.Caption;
import com.zhiyun.editortemplate.data.api.entity.template.Description;
import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.Effect;
import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;
import com.zhiyun.editortemplate.data.api.entity.template.Filter;
import com.zhiyun.editortemplate.data.api.entity.template.Gif;
import com.zhiyun.editortemplate.data.api.entity.template.Global;
import com.zhiyun.editortemplate.data.api.entity.template.Image;
import com.zhiyun.editortemplate.data.api.entity.template.Music;
import com.zhiyun.editortemplate.data.api.entity.template.Render;
import com.zhiyun.editortemplate.data.api.entity.template.Roi;
import com.zhiyun.editortemplate.data.api.entity.template.Roi$RoiInfo;
import com.zhiyun.editortemplate.data.api.entity.template.Rotate;
import com.zhiyun.editortemplate.data.api.entity.template.Slices;
import com.zhiyun.editortemplate.data.api.entity.template.Stickers;
import com.zhiyun.editortemplate.data.api.entity.template.Text;
import com.zhiyun.editortemplate.data.api.entity.template.Transition;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import d.v.e.l.h1;
import d.v.e.l.s1;
import d.v.e.l.z1;
import d.v.j.d;
import d.v.j.e.g.a;
import d.v.j.e.g.a0;
import d.v.j.e.g.b;
import d.v.j.e.g.c;
import d.v.j.e.g.e;
import d.v.j.e.g.f;
import d.v.j.e.g.g;
import d.v.j.e.g.h;
import d.v.j.e.g.i;
import d.v.j.e.g.j;
import d.v.j.e.g.k;
import d.v.j.e.g.l;
import d.v.j.e.g.m;
import d.v.j.e.g.n;
import d.v.j.e.g.o;
import d.v.j.e.g.p;
import d.v.j.e.g.q;
import d.v.j.e.g.r;
import d.v.j.e.g.s;
import d.v.j.e.g.t;
import d.v.j.e.g.u;
import d.v.j.e.g.v;
import d.v.j.e.g.w;
import d.v.j.e.g.x;
import d.v.j.e.g.z;
import d.v.j.e.g.z$a;
import e.a.h0;
import e.a.i0;
import e.a.k0;
import e.a.p0;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class y
implements z {
    private static volatile y o;
    private final G_TemplateDataDao g;
    private final G_DraftDao h;
    private final G_WithdrawDao i;
    private final G_TemplateDao j;
    private z$a k;
    private String l;
    private String m;
    private Description n;

    private y() {
        BaseDao baseDao;
        Object object = DatabaseHelperTemplate.getInstance().getDataBase();
        this.g = baseDao = ((AppDatabaseTemplate)object).templateDataDao();
        baseDao = ((AppDatabaseTemplate)object).withdrawDao();
        this.i = baseDao;
        baseDao = ((AppDatabaseTemplate)object).draftDao();
        this.h = baseDao;
        this.j = object = ((AppDatabaseTemplate)object).templateDao();
    }

    public static /* synthetic */ void B(Global global, List object) {
        object = object.stream();
        Object object2 = u.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        global.setStickers((List)object);
    }

    private /* synthetic */ void C(long l10, k0 k02) {
        int n10;
        G_TemplateDataDao g_TemplateDataDao = this.g;
        boolean bl2 = true;
        long[] lArray = new long[bl2];
        lArray[0] = l10;
        int n11 = g_TemplateDataDao.deletedTemplateFromTemplateDataIds(lArray);
        if (n11 == (n10 = -1)) {
            bl2 = false;
        }
        Boolean bl3 = bl2;
        k02.onSuccess(bl3);
    }

    public static /* synthetic */ Long E(a0 a02) {
        Object object = a02.a();
        if (object != null && (object = a02.a().getWithdraw()) != null) {
            return a02.a().getWithdraw().createTime;
        }
        return null;
    }

    public static /* synthetic */ Stickers F(TemplateSticker templateSticker) {
        Object object;
        Object object2;
        Object object3;
        Object object4 = templateSticker.getTextContent();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
        boolean bl3 = true;
        Gif gif = null;
        if (!bl2) {
            object4 = new Text();
            object3 = templateSticker.getTextContent();
            ((Text)object4).setText((String)object3);
            float f10 = templateSticker.getTextFontSize();
            ((Text)object4).setFontSize(f10);
            object3 = templateSticker.getTextFontName();
            ((Text)object4).setName((String)object3);
            object3 = templateSticker.getTextColor();
            ((Text)object4).setTextColor((String)object3);
            object3 = templateSticker.getTextCaptionName();
            boolean bl4 = TextUtils.isEmpty((CharSequence)object3);
            if (bl4) {
                object3 = new Caption();
                String string2 = templateSticker.getTextCaptionName();
                ((FileDataBaseBean)object3).setName(string2);
                ((FileDataBaseBean)object3).setLocalSource(bl3);
            }
            object2 = object4;
        } else {
            object2 = null;
        }
        object4 = templateSticker.getImageName();
        bl2 = TextUtils.isEmpty((CharSequence)object4);
        if (!bl2) {
            object4 = new Image();
            object3 = templateSticker.getImageName();
            ((FileDataBaseBean)object4).setName((String)object3);
            ((FileDataBaseBean)object4).setLocalSource(bl3);
            object = object4;
        } else {
            object = null;
        }
        object4 = templateSticker.getGifName();
        bl2 = TextUtils.isEmpty((CharSequence)object4);
        if (!bl2) {
            gif = new Gif();
            gif.setLocalSource(bl3);
            object4 = templateSticker.getGifName();
            gif.setName((String)object4);
        }
        long l10 = templateSticker.getStartTime();
        long l11 = templateSticker.getEndTime();
        float f11 = templateSticker.getAngle();
        String string3 = templateSticker.getCenter();
        String string4 = templateSticker.getType();
        float f12 = templateSticker.getScale();
        object4 = new Stickers(l10, l11, f11, string3, string4, f12, (Text)object2, (Image)object, gif);
        return object4;
    }

    public static /* synthetic */ Music G(TemplateMusic object) {
        Music music = new Music();
        long l10 = ((TemplateAudioData)object).getAttachTime();
        music.setAttachTime(l10);
        l10 = ((TemplateAudioData)object).getStartTime();
        music.setStartTime(l10);
        l10 = ((TemplateAudioData)object).getEndTime();
        music.setEndTime(l10);
        l10 = music.getTimebase();
        music.setTimebase(l10);
        float f10 = ((TemplateAudioData)object).getVolume();
        music.setVolume(f10);
        boolean bl2 = ((TemplateAudioData)object).isMute();
        music.setMute(bl2);
        music.setLocalSource(true);
        object = ((TemplateAudioData)object).getName();
        music.setName((String)object);
        return music;
    }

    public static /* synthetic */ void H(Slices slices, TemplateRotate templateRotate) {
        boolean bl2 = templateRotate.isEnable();
        int n10 = templateRotate.getRotate();
        Rotate rotate = new Rotate(bl2, n10);
        slices.setRotate(rotate);
    }

    private /* synthetic */ void I(Slices slices, TemplateFilter object) {
        object = this.j((TemplateFilter)object);
        slices.setFilter((Filter)object);
    }

    private /* synthetic */ void K(Slices slices, TemplateEffect object) {
        object = this.k((TemplateEffect)object);
        slices.setEffect((Effect)object);
    }

    public static /* synthetic */ void M(Slices slices, TemplateTransition object) {
        Transition transition = new Transition();
        transition.setLocalSource(true);
        long l10 = ((TemplateTransition)object).getDuration();
        transition.setDuration(l10);
        l10 = ((TemplateTransition)object).getTimebase();
        transition.setTimebase(l10);
        object = ((TemplateTransition)object).getName();
        transition.setName((String)object);
        slices.setTransition(transition);
    }

    public static /* synthetic */ void N(Slices slices, TemplateRoi templateRoi) {
        Roi roi;
        Object object = templateRoi.getStartCenter();
        float f10 = templateRoi.getStartWidth();
        float f11 = templateRoi.getStartHeight();
        Roi$RoiInfo roi$RoiInfo = new Roi$RoiInfo((String)object, f10, f11);
        object = templateRoi.getEndCenter();
        f10 = templateRoi.getEndWidth();
        f11 = templateRoi.getEndHeight();
        Roi$RoiInfo roi$RoiInfo2 = new Roi$RoiInfo((String)object, f10, f11);
        boolean bl2 = templateRoi.isEnable();
        long l10 = templateRoi.getDuration();
        object = roi;
        roi = new Roi(bl2, l10, roi$RoiInfo, roi$RoiInfo2);
        slices.setRoi(roi);
    }

    private /* synthetic */ void O(int n10, TemplatePOJO templatePOJO) {
        block4: {
            block2: {
                block3: {
                    if (n10 == 0) break block2;
                    int n11 = 2;
                    if (n10 == n11) break block3;
                    n11 = 3;
                    if (n10 == n11 || n10 == (n11 = 4)) break block2;
                    n11 = 5;
                    if (n10 != n11) {
                        this.a();
                    } else {
                        TemplatePOJO templatePOJO2 = templatePOJO.clone();
                        this.W(templatePOJO2);
                    }
                    break block4;
                }
                this.Y(templatePOJO);
                break block4;
            }
            TemplatePOJO templatePOJO3 = templatePOJO.clone();
            this.X(templatePOJO3);
            this.a();
        }
    }

    public static /* synthetic */ void Q(Throwable objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("empty data", objectArray);
    }

    private /* synthetic */ void R(Optional optional, TemplatePOJO templatePOJO) {
        G_WithdrawDao g_WithdrawDao = this.i;
        b b10 = b.a;
        optional = optional.map(b10);
        g_WithdrawDao.insertWithdraw(templatePOJO, optional);
    }

    public static /* synthetic */ void T(Throwable objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("save error", objectArray);
    }

    private /* synthetic */ String U(TemplatePOJO object) {
        object = this.n((TemplatePOJO)object);
        return d.v.e.l.q2.c.h(EditorProtocol.class, object);
    }

    private void W(TemplatePOJO templatePOJO) {
        Object object = new StringBuilder();
        Object object2 = new StringBuilder();
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        ((StringBuilder)object2).append("");
        object2 = d.e(((StringBuilder)object2).toString()).getAbsolutePath();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("/cover.png");
        object = ((StringBuilder)object).toString();
        CharSequence charSequence = object;
        object2 = z1.b(this.l, 1L);
        Object object3 = Bitmap.CompressFormat.PNG;
        h1.D((Bitmap)object2, (Bitmap.CompressFormat)object3, (int)50, (String)object);
        object = templatePOJO.getTemplateData();
        object3 = object2;
        String string2 = this.m;
        String string3 = this.l;
        double d10 = ((TemplateData)object).getVideoTime();
        int n10 = ((TemplateData)object).getVideoCount();
        String string4 = templatePOJO.getTemplateGlobal().getRender();
        int n11 = (int)s1.x(this.l);
        boolean bl2 = ((TemplateData)object).isPrimeUsable();
        Long l11 = System.currentTimeMillis();
        TemplateDescription templateDescription = ((TemplateData)object).getTemplateDescription();
        String string5 = ((TemplateData)object).getEditorTemplate();
        String string6 = ((TemplateData)object).getTrackEditorConfigData();
        ScriptDataExt scriptDataExt = ((TemplateData)object).getScriptDataExt();
        boolean bl3 = ((TemplateData)object).isFirstLoaded();
        object2 = new TemplateData(string2, string2, string2, (String)charSequence, string3, d10, n10, string4, n11, bl2, -2, true, l11, templateDescription, string5, string6, 0, 0, scriptDataExt, bl3);
        templatePOJO.setTemplateData((TemplateData)object2);
        templatePOJO.setWithdraw(null);
        object = this.j;
        object2 = this.n;
        object.insertDIYTemplate(templatePOJO, (Description)object2);
    }

    private void X(TemplatePOJO templatePOJO) {
        templatePOJO.setWithdraw(null);
        templatePOJO.getTemplateData().setTemplateUseType(3);
        long l10 = System.currentTimeMillis();
        String string2 = Times.TIME_DOT.getDate();
        Draft draft = new Draft();
        draft.setContentDesc(string2);
        draft.setCreateTime(l10);
        templatePOJO.setDraft(draft);
        this.h.insertDraft(templatePOJO);
    }

    private void Y(TemplatePOJO object) {
        object = Optional.ofNullable(object);
        Object object2 = x.a;
        object = ((Optional)object).filter(object2);
        object2 = new m(this);
        object = ((Optional)object).map(object2).orElse("");
        object2 = this.k;
        if (object2 != null) {
            object2.a((String)object);
        }
    }

    private Filter j(TemplateFilter object) {
        Filter filter = new Filter();
        boolean bl2 = ((TemplateFilter)object).isEnable();
        filter.setEnable(bl2);
        float f10 = ((TemplateFilter)object).getStrength();
        filter.setStrength(f10);
        filter.setLocalSource(true);
        object = ((TemplateFilter)object).getName();
        filter.setName((String)object);
        return filter;
    }

    private Effect k(TemplateEffect templateEffect) {
        boolean bl2 = templateEffect.isEnable();
        float f10 = templateEffect.getSaturation();
        float f11 = templateEffect.getContrast();
        float f12 = templateEffect.getTemperature();
        float f13 = templateEffect.getHue();
        float f14 = templateEffect.getExposure();
        float f15 = templateEffect.getVignette();
        float f16 = templateEffect.getSharpen();
        Effect effect = new Effect(bl2, f10, f11, f12, f13, f14, f15, f16);
        return effect;
    }

    private Global l(TemplateGlobal object, List list, List list2) {
        if (object == null) {
            return null;
        }
        Global global = new Global();
        long l10 = ((TemplateGlobal)object).getDuration();
        global.setDuration(l10);
        l10 = ((TemplateGlobal)object).getTimebase();
        global.setTimebase(l10);
        float f10 = ((TemplateGlobal)object).getVolume();
        global.setVolume(f10);
        boolean bl2 = ((TemplateGlobal)object).isMute();
        global.setMute(bl2);
        Object object2 = Optional.ofNullable(((TemplateGlobal)object).getRender());
        Consumer consumer = new i(global);
        ((Optional)object2).ifPresent(consumer);
        object2 = Optional.ofNullable(global.getRender());
        consumer = new l((TemplateGlobal)object);
        ((Optional)object2).ifPresent(consumer);
        object2 = Optional.ofNullable(((TemplateGlobal)object).getFilter());
        consumer = new o(this, global);
        ((Optional)object2).ifPresent(consumer);
        object2 = Optional.ofNullable(((TemplateGlobal)object).getRotate());
        consumer = new k(global);
        ((Optional)object2).ifPresent(consumer);
        object = Optional.ofNullable(((TemplateGlobal)object).getEffect());
        object2 = new s(this, global);
        ((Optional)object).ifPresent(object2);
        this.m(list, global);
        this.p(list2, global);
        return global;
    }

    private void m(List object, Global global) {
        object = Optional.ofNullable(object);
        p p10 = new p(global);
        ((Optional)object).ifPresent(p10);
    }

    private EditorProtocol n(TemplatePOJO object) {
        Object object2 = ((TemplatePOJO)object).getTemplateGlobal();
        List list = ((TemplatePOJO)object).getTemplateMusicList();
        List list2 = ((TemplatePOJO)object).getTemplateStickerList();
        object2 = this.l((TemplateGlobal)object2, list, list2);
        object = ((TemplatePOJO)object).getTemplateVideoList();
        object = this.o((List)object);
        EditorProtocol editorProtocol = new EditorProtocol(0, 0, (Global)object2, (List)object);
        return editorProtocol;
    }

    private List o(List stream) {
        if (stream == null) {
            return null;
        }
        stream = stream.stream();
        Object object = new q(this);
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    private void p(List object, Global global) {
        object = Optional.ofNullable(object);
        n n10 = new n(global);
        ((Optional)object).ifPresent(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static y q() {
        Object object = o;
        if (object != null) return o;
        object = y.class;
        synchronized (object) {
            y y10 = o;
            if (y10 != null) return o;
            o = y10 = new y();
            return o;
        }
    }

    public static /* synthetic */ void r(Global global, TemplateRotate templateRotate) {
        boolean bl2 = templateRotate.isEnable();
        int n10 = templateRotate.getRotate();
        Rotate rotate = new Rotate(bl2, n10);
        global.setRotate(rotate);
    }

    private /* synthetic */ void s(Global global, TemplateEffect object) {
        object = this.k((TemplateEffect)object);
        global.setEffect((Effect)object);
    }

    public static /* synthetic */ void u(Global global, String string2) {
        Render render = new Render(string2);
        global.setRender(render);
    }

    public static /* synthetic */ void v(TemplateGlobal templateGlobal, Render render) {
        int n10 = templateGlobal.getDisplayType();
        render.setDisplayType(n10);
    }

    private /* synthetic */ void w(Global global, TemplateFilter object) {
        object = this.j((TemplateFilter)object);
        global.setFilter((Filter)object);
    }

    public static /* synthetic */ void y(Global global, List object) {
        object = object.stream();
        Object object2 = f.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        global.setMusics((List)object);
    }

    private /* synthetic */ Slices z(TemplateVideo templateVideo) {
        Slices slices;
        long l10 = templateVideo.getTimebase();
        long l11 = templateVideo.getStartTime();
        long l12 = templateVideo.getEndTime();
        long l13 = templateVideo.getDuration();
        boolean bl2 = templateVideo.isMute();
        float f10 = templateVideo.getVolume();
        float f11 = templateVideo.getRate();
        Optional<Object> optional = slices;
        slices = new Slices(l10, l11, l12, l13, bl2, f10, f11, 0, null);
        optional = Optional.ofNullable(templateVideo.getRotate());
        Consumer consumer = new h(slices);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(templateVideo.getFilter());
        consumer = new v(this, slices);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(templateVideo.getEffect());
        consumer = new a(this, slices);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(templateVideo.getTransition());
        consumer = new d.v.j.e.g.d(slices);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(templateVideo.getRoi());
        consumer = new c(slices);
        optional.ifPresent(consumer);
        return slices;
    }

    public /* synthetic */ Slices A(TemplateVideo templateVideo) {
        return this.z(templateVideo);
    }

    public /* synthetic */ void D(long l10, k0 k02) {
        this.C(l10, k02);
    }

    public /* synthetic */ void J(Slices slices, TemplateFilter templateFilter) {
        this.I(slices, templateFilter);
    }

    public /* synthetic */ void L(Slices slices, TemplateEffect templateEffect) {
        this.K(slices, templateEffect);
    }

    public /* synthetic */ void P(int n10, TemplatePOJO templatePOJO) {
        this.O(n10, templatePOJO);
    }

    public /* synthetic */ void S(Optional optional, TemplatePOJO templatePOJO) {
        this.R(optional, templatePOJO);
    }

    public /* synthetic */ String V(TemplatePOJO templatePOJO) {
        return this.U(templatePOJO);
    }

    public void a() {
        i0 i02 = this.i.deletedAllWithdraw();
        p0 p02 = d.v.e.k.e.f();
        i02.s(p02).a();
    }

    public i0 b(long l10, String string2) {
        return this.h.updateDescBoolean(l10, string2);
    }

    public void c(int n10) {
        i0 i02 = this.i.getLastWithdraw_Single();
        Object object = e.a.c1.b.d();
        i02 = i02.f1((h0)object);
        object = e.a.c1.b.d();
        i02 = i02.O0((h0)object);
        object = new r(this, n10);
        t t10 = t.a;
        i02.c((e.a.v0.g)object, t10);
    }

    public TemplatePOJO d() {
        return this.i.getLastWithdraw();
    }

    public void e(z$a z$a) {
        this.k = z$a;
    }

    public void f(TemplatePOJO object, Optional object2) {
        object = i0.x0(object);
        Object object3 = w.a;
        object = ((i0)object).g0((e.a.v0.r)object3);
        object3 = e.a.c1.b.d();
        object = ((e.a.q)object).u1((h0)object3);
        object3 = e.a.c1.b.d();
        object = ((e.a.q)object).W0((h0)object3);
        object3 = new e(this, (Optional)object2);
        object2 = d.v.j.e.g.j.a;
        ((e.a.q)object).c((e.a.v0.g)object3, (e.a.v0.g)object2);
    }

    public i0 g(long l10) {
        g g10 = new g(this, l10);
        return i0.H(g10);
    }

    public LiveData getLatestDraft() {
        return Transformations.distinctUntilChanged(this.h.getLatestDraft_LiveData());
    }

    public LiveData h() {
        return this.h.getAllDraft_LiveData();
    }

    public void i(String string2, String string3, Description description) {
        this.l = string2;
        this.m = string3;
        this.n = description;
        this.c(5);
    }

    public /* synthetic */ void t(Global global, TemplateEffect templateEffect) {
        this.s(global, templateEffect);
    }

    public /* synthetic */ void x(Global global, TemplateFilter templateFilter) {
        this.w(global, templateFilter);
    }
}

