/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  d.v.e.l.h1
 */
package d.v.c.s0.h7.u0;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.editortemplate.data.api.entity.BaseInfoList;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.image.Images;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.u0.h;
import d.v.c.s0.h7.u0.i;
import d.v.c.v0.n.d;
import d.v.e.f;
import d.v.e.h.a;
import d.v.e.l.c1;
import d.v.e.l.h1;
import d.v.e.l.k2;
import d.v.j.e.c;
import d.v.j.e.i.b1;
import d.v.j.e.i.d1;
import d.v.j.g.b0;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class l
extends ViewModel {
    private static final String j = TemEditorConfig.c(TemEditorConfig$SmartType.SMART_DIY_TRACK, "trackDescriptionList.json");
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    private final List g;
    private final List h;
    public String i;

    public l() {
        int n10;
        ArrayList<Object> arrayList = Boolean.FALSE;
        Object object = new MutableLiveData(arrayList);
        this.a = object;
        object = new MutableLiveData(null);
        this.b = object;
        HashMap hashMap = new HashMap();
        object = new MutableLiveData(hashMap);
        this.c = object;
        object = new MutableLiveData(arrayList);
        this.d = object;
        object = new MutableLiveData(arrayList);
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = d.v.j.e.c.a().g().E0();
        if (object != null && (n10 = object.size()) > 0) {
            this.h = object;
        } else {
            object = d.v.j.e.c.a().a();
            this.h = arrayList;
            arrayList.add(object);
        }
        object = j;
        arrayList = new ArrayList<Object>(this);
        arrayList = ((TypeToken)((Object)arrayList)).getType();
        object = (BaseInfoList)d.v.e.l.q2.c.d((String)object, (Type)((Object)arrayList));
        if (object != null && (arrayList = ((BaseInfoList)object).getList()) != null && (n10 = (arrayList = ((BaseInfoList)object).getList()).size()) > 0) {
            this.g = object = ((BaseInfoList)object).getList();
        } else {
            object = new TrackDescriptionBean();
            this.g = arrayList = new ArrayList<Object>();
            arrayList.add(object);
        }
    }

    private TemplatePOJO b(TemplatePOJO templatePOJO) {
        return templatePOJO.cloneObject().cloneTemplateConfig(templatePOJO);
    }

    private String c() {
        File file;
        block9: {
            Object object = k2.m();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("smart_cover_");
            long l10 = System.currentTimeMillis();
            charSequence.append(l10);
            String string2 = ".png";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            file = new File((File)object, (String)charSequence);
            object = d.v.e.f.a();
            object = ((f)object).c();
            charSequence = this.i;
            object = Images.n((Context)object, charSequence);
            charSequence = Bitmap.CompressFormat.PNG;
            int n10 = 100;
            String string3 = file.getPath();
            int n11 = h1.D((Bitmap)object, (Bitmap.CompressFormat)charSequence, (int)n10, (String)string3);
            if (n11 != 0) break block9;
            try {
                return file.getPath();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return file.getPath();
    }

    public static int d(String string2) {
        String string3 = "0x";
        boolean bl2 = string2.startsWith(string3);
        if (!bl2 && !(bl2 = string2.startsWith(string3 = "0X"))) {
            return Integer.parseInt(string2, 16);
        }
        return Integer.decode(string2);
    }

    private ScriptTrackPOJO f(Integer n10) {
        int n11;
        int n12;
        if (n10 != null && (n12 = n10.intValue()) >= 0) {
            n11 = n10;
        } else {
            n11 = 0;
            n10 = null;
        }
        n11 = ((TrackDescriptionBean)this.n().get(n11)).getTrackId();
        return this.g(n11);
    }

    public static boolean s(List object, Model model) {
        int n10;
        b1 b12 = d.v.j.e.c.a().g();
        object = b12.F0((List)object);
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = (ScriptTrackMetaData)object.next();
            int n11 = model.getCode();
            if (n11 != (n10 = l.d((String)(object2 = ((ScriptTrackMetaData)object2).getProduct())))) continue;
            return bl2;
        }
        return false;
    }

    public static boolean t(List object, Model model, float f10) {
        Object object2;
        b1 b12 = d.v.j.e.c.a().g();
        object = b12.F0((List)object);
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        int n10 = model.getCode();
        object = object.iterator();
        while ((object2 = object.hasNext()) != 0) {
            ScriptTrackMetaData scriptTrackMetaData = (ScriptTrackMetaData)object.next();
            String string2 = scriptTrackMetaData.getProduct();
            int n11 = l.d(string2);
            if (n10 != n11) continue;
            float f11 = scriptTrackMetaData.getVersion();
            n11 = 1120403456;
            float f12 = 100.0f;
            float f13 = f10 - (f11 /= f12);
            object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 < 0) continue;
            return bl2;
        }
        return false;
    }

    public static /* synthetic */ void u(TemplatePOJO object, String object2, String string2) {
        object = ((TemplatePOJO)object).getTemplateData();
        ((TemplateData)object).setTextEn((String)object2);
        ((TemplateData)object).setTextZh((String)object2);
        ((TemplateData)object).setTextZhTw((String)object2);
        object2 = ((TemplateData)object).getTemplateDescription();
        if (object2 == null) {
            object2 = new TemplateDescription();
            ((TemplateData)object).setTemplateDescription((TemplateDescription)object2);
        }
        ((TemplateDescription)object2).setTextEn(string2);
        ((TemplateDescription)object2).setTextZh(string2);
        ((TemplateDescription)object2).setTextZhTw(string2);
        d.v.j.e.c.a().g().B0((TemplateData)object);
    }

    private /* synthetic */ void v(TemplatePOJO templatePOJO, String string2, String string3) {
        TemplateData templateData;
        Object object = string3;
        Object object2 = string2;
        String string4 = this.c();
        TemplatePOJO templatePOJO2 = this.o(templatePOJO);
        TemplateData templateData2 = templatePOJO2.getTemplateData();
        Object object3 = templateData;
        Object object4 = this;
        String string5 = this.i;
        double d10 = templateData2.getVideoTime();
        int n10 = templateData2.getVideoCount();
        String string6 = templateData2.getVideoRatio();
        int n11 = templateData2.getResSize();
        boolean bl2 = templateData2.isPrimeUsable();
        long l10 = System.currentTimeMillis();
        object4 = l10;
        TemplateDescription templateDescription = templateData2.getTemplateDescription();
        String string7 = templateData2.getEditorTemplate();
        String string8 = templateData2.getTrackEditorConfigData();
        int n12 = -2;
        int n13 = 1;
        templateData = new TemplateData(string2, string2, string2, string4, string5, d10, n10, string6, n11, bl2, n12, n13 != 0, (Long)object4, templateDescription, string7, string8, n13, 0, null, false);
        object3 = templatePOJO2;
        templatePOJO2.setTemplateData(templateData);
        object2 = templateData.getTemplateDescription();
        if (object2 == null) {
            object2 = new TemplateDescription();
            templateData.setTemplateDescription((TemplateDescription)object2);
        }
        ((TemplateDescription)object2).setTextEn((String)object);
        ((TemplateDescription)object2).setTextZh((String)object);
        ((TemplateDescription)object2).setTextZhTw((String)object);
        object = new Script();
        ((TemplatePOJO)object3).setScript((Script)object);
        object = d.v.j.e.c.a().g();
        long l11 = templateData2.getId();
        ((d1)object).J(l11, (TemplatePOJO)object3);
    }

    public void A(TemplatePOJO templatePOJO, String string2, String string3) {
        Executor executor = c1.b().a();
        i i10 = new i(this, templatePOJO, string2, string3);
        executor.execute(i10);
    }

    public int e(int n10) {
        List list = this.g;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            TrackDescriptionBean trackDescriptionBean = (TrackDescriptionBean)this.g.get(i10);
            int n12 = trackDescriptionBean.getTrackId();
            if (n10 != n12) continue;
            return i10;
        }
        return 0;
    }

    public ScriptTrackPOJO g(int n10) {
        boolean bl2;
        Iterator iterator2 = this.h.iterator();
        while (bl2 = iterator2.hasNext()) {
            ScriptTrack scriptTrack;
            long l10;
            long l11;
            long l12;
            long l13;
            ScriptTrackPOJO scriptTrackPOJO = (ScriptTrackPOJO)iterator2.next();
            ScriptTrack scriptTrack2 = scriptTrackPOJO.getScriptTrack();
            if (scriptTrack2 == null || (l13 = (l12 = (l11 = (long)n10) - (l10 = (scriptTrack = scriptTrackPOJO.getScriptTrack()).getTrackId())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) continue;
            return scriptTrackPOJO;
        }
        return null;
    }

    public List i() {
        return this.h;
    }

    public ScriptTrackPOJO j() {
        Integer n10 = (Integer)this.b.getValue();
        return this.f(n10);
    }

    public int k() {
        return d.v.c.v0.n.d.s().G();
    }

    public List l(TemplatePOJO templatePOJO, long l10) {
        Object object = this;
        long l11 = l10;
        List list = templatePOJO.getTemplateVideoList();
        int n10 = list.size();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Map map = (Map)this.c.getValue();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2;
            Object object3;
            Object object4 = i10;
            object4 = (Integer)map.get(object4);
            object4 = ((l)object).f((Integer)object4).clone();
            List list2 = ((ScriptTrackPOJO)object4).getScriptTrackPointList();
            ArrayList<TemplateVideo> arrayList2 = new ArrayList<TemplateVideo>();
            int n11 = list2.size();
            long l12 = 0L;
            for (int i11 = 1; i11 < n11; ++i11) {
                object3 = (ScriptTrackPoint)list2.get(i11);
                object2 = ((ScriptTrackPoint)object3).getDuration();
                arrayList2.add((TemplateVideo)object2);
                object2 = (ScriptTrackPoint)list2.get(i11);
                long l13 = ((ScriptTrackPoint)object2).getDuration();
                l12 += l13;
            }
            object2 = (TemplateVideo)templatePOJO.getTemplateVideoList().get(i10);
            long l14 = b0.h((TemplateVideo)object2);
            long l15 = 0L;
            long l16 = l11 - l15;
            Object object5 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object5 > 0) {
                l14 = Math.min(l11, l14);
            }
            for (object5 = (Object)1; object5 < n11; ++object5) {
                Object object6 = list2.get((int)object5);
                object = object6;
                object = (ScriptTrackPoint)object6;
                long l17 = object5 + -1;
                Long l18 = (Long)arrayList2.get((int)l17);
                double d10 = l18.longValue();
                object6 = list2;
                object3 = arrayList2;
                double d11 = l12;
                double d12 = 1.0;
                d10 /= (d11 *= d12);
                d11 = l14;
                d10 *= d11;
                d11 = 1000.0;
                l11 = (long)(d10 /= d11);
                ((ScriptTrackPoint)object).setDuration(l11);
                object = this;
                l11 = l10;
            }
            arrayList.add(object4);
            object = this;
            l11 = l10;
        }
        return arrayList;
    }

    public TrackDescriptionBean m(int n10) {
        boolean bl2;
        Iterator iterator2 = this.g.iterator();
        while (bl2 = iterator2.hasNext()) {
            TrackDescriptionBean trackDescriptionBean = (TrackDescriptionBean)iterator2.next();
            int n11 = trackDescriptionBean.getTrackId();
            if (n10 != n11) continue;
            return trackDescriptionBean;
        }
        return null;
    }

    public List n() {
        return this.g;
    }

    public TemplatePOJO o(TemplatePOJO templatePOJO) {
        return this.p(templatePOJO, -1);
    }

    public TemplatePOJO p(TemplatePOJO object, long l10) {
        boolean bl2 = this.r();
        if (bl2) {
            TemplatePOJO templatePOJO = this.b((TemplatePOJO)object);
            object = this.l((TemplatePOJO)object, l10);
            templatePOJO.setScriptTrackPOJOList((List)object);
            return templatePOJO;
        }
        return object;
    }

    public boolean r() {
        return d.v.e.h.a.c((Boolean)this.a.getValue());
    }

    public /* synthetic */ void w(TemplatePOJO templatePOJO, String string2, String string3) {
        this.v(templatePOJO, string2, string3);
    }

    public void x(TemplatePOJO templatePOJO, String string2, String string3) {
        Executor executor = c1.b().a();
        h h10 = new h(templatePOJO, string2, string3);
        executor.execute(h10);
    }

    public void y(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Serializable serializable = 0;
        mutableLiveData.setValue(serializable);
        mutableLiveData = this.c;
        serializable = new HashMap();
        mutableLiveData.setValue(serializable);
        mutableLiveData = this.e;
        serializable = Boolean.FALSE;
        mutableLiveData.setValue(serializable);
        mutableLiveData = this.a;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        this.f.setValue(serializable);
    }

    public void z() {
        d d10 = d.v.c.v0.n.d.s();
        int n10 = this.k() + 1;
        d10.y0(n10);
    }
}

