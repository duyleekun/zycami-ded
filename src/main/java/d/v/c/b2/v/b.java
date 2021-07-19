/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.b2.v;

import android.content.Context;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.b2.v.a;
import d.v.c.b2.v.b$a;
import d.v.e.i.h;
import d.v.j.g.d0.d;
import d.v.j.g.d0.d$a;

public class b
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    public final MediatorLiveData c;
    private final d.v.c.v0.q.b d;
    private final d$a e;
    private boolean f;

    public b() {
        Object object = new MutableLiveData();
        this.a = object;
        object = new MutableLiveData();
        this.b = object;
        this.c = object;
        this.d = object = new d.v.c.v0.q.b();
        a a10 = new a(this);
        this.e = a10;
        ((d)object).b(a10);
    }

    private /* synthetic */ void j(Long object, d.v.c.b2.w.a a10, DownloadEvent downloadEvent) {
        boolean bl2 = this.f;
        if (!bl2) {
            return;
        }
        if (downloadEvent != null) {
            object = b$a.a;
            int n10 = downloadEvent.getDownloadState().ordinal();
            Object object2 = object[n10];
            n10 = 0;
            switch (object2) {
                default: {
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    this.f = false;
                    a10.C(0);
                    a10.B(false);
                    break;
                }
                case 2: {
                    this.f = false;
                    a10.C(100);
                    boolean bl3 = true;
                    a10.B(bl3);
                    break;
                }
                case 1: {
                    int n11 = downloadEvent.getProgress();
                    a10.C(n11);
                }
            }
        }
    }

    public void b(Context context, d.v.c.b2.w.a a10) {
        long l10 = a10.getId();
        this.d.J(context, l10, a10);
        this.f = true;
    }

    public void c(d.v.c.b2.w.a a10) {
        h.g(this.b, a10);
    }

    public MutableLiveData d() {
        return this.a;
    }

    public int e() {
        int n10;
        Object object = this.a.getValue();
        if (object == null) {
            n10 = -1;
        } else {
            object = (Integer)this.a.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public MutableLiveData f() {
        return this.b;
    }

    public MediatorLiveData g() {
        return (MediatorLiveData)Transformations.distinctUntilChanged(this.c);
    }

    public void i(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public /* synthetic */ void k(Long l10, d.v.c.b2.w.a a10, DownloadEvent downloadEvent) {
        this.j(l10, a10, downloadEvent);
    }

    public void l(int n10) {
        MediatorLiveData mediatorLiveData = this.c;
        Integer n11 = n10;
        h.g(mediatorLiveData, n11);
    }

    public void onCleared() {
        super.onCleared();
        d.v.c.v0.q.b b10 = this.d;
        if (b10 != null) {
            d$a d$a = this.e;
            b10.w(d$a);
        }
    }
}

