/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.x0.c.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.font.FontData;
import com.zhiyun.cama.data.database.model.font.FontFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.q.c;
import d.v.c.x0.c.d.g;
import d.v.c.x0.c.d.h;
import d.v.c.x0.c.d.i;
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
    private final d.v.c.v0.s.b.a g;
    private LiveData h;
    private LiveData i;
    private final MediatorLiveData j;

    public l() {
        Object object = new MediatorLiveData();
        this.j = object;
        this.g = object = d.v.c.v0.s.b.a.u();
    }

    private i o(FontData object, String string2, boolean bl2) {
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
        String string5 = ((FontData)object).getThumb();
        boolean bl6 = ((FontData)object).getRequiredPrime();
        boolean bl5 = true;
        if (bl6 == bl5) {
            bl3 = bl5;
        } else {
            boolean bl7 = false;
            object = null;
            bl3 = false;
        }
        object3 = object2;
        object2 = new i(l10, string4, string2, string5, bl3);
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
            object = this.j;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
        } else {
            object = this.y((List)object, (List)object2);
            object2 = this.j;
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
            object4 = (FontData)iterator2.next();
            long l11 = ((ResourceData)object4).getResId();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                object2 = EditConfig$ResourceType.FONT;
                object = ((FontData)object4).getPath();
                object = TemEditorConfig.c((a)object2, (String)object);
                ((FontData)object4).setPath((String)object);
                object = ((FontData)object4).getThumb();
                object2 = TemEditorConfig.c((a)object2, (String)object);
                ((FontData)object4).setThumb((String)object2);
                object2 = ((FontData)object4).getPath();
                object4 = this.o((FontData)object4, (String)object2, bl2);
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
                object5 = (FontData)iterator2.next();
                object4 = ((FontData)object5).getHash();
                object3 = 0;
                object2 = null;
                boolean bl7 = b.f(list);
                if (!bl7) {
                    boolean bl8;
                    object = list.iterator();
                    while (bl8 = object.hasNext()) {
                        boolean bl9;
                        FontFile fontFile = (FontFile)object.next();
                        String string2 = fontFile.getHash();
                        boolean bl10 = TextUtils.isEmpty((CharSequence)string2);
                        if (bl10 || (bl10 = TextUtils.isEmpty((CharSequence)object4)) || !(bl9 = ((String)object4).equals(string2))) continue;
                        object2 = ((FontData)object5).getPath();
                        object3 = ((String)object2).equals(string2 = fontFile.getPath());
                        if (object3 == false) {
                            object2 = this.g;
                            string2 = fontFile.getPath();
                            ((d.v.c.v0.s.b.a)object2).updateFontPath(string2, (String)object4);
                        }
                        object2 = fontFile;
                    }
                }
                object4 = object2 == null ? ((FontData)object5).getPath() : ((FileData)object2).getPath();
                if (object2 != null) {
                    object3 = bl2;
                } else {
                    object3 = 0;
                    object2 = null;
                }
                object5 = this.o((FontData)object5, (String)object4, (boolean)object3);
                arrayList.add(object5);
            }
        }
        return arrayList;
    }

    public boolean m(d object, i i10) {
        if (i10 != null && object != null) {
            String string2 = ((d)object).v();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            String string3 = "";
            object = !bl2 ? ((d)object).v() : string3;
            string2 = i10.R();
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                string3 = i10.R();
            }
            return ((String)object).equals(string3);
        }
        return false;
    }

    public void n(Context context, d.v.c.b2.w.a a10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.FONT;
        a10.E(editConfig$ResourceType);
        this.b(context, a10);
    }

    public i p(int n10) {
        Object object = this.j.getValue();
        if (object == null) {
            return null;
        }
        object = (List)this.j.getValue();
        int n11 = object.size();
        if (n10 >= n11) {
            return null;
        }
        return (i)((List)this.j.getValue()).get(n10);
    }

    public MediatorLiveData r() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.j);
    }

    public void s() {
        AtomicReference atomicReference = this.j;
        AtomicReference atomicReference2 = this.h;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.j;
        atomicReference2 = this.i;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.g;
        int n10 = 1;
        atomicReference = ((d.v.c.v0.s.b.a)((Object)atomicReference)).a(n10 != 0, n10, 1000);
        this.i = atomicReference;
        atomicReference = this.g.n();
        this.h = atomicReference;
        atomicReference = new AtomicReference();
        atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MediatorLiveData mediatorLiveData = this.j;
        LiveData liveData = this.i;
        Observer observer = new h(this, atomicBoolean, atomicReference, atomicReference2);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.j;
        liveData = this.h;
        observer = new g(this, atomicReference2, atomicReference, atomicBoolean);
        mediatorLiveData.addSource(liveData, observer);
    }

    public /* synthetic */ void u(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2, k k10) {
        this.t(atomicBoolean, atomicReference, atomicReference2, k10);
    }

    public /* synthetic */ void w(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, List list) {
        this.v(atomicReference, atomicReference2, atomicBoolean, list);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void z(d object) {
        Integer n10;
        int n11;
        block4: {
            n11 = 0;
            n10 = null;
            if (object != null) {
                Object object2 = ((d)object).v();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                object = !bl2 ? ((d)object).v() : "";
                object2 = (List)this.j.getValue();
                if (object2 != null) {
                    int n12;
                    for (int i10 = 0; i10 < (n12 = object2.size()); ++i10) {
                        String string2;
                        n12 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                        if (n12 == 0 || (n12 = (int)(TextUtils.isEmpty((CharSequence)(string2 = ((i)object2.get(0)).R())) ? 1 : 0)) == 0) {
                            string2 = ((i)object2.get(i10)).R();
                            n12 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n12 == 0) continue;
                            n11 = i10;
                        }
                        break block4;
                    }
                }
            }
            n11 = -1;
        }
        object = this.c;
        n10 = n11;
        d.v.e.i.h.g((MutableLiveData)object, n10);
    }
}

