/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.WorksDao;
import d.v.c.v0.l.j;
import d.v.c.v0.u.a0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k.d;

public class k
extends e {
    private static Map i;
    private int g;
    private WorksDao h;

    static {
        HashMap hashMap;
        i = hashMap = new HashMap();
    }

    private k(int n10, int n11) {
        super(n11);
        WorksDao worksDao;
        this.g = n10;
        this.h = worksDao = DatabaseHelper.getInstance().getDataBase().worksDao();
        this.p(true);
    }

    public static k q(int n10, int n11) {
        Object object = i;
        Integer n12 = n10;
        if ((object = (k)object.get(n12)) == null) {
            object = new k(n10, n11);
            Map map = i;
            Integer n13 = n10;
            map.put(n13, object);
        }
        return object;
    }

    public void e() {
        WorksDao worksDao = this.h;
        int n10 = this.g;
        worksDao.deletedUserWorks(n10);
    }

    public d f(int n10, int n11) {
        j j10 = j.a;
        int n12 = this.g;
        String string2 = d.v.a.f.c.d.d.F().K();
        return j10.b(n12, string2, n10, n11);
    }

    public void i(ArrayList arrayList) {
        this.h.insertWorks(arrayList);
    }
}

