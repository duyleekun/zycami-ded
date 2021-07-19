/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import android.text.TextUtils;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.k1.a.v;
import d.v.c.k1.a.x.c;
import d.v.c.k1.a.x.d;
import d.v.c.k1.a.x.e;
import d.v.c.k1.a.x.f;
import d.v.c.k1.a.x.j;
import d.v.h.e.a;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class m
implements j {
    private ArrayList m;

    public m() {
        ArrayList arrayList;
        this.m = arrayList = new ArrayList();
    }

    public static /* synthetic */ boolean k(a a10) {
        return TextUtils.isEmpty((CharSequence)a10.e());
    }

    public static /* synthetic */ String[] l(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ a m(TemplateVideo templateVideo) {
        a a10 = new a();
        Object object = "";
        a10 = a10.l((String)object).p((String)object);
        object = MediaType.VIDEO;
        a10 = a10.m((MediaType)((Object)object));
        long l10 = templateVideo.getEndTime();
        long l11 = templateVideo.getStartTime();
        l10 = (l10 - l11) * 1000000L;
        l11 = templateVideo.getTimebase();
        return a10.k(l10 /= l11);
    }

    public String[] a() {
        Stream<Object> stream = this.m.stream();
        Object object = c.a;
        stream = stream.map(object);
        object = f.a;
        return (String[])stream.toArray((IntFunction<A[]>)object);
    }

    public ArrayList b() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void c(RecyclerView recyclerView, v v10, int n10) {
        a a10 = ((a)v10.d().get(n10)).c();
        Object object = "";
        a10 = a10.l((String)object).p((String)object);
        object = v10.d();
        ((ObservableArrayList)object).set(n10, a10);
        int n11 = -1;
        if (n10 == n11 || n10 >= (n11 = v10.getItemCount() + -3)) {
            n10 = v10.getItemCount();
        }
        recyclerView.smoothScrollToPosition(n10);
    }

    public int d(List list) {
        int n10;
        block2: {
            int n11;
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                String string2 = ((a)list.get(n10)).e();
                n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n11 == 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public void e(Activity stringArray, Fragment fragment, long l10, MutableLiveData mutableLiveData) {
        stringArray = this.a();
        EditorTemplateEditActivity.Y(fragment, stringArray, l10);
    }

    public void f(RecyclerView recyclerView, v v10, a a10, MutableLiveData object) {
        object = v10.d();
        TemplateVideo templateVideo = this.i((List)object);
        if (templateVideo == null) {
            return;
        }
        this.j((List)object, a10);
        v10.notifyDataSetChanged();
        int n10 = this.d((List)object);
        v10.q(n10);
        int n11 = -1;
        if (n10 == n11 || n10 >= (n11 = v10.getItemCount() + -3)) {
            n10 = v10.getItemCount();
        }
        recyclerView.smoothScrollToPosition(n10);
    }

    public List g(List stream) {
        this.m.clear();
        this.m.addAll(stream);
        stream = stream.stream();
        Object object = d.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public boolean h(List object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return false;
        }
        object = object.stream();
        e e10 = e.a;
        return object.noneMatch(e10);
    }

    public TemplateVideo i(List list) {
        int n10;
        int n11 = this.d(list);
        if (n11 == (n10 = -1)) {
            return null;
        }
        return (TemplateVideo)this.m.get(n11);
    }

    public void j(List object, a object2) {
        int n10;
        int n11 = this.d((List)object);
        if (n11 == (n10 = -1)) {
            return;
        }
        object = (a)object.get(n11);
        Object object3 = ((a)object2).e();
        object = ((a)object).l((String)object3);
        object3 = ((a)object2).i();
        object = ((a)object).p((String)object3);
        object3 = ((a)object2).f();
        ((a)object).m((MediaType)((Object)object3));
        object = (TemplateVideo)this.m.get(n11);
        object2 = ((a)object2).e();
        ((TemplateVideo)object).setVideoPath((String)object2);
    }
}

