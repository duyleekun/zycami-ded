/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.FeedbackDao;
import d.v.c.v0.u.a0.e;
import java.util.ArrayList;
import k.d;

public class f
extends e {
    private FeedbackDao g;

    public f(int n10) {
        super(n10);
        FeedbackDao feedbackDao;
        this.g = feedbackDao = DatabaseHelper.getInstance().getDataBase().feedbackDao();
    }

    public void e() {
        this.g.deleteFeedback();
    }

    public d f(int n10, int n11) {
        d.v.c.v0.l.d d10 = d.v.c.v0.l.d.a;
        String string2 = d.v.a.f.c.d.d.F().K();
        return d10.d(string2, n10, n11);
    }

    public void i(ArrayList arrayList) {
        this.g.insertFeedback(arrayList);
    }
}

