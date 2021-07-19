/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.text.TextUtils
 */
package l.a.q.g0;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;
import l.a.q.g0.q$a;
import l.a.q.g0.q$b;

public class q {
    private boolean a(Context object, String string2) {
        object = object.getAssets();
        int n10 = 1;
        try {
            object.open(string2);
            return n10 != 0;
        }
        catch (Exception exception) {
            block9: {
                int n11;
                String string3 = "/";
                try {
                    n11 = string2.endsWith(string3);
                    if (n11 == 0) break block9;
                }
                catch (Exception exception2) {
                    return false;
                }
                n11 = string2.length() - n10;
                string2 = string2.substring(0, n11);
            }
            String string4 = "";
            object = object.list(string4);
            object = Arrays.asList(object);
            return object.contains(string2);
        }
    }

    public void b(Context object, String string2, q$a objectArray) {
        Object object2 = new File(string2);
        boolean bl2 = object2.exists();
        boolean bl3 = this.a((Context)object, string2);
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl4 && (bl2 || bl3)) {
            object2 = new q$b(this, (Context)object, bl2, bl3, (q$a)objectArray);
            object = AsyncTask.THREAD_POOL_EXECUTOR;
            int n10 = 1;
            objectArray = new String[n10];
            objectArray[0] = string2;
            object2.executeOnExecutor((Executor)object, objectArray);
        }
    }
}

