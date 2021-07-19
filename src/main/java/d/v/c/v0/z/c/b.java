/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.z.c;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.transition.AssetsTransitionListBean;
import com.zhiyun.cama.data.api.entity.transition.AssetsTransitionListBean$AssetsTransitionBean;
import com.zhiyun.cama.data.api.entity.transition.TransitionListBean;
import com.zhiyun.cama.data.api.entity.transition.TransitionListBean$TransitionBean;
import com.zhiyun.cama.data.api.entity.transition.TransitionListBean$TransitionBean$Ext;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao;
import com.zhiyun.cama.data.database.model.transition.TransitionData;
import d.v.c.m0;
import d.v.c.v0.z.c.a;
import d.v.c.v0.z.c.b$a;
import d.v.e.l.c1;
import d.v.e.l.q2.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class b {
    private TransitionDataDao a;
    private TransitionFileDao b;
    private final AppDatabaseComm c;

    public b() {
        TransitionDataDao transitionDataDao;
        Object object = DatabaseCommHelper.getInstance().getDataBase();
        this.c = object;
        this.a = transitionDataDao = ((AppDatabaseComm)object).transitionDataDao();
        this.b = object = ((AppDatabaseComm)object).transitionFileDao();
    }

    private void b() {
        this.a.deleteAssetsTransition();
    }

    public static b f() {
        return b$a.a();
    }

    private /* synthetic */ void j(String string2, String string3) {
        this.a.updateTransitionPath(string2, string3);
    }

    private List l(AssetsTransitionListBean object) {
        Object object2;
        if (object != null && (object2 = ((AssetsTransitionListBean)object).getList()) != null) {
            int n10;
            object2 = ((AssetsTransitionListBean)object).getList();
            ArrayList<TransitionData> arrayList = new ArrayList<TransitionData>();
            object2 = object2.iterator();
            while ((n10 = object2.hasNext()) != 0) {
                Object object3;
                Object object4 = (AssetsTransitionListBean$AssetsTransitionBean)object2.next();
                long l10 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getId();
                String string2 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getTitle();
                String string3 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getTitle_tw();
                String string4 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getTitle_en();
                int n11 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getSort();
                long l11 = 0L;
                String string5 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getUrl();
                String string6 = String.valueOf(-((AssetsTransitionListBean$AssetsTransitionBean)object4).getId());
                String string7 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getThumb();
                object4 = ((AssetsTransitionListBean$AssetsTransitionBean)object4).getThumb_small();
                TransitionData transitionData = object3;
                object = object3;
                object3 = object4;
                transitionData(l10, string2, string3, string4, n11, l11, string5, string6, string7, (String)object4, 0);
                n10 = transitionData.getTransitionType();
                int n12 = 2;
                if (n10 == n12) {
                    object4 = transitionData.getPath();
                    transitionData.setPath((String)object4);
                }
                arrayList.add(transitionData);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void a() {
        this.a.deleteDownloadTransition();
    }

    public LiveData c() {
        return this.a.getAllTransitionData();
    }

    public LiveData d() {
        return this.b.getAllTransitionFile();
    }

    public List e() {
        Object object = m0.m();
        Class<AssetsTransitionListBean> clazz = AssetsTransitionListBean.class;
        if ((object = (AssetsTransitionListBean)d.v.e.l.q2.c.d((String)object, clazz)) != null && (clazz = ((AssetsTransitionListBean)object).getList()) != null) {
            return this.l((AssetsTransitionListBean)object);
        }
        return Collections.emptyList();
    }

    public void g() {
        this.b();
        this.h();
    }

    public void h() {
        List list = this.e();
        this.i(list);
    }

    public void i(List list) {
        int n10;
        if (list != null && (n10 = list.size()) != 0) {
            TransitionDataDao transitionDataDao = this.a;
            transitionDataDao.insert(list);
        }
    }

    public /* synthetic */ void k(String string2, String string3) {
        this.j(string2, string3);
    }

    public List m(TransitionListBean object) {
        Object object2;
        if (object != null && (object2 = ((TransitionListBean)object).getList()) != null) {
            boolean bl2;
            object2 = ((TransitionListBean)object).getList();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                String string2;
                Object object3 = (TransitionListBean$TransitionBean)object2.next();
                long l10 = ((TransitionListBean$TransitionBean)object3).getZ_film().getId();
                String string3 = ((TransitionListBean$TransitionBean)object3).getTitle();
                String string4 = ((TransitionListBean$TransitionBean)object3).getTitle_tw();
                String string5 = ((TransitionListBean$TransitionBean)object3).getTitle_en();
                int n10 = ((TransitionListBean$TransitionBean)object3).getSort();
                int n11 = ((TransitionListBean$TransitionBean)object3).getZ_film().getSize();
                long l11 = n11;
                String string6 = ((TransitionListBean$TransitionBean)object3).getZ_film().getUrl();
                String string7 = ((TransitionListBean$TransitionBean)object3).getZ_film().getHash();
                String string8 = ((TransitionListBean$TransitionBean)object3).getThumb();
                String string9 = ((TransitionListBean$TransitionBean)object3).getThumb();
                int n12 = ((TransitionListBean$TransitionBean)object3).getRequiredPrime();
                Object object4 = string2;
                object = object2;
                object2 = string2;
                string2 = string9;
                ((TransitionData)object4)(l10, string3, string4, string5, n10, l11, string6, string7, string8, string9, n12);
                object3 = ((TransitionListBean$TransitionBean)object3).getZ_film().getExt();
                if (object3 != null) {
                    object4 = ((TransitionListBean$TransitionBean$Ext)object3).getLicenseName();
                    ((TransitionData)object2).setLicenseName((String)object4);
                    object3 = ((TransitionListBean$TransitionBean$Ext)object3).getLicenseUrl();
                    ((TransitionData)object2).setLicensePath((String)object3);
                }
                arrayList.add(object2);
                object2 = object;
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void n(String string2, String string3) {
        Executor executor = c1.b().d();
        a a10 = new a(this, string2, string3);
        executor.execute(a10);
    }
}

