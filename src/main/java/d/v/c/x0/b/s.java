/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.api.entity.sticker.StickerTabInfo;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.sticker.StickerType;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.y.d.b;
import d.v.c.x0.b.n;
import d.v.c.x0.b.o;
import d.v.e.i.h;
import d.v.h.d.c;
import d.v.j.e.h.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s
extends ViewModel {
    private MutableLiveData a;
    private d.v.c.x1.p.c b;
    private final MutableLiveData c;
    public LiveData d;
    public b e;
    private LiveData f;

    public s() {
        Object object = new MutableLiveData();
        this.a = object;
        this.b = object = new d.v.c.x1.p.c();
        this.c = object = new MutableLiveData();
        this.e = object = d.v.c.v0.y.d.b.u();
    }

    public static /* synthetic */ List i(k object) {
        int n10;
        Object object2;
        Status status;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null && (status = ((k)object).a) != (object2 = Status.LOADING) && (object = (List)((k)object).c) != null && (n10 = object.size()) != 0) {
            int n11;
            status = null;
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                object2 = (StickerType)object.get(n10);
                StickerTabInfo stickerTabInfo = new StickerTabInfo();
                long l10 = ((ResourceData)object2).getResId();
                stickerTabInfo = stickerTabInfo.setId(l10);
                String string2 = ((ResourceData)object2).getLabel();
                stickerTabInfo = stickerTabInfo.setLabel(string2);
                string2 = ((ResourceData)object2).getLabel_en();
                stickerTabInfo = stickerTabInfo.setLabel_en(string2);
                object2 = ((ResourceData)object2).getLabel_tw();
                object2 = stickerTabInfo.setLabel_tw((String)object2).setLabelIndex(n10);
                arrayList.add(object2);
            }
        }
        return arrayList;
    }

    public o b() {
        return (o)this.c.getValue();
    }

    public MutableLiveData c() {
        return this.a;
    }

    public List d() {
        return Collections.emptyList();
    }

    public LiveData e() {
        return this.f;
    }

    public LiveData f() {
        return this.d;
    }

    public void g() {
        LiveData liveData;
        this.f = liveData = this.e.c();
        n n10 = n.a;
        this.d = liveData = Transformations.map(liveData, n10);
    }

    public c j() {
        return (c)this.b.a();
    }

    public void k(o o10) {
        h.g(this.c, o10);
    }

    public void l(c c10) {
        this.b.b(c10);
    }
}

