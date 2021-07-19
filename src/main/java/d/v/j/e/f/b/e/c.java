/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import java.util.function.Consumer;

public final class c
implements Consumer {
    public final /* synthetic */ TemplateDataDao a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ TemplatePOJO d;

    public /* synthetic */ c(TemplateDataDao templateDataDao, boolean bl2, boolean bl3, TemplatePOJO templatePOJO) {
        this.a = templateDataDao;
        this.b = bl2;
        this.c = bl3;
        this.d = templatePOJO;
    }

    public final void accept(Object object) {
        TemplateDataDao templateDataDao = this.a;
        boolean bl2 = this.b;
        boolean bl3 = this.c;
        TemplatePOJO templatePOJO = this.d;
        object = (TemplateData)object;
        TemplateDataDao.j(templateDataDao, bl2, bl3, templatePOJO, (TemplateData)object);
    }
}

