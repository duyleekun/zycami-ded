/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.c.x0.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.data.database.model.ResourceData;
import com.zhiyun.cama.data.database.model.sticker.StickerData;
import com.zhiyun.cama.data.database.model.sticker.StickerFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.y.a.b;
import d.v.c.x0.b.k;
import d.v.c.x0.b.l;
import d.v.c.x0.b.m;
import d.v.c.x0.b.o;
import d.v.e.i.h;
import d.v.e.j.a;
import d.v.h.d.c;
import d.v.j.g.b0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class q
extends d.v.c.b2.v.b {
    private LiveData g;
    private LiveData h;
    private final MediatorLiveData i;
    private final b j;

    public q() {
        Object object = new MediatorLiveData();
        this.i = object;
        this.j = object = b.v();
    }

    private /* synthetic */ void F(AtomicReference object, AtomicReference object2, AtomicBoolean atomicBoolean, List list) {
        ((AtomicReference)object).set(list);
        object2 = (List)((AtomicReference)object2).get();
        object = (List)((AtomicReference)object).get();
        boolean bl2 = atomicBoolean.get();
        this.I((List)object2, (List)object, bl2);
    }

    private void I(List object, List object2, boolean bl2) {
        if (!bl2) {
            object = this.i;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
        } else {
            object = this.J((List)object, (List)object2);
            object2 = this.i;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    private List J(List iterator2, List list) {
        int n10;
        if (iterator2 != null && (n10 = iterator2.size()) != 0) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            boolean bl2;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object5 = new ArrayList();
            iterator2 = iterator2.iterator();
            while (true) {
                long l10;
                boolean bl3 = iterator2.hasNext();
                bl2 = true;
                if (!bl3) break;
                object4 = (StickerData)iterator2.next();
                long l11 = ((ResourceData)object4).getResId();
                long l12 = l11 - (l10 = 0L);
                object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 < 0) {
                    object2 = EditConfig$ResourceType.STICKER;
                    object = ((StickerData)object4).getPath();
                    object = TemEditorConfig.c((a)object2, (String)object);
                    ((StickerData)object4).setPath((String)object);
                    object = ((StickerData)object4).getThumb();
                    object = TemEditorConfig.c((a)object2, (String)object);
                    ((StickerData)object4).setThumb((String)object);
                    object = ((StickerData)object4).getLittleThumb();
                    object2 = TemEditorConfig.c((a)object2, (String)object);
                    ((StickerData)object4).setLittleThumb((String)object2);
                    object2 = ((StickerData)object4).getPath();
                    object4 = this.s((StickerData)object4, (String)object2, bl2);
                    arrayList.add(object4);
                    continue;
                }
                object5.add(object4);
            }
            boolean bl4 = object5.isEmpty();
            if (!bl4) {
                boolean bl5;
                iterator2 = object5.iterator();
                while (bl5 = iterator2.hasNext()) {
                    object5 = (StickerData)iterator2.next();
                    object4 = ((StickerData)object5).getHash();
                    object3 = 0;
                    object2 = null;
                    boolean bl6 = d.v.j.b.f(list);
                    if (!bl6) {
                        boolean bl7;
                        object = list.iterator();
                        while (bl7 = object.hasNext()) {
                            boolean bl8;
                            StickerFile stickerFile = (StickerFile)object.next();
                            Object object6 = stickerFile.getHash();
                            boolean bl9 = TextUtils.isEmpty((CharSequence)object4);
                            if (bl9 || (bl9 = TextUtils.isEmpty((CharSequence)object6)) || !(bl8 = TextUtils.equals((CharSequence)object4, (CharSequence)object6))) continue;
                            object2 = stickerFile.getPath();
                            object6 = ((StickerData)object5).getPath();
                            bl8 = ((String)object6).equals(object2);
                            if (!bl8) {
                                object6 = this.j;
                                ((b)object6).updateStickerPath((String)object2, (String)object4);
                            }
                            object2 = stickerFile;
                        }
                    }
                    object4 = object2 == null ? ((StickerData)object5).getPath() : ((FileData)object2).getPath();
                    if (object2 != null) {
                        object3 = bl2;
                    } else {
                        object3 = 0;
                        object2 = null;
                    }
                    object5 = this.s((StickerData)object5, (String)object4, (boolean)object3);
                    arrayList.add(object5);
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private o s(StickerData object, String string2, boolean bl2) {
        int n10;
        o o10;
        int n11;
        int n12;
        Iterator iterator2 = this.i.getValue();
        o o11 = null;
        if (iterator2 != null && (n12 = (iterator2 = (List)this.i.getValue()).isEmpty()) == 0) {
            iterator2 = ((List)this.i.getValue()).iterator();
            while (n11 = iterator2.hasNext()) {
                long l10;
                o10 = (o)iterator2.next();
                long l11 = o10.getId();
                long l12 = l11 - (l10 = ((ResourceData)object).getResId());
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 != 0) continue;
                o10.Z(string2);
                o11 = o10;
            }
        }
        if (o11 == null) {
            int n13;
            long l13 = ((ResourceData)object).getResId();
            n10 = (int)l13;
            long l14 = ((StickerData)object).getTypeId();
            String string3 = ((StickerData)object).getName();
            String string4 = ((StickerData)object).getThumb();
            float f10 = ((StickerData)object).getScale();
            String string5 = ((StickerData)object).getLittleThumb();
            n12 = ((StickerData)object).getRequiredPrime();
            if (n12 == (n11 = 1)) {
                n13 = n11;
            } else {
                n12 = 0;
                iterator2 = null;
                n13 = 0;
            }
            o10 = o11;
            o11 = new o(n10, l14, string3, string2, string4, f10, string5, n13 != 0);
        }
        string2 = ((StickerData)object).getLicenseName();
        o11.L(string2);
        object = ((StickerData)object).getLicensePath();
        o11.M((String)object);
        object = o11.U();
        object = this.w((String)object);
        o11.W((DecorationType)((Object)object));
        o11.B(bl2);
        object = EditConfig$ResourceType.STICKER;
        o11.E((EditConfig$ResourceType)object);
        return o11;
    }

    private DecorationType w(String object) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            object = "";
        }
        object = (bl2 = b0.t(object)) ? DecorationType.GIF_PASTER : DecorationType.IMAGE_PASTER;
        return object;
    }

    private /* synthetic */ void x(c object, List object2) {
        int n10 = d.v.j.b.f((List)object2);
        if (n10 == 0 && object != null) {
            int n11;
            n10 = -1;
            for (int i10 = 0; i10 < (n11 = object2.size()); ++i10) {
                String string2;
                String string3 = ((c)object).x();
                n11 = (int)(string3.equals(string2 = ((o)object2.get(i10)).U()) ? 1 : 0);
                if (n11 == 0) continue;
                n10 = i10;
                break;
            }
            object = this.c;
            object2 = n10;
            d.v.e.i.h.g((MutableLiveData)object, object2);
        }
    }

    private /* synthetic */ void z(AtomicBoolean atomicBoolean, AtomicReference object, AtomicReference object2, d.v.j.e.h.k object3) {
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
        this.I((List)object, (List)object2, bl2);
    }

    public /* synthetic */ void A(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2, d.v.j.e.h.k k10) {
        this.z(atomicBoolean, atomicReference, atomicReference2, k10);
    }

    public /* synthetic */ void G(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, List list) {
        this.F(atomicReference, atomicReference2, atomicBoolean, list);
    }

    public void H(int n10) {
        MediatorLiveData mediatorLiveData = this.c;
        Integer n11 = n10;
        d.v.e.i.h.g(mediatorLiveData, n11);
    }

    public MediatorLiveData g() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.c);
    }

    public boolean m(c object, o object2) {
        if (object2 != null && object != null) {
            object = ((c)object).x();
            object2 = ((o)object2).U();
            return ((String)object).equals(object2);
        }
        return false;
    }

    public boolean n(c object, c object2, List list) {
        if (object2 != null) {
            return true;
        }
        int n10 = -1;
        if (object != null) {
            int n11;
            for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
                String string2;
                String string3 = ((c)object).x();
                n11 = (int)(string3.equals(string2 = ((o)list.get(i10)).U()) ? 1 : 0);
                if (n11 == 0) continue;
                n10 = i10;
                break;
            }
        }
        object = this.d();
        object2 = n10;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        return false;
    }

    public void o(Context context, d.v.c.b2.w.a a10) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.STICKER;
        a10.E(editConfig$ResourceType);
        this.b(context, a10);
    }

    public int p(c c10, List list) {
        int n10;
        if (c10 != null) {
            int n11;
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                String string2;
                String string3 = c10.x();
                n11 = (int)(string3.equals(string2 = ((o)list.get(n10)).U()) ? 1 : 0);
                if (n11 == 0) {
                    continue;
                }
                break;
            }
        } else {
            n10 = -1;
        }
        return n10;
    }

    public void r(c c10) {
        MediatorLiveData mediatorLiveData = this.c;
        MediatorLiveData mediatorLiveData2 = this.i;
        d.v.e.i.h.c(mediatorLiveData, mediatorLiveData2);
        mediatorLiveData = this.c;
        mediatorLiveData2 = this.i;
        m m10 = new m(this, c10);
        mediatorLiveData.addSource(mediatorLiveData2, m10);
    }

    public o t(int n10) {
        Object object = this.i.getValue();
        if (object == null) {
            return null;
        }
        object = (List)this.i.getValue();
        int n11 = object.size();
        if (n10 >= n11) {
            return null;
        }
        return (o)((List)this.i.getValue()).get(n10);
    }

    public void u(int n10) {
        AtomicReference atomicReference = this.i;
        Object object = this.g;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)object);
        atomicReference = this.i;
        object = this.h;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)object);
        atomicReference = this.j;
        int n11 = 1;
        AtomicReference atomicReference2 = ((b)((Object)atomicReference)).l(n11 != 0, n11, 1000, n10);
        this.h = atomicReference2;
        atomicReference2 = this.j.p();
        this.g = atomicReference2;
        atomicReference2 = new AtomicReference();
        atomicReference = new AtomicReference();
        object = new AtomicBoolean(false);
        MediatorLiveData mediatorLiveData = this.i;
        LiveData liveData = this.h;
        Observer observer = new k(this, (AtomicBoolean)object, atomicReference2, atomicReference);
        mediatorLiveData.addSource(liveData, observer);
        mediatorLiveData = this.i;
        liveData = this.g;
        observer = new l(this, atomicReference, atomicReference2, (AtomicBoolean)object);
        mediatorLiveData.addSource(liveData, observer);
    }

    public MediatorLiveData v() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.i);
    }

    public /* synthetic */ void y(c c10, List list) {
        this.x(c10, list);
    }
}

