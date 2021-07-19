/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package com.zhiyun.cama.voice.music;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.v0.v.c.s;
import d.v.c.y1.f.a;
import d.v.c.y1.f.j;
import d.v.c.y1.f.k;
import d.v.c.y1.f.q;
import d.v.c.y1.f.t;
import d.v.e.i.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class MusicListViewModel
extends MusicPlayVieModel {
    private final t f;
    private LiveData g;
    private LiveData h;
    private LiveData i;
    private MediatorLiveData j;
    private MutableLiveData k;

    public MusicListViewModel(Application object) {
        super((Application)object);
        super();
        this.j = object;
        super();
        this.k = object;
        super();
        this.f = object;
    }

    private void A(LiveData liveData) {
        AtomicReference atomicReference = this.j;
        AtomicReference atomicReference2 = this.h;
        d.v.e.i.h.c((MediatorLiveData)((Object)atomicReference), (LiveData)((Object)atomicReference2));
        atomicReference = this.f.g();
        this.h = atomicReference;
        atomicReference = new AtomicReference();
        atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        LiveData liveData2 = this.j;
        Observer observer = new j(this, atomicBoolean, atomicReference, atomicReference2);
        liveData2.addSource(liveData, observer);
        liveData = this.j;
        liveData2 = this.h;
        observer = new k(this, atomicReference2, atomicReference, atomicBoolean);
        ((MediatorLiveData)liveData).addSource(liveData2, observer);
    }

    private void F(List object, List object2, boolean bl2) {
        if (!bl2) {
            object = this.j;
            object2 = null;
            ((MutableLiveData)object).setValue(null);
        } else {
            t t10 = this.f;
            object = t10.j((List)object, (List)object2);
            object2 = this.j;
            ((MutableLiveData)object2).setValue(object);
        }
    }

    private /* synthetic */ void w(AtomicBoolean atomicBoolean, AtomicReference object, AtomicReference object2, d.v.j.e.h.k object3) {
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
        this.F((List)object, (List)object2, bl2);
    }

    private /* synthetic */ void y(AtomicReference object, AtomicReference object2, AtomicBoolean atomicBoolean, List list) {
        ((AtomicReference)object).set(list);
        object2 = (List)((AtomicReference)object2).get();
        object = (List)((AtomicReference)object).get();
        boolean bl2 = atomicBoolean.get();
        this.F((List)object2, (List)object, bl2);
    }

    public void o(q q10) {
        d.v.e.i.h.g(this.k, q10);
    }

    public void onCleared() {
        super.onCleared();
        this.f.h();
    }

    public void p(Context context, q q10) {
        long l10 = q10.G().f();
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.MUSIC;
        q10.E(editConfig$ResourceType);
        this.f.a(context, l10, q10);
    }

    public MutableLiveData r() {
        return this.k;
    }

    public void s() {
        LiveData liveData = this.j;
        LiveData liveData2 = this.i;
        d.v.e.i.h.c(liveData, liveData2);
        liveData = this.f.f();
        this.i = liveData;
        this.A(liveData);
    }

    public LiveData t() {
        LiveData liveData = s.p().r();
        t t10 = this.f;
        t10.getClass();
        a a10 = new a(t10);
        return Transformations.map(liveData, a10);
    }

    public void u(long l10) {
        LiveData liveData;
        MediatorLiveData mediatorLiveData = this.j;
        LiveData liveData2 = this.g;
        d.v.e.i.h.c(mediatorLiveData, liveData2);
        this.g = liveData = this.f.e(l10);
        this.A(liveData);
    }

    public MediatorLiveData v() {
        return this.j;
    }

    public /* synthetic */ void x(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2, d.v.j.e.h.k k10) {
        this.w(atomicBoolean, atomicReference, atomicReference2, k10);
    }

    public /* synthetic */ void z(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, List list) {
        this.y(atomicReference, atomicReference2, atomicBoolean, list);
    }
}

