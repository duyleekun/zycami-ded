/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import m.a.a;

public class BleViewModel$l
extends d.v.e0.ke.a {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$l(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void a() {
        Object object = this.a;
        Object[] objectArray = object.g;
        KeyFunc keyFunc = KeyFunc.DEFAULT;
        object = BleViewModel.b(object, (LiveData)objectArray, keyFunc);
        objectArray = new Object[]{object};
        m.a.a.i("CustomMenu: %s", objectArray);
    }
}

