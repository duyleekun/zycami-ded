/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.device.connection.BleDevice;
import java.lang.constant.Constable;

public class s
extends ViewModel {
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;

    public s() {
        MutableLiveData mutableLiveData;
        Constable constable = 0;
        this.a = mutableLiveData = new MutableLiveData(constable);
        this.b = mutableLiveData = new MutableLiveData();
        constable = Boolean.TRUE;
        this.c = mutableLiveData = new MutableLiveData(constable);
        this.d = mutableLiveData = new MutableLiveData();
        constable = Boolean.FALSE;
        this.e = mutableLiveData = new MutableLiveData(constable);
    }

    public int b() {
        int n10;
        Object object = this.a.getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.a.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public void c(BleDevice object) {
        int n10;
        this.b.setValue(object);
        MutableLiveData mutableLiveData = this.a;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = 2;
        }
        object = n10;
        mutableLiveData.setValue(object);
    }

    public void d(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }
}

