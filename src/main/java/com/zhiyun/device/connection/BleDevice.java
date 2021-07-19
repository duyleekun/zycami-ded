/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleDevice$State;
import com.zhiyun.stabilizer.Stabilizer;
import java.util.Objects;

public class BleDevice {
    public final Stabilizer a;
    public BleDevice$State b;

    public BleDevice(Stabilizer object) {
        this.a = object;
        boolean bl2 = object.t3();
        object = bl2 ? BleDevice$State.CONNECTED : BleDevice$State.UNCONNECTED;
        this.b = object;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            object = (BleDevice)object;
            object3 = ((BleDevice)object).a;
            if (object3 == null && (object2 = this.a) == null) {
                return bl2;
            }
            if (object3 != null) {
                String string2 = this.a.F2();
                object = ((BleDevice)object).a.F2();
                return Objects.equals(string2, object);
            }
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Object object = this.a;
        objectArray[0] = object;
        object = this.b;
        objectArray[1] = object;
        return Objects.hash(objectArray);
    }
}

