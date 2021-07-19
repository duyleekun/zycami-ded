/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothManager
 *  android.bluetooth.le.ScanCallback
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.ParcelUuid
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BHelper$1;
import com.mob.tools.utils.BHelper$2;
import com.mob.tools.utils.BHelper$3;
import com.mob.tools.utils.BHelper$4;
import com.mob.tools.utils.BHelper$5;
import com.mob.tools.utils.BHelper$6;
import com.mob.tools.utils.BHelper$7;
import com.mob.tools.utils.BHelper$BOperationCallback;
import com.mob.tools.utils.BHelper$BScanCallback;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BHelper {
    private static final String TAG = "BHelper";
    private static BHelper instance;
    private Map bOperationCallbackMap;
    private BroadcastReceiver bOperationReceiver;
    private boolean bOperationRegistered = false;
    private BroadcastReceiver bScanReceiver;
    private boolean bScanRegistered = false;
    private Context context;
    private boolean mScanning = false;

    private BHelper(Context context) {
        this.context = context = context.getApplicationContext();
    }

    public static /* synthetic */ Map access$000(BHelper bHelper) {
        return bHelper.bOperationCallbackMap;
    }

    public static /* synthetic */ HashMap access$100(BHelper bHelper, BluetoothDevice bluetoothDevice) {
        return bHelper.parseDevice2Map(bluetoothDevice);
    }

    public static /* synthetic */ boolean access$202(BHelper bHelper, boolean bl2) {
        bHelper.mScanning = bl2;
        return bl2;
    }

    private BluetoothAdapter getBAdapter() {
        Object object;
        Object object2;
        int n10;
        block8: {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 < n11) break block8;
            object2 = this.context;
            object2 = DeviceHelper.getInstance((Context)object2);
            object = "bluetooth";
            object2 = ((DeviceHelper)object2).getSystemServiceSafe((String)object);
            object2 = (BluetoothManager)object2;
            object2 = object2.getAdapter();
        }
        try {
            object2 = BluetoothAdapter.getDefaultAdapter();
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = throwable.getMessage();
            charSequence.append((String)objectArray);
            charSequence.append("");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(throwable, (Object)charSequence, objectArray);
            n10 = 0;
            object2 = null;
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static BHelper getInstance(Context context) {
        Object object = instance;
        if (object != null) return instance;
        object = BHelper.class;
        synchronized (object) {
            BHelper bHelper = instance;
            if (bHelper != null) return instance;
            instance = bHelper = new BHelper(context);
            return instance;
        }
    }

    private HashMap parseDevice2Map(BluetoothDevice object) {
        HashMap<Object, Object> hashMap;
        block30: {
            ArrayList<Object> arrayList;
            block31: {
                int n10;
                Object object2;
                int n11;
                int n12;
                block29: {
                    hashMap = new HashMap<Object, Object>();
                    if (object == null) break block30;
                    arrayList = "name";
                    Object object3 = object.getName();
                    hashMap.put(arrayList, object3);
                    arrayList = "address";
                    object3 = object.getAddress();
                    hashMap.put(arrayList, object3);
                    arrayList = "bondState";
                    n12 = object.getBondState();
                    object3 = n12;
                    hashMap.put(arrayList, object3);
                    arrayList = object.getBluetoothClass();
                    n12 = arrayList.getMajorDeviceClass();
                    n11 = arrayList.getDeviceClass();
                    object2 = "majorClass";
                    object3 = n12;
                    hashMap.put(object2, object3);
                    object3 = "deviceClass";
                    arrayList = n11;
                    hashMap.put(object3, arrayList);
                    n11 = Build.VERSION.SDK_INT;
                    n12 = 18;
                    if (n11 < n12) break block29;
                    object3 = "type";
                    n10 = object.getType();
                    object2 = n10;
                    hashMap.put(object3, object2);
                }
                if (n11 < (n12 = 15)) break block30;
                n11 = object.getBondState();
                n12 = 12;
                if (n11 != n12) break block30;
                arrayList = new ArrayList<Object>();
                object = object.getUuids();
                if (object == null) break block31;
                n12 = ((ParcelUuid[])object).length;
                if (n12 <= 0) break block31;
                n12 = ((ParcelUuid[])object).length;
                object2 = null;
                for (n10 = 0; n10 < n12; ++n10) {
                    Object object4 = object[n10];
                    if (object4 == null) continue;
                    UUID uUID = object4.getUuid();
                    if (uUID == null) continue;
                    object4 = object4.getUuid();
                    object4 = ((UUID)object4).toString();
                    arrayList.add(object4);
                }
            }
            object = "uuids";
            try {
                hashMap.put(object, arrayList);
            }
            catch (Throwable throwable) {
                arrayList = MobLog.getInstance();
                ((NLog)((Object)arrayList)).d(throwable);
            }
        }
        return hashMap;
    }

    /*
     * Unable to fully structure code
     */
    public void findLE(int var1_1, BluetoothAdapter var2_2, BHelper$BScanCallback var3_3) {
        block32: {
            block34: {
                block35: {
                    block33: {
                        var4_4 = null;
                        var5_5 = this.context;
                        var5_5 = DeviceHelper.getInstance((Context)var5_5);
                        var6_6 = "android.permission.BLUETOOTH";
                        var7_7 = var5_5.checkPermission(var6_6);
                        if (var7_7 == 0) break block32;
                        var5_5 = this.context;
                        var5_5 = DeviceHelper.getInstance((Context)var5_5);
                        var6_6 = "android.permission.BLUETOOTH_ADMIN";
                        var7_7 = var5_5.checkPermission(var6_6);
                        if (var7_7 == 0) break block32;
                        var7_7 = var2_2.isEnabled();
                        if (var7_7 != 0) ** GOTO lbl26
                        var8_8 = new ArrayList<E>();
                        var3_3.onScan(var8_8);
                        return;
lbl26:
                        // 1 sources

                        var7_7 = this.mScanning;
                        if (var7_7 == 0) break block33;
                        var8_8 = new ArrayList<E>();
                        var3_3.onScan(var8_8);
                        return;
                    }
                    if (var1_1 <= 0) {
                        var1_1 = 6;
                    }
                    var7_7 = Build.VERSION.SDK_INT;
                    var9_11 = 18;
                    if (var7_7 < var9_11) break block34;
                    var10_12 = new ArrayList<E>();
                    var9_11 = 21;
                    var11_13 = true;
                    if (var7_7 >= var9_11) break block35;
                    var12_14 = new BHelper$4(this, var10_12);
                    this.mScanning = var11_13;
                    var2_2.startLeScan((BluetoothAdapter.LeScanCallback)var12_14);
                    var13_16 = var2_2;
                    var5_5 = new BHelper$5(this, (BluetoothAdapter)var2_2, var12_14, var3_3, var10_12);
                    var2_2 = MobHandlerThread.newHandler((Handler.Callback)var5_5);
                    var14_18 = var1_1 *= 1000;
                    var2_2.sendEmptyMessageDelayed(0, var14_18);
                }
                var12_15 = new BHelper$6(this, var10_12);
                var13_17 = var2_2.getBluetoothLeScanner();
                this.mScanning = var11_13;
                var13_17.startScan((ScanCallback)var12_15);
                var2_2 = new BHelper$7(this, var13_17, var12_15, var3_3, var10_12);
                var2_2 = MobHandlerThread.newHandler((Handler.Callback)var2_2);
                var14_19 = var1_1 *= 1000;
                var2_2.sendEmptyMessageDelayed(0, var14_19);
            }
            this.findLEAndClassic(var1_1, var3_3);
        }
        var8_8 = new ArrayList<E>();
        try {
            var3_3.onScan(var8_8);
        }
        catch (Throwable var8_9) {
            var2_2 = MobLog.getInstance();
            var5_5 = new StringBuilder();
            var6_6 = var8_9.getMessage();
            var5_5.append(var6_6);
            var6_6 = "";
            var5_5.append(var6_6);
            var5_5 = var5_5.toString();
            var4_4 = new Object[]{};
            var2_2.d(var8_9, var5_5, var4_4);
            var8_10 = new ArrayList<E>();
            var3_3.onScan(var8_10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void findLEAndClassic(int var1_1, BHelper$BScanCallback var2_2) {
        block37: {
            block38: {
                var3_3 = null;
                var4_4 = this.context;
                var4_4 = DeviceHelper.getInstance((Context)var4_4);
                var5_5 = "android.permission.BLUETOOTH";
                var6_6 = var4_4.checkPermission((String)var5_5);
                if (!var6_6) break block37;
                var4_4 = this.context;
                var4_4 = DeviceHelper.getInstance((Context)var4_4);
                var5_5 = "android.permission.BLUETOOTH_ADMIN";
                var6_6 = var4_4.checkPermission((String)var5_5);
                if (!var6_6) break block37;
                var4_4 = this.getBAdapter();
                var7_7 = var4_4.isEnabled();
                if (var7_7) ** GOTO lbl28
                var8_8 = new ArrayList();
                var2_2.onScan((ArrayList)var8_8);
                return;
lbl28:
                // 1 sources

                var7_7 = this.mScanning;
                if (!var7_7) break block38;
                var8_8 = new ArrayList();
                var2_2.onScan((ArrayList)var8_8);
                return;
            }
            if (var1_1 <= 0) {
                var1_1 = 6;
            }
            var5_5 = new BHelper$2(this, (BluetoothAdapter)var4_4);
            var5_5 = MobHandlerThread.newHandler((Handler.Callback)var5_5);
            var9_11 = var1_1 *= 1000;
            var5_5.sendEmptyMessageDelayed(0, var9_11);
            var8_8 = new ArrayList();
            var11_12 /* !! */  = new BHelper$3(this, (ArrayList)var8_8, var2_2, (Handler)var5_5);
            this.bScanReceiver = var11_12 /* !! */ ;
            var8_8 = new IntentFilter();
            var5_5 = "android.bluetooth.device.action.FOUND";
            var8_8.addAction((String)var5_5);
            var5_5 = "android.bluetooth.adapter.action.DISCOVERY_STARTED";
            var8_8.addAction((String)var5_5);
            var5_5 = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
            var8_8.addAction((String)var5_5);
            var5_5 = this.context;
            var11_12 /* !! */  = "registerReceiver";
            var12_13 = 2;
            var13_14 = new Object[var12_13];
            var14_15 = this.bScanReceiver;
            var13_14[0] = var14_15;
            var15_16 = 1;
            var13_14[var15_16] = var8_8;
            var8_8 = new Class[var12_13];
            var16_17 = BroadcastReceiver.class;
            var8_8[0] = var16_17;
            var16_17 = IntentFilter.class;
            var8_8[var15_16] = var16_17;
            ReflectHelper.invokeInstanceMethod(var5_5, var11_12 /* !! */ , var13_14, var8_8);
            this.bScanRegistered = var15_16;
            this.mScanning = var15_16;
            var4_4.startDiscovery();
        }
        var8_8 = new ArrayList();
        try {
            var2_2.onScan((ArrayList)var8_8);
        }
        catch (Throwable var8_9) {
            var4_4 = MobLog.getInstance();
            var5_5 = new StringBuilder();
            var11_12 /* !! */  = var8_9.getMessage();
            var5_5.append(var11_12 /* !! */ );
            var11_12 /* !! */  = "";
            var5_5.append(var11_12 /* !! */ );
            var5_5 = var5_5.toString();
            var3_3 = new Object[]{};
            var4_4.d(var8_9, var5_5, var3_3);
            var8_10 = new ArrayList<E>();
            var2_2.onScan(var8_10);
        }
    }

    public ArrayList getBondedDevice() {
        ArrayList<Object> arrayList;
        block18: {
            String string2;
            Object object;
            arrayList = new ArrayList<Object>();
            Object[] objectArray = null;
            Object object2 = this.context;
            object2 = DeviceHelper.getInstance((Context)object2);
            Object object3 = "android.permission.BLUETOOTH";
            boolean bl2 = ((DeviceHelper)object2).checkPermission((String)object3);
            if (!bl2) break block18;
            object2 = this.getBAdapter();
            object2 = object2.getBondedDevices();
            int n10 = object2.size();
            if (n10 <= 0) break block18;
            try {
                object2 = object2.iterator();
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                object = new StringBuilder();
                string2 = throwable.getMessage();
                ((StringBuilder)object).append(string2);
                string2 = "";
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                objectArray = new Object[]{};
                ((NLog)object3).d(throwable, object, objectArray);
            }
            while (true) {
                block19: {
                    n10 = (int)(object2.hasNext() ? 1 : 0);
                    if (n10 == 0) break block18;
                    object3 = object2.next();
                    object3 = (BluetoothDevice)object3;
                    object = this.parseDevice2Map((BluetoothDevice)object3);
                    string2 = "__currConnected";
                    n10 = (int)(this.isConnectedDevice((BluetoothDevice)object3) ? 1 : 0);
                    if (n10 != 0) {
                        n10 = 1;
                        break block19;
                    }
                    n10 = 0;
                    object3 = null;
                }
                object3 = n10;
                ((HashMap)object).put(string2, object3);
                arrayList.add(object);
                continue;
                break;
            }
        }
        return arrayList;
    }

    public boolean isConnectedDevice(BluetoothDevice object) {
        boolean bl2;
        block10: {
            bl2 = false;
            if (object != null) {
                Object object2 = this.context;
                object2 = DeviceHelper.getInstance((Context)object2);
                Object[] objectArray = "android.permission.BLUETOOTH";
                boolean n10 = ((DeviceHelper)object2).checkPermission((String)objectArray);
                if (!n10) break block10;
                int n11 = 115;
                object2 = Strings.getString(n11);
                objectArray = new Object[]{};
                object = ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
                object = (Boolean)object;
                if (object == null) break block10;
                try {
                    boolean bl3;
                    bl2 = bl3 = ((Boolean)object).booleanValue();
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            }
        }
        return bl2;
    }

    public boolean isEnabled() {
        boolean bl2;
        block7: {
            bl2 = false;
            Object object = this.context;
            object = DeviceHelper.getInstance((Context)object);
            Object object2 = "android.permission.BLUETOOTH";
            boolean bl3 = ((DeviceHelper)object).checkPermission((String)object2);
            if (!bl3) break block7;
            object = this.getBAdapter();
            if (object == null) break block7;
            try {
                bl3 = object.isEnabled();
                if (bl3) {
                    bl2 = true;
                }
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                CharSequence charSequence = new StringBuilder();
                Object[] objectArray = throwable.getMessage();
                charSequence.append((String)objectArray);
                charSequence.append("");
                charSequence = charSequence.toString();
                objectArray = new Object[]{};
                ((NLog)object2).d(throwable, (Object)charSequence, objectArray);
            }
        }
        return bl2;
    }

    public void open() {
        block9: {
            Object object = this.context;
            object = DeviceHelper.getInstance((Context)object);
            Object object2 = "android.permission.BLUETOOTH";
            boolean bl2 = ((DeviceHelper)object).checkPermission((String)object2);
            if (!bl2) break block9;
            object = this.context;
            object = DeviceHelper.getInstance((Context)object);
            object2 = "android.permission.BLUETOOTH_ADMIN";
            bl2 = ((DeviceHelper)object).checkPermission((String)object2);
            if (!bl2) break block9;
            object = this.getBAdapter();
            try {
                object.enable();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                CharSequence charSequence = new StringBuilder();
                Object[] objectArray = throwable.getMessage();
                charSequence.append((String)objectArray);
                charSequence.append("");
                charSequence = charSequence.toString();
                objectArray = new Object[]{};
                ((NLog)object2).d(throwable, (Object)charSequence, objectArray);
            }
        }
    }

    public void registerBOperationReceiver(String objectArray, BHelper$BOperationCallback classArray) {
        if (classArray != null) {
            HashMap<Object[], BHelper$BOperationCallback> hashMap = this.bOperationCallbackMap;
            if (hashMap == null) {
                hashMap = new HashMap();
                this.bOperationCallbackMap = hashMap;
            }
            hashMap = this.bOperationCallbackMap;
            hashMap.put(objectArray, (BHelper$BOperationCallback)classArray);
            objectArray = this.bOperationReceiver;
            if (objectArray == null) {
                objectArray = null;
                classArray = new BHelper$1(this);
                this.bOperationReceiver = classArray;
                classArray = new IntentFilter();
                hashMap = "android.bluetooth.adapter.action.STATE_CHANGED";
                classArray.addAction((String)((Object)hashMap));
                hashMap = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
                classArray.addAction((String)((Object)hashMap));
                hashMap = "android.bluetooth.device.action.ACL_CONNECTED";
                classArray.addAction((String)((Object)hashMap));
                hashMap = "android.bluetooth.device.action.ACL_DISCONNECTED";
                classArray.addAction((String)((Object)hashMap));
                hashMap = this.context;
                CharSequence charSequence = "registerReceiver";
                int n10 = 2;
                Object[] objectArray2 = new Object[n10];
                BroadcastReceiver broadcastReceiver = this.bOperationReceiver;
                objectArray2[0] = broadcastReceiver;
                int n11 = 1;
                objectArray2[n11] = classArray;
                classArray = new Class[n10];
                Class<IntentFilter> clazz = BroadcastReceiver.class;
                classArray[0] = clazz;
                clazz = IntentFilter.class;
                classArray[n11] = clazz;
                ReflectHelper.invokeInstanceMethod((Object)hashMap, (String)charSequence, objectArray2, classArray);
                try {
                    this.bOperationRegistered = n11;
                }
                catch (Throwable throwable) {
                    hashMap = MobLog.getInstance();
                    charSequence = new StringBuilder();
                    clazz = throwable.getMessage();
                    charSequence.append((String)((Object)clazz));
                    clazz = "";
                    charSequence.append((String)((Object)clazz));
                    charSequence = charSequence.toString();
                    objectArray = new Object[]{};
                    ((NLog)((Object)hashMap)).d(throwable, charSequence, objectArray);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unRegisterBOperationReceiver(String object) {
        Object[] objectArray = null;
        try {
            Class<BroadcastReceiver> clazz;
            boolean bl2;
            boolean bl3;
            Map map = this.bOperationCallbackMap;
            if (map != null && !(bl3 = map.containsKey(object))) {
                map = this.bOperationCallbackMap;
                map.remove(object);
            }
            if (!(bl2 = (object = this.bOperationCallbackMap).isEmpty())) return;
            object = this.bOperationReceiver;
            if (object == null) return;
            bl3 = this.bOperationRegistered;
            if (!bl3) return;
            map = this.context;
            String string2 = "unregisterReceiver";
            int n10 = 1;
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = object;
            object = new Class[n10];
            object[0] = clazz = BroadcastReceiver.class;
            ReflectHelper.invokeInstanceMethod((Object)map, string2, objectArray2, (Class[])object);
            this.bOperationRegistered = false;
            bl2 = false;
            object = null;
            this.bOperationReceiver = null;
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = throwable.getMessage();
            stringBuilder.append(string3);
            string3 = "";
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            objectArray = new Object[]{};
            nLog.d(throwable, (Object)string4, objectArray);
        }
    }

    public void unRegisterBScanReceiver() {
        block10: {
            Object[] objectArray = null;
            Class[] classArray = this.bScanReceiver;
            if (classArray == null) break block10;
            boolean bl2 = this.bScanRegistered;
            if (!bl2) break block10;
            NLog nLog = this.context;
            CharSequence charSequence = "unregisterReceiver";
            int n10 = 1;
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = classArray;
            classArray = new Class[n10];
            Object object = BroadcastReceiver.class;
            classArray[0] = object;
            ReflectHelper.invokeInstanceMethod((Object)nLog, (String)charSequence, objectArray2, classArray);
            this.bScanRegistered = false;
            classArray = null;
            try {
                this.bScanReceiver = null;
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                charSequence = new StringBuilder();
                object = throwable.getMessage();
                ((StringBuilder)charSequence).append((String)object);
                object = "";
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray = new Object[]{};
                nLog.d(throwable, (Object)charSequence, objectArray);
            }
        }
    }
}

