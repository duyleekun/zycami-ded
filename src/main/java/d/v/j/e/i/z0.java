/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.e.i;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$TemplateType;
import com.zhiyun.editortemplate.data.api.entity.BaseInfoList;
import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoList;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateTypeBean;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateTypeListBean;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import d.v.e.j.b;
import d.v.j.e.i.c;
import d.v.j.e.i.d;
import d.v.j.e.i.d1;
import d.v.j.e.i.e;
import d.v.j.e.i.f;
import d.v.j.e.i.z0$a;
import d.v.j.e.i.z0$b;
import d.v.j.e.i.z0$c;
import d.v.j.g.c0;
import d.v.j.g.y;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import m.a.a;

public class z0
extends d1 {
    private final G_TemplateDao j;
    private final G_TemplateTypeDao k;

    public z0() {
        BaseDao baseDao;
        this.j = baseDao = this.a.templateDao();
        baseDao = this.a.templateTypeDao();
        this.k = baseDao;
    }

    private TemplateType C0(TemplateTypeBean templateTypeBean, int n10, int n11) {
        long l10 = templateTypeBean.getRealTypeId();
        String string2 = templateTypeBean.getTextZh();
        String string3 = templateTypeBean.getTextZhTw();
        String string4 = templateTypeBean.getTextEn();
        return TemplateType.create(l10, string2, string3, string4, n10, n11);
    }

    private void D0(int n10) {
        G_TemplateDataDao g_TemplateDataDao = this.b;
        Integer n11 = -1;
        Integer n12 = 0;
        Integer n13 = n10;
        Boolean bl2 = Boolean.TRUE;
        g_TemplateDataDao.deleteTemplateData(n11, n12, n13, bl2, null);
    }

    private TemplatePOJO H0(TemplateInfoData templateInfoData, int n10) {
        int n11 = templateInfoData.getIsPkg();
        Object object = this;
        TemplatePOJO templatePOJO = this.H(templateInfoData, n11, false, 0, n10, null);
        object = new Template();
        long l10 = templateInfoData.getId();
        ((Template)object).setReferenceId(l10);
        l10 = templateInfoData.getRealTypeId();
        ((Template)object).setTypeId(l10);
        templatePOJO.setTemplate((Template)object);
        return templatePOJO;
    }

    public static /* synthetic */ Integer I0(TemplateType templateType) {
        return (int)templateType.getId();
    }

    private /* synthetic */ void J0(int n10, TemplateInfoData templateInfoData) {
        String string2;
        int n11;
        if (n10 != 0) {
            n11 = 1;
            if (n10 != n11) {
                n10 = 0;
                string2 = null;
            } else {
                long l10 = -998L;
                templateInfoData.setTypeId(l10);
                n10 = -1;
                templateInfoData.setIsPkg(n10);
                string2 = TemEditorConfig.b(TemEditorConfig$TemplateType.EOV);
            }
        } else {
            string2 = TemEditorConfig.b(TemEditorConfig$TemplateType.TEMPLATE);
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        this.Z0(templateInfoData, string2);
    }

    private /* synthetic */ void L0() {
        this.D0(0);
        Iterator iterator2 = d.v.e.j.b.d("editor_template/EditorTypeList.json");
        Object object = new z0$a(this);
        object = ((TypeToken)object).getType();
        iterator2 = (TemplateTypeListBean)d.v.e.l.q2.c.d((String)((Object)iterator2), (Type)object);
        if (iterator2 != null && (iterator2 = ((TemplateTypeListBean)((Object)iterator2)).getList()) != null) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (TemplateTypeBean)iterator2.next();
                int n10 = -1;
                object = this.C0((TemplateTypeBean)object, n10, 0);
                G_TemplateTypeDao g_TemplateTypeDao = this.k;
                g_TemplateTypeDao.updateOrInsert((TemplateType)object);
            }
        }
        this.W0("editor_template/EditorProtocolList.json", 0);
    }

    private /* synthetic */ void N0() {
        int n10 = 1;
        this.D0(n10);
        d.v.j.e.e.a a10 = new TemplateTypeBean();
        a10.setId(-998L);
        String string2 = "\u7247\u5c3e";
        a10.setTextEn(string2);
        a10.setTextZh(string2);
        a10.setTextZhTw(string2);
        a10 = this.C0((TemplateTypeBean)a10, -1, n10);
        this.k.updateOrInsert((TemplateType)a10);
        this.W0("eov/TrailerList.json", n10);
    }

    private void W0(String stream, int n10) {
        stream = d.v.e.j.b.d((String)((Object)stream));
        Object object = new z0$b(this);
        if ((stream = (TemplateInfoList)d.v.e.l.q2.c.d((String)((Object)stream), (Type)(object = ((TypeToken)object).getType()))) == null) {
            return;
        }
        if ((stream = ((BaseInfoList)((Object)stream)).getList()) == null) {
            return;
        }
        stream = stream.stream();
        object = new e(this, n10);
        stream.forEach(object);
    }

    private void Z0(TemplateInfoData object, String object2) {
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object2);
        object2 = ((TemplateInfoData)object).getEditorName();
        ((StringBuilder)object3).append((String)object2);
        object2 = d.v.e.j.b.d(((StringBuilder)object3).toString());
        object3 = new z0$c(this);
        object3 = ((TypeToken)object3).getType();
        object2 = (EditorProtocol)d.v.e.l.q2.c.d((String)object2, (Type)object3);
        if (object2 == null) {
            return;
        }
        int n10 = ((EditorProtocol)object2).getType();
        object = this.H0((TemplateInfoData)object, n10);
        this.l0((TemplatePOJO)object, (EditorProtocol)object2);
    }

    public void E0(long l10) {
        c0.d();
        this.k.delete(l10);
    }

    public long F0(long l10) {
        c0.d();
        return this.j.getTemplateCountFromType(l10);
    }

    public LiveData G0(Integer n10, Integer n11) {
        return this.k.getTemplateType_LiveData(n10, n11);
    }

    public /* synthetic */ void K0(int n10, TemplateInfoData templateInfoData) {
        this.J0(n10, templateInfoData);
    }

    public /* synthetic */ void M0() {
        this.L0();
    }

    public /* synthetic */ void O0() {
        this.N0();
    }

    public LiveData P0(List list) {
        LiveData liveData = this.k.getAllTemplateType_LiveData(list);
        f f10 = f.a;
        return y.l(list, liveData, f10);
    }

    public LiveData Q0(long l10) {
        return Transformations.distinctUntilChanged(this.j.getEditorTemplate_LiveData(l10));
    }

    public LiveData R0(long l10) {
        return this.j.getEditorTemplate_LiveData(l10);
    }

    public LiveData S0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, long l10, boolean bl3) {
        return this.j.getTemplatePOJOFromTemplateType_LiveData(n10, n11, n12, bl2, string2, l10, bl3);
    }

    public LiveData T0(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2, long l10, boolean bl3) {
        G_TemplateDao g_TemplateDao = this.j;
        int[] nArray4 = this.r(nArray);
        int[] nArray5 = nArray2;
        nArray5 = this.s(nArray2);
        int[] nArray6 = nArray3;
        nArray6 = this.q(nArray3);
        return g_TemplateDao.getTemplatePOJOFromTemplateTypeNonNullParam_LiveData(nArray4, nArray5, nArray6, bl2, string2, l10, bl3);
    }

    public LiveData U0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        return this.k.getTemplateTypeFromTemplateData_LiveData(n10, n11, n12, bl2, string2);
    }

    public LiveData V0(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        G_TemplateTypeDao g_TemplateTypeDao = this.k;
        int[] nArray4 = this.r(nArray);
        int[] nArray5 = this.s(nArray2);
        int[] nArray6 = this.q(nArray3);
        return g_TemplateTypeDao.getTemplateTypeFromTemplateDataNonNullParam_LiveData(nArray4, nArray5, nArray6, bl2, string2);
    }

    public boolean X0() {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        c c10 = new c(this);
        appDatabaseTemplate.runInTransaction(c10);
        return true;
    }

    public boolean Y0() {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        d d10 = new d(this);
        appDatabaseTemplate.runInTransaction(d10);
        return true;
    }

    public void a1(TemplateInfoList templateInfoList, String string2, int n10, int n11, long l10, int n12, boolean bl2) {
        int n13;
        G_TemplateDao g_TemplateDao;
        int n14;
        Object object;
        boolean bl3;
        z0 z02 = this;
        c0.d();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n15 = 1;
        Object object2 = new Object[n15];
        if (templateInfoList == null) {
            bl3 = false;
            object = null;
        } else {
            object = templateInfoList.getList();
        }
        object2[0] = object = y.b((List)object);
        object = "\u52a0\u8f7d\u5230\u7684\u6a21\u677f\u7f51\u7edcid\u5217\u8868, ids:%s";
        m.a.a.b((String)object, (Object[])object2);
        if (templateInfoList != null && (object2 = templateInfoList.getList()) != null && (n14 = (object2 = templateInfoList.getList()).size()) > 0) {
            object2 = templateInfoList.getList().iterator();
            while (bl3 = object2.hasNext()) {
                object = (TemplateInfoData)object2.next();
                object = z02.H0((TemplateInfoData)object, n12);
                g_TemplateDao = z02.j;
                long l11 = g_TemplateDao.insertNetworkTemplateData((TemplatePOJO)object, l10);
                object = l11;
                arrayList.add(object);
            }
        }
        Object object3 = new Object[n15];
        object3[0] = arrayList;
        object2 = "\u4fdd\u5b58\u7684\u6a21\u677f\u6570\u636e\u4e3b\u952eid\u5217\u8868, ids:%s";
        m.a.a.b((String)object2, object3);
        G_TemplateDao g_TemplateDao2 = z02.j;
        Integer n16 = 0;
        Integer n17 = n12;
        Boolean bl4 = Boolean.TRUE;
        object = g_TemplateDao2.getSortTemplateDataIds(null, n16, n17, bl4, null, l10, bl2);
        if (templateInfoList == null) {
            n13 = 0;
            g_TemplateDao = null;
        } else {
            n13 = n15 = templateInfoList.getCount();
        }
        object3 = this;
        object2 = string2;
        object3 = this.u(string2, (List)object, arrayList, n11, n10, n13);
        z02.k0((SortResult)object3);
    }

    public void b1(TemplateTypeListBean object, String string2, int n10) {
        List[] listArray;
        List[] listArray2;
        int n11;
        int n12;
        Object object2;
        c0.d();
        List list = null;
        if (object != null && (object2 = ((TemplateTypeListBean)object).getList()) != null && (n12 = (object2 = ((TemplateTypeListBean)object).getList()).size()) > 0) {
            object2 = ((TemplateTypeListBean)object).getList().iterator();
            while ((n11 = object2.hasNext()) != 0) {
                listArray2 = (TemplateTypeBean)object2.next();
                listArray2 = this.C0((TemplateTypeBean)listArray2, 0, 0);
                listArray = this.k;
                listArray.updateOrInsert((TemplateType)listArray2);
            }
        }
        object2 = this.k;
        listArray2 = -1;
        listArray = n10;
        object2 = object2.getTemplateTypeIds((Integer)listArray2, (Integer)listArray);
        listArray2 = this.k;
        Object object3 = Integer.valueOf(n10);
        Comparable<Boolean> comparable = Boolean.TRUE;
        List list2 = listArray2.getTemplateTypeIdsFromTemplateData(null, null, (Integer)object3, (Boolean)comparable, null);
        n11 = 2;
        listArray = new List[n11];
        int n13 = 1;
        object3 = new Long[n13];
        long l10 = -999L;
        comparable = l10;
        object3[0] = comparable;
        listArray[0] = object3 = Arrays.asList(object3);
        listArray[n13] = object2;
        object2 = y.e(listArray);
        listArray2 = new List[n11];
        listArray2[0] = object2;
        listArray2[n13] = list2;
        list = y.c(listArray2);
        object = object == null ? null : ((TemplateTypeListBean)object).getList();
        object = y.b((List)object);
        object = this.v(string2, list, list2, (List)object);
        this.k0((SortResult)object);
    }
}

