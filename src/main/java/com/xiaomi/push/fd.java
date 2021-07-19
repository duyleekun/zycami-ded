/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.fc$a;
import com.xiaomi.push.fy;
import com.xiaomi.push.service.at;
import java.lang.reflect.Method;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fd
implements fc$a {
    private volatile long a;
    private PendingIntent a;
    public Context a = 0L;

    public fd(Context context) {
        this.a = context;
    }

    private void a(AlarmManager alarmManager, long l10, PendingIntent pendingIntent) {
        Object object = AlarmManager.class;
        Object[] objectArray = "setExact";
        int n10 = 3;
        Class[] classArray = new Class[n10];
        Class<Number> clazz = Integer.TYPE;
        classArray[0] = clazz;
        clazz = Long.TYPE;
        int n11 = 1;
        classArray[n11] = clazz;
        clazz = PendingIntent.class;
        int n12 = 2;
        classArray[n12] = clazz;
        object = ((Class)object).getMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        Integer n13 = 0;
        objectArray[0] = n13;
        Long l11 = l10;
        objectArray[n11] = l11;
        objectArray[n12] = pendingIntent;
        try {
            ((Method)object).invoke(alarmManager, objectArray);
        }
        catch (Exception exception) {
            b.a(exception);
        }
    }

    public long a() {
        return fy.b();
    }

    public void a() {
        String string2 = "unregister timer";
        PendingIntent pendingIntent = this.a;
        long l10 = 0L;
        if (pendingIntent != null) {
            pendingIntent = (AlarmManager)this.a.getSystemService("alarm");
            PendingIntent pendingIntent2 = this.a;
            try {
                pendingIntent.cancel(pendingIntent2);
            }
            catch (Throwable throwable) {
                this.a = null;
                b.c(string2);
                this.a = l10;
                throw throwable;
            }
            catch (Exception exception) {}
            this.a = null;
            b.c(string2);
            this.a = l10;
        }
        this.a = l10;
    }

    public void a(Intent object, long l10) {
        AlarmManager alarmManager = (AlarmManager)this.a.getSystemService("alarm");
        Object object2 = this.a;
        Long l11 = null;
        object = PendingIntent.getBroadcast((Context)object2, (int)0, (Intent)object, (int)0);
        this.a = object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            int n12 = 3;
            object = new Object[n12];
            object2 = 0;
            object[0] = object2;
            l11 = l10;
            object[1] = l11;
            n10 = 2;
            l11 = this.a;
            object[n10] = l11;
            object2 = "setExactAndAllowWhileIdle";
            ba.a((Object)alarmManager, (String)object2, (Object[])object);
        } else {
            n11 = 19;
            if (n10 >= n11) {
                this.a(alarmManager, l10, (PendingIntent)object);
            } else {
                alarmManager.set(0, l10, (PendingIntent)object);
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("register timer ");
        ((StringBuilder)object).append(l10);
        b.c(((StringBuilder)object).toString());
    }

    public void a(boolean object) {
        long l10;
        block3: {
            long l11;
            block4: {
                block2: {
                    long l12;
                    long l13;
                    long l14;
                    long l15;
                    l10 = this.a();
                    l11 = 0L;
                    if (object == 0 && (l15 = (l14 = (l13 = this.a) - l11) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
                        return;
                    }
                    if (object != 0) {
                        this.a();
                    }
                    if (object != 0 || (object = (l12 = (l13 = this.a) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0) break block2;
                    l11 = this.a + l10;
                    this.a = l11;
                    l11 = this.a;
                    l13 = System.currentTimeMillis();
                    long l16 = l11 - l13;
                    object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object >= 0) break block3;
                    break block4;
                }
                l11 = SystemClock.elapsedRealtime() % l10;
                l10 -= l11;
            }
            this.a = l11 = System.currentTimeMillis() + l10;
        }
        String string2 = at.o;
        Intent intent = new Intent(string2);
        string2 = this.a.getPackageName();
        intent.setPackage(string2);
        l10 = this.a;
        this.a(intent, l10);
    }

    public boolean a() {
        long l10 = this.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

