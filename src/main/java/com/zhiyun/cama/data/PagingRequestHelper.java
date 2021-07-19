/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$RequestType;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$a;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import com.zhiyun.cama.data.PagingRequestHelper$c;
import com.zhiyun.cama.data.PagingRequestHelper$d;
import com.zhiyun.cama.data.PagingRequestHelper$e;
import com.zhiyun.cama.data.PagingRequestHelper$f;
import d.v.c.v0.b;
import d.v.c.v0.c;
import d.v.e.l.m2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class PagingRequestHelper {
    private final Object a;
    private final Executor b;
    private final PagingRequestHelper$d[] c;
    public final CopyOnWriteArrayList d;

    public PagingRequestHelper(Executor executor) {
        PagingRequestHelper$d pagingRequestHelper$d;
        Object object = new Object();
        this.a = object;
        object = new PagingRequestHelper$d[3];
        PagingRequestHelper$RequestType pagingRequestHelper$RequestType = PagingRequestHelper$RequestType.INITIAL;
        object[0] = pagingRequestHelper$d = new PagingRequestHelper$d(this, pagingRequestHelper$RequestType);
        pagingRequestHelper$RequestType = PagingRequestHelper$RequestType.BEFORE;
        object[1] = pagingRequestHelper$d = new PagingRequestHelper$d(this, pagingRequestHelper$RequestType);
        pagingRequestHelper$RequestType = PagingRequestHelper$RequestType.AFTER;
        object[2] = pagingRequestHelper$d = new PagingRequestHelper$d(this, pagingRequestHelper$RequestType);
        this.c = object;
        this.d = object;
        this.b = executor;
    }

    private void c(PagingRequestHelper$f pagingRequestHelper$f) {
        boolean bl2;
        Iterator iterator2 = this.d.iterator();
        while (bl2 = iterator2.hasNext()) {
            PagingRequestHelper$a pagingRequestHelper$a = (PagingRequestHelper$a)iterator2.next();
            pagingRequestHelper$a.a(pagingRequestHelper$f);
        }
    }

    private PagingRequestHelper$Status d(PagingRequestHelper$RequestType pagingRequestHelper$RequestType) {
        PagingRequestHelper$d[] pagingRequestHelper$dArray = this.c;
        int n10 = pagingRequestHelper$RequestType.ordinal();
        return pagingRequestHelper$dArray[n10].e;
    }

    public static /* synthetic */ void e(MutableLiveData mutableLiveData, PagingRequestHelper$f pagingRequestHelper$f) {
        c c10 = new c(pagingRequestHelper$f, mutableLiveData);
        m2.Y(200L, c10);
    }

    public static /* synthetic */ void f(PagingRequestHelper$f object, MutableLiveData mutableLiveData) {
        boolean bl2 = ((PagingRequestHelper$f)object).e();
        if (bl2) {
            PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.RUNNING;
            object = new PagingRequestHelper$b(pagingRequestHelper$Status);
            mutableLiveData.postValue(object);
        } else {
            bl2 = ((PagingRequestHelper$f)object).d();
            if (bl2) {
                PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
                int n10 = ((PagingRequestHelper$f)object).a();
                object = ((PagingRequestHelper$f)object).c();
                PagingRequestHelper$b pagingRequestHelper$b = new PagingRequestHelper$b(pagingRequestHelper$Status, n10, (String)object);
                mutableLiveData.postValue(pagingRequestHelper$b);
            } else {
                PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
                object = new PagingRequestHelper$b(pagingRequestHelper$Status);
                mutableLiveData.postValue(object);
            }
        }
    }

    private PagingRequestHelper$f g() {
        Object object;
        Throwable[] throwableArray = new Throwable[3];
        Object object2 = this.c;
        throwableArray[0] = object = object2[0].d;
        int n10 = 1;
        throwableArray[n10] = object = object2[n10].d;
        n10 = 2;
        throwableArray[n10] = object2 = object2[n10].d;
        Enum enum_ = PagingRequestHelper$RequestType.INITIAL;
        enum_ = this.d((PagingRequestHelper$RequestType)enum_);
        object = PagingRequestHelper$RequestType.BEFORE;
        object = this.d((PagingRequestHelper$RequestType)((Object)object));
        Enum enum_2 = PagingRequestHelper$RequestType.AFTER;
        enum_2 = this.d((PagingRequestHelper$RequestType)enum_2);
        object2 = new PagingRequestHelper$f((PagingRequestHelper$Status)enum_, (PagingRequestHelper$Status)((Object)object), (PagingRequestHelper$Status)enum_2, throwableArray);
        return object2;
    }

    public boolean a(PagingRequestHelper$a pagingRequestHelper$a) {
        return this.d.add(pagingRequestHelper$a);
    }

    public LiveData b() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        b b10 = new b(mutableLiveData);
        this.a(b10);
        return mutableLiveData;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void h(PagingRequestHelper$e object, Throwable throwable, int n10, String string2) {
        boolean bl2 = true;
        boolean bl3 = throwable == null ? bl2 : false;
        boolean bl4 = this.d.isEmpty();
        bl2 ^= bl4;
        Object object2 = this.a;
        // MONITORENTER : object2
        Object object3 = this.c;
        Object object4 = object.c;
        int n11 = ((Enum)object4).ordinal();
        object3 = object3[n11];
        n11 = 0;
        object4 = null;
        object3.c = null;
        object3.d = throwable;
        if (bl3) {
            object3.b = null;
            object = PagingRequestHelper$Status.SUCCESS;
            object3.e = object;
        } else {
            object3.b = object;
            object = PagingRequestHelper$Status.FAILED;
            object3.e = object;
        }
        if (bl2) {
            object4 = this.g();
        }
        // MONITOREXIT : object2
        if (object4 == null) return;
        ((PagingRequestHelper$f)object4).f(n10);
        ((PagingRequestHelper$f)object4).g(string2);
        this.c((PagingRequestHelper$f)object4);
    }

    public boolean i(PagingRequestHelper$a pagingRequestHelper$a) {
        return this.d.remove(pagingRequestHelper$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean j() {
        PagingRequestHelper$e pagingRequestHelper$e;
        int n10;
        PagingRequestHelper$RequestType[] pagingRequestHelper$RequestTypeArray = PagingRequestHelper$RequestType.values();
        int n11 = pagingRequestHelper$RequestTypeArray.length;
        PagingRequestHelper$e[] pagingRequestHelper$eArray = new PagingRequestHelper$e[n11];
        Object object = this.a;
        synchronized (object) {
            Object object2;
            int n12;
            n10 = 0;
            pagingRequestHelper$e = null;
            for (int i10 = 0; i10 < (n12 = ((PagingRequestHelper$RequestType[])(object2 = PagingRequestHelper$RequestType.values())).length); ++i10) {
                object2 = this.c;
                Object object3 = object2[i10];
                object3 = ((PagingRequestHelper$d)object3).b;
                pagingRequestHelper$eArray[i10] = object3;
                object2 = object2[i10];
                object3 = null;
                object2.b = null;
            }
        }
        boolean bl2 = false;
        object = null;
        while (n10 < n11) {
            pagingRequestHelper$e = pagingRequestHelper$eArray[n10];
            if (pagingRequestHelper$e != null) {
                object = this.b;
                pagingRequestHelper$e.c((Executor)object);
                bl2 = true;
            }
            ++n10;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean k(PagingRequestHelper$RequestType pagingRequestHelper$RequestType, PagingRequestHelper$c pagingRequestHelper$c) {
        Object object = this.d;
        boolean bl2 = ((CopyOnWriteArrayList)object).isEmpty();
        boolean bl3 = true;
        bl2 ^= bl3;
        Object object2 = this.a;
        // MONITORENTER : object2
        Object object3 = this.c;
        int n10 = pagingRequestHelper$RequestType.ordinal();
        object3 = object3[n10];
        Object object4 = object3.c;
        if (object4 != null) {
            pagingRequestHelper$RequestType = null;
            // MONITOREXIT : object2
            return false;
        }
        object3.c = pagingRequestHelper$c;
        object4 = PagingRequestHelper$Status.RUNNING;
        object3.e = object4;
        n10 = 0;
        object4 = null;
        object3.b = null;
        object3.d = null;
        if (bl2) {
            object4 = this.g();
        }
        // MONITOREXIT : object2
        if (object4 != null) {
            this.c((PagingRequestHelper$f)object4);
        }
        object = new PagingRequestHelper$e(pagingRequestHelper$c, this, pagingRequestHelper$RequestType);
        ((PagingRequestHelper$e)object).run();
        return bl3;
    }
}

