/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.v0.r.b;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.filter.AssetsFilterListBean;
import com.zhiyun.cama.data.api.entity.filter.AssetsFilterListBean$AssetsFilterBean;
import com.zhiyun.cama.data.api.entity.filter.FilterListBean;
import com.zhiyun.cama.data.api.entity.filter.FilterListBean$FilterBean;
import com.zhiyun.cama.data.api.entity.filter.FilterListBean$FilterBean$ZFilmBean;
import com.zhiyun.cama.data.api.entity.filter.FilterTypeListBean;
import com.zhiyun.cama.data.api.entity.filter.FilterTypeListBean$FilterTypeBean;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.filter.FilterData;
import com.zhiyun.cama.data.database.model.filter.FilterType;
import d.v.c.m0;
import d.v.c.v0.r.b.b;
import d.v.c.v0.r.b.c;
import d.v.c.v0.r.b.d;
import d.v.c.v0.r.b.f;
import d.v.e.i.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class g {
    private static volatile g f;
    private FilterTypeDao a;
    private final FilterDataDao b;
    private final FilterFileDao c;
    private AppDatabaseComm d;
    private List e;

    private g() {
        Object object = new ArrayList();
        this.e = object;
        this.d = object = DatabaseCommHelper.getInstance().getDataBase();
        this.a = object = ((AppDatabaseComm)object).filterTypeDao();
        this.b = object = this.d.filterDataDao();
        this.c = object = this.d.filterFileDao();
    }

    private /* synthetic */ void A(String string2, String string3) {
        this.b.updateFilterPath(string2, string3);
    }

    private /* synthetic */ void C(String string2, String string3) {
        this.b.updateFilterThumbPath(string2, string3);
    }

    private List E(AssetsFilterListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((AssetsFilterListBean)((Object)stream)).getList()) != null) {
            stream = ((AssetsFilterListBean)((Object)stream)).getList().stream();
            collector = new Collector(this);
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    private void b() {
        this.a.deleteAssetsFilterType();
    }

    private List i() {
        block3: {
            block2: {
                boolean bl2;
                Object object = this.e;
                if (object != null && !(bl2 = object.isEmpty())) break block2;
                object = m0.g();
                Class<FilterTypeListBean> clazz = FilterTypeListBean.class;
                object = (FilterTypeListBean)d.v.e.l.q2.c.d((String)object, clazz);
                this.e = object = this.G((FilterTypeListBean)object);
                if (object == null || (bl2 = object.isEmpty())) break block3;
            }
            return this.e;
        }
        return Collections.emptyList();
    }

    private FilterType j(int n10) {
        FilterType filterType;
        boolean bl2;
        Object object = this.i();
        if (object != null) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                long l10;
                filterType = (FilterType)object.next();
                long l11 = filterType.getResId();
                long l12 = l11 - (l10 = (long)n10);
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false) continue;
                break;
            }
        } else {
            bl2 = false;
            filterType = null;
        }
        return filterType;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g k() {
        Object object = f;
        if (object != null) return f;
        object = g.class;
        synchronized (object) {
            g g10 = f;
            if (g10 != null) return f;
            f = g10 = new g();
            return f;
        }
    }

    private void m() {
        List list = this.h();
        this.a();
        this.s(list);
    }

    private void n() {
        this.b();
        this.p();
    }

    private void p() {
        List list = this.i();
        this.q(list);
    }

    private /* synthetic */ void t(MutableLiveData mutableLiveData) {
        this.b();
        this.p();
        Boolean bl2 = Boolean.TRUE;
        h.g(mutableLiveData, bl2);
    }

    private /* synthetic */ FilterData v(AssetsFilterListBean$AssetsFilterBean assetsFilterListBean$AssetsFilterBean) {
        FilterData filterData;
        int n10 = -assetsFilterListBean$AssetsFilterBean.getId();
        String string2 = String.valueOf(n10);
        Object object = this.b.getFilterDataByHash(string2);
        int n11 = -assetsFilterListBean$AssetsFilterBean.getId();
        long l10 = n11;
        String string3 = assetsFilterListBean$AssetsFilterBean.getName();
        String string4 = assetsFilterListBean$AssetsFilterBean.getName_tw();
        String string5 = assetsFilterListBean$AssetsFilterBean.getName_en();
        int n12 = assetsFilterListBean$AssetsFilterBean.getSort();
        long l11 = assetsFilterListBean$AssetsFilterBean.getTypeId();
        String string6 = assetsFilterListBean$AssetsFilterBean.getUrl();
        object = object == null ? "" : ((FilterData)object).getThumb();
        Object object2 = object;
        int n13 = assetsFilterListBean$AssetsFilterBean.getMain_sort();
        object = filterData;
        filterData = new FilterData(l10, string3, string4, string5, n12, l11, 0L, string6, (String)object2, string2, n13, 0);
        return filterData;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ FilterData x(FilterListBean$FilterBean filterListBean$FilterBean) {
        long l10;
        int n10;
        Object object;
        int n11;
        Object object2;
        block13: {
            block12: {
                object2 = filterListBean$FilterBean.getLocal_id();
                n11 = -1;
                object = "";
                if (object2 != null) {
                    int n12;
                    try {
                        object2 = filterListBean$FilterBean.getLocal_id();
                        n12 = Integer.parseInt((String)object2);
                    }
                    catch (Exception exception) {}
                    try {
                        object2 = this.j(n12);
                        if (object2 == null) break block12;
                        n10 = ((ResourceData)object2).getSort();
                    }
                    catch (Exception exception) {}
                    object = object2 = ((FilterType)object2).getThumb();
                    break block13;
                }
            }
            n10 = n11;
            break block13;
            catch (Exception exception) {}
        }
        int n13 = filterListBean$FilterBean.getZFilm().getId();
        long l11 = n13;
        String string2 = filterListBean$FilterBean.getTitle();
        String string3 = filterListBean$FilterBean.getTitle_tw();
        String string4 = filterListBean$FilterBean.getTitle_en();
        int n14 = filterListBean$FilterBean.getSort();
        Object object3 = filterListBean$FilterBean.getLocal_id();
        if (object3 == null) {
            n13 = filterListBean$FilterBean.getGroup_id();
            l10 = n13;
        } else {
            object3 = filterListBean$FilterBean.getLocal_id();
            l10 = Long.parseLong((String)object3);
        }
        long l12 = filterListBean$FilterBean.getZFilm().getSize();
        object3 = filterListBean$FilterBean.getZFilm();
        String string5 = ((FilterListBean$FilterBean$ZFilmBean)object3).getUrl();
        n13 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n13 != 0) {
            object = filterListBean$FilterBean.getThumb();
        }
        Object object4 = object;
        object = filterListBean$FilterBean.getZFilm();
        String string6 = ((FilterListBean$FilterBean$ZFilmBean)object).getHash();
        if (n10 == n11) {
            n10 = filterListBean$FilterBean.getMain_sort();
        }
        int n15 = filterListBean$FilterBean.getRequiredPrime();
        object3 = object2;
        object2 = new FilterData(l11, string2, string3, string4, n14, l10, l12, string5, (String)object4, string6, n10, n15);
        Object object5 = filterListBean$FilterBean.getZFilm().getExt();
        if (object5 != null) {
            object5 = filterListBean$FilterBean.getZFilm().getExt().getLicenseName();
            ((FilterData)object2).setLicenseName((String)object5);
            object5 = filterListBean$FilterBean.getZFilm().getExt().getLicenseUrl();
            ((FilterData)object2).setLicensePath((String)object5);
        }
        return object2;
    }

    public static /* synthetic */ FilterType z(FilterTypeListBean$FilterTypeBean filterTypeListBean$FilterTypeBean) {
        long l10 = filterTypeListBean$FilterTypeBean.getId();
        String string2 = filterTypeListBean$FilterTypeBean.getLabel();
        String string3 = filterTypeListBean$FilterTypeBean.getLabel_tw();
        String string4 = filterTypeListBean$FilterTypeBean.getLabel_en();
        int n10 = filterTypeListBean$FilterTypeBean.getSort();
        String string5 = filterTypeListBean$FilterTypeBean.getThumb();
        FilterType filterType = new FilterType(l10, string2, string3, string4, n10, string5);
        return filterType;
    }

    public /* synthetic */ void B(String string2, String string3) {
        this.A(string2, string3);
    }

    public /* synthetic */ void D(String string2, String string3) {
        this.C(string2, string3);
    }

    public List F(FilterListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((FilterListBean)((Object)stream)).getList()) != null) {
            stream = ((FilterListBean)((Object)stream)).getList().stream();
            collector = new Collector(this);
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public List G(FilterTypeListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((FilterTypeListBean)((Object)stream)).getList()) != null) {
            stream = ((FilterTypeListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.r.b.b.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public void H(String string2, String string3) {
        AppDatabaseComm appDatabaseComm = this.d;
        c c10 = new c(this, string2, string3);
        appDatabaseComm.runOnTransition(c10);
    }

    public void I(String string2, String string3) {
        AppDatabaseComm appDatabaseComm = this.d;
        d d10 = new d(this, string2, string3);
        appDatabaseComm.runOnTransition(d10);
    }

    public void a() {
        this.b.deleteAssetsFilter();
    }

    public void c() {
        this.b.deleteDownloadFilter();
    }

    public void d() {
        this.a.deleteDownloadFilterType();
    }

    public LiveData e() {
        return this.b.getAllFilterData();
    }

    public LiveData f() {
        return this.c.getAllFilterFile();
    }

    public LiveData g() {
        return this.a.getAllFilterTypeData();
    }

    public List h() {
        boolean bl2;
        Object object = m0.e();
        Class<AssetsFilterListBean> clazz = AssetsFilterListBean.class;
        object = (AssetsFilterListBean)d.v.e.l.q2.c.d((String)object, clazz);
        if ((object = this.E((AssetsFilterListBean)object)) != null && !(bl2 = object.isEmpty())) {
            return object;
        }
        return Collections.emptyList();
    }

    public void l() {
        this.m();
        this.n();
    }

    public void o() {
        List list = this.h();
        this.a();
        this.s(list);
    }

    public void q(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            FilterTypeDao filterTypeDao = this.a;
            filterTypeDao.insert(list);
        }
    }

    public LiveData r() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        AppDatabaseComm appDatabaseComm = this.d;
        f f10 = new f(this, mutableLiveData);
        appDatabaseComm.runOnTransition(f10);
        return mutableLiveData;
    }

    public void s(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            FilterDataDao filterDataDao = this.b;
            filterDataDao.insert(list);
        }
    }

    public /* synthetic */ void u(MutableLiveData mutableLiveData) {
        this.t(mutableLiveData);
    }

    public /* synthetic */ FilterData w(AssetsFilterListBean$AssetsFilterBean assetsFilterListBean$AssetsFilterBean) {
        return this.v(assetsFilterListBean$AssetsFilterBean);
    }

    public /* synthetic */ FilterData y(FilterListBean$FilterBean filterListBean$FilterBean) {
        return this.x(filterListBean$FilterBean);
    }
}

