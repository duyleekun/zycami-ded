/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.x1.p.c;
import d.v.e.i.h;
import d.v.h.e.a;
import d.v.h.e.d;
import java.lang.constant.Constable;

public class e
extends ViewModel {
    private MutableLiveData a;
    private c b;
    public MutableLiveData c;

    public e() {
        Constable constable = Float.valueOf(1.0f);
        Object object = new MutableLiveData(constable);
        this.a = object;
        this.b = object = new c();
        constable = Boolean.TRUE;
        this.c = object = new MutableLiveData(constable);
    }

    public MutableLiveData b() {
        return this.c;
    }

    public MutableLiveData c() {
        return this.a;
    }

    public d.v.c.q0.e d() {
        return (d.v.c.q0.e)this.b.a();
    }

    public void e(d.v.c.q0.e e10) {
        this.b.b(e10);
    }

    public void f(d object) {
        boolean bl2;
        MediaType mediaType;
        MutableLiveData mutableLiveData = this.c;
        MediaType mediaType2 = ((a)object).f();
        if (mediaType2 == (mediaType = MediaType.VIDEO) && !(bl2 = ((a)object).j())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        h.g(mutableLiveData, object);
    }
}

