/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.e.i;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.editortemplate.data.api.entity.BaseInfoList;
import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.api.entity.track.AssetScriptList;
import com.zhiyun.editortemplate.data.api.entity.track.ScriptInfoData;
import com.zhiyun.editortemplate.data.api.entity.track.ScriptInfoList;
import com.zhiyun.editortemplate.data.api.entity.track.TrackBean;
import com.zhiyun.editortemplate.data.api.entity.track.TrackFocus;
import com.zhiyun.editortemplate.data.api.entity.track.TrackListBean;
import com.zhiyun.editortemplate.data.api.entity.track.TrackPointBean;
import com.zhiyun.editortemplate.data.api.entity.track.TrackProductsBean;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;
import d.v.e.l.q2.c;
import d.v.j.e.i.a;
import d.v.j.e.i.a0;
import d.v.j.e.i.b;
import d.v.j.e.i.b1$a;
import d.v.j.e.i.b1$b;
import d.v.j.e.i.b1$c;
import d.v.j.e.i.b1$d;
import d.v.j.e.i.b1$e;
import d.v.j.e.i.b1$f;
import d.v.j.e.i.d1;
import d.v.j.e.i.k;
import d.v.j.e.i.l;
import d.v.j.e.i.m;
import d.v.j.e.i.n;
import d.v.j.e.i.o;
import d.v.j.e.i.p;
import d.v.j.e.i.q;
import d.v.j.e.i.r;
import d.v.j.e.i.s;
import d.v.j.e.i.s0;
import d.v.j.e.i.t;
import d.v.j.e.i.t0;
import d.v.j.e.i.u;
import d.v.j.e.i.v;
import d.v.j.e.i.w;
import d.v.j.e.i.w0;
import d.v.j.e.i.x;
import d.v.j.e.i.x0;
import d.v.j.e.i.y;
import d.v.j.e.i.y0;
import d.v.j.e.i.z;
import d.v.j.g.c0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class b1
extends d1 {
    private final G_ScriptDao j;
    private final ScriptTrackDao k;

    public b1() {
        BaseDao baseDao;
        this.j = baseDao = this.a.scriptDao();
        baseDao = this.a.scriptTrackDao();
        this.k = baseDao;
    }

    private TemplatePOJO C0(ScriptInfoData scriptInfoData) {
        int n10 = scriptInfoData.getIsPkg();
        int n11 = scriptInfoData.getStatus();
        int n12 = scriptInfoData.getProtocol();
        int n13 = scriptInfoData.getVersion();
        ScriptDataExt scriptDataExt = ScriptDataExt.create(n11, n12, n13);
        Object object = this;
        Object object2 = scriptInfoData;
        object = this.H(scriptInfoData, n10, false, 1, 0, scriptDataExt);
        object2 = new Script();
        long l10 = scriptInfoData.getId();
        ((Script)object2).setReferenceId(l10);
        ((TemplatePOJO)object).setScript((Script)object2);
        return object;
    }

    public static /* synthetic */ void J0(b1 b12, ScriptInfoData scriptInfoData) {
        b12.m1(scriptInfoData);
    }

    public static /* synthetic */ List K0(List stream) {
        stream = stream.stream();
        Collector collector = y0.a;
        stream = stream.filter((Predicate<Object>)((Object)collector));
        collector = x0.a;
        stream = stream.map(collector);
        collector = u.a;
        stream = stream.filter((Predicate<Object>)((Object)collector));
        collector = Collectors.toList();
        return stream.collect(collector);
    }

    public static /* synthetic */ List[] L0(int n10) {
        return new List[n10];
    }

    public static /* synthetic */ void M0(List object, Map map, List object2) {
        object2 = object2.stream();
        Predicate predicate = y0.a;
        object2 = object2.filter(predicate);
        predicate = new m((List)object);
        object = object2.filter(predicate);
        object2 = new v(map);
        object.forEach(object2);
    }

    public static /* synthetic */ boolean N0(List stream) {
        stream = stream.stream();
        Object object = y0.a;
        stream = stream.filter((Predicate<Object>)object);
        object = x0.a;
        stream = stream.map(object);
        object = q.a;
        return stream.anyMatch((Predicate<Object>)object);
    }

    public static /* synthetic */ ScriptTrackPoint O0(TrackPointBean trackPointBean) {
        ScriptTrackPointItem scriptTrackPointItem;
        Object object = trackPointBean.getZoom();
        Object object2 = trackPointBean.getFocus();
        ScriptTrackPointItem scriptTrackPointItem2 = null;
        if (object == null) {
            scriptTrackPointItem = null;
        } else {
            ScriptTrackPointItem scriptTrackPointItem3;
            Float f10 = ((TrackFocus)object).getStart();
            float f11 = ((TrackFocus)object).getEnd();
            object = ((TrackFocus)object).getType();
            scriptTrackPointItem = scriptTrackPointItem3 = new ScriptTrackPointItem(f10, f11, (String)object);
        }
        if (object2 != null) {
            object = ((TrackFocus)object2).getStart();
            float f12 = ((TrackFocus)object2).getEnd();
            object2 = ((TrackFocus)object2).getType();
            scriptTrackPointItem2 = new ScriptTrackPointItem((Float)object, f12, (String)object2);
        }
        String string2 = trackPointBean.getType();
        long l10 = trackPointBean.getDuration();
        Float f13 = trackPointBean.getYaw();
        Float f14 = trackPointBean.getPitch();
        Float f15 = trackPointBean.getRoll();
        String string3 = trackPointBean.getOrientation();
        String string4 = trackPointBean.getFunc();
        object = new ScriptTrackPoint(string2, l10, f13, f14, f15, scriptTrackPointItem, scriptTrackPointItem2, string3, string4);
        return object;
    }

    public static /* synthetic */ ScriptTrackMetaData P0(TrackProductsBean trackProductsBean) {
        String string2 = trackProductsBean.getProduct();
        String string3 = trackProductsBean.getName();
        int n10 = trackProductsBean.getVersion();
        ScriptTrackMetaData scriptTrackMetaData = new ScriptTrackMetaData(string2, string3, n10);
        return scriptTrackMetaData;
    }

    private /* synthetic */ ScriptTrackPOJO Q0(String string2, TrackBean trackBean) {
        return this.G0(trackBean, string2);
    }

    private /* synthetic */ TrackBean S0(List list, TrackBean trackBean) {
        return this.h1(trackBean, list);
    }

    public static /* synthetic */ boolean U0(TrackBean trackBean, TrackBean trackBean2) {
        long l10;
        long l11 = trackBean.getTrackId();
        long l12 = l11 - (l10 = trackBean2.getTrackId());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            trackBean = null;
        }
        return (boolean)object;
    }

    public static /* synthetic */ void V0(TrackBean trackBean, TrackBean object) {
        Object object2 = trackBean.getTrackName();
        if (object2 == null) {
            object2 = ((TrackBean)object).getTrackName();
            trackBean.setTrackName((String)object2);
        }
        if ((object2 = trackBean.getTrackNameJson()) == null) {
            object2 = ((TrackBean)object).getTrackNameJson();
            trackBean.setTrackNameJson((String)object2);
        }
        if ((object2 = trackBean.getDurationType()) == null) {
            object2 = ((TrackBean)object).getDurationType();
            trackBean.setDurationType((String)object2);
        }
        if ((object2 = trackBean.getProducts()) == null) {
            object = ((TrackBean)object).getProducts();
            trackBean.setProducts((List)object);
        }
    }

    public static /* synthetic */ boolean W0(String string2) {
        return TextUtils.isEmpty((CharSequence)string2) ^ true;
    }

    public static /* synthetic */ boolean X0(List list, ScriptTrackMetaData object) {
        boolean bl2;
        String string2 = ((ScriptTrackMetaData)object).getProduct();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && (bl2 = list.contains(object = ((ScriptTrackMetaData)object).getProduct()))) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }

    public static /* synthetic */ void Y0(Map map, ScriptTrackMetaData scriptTrackMetaData) {
        String string2 = scriptTrackMetaData.getProduct();
        ScriptTrackMetaData scriptTrackMetaData2 = (ScriptTrackMetaData)map.get(string2);
        if (scriptTrackMetaData2 == null) {
            map.put(string2, scriptTrackMetaData);
        } else {
            int n10;
            int n11 = scriptTrackMetaData.getVersion();
            if (n11 > (n10 = scriptTrackMetaData2.getVersion())) {
                map.remove(string2);
                map.put(string2, scriptTrackMetaData);
            }
        }
    }

    public static /* synthetic */ boolean Z0(String string2) {
        return TextUtils.isEmpty((CharSequence)string2) ^ true;
    }

    private /* synthetic */ ScriptInfoData a1(String string2, String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        string2 = d.v.e.j.b.d(stringBuilder.toString());
        object = new b1$b(this);
        object = ((TypeToken)object).getType();
        return (ScriptInfoData)c.d(string2, (Type)object);
    }

    private /* synthetic */ void c1() {
        Object object = this.b;
        Integer n10 = -1;
        Integer n11 = 1;
        Integer n12 = 0;
        Boolean bl2 = Boolean.TRUE;
        object.deleteTemplateData(n10, n11, n12, bl2, null);
        object = TemEditorConfig.b(TemEditorConfig$SmartType.SMART_EDITOR);
        this.j1("smart_script/Smart/smartList.json", (String)object);
    }

    private TrackBean h1(TrackBean trackBean, List optional) {
        boolean bl2 = d.v.j.b.f((List)((Object)optional));
        if (bl2) {
            return trackBean;
        }
        optional = optional.stream();
        Object object = new w(trackBean);
        optional = optional.filter(object).findFirst();
        object = new x(trackBean);
        optional.ifPresent(object);
        return trackBean;
    }

    private List i1(List ... object) {
        Object object2 = null;
        if (object == null) {
            return null;
        }
        int n10 = ((List[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            return object[0];
        }
        n10 = ((List[])object).length;
        int n12 = 2;
        if (n10 == n12) {
            object2 = object[n11];
            object = object[0].stream();
            l l10 = new l(this, (List)object2);
            object = object.map(l10);
            object2 = Collectors.toList();
            return (List)object.collect(object2);
        }
        for (n10 = ((List[])object).length - n11; n10 >= 0; n10 += -1) {
            List list = object[n10];
            if (list == null) continue;
            List[] listArray = new List[n12];
            listArray[0] = list;
            listArray[n11] = object2;
            object2 = this.i1(listArray);
        }
        return object2;
    }

    private void j1(String stream, String object) {
        stream = d.v.e.j.b.d((String)((Object)stream));
        Object object2 = new b1$a(this);
        if ((stream = (AssetScriptList)c.d((String)((Object)stream), (Type)(object2 = ((TypeToken)object2).getType()))) == null) {
            return;
        }
        if ((stream = ((BaseInfoList)((Object)stream)).getList()) == null) {
            return;
        }
        stream = stream.stream();
        object2 = new r(this, (String)object);
        stream = stream.map(object2);
        object = new o(this);
        stream.forEach((Consumer<Object>)object);
    }

    private void m1(ScriptInfoData object) {
        if (object == null) {
            return;
        }
        Object object2 = TemEditorConfig$SmartType.SMART_TEMPLATE;
        Object object3 = ((TemplateInfoData)object).getEditorName();
        object2 = TemEditorConfig.c((d.v.e.j.a)object2, (String)object3);
        object3 = new b1$c(this);
        if ((object2 = (EditorProtocol)c.d((String)object2, (Type)(object3 = ((TypeToken)object3).getType()))) == null) {
            return;
        }
        object3 = TemEditorConfig$SmartType.SMART_TRACK_CHAIN;
        Object object4 = ((TemplateInfoData)object).getTrackChainName();
        object3 = TemEditorConfig.c((d.v.e.j.a)object3, (String)object4);
        object3 = this.I0((String)object3);
        object4 = this.I0("smart_script/Track/trackList.json");
        String string2 = TemEditorConfig.b(TemEditorConfig$SmartType.SMART_TRACK);
        List[] listArray = new List[]{object3, object4};
        object3 = this.i1(listArray);
        object3 = this.H0(string2, (List)object3);
        object = this.C0((ScriptInfoData)object);
        ((TemplatePOJO)object).setScriptTrackPOJOList((List)object3);
        this.l0((TemplatePOJO)object, (EditorProtocol)object2);
    }

    public void D0(List object) {
        c0.d();
        object = object.stream();
        Collector collector = w0.a;
        object = object.map(collector);
        collector = t0.a;
        object = object.filter(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.k.delete((List)object);
    }

    public List E0() {
        String string2 = TemEditorConfig.b(TemEditorConfig$SmartType.SMART_DIY_TRACK);
        List list = this.I0("track/TrackList_co.json");
        return this.H0(string2, list);
    }

    public List F0(List arrayList) {
        k k10;
        Object[] objectArray = null;
        if (arrayList == null) {
            return null;
        }
        HashMap hashMap = arrayList.stream();
        Object object = d.v.j.e.i.a.a;
        hashMap = hashMap.filter(object);
        b b10 = d.v.j.e.i.b.a;
        hashMap = hashMap.map(b10);
        s0 s02 = s0.a;
        boolean bl2 = (hashMap = hashMap.filter(s02)).anyMatch(k10 = d.v.j.e.i.k.a);
        if (!bl2) {
            return null;
        }
        objectArray = arrayList.stream().filter(object).map(b10).filter(s02);
        hashMap = t.a;
        objectArray = objectArray.map(hashMap);
        hashMap = y.a;
        objectArray = d.v.j.g.y.c((List[])objectArray.toArray((IntFunction<A[]>)((Object)hashMap)));
        hashMap = new HashMap();
        arrayList = arrayList.stream().filter(object).map(b10).filter(s02);
        object = new z((List)objectArray, hashMap);
        arrayList.forEach(object);
        objectArray = hashMap.values();
        arrayList = new ArrayList(objectArray);
        objectArray = new Object[]{arrayList};
        m.a.a.b("\u83b7\u53d6\u652f\u6301\u7684\u8bbe\u5907\u5217\u8868: %s", objectArray);
        return arrayList;
    }

    public ScriptTrackPOJO G0(TrackBean object, String list) {
        ScriptTrackPOJO scriptTrackPOJO = new ScriptTrackPOJO();
        Object object2 = ((TrackBean)object).getTrackNameJson();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            list = new b1$e(this);
            list = c.b(((TypeToken)((Object)list)).getType(), (String)object2);
        } else {
            boolean bl3 = TextUtils.isEmpty((CharSequence)((Object)list));
            if (!bl3) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)((Object)list));
                list = ((TrackBean)object).getTrackName();
                ((StringBuilder)object2).append((String)((Object)list));
                list = d.v.e.j.b.d(((StringBuilder)object2).toString());
                object2 = new b1$f(this);
                object2 = ((TypeToken)object2).getType();
                list = (List)c.d((String)((Object)list), (Type)object2);
            } else {
                list = null;
            }
        }
        if (list != null) {
            list = list.stream();
            object2 = n.a;
            list = list.map(object2);
            object2 = Collectors.toList();
            list = list.collect(object2);
            scriptTrackPOJO.setScriptTrackPointList(list);
        }
        if ((list = ((TrackBean)object).getProducts()) != null) {
            list = list.stream();
            object2 = a0.a;
            list = list.map(object2);
            object2 = Collectors.toList();
            list = (List)list.collect(object2);
            scriptTrackPOJO.setScriptTrackMetaDataList(list);
        }
        long l10 = ((TrackBean)object).getTrackId();
        object = ((TrackBean)object).getDurationType();
        list = new ScriptTrack(l10, (String)object);
        scriptTrackPOJO.setScriptTrack((ScriptTrack)((Object)list));
        return scriptTrackPOJO;
    }

    public List H0(String object, List collector) {
        boolean bl2 = d.v.j.b.f((List)((Object)collector));
        if (bl2) {
            return null;
        }
        collector = collector.stream();
        s s10 = new s(this, (String)object);
        object = collector.map(s10);
        collector = Collectors.toList();
        return object.collect(collector);
    }

    public List I0(String object) {
        object = d.v.e.j.b.d((String)object);
        Object object2 = new b1$d(this);
        object = (object = (TrackListBean)c.d((String)object, (Type)(object2 = ((TypeToken)object2).getType()))) == null ? null : ((TrackListBean)object).getTrackList();
        return object;
    }

    public /* synthetic */ ScriptTrackPOJO R0(String string2, TrackBean trackBean) {
        return this.Q0(string2, trackBean);
    }

    public /* synthetic */ TrackBean T0(List list, TrackBean trackBean) {
        return this.S0(list, trackBean);
    }

    public /* synthetic */ ScriptInfoData b1(String string2, String string3) {
        return this.a1(string2, string3);
    }

    public /* synthetic */ void d1() {
        this.c1();
    }

    public LiveData e1(long l10) {
        return this.j.getTemplatePOJOFromSmartReferenceId_LiveData(l10);
    }

    public LiveData f1(long l10) {
        return this.j.getTemplatePOJOFromScriptId_LiveData(l10);
    }

    public LiveData g1() {
        return this.j.getSmartMaxReferenceId_LiveData();
    }

    public boolean k1() {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        p p10 = new p(this);
        appDatabaseTemplate.runInTransaction(p10);
        return true;
    }

    public void l1(ScriptInfoList object, String string2, int n10, int n11, int n12) {
        int n13;
        int n14;
        Object object2;
        boolean bl2;
        c0.d();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        n12 = 1;
        Object object3 = new Object[n12];
        if (object == null) {
            bl2 = false;
            object2 = null;
        } else {
            object2 = ((BaseInfoList)object).getList();
        }
        object3[0] = object2 = d.v.j.g.y.b((List)object2);
        object2 = "\u52a0\u8f7d\u5230\u7684\u6a21\u677f\u7f51\u7edcid\u5217\u8868, ids:%s";
        m.a.a.b((String)object2, (Object[])object3);
        if (object != null && (object3 = ((BaseInfoList)object).getList()) != null && (n14 = (object3 = ((BaseInfoList)object).getList()).size()) > 0) {
            object3 = ((BaseInfoList)object).getList().iterator();
            while (bl2 = object3.hasNext()) {
                object2 = (ScriptInfoData)object3.next();
                object2 = this.C0((ScriptInfoData)object2);
                G_ScriptDao g_ScriptDao = this.j;
                long l10 = g_ScriptDao.insertNetworkScriptData((TemplatePOJO)object2);
                object2 = l10;
                arrayList.add(object2);
            }
        }
        Object[] objectArray = new Object[n12];
        objectArray[0] = arrayList;
        object3 = "\u4fdd\u5b58\u7684\u6a21\u677f\u6570\u636e\u4e3b\u952eid\u5217\u8868, ids:%s";
        m.a.a.b((String)object3, objectArray);
        n12 = 0;
        objectArray = null;
        int n15 = object == null ? 0 : (n13 = ((BaseInfoList)object).getCount());
        object3 = this;
        object2 = string2;
        object = this.u(string2, null, arrayList, n11, n10, n15);
        this.k0((SortResult)object);
    }
}

