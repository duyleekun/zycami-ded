/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.v1;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.transition.TransitionData;
import com.zhiyun.cama.data.database.model.transition.TransitionFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.m0;
import d.v.c.v1.i;
import d.v.c.v1.j;
import d.v.c.v1.k;
import d.v.c.v1.l;
import d.v.c.x1.p.c;
import d.v.e.i.h;
import d.v.e.j.a;
import d.v.h.k.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class o
extends d.v.c.b2.v.b {
    private MutableLiveData g;
    private MutableLiveData h;
    private LiveData i;
    private LiveData j;
    private MediatorLiveData k;
    private c l;
    private d.v.c.v0.z.b m;

    public o() {
        Integer n10 = 1;
        Object object = new MutableLiveData(n10);
        this.g = object;
        object = new MutableLiveData();
        this.h = object;
        object = new MutableLiveData();
        this.i = object;
        object = new MutableLiveData();
        this.j = object;
        this.k = object;
        this.l = object = new c();
        this.m = object = d.v.c.v0.z.b.u();
    }

    private /* synthetic */ void G(b object, List object2) {
        boolean bl2 = d.v.j.b.f((List)object2);
        if (bl2) {
            return;
        }
        int n10 = this.p((b)object, (List)object2);
        object2 = this.c;
        object = n10;
        d.v.e.i.h.g((MutableLiveData)object2, object);
    }

    private /* synthetic */ void I(AtomicBoolean atomicBoolean, AtomicReference object, AtomicReference object2, d.v.j.e.h.k object3) {
        Status status = ((d.v.j.e.h.k)object3).a;
        Status status2 = Status.LOADING;
        if (status == status2) {
            return;
        }
        atomicBoolean.set(true);
        object3 = ((d.v.j.e.h.k)object3).c;
        ((AtomicReference)object).set(object3);
        object = (List)((AtomicReference)object).get();
        object2 = (List)((AtomicReference)object2).get();
        boolean bl2 = atomicBoolean.get();
        this.Q((List)object, (List)object2, bl2);
    }

    private /* synthetic */ void K(AtomicReference object, AtomicReference object2, AtomicBoolean atomicBoolean, List list) {
        ((AtomicReference)object).set(list);
        object2 = (List)((AtomicReference)object2).get();
        object = (List)((AtomicReference)object).get();
        boolean bl2 = atomicBoolean.get();
        this.Q((List)object2, (List)object, bl2);
    }

    private List P(List iterator2, List list) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl2;
        boolean bl3 = d.v.j.b.f((List)((Object)iterator2));
        if (bl3) {
            return Collections.emptyList();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object5 = new ArrayList();
        iterator2 = iterator2.iterator();
        while (true) {
            long l10;
            boolean bl4 = iterator2.hasNext();
            bl2 = true;
            if (!bl4) break;
            object4 = (TransitionData)iterator2.next();
            long l11 = ((ResourceData)object4).getResId();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                object3 = ((TransitionData)object4).getTransitionType();
                if (object3 != bl2) {
                    object2 = EditConfig$ResourceType.TRANSITION;
                    object = ((TransitionData)object4).getPath();
                    object2 = TemEditorConfig.c((a)object2, (String)object);
                    ((TransitionData)object4).setPath((String)object2);
                }
                object2 = EditConfig$ResourceType.TRANSITION;
                object = ((TransitionData)object4).getThumb();
                object = TemEditorConfig.c((a)object2, (String)object);
                ((TransitionData)object4).setThumb((String)object);
                object = ((TransitionData)object4).getLittleThumb();
                object2 = TemEditorConfig.c((a)object2, (String)object);
                ((TransitionData)object4).setLittleThumb((String)object2);
                object2 = ((TransitionData)object4).getPath();
                object4 = this.s((TransitionData)object4, (String)object2, bl2);
                arrayList.add(object4);
                continue;
            }
            object5.add(object4);
        }
        boolean bl5 = object5.isEmpty();
        if (!bl5) {
            boolean bl6;
            iterator2 = object5.iterator();
            while (bl6 = iterator2.hasNext()) {
                boolean bl7;
                object5 = (TransitionData)iterator2.next();
                object4 = ((TransitionData)object5).getHash();
                object3 = 0;
                object2 = null;
                object = list.iterator();
                while (bl7 = object.hasNext()) {
                    TransitionFile transitionFile = (TransitionFile)object.next();
                    String string2 = transitionFile.getHash();
                    boolean bl8 = TextUtils.isEmpty((CharSequence)object4);
                    if (bl8 || (bl8 = TextUtils.isEmpty((CharSequence)string2)) || !(bl8 = TextUtils.equals((CharSequence)object4, (CharSequence)string2))) continue;
                    object2 = this.m;
                    String string3 = transitionFile.getPath();
                    ((d.v.c.v0.z.b)object2).updateTransitionPath(string3, string2);
                    object2 = transitionFile;
                }
                object4 = object2 == null ? ((TransitionData)object5).getPath() : ((FileData)object2).getPath();
                if (object2 != null) {
                    object3 = bl2;
                } else {
                    object3 = 0;
                    object2 = null;
                }
                object4 = this.s((TransitionData)object5, (String)object4, (boolean)object3);
                object2 = ((TransitionData)object5).getLicenseName();
                ((d.v.c.b2.w.a)object4).L((String)object2);
                object5 = ((TransitionData)object5).getLicensePath();
                ((d.v.c.b2.w.a)object4).M((String)object5);
                arrayList.add(object4);
            }
        }
        return arrayList;
    }

    private void Q(List object, List object2, boolean bl2) {
        if (!bl2) {
            object = this.k;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
        } else {
            object = this.P((List)object, (List)object2);
            object2 = this.k;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    private int p(b b10, List list) {
        int n10 = b10.e();
        int n11 = 0;
        if (n10 != 0) {
            int n12;
            for (n10 = 0; n10 < (n12 = list.size()); ++n10) {
                String string2;
                int n13;
                Object object = (l)list.get(n10);
                int n14 = b10.e();
                if (!(n14 == (n13 = 1) ? (n12 = (int)((string2 = b10.b()).equals(object = ((l)object).R()) ? 1 : 0)) != 0 : (n14 = b10.e()) == (n13 = 2) && (n12 = (int)((string2 = b10.c()).equals(object = ((l)object).S()) ? 1 : 0)) != 0)) continue;
                n11 = n10;
                break;
            }
        }
        return n11;
    }

    private l s(TransitionData object, String string2, boolean bl2) {
        l l10;
        int n10;
        int n11;
        int n12 = ((TransitionData)object).getTransitionType();
        long l11 = ((ResourceData)object).getResId();
        int n13 = (int)l11;
        int n14 = ((TransitionData)object).getTransitionType();
        String string3 = ((TransitionData)object).getThumb();
        String string4 = ((TransitionData)object).getLittleThumb();
        String string5 = ((ResourceData)object).showLabel();
        Object object2 = "";
        int n15 = 1;
        Object object3 = n12 == n15 ? string2 : object2;
        if (n12 == n15) {
            string2 = object2;
        }
        if ((n11 = ((TransitionData)object).getRequiredPrime()) == n15) {
            n10 = n15;
        } else {
            n11 = 0;
            object = null;
            n10 = 0;
        }
        object2 = l10;
        String string6 = object3;
        object3 = string2;
        l10 = new l(n13, n14, string3, string4, string5, string6, string2, n10 != 0);
        l10.B(bl2);
        object = EditConfig$ResourceType.STICKER;
        l10.E((EditConfig$ResourceType)object);
        return l10;
    }

    private int x(long l10) {
        long l11;
        long l12;
        long l13;
        long[] lArray = m0.h;
        int n10 = lArray.length;
        int n11 = -1;
        for (int i10 = 0; i10 < n10 && (l13 = (l12 = l10 - (l11 = lArray[i10])) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0; ++i10) {
            ++n11;
        }
        return n11;
    }

    public void A() {
        AtomicReference atomicReference = this.k;
        AtomicReference atomicReference2 = this.i;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.k;
        atomicReference2 = this.j;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.m;
        int n10 = 1;
        atomicReference = ((d.v.c.v0.z.b)((Object)atomicReference)).a(n10 != 0, n10, 1000);
        this.i = atomicReference;
        atomicReference = this.m.f();
        this.j = atomicReference;
        atomicReference = new AtomicReference();
        atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MediatorLiveData mediatorLiveData = this.k;
        LiveData liveData = this.i;
        Observer observer = new k(this, atomicBoolean, atomicReference, atomicReference2);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.k;
        liveData = this.j;
        observer = new i(this, atomicReference2, atomicReference, atomicBoolean);
        mediatorLiveData.addSource(liveData, observer);
    }

    public MediatorLiveData F() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.k);
    }

    public /* synthetic */ void H(b b10, List list) {
        this.G(b10, list);
    }

    public /* synthetic */ void J(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2, d.v.j.e.h.k k10) {
        this.I(atomicBoolean, atomicReference, atomicReference2, k10);
    }

    public /* synthetic */ void L(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, List list) {
        this.K(atomicReference, atomicReference2, atomicBoolean, list);
    }

    public b M() {
        return (b)this.l.a();
    }

    public void N(b b10) {
        this.l.b(b10);
    }

    public b m(l object) {
        if (object == null) {
            return null;
        }
        b b10 = new b();
        Object object2 = m0.h;
        int n10 = this.z();
        long l10 = object2[n10];
        b10 = b10.f(l10);
        object2 = ((l)object).R();
        b10 = b10.g((String)object2);
        int n11 = ((l)object).U();
        b10 = b10.j(n11);
        object2 = ((l)object).S();
        b10 = b10.h((String)object2);
        object = ((l)object).T();
        return b10.i((String)object);
    }

    public void n(Context context, d.v.c.b2.w.a a10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.TRANSITION;
        a10.E(editConfig$ResourceType);
        this.b(context, a10);
    }

    public void o(int n10) {
        MutableLiveData mutableLiveData = this.g;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public void r(b object) {
        MutableLiveData mutableLiveData = this.c;
        MediatorLiveData mediatorLiveData = this.k;
        d.v.e.i.h.c(mutableLiveData, mediatorLiveData);
        mutableLiveData = this.c;
        mediatorLiveData = this.k;
        j j10 = new j(this, (b)object);
        mutableLiveData.addSource(mediatorLiveData, j10);
        long l10 = ((b)object).a();
        int n10 = this.t(l10);
        int n11 = -1;
        if (n10 != n11) {
            mutableLiveData = this.g;
            object = n10;
            d.v.e.i.h.g(mutableLiveData, object);
        }
    }

    public int t(long l10) {
        int n10;
        block2: {
            long[] lArray;
            int n11;
            for (n10 = 0; n10 < (n11 = (lArray = m0.h).length); ++n10) {
                long l11 = lArray[n10];
                double d10 = l11;
                double d11 = l10;
                int n12 = Double.compare(d10, d11);
                if (n12 != 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public l u(int n10) {
        Object object = this.k.getValue();
        if (object == null) {
            return null;
        }
        object = (List)this.k.getValue();
        int n11 = object.size();
        if (n10 >= n11) {
            return null;
        }
        return (l)((List)this.k.getValue()).get(n10);
    }

    public MutableLiveData v() {
        return this.h;
    }

    public void w(int n10) {
        long l10 = d.v.v.q.h.T(n10);
        n10 = this.x(l10);
        MutableLiveData mutableLiveData = this.h;
        Integer n11 = n10;
        d.v.e.i.h.g(mutableLiveData, n11);
    }

    public MutableLiveData y() {
        return this.g;
    }

    public int z() {
        int n10;
        Object object = this.g.getValue();
        if (object == null) {
            n10 = 1;
        } else {
            object = (Integer)this.g.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }
}

