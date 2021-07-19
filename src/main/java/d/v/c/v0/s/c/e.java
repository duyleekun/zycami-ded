/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.s.c;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean;
import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean$CaptionStyleBean;
import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean$CaptionStyleBean$Ext;
import com.zhiyun.cama.data.api.entity.font.CaptionStyleListBean$CaptionStyleBean$PlatformBean;
import com.zhiyun.cama.data.api.entity.font.FontListBean;
import com.zhiyun.cama.data.api.entity.font.FontListBean$FontBean;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao;
import com.zhiyun.cama.data.database.dao.font.FontDao;
import com.zhiyun.cama.data.database.dao.font.FontFileDao;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;
import com.zhiyun.cama.data.database.model.font.FontData;
import d.v.c.m0;
import d.v.c.v0.s.c.a;
import d.v.c.v0.s.c.b;
import d.v.c.v0.s.c.c;
import d.v.c.v0.s.c.d;
import d.v.c.v0.s.c.e$a;
import d.v.e.l.c1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class e {
    private FontDao a;
    private FontFileDao b;
    private CaptionStyleDao c;
    private CaptionStyleFileDao d;
    private final AppDatabaseComm e;

    public e() {
        BaseDao baseDao;
        Object object = DatabaseCommHelper.getInstance().getDataBase();
        this.e = object;
        this.a = baseDao = ((AppDatabaseComm)object).fontDao();
        baseDao = ((AppDatabaseComm)object).fontFileDao();
        this.b = baseDao;
        baseDao = ((AppDatabaseComm)object).captionStyleDao();
        this.c = baseDao;
        this.d = object = ((AppDatabaseComm)object).captionStyleFileDao();
    }

    public static e k() {
        return e$a.a();
    }

    private void l() {
        this.a();
        this.o();
    }

    private void n() {
        this.b();
        this.p();
    }

    public static /* synthetic */ CaptionStyleData u(CaptionStyleListBean$CaptionStyleBean object) {
        CaptionStyleData captionStyleData;
        long l10;
        int n10;
        long l11;
        Object object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
        if (object2 == null) {
            l11 = 1L;
        } else {
            object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
            n10 = ((CaptionStyleListBean$CaptionStyleBean$PlatformBean)object2).getId();
            l11 = n10;
        }
        long l12 = l11;
        String string2 = ((CaptionStyleListBean$CaptionStyleBean)object).getName();
        String string3 = ((CaptionStyleListBean$CaptionStyleBean)object).getName();
        String string4 = ((CaptionStyleListBean$CaptionStyleBean)object).getName();
        int n11 = ((CaptionStyleListBean$CaptionStyleBean)object).getSort();
        object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
        if (object2 == null) {
            l10 = 0L;
        } else {
            object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
            n10 = ((CaptionStyleListBean$CaptionStyleBean$PlatformBean)object2).getSize();
            l10 = n10;
        }
        object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
        Object object3 = "";
        Object object4 = object2 == null ? object3 : (object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film().getUrl());
        object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film();
        Object object5 = object2 == null ? object3 : (object2 = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film().getHash());
        String string5 = ((CaptionStyleListBean$CaptionStyleBean)object).getThumb();
        int n12 = ((CaptionStyleListBean$CaptionStyleBean)object).getRequiredPrime();
        object2 = captionStyleData;
        object3 = object4;
        object4 = object5;
        object5 = string5;
        captionStyleData = new CaptionStyleData(l12, string2, string3, string4, n11, l10, (String)object3, (String)object4, string5, n12);
        object = ((CaptionStyleListBean$CaptionStyleBean)object).getZ_film().getExt();
        if (object != null) {
            object2 = ((CaptionStyleListBean$CaptionStyleBean$Ext)object).getLicenseName();
            captionStyleData.setLicenseName((String)object2);
            object = ((CaptionStyleListBean$CaptionStyleBean$Ext)object).getLicenseUrl();
            captionStyleData.setLicensePath((String)object);
        }
        return captionStyleData;
    }

    public static /* synthetic */ FontData v(FontListBean$FontBean fontListBean$FontBean) {
        long l10 = fontListBean$FontBean.getZFilm().getId();
        String string2 = fontListBean$FontBean.getName();
        String string3 = fontListBean$FontBean.getName_tw();
        String string4 = fontListBean$FontBean.getName_en();
        int n10 = fontListBean$FontBean.getSort();
        long l11 = fontListBean$FontBean.getZFilm().getSize();
        String string5 = fontListBean$FontBean.getZFilm().getUrl();
        String string6 = fontListBean$FontBean.getZFilm().getHash();
        String string7 = fontListBean$FontBean.getThumb();
        int n11 = fontListBean$FontBean.getRequiredPrime();
        FontData fontData = new FontData(l10, string2, string3, string4, n10, l11, string5, string6, string7, n11);
        return fontData;
    }

    private /* synthetic */ void w(String string2, String string3) {
        this.c.updateCaptionPath(string2, string3);
    }

    private /* synthetic */ void y(String string2, String string3) {
        this.a.updateFontPath(string2, string3);
    }

    public List A(CaptionStyleListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((CaptionStyleListBean)((Object)stream)).getList()) != null) {
            stream = ((CaptionStyleListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.s.c.c.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public List B(FontListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((FontListBean)((Object)stream)).getList()) != null) {
            stream = ((FontListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.s.c.a.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public void C(String string2, String string3) {
        Executor executor = c1.b().d();
        b b10 = new b(this, string2, string3);
        executor.execute(b10);
    }

    public void D(String string2, String string3) {
        Executor executor = c1.b().d();
        d d10 = new d(this, string2, string3);
        executor.execute(d10);
    }

    public void a() {
        this.c.deleteAssetsCaptionStyle();
    }

    public void b() {
        this.a.deleteAssetsFont();
    }

    public void c() {
        this.c.deleteDownloadCaptionStyle();
    }

    public void d() {
        this.a.deleteDownloadFont();
    }

    public LiveData e() {
        return this.c.getDistinctCaptionStyleDataLiveData();
    }

    public LiveData f() {
        return this.d.getDistinctCaptionStyleLiveData();
    }

    public LiveData g() {
        return this.a.getDistinctFontDataLiveData();
    }

    public LiveData h() {
        return this.b.getDistinctFontFileLiveData();
    }

    public List i() {
        List list = m0.b();
        Class<CaptionStyleListBean> clazz = CaptionStyleListBean.class;
        list = (CaptionStyleListBean)d.v.e.l.q2.c.d((String)((Object)list), clazz);
        boolean bl2 = d.v.j.b.f(list = this.A((CaptionStyleListBean)((Object)list)));
        if (bl2) {
            list = Collections.emptyList();
        }
        return list;
    }

    public List j() {
        List list = m0.h();
        Class<FontListBean> clazz = FontListBean.class;
        list = (FontListBean)d.v.e.l.q2.c.d((String)((Object)list), clazz);
        boolean bl2 = d.v.j.b.f(list = this.B((FontListBean)((Object)list)));
        if (bl2) {
            list = Collections.emptyList();
        }
        return list;
    }

    public void m() {
        this.n();
        this.l();
    }

    public void o() {
        List list = this.i();
        this.r(list);
    }

    public void p() {
        List list = this.j();
        this.t(list);
    }

    public void q(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.d.defaultInsertSingle(list, null);
    }

    public void r(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.c.defaultInsertSingle(list, null);
    }

    public void s(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.b.defaultInsertSingle(list, null);
    }

    public void t(List list) {
        boolean bl2 = d.v.j.b.f(list);
        if (bl2) {
            return;
        }
        this.a.insert(list);
    }

    public /* synthetic */ void x(String string2, String string3) {
        this.w(string2, string3);
    }

    public /* synthetic */ void z(String string2, String string3) {
        this.y(string2, string3);
    }
}

