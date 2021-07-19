/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package d.v.e.i;

import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.e.i.a;
import d.v.e.i.h$a;
import d.v.e.l.c1;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;

public class h {
    public static /* synthetic */ void a(MediatorLiveData mediatorLiveData, LiveData liveData, LiveData liveData2) {
        mediatorLiveData.removeSource(liveData);
    }

    private static void b(MutableLiveData object, Object object2) {
        Executor executor = c1.b().c();
        object = h$a.a((MutableLiveData)object, object2);
        executor.execute((Runnable)object);
    }

    public static void c(MediatorLiveData mediatorLiveData, LiveData liveData) {
        if (mediatorLiveData == null) {
            return;
        }
        Optional<LiveData> optional = Optional.ofNullable(liveData);
        a a10 = new a(mediatorLiveData, liveData);
        optional.ifPresent(a10);
    }

    public static boolean d(MutableLiveData mutableLiveData, Object object) {
        Object object2;
        boolean bl2;
        if (mutableLiveData != null && !(bl2 = Objects.equals(object, object2 = mutableLiveData.getValue()))) {
            h.e(mutableLiveData, object);
            return true;
        }
        return false;
    }

    public static void e(MutableLiveData mutableLiveData, Object object) {
        Thread thread;
        if (mutableLiveData == null) {
            return;
        }
        Thread thread2 = Thread.currentThread();
        if (thread2 == (thread = Looper.getMainLooper().getThread())) {
            mutableLiveData.setValue(object);
        } else {
            h.b(mutableLiveData, object);
        }
    }

    public static boolean f(MutableLiveData mutableLiveData, Object object) {
        Object object2;
        boolean bl2;
        if (mutableLiveData != null && !(bl2 = Objects.equals(object, object2 = mutableLiveData.getValue()))) {
            h.g(mutableLiveData, object);
            return true;
        }
        return false;
    }

    public static void g(MutableLiveData mutableLiveData, Object object) {
        Thread thread;
        if (mutableLiveData == null) {
            return;
        }
        Thread thread2 = Thread.currentThread();
        if (thread2 == (thread = Looper.getMainLooper().getThread())) {
            mutableLiveData.setValue(object);
        } else {
            mutableLiveData.postValue(object);
        }
    }
}

