/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.d;

import com.zhiyun.editortemplate.data.database.dao.draft.WithdrawDao;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ WithdrawDao a;

    public /* synthetic */ b(WithdrawDao withdrawDao) {
        this.a = withdrawDao;
    }

    public final void accept(Object object) {
        WithdrawDao withdrawDao = this.a;
        long l10 = (Long)object;
        withdrawDao.deleteWithdrawFromCurrent(l10);
    }
}

