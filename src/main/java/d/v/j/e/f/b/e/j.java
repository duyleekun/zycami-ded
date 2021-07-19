/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class j
implements Consumer {
    public final /* synthetic */ AtomicLong a;

    public /* synthetic */ j(AtomicLong atomicLong) {
        this.a = atomicLong;
    }

    public final void accept(Object object) {
        AtomicLong atomicLong = this.a;
        object = (TemplateVideo)object;
        TemplateDataDao.f(atomicLong, (TemplateVideo)object);
    }
}

