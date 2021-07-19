/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 */
package d.n.a.q0.x;

import android.content.Context;
import android.os.Process;

public class i {
    private final Context a;
    private final String[] b;

    public i(Context context, String[] stringArray) {
        this.a = context;
        this.b = stringArray;
    }

    private boolean b(String object) {
        if (object != null) {
            int n10;
            Context context = this.a;
            int n11 = Process.myPid();
            int n12 = context.checkPermission((String)object, n11, n10 = Process.myUid());
            if (!n12) {
                n12 = 1;
            } else {
                n12 = 0;
                object = null;
            }
            return n12 != 0;
        }
        object = new IllegalArgumentException("permission is null");
        throw object;
    }

    public String[] a() {
        return this.b;
    }

    public boolean c() {
        boolean bl2;
        String[] stringArray = this.b;
        int n10 = stringArray.length;
        boolean bl3 = false;
        int n11 = 0;
        while (true) {
            bl2 = true;
            if (n11 >= n10) break;
            String string2 = stringArray[n11];
            boolean bl4 = this.b(string2);
            if (bl4) {
                return bl2;
            }
            ++n11;
        }
        stringArray = this.b;
        int n12 = stringArray.length;
        if (n12 == 0) {
            bl3 = bl2;
        }
        return bl3;
    }
}

