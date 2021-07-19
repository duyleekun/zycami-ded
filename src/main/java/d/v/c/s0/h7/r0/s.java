/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.r0.f;
import d.v.c.v0.n.d;
import d.v.j.e.c;
import d.v.j.e.i.d1;
import d.v.j.e.i.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class s
extends ViewModel {
    public MutableLiveData a;
    public MutableLiveData b;
    public MutableLiveData c;
    public List d;
    public String e;
    public long f;
    public final LiveData g;
    public final LiveData h;

    public s() {
        Object object = Boolean.FALSE;
        Object object2 = new MutableLiveData(object);
        this.a = object2;
        object2 = new MutableLiveData(object);
        this.b = object2;
        object2 = new MutableLiveData();
        this.c = object2;
        object2 = new ArrayList();
        this.d = object2;
        object = d.v.j.e.c.a().d();
        Object object3 = -2;
        Integer n10 = 0;
        Boolean bl2 = Boolean.TRUE;
        Object object4 = EditConfig$a.l;
        int n11 = 3;
        Object object5 = object4[n11];
        Object object6 = 9;
        object4 = n10;
        Object object7 = bl2;
        object = ((d1)object).d0((Integer)object3, n10, n10, bl2, (String)object5, (Integer)object6);
        object3 = d.v.c.s0.h7.r0.f.a;
        this.g = object = Transformations.map((LiveData)object, (Function)object3);
        object7 = d.v.j.e.c.a().d();
        Object object8 = object5 = (Object)new int[2];
        object8[0] = -1;
        object8[1] = false;
        int n12 = 1;
        object6 = new int[n12];
        object6[0] = false;
        object = new int[n12];
        object[0] = false;
        String string2 = EditConfig$a.l[n11];
        this.h = object2 = ((z0)object7).V0((int[])object5, (int[])object6, (int[])object, bl2, string2);
    }

    private String d() {
        return d.v.c.v0.n.d.s().H();
    }

    public static /* synthetic */ Boolean e(Long l10) {
        long l11;
        long l12 = l10;
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            object = 1;
        } else {
            object = 0;
            l10 = null;
        }
        return (boolean)object;
    }

    public int b(String object, long l10, List list) {
        int n10;
        block1: {
            String string2;
            boolean bl2;
            Object object2;
            TemplatePOJO templatePOJO;
            Iterator iterator2 = list.iterator();
            do {
                boolean bl3 = iterator2.hasNext();
                n10 = 1;
                if (!bl3) break block1;
            } while ((templatePOJO = (TemplatePOJO)iterator2.next()) == null || (object2 = templatePOJO.getTemplateData()) == null || !(bl2 = ((String)(object2 = l0.a(templatePOJO))).equals(string2 = this.d())));
            this.e = object;
            this.f = l10;
            object = this.c;
            Boolean bl4 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl4);
            return list.indexOf(templatePOJO) + n10;
        }
        return n10;
    }

    public int c() {
        boolean bl2;
        String string2 = "type_me";
        Object object = this.e;
        boolean bl3 = string2.equals(object);
        if (bl3) {
            return 0;
        }
        object = this.e;
        string2 = "type_smart";
        bl3 = string2.equals(object);
        int n10 = 1;
        if (bl3) {
            return n10;
        }
        object = this.d.iterator();
        while (bl2 = object.hasNext()) {
            long l10;
            long l11;
            long l12;
            long l13;
            TemplateType templateType = (TemplateType)object.next();
            if (templateType == null || (l13 = (l12 = (l11 = templateType.getId()) - (l10 = this.f)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) continue;
            return this.d.indexOf(templateType);
        }
        return n10;
    }

    public void f(TemplatePOJO object) {
        d d10 = d.v.c.v0.n.d.s();
        object = l0.a((TemplatePOJO)object);
        d10.z0((String)object);
    }
}

