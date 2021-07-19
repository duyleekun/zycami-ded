/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.app;

import android.util.Log;
import androidx.core.app.ActivityRecreator;
import java.lang.reflect.Method;

public class ActivityRecreator$3
implements Runnable {
    public final /* synthetic */ Object val$activityThread;
    public final /* synthetic */ Object val$token;

    public ActivityRecreator$3(Object object, Object object2) {
        this.val$activityThread = object;
        this.val$token = object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = Boolean.FALSE;
        try {
            Object object2;
            Method method = ActivityRecreator.performStopActivity3ParamsMethod;
            int n10 = 1;
            int n11 = 2;
            if (method != null) {
                Object object3;
                Object object4 = this.val$activityThread;
                int n12 = 3;
                Object[] objectArray = new Object[n12];
                objectArray[0] = object3 = this.val$token;
                objectArray[n10] = object;
                objectArray[n11] = object = "AppCompat recreation";
                method.invoke(object4, objectArray);
                return;
            }
            method = ActivityRecreator.performStopActivity2ParamsMethod;
            Object object5 = this.val$activityThread;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object2 = this.val$token;
            objectArray[n10] = object;
            method.invoke(object5, objectArray);
            return;
        }
        catch (Throwable throwable) {
            String string2 = "ActivityRecreator";
            String string3 = "Exception while invoking performStopActivity";
            Log.e((String)string2, (String)string3, (Throwable)throwable);
            return;
        }
        catch (RuntimeException runtimeException) {
            Object object6 = runtimeException.getClass();
            Object object7 = RuntimeException.class;
            if (object6 != object7) return;
            object6 = runtimeException.getMessage();
            if (object6 == null) return;
            object6 = runtimeException.getMessage();
            boolean bl2 = ((String)object6).startsWith((String)(object7 = "Unable to stop"));
            if (bl2) throw runtimeException;
            return;
        }
    }
}

