/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.WorksDao;
import com.zhiyun.cama.data.database.model.Likes;
import d.v.c.v0.u.a0.e;
import d.v.e.l.w1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k.d;

public class j
extends e {
    private static Map i;
    private int g;
    private WorksDao h;

    static {
        HashMap hashMap;
        i = hashMap = new HashMap();
    }

    private j(int n10, int n11) {
        super(n11);
        WorksDao worksDao;
        this.g = n10;
        this.h = worksDao = DatabaseHelper.getInstance().getDataBase().worksDao();
        this.p(true);
    }

    public static j q(int n10, int n11) {
        Object object = i;
        Integer n12 = n10;
        if ((object = (j)object.get(n12)) == null) {
            object = new j(n10, n11);
            Map map = i;
            Integer n13 = n10;
            map.put(n13, object);
        }
        return object;
    }

    public void e() {
        WorksDao worksDao = this.h;
        int n10 = this.g;
        worksDao.deletedUserLikes(n10);
    }

    public d f(int n10, int n11) {
        d.v.c.v0.l.j j10 = d.v.c.v0.l.j.a;
        int n12 = this.g;
        String string2 = w1.a();
        return j10.d(n12, n10, n11, string2);
    }

    public void i(ArrayList arrayList) {
        boolean bl2;
        if (arrayList != null && !(bl2 = arrayList.isEmpty())) {
            boolean bl3;
            Object object = arrayList.iterator();
            while (bl3 = object.hasNext()) {
                Likes likes = (Likes)object.next();
                int n10 = this.g;
                long l10 = n10;
                likes.setUser(l10);
            }
            object = this.h;
            object.insertLikes(arrayList);
        }
    }
}

