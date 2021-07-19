/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.f.b.d.a;
import e.a.i0;
import java.util.List;

public interface DraftDao
extends BaseDao {
    public static final String DELETE_DRAFT_ID = "DELETE FROM draft WHERE draft_id = :draftId";
    public static final String QUERY_ALL_DRAFT = "SELECT * FROM draft,TemplateData WHERE draft.draft_id = templateData.id ORDER BY draft.create_time DESC";
    public static final String QUERY_LAST_DRAFT = "SELECT * FROM draft,TemplateData WHERE draft.draft_id = templateData.id ORDER BY draft.create_time DESC LIMIT 1";
    public static final String SELECT_LATEST_DRAFT = "SELECT * FROM draft ORDER BY create_time DESC LIMIT 1";
    public static final String UPDATE_DRAFT_DESC = "UPDATE draft SET content_desc = :desc WHERE draft_id = :draftId";

    public static /* synthetic */ Boolean h(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 != (n11 = -1)) {
            n12 = 1;
        } else {
            n12 = 0;
            n10 = null;
        }
        return n12 != 0;
    }

    public List getAllDraft();

    public Draft getLatestDraft();

    public TemplatePOJO getLatestDraftPOJO();

    default public void insertDraft(TemplatePOJO object) {
        long l10;
        if (object == null) {
            return;
        }
        G_TemplateDataDao g_TemplateDataDao = DatabaseHelperTemplate.getInstance().getDataBase().templateDataDao();
        long l11 = g_TemplateDataDao.insertOrReplaceTemplateConfig((TemplatePOJO)object, false, false);
        long l12 = l11 - (l10 = (long)-1);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return;
        }
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        if ((object = ((TemplatePOJO)object).getDraft()) == null) {
            object = new Draft();
            long l13 = System.currentTimeMillis();
            ((Draft)object).setCreateTime(l13);
        }
        ((Draft)object).setDraftId(l11);
        appDatabaseTemplate.draftDao().insert(object);
    }

    public i0 updateDesc(long var1, String var3);

    default public i0 updateDescBoolean(long l10, String string2) {
        i0 i02 = this.updateDesc(l10, string2);
        a a10 = a.a;
        return i02.z0(a10);
    }
}

