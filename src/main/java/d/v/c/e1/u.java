/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.text.TextUtils
 */
package d.v.c.e1;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.filter.FilterData;
import com.zhiyun.cama.data.database.model.filter.FilterFile;
import com.zhiyun.cama.data.database.model.filter.FilterType;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorsdk.frame.FilterThumbUseCase;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$FilterType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.e1.k;
import d.v.c.e1.l;
import d.v.c.e1.m;
import d.v.c.e1.n;
import d.v.c.e1.o;
import d.v.c.e1.p;
import d.v.c.e1.q;
import d.v.c.m0;
import d.v.c.q0.e;
import d.v.c.x1.p.c;
import d.v.e.i.h;
import d.v.e.j.a;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.e.l.w1;
import d.v.f.i.g;
import d.v.j.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class u
extends d.v.c.b2.v.b {
    private MutableLiveData g;
    private LiveData h;
    private LiveData i;
    private LiveData j;
    private final MediatorLiveData k;
    private c l;
    private FilterThumbUseCase m;
    private d.v.c.v0.r.d.a n;
    private d.v.c.v0.r.a.a o;
    private boolean p;

    public u() {
        Object object = new MutableLiveData();
        this.g = object;
        this.k = object;
        this.l = object = new c();
        this.n = object = d.v.c.v0.r.d.a.u();
        this.o = object = d.v.c.v0.r.a.a.u();
    }

    private FilterType A(long l10, List object) {
        boolean bl2;
        FilterType filterType = null;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                FilterType filterType2 = (FilterType)object.next();
                long l11 = filterType2.getResId();
                long l12 = l11 - l10;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false) continue;
                filterType = filterType2;
                break;
            }
        }
        return filterType;
    }

    private /* synthetic */ void G(Bitmap bitmap, String string2) {
        this.T(bitmap, string2);
    }

    public static /* synthetic */ boolean I(d.v.h.f.a object, String string2, List list, String string3, int n10) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl32 = ((d.v.h.f.a)object).l();
        boolean bl5 = true;
        if (!(bl32 ? (bl32 == bl5 || bl32 == (bl4 = 2 != 0)) && (bl3 = string3.equals(object = ((q)list.get(n10)).S())) : (bl2 = string2.equals(object = ((q)list.get(n10)).R())))) {
            bl5 = false;
        }
        return bl5;
    }

    private /* synthetic */ void J(AtomicReference object, AtomicReference object2, Context context, AtomicReference atomicReference, AtomicReference atomicReference2, d.v.j.e.h.k object3) {
        Object object4 = ((d.v.j.e.h.k)object3).a;
        Status status = Status.LOADING;
        if (object4 == status) {
            return;
        }
        object4 = (Integer)((AtomicReference)object).get() + 1;
        ((AtomicReference)object).set(object4);
        object3 = ((d.v.j.e.h.k)object3).c;
        ((AtomicReference)object2).set(object3);
        Object object5 = object2 = ((AtomicReference)object2).get();
        object5 = (List)object2;
        Object object6 = object2 = atomicReference.get();
        object6 = (List)object2;
        Object object7 = object2 = atomicReference2.get();
        object7 = (List)object2;
        int n10 = (Integer)((AtomicReference)object).get();
        object4 = this;
        status = context;
        this.W(context, (List)object5, (List)object6, (List)object7, n10);
        object = this.k;
        object2 = this.h;
        d.v.e.i.h.c((MediatorLiveData)object, (LiveData)object2);
    }

    private /* synthetic */ void L(AtomicReference object, AtomicReference object2, Context context, AtomicReference atomicReference, AtomicReference atomicReference2, d.v.j.e.h.k object3) {
        int n10;
        Object object4 = ((d.v.j.e.h.k)object3).a;
        Status status = Status.LOADING;
        if (object4 == status) {
            return;
        }
        object4 = (Integer)((AtomicReference)object).get();
        int n11 = (Integer)object4;
        if (n11 != (n10 = 2)) {
            n11 = (Integer)((AtomicReference)object).get() + 1;
            object4 = n11;
            ((AtomicReference)object).set(object4);
        }
        object3 = ((d.v.j.e.h.k)object3).c;
        ((AtomicReference)object2).set(object3);
        atomicReference = atomicReference.get();
        Object object5 = atomicReference;
        object5 = (List)((Object)atomicReference);
        Object object6 = object2 = ((AtomicReference)object2).get();
        object6 = (List)object2;
        Object object7 = object2 = atomicReference2.get();
        object7 = (List)object2;
        int n12 = (Integer)((AtomicReference)object).get();
        object4 = this;
        status = context;
        this.W(context, (List)object5, (List)object6, (List)object7, n12);
        object = this.k;
        object2 = this.i;
        d.v.e.i.h.c((MediatorLiveData)object, (LiveData)object2);
    }

    private /* synthetic */ void N(AtomicReference atomicReference, Context context, AtomicReference atomicReference2, AtomicReference atomicReference3, AtomicReference atomicReference4, List list) {
        atomicReference.set(list);
        atomicReference2 = atomicReference2.get();
        Object object = atomicReference2;
        object = (List)((Object)atomicReference2);
        atomicReference2 = atomicReference3.get();
        Object object2 = atomicReference2;
        object2 = (List)((Object)atomicReference2);
        atomicReference = atomicReference.get();
        Object object3 = atomicReference;
        object3 = (List)((Object)atomicReference);
        int n10 = (Integer)atomicReference4.get();
        this.W(context, (List)object, (List)object2, (List)object3, n10);
    }

    private /* synthetic */ void Q(d.v.h.f.a a10, List list) {
        boolean bl2 = b.f(list);
        if (bl2) {
            return;
        }
        int n10 = this.p(list, a10);
        this.l(n10);
    }

    private void T(Bitmap object, String string2) {
        if (object == null) {
            return;
        }
        Object object2 = new StringBuilder();
        Object object3 = k2.J("filter_cache").getAbsolutePath();
        ((StringBuilder)object2).append((String)object3);
        object3 = File.separator;
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        long l10 = System.currentTimeMillis();
        stringBuilder.append(l10);
        object2 = ".jpg";
        stringBuilder.append((String)object2);
        object2 = stringBuilder.toString();
        object3 = new File((String)object2);
        object2 = new FileOutputStream((File)object3);
        stringBuilder = Bitmap.CompressFormat.JPEG;
        int n10 = 100;
        object.compress((Bitmap.CompressFormat)stringBuilder, n10, (OutputStream)object2);
        object = this.o;
        object3 = ((File)object3).getAbsolutePath();
        try {
            ((d.v.c.v0.r.a.a)object).updateFilterThumbPath((String)object3, string2);
            ((OutputStream)object2).flush();
            ((FileOutputStream)object2).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private List V(Context object, List list, List object2, List list2) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = this.t((Context)object);
        Object object3 = 0;
        Object object4 = null;
        arrayList.add(0, object);
        object = object2.iterator();
        while (bl2 = object.hasNext()) {
            long l10;
            object2 = (FilterData)object.next();
            long l11 = ((ResourceData)object2).getResId();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                object4 = TemEditorConfig$FilterType.FILTER_LUT;
                String string2 = ((FilterData)object2).getPath();
                object4 = TemEditorConfig.c((a)object4, string2);
                ((FilterData)object2).setPath((String)object4);
                object4 = ((FilterData)object2).getThumb();
                object3 = TextUtils.isEmpty((CharSequence)object4);
                if (object3 == 0) {
                    object4 = TemEditorConfig$FilterType.FILTER;
                    string2 = ((FilterData)object2).getThumb();
                    object4 = TemEditorConfig.c((a)object4, string2);
                    ((FilterData)object2).setThumb((String)object4);
                }
                object4 = ((FilterData)object2).getPath();
                object4 = this.r(list, (FilterData)object2, (String)object4, true);
                string2 = ((FilterData)object2).getThumb();
                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                if ((bl3 || !(bl3 = s1.r(string2 = ((FilterData)object2).getThumb()))) && (string2 = ((d.v.c.b2.w.a)object4).H()) == null) {
                    object2 = ((FilterData)object2).getHash();
                    this.o((q)object4, (String)object2);
                }
                arrayList.add(object4);
                continue;
            }
            object2 = this.m((FilterData)object2, list2, list);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private q m(FilterData filterData, List object, List list) {
        boolean bl2;
        boolean bl3;
        String string2 = filterData.getHash();
        object = object.iterator();
        Object object2 = null;
        while (bl3 = object.hasNext()) {
            boolean bl4;
            FilterFile filterFile = (FilterFile)object.next();
            String string3 = filterFile.getHash();
            boolean bl5 = TextUtils.isEmpty((CharSequence)string3);
            if (bl5 || (bl5 = TextUtils.isEmpty((CharSequence)string2)) || !(bl4 = TextUtils.equals((CharSequence)string2, (CharSequence)string3))) continue;
            object2 = this.o;
            string3 = filterFile.getPath();
            ((d.v.c.v0.r.a.a)object2).updateFilterPath(string3, string2);
            object2 = filterFile;
        }
        object = object2 == null ? filterData.getPath() : ((FileData)object2).getPath();
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return this.r(list, filterData, (String)object, bl2);
    }

    private void o(q object, String string2) {
        Object object2 = ((d.v.c.b2.w.a)object).I();
        Object object3 = new Object[]{object2};
        m.a.a.b("thumb path = %s", (Object[])object3);
        object2 = ((d.v.c.b2.w.a)object).I();
        this.m = object3 = new FilterThumbUseCase((String)object2);
        object2 = ((q)object).S();
        object3 = ((FilterThumbUseCase)object3).a((String)object2, "");
        this.m.c();
        ((d.v.c.b2.w.a)object).P((Bitmap)object3);
        object = c1.b().d();
        object2 = new l(this, (Bitmap)object3, string2);
        object.execute((Runnable)object2);
    }

    private int p(List list, d.v.h.f.a a10) {
        int n10;
        int n11 = b.f(list);
        if (n11 == 0 && a10 != null && (n11 = a10.f()) != (n10 = -1)) {
            String string2 = a10.i();
            n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            String string3 = "";
            string2 = n11 != 0 ? string3 : a10.i();
            Object object = a10.j();
            int n12 = TextUtils.isEmpty((CharSequence)object);
            if (n12 == 0) {
                string3 = a10.j();
            }
            n12 = list.size();
            object = IntStream.range(0, n12);
            n n13 = new n(a10, string2, list, string3);
            return object.filter(n13).findFirst().orElse(0);
        }
        return 0;
    }

    private q t(Context context) {
        String string2 = d.v.f.i.g.m(context, 2131952052);
        String string3 = m0.f();
        q q10 = new q(0, 0, string2, "", string3, null, false);
        q10.B(true);
        return q10;
    }

    private String y(long l10, List object, String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            return string2;
        }
        string2 = m0.f();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            FilterType filterType = (FilterType)object.next();
            long l11 = filterType.getResId();
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) continue;
            TemEditorConfig$FilterType temEditorConfig$FilterType = TemEditorConfig$FilterType.FILTER;
            String string3 = filterType.getThumb();
            string2 = TemEditorConfig.c(temEditorConfig$FilterType, string3);
            break;
        }
        return string2;
    }

    private String z(FilterData filterData) {
        String string2;
        String string3 = filterData.getLabel_en();
        String string4 = w1.a();
        boolean bl2 = string4.equals(string2 = "zh_CN".toLowerCase());
        if (bl2) {
            string3 = filterData.getLabel();
        } else {
            string2 = "zh_TW".toLowerCase();
            boolean bl3 = string4.equals(string2);
            if (bl3) {
                string3 = filterData.getLabel_tw();
            }
        }
        return string3;
    }

    public d.v.h.f.a F(int n10, q object) {
        Object object2;
        String string2 = ((q)object).S();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            n11 = 0;
            string2 = null;
        } else {
            string2 = ((q)object).S();
            n11 = string2.endsWith((String)(object2 = ".png"));
            n11 = n11 == 0 && (n11 = (int)((string2 = ((q)object).S()).endsWith((String)(object2 = ".mslut")) ? 1 : 0)) == 0 ? 1 : 2;
        }
        object2 = new d.v.h.f.a();
        if (n10 == 0) {
            n10 = -1;
        }
        d.v.h.f.a a10 = ((d.v.h.f.a)object2).u(n10);
        object2 = ((q)object).S();
        a10 = a10.x((String)object2);
        object = ((d.v.c.b2.w.a)object).G();
        return a10.w((String)object).z(n11).y(100);
    }

    public /* synthetic */ void H(Bitmap bitmap, String string2) {
        this.G(bitmap, string2);
    }

    public /* synthetic */ void K(AtomicReference atomicReference, AtomicReference atomicReference2, Context context, AtomicReference atomicReference3, AtomicReference atomicReference4, d.v.j.e.h.k k10) {
        this.J(atomicReference, atomicReference2, context, atomicReference3, atomicReference4, k10);
    }

    public /* synthetic */ void M(AtomicReference atomicReference, AtomicReference atomicReference2, Context context, AtomicReference atomicReference3, AtomicReference atomicReference4, d.v.j.e.h.k k10) {
        this.L(atomicReference, atomicReference2, context, atomicReference3, atomicReference4, k10);
    }

    public /* synthetic */ void P(AtomicReference atomicReference, Context context, AtomicReference atomicReference2, AtomicReference atomicReference3, AtomicReference atomicReference4, List list) {
        this.N(atomicReference, context, atomicReference2, atomicReference3, atomicReference4, list);
    }

    public /* synthetic */ void R(d.v.h.f.a a10, List list) {
        this.Q(a10, list);
    }

    public e S() {
        return (e)this.l.a();
    }

    public void U(e e10) {
        this.l.b(e10);
    }

    public void W(Context object, List object2, List list, List list2, int n10) {
        int n11 = 2;
        if (n10 != n11) {
            object = this.k;
            object2 = null;
            object.setValue(null);
        } else {
            object = this.V((Context)object, (List)object2, list, list2);
            object2 = this.k;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    public void X(d.v.h.f.a a10) {
        MediatorLiveData mediatorLiveData = this.c;
        MediatorLiveData mediatorLiveData2 = this.k;
        d.v.e.i.h.c(mediatorLiveData, mediatorLiveData2);
        mediatorLiveData = this.c;
        mediatorLiveData2 = this.k;
        m m10 = new m(this, a10);
        mediatorLiveData.addSource(mediatorLiveData2, m10);
    }

    public void n(Context context, d.v.c.b2.w.a a10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.FILTER;
        a10.E(editConfig$ResourceType);
        this.b(context, a10);
    }

    public void onCleared() {
        super.onCleared();
        FilterThumbUseCase filterThumbUseCase = this.m;
        if (filterThumbUseCase != null) {
            filterThumbUseCase.c();
        }
    }

    public q r(List object, FilterData filterData, String string2, boolean bl2) {
        Object object2;
        long l10;
        long l11;
        q q10;
        boolean bl3;
        int n10;
        Iterator iterator2 = this.k.getValue();
        if (iterator2 != null && (n10 = (iterator2 = (List)this.k.getValue()).isEmpty()) == 0) {
            iterator2 = ((List)this.k.getValue()).iterator();
            while (bl3 = iterator2.hasNext()) {
                q10 = (q)iterator2.next();
                l11 = q10.getId();
                long l12 = l11 - (l10 = filterData.getResId());
                object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false) continue;
                break;
            }
        } else {
            bl3 = false;
            q10 = null;
        }
        n10 = 0;
        iterator2 = null;
        if (q10 == null) {
            boolean bl4;
            l11 = filterData.getResId();
            int n11 = (int)l11;
            l10 = filterData.getTypeId();
            int n12 = (int)l10;
            String string3 = this.z(filterData);
            long l13 = filterData.getTypeId();
            Object object3 = filterData.getThumb();
            String string4 = this.y(l13, (List)object, (String)object3);
            object2 = filterData.getRequiredPrime();
            boolean bl5 = object2 == (bl4 = true) ? bl4 : false;
            object3 = q10;
            q10 = new q(n11, n12, string3, string2, string4, null, bl5);
            object3 = filterData.getLicenseName();
            q10.L((String)object3);
            object3 = filterData.getLicensePath();
            q10.M((String)object3);
        }
        q10.W(string2);
        long l14 = filterData.getTypeId();
        object = this.A(l14, (List)object);
        if (object != null) {
            n10 = ((ResourceData)object).getSort();
        }
        q10.Y(n10);
        q10.B(bl2);
        object = EditConfig$ResourceType.FILTER;
        q10.E((EditConfig$ResourceType)object);
        return q10;
    }

    public q s(int n10) {
        Object object = this.k.getValue();
        if (object == null) {
            return null;
        }
        object = (List)this.k.getValue();
        int n11 = object.size();
        if (n10 >= n11) {
            return null;
        }
        return (q)((List)this.k.getValue()).get(n10);
    }

    public void u(Context context) {
        Observer observer;
        AtomicReference atomicReference = this.k;
        Object object = this.h;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)object);
        atomicReference = this.k;
        object = this.i;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)object);
        atomicReference = this.k;
        object = this.j;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)object);
        atomicReference = this.n.c();
        this.h = atomicReference;
        atomicReference = this.o;
        int n10 = 1;
        atomicReference = ((d.v.c.v0.r.a.a)((Object)atomicReference)).a(n10 != 0, n10, 1000);
        this.i = atomicReference;
        atomicReference = this.o.m();
        this.j = atomicReference;
        atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicReference atomicReference3 = new AtomicReference();
        object = 0;
        AtomicReference<Object> atomicReference4 = new AtomicReference<Object>(object);
        MediatorLiveData mediatorLiveData = this.k;
        LiveData liveData = this.h;
        object = observer;
        observer = new p(this, atomicReference4, atomicReference, context, atomicReference2, atomicReference3);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.k;
        liveData = this.i;
        object = observer;
        observer = new o(this, atomicReference4, atomicReference2, context, atomicReference, atomicReference3);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.k;
        liveData = this.j;
        object = observer;
        observer = new k(this, atomicReference3, context, atomicReference, atomicReference2, atomicReference4);
        mediatorLiveData.addSource(liveData, observer);
    }

    public List v() {
        List list = this.k.getValue();
        list = list == null ? Collections.emptyList() : (List)this.k.getValue();
        return list;
    }

    public MediatorLiveData w() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.k);
    }

    public MutableLiveData x() {
        return this.g;
    }
}

