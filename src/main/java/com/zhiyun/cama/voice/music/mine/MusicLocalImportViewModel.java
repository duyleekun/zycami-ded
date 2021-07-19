/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.zhiyun.cama.voice.music.mine;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel$a;
import d.g.a.a.c;
import d.v.c.k1.b.a;
import d.v.c.v0.v.c.s;
import d.v.c.y1.f.q;
import d.v.c.y1.f.x.u;
import d.v.c.y1.f.x.v;
import d.v.c.y1.f.x.z;
import d.v.e.i.h;
import d.v.j.b;
import d.v.s.b.i;
import d.v.s.b.i$a;
import d.v.s.b.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MusicLocalImportViewModel
extends MusicPlayVieModel {
    private final i f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;
    private MutableLiveData j;
    private MutableLiveData k;
    private int l;
    private List m;
    private MutableLiveData n;
    private MutableLiveData o;

    public MusicLocalImportViewModel(Application object) {
        super((Application)object);
        Object object2 = new MutableLiveData();
        this.g = object2;
        object2 = new MutableLiveData();
        this.h = object2;
        Serializable serializable = new Serializable();
        object2 = new MutableLiveData(serializable);
        this.i = object2;
        serializable = 0;
        object2 = new MutableLiveData(serializable);
        this.j = object2;
        serializable = Boolean.FALSE;
        object2 = new MutableLiveData(serializable);
        this.k = object2;
        object2 = new ArrayList();
        this.m = object2;
        this.n = object2 = new MutableLiveData();
        this.o = object2 = new MutableLiveData();
        object = d.v.s.b.l.J((Context)object);
        this.f = object;
    }

    private boolean A(a a10) {
        int n10;
        Object object = (List)this.i.getValue();
        if (object != null && (n10 = object.size()) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                long l10;
                long l11;
                Object object2 = (q)object.next();
                Object object3 = ((q)object2).G();
                long l12 = ((a)object3).c();
                long l13 = l12 - (l11 = a10.c());
                Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object4 != false || (object4 = (l10 = (l12 = ((a)(object3 = ((q)object2).G())).h()) - (l11 = a10.h())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (n10 = (int)(((String)(object2 = ((q)object2).G().g())).equals(object3 = a10.g()) ? 1 : 0)) == 0) continue;
                return true;
            }
        }
        return false;
    }

    private boolean F(a a10, String string2) {
        int n10;
        Iterator iterator2 = s.p();
        String string3 = a10.i();
        iterator2 = ((s)((Object)iterator2)).t(string3);
        string3 = null;
        if (iterator2 != null && (n10 = iterator2.size()) != 0) {
            iterator2 = iterator2.iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                String string4;
                String string5;
                long l10;
                long l11;
                Object object = (MusicInfoData)iterator2.next();
                long l12 = ((MusicInfoData)object).getDuration();
                long l13 = l12 - (l11 = a10.c());
                Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object2 != false || (object2 = (l10 = (l12 = ((MusicInfoData)object).getSize()) - (l11 = a10.h())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object2 = (Object)(string5 = ((MusicInfoData)object).getMusicPath()).equals(string4 = a10.g())) == false && (n10 = (int)(((String)(object = ((MusicInfoData)object).getMusicPath())).equals(string2) ? 1 : 0)) == 0) continue;
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ MusicInfoData Q(q object) {
        object = ((q)object).G();
        MusicInfoData musicInfoData = new MusicInfoData();
        String string2 = ((a)object).i();
        musicInfoData.setMusicName(string2);
        long l10 = ((a)object).c();
        musicInfoData.setDuration(l10);
        string2 = ((a)object).g();
        musicInfoData.setMusicPath(string2);
        l10 = ((a)object).h();
        musicInfoData.setSize(l10);
        object = ((a)object).e();
        musicInfoData.setMusicImage((String)object);
        l10 = System.currentTimeMillis();
        musicInfoData.setImportTimestamp(l10);
        return musicInfoData;
    }

    public static /* synthetic */ int R(q object, q object2) {
        object = ((q)object).G().i().trim();
        object2 = ((q)object2).G().i().trim();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = " ";
        if (bl2) {
            object = string2;
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object2)) {
            object2 = string2;
        }
        char c10 = c.g(((String)object).charAt(0)).toLowerCase().charAt(0);
        char c11 = c.g(((String)object2).charAt(0)).toLowerCase().charAt(0);
        return c10 - c11;
    }

    private void W() {
        List list = this.m;
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return;
        }
        list = this.m;
        u u10 = u.a;
        Collections.sort(list, u10);
    }

    public static /* synthetic */ boolean o(MusicLocalImportViewModel musicLocalImportViewModel, a a10, String string2) {
        return musicLocalImportViewModel.F(a10, string2);
    }

    private void onDestroy() {
        this.X();
    }

    public static /* synthetic */ boolean p(MusicLocalImportViewModel musicLocalImportViewModel, a a10) {
        return musicLocalImportViewModel.A(a10);
    }

    public static /* synthetic */ List r(MusicLocalImportViewModel musicLocalImportViewModel) {
        return musicLocalImportViewModel.m;
    }

    public static /* synthetic */ int s(MusicLocalImportViewModel musicLocalImportViewModel) {
        int n10;
        int n11 = musicLocalImportViewModel.l;
        musicLocalImportViewModel.l = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ void t(MusicLocalImportViewModel musicLocalImportViewModel) {
        musicLocalImportViewModel.W();
    }

    public static /* synthetic */ MutableLiveData u(MusicLocalImportViewModel musicLocalImportViewModel) {
        return musicLocalImportViewModel.n;
    }

    public static /* synthetic */ MutableLiveData v(MusicLocalImportViewModel musicLocalImportViewModel) {
        return musicLocalImportViewModel.g;
    }

    public static /* synthetic */ MutableLiveData w(MusicLocalImportViewModel musicLocalImportViewModel) {
        return musicLocalImportViewModel.o;
    }

    private void z() {
        Boolean bl2;
        int n10;
        MutableLiveData mutableLiveData = this.k;
        int n11 = this.J();
        if (n11 == (n10 = this.l)) {
            n11 = 1;
        } else {
            n11 = 0;
            bl2 = null;
        }
        bl2 = n11 != 0;
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    public boolean G() {
        boolean bl2;
        Object object = this.k.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.k.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public MutableLiveData H() {
        return this.k;
    }

    public MutableLiveData I() {
        return this.j;
    }

    public int J() {
        int n10;
        Object object = this.j;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)((LiveData)object).getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public MutableLiveData K() {
        return this.o;
    }

    public MutableLiveData L() {
        return this.n;
    }

    public void M() {
        boolean bl2;
        Object object = (List)this.n.getValue();
        if (object != null && !(bl2 = object.isEmpty())) {
            return;
        }
        this.l = 0;
        this.m.clear();
        object = this.g;
        Object object2 = Boolean.TRUE;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.f;
        object2 = new MusicLocalImportViewModel$a(this);
        object.x((i$a)object2);
        this.f.c(500);
        this.f.w(1);
    }

    public MutableLiveData N() {
        return this.h;
    }

    public MutableLiveData P() {
        return this.g;
    }

    public void S(Consumer consumer) {
        Object object = (List)this.i.getValue();
        if (object == null) {
            return;
        }
        object = object.stream();
        Object object2 = v.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        s.p().I((List)object, consumer);
    }

    public void T(q object) {
        Object object2 = (List)this.i.getValue();
        if (object2 == null) {
            return;
        }
        object2.remove(object);
        object = this.j;
        object2 = object2.size();
        d.v.e.i.h.g((MutableLiveData)object, object2);
        this.z();
    }

    public void U(List list) {
        s.p().h(list);
    }

    public void V(List list) {
        s.p().j(list);
    }

    public void X() {
        MutableLiveData mutableLiveData = this.g;
        Boolean bl2 = Boolean.FALSE;
        d.v.e.i.h.g(mutableLiveData, bl2);
        this.f.s();
    }

    public void Y(q object) {
        boolean bl2 = ((q)object).H() ^ true;
        ((q)object).J(bl2);
        List list = (List)this.i.getValue();
        if (list == null) {
            return;
        }
        if (bl2) {
            list.add(object);
        } else {
            list.remove(object);
        }
        object = this.j;
        Integer n10 = list.size();
        d.v.e.i.h.g((MutableLiveData)object, n10);
        this.z();
    }

    public void x(q object) {
        Object object2 = (List)this.i.getValue();
        if (object2 == null) {
            return;
        }
        object2.add(object);
        object = this.j;
        object2 = object2.size();
        d.v.e.i.h.g((MutableLiveData)object, object2);
        this.z();
    }

    public boolean y(List object) {
        boolean bl2 = b.f((List)object);
        if (bl2) {
            return false;
        }
        object = object.stream();
        z z10 = z.a;
        return object.allMatch(z10);
    }
}

