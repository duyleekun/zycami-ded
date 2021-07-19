/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjm;
import com.google.android.gms.internal.vision.zzjn;
import java.io.IOException;

public abstract class zzgh
implements zzjm {
    public /* synthetic */ Object clone() {
        return this.zzeh();
    }

    public abstract zzgh zza(zzge var1);

    public abstract zzgh zza(zzhe var1, zzho var2);

    public zzgh zza(byte[] object, int n10, int n11, zzho object2) {
        RuntimeException runtimeException = null;
        object = zzhe.zza((byte[])object, 0, n11, false);
        this.zza((zzhe)object, (zzho)object2);
        try {
            ((zzhe)object).zzax(0);
            return this;
        }
        catch (IOException iOException) {
            String string2 = "byte array";
            object2 = this.getClass().getName();
            int n12 = String.valueOf(object2).length() + 60;
            int n13 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n12 += n13);
            stringBuilder.append("Reading ");
            stringBuilder.append((String)object2);
            stringBuilder.append(" from a ");
            stringBuilder.append(string2);
            stringBuilder.append(" threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            runtimeException = new RuntimeException(string2, iOException);
            throw runtimeException;
        }
        catch (zzin zzin2) {
            throw zzin2;
        }
    }

    public final /* synthetic */ zzjm zza(zzjn object) {
        Class<?> clazz = this.zzgx().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            object = (zzge)object;
            return this.zza((zzge)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public abstract zzgh zzeh();
}

