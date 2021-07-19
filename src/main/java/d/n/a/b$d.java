/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothGattDescriptor
 *  android.bluetooth.BluetoothManager
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.location.LocationManager
 *  android.os.Build$VERSION
 */
package d.n.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.internal.serialization.RxBleThreadFactory;
import d.n.a.b$c;
import d.n.a.b$d$a;
import d.n.a.e0;
import d.n.a.g0;
import d.n.a.q0.v.c;
import d.n.a.q0.v.i;
import d.n.a.q0.v.n;
import d.n.a.q0.v.x;
import d.n.a.q0.w.b;
import d.n.a.q0.x.p;
import d.n.a.q0.x.r;
import d.n.a.q0.x.w;
import d.n.a.r0.a;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class b$d {
    public static int A(Context object) {
        PackageManager packageManager;
        try {
            packageManager = object.getPackageManager();
        }
        catch (Throwable throwable) {
            return -1 >>> 1;
        }
        object = object.getPackageName();
        object = packageManager.getApplicationInfo((String)object, 0);
        return object.targetSdkVersion;
    }

    public static BluetoothAdapter f() {
        return BluetoothAdapter.getDefaultAdapter();
    }

    public static h0 g() {
        RxBleThreadFactory rxBleThreadFactory = new RxBleThreadFactory();
        return e.a.a1.a.h(rxBleThreadFactory);
    }

    public static ExecutorService h() {
        return Executors.newSingleThreadExecutor();
    }

    public static h0 i(ExecutorService executorService) {
        return e.a.c1.b.b(executorService);
    }

    public static BluetoothManager j(Context context) {
        return (BluetoothManager)context.getSystemService("bluetooth");
    }

    public static h0 k() {
        return e.a.c1.b.a();
    }

    public static ExecutorService l() {
        return Executors.newCachedThreadPool();
    }

    public static ContentResolver m(Context context) {
        return context.getContentResolver();
    }

    public static int n() {
        return Build.VERSION.SDK_INT;
    }

    public static byte[] o() {
        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
    }

    public static byte[] p() {
        return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
    }

    public static byte[] q() {
        return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
    }

    public static b$c r(ExecutorService executorService, h0 h02, ExecutorService executorService2) {
        b$d$a b$d$a = new b$d$a(executorService, h02, executorService2);
        return b$d$a;
    }

    public static boolean s(Context context, int n10) {
        String string2;
        boolean bl2;
        int n11 = 20;
        if (n10 >= n11 && (bl2 = (context = context.getPackageManager()).hasSystemFeature(string2 = "android.hardware.type.watch"))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public static LocationManager t(Context context) {
        return (LocationManager)context.getSystemService("location");
    }

    public static z u(int n10, p p10) {
        int n11 = 23;
        z z10 = n10 < n11 ? w.b(Boolean.TRUE) : p10.a();
        return z10;
    }

    public static r v(int n10, c.b.a.c c10, c.b.a.c c11) {
        int n11 = 23;
        r r10 = n10 < n11 ? (r)c10.get() : (r)c11.get();
        return r10;
    }

    public static String[] w(int n10, int n11) {
        if ((n10 = Math.min(n10, n11)) < (n11 = 23)) {
            return new String[0];
        }
        n11 = 29;
        String string2 = "android.permission.ACCESS_FINE_LOCATION";
        if (n10 < n11) {
            return new String[]{"android.permission.ACCESS_COARSE_LOCATION", string2};
        }
        return new String[]{string2};
    }

    public static n x(int n10, c.b.a.c c10, c.b.a.c c11) {
        int n11 = 24;
        if (n10 < n11) {
            return (n)c10.get();
        }
        return (n)c11.get();
    }

    public static x z(int n10, c.b.a.c c10, c.b.a.c c11, c.b.a.c c12) {
        int n11 = 21;
        if (n10 < n11) {
            return (x)c10.get();
        }
        int n12 = 23;
        if (n10 < n12) {
            return (x)c11.get();
        }
        return (x)c12.get();
    }

    public abstract a a(c var1);

    public abstract d.n.a.q0.w.a b(b var1);

    public abstract RxBleClient c(g0 var1);

    public abstract z d(e0 var1);

    public abstract h0 e(h0 var1);

    public abstract o y(i var1);
}

