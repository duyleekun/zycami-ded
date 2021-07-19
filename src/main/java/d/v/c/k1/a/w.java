/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.k1.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import d.v.c.k1.a.v;
import d.v.c.k1.a.w$a;
import d.v.c.k1.a.w$b;
import d.v.c.k1.a.x.g;
import d.v.c.k1.a.x.h;
import d.v.c.k1.a.x.i;
import d.v.c.k1.a.x.j;
import d.v.c.k1.a.x.k;
import d.v.c.k1.a.x.l;
import d.v.c.k1.a.x.m;
import d.v.h.e.a;
import d.v.s.b.i$a;
import java.util.ArrayList;
import java.util.List;

public class w
extends AndroidViewModel {
    private static final String[] p = new String[]{"video/quicktime", "video/mp4", "video/ext-mp4", "video/x-flv", "video/flv", "video/3gpp", "video/mov", "image/x-canon-cr2", "image/jpeg", "image/png", "image/gif"};
    private static final String[] q = new String[]{"video/quicktime", "video/mp4", "video/ext-mp4", "video/x-flv", "video/flv", "video/3gpp", "video/mov"};
    private static final String[] r = new String[]{"video/quicktime", "video/mp4", "image/x-canon-cr2", "image/jpeg", "image/png"};
    private final d.v.s.b.i a;
    private j b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private final MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private ObservableList i;
    private final MutableLiveData j;
    private ArrayList k;
    private ArrayList l;
    private ArrayList m;
    private ArrayList n;
    private final i$a o;

    public w(Application object) {
        super((Application)object);
        Object object2 = new MutableLiveData();
        this.c = object2;
        super();
        this.d = object2;
        super();
        this.e = object2;
        object2 = new MutableLiveData();
        this.f = object2;
        object2 = new MutableLiveData();
        this.g = object2;
        object2 = new MutableLiveData();
        this.h = object2;
        this.i = object2 = new ObservableArrayList();
        this.j = object2 = new MutableLiveData();
        object2 = new ArrayList();
        this.k = object2;
        object2 = new ArrayList();
        this.l = object2;
        object2 = new ArrayList();
        this.m = object2;
        object2 = new ArrayList();
        this.n = object2;
        this.o = object2 = new w$a(this);
        object = d.v.s.b.l.J((Context)object);
        this.a = object;
    }

    public static /* synthetic */ ArrayList b(w w10) {
        return w10.l;
    }

    public static /* synthetic */ ArrayList c(w w10) {
        return w10.n;
    }

    public static /* synthetic */ ArrayList d(w w10) {
        return w10.m;
    }

    public static /* synthetic */ ArrayList e(w w10) {
        return w10.k;
    }

    public static /* synthetic */ MutableLiveData f(w w10) {
        return w10.d;
    }

    public static /* synthetic */ MutableLiveData g(w w10) {
        return w10.f;
    }

    public static /* synthetic */ MutableLiveData i(w w10) {
        return w10.g;
    }

    public static /* synthetic */ MutableLiveData j(w w10) {
        return w10.h;
    }

    public MutableLiveData A() {
        return this.j;
    }

    public MutableLiveData F() {
        return this.c;
    }

    public void G(Activity activity, Fragment fragment, long l10) {
        j j10 = this.b;
        MutableLiveData mutableLiveData = this.j;
        j10.e(activity, fragment, l10, mutableLiveData);
    }

    public List H(List list) {
        return this.b.g(list);
    }

    public void I(int n10) {
        Boolean bl2;
        Object object;
        int n11;
        block10: {
            block9: {
                block7: {
                    block8: {
                        n11 = 1;
                        if (n10 == 0) break block7;
                        if (n10 == n11) break block8;
                        n11 = 2;
                        if (n10 != n11) {
                            n11 = 3;
                            if (n10 != n11) {
                                n11 = 4;
                                if (n10 != n11) {
                                    n11 = 5;
                                    if (n10 == n11) {
                                        this.b = object = new i();
                                    }
                                } else {
                                    this.b = object = new h();
                                }
                            } else {
                                this.b = object = new g();
                            }
                        } else {
                            object = new k();
                            this.b = object;
                        }
                        break block9;
                    }
                    object = new m();
                    this.b = object;
                    break block10;
                }
                object = new l();
                this.b = object;
            }
            n11 = 0;
            bl2 = null;
        }
        object = this.c;
        bl2 = n11 != 0;
        d.v.e.i.h.g((MutableLiveData)object, bl2);
    }

    public void J(int n10, int n11) {
        String[] stringArray = this.f;
        Object object = Boolean.TRUE;
        d.v.e.i.h.g((MutableLiveData)stringArray, object);
        stringArray = this.e;
        object = Boolean.FALSE;
        d.v.e.i.h.g((MutableLiveData)stringArray, object);
        stringArray = this.a;
        int n12 = 500;
        stringArray.c(n12);
        stringArray = this.a;
        object = this.o;
        stringArray.x((i$a)object);
        int n13 = 2;
        if (n10 == n13) {
            d.v.s.b.i i10 = this.a;
            String[] stringArray2 = q;
            i10.f(stringArray2);
            this.a.w(n13);
            return;
        }
        n13 = 5;
        if (n10 == n13) {
            d.v.s.b.i i11 = this.a;
            stringArray = r;
            i11.f(stringArray);
            this.a.w(n11);
            return;
        }
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        d.v.s.b.i i12 = this.a;
        String[] stringArray3 = p;
        i12.f(stringArray3);
        this.a.w(6);
    }

    public void K(RecyclerView recyclerView, v v10, int n10) {
        this.b.c(recyclerView, v10, n10);
    }

    public void L() {
        this.a.s();
        MutableLiveData mutableLiveData = this.f;
        Boolean bl2 = Boolean.FALSE;
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    public void M(List list, a a10) {
        this.b.j(list, a10);
    }

    public boolean N(Context object, a a10, List list) {
        object = this.m(list);
        if (object == null) {
            return true;
        }
        this.M(list, a10);
        return false;
    }

    public void k(RecyclerView object, v v10, a a10) {
        this.L();
        j j10 = this.b;
        MutableLiveData mutableLiveData = this.j;
        j10.f((RecyclerView)object, v10, a10, mutableLiveData);
        object = v10.d();
        this.r((List)object);
        this.l();
    }

    public void l() {
        MutableLiveData mutableLiveData = this.e;
        Object object = this.b;
        ObservableList observableList = this.i;
        object = object.h(observableList);
        d.v.e.i.h.g(mutableLiveData, object);
    }

    public TemplateVideo m(List list) {
        return this.b.i(list);
    }

    public int n(List list) {
        return this.b.d(list);
    }

    public MutableLiveData o() {
        return this.e;
    }

    public void onCleared() {
        super.onCleared();
        this.L();
    }

    public boolean p() {
        boolean bl2;
        Object object = this.e.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.e.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void r(List list) {
        this.i.clear();
        this.i.addAll(list);
    }

    public ObservableList s() {
        return this.i;
    }

    public MutableLiveData t() {
        return this.f;
    }

    public ArrayList u() {
        return this.b.b();
    }

    public String[] v() {
        return this.b.a();
    }

    public MutableLiveData w() {
        return this.g;
    }

    public MutableLiveData x() {
        return this.h;
    }

    public MutableLiveData y() {
        return this.d;
    }

    public List z(MediaType object) {
        Object object2 = this.k;
        Object object3 = ((ArrayList)object2).isEmpty();
        if (object3 != 0) {
            object = new ArrayList();
            return object;
        }
        object2 = w$b.a;
        Object object4 = ((Enum)object).ordinal();
        object3 = 1;
        if ((object4 = (Object)object2[object4]) != object3) {
            object3 = 2;
            if (object4 != object3) {
                object3 = 3;
                if (object4 != object3) {
                    object3 = 4;
                    if (object4 != object3) {
                        object = new ArrayList();
                        return object;
                    }
                    return this.n;
                }
                return this.m;
            }
            return this.l;
        }
        return this.k;
    }
}

