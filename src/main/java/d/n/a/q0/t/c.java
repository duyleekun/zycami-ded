/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 *  android.bluetooth.BluetoothGattService
 */
package d.n.a.q0.t;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import d.n.a.k0;
import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.x.h;
import java.util.List;

public class c {
    private final h a;

    public c(h h10) {
        this.a = h10;
    }

    private static void a(StringBuilder stringBuilder, BluetoothGattCharacteristic object) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("* ");
        String string2 = c.i(object);
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        object = b.h(object.getUuid());
        stringBuilder.append((String)object);
        stringBuilder.append(")");
    }

    private void b(StringBuilder stringBuilder, BluetoothGattCharacteristic object) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("  ");
        stringBuilder.append("Properties: ");
        h h10 = this.a;
        int n10 = object.getProperties();
        object = h10.c(n10);
        stringBuilder.append((String)object);
    }

    private static void c(StringBuilder stringBuilder, BluetoothGattDescriptor object) {
        stringBuilder.append('\n');
        char c10 = '\t';
        stringBuilder.append(c10);
        stringBuilder.append(c10);
        stringBuilder.append("* ");
        String string2 = c.j(object);
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        object = b.h(object.getUuid());
        stringBuilder.append((String)object);
        stringBuilder.append(")");
    }

    private static void d(StringBuilder stringBuilder, BluetoothGattCharacteristic object) {
        List list = object.getDescriptors();
        boolean bl2 = list.isEmpty();
        if (!bl2) {
            c.e(stringBuilder);
            object = object.getDescriptors().iterator();
            while (bl2 = object.hasNext()) {
                list = (BluetoothGattDescriptor)object.next();
                c.c(stringBuilder, (BluetoothGattDescriptor)list);
            }
        }
    }

    private static void e(StringBuilder stringBuilder) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("  ");
        stringBuilder.append("-> Descriptors: ");
    }

    private static void f(BluetoothDevice object, StringBuilder stringBuilder) {
        stringBuilder.append("--------------- ====== Printing peripheral content ====== ---------------\n");
        String string2 = b.d(object.getAddress());
        stringBuilder.append(string2);
        char c10 = '\n';
        stringBuilder.append(c10);
        stringBuilder.append("PERIPHERAL NAME: ");
        object = object.getName();
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append("-------------------------------------------------------------------------");
    }

    private void g(StringBuilder stringBuilder, BluetoothGattService object) {
        boolean bl2;
        c.h(stringBuilder, (BluetoothGattService)object);
        String string2 = "-> Characteristics:";
        stringBuilder.append(string2);
        object = object.getCharacteristics().iterator();
        while (bl2 = object.hasNext()) {
            string2 = (BluetoothGattCharacteristic)object.next();
            c.a(stringBuilder, (BluetoothGattCharacteristic)string2);
            this.b(stringBuilder, (BluetoothGattCharacteristic)string2);
            c.d(stringBuilder, (BluetoothGattCharacteristic)string2);
        }
    }

    private static void h(StringBuilder stringBuilder, BluetoothGattService bluetoothGattService) {
        stringBuilder.append("\n");
        String string2 = c.l(bluetoothGattService);
        stringBuilder.append(string2);
        stringBuilder.append(" - ");
        string2 = c.k(bluetoothGattService);
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        string2 = b.h(bluetoothGattService.getUuid());
        stringBuilder.append(string2);
        stringBuilder.append(")\n");
        stringBuilder.append("Instance ID: ");
        int n10 = bluetoothGattService.getInstanceId();
        stringBuilder.append(n10);
        stringBuilder.append('\n');
    }

    private static String i(BluetoothGattCharacteristic object) {
        if ((object = d.n.a.s0.c.a(object.getUuid())) == null) {
            object = "Unknown characteristic";
        }
        return object;
    }

    private static String j(BluetoothGattDescriptor object) {
        if ((object = d.n.a.s0.c.b(object.getUuid())) == null) {
            object = "Unknown descriptor";
        }
        return object;
    }

    private static String k(BluetoothGattService object) {
        if ((object = d.n.a.s0.c.c(object.getUuid())) == null) {
            object = "Unknown service";
        }
        return object;
    }

    private static String l(BluetoothGattService bluetoothGattService) {
        int n10 = bluetoothGattService.getType();
        if (n10 == 0) {
            return "Primary Service";
        }
        return "Secondary Service";
    }

    private String n(k0 object, BluetoothDevice bluetoothDevice) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        c.f(bluetoothDevice, stringBuilder);
        object = ((k0)object).a().iterator();
        while (bl2 = object.hasNext()) {
            bluetoothDevice = (BluetoothGattService)object.next();
            char c10 = '\n';
            stringBuilder.append(c10);
            this.g(stringBuilder, (BluetoothGattService)bluetoothDevice);
        }
        stringBuilder.append("\n--------------- ====== Finished peripheral content ====== ---------------");
        return stringBuilder.toString();
    }

    public void m(k0 object, BluetoothDevice objectArray) {
        boolean bl2 = p.m(2);
        if (bl2) {
            bl2 = false;
            Object[] objectArray2 = new Object[]{};
            String string2 = "Preparing services description";
            p.s(string2, objectArray2);
            object = this.n((k0)object, (BluetoothDevice)objectArray);
            objectArray = new Object[]{};
            p.s((String)object, objectArray);
        }
    }
}

