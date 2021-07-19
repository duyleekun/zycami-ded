/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;

public interface TemplateGlobalDao
extends BaseDao {
    public TemplateGlobal getTemplateGlobal(long var1);

    default public void insertGlobal(TemplateGlobal templateGlobal) {
        long l10 = templateGlobal.getTempId();
        TemplateGlobal templateGlobal2 = this.getTemplateGlobal(l10);
        if (templateGlobal2 != null) {
            l10 = templateGlobal2.getId();
            templateGlobal.setId(l10);
            this.update(templateGlobal);
        } else {
            this.replace(templateGlobal);
        }
    }
}

