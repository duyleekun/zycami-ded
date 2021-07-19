/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import d.v.e.l.s1;
import d.v.j.e.i.a1;
import d.v.j.e.i.b0;
import d.v.j.e.i.b1;
import d.v.j.e.i.c1$a;
import d.v.j.e.i.c1$b;
import d.v.j.e.i.c1$c;
import d.v.j.e.i.d1;
import d.v.j.e.i.e1;
import d.v.j.e.i.g;
import d.v.j.e.i.i;
import d.v.j.e.i.j;
import d.v.j.e.i.k0;
import d.v.j.e.i.l0;
import d.v.j.e.i.u0;
import d.v.j.e.i.v0;
import d.v.j.e.i.z0;
import d.v.j.g.c0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import m.a.a;

public class c1
implements a1 {
    public static final String f = "SortSmartByTemplateDataId";
    public static final String g = "SortTemplateByTemplateDataId";
    public static final String h = "SortTemplateTypeByTemplateTypeId";
    public static final String i = "SortTemplateEndByTemplateDataId";
    public static final String j = "SortTemplateEndTypeByTemplateTypeId";
    private static volatile c1 k;
    private final int a;
    private final z0 b;
    private final b1 c;
    private final e1 d;
    private d.v.e.l.c1 e;

    public c1(d.v.e.l.c1 object) {
        this.a = 1000;
        this.e = object;
        this.b = object = new z0();
        this.c = object = new b1();
        this.d = object = new e1();
    }

    private /* synthetic */ void A(TemplateData templateData) {
        this.l(templateData);
        templateData.setDownloadFinished(false);
        templateData.setDownloadTimestamp(null);
        this.b.B0(templateData);
        z0 z02 = this.b;
        long l10 = templateData.getId();
        z02.c(l10);
    }

    private /* synthetic */ LiveData C(List list) {
        LiveData liveData = this.b.X(list);
        b0 b02 = new b0(list);
        return Transformations.map(liveData, b02);
    }

    public static /* synthetic */ Long E(List object, List object2) {
        boolean bl2;
        int n10 = object.size() * 3;
        long l10 = n10;
        object = object2.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            long l11 = s1.x((String)object2);
            l10 += l11;
        }
        return l10;
    }

    private LiveData F(String string2, int n10, boolean bl2, long l10, boolean bl3, int n11, boolean bl4) {
        d.v.e.l.c1 c12 = this.e;
        c1$a c1$a = new c1$a(this, c12, string2, n10, l10, n11, bl4, bl2, bl3);
        return c1$a.d();
    }

    private LiveData G(String string2, int n10) {
        d.v.e.l.c1 c12 = this.e;
        c1$c c1$c = new c1$c(this, c12, string2, n10);
        return c1$c.d();
    }

    public static /* synthetic */ z0 s(c1 c12) {
        return c12.b;
    }

    public static /* synthetic */ e1 t(c1 c12) {
        return c12.d;
    }

    public static /* synthetic */ b1 u(c1 c12) {
        return c12.c;
    }

    private void v(List object) {
        int n10;
        c0.d();
        if (object != null && (n10 = object.size()) > 0) {
            Object object2 = this.b;
            ((d1)object2).a((List)object);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (String)object.next();
                s1.h((String)object2);
            }
        }
    }

    private Set w() {
        boolean bl2;
        Object object = this.b.k();
        HashSet hashSet = new HashSet();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (TemplatePOJO)object.next();
            object2 = this.y((TemplatePOJO)object2);
            hashSet.addAll(object2);
        }
        return hashSet;
    }

    private Set y(TemplatePOJO object) {
        boolean bl2;
        boolean bl3;
        Object object2;
        Object object3;
        boolean bl4;
        HashSet<Object> hashSet = new HashSet<Object>();
        Object object4 = ((TemplatePOJO)object).getTemplateVideoList();
        if (object4 != null) {
            object4 = object4.iterator();
            while (bl4 = object4.hasNext()) {
                boolean bl5;
                object3 = (TemplateVideo)object4.next();
                object2 = ((TemplateVideo)object3).getFilter();
                if (object2 != null && (bl5 = ((TemplateFilter)object2).isEnable()) && !(bl5 = ((TemplateFilter)object2).isLocalSource())) {
                    object2 = ((TemplateFilter)object2).getName();
                    hashSet.add(object2);
                }
                if ((object3 = ((TemplateVideo)object3).getTransition()) == null || (bl3 = ((TemplateTransition)object3).isLocalSource())) continue;
                object3 = ((TemplateTransition)object3).getName();
                hashSet.add(object3);
            }
        }
        if ((object4 = ((TemplatePOJO)object).getTemplateStickerList()) != null) {
            object4 = object4.iterator();
            while (bl4 = object4.hasNext()) {
                object3 = (TemplateSticker)object4.next();
                if (object3 != null && !(bl3 = ((TemplateSticker)object3).isLocalSource())) {
                    object2 = ((TemplateSticker)object3).getName();
                    hashSet.add(object2);
                }
                if (object3 == null || (bl3 = ((TemplateSticker)object3).isTextCaptionLocalSource())) continue;
                object3 = ((TemplateSticker)object3).getTextCaptionName();
                hashSet.add(object3);
            }
        }
        if ((object4 = ((TemplatePOJO)object).getTemplateMusicList()) != null) {
            object4 = object4.iterator();
            while (bl4 = object4.hasNext()) {
                object3 = (TemplateMusic)object4.next();
                if (object3 == null || (bl3 = ((TemplateAudioData)object3).isLocalSource())) continue;
                object3 = ((TemplateAudioData)object3).getName();
                hashSet.add(object3);
            }
        }
        if ((object4 = ((TemplatePOJO)object).getTemplateRecordingList()) != null) {
            object4 = object4.iterator();
            while (bl4 = object4.hasNext()) {
                object3 = (TemplateRecording)object4.next();
                if (object3 == null || (bl3 = ((TemplateAudioData)object3).isLocalSource())) continue;
                object3 = ((TemplateAudioData)object3).getName();
                hashSet.add(object3);
            }
        }
        if ((object = ((TemplatePOJO)object).getTemplateGlobal()) != null && (object = ((TemplateGlobal)object).getFilter()) != null && (bl2 = ((TemplateFilter)object).isEnable()) && !(bl2 = ((TemplateFilter)object).isLocalSource())) {
            object = ((TemplateFilter)object).getName();
            hashSet.add(object);
        }
        return hashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c1 z(d.v.e.l.c1 c12) {
        Object object = k;
        if (object != null) return k;
        object = c1.class;
        synchronized (object) {
            c1 c13 = k;
            if (c13 != null) return k;
            k = c13 = new c1(c12);
            return k;
        }
    }

    public /* synthetic */ void B(TemplateData templateData) {
        this.A(templateData);
    }

    public /* synthetic */ LiveData D(List list) {
        return this.C(list);
    }

    public void H() {
        List list = this.b.F();
        this.v(list);
    }

    public ScriptTrackPOJO a() {
        ScriptTrackPOJO scriptTrackPOJO = new ScriptTrackPOJO();
        ArrayList<ScriptTrackPoint> arrayList = new ArrayList<ScriptTrackPoint>(0L, "editorPriority");
        scriptTrackPOJO.setScriptTrack((ScriptTrack)((Object)arrayList));
        arrayList = new ArrayList<ScriptTrackPoint>();
        ScriptTrackPoint scriptTrackPoint = new ScriptTrackPoint("unmove", 3000L);
        arrayList.add(scriptTrackPoint);
        scriptTrackPOJO.setScriptTrackPointList(arrayList);
        return scriptTrackPOJO;
    }

    public LiveData b(int n10) {
        String string2 = this.m(n10);
        return this.G(string2, n10);
    }

    public String c(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public z0 d() {
        return this.b;
    }

    public void e() {
        c0.d();
        z0 z02 = this.b;
        Integer n10 = 0;
        z02.f(n10, n10, n10, null, null);
        this.H();
    }

    public LiveData f(int n10) {
        z0 z02 = this.b;
        Integer n11 = -1;
        Integer n12 = n10;
        Integer n13 = 0;
        Boolean bl2 = Boolean.TRUE;
        return z02.f0(n11, n12, n13, bl2, null);
    }

    public b1 g() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String h(long l10, int n10) {
        String string2;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\u53c2\u6570\u4e0d\u6b63\u786e,\u53c2\u6570editorTemplateProtoType=");
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
                throw illegalArgumentException;
            }
            string2 = i;
        } else {
            string2 = g;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }

    public e1 i() {
        return this.d;
    }

    public boolean j() {
        d1 d12 = this.b;
        boolean bl2 = ((z0)d12).X0();
        if (bl2 && (bl2 = ((z0)(d12 = this.b)).Y0()) && (bl2 = ((b1)(d12 = this.c)).k1())) {
            bl2 = true;
        } else {
            bl2 = false;
            d12 = null;
        }
        return bl2;
    }

    public LiveData k() {
        Object object = this.b;
        Integer n10 = 0;
        Object object2 = n10;
        object = ((d1)object).e0(n10, n10, n10, null, null);
        object2 = new l0(this);
        return Transformations.switchMap((LiveData)object, (Function)object2);
    }

    public void l(TemplateData optional) {
        c0.d();
        long l10 = ((TemplateData)((Object)optional)).getId();
        optional = this.b.B(l10);
        Object object = ((TemplatePOJO)((Object)optional)).getTemplateGlobal();
        Object object2 = ((TemplatePOJO)((Object)optional)).getTemplateVideoList();
        Object object3 = ((TemplatePOJO)((Object)optional)).getTemplateStickerList();
        List list = ((TemplatePOJO)((Object)optional)).getTemplateMusicList();
        optional = ((TemplatePOJO)((Object)optional)).getScriptTrackPOJOList();
        object = Optional.ofNullable(object);
        Object object4 = this.b;
        object4.getClass();
        v0 v02 = new v0((z0)object4);
        ((Optional)object).ifPresent(v02);
        object = Optional.ofNullable(object2);
        object2 = this.b;
        object2.getClass();
        object4 = new i((z0)object2);
        ((Optional)object).ifPresent((Consumer<List>)object4);
        object = Optional.ofNullable(object3);
        object2 = this.b;
        object2.getClass();
        object3 = new j((z0)object2);
        ((Optional)object).ifPresent((Consumer<List>)object3);
        object = Optional.ofNullable(list);
        object2 = this.b;
        object2.getClass();
        object3 = new g((z0)object2);
        ((Optional)object).ifPresent((Consumer<List>)object3);
        optional = Optional.ofNullable(optional);
        object = this.c;
        object.getClass();
        object2 = new u0((b1)object);
        optional.ifPresent((Consumer<Object>)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String m(int n10) {
        if (n10 == 0) return h;
        int n11 = 1;
        if (n10 == n11) {
            return j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u53c2\u6570\u4e0d\u6b63\u786e,\u53c2\u6570editorTemplateProtoType=");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public LiveData n(String string2, int n10, boolean bl2, int n11, String string3) {
        d.v.e.l.c1 c12 = this.e;
        c1$b c1$b = new c1$b(this, c12, string2, n10, n11, bl2, string3);
        return c1$b.d();
    }

    public LiveData o(boolean bl2, String string2) {
        String string3 = this.c(string2);
        return this.n(string3, 1000, bl2, 0, string2);
    }

    public void p(TemplateData templateData) {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        k0 k02 = new k0(this, templateData);
        appDatabaseTemplate.runInTransaction(k02);
    }

    public LiveData q(boolean bl2, long l10, boolean bl3, int n10, boolean bl4) {
        String string2 = this.h(l10, n10);
        return this.F(string2, 1000, bl2, l10, bl3, n10, bl4);
    }

    public void r(TemplateData objectArray) {
        int n10;
        z0 z02;
        Object object;
        c0.d();
        boolean bl2 = objectArray.isNetworkTemplate();
        if (!(bl2 || (bl2 = objectArray.isSmartTemplate()) && (bl2 = objectArray.isDIYTemplate()))) {
            bl2 = false;
            object = null;
        } else {
            object = this.b;
            long l10 = objectArray.getId();
            object = ((d1)object).n(l10);
        }
        boolean bl3 = objectArray.isNetworkTemplate();
        if (bl3) {
            this.p((TemplateData)objectArray);
        } else {
            z02 = this.b;
            z02.e((TemplateData)objectArray);
        }
        if (object != null && (n10 = object.size()) > 0) {
            this.v((List)object);
            n10 = 1;
            objectArray = new Object[n10];
            bl3 = false;
            z02 = null;
            objectArray[0] = object;
            object = "deleteTemplateData, filePaths: %s";
            m.a.a.b((String)object, objectArray);
        }
    }

    public List x() {
        c0.d();
        return this.b.k();
    }
}

