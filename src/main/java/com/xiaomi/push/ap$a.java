/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.xiaomi.push;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.push.ap;
import com.xiaomi.push.ap$b;
import com.xiaomi.push.aq;

public class ap$a
implements ServiceConnection {
    public final /* synthetic */ ap a;

    private ap$a(ap ap2) {
        this.a = ap2;
    }

    public /* synthetic */ ap$a(ap ap2, aq aq2) {
        this(ap2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onServiceConnected(ComponentName object, IBinder object2) {
        int n10 = 2;
        ap ap2 = this.a;
        String string2 = ap$b.a((IBinder)object2);
        ap.a(ap2, string2);
        ap2 = this.a;
        boolean bl2 = ap$b.a((IBinder)object2);
        ap.a(ap2, bl2);
        ap.a(this.a);
        ap.a(this.a, n10);
        object = this.a;
        object2 = ap.a((ap)object);
        // MONITORENTER : object2
        object = this.a;
        object = ap.a((ap)object);
        object.notifyAll();
        return;
        catch (Throwable throwable) {
            ap.a(this.a);
            ap.a(this.a, n10);
            object = this.a;
            Object object3 = ap.a((ap)object);
            // MONITORENTER : object3
            try {
                object = this.a;
                object = ap.a((ap)object);
                object.notifyAll();
                throw throwable;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
            catch (Exception exception) {}
            throw throwable;
        }
        catch (Exception exception) {
            ap.a(this.a);
            object2 = this.a;
            ap.a((ap)object2, n10);
            object = ap.a(this.a);
            // MONITORENTER : object
            object2 = this.a;
            object2 = ap.a((ap)object2);
            object2.notifyAll();
            return;
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception2) {}
            {
                // MONITOREXIT : object2
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception3) {}
            {
                // MONITOREXIT : object
                return;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

