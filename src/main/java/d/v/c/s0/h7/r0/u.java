/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.s0.h7.r0.l;
import d.v.c.s0.h7.r0.m;
import d.v.c.s0.h7.r0.n;
import d.v.c.s0.h7.r0.o;
import d.v.c.s0.h7.r0.p;
import d.v.e.h.d;
import d.v.j.b;
import d.v.j.e.c;
import d.v.j.e.i.z0;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class u
extends ViewModel {
    public static final int e = 9;
    public static final String f = "type_me";
    public static final String g = "type_smart";
    public static final String h = "type_id";
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MediatorLiveData c;
    public final MutableLiveData d;

    public u() {
        MutableLiveData mutableLiveData;
        LiveData liveData;
        this.a = liveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData;
        Object object = new MutableLiveData();
        this.d = object;
        object = new l(this);
        liveData = Transformations.switchMap(liveData, (Function)object);
        ((MediatorLiveData)mutableLiveData).removeSource(liveData);
        object = new o(this, liveData);
        ((MediatorLiveData)mutableLiveData).addSource(liveData, (Observer)object);
    }

    public static boolean c(TemplatePOJO object, Set set, List list) {
        boolean bl2;
        TemplateData templateData = ((TemplatePOJO)object).getTemplateData();
        boolean bl3 = templateData.isSmartTemplate();
        if (bl3 && !(bl3 = (templateData = ((TemplatePOJO)object).getTemplateData()).isDIYTemplate()) && (bl2 = list.contains(object = ((TemplatePOJO)object).getTemplateData().showTitle()))) {
            bl2 = set.contains(object);
            if (bl2) {
                return false;
            }
            set.add(object);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private /* synthetic */ LiveData d(String var1_1) {
        block6: {
            block4: {
                block5: {
                    var2_2 = var1_1.hashCode();
                    var3_3 = -1080249212;
                    var4_4 = 2;
                    var5_5 = 1;
                    if (var2_2 == var3_3) break block4;
                    var3_3 = -853090240;
                    if (var2_2 == var3_3) break block5;
                    var3_3 = -853090115;
                    if (var2_2 != var3_3 || (var7_7 = (int)var1_1.equals(var6_6 = "type_me")) == 0) ** GOTO lbl-1000
                    var7_7 = 0;
                    var1_1 = null;
                    break block6;
                }
                var6_6 = "type_id";
                var7_7 = (int)var1_1.equals(var6_6);
                if (var7_7 == 0) ** GOTO lbl-1000
                var7_7 = var5_5;
                break block6;
            }
            var6_6 = "type_smart";
            var7_7 = var1_1.equals(var6_6);
            if (var7_7 != 0) {
                var7_7 = var4_4;
            } else lbl-1000:
            // 3 sources

            {
                var7_7 = -1;
            }
        }
        var2_2 = 3;
        if (var7_7 != 0) {
            if (var7_7 != var5_5) {
                var8_8 = d.v.j.e.c.a().g();
                var9_10 = new int[var4_4];
                var9_10[0] = -1;
                var9_10[1] = 0;
                var10_12 = new int[var5_5];
                var10_12[0] = var5_5;
                var11_14 = new int[var5_5];
                var11_14[0] = 0;
                var12_16 = Boolean.TRUE;
                var13_18 = EditConfig$a.l[var2_2];
                return var8_8.c0(var9_10, var10_12, var11_14, var12_16, var13_18);
            }
            var1_1 = this.b;
            var6_6 = n.a;
            return Transformations.switchMap((LiveData)var1_1, (Function)var6_6);
        }
        var8_9 = d.v.j.e.c.a().g();
        var9_11 = -2;
        var10_13 = 0;
        var11_15 = 0;
        var12_17 = Boolean.TRUE;
        var13_19 = EditConfig$a.l[var2_2];
        var14_20 = 9;
        return var8_9.b0(var9_11, var10_13, var11_15, var12_17, var13_19, false, var14_20);
    }

    private /* synthetic */ void f(LiveData object, List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.c.removeSource((LiveData)object);
        object = p.a;
        list.forEach(object);
        this.c.setValue(list);
    }

    public static /* synthetic */ LiveData i(Long l10) {
        z0 z02 = d.v.j.e.c.a().d();
        int[] nArray = new int[]{-1, 0};
        int n10 = 1;
        int[] nArray2 = new int[n10];
        nArray2[0] = 0;
        int[] nArray3 = new int[n10];
        nArray3[0] = 0;
        Boolean bl2 = Boolean.TRUE;
        String string2 = EditConfig$a.l[3];
        long l11 = l10;
        return z02.T0(nArray, nArray2, nArray3, bl2, string2, l11, true);
    }

    public static /* synthetic */ boolean j(Set set, List list, TemplatePOJO templatePOJO) {
        return u.c(templatePOJO, set, list);
    }

    public int b() {
        return d.v.e.h.d.d((Integer)this.d.getValue(), 1);
    }

    public /* synthetic */ LiveData e(String string2) {
        return this.d(string2);
    }

    public /* synthetic */ void g(LiveData liveData, List list) {
        this.f(liveData, list);
    }

    public List k(List object) {
        Object object2 = g;
        HashSet hashSet = this.a.getValue();
        boolean bl2 = ((String)object2).equals(hashSet);
        if (bl2) {
            boolean bl3;
            hashSet = new HashSet();
            object2 = new Object();
            Object object3 = object.iterator();
            while (bl3 = object3.hasNext()) {
                Object object4 = (TemplatePOJO)object3.next();
                TemplateData templateData = ((TemplatePOJO)object4).getTemplateData();
                boolean bl4 = templateData.isSmartTemplate();
                if (!bl4 || (bl4 = (templateData = ((TemplatePOJO)object4).getTemplateData()).isDIYTemplate()) || (bl4 = hashSet.add(object4 = ((TemplatePOJO)object4).getTemplateData().showTitle()))) continue;
                object2.add(object4);
            }
            hashSet.clear();
            object = object.stream();
            object3 = new m(hashSet, (List)object2);
            object = object.filter(object3);
            hashSet = Collectors.toList();
            object = (List)object.collect(hashSet);
        }
        return object;
    }
}

