/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package d.n.a.q0.x;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build;
import d.n.a.q0.p;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b {
    private final Context a;

    public b(Context context) {
        this.a = context;
    }

    private BluetoothGatt b(BluetoothGattCallback bluetoothGattCallback, BluetoothDevice bluetoothDevice, boolean bl2) {
        Object[] objectArray = new Object[]{};
        String string2 = "Connecting without reflection";
        p.s(string2, objectArray);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            objectArray = this.a;
            return bluetoothDevice.connectGatt((Context)objectArray, bl2, bluetoothGattCallback, 2);
        }
        objectArray = this.a;
        return bluetoothDevice.connectGatt((Context)objectArray, bl2, bluetoothGattCallback);
    }

    private static boolean c(BluetoothGatt bluetoothGatt, BluetoothGattCallback bluetoothGattCallback, boolean bl2) {
        Object[] objectArray = new Object[]{};
        p.s("Connecting using reflection", objectArray);
        b.h(bluetoothGatt, bl2);
        GenericDeclaration genericDeclaration = bluetoothGatt.getClass();
        int n10 = 2;
        Object object = new Class[n10];
        object[0] = Boolean.class;
        int n11 = 1;
        object[n11] = BluetoothGattCallback.class;
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("connect", (Class<?>)object);
        ((Method)genericDeclaration).setAccessible(n11 != 0);
        objectArray = new Object[n10];
        objectArray[0] = object = Boolean.TRUE;
        objectArray[n11] = bluetoothGattCallback;
        return (Boolean)((Method)genericDeclaration).invoke(bluetoothGatt, objectArray);
    }

    private BluetoothGatt d(Object object, BluetoothDevice bluetoothDevice) {
        Constructor<?> constructor = BluetoothGatt.class.getDeclaredConstructors()[0];
        int n10 = 1;
        constructor.setAccessible(n10 != 0);
        Object[] objectArray = new StringBuilder();
        objectArray.append("Found constructor with args count = ");
        int n11 = constructor.getParameterTypes().length;
        objectArray.append(n11);
        objectArray = objectArray.toString();
        Object[] objectArray2 = new Object[]{};
        p.s((String)objectArray, objectArray2);
        objectArray = constructor.getParameterTypes();
        int n12 = objectArray.length;
        n11 = 3;
        int n13 = 4;
        int n14 = 2;
        if (n12 == n13) {
            objectArray = new Object[n13];
            Context context = this.a;
            objectArray[0] = context;
            objectArray[n10] = object;
            objectArray[n14] = bluetoothDevice;
            objectArray[n11] = object = Integer.valueOf(n14);
            return (BluetoothGatt)constructor.newInstance(objectArray);
        }
        objectArray = new Object[n11];
        objectArray2 = this.a;
        objectArray[0] = objectArray2;
        objectArray[n10] = object;
        objectArray[n14] = bluetoothDevice;
        return (BluetoothGatt)constructor.newInstance(objectArray);
    }

    private static Object e(Object object) {
        if (object == null) {
            return null;
        }
        Method method = b.g(object.getClass(), "getBluetoothGatt");
        Object[] objectArray = new Object[]{};
        return method.invoke(object, objectArray);
    }

    private static Object f() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            return null;
        }
        Method method = b.g(bluetoothAdapter.getClass(), "getBluetoothManager");
        Object[] objectArray = new Object[]{};
        return method.invoke(bluetoothAdapter, objectArray);
    }

    private static Method g(Class genericDeclaration, String string2) {
        Class[] classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
        ((Method)genericDeclaration).setAccessible(true);
        return genericDeclaration;
    }

    private static void h(BluetoothGatt bluetoothGatt, boolean bl2) {
        Field field = bluetoothGatt.getClass().getDeclaredField("mAutoConnect");
        field.setAccessible(true);
        field.setBoolean(bluetoothGatt, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public BluetoothGatt a(BluetoothDevice bluetoothDevice, boolean bl2, BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothDevice == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11 && bl2) {
            void var7_14;
            Object[] objectArray;
            block24: {
                Object object;
                block23: {
                    Object object2;
                    block22: {
                        block21: {
                            bl2 = true;
                            n10 = 0;
                            objectArray = null;
                            object = "Trying to connectGatt using reflection.";
                            object2 = new Object[]{};
                            p.s((String)object, object2);
                            object = b.f();
                            object = b.e(object);
                            if (object != null) break block21;
                            object = "Couldn't get iBluetoothGatt object";
                            object2 = new Object[]{};
                            p.u((String)object, object2);
                            return this.b(bluetoothGattCallback, bluetoothDevice, bl2);
                        }
                        object = this.d(object, bluetoothDevice);
                        if (object != null) break block22;
                        object = "Couldn't create BluetoothGatt object";
                        object2 = new Object[]{};
                        p.u((String)object, object2);
                        return this.b(bluetoothGattCallback, bluetoothDevice, bl2);
                    }
                    boolean bl3 = b.c((BluetoothGatt)object, bluetoothGattCallback, bl2);
                    if (bl3) break block23;
                    object2 = "Connection using reflection failed, closing gatt";
                    Object[] objectArray2 = new Object[]{};
                    try {
                        p.u((String)object2, objectArray2);
                        object.close();
                    }
                    catch (NoSuchFieldException noSuchFieldException) {
                        break block24;
                    }
                    catch (InstantiationException instantiationException) {
                        break block24;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        break block24;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        break block24;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        break block24;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        // empty catch block
                    }
                }
                return object;
            }
            objectArray = new Object[]{};
            p.v((Throwable)var7_14, "Error while trying to connect via reflection", objectArray);
            return this.b(bluetoothGattCallback, bluetoothDevice, bl2);
        }
        return this.b(bluetoothGattCallback, bluetoothDevice, bl2);
    }
}

