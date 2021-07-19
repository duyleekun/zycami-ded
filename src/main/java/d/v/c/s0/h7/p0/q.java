/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.p0.l;
import d.v.c.s0.h7.p0.m;
import d.v.c.s0.h7.p0.n;
import d.v.c.v0.n.d;
import d.v.e.h.a;
import d.v.e.j.b;
import d.v.j.e.c;
import d.v.j.e.i.d1;
import d.v.j.g.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class q
extends ViewModel {
    public static final int f;
    private MutableLiveData a;
    private MutableLiveData b;
    public MutableLiveData c;
    public MutableLiveData d;
    public final MediatorLiveData e;

    public q() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        Object object = Boolean.FALSE;
        this.c = mutableLiveData = new MutableLiveData(object);
        this.d = mutableLiveData = new MutableLiveData(object);
        this.e = mutableLiveData;
        Object object2 = d.v.j.e.c.a().g();
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        int[] nArray2 = new int[n10];
        nArray2[0] = 0;
        Boolean bl2 = Boolean.TRUE;
        String string2 = EditConfig$a.l[3];
        object = ((d1)object2).c0(null, nArray, nArray2, bl2, string2);
        object2 = new m(this);
        ((MediatorLiveData)mutableLiveData).addSource((LiveData)object, (Observer)object2);
    }

    private void b(List list) {
        TemplatePOJO templatePOJO = new TemplatePOJO();
        Object object = new TemplateData();
        String string2 = this.f();
        ((TemplateData)object).setCoverUrl(string2);
        string2 = this.g();
        ((TemplateData)object).setVideoUrl(string2);
        templatePOJO.setTemplateData((TemplateData)object);
        object = new Template();
        templatePOJO.setTemplate((Template)object);
        list.add(0, templatePOJO);
    }

    private String f() {
        return d.v.e.j.b.h(ResConfig$AppResType.APP_ASSETS, "personal_smart_zh_cn.png");
    }

    private String g() {
        return d.v.e.j.b.h(ResConfig$AppResType.APP_ASSETS, "personal_smart_zh_cn.mp4");
    }

    private boolean k(boolean bl2, Model object, String object2, TemplatePOJO object3, Set set, List list, Map map) {
        String string2 = ((TemplatePOJO)object3).getTemplateData().getVideoRatio();
        boolean bl3 = ((String)object2).equals(string2);
        string2 = null;
        if (bl3) {
            object2 = ((TemplatePOJO)object3).getTemplateData();
            bl3 = ((TemplateData)object2).isDIYTemplate();
            boolean bl4 = true;
            if (bl3) {
                return bl4;
            }
            object2 = ((TemplatePOJO)object3).getScriptTrackPOJOList();
            if (bl2) {
                return d.v.c.s0.h7.u0.l.s((List)object2, object);
            }
            Model model = d.v.c.v0.n.d.s().l();
            object = ((TemplatePOJO)object3).getTemplateData().showTitle();
            boolean bl5 = list.contains(object);
            if (bl5) {
                bl5 = set.contains(object);
                if (bl5) {
                    return false;
                }
                object3 = (Boolean)map.get(object);
                bl5 = d.v.e.h.a.c((Boolean)object3);
                if (!bl5) {
                    model = Model.SMOOTHX;
                }
                if (bl2 = d.v.c.s0.h7.u0.l.s((List)object2, model)) {
                    set.add(object);
                }
                return bl2;
            }
            return bl4;
        }
        return false;
    }

    private /* synthetic */ void l(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        n n10 = n.a;
        list.forEach(n10);
        this.e.setValue(list);
    }

    private /* synthetic */ boolean n(boolean bl2, Model model, String string2, Set set, List list, Map map, TemplatePOJO templatePOJO) {
        return this.k(bl2, model, string2, templatePOJO, set, list, map);
    }

    public MutableLiveData c() {
        return this.b;
    }

    public boolean d() {
        boolean bl2;
        Object object = this.b.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.b.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public MutableLiveData e() {
        return this.a;
    }

    public int i(List list) {
        boolean bl2;
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            TemplatePOJO templatePOJO = (TemplatePOJO)iterator2.next();
            String string3 = l0.a(templatePOJO);
            boolean bl3 = string3.equals(string2 = this.j());
            if (!bl3) continue;
            return list.indexOf(templatePOJO);
        }
        return 0;
    }

    public String j() {
        return d.v.c.v0.n.d.s().E();
    }

    public /* synthetic */ void m(List list) {
        this.l(list);
    }

    public /* synthetic */ boolean o(boolean bl2, Model model, String string2, Set set, List list, Map map, TemplatePOJO templatePOJO) {
        return this.n(bl2, model, string2, set, list, map, templatePOJO);
    }

    public void p(String string2) {
        d.v.c.v0.n.d.s().w0(string2);
    }

    public String r() {
        Object object = this.a.getValue();
        object = object == null ? "" : ((TemplateData)this.a.getValue()).showTitle();
        return object;
    }

    public List s(List object, String object2, boolean bl2, Model model) {
        boolean bl3;
        Object object3;
        Object object4;
        Object object5;
        int n10;
        int n11 = b0.l((String)object2);
        if (n11 == (n10 = -1)) {
            return object;
        }
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (!bl2) {
            boolean bl4;
            boolean bl5;
            object5 = d.v.c.v0.n.d.s().l();
            Iterator iterator2 = object.iterator();
            while (bl5 = iterator2.hasNext()) {
                object4 = (TemplatePOJO)iterator2.next();
                object3 = ((TemplatePOJO)object4).getTemplateData();
                bl4 = ((TemplateData)object3).isDIYTemplate();
                if (bl4 || (bl4 = hashSet.add(object4 = ((TemplatePOJO)object4).getTemplateData().showTitle()))) continue;
                arrayList.add(object4);
            }
            iterator2 = object.iterator();
            while (bl5 = iterator2.hasNext()) {
                Boolean bl6;
                object4 = (TemplatePOJO)iterator2.next();
                object3 = ((TemplatePOJO)object4).getTemplateData();
                bl4 = ((TemplateData)object3).isDIYTemplate();
                if (bl4 || !(bl3 = arrayList.contains(object3 = ((TemplatePOJO)object4).getTemplateData().showTitle())) || (bl3 = d.v.e.h.a.c(bl6 = (Boolean)hashMap.get(object3)))) continue;
                bl5 = d.v.c.s0.h7.u0.l.s(((TemplatePOJO)object4).getScriptTrackPOJOList(), object5);
                object4 = bl5;
                hashMap.put(object3, object4);
            }
            hashSet.clear();
        }
        object = object.stream();
        object4 = object5;
        object3 = this;
        bl3 = bl2;
        object5 = new l(this, bl2, model, (String)object2, hashSet, arrayList, hashMap);
        object = object.filter(object5);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        this.b((List)object);
        return object;
    }
}

