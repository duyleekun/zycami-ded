/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.Script;

public interface ScriptDao
extends BaseDao {
    public static final String QUERY_MAX_REFERENCE_ID = "SELECT MAX(script.reference_id) FROM script";
    public static final String QUERY_SMART_TEMPLATE_FROM_REFERENCE_ID = "SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.reference_id = :referenceId)";
    public static final String QUERY_SMART_TEMPLATE_FROM_SCRIPT_ID = "SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.id == :scriptId)";

    public Long getSmartMaxReferenceId();

    public TemplatePOJO getTemplatePOJOFromScriptId(long var1);

    public TemplatePOJO getTemplatePOJOFromSmartReferenceId(long var1);

    default public long insertNetworkScriptData(TemplatePOJO templatePOJO) {
        Object object;
        boolean bl2;
        Script script = templatePOJO.getScript();
        Object object2 = templatePOJO.getTemplateData();
        long l10 = script.getReferenceId();
        TemplatePOJO templatePOJO2 = this.getTemplatePOJOFromSmartReferenceId(l10);
        boolean bl3 = true;
        if (templatePOJO2 != null && !(bl2 = ((TemplateData)(object = templatePOJO2.getTemplateData())).isFirstLoaded())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = bl3;
        }
        ((TemplateData)object2).setFirstLoaded(bl2);
        if (templatePOJO2 != null) {
            object = templatePOJO2.getTemplateData();
            long l11 = ((TemplateData)object).getId();
            ((TemplateData)object2).setId(l11);
            boolean bl4 = ((TemplateData)object).isDownloadFinished();
            ((TemplateData)object2).setDownloadFinished(bl4);
            object = ((TemplateData)object).getDownloadTimestamp();
            ((TemplateData)object2).setDownloadTimestamp((Long)object);
            object2 = templatePOJO2.getScript();
            long l12 = ((Script)object2).getId();
            script.setId(l12);
            long l13 = ((Script)object2).getScriptId();
            script.setScriptId(l13);
        }
        return (Long)DatabaseHelperTemplate.getInstance().getDataBase().templateDataDao().insertOrUpdateAll((TemplatePOJO)templatePOJO, (boolean)false, (boolean)bl3).first;
    }
}

