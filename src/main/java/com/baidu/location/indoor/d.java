/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothManager
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package com.baidu.location.indoor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.indoor.d$a;
import com.baidu.location.indoor.d$b;
import com.baidu.location.indoor.e;
import com.baidu.location.indoor.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class d {
    private static final char[] a;
    private static d b;
    private Context c;
    private boolean d = false;
    private boolean e = false;
    private BluetoothAdapter f;
    private boolean g = false;
    private d$b h;
    private boolean i = false;
    private String j;
    private long k;
    private HashMap l;
    private Handler m;
    private Runnable n;
    private Object o;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        a = cArray;
        b = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private d(Context object) {
        Handler handler;
        HashMap hashMap;
        long l10;
        int n10 = 0;
        this.j = null;
        this.k = l10 = (long)-1;
        this.l = hashMap = new HashMap();
        this.m = handler = new Handler();
        e e10 = new e(this);
        this.n = e10;
        this.o = null;
        this.c = object;
        BluetoothAdapter bluetoothAdapter = this.f;
        if (bluetoothAdapter != null) return;
        try {
            BluetoothAdapter bluetoothAdapter2;
            n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 > n11) {
                boolean bl2;
                BluetoothAdapter bluetoothAdapter3;
                String string2 = "bluetooth";
                Object object2 = object.getSystemService(string2);
                BluetoothManager bluetoothManager = (BluetoothManager)object2;
                this.f = bluetoothAdapter3 = bluetoothManager.getAdapter();
                Context context = this.c;
                PackageManager packageManager = context.getPackageManager();
                String string3 = "android.hardware.bluetooth_le";
                this.g = bl2 = packageManager.hasSystemFeature(string3);
                return;
            }
            this.f = bluetoothAdapter2 = BluetoothAdapter.getDefaultAdapter();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static d a(Context context) {
        d d10 = b;
        if (d10 == null) {
            b = d10 = new d(context);
        }
        return b;
    }

    private String a(List list, int n10) {
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(list);
        String string2 = ((d$a)list.get(0)).toString();
        stringBuilder.append(string2);
        for (int i10 = 1; i10 < (n11 = list.size()) && i10 < n10; ++i10) {
            stringBuilder.append("|");
            String string3 = ((d$a)list.get(i10)).toString();
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public static String a(byte[] object) {
        int n10;
        int n11 = ((byte[])object).length * 2;
        char[] cArray = new char[n11];
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); ++i10) {
            n10 = object[i10] & 0xFF;
            int n12 = i10 * 2;
            char[] cArray2 = a;
            int n13 = n10 >>> 4;
            cArray[n12] = n13 = cArray2[n13];
            n10 &= 0xF;
            cArray[++n12] = n10 = cArray2[n10];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static /* synthetic */ HashMap a(d d10) {
        return d10.l;
    }

    public static /* synthetic */ void a(d d10, HashMap hashMap) {
        d10.a(hashMap);
    }

    private void a(HashMap object) {
        int n10;
        int n11;
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        int n12;
        int n13;
        object = ((HashMap)object).values();
        Iterator iterator2 = new Iterator(object);
        object = new ArrayList();
        Object object5 = new HashMap();
        Object object6 = new HashMap();
        HashMap<Object, ScanResult> hashMap = new HashMap<Object, ScanResult>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        iterator2 = iterator2.iterator();
        while (true) {
            n13 = iterator2.hasNext();
            n12 = 1;
            if (n13 == 0) break;
            object4 = (ScanResult)iterator2.next();
            object3 = object4.getDevice().getAddress();
            String string2 = ":";
            String string3 = "";
            object3 = ((String)object3).replaceAll(string2, string3);
            int n14 = object4.getRssi();
            long l10 = object4.getTimestampNanos();
            object2 = new d$a((String)object3, n14, l10);
            arrayList.add(object2);
            bl2 = this.d;
            if (!bl2) continue;
            object4.getScanRecord().getAdvertiseFlags();
            object2 = object4.getScanRecord().getBytes();
            n11 = ((Object)object2).length;
            n14 = 26;
            if (n11 < n14) continue;
            n11 = 25;
            n14 = 9;
            object3 = com.baidu.location.indoor.d.a(Arrays.copyOfRange((byte[])object2, n14, n11));
            object.add(object3);
            object4 = object4.getDevice().getName();
            ((HashMap)object5).put(object3, object4);
            object4 = com.baidu.location.indoor.d.a(Arrays.copyOfRange((byte[])object2, 0, n14));
            ((HashMap)object6).put(object3, object4);
            object4 = hashMap.get(object3);
            if (object4 == null) {
                object4 = 0;
                hashMap.put(object3, (ScanResult)object4);
            }
            n13 = (Integer)hashMap.get(object3) + n12;
            object4 = n13;
            hashMap.put(object3, (ScanResult)object4);
        }
        int n15 = 0;
        object = null;
        iterator2 = hashMap.keySet().iterator();
        n13 = 0;
        object4 = null;
        while (bl2 = iterator2.hasNext()) {
            object2 = (String)iterator2.next();
            object3 = (Integer)hashMap.get(object2);
            n11 = (Integer)object3;
            if (n11 <= n13) continue;
            n13 = (Integer)hashMap.get(object2);
            object = object2;
        }
        int n16 = 3;
        if (n13 > n16) {
            n10 = n12;
        } else {
            n10 = 0;
            hashMap = null;
        }
        object4 = this.h;
        if (object4 != null && (bl2 = this.d)) {
            object5 = (String)((HashMap)object5).get(object);
            object6 = (String)((HashMap)object6).get(object);
            object4.a(n10 != 0, (String)object, (String)object5, (String)object6);
            this.d = false;
        }
        if ((n15 = arrayList.size()) > n16) {
            long l11;
            n15 = 32;
            this.j = object = this.a(arrayList, n15);
            this.k = l11 = System.currentTimeMillis();
        }
        if ((n15 = (int)(this.i ? 1 : 0)) != 0) {
            this.a(n12 != 0);
        }
    }

    public static /* synthetic */ BluetoothAdapter b(d d10) {
        return d10.f;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean h() {
        Object object;
        Object object2;
        Object object3;
        block11: {
            block10: {
                BufferedReader bufferedReader;
                Object object4;
                object3 = "";
                object2 = this.c.getCacheDir();
                object = new File((File)object2, "ibct");
                boolean bl2 = ((File)object).exists();
                if (!bl2) {
                    return false;
                }
                bl2 = false;
                object2 = null;
                try {
                    object4 = new FileReader((File)object);
                    bufferedReader = new BufferedReader((Reader)object4);
                    object = null;
                    object2 = object3;
                }
                catch (Exception exception) {
                    File file = object2;
                    object2 = exception;
                    object = file;
                    break block10;
                }
                try {
                    while ((object = bufferedReader.readLine()) != null) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append((String)object2);
                        ((StringBuilder)object4).append((String)object);
                        object2 = ((StringBuilder)object4).toString();
                    }
                }
                catch (Exception exception) {
                    break block10;
                }
                {
                    bufferedReader.close();
                    break block11;
                }
            }
            ((Throwable)object2).printStackTrace();
            object2 = object;
        }
        if (object2 == null) return false;
        object = ((String)object2).trim();
        int n10 = ((String)object).equals(object3);
        if (n10 != 0) {
            return false;
        }
        try {
            object3 = Long.valueOf((String)object2);
            long l10 = (Long)object3;
            long l11 = System.currentTimeMillis() - l10;
            l10 = 259200L;
            n10 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (n10 >= 0) return false;
            return true;
        }
        catch (Exception exception) {}
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void i() {
        Object object = this.c.getCacheDir();
        String string2 = "ibct";
        Object object2 = new File((File)object, string2);
        try {
            object = new FileWriter((File)object2);
        }
        catch (Exception exception) {
            return;
        }
        object2 = new StringBuilder();
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        string2 = "";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((Writer)object).write((String)object2);
        ((OutputStreamWriter)object).flush();
        ((OutputStreamWriter)object).close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object = this.f;
        if (object == null) {
            return;
        }
        try {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 < n11) return;
            if (bl2) {
                f f10 = new f(this);
                this.o = f10;
                f10 = this.f;
                f10 = f10.getBluetoothLeScanner();
                object = this.o;
                object = (ScanCallback)object;
                f10.startScan((ScanCallback)object);
                f10 = this.m;
                object = this.n;
                long l10 = 3000L;
                f10.postDelayed((Runnable)object, l10);
                bl2 = true;
            } else {
                d$b d$b = this.h;
                if (d$b != null) {
                    d$b = object.getBluetoothLeScanner();
                    object = this.o;
                    object = (ScanCallback)object;
                    d$b.stopScan((ScanCallback)object);
                }
                bl2 = false;
                d$b = null;
            }
            this.d = bl2;
            return;
        }
        catch (Exception exception) {}
    }

    public boolean a() {
        boolean bl2;
        BluetoothAdapter bluetoothAdapter = this.f;
        if (bluetoothAdapter != null && (bl2 = this.g)) {
            try {
                return bluetoothAdapter.isEnabled();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(d$b d$b) {
        boolean bl2 = this.d;
        if (bl2) {
            return false;
        }
        bl2 = this.e;
        if (bl2) {
            return false;
        }
        this.e = bl2 = true;
        boolean bl3 = this.a();
        if (!bl3) {
            return false;
        }
        bl3 = this.h();
        if (bl3) {
            return false;
        }
        this.i();
        this.h = d$b;
        this.a(bl2);
        return bl2;
    }

    public boolean b() {
        boolean bl2 = this.a();
        if (!bl2) {
            return false;
        }
        bl2 = true;
        this.a(bl2);
        this.i = bl2;
        return bl2;
    }

    public void c() {
        this.e = false;
        this.d = false;
    }

    public void d() {
        this.i = false;
    }

    public String e() {
        return this.j;
    }

    public long f() {
        return this.k;
    }

    public boolean g() {
        long l10 = System.currentTimeMillis();
        long l11 = this.k;
        long l12 = (l10 -= l11) - (l11 = 20000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

