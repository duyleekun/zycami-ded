/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editortemplate.data.api.entity.LastTemplateId;
import d.v.a.f.b.a;
import d.v.c.s0.h7.m0;

public class m0$a
extends a {
    public final /* synthetic */ m0 a;

    public m0$a(m0 m02) {
        this.a = m02;
    }

    public void a(LastTemplateId object) {
        if (object != null) {
            m0 m02 = this.a;
            int n10 = ((LastTemplateId)object).getLastId();
            long l10 = n10;
            object = l10;
            m0.b(m02, (Long)object);
            object = this.a;
            m0.c((m0)object);
        } else {
            object = this.a.m;
            Boolean bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.a.m;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }
}

