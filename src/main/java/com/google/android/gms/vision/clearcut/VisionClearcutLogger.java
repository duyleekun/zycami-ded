/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger$LogEventBuilder;
import com.google.android.gms.internal.vision.zzfd;
import com.google.android.gms.internal.vision.zzfl$zzo;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgh;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.vision.L;

public class VisionClearcutLogger {
    private final ClearcutLogger zzcd;
    private boolean zzce = true;

    public VisionClearcutLogger(Context context) {
        ClearcutLogger clearcutLogger;
        this.zzcd = clearcutLogger = new ClearcutLogger(context, "VISION", null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzb(int n10, zzfl$zzo object) {
        int n11;
        object = ((zzge)object).toByteArray();
        int n12 = 1;
        if (n10 >= 0 && n10 <= (n11 = 3)) {
            n11 = (int)(this.zzce ? 1 : 0);
            if (n11 != 0) {
                ClearcutLogger clearcutLogger = this.zzcd;
                object = clearcutLogger.newEvent((byte[])object);
                ClearcutLogger$LogEventBuilder clearcutLogger$LogEventBuilder = ((ClearcutLogger$LogEventBuilder)object).setEventCode(n10);
                clearcutLogger$LogEventBuilder.log();
                return;
            }
            Object object2 = zzfl$zzo.zzec();
            {
                catch (Exception exception) {
                    zzfd.zza(exception);
                    object = new Object[]{};
                    L.e(exception, "Failed to log", (Object[])object);
                    return;
                }
                try {
                    zzho zzho2 = zzho.zzgg();
                    int n13 = ((Object[])object).length;
                    ((zzgh)object2).zza((byte[])object, 0, n13, zzho2);
                    object = "Would have logged:\n%s";
                    Object[] objectArray = new Object[n12];
                    objectArray[0] = object2 = object2.toString();
                    L.e((String)object, objectArray);
                    return;
                }
                catch (Exception exception) {}
                object = "Parsing error";
                {
                    Object[] objectArray = new Object[]{};
                    L.e(exception, (String)object, objectArray);
                    return;
                }
            }
        }
        object = new Object[n12];
        Integer n14 = n10;
        object[0] = n14;
        L.i("Illegal event code: %d", (Object[])object);
    }
}

