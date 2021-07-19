/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.main.EditorMainActivity;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.k1.a.v;
import d.v.c.k1.a.x.j;
import d.v.h.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l
implements j {
    public static final int n = 9;
    private ArrayList m;

    public l() {
        ArrayList arrayList;
        this.m = arrayList = new ArrayList();
    }

    public String[] a() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ArrayList b() {
        return this.m;
    }

    public void c(RecyclerView recyclerView, v v10, int n10) {
        v10.d().remove(n10);
        v10.notifyDataSetChanged();
    }

    public int d(List object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void e(Activity activity, Fragment object, long l10, MutableLiveData mutableLiveData) {
        object = this.b();
        EditorMainActivity.T(activity, (ArrayList)object);
        ActivityCompat.finishAfterTransition(activity);
    }

    public void f(RecyclerView recyclerView, v v10, a a10, MutableLiveData mutableLiveData) {
        v10.addData(a10);
        v10.notifyDataSetChanged();
        int n10 = v10.getItemCount();
        recyclerView.smoothScrollToPosition(n10);
    }

    public List g(List list) {
        return Collections.emptyList();
    }

    public boolean h(List list) {
        this.m.clear();
        this.m.addAll(list);
        return list.isEmpty() ^ true;
    }

    public TemplateVideo i(List object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void j(List object, a a10) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

