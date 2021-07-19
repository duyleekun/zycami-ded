/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ie.b;

public class d1
implements b {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final MutableLiveData c;

    public d1() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.b = mutableLiveData = new MutableLiveData(bl2);
        this.c = mutableLiveData = new MutableLiveData();
    }

    private void i(Stabilizer object) {
        this.a.postValue(object);
        MutableLiveData mutableLiveData = this.b;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.postValue(bl2);
        mutableLiveData = this.c;
        object = ((Stabilizer)object).B3();
        mutableLiveData.postValue(object);
    }

    private void j(Stabilizer object) {
        object = this.b;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).postValue(bl2);
        this.c.postValue(bl2);
    }

    public void b(Stabilizer stabilizer) {
        this.i(stabilizer);
    }

    public void c(Throwable throwable, Stabilizer stabilizer) {
        this.j(stabilizer);
    }

    public void d(Stabilizer stabilizer) {
        this.j(stabilizer);
    }

    public void e(Stabilizer stabilizer) {
        this.i(stabilizer);
    }

    public LiveData k() {
        return this.b;
    }

    public LiveData l() {
        return this.a;
    }

    public LiveData m() {
        return this.c;
    }
}

