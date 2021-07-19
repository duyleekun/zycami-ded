/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.v0.y.b;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean$AssetsStickerBean;
import com.zhiyun.cama.data.api.entity.sticker.StickerListBean;
import com.zhiyun.cama.data.api.entity.sticker.StickerListBean$StickerBean;
import com.zhiyun.cama.data.api.entity.sticker.StickerListBean$StickerBean$PlatformBean;
import com.zhiyun.cama.data.api.entity.sticker.StickerTypeListBean;
import com.zhiyun.cama.data.api.entity.sticker.StickerTypeListBean$StickerTypeBean;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao;
import com.zhiyun.cama.data.database.model.sticker.StickerData;
import com.zhiyun.cama.data.database.model.sticker.StickerType;
import d.v.c.m0;
import d.v.c.v0.y.b.a;
import d.v.c.v0.y.b.b;
import d.v.c.v0.y.b.c;
import d.v.c.v0.y.b.d;
import d.v.c.v0.y.b.e$a;
import d.v.e.l.c1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class e {
    private StickerDataDao a;
    private StickerTypeDao b;
    private StickerFileDao c;
    private final AppDatabaseComm d;

    public e() {
        BaseDao baseDao;
        Object object = DatabaseCommHelper.getInstance().getDataBase();
        this.d = object;
        this.a = baseDao = ((AppDatabaseComm)object).stickerDataDao();
        baseDao = ((AppDatabaseComm)object).stickerTypeDao();
        this.b = baseDao;
        this.c = object = ((AppDatabaseComm)object).stickerFileDao();
    }

    private void c() {
        this.a.deleteAssetsSticker();
    }

    public static e l() {
        return e$a.a();
    }

    private void p() {
        List list = this.j();
        this.q(list);
    }

    private void r() {
        List list = this.k();
        this.s(list);
    }

    public static /* synthetic */ StickerData t(AssetsStickerListBean$AssetsStickerBean assetsStickerListBean$AssetsStickerBean) {
        boolean bl2;
        Object object = assetsStickerListBean$AssetsStickerBean.getLittleThumb();
        if (object == null || (bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object = assetsStickerListBean$AssetsStickerBean.getThumb();
        }
        String string2 = object;
        long l10 = assetsStickerListBean$AssetsStickerBean.getId();
        String string3 = assetsStickerListBean$AssetsStickerBean.getName();
        String string4 = assetsStickerListBean$AssetsStickerBean.getName();
        String string5 = assetsStickerListBean$AssetsStickerBean.getName();
        int n10 = assetsStickerListBean$AssetsStickerBean.getSort();
        long l11 = assetsStickerListBean$AssetsStickerBean.getTypeId();
        String string6 = assetsStickerListBean$AssetsStickerBean.getName();
        float f10 = assetsStickerListBean$AssetsStickerBean.getScale();
        String string7 = assetsStickerListBean$AssetsStickerBean.getThumb();
        String string8 = assetsStickerListBean$AssetsStickerBean.getUrl();
        String string9 = String.valueOf(-assetsStickerListBean$AssetsStickerBean.getId());
        object = new StickerData(l10, string3, string4, string5, n10, l11, 0L, string6, f10, string7, string2, string8, string9, 0);
        return object;
    }

    public static /* synthetic */ StickerData u(StickerListBean$StickerBean stickerListBean$StickerBean) {
        StickerData stickerData;
        StickerData stickerData2;
        Object object = stickerListBean$StickerBean.getZ_film();
        long l10 = ((StickerListBean$StickerBean$PlatformBean)object).getId();
        String string2 = stickerListBean$StickerBean.getTitle();
        String string3 = stickerListBean$StickerBean.getTitle();
        String string4 = stickerListBean$StickerBean.getTitle();
        int n10 = stickerListBean$StickerBean.getSort();
        int n11 = stickerListBean$StickerBean.getLocalId();
        n11 = n11 == 0 ? stickerListBean$StickerBean.getTypeId() : stickerListBean$StickerBean.getLocalId();
        long l11 = n11;
        n11 = stickerListBean$StickerBean.getZ_film().getSize();
        long l12 = n11;
        String string5 = stickerListBean$StickerBean.getZ_film().getName();
        float f10 = 1.0f;
        String string6 = stickerListBean$StickerBean.getThumb();
        String string7 = stickerListBean$StickerBean.getThumb();
        String string8 = stickerListBean$StickerBean.getZ_film().getUrl();
        String string9 = stickerListBean$StickerBean.getZ_film().getHash();
        int n12 = stickerListBean$StickerBean.getRequiredPrime();
        object = stickerData2;
        stickerData2 = new StickerData(l10, string2, string3, string4, n10, l11, l12, string5, f10, string6, string7, string8, string9, n12);
        object = stickerListBean$StickerBean.getExt();
        if (object != null) {
            object = stickerListBean$StickerBean.getExt().getLicenseName();
            stickerData = stickerData2;
            stickerData2.setLicenseName((String)object);
            object = stickerListBean$StickerBean.getExt().getLicenseUrl();
            stickerData2.setLicenseName((String)object);
        } else {
            stickerData = stickerData2;
        }
        return stickerData;
    }

    public static /* synthetic */ StickerType v(StickerTypeListBean$StickerTypeBean stickerTypeListBean$StickerTypeBean) {
        long l10 = stickerTypeListBean$StickerTypeBean.getId();
        String string2 = stickerTypeListBean$StickerTypeBean.getLabel();
        String string3 = stickerTypeListBean$StickerTypeBean.getLabel_tw();
        String string4 = stickerTypeListBean$StickerTypeBean.getLabel_en();
        int n10 = stickerTypeListBean$StickerTypeBean.getSort();
        StickerType stickerType = new StickerType(l10, string2, string3, string4, n10);
        return stickerType;
    }

    private /* synthetic */ void w(String string2, String string3) {
        this.a.updateStickerPath(string2, string3);
    }

    private List y(AssetsStickerListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((AssetsStickerListBean)((Object)stream)).getList()) != null) {
            stream = ((AssetsStickerListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.y.b.b.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public List A(StickerTypeListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((StickerTypeListBean)((Object)stream)).getList()) != null) {
            stream = ((StickerTypeListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.y.b.a.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }

    public void B(String string2, String string3) {
        Executor executor = c1.b().d();
        c c10 = new c(this, string2, string3);
        executor.execute(c10);
    }

    public void a() {
        this.a.deleteDownloadSticker();
    }

    public void b() {
        this.b.deleteDownloadStickerType();
    }

    public void d() {
        this.b.deleteAssetsStickerType();
    }

    public void e(int n10) {
        this.a.deleteDownloadStickerByType(n10);
    }

    public LiveData f() {
        return this.a.getAllStickerData();
    }

    public LiveData g(int n10) {
        return this.a.getStickerDataByType(n10);
    }

    public LiveData h() {
        return this.c.getAllStickerFile();
    }

    public LiveData i() {
        return this.b.getAllStickerTypeData();
    }

    public List j() {
        boolean bl2;
        Object object = m0.k();
        Class<AssetsStickerListBean> clazz = AssetsStickerListBean.class;
        object = (AssetsStickerListBean)d.v.e.l.q2.c.d((String)object, clazz);
        if ((object = this.y((AssetsStickerListBean)object)) != null && !(bl2 = object.isEmpty())) {
            return object;
        }
        return Collections.emptyList();
    }

    public List k() {
        int n10;
        Object object = m0.l();
        Class<StickerTypeListBean> clazz = StickerTypeListBean.class;
        object = (StickerTypeListBean)d.v.e.l.q2.c.d((String)object, clazz);
        if ((object = this.A((StickerTypeListBean)object)) != null && (n10 = object.size()) != 0) {
            return object;
        }
        return Collections.emptyList();
    }

    public void m() {
        this.n();
        this.o();
    }

    public void n() {
        this.c();
        this.p();
    }

    public void o() {
        this.d();
        this.r();
    }

    public void q(List list) {
        int n10;
        if (list != null && (n10 = list.size()) != 0) {
            StickerDataDao stickerDataDao = this.a;
            stickerDataDao.insert(list);
        }
    }

    public void s(List list) {
        int n10;
        if (list != null && (n10 = list.size()) != 0) {
            StickerTypeDao stickerTypeDao = this.b;
            stickerTypeDao.insert(list);
        }
    }

    public /* synthetic */ void x(String string2, String string3) {
        this.w(string2, string3);
    }

    public List z(StickerListBean stream) {
        Collector collector;
        if (stream != null && (collector = ((StickerListBean)((Object)stream)).getList()) != null) {
            stream = ((StickerListBean)((Object)stream)).getList().stream();
            collector = d.v.c.v0.y.b.d.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return Collections.emptyList();
    }
}

