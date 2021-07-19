/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.bluetooth.le.ScanResult
 *  android.bluetooth.le.ScanSettings
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package d.n.a.q0.v;

import android.app.PendingIntent;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.os.Build;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.n.a.q0.p;
import d.n.a.q0.v.a;
import d.n.a.q0.v.g;
import d.n.a.q0.v.i;
import d.n.a.q0.v.k;
import d.n.a.q0.x.y;
import d.n.a.r0.b;
import d.n.a.r0.d;
import d.n.a.r0.e;
import java.util.ArrayList;
import java.util.List;

public class c
implements d.n.a.r0.a {
    private static final int e;
    private final y a;
    private final a b;
    private final g c;
    private final i d;

    public c(y y10, a a10, g g10, i i10) {
        this.a = y10;
        this.b = a10;
        this.c = g10;
        this.d = i10;
    }

    private d d(int n10, ScanResult scanResult) {
        i i10 = this.d;
        k k10 = this.c.a(n10, scanResult);
        return i10.a(k10);
    }

    private static List e(Intent intent) {
        return (List)((Object)intent.getSerializableExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT"));
    }

    public void a(PendingIntent objectArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            objectArray = new Object[]{};
            p.u("PendingIntent based scanning is available for Android O and higher only.", objectArray);
            return;
        }
        Object[] objectArray2 = this.a;
        n10 = (int)(objectArray2.d() ? 1 : 0);
        if (n10 == 0) {
            objectArray = new Object[]{};
            p.u("PendingIntent based scanning is available only when Bluetooth is ON.", objectArray);
            return;
        }
        objectArray2 = new Object[]{};
        p.k("Stopping pending intent based scan.", objectArray2);
        this.a.h((PendingIntent)objectArray);
    }

    public List b(Intent object) {
        String string2 = "android.bluetooth.le.extra.CALLBACK_TYPE";
        int n10 = object.getIntExtra(string2, -1);
        Object object2 = "android.bluetooth.le.extra.ERROR_CODE";
        int n11 = object.getIntExtra((String)object2, 0);
        object = d.n.a.q0.v.c.e((Intent)object);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (n11 == 0) {
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (ScanResult)object.next();
                object2 = this.d(n10, (ScanResult)object2);
                arrayList.add(object2);
            }
            return arrayList;
        }
        object = new BleScanException(n11);
        throw object;
    }

    public void c(PendingIntent objectArray, e object, b ... object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            objectArray = new Object[]{};
            p.u("PendingIntent based scanning is available for Android O and higher only.", objectArray);
            return;
        }
        Object object3 = this.a;
        n10 = (int)(((y)object3).d() ? 1 : 0);
        if (n10 != 0) {
            object3 = new Object[]{};
            String string2 = "Requesting pending intent based scan.";
            p.k(string2, (Object[])object3);
            object2 = this.b.c((b)object2);
            object = this.b.d((e)object);
            object3 = this.a;
            int n12 = ((y)object3).e((List)object2, (ScanSettings)object, (PendingIntent)objectArray);
            if (n12 == 0) {
                return;
            }
            object = new BleScanException(n12);
            objectArray = new Object[]{};
            p.v((Throwable)object, "Failed to start scan", objectArray);
            throw object;
        }
        objectArray = new Object[]{};
        p.u("PendingIntent based scanning is available only when Bluetooth is ON.", objectArray);
        objectArray = new BleScanException(1);
        throw objectArray;
    }
}

