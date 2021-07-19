/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class m
implements Consumer {
    public final /* synthetic */ AtomicLong a;

    public /* synthetic */ m(AtomicLong atomicLong) {
        this.a = atomicLong;
    }

    public final void accept(Object object) {
        AtomicLong atomicLong = this.a;
        object = (TemplateSticker)object;
        TemplateDataDao.e(atomicLong, (TemplateSticker)object);
    }
}

