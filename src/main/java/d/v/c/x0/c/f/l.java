/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.x0.c.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.font.CaptionStyleData;
import com.zhiyun.cama.data.database.model.font.CaptionStyleFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.q.c;
import d.v.c.x0.c.f.g;
import d.v.c.x0.c.f.h;
import d.v.c.x0.c.f.j;
import d.v.e.j.a;
import d.v.e.l.w1;
import d.v.h.d.d;
import d.v.j.b;
import d.v.j.e.h.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class l
extends d.v.c.b2.v.b {
    private final d.v.c.v0.s.a.a g;
    private final MediatorLiveData h;
    private LiveData i;
    private LiveData j;

    public l() {
        Object object = new MediatorLiveData();
        this.h = object;
        this.g = object = d.v.c.v0.s.a.a.u();
    }

    private j o(CaptionStyleData object, String string2, boolean bl2) {
        boolean bl3;
        Object object2 = w1.a();
        String string3 = ((ResourceData)object).getLabel_en();
        Object object3 = "zh_CN".toLowerCase();
        boolean bl4 = ((String)object2).equals(object3);
        if (bl4) {
            string3 = ((ResourceData)object).getLabel();
        } else {
            object3 = "zh_TW".toLowerCase();
            boolean bl5 = ((String)object2).equals(object3);
            if (bl5) {
                string3 = ((ResourceData)object).getLabel_tw();
            }
        }
        String string4 = string3;
        long l10 = ((ResourceData)object).getResId();
        String string5 = ((CaptionStyleData)object).getThumb();
        boolean bl6 = ((CaptionStyleData)object).getRequiredPrime();
        boolean bl5 = true;
        if (bl6 == bl5) {
            bl3 = bl5;
        } else {
            boolean bl7 = false;
            object = null;
            bl3 = false;
        }
        object3 = object2;
        object2 = new j(l10, string4, string2, string5, bl3);
        ((c)object2).B(bl2);
        object = EditConfig$ResourceType.FONT;
        ((c)object2).E((EditConfig$ResourceType)object);
        return object2;
    }

    private /* synthetic */ void t(AtomicBoolean atomicBoolean, AtomicReference object, AtomicReference object2, k object3) {
        Status status = ((k)object3).a;
        Status status2 = Status.LOADING;
        if (status == status2) {
            return;
        }
        atomicBoolean.set(true);
        object3 = ((k)object3).c;
        ((AtomicReference)object).set(object3);
        object = (List)((AtomicReference)object).get();
        object2 = (List)((AtomicReference)object2).get();
        boolean bl2 = atomicBoolean.get();
        this.x((List)object, (List)object2, bl2);
    }

    private /* synthetic */ void v(AtomicReference object, AtomicReference object2, AtomicBoolean atomicBoolean, List list) {
        ((AtomicReference)object).set(list);
        object2 = (List)((AtomicReference)object2).get();
        object = (List)((AtomicReference)object).get();
        boolean bl2 = atomicBoolean.get();
        this.x((List)object2, (List)object, bl2);
    }

    private void x(List object, List object2, boolean bl2) {
        if (!bl2) {
            object = this.h;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
        } else {
            object = this.y((List)object, (List)object2);
            object2 = this.h;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    private List y(List iterator2, List list) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl2;
        boolean bl3 = b.f((List)((Object)iterator2));
        if (bl3) {
            return Collections.emptyList();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object5 = new ArrayList();
        object5.clear();
        iterator2 = iterator2.iterator();
        while (true) {
            long l10;
            boolean bl4 = iterator2.hasNext();
            bl2 = true;
            if (!bl4) break;
            object4 = (CaptionStyleData)iterator2.next();
            long l11 = ((ResourceData)object4).getResId();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                object2 = EditConfig$ResourceType.CAPTION;
                object = ((CaptionStyleData)object4).getPath();
                object = TemEditorConfig.c((a)object2, (String)object);
                ((CaptionStyleData)object4).setPath((String)object);
                object = ((CaptionStyleData)object4).getThumb();
                object2 = TemEditorConfig.c((a)object2, (String)object);
                ((CaptionStyleData)object4).setThumb((String)object2);
                object2 = ((CaptionStyleData)object4).getPath();
                object4 = this.o((CaptionStyleData)object4, (String)object2, bl2);
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
                object5 = (CaptionStyleData)iterator2.next();
                object4 = ((CaptionStyleData)object5).getHash();
                object3 = 0;
                object2 = null;
                boolean bl7 = b.f(list);
                if (!bl7) {
                    boolean bl8;
                    object = list.iterator();
                    while (bl8 = object.hasNext()) {
                        String string2;
                        CaptionStyleFile captionStyleFile = (CaptionStyleFile)object.next();
                        String string3 = captionStyleFile.getHash();
                        boolean bl9 = TextUtils.isEmpty((CharSequence)string3);
                        if (bl9 || (bl9 = TextUtils.isEmpty((CharSequence)object4)) || !(bl9 = ((String)object4).equals(string3))) continue;
                        object2 = ((CaptionStyleData)object5).getPath();
                        object3 = ((String)object2).equals(string2 = captionStyleFile.getPath());
                        if (object3 == false) {
                            object2 = this.g;
                            string2 = captionStyleFile.getPath();
                            ((d.v.c.v0.s.a.a)object2).updateCaptionPath(string2, string3);
                        }
                        object2 = captionStyleFile;
                    }
                }
                object4 = object2 == null ? ((CaptionStyleData)object5).getPath() : ((FileData)object2).getPath();
                if (object2 != null) {
                    object3 = bl2;
                } else {
                    object3 = 0;
                    object2 = null;
                }
                object4 = this.o((CaptionStyleData)object5, (String)object4, (boolean)object3);
                object2 = ((CaptionStyleData)object5).getLicenseName();
                ((d.v.c.b2.w.a)object4).L((String)object2);
                object5 = ((CaptionStyleData)object5).getLicensePath();
                ((d.v.c.b2.w.a)object4).M((String)object5);
                arrayList.add(object4);
            }
        }
        return arrayList;
    }

    public boolean m(d object, j j10) {
        Object object2;
        if (j10 != null && object != null && (object2 = ((d)object).t()) != null) {
            object2 = ((d)object).t().b();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            String string2 = "";
            object = !bl2 ? ((d)object).t().b() : string2;
            object2 = j10.R();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                string2 = j10.R();
            }
            return ((String)object).equals(string2);
        }
        return false;
    }

    public void n(Context context, d.v.c.b2.w.a a10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.CAPTION;
        a10.E(editConfig$ResourceType);
        this.b(context, a10);
    }

    public void p() {
        AtomicReference atomicReference = this.h;
        AtomicReference atomicReference2 = this.i;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.h;
        atomicReference2 = this.j;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.g;
        int n10 = 1;
        atomicReference = ((d.v.c.v0.s.a.a)((Object)atomicReference)).a(n10 != 0, n10, 1000);
        this.i = atomicReference;
        atomicReference = this.g.o();
        this.j = atomicReference;
        atomicReference = new AtomicReference();
        atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MediatorLiveData mediatorLiveData = this.h;
        LiveData liveData = this.i;
        Observer observer = new g(this, atomicBoolean, atomicReference, atomicReference2);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.h;
        liveData = this.j;
        observer = new h(this, atomicReference2, atomicReference, atomicBoolean);
        mediatorLiveData.addSource(liveData, observer);
    }

    public j r(int n10) {
        Object object = this.h.getValue();
        if (object == null) {
            return null;
        }
        object = (List)this.h.getValue();
        int n11 = object.size();
        if (n10 >= n11) {
            return null;
        }
        return (j)((List)this.h.getValue()).get(n10);
    }

    public MediatorLiveData s() {
        return this.h;
    }

    public /* synthetic */ void u(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2, k k10) {
        this.t(atomicBoolean, atomicReference, atomicReference2, k10);
    }

    public /* synthetic */ void w(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, List list) {
        this.v(atomicReference, atomicReference2, atomicBoolean, list);
    }

    public void z(d object) {
        int n10 = 0;
        Integer n11 = null;
        if (object != null) {
            boolean bl2;
            Object object2 = ((d)object).t();
            object = object2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((d)object).t().b()))) ? ((d)object).t().b() : "";
            object2 = (List)this.h.getValue();
            if (object2 != null) {
                String string2;
                int n12;
                for (int i10 = 0; i10 < (n12 = object2.size()) && ((n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0 || (n12 = (int)(TextUtils.isEmpty((CharSequence)(string2 = ((j)object2.get(0)).R())) ? 1 : 0)) == 0); ++i10) {
                    string2 = ((j)object2.get(i10)).R();
                    n12 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n12 == 0) continue;
                    n10 = i10;
                    break;
                }
            }
        }
        object = this.c;
        n11 = n10;
        d.v.e.i.h.g((MutableLiveData)object, n11);
    }
}

