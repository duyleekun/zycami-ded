/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.t;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.q0.p;
import d.n.a.q0.t.b$a;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

public class b {
    private static final char[] a = "0123456789ABCDEF".toCharArray();

    private b() {
    }

    public static String a(byte[] object) {
        int n10;
        if (object == null) {
            return "null";
        }
        int n11 = p.h();
        if (n11 == 0) {
            return "[...]";
        }
        n11 = ((byte[])object).length;
        if (n11 == 0) {
            return "[]";
        }
        int n12 = n11 * 2;
        int n13 = n11 + -1;
        int n14 = n13 * 2;
        n12 = n12 + n14 + 2;
        char[] cArray = new char[n12];
        for (n10 = 0; n10 < n11; ++n10) {
            int n15 = object[n10] & 0xFF;
            int n16 = n10 * 2;
            int n17 = n16 + 1 + n16;
            char[] cArray2 = a;
            int n18 = n15 >>> 4;
            cArray[n17] = n18 = cArray2[n18];
            n15 &= 0xF;
            cArray[++n17] = n15 = cArray2[n15];
        }
        object = null;
        for (int i10 = 0; i10 < n13; ++i10) {
            n11 = i10 * 2;
            n10 = n11 + 1 + n11 + 2;
            cArray[n10] = 44;
            cArray[++n10] = n11 = 32;
        }
        cArray[0] = 91;
        cArray[n12 += -1] = 93;
        object = new String;
        object(cArray);
        return object;
    }

    private static String b() {
        return " %24s()";
    }

    public static String c(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            return "MAC=null";
        }
        return b.d(bluetoothGatt.getDevice().getAddress());
    }

    public static String d(String string2) {
        Object[] objectArray;
        int n10;
        if (string2 == null) {
            return "MAC=null";
        }
        int n11 = p.g();
        if (n11 != (n10 = 3)) {
            n10 = -1 >>> 1;
            if (n11 == n10) {
                string2 = "XX:XX:XX:XX:XX:XX";
            }
        } else {
            objectArray = new StringBuilder();
            n10 = 15;
            string2 = string2.substring(0, n10);
            objectArray.append(string2);
            objectArray.append("XX");
            string2 = objectArray.toString();
        }
        objectArray = new Object[]{string2};
        return String.format("MAC='%s'", objectArray);
    }

    private static String e() {
        return ", status=%d";
    }

    private static String f() {
        return ", value=%s";
    }

    public static String g(Set object) {
        int n10 = object.size();
        Object[] objectArray = new String[n10];
        object = object.iterator();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = b.h((UUID)object.next());
            objectArray[i10] = string2;
        }
        return Arrays.toString(objectArray);
    }

    public static String h(UUID uUID) {
        int n10;
        int n11 = p.j();
        if (n11 == (n10 = 2)) {
            return uUID.toString();
        }
        return "...";
    }

    public static void i(String string2, BluetoothGatt object, int n10) {
        boolean bl2 = p.m(4);
        if (!bl2) {
            return;
        }
        Object[] objectArray = new StringBuilder();
        object = b.c(object);
        objectArray.append((String)object);
        object = b.b();
        objectArray.append((String)object);
        object = b.e();
        objectArray.append((String)object);
        object = objectArray.toString();
        objectArray = new Object[2];
        objectArray[0] = string2;
        Integer n11 = n10;
        objectArray[1] = n11;
        p.k((String)object, objectArray);
    }

    public static void j(String string2, BluetoothGatt object, int n10, int n11) {
        boolean bl2 = p.m(4);
        if (!bl2) {
            return;
        }
        Object[] objectArray = new StringBuilder();
        object = b.c(object);
        objectArray.append((String)object);
        object = b.b();
        objectArray.append((String)object);
        object = b.e();
        objectArray.append((String)object);
        object = b.f();
        objectArray.append((String)object);
        object = objectArray.toString();
        objectArray = new Object[3];
        objectArray[0] = string2;
        Integer n12 = n10;
        objectArray[1] = n12;
        n12 = n11;
        objectArray[2] = n12;
        p.k((String)object, objectArray);
    }

    public static void k(String string2, BluetoothGatt object, int n10, BluetoothGattCharacteristic object2, boolean bl2) {
        boolean bl3 = p.m(4);
        if (!bl3) {
            return;
        }
        UUID uUID = object2.getUuid();
        object2 = object2.getValue();
        b$a b$a = new b$a(uUID, (byte[])object2, bl2);
        object2 = new StringBuilder();
        object = b.c(object);
        ((StringBuilder)object2).append((String)object);
        object = b.b();
        ((StringBuilder)object2).append((String)object);
        object = b.e();
        ((StringBuilder)object2).append((String)object);
        object = b.f();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[3];
        object2[0] = string2;
        Integer n11 = n10;
        object2[1] = n11;
        object2[2] = b$a;
        p.k((String)object, (Object[])object2);
    }

    public static void l(String string2, BluetoothGatt object, int n10, BluetoothGattDescriptor object2, boolean bl2) {
        boolean bl3 = p.m(4);
        if (!bl3) {
            return;
        }
        UUID uUID = object2.getUuid();
        object2 = object2.getValue();
        b$a b$a = new b$a(uUID, (byte[])object2, bl2);
        object2 = new StringBuilder();
        object = b.c(object);
        ((StringBuilder)object2).append((String)object);
        object = b.b();
        ((StringBuilder)object2).append((String)object);
        object = b.e();
        ((StringBuilder)object2).append((String)object);
        object = b.f();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[3];
        object2[0] = string2;
        Integer n11 = n10;
        object2[1] = n11;
        object2[2] = b$a;
        p.k((String)object, (Object[])object2);
    }

    public static void m(String string2, BluetoothGatt object, BluetoothGattCharacteristic object2, boolean bl2) {
        boolean bl3 = p.m(4);
        if (!bl3) {
            return;
        }
        UUID uUID = object2.getUuid();
        object2 = object2.getValue();
        b$a b$a = new b$a(uUID, (byte[])object2, bl2);
        object2 = new StringBuilder();
        object = b.c(object);
        ((StringBuilder)object2).append((String)object);
        object = b.b();
        ((StringBuilder)object2).append((String)object);
        object = b.f();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[]{string2, b$a};
        p.k((String)object, (Object[])object2);
    }

    public static void n(String object, BluetoothGatt object2, int n10, int n11, int n12, int n13) {
        int n14 = 4;
        boolean bl2 = p.m(n14);
        if (!bl2) {
            return;
        }
        Object[] objectArray = new StringBuilder();
        object2 = b.c(object2);
        objectArray.append((String)object2);
        object2 = b.b();
        objectArray.append((String)object2);
        object2 = b.e();
        objectArray.append((String)object2);
        objectArray.append(", interval=%d (%.2f ms), latency=%d, timeout=%d (%.0f ms)");
        object2 = objectArray.toString();
        objectArray = new Object[7];
        objectArray[0] = object;
        Number number = n10;
        objectArray[1] = number;
        number = n11;
        objectArray[2] = number;
        number = Float.valueOf((float)n11 * 1.25f);
        objectArray[3] = number;
        objectArray[n14] = object = Integer.valueOf(n12);
        number = n13;
        objectArray[5] = number;
        number = Float.valueOf((float)n13 * 10.0f);
        objectArray[6] = number;
        p.k((String)object2, objectArray);
    }

    public static void o(d.n.a.q0.u.p object, long l10, long l11) {
        int n10 = 3;
        int n11 = (int)(p.m(n10) ? 1 : 0);
        if (n11 != 0) {
            Object[] objectArray = new Object[n10];
            String string2 = object.getClass().getSimpleName();
            objectArray[0] = string2;
            n11 = 1;
            objectArray[n11] = object = Integer.valueOf(System.identityHashCode(object));
            int n12 = 2;
            Long l12 = l11 -= l10;
            objectArray[n12] = l12;
            object = "FINISHED %s(%d) in %d ms";
            p.b((String)object, objectArray);
        }
    }

    public static void p(d.n.a.q0.u.p object) {
        int n10 = p.m(3);
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            String string2 = object.getClass().getSimpleName();
            objectArray[0] = string2;
            int n11 = 1;
            int n12 = System.identityHashCode(object);
            objectArray[n11] = object = Integer.valueOf(n12);
            object = "QUEUED   %s(%d)";
            p.b((String)object, objectArray);
        }
    }

    public static void q(d.n.a.q0.u.p object) {
        int n10 = p.m(3);
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            String string2 = object.getClass().getSimpleName();
            objectArray[0] = string2;
            int n11 = 1;
            int n12 = System.identityHashCode(object);
            objectArray[n11] = object = Integer.valueOf(n12);
            object = "REMOVED  %s(%d)";
            p.b((String)object, objectArray);
        }
    }

    public static void r(d.n.a.q0.u.p p10) {
        Object[] objectArray = new Object[]{p10};
        p.k("RUNNING  %s", objectArray);
    }

    public static void s(d.n.a.q0.u.p object) {
        int n10 = 2;
        int n11 = (int)(p.m(n10) ? 1 : 0);
        if (n11 != 0) {
            Object[] objectArray = new Object[n10];
            String string2 = object.getClass().getSimpleName();
            objectArray[0] = string2;
            n11 = 1;
            int n12 = System.identityHashCode(object);
            objectArray[n11] = object = Integer.valueOf(n12);
            object = "SKIPPED  %s(%d) just before running \u2014 is disposed";
            p.s((String)object, objectArray);
        }
    }

    public static void t(d.n.a.q0.u.p object) {
        int n10 = p.m(3);
        if (n10 != 0) {
            n10 = 2;
            Object[] objectArray = new Object[n10];
            String string2 = object.getClass().getSimpleName();
            objectArray[0] = string2;
            int n11 = 1;
            int n12 = System.identityHashCode(object);
            objectArray[n11] = object = Integer.valueOf(n12);
            object = "STARTED  %s(%d)";
            p.b((String)object, objectArray);
        }
    }

    public static b$a u(BluetoothGattCharacteristic object, boolean bl2) {
        UUID uUID = object.getUuid();
        object = object.getValue();
        b$a b$a = new b$a(uUID, (byte[])object, bl2);
        return b$a;
    }

    public static b$a v(BluetoothGattDescriptor object, boolean bl2) {
        UUID uUID = object.getUuid();
        object = object.getValue();
        b$a b$a = new b$a(uUID, (byte[])object, bl2);
        return b$a;
    }
}

