/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.f.b.d.b;
import e.a.i0;
import java.util.List;
import java.util.Optional;

public interface WithdrawDao
extends BaseDao {
    public static final String DELETE_ALL_WITHDRAWS = "DELETE FROM TemplateData WHERE templateData.id IN (SELECT back_id FROM withdraw)";
    public static final String DELETE_WITHDRAW_FROM_CURRENT = "DELETE FROM TemplateData WHERE templateData.id IN (SELECT back_id FROM withdraw WHERE create_time > :currentCreateTime)";
    public static final String QUERY_LAST_WITHDRAW = "SELECT * FROM withdraw,TemplateData WHERE withdraw.back_id = templateData.id ORDER BY withdraw.create_time DESC LIMIT 1";
    public static final String QUERY_LIMIT_DATA = "SELECT * FROM withdraw ORDER BY create_time DESC LIMIT :limit";

    public int deleteWithdrawFromCurrent(long var1);

    public i0 deletedAllWithdraw();

    public List geLimitData(int var1);

    public List getAllWithdraw();

    public TemplatePOJO getLastWithdraw();

    default public void insertWithdraw(TemplatePOJO templatePOJO, Optional object) {
        if (templatePOJO == null) {
            return;
        }
        Object object2 = new b(this);
        ((Optional)object).ifPresent(object2);
        templatePOJO.getTemplateData().setId(0L);
        object = DatabaseHelperTemplate.getInstance().getDataBase().templateDataDao();
        object2 = null;
        long l10 = object.insertOrReplaceTemplateConfig(templatePOJO, false, false);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        object2 = DatabaseHelperTemplate.getInstance().getDataBase();
        long l13 = System.currentTimeMillis();
        Withdraw withdraw = new Withdraw(l10, l13);
        ((AppDatabaseTemplate)object2).withdrawDao().insert(withdraw);
    }
}

