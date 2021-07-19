/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.f.b.e;

import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public final class k
implements Consumer {
    public final /* synthetic */ AtomicLong a;

    public /* synthetic */ k(AtomicLong atomicLong) {
        this.a = atomicLong;
    }

    public final void accept(Object object) {
        AtomicLong atomicLong = this.a;
        object = (TemplateRecording)object;
        TemplateDataDao.p(atomicLong, (TemplateRecording)object);
    }
}

