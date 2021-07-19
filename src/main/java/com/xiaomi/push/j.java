/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Looper
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.xiaomi.push.j$a;
import com.xiaomi.push.j$b;
import com.xiaomi.push.j$c;
import java.io.IOException;

public final class j {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static j$a a(Context object) {
        block9: {
            Object object2;
            Object object3 = Looper.myLooper();
            if (object3 == (object2 = Looper.getMainLooper())) {
                object = new IllegalStateException("Cannot be called from the main thread");
                throw object;
            }
            object3 = object.getPackageManager();
            object2 = "com.android.vending";
            object3.getPackageInfo((String)object2, 0);
            object3 = new j$b(null);
            object2 = new Intent("com.google.android.gms.ads.identifier.service.START");
            Object object4 = "com.google.android.gms";
            object2.setPackage((String)object4);
            int n10 = 1;
            boolean bl2 = object.bindService((Intent)object2, (ServiceConnection)object3, n10);
            if (bl2) {
                Throwable throwable2222222;
                block8: {
                    block7: {
                        object2 = ((j$b)object3).a();
                        if (object2 == null) break block7;
                        object4 = new j$c((IBinder)object2);
                        object4 = ((j$c)object4).a();
                        object2 = new j$a((String)object4, false);
                        {
                            catch (Throwable throwable2222222) {
                                break block8;
                            }
                            catch (Exception exception) {}
                            {
                                throw exception;
                            }
                        }
                        object.unbindService((ServiceConnection)object3);
                        return object2;
                    }
                    object.unbindService((ServiceConnection)object3);
                    break block9;
                }
                object.unbindService((ServiceConnection)object3);
                throw throwable2222222;
            }
        }
        object = new IOException("Google Play connection failed");
        throw object;
    }
}

