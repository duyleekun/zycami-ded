/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 */
package i.f.b;

import android.app.Activity;
import android.os.Build;
import i.f.b.e;
import java.util.ArrayList;
import java.util.List;

public class d
extends Activity {
    private static final int a = 200;

    public List a() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public void b() {
        boolean bl2;
        Object object = this.a();
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            e e10 = (e)((Object)object.next());
            if (e10 == null) continue;
            e10.r();
        }
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        int n11 = 200;
        if (n10 == n11 && (n11 = nArray.length) > 0 && (n11 = nArray[0]) == 0) {
            this.b();
        }
        super.onRequestPermissionsResult(n10, stringArray, nArray);
    }

    public void onStart() {
        String[] stringArray;
        super.onStart();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (n11 = this.checkSelfPermission((String)(stringArray = "android.permission.CAMERA"))) != 0) {
            stringArray = new String[]{stringArray};
            n11 = 200;
            this.requestPermissions(stringArray, n11);
            n10 = 0;
            stringArray = null;
        } else {
            n10 = 1;
        }
        if (n10 != 0) {
            this.b();
        }
    }
}

