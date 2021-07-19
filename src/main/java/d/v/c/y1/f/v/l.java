/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.v;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.d;
import d.v.c.y1.f.v.g;
import d.v.c.y1.f.v.h;
import d.v.e.j.a;
import d.v.j.e.h.k;
import java.util.List;

public class l
extends ViewModel {
    private MediatorLiveData a;
    private final d.v.c.v0.v.a.a b;

    public l() {
        Object object = new MediatorLiveData();
        this.a = object;
        this.b = object = d.a();
    }

    private /* synthetic */ void c(k k10) {
        Object object = k10.a;
        Object object2 = Status.LOADING;
        if (object == object2) {
            return;
        }
        object = k10.c;
        if (object != null) {
            object = (List)object;
            object2 = g.a;
            object.forEach(object2);
        }
        d.v.e.i.h.g(this.a, k10);
    }

    public static /* synthetic */ void e(AlbumData albumData) {
        long l10;
        long l11 = albumData.getResId();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            Object object2 = EditConfig$ResourceType.MUSIC;
            String string2 = albumData.getCoverUrl();
            object2 = TemEditorConfig.c((a)object2, string2);
            albumData.setCoverUrl((String)object2);
        }
    }

    public MutableLiveData b() {
        return this.a;
    }

    public /* synthetic */ void d(k k10) {
        this.c(k10);
    }

    public void f() {
        MediatorLiveData mediatorLiveData = this.a;
        LiveData liveData = this.b.b(true, null);
        h h10 = new h(this);
        mediatorLiveData.addSource(liveData, h10);
    }
}

