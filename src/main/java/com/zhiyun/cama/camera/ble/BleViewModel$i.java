/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.stabilizer.Stabilizer$j;
import d.v.y.c.s1.l.c;
import m.a.a;

public class BleViewModel$i
implements Stabilizer$j {
    private WorkingMode a;
    public final /* synthetic */ BleViewModel b;

    public BleViewModel$i(BleViewModel bleViewModel) {
        this.b = bleViewModel;
    }

    public void a(c object) {
        Object object2;
        if ((object = ((c)object).d()) != null && object != (object2 = this.a)) {
            WorkingMode workingMode;
            this.a = object;
            object2 = this.b.b;
            int n10 = (int)(((LiveData)object2).hasActiveObservers() ? 1 : 0);
            if (n10 != 0) {
                object2 = this.b.b;
                workingMode = this.a;
                ((MutableLiveData)object2).postValue((Object)workingMode);
            }
            n10 = 1;
            object2 = new Object[n10];
            workingMode = null;
            object2[0] = object = ((Enum)object).name();
            object = "rdis: %s";
            m.a.a.i((String)object, (Object[])object2);
        }
    }
}

