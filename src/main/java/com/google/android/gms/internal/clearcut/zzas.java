/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbg;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzdo;
import java.io.IOException;

public abstract class zzas
implements zzdo {
    private static boolean zzey = false;
    public int zzex = 0;

    public void zzf(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final zzbb zzr() {
        Object object;
        int n10;
        try {
            n10 = this.zzas();
        }
        catch (IOException iOException) {
            String string2 = "ByteString";
            String string3 = this.getClass().getName();
            int n11 = String.valueOf(string3).length() + 62;
            int n12 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n11 += n12);
            stringBuilder.append("Serializing ");
            stringBuilder.append(string3);
            stringBuilder.append(" to a ");
            stringBuilder.append(string2);
            stringBuilder.append(" threw an IOException (should never happen).");
            string2 = stringBuilder.toString();
            object = new RuntimeException(string2, iOException);
            throw object;
        }
        zzbg zzbg2 = zzbb.zzk(n10);
        object = zzbg2.zzae();
        this.zzb((zzbn)object);
        return zzbg2.zzad();
    }

    public int zzs() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

