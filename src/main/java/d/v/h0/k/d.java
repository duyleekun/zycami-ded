/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package d.v.h0.k;

import android.media.MediaFormat;
import androidx.core.util.Pair;
import d.v.y.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class d {
    private d() {
    }

    public static Pair a(MediaFormat object) {
        ByteBuffer byteBuffer = object.getByteBuffer("csd-0");
        object = object.getByteBuffer("csd-1");
        int n10 = byteBuffer.remaining();
        byte[] byArray = new byte[n10];
        byteBuffer.get(byArray, 0, n10);
        int n11 = ((Buffer)object).remaining();
        byte[] byArray2 = new byte[n11];
        ((ByteBuffer)object).get(byArray2, 0, n11);
        return Pair.create(byArray, byArray2);
    }

    public static byte[] b(MediaFormat object) {
        object = object.getByteBuffer("csd-0");
        int n10 = ((Buffer)object).remaining();
        byte[] byArray = new byte[n10];
        ((ByteBuffer)object).get(byArray, 0, n10);
        return byArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean c(byte[] object) {
        int n10;
        Object object2;
        int n11;
        int n12 = Math.min(((Object)object).length, 512);
        int n13 = 0;
        object = a.h(a.e((byte[])object, 0, n12));
        String string2 = "00,00,00,01,";
        n12 = ((Object)(object = ((String)object).split(string2))).length;
        if (n12 < (n11 = 4)) {
            return false;
        }
        n12 = 1;
        try {
            object2 = object[n12];
            n10 = 2;
        }
        catch (NumberFormatException numberFormatException) {
            return n13 != 0;
        }
        object2 = ((String)object2).substring(0, n10);
        int n14 = 16;
        n11 = Byte.parseByte((String)object2, n14) & 0x1F;
        int n15 = 7;
        if (n11 != n15) return n13 != 0;
        object = object[n10];
        object = ((String)object).substring(0, n10);
        int n16 = Byte.parseByte((String)object, n14) & 0x1F;
        n11 = 8;
        if (n16 != n11) return n13 != 0;
        return n12 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean d(byte[] object) {
        int n10;
        Object object2;
        int n11;
        int n12 = Math.min(((Object)object).length, 512);
        int n13 = 0;
        object = a.h(a.e((byte[])object, 0, n12));
        String string2 = "00,00,00,01,";
        n12 = ((Object)(object = ((String)object).split(string2))).length;
        if (n12 < (n11 = 5)) {
            return false;
        }
        n12 = 1;
        try {
            object2 = object[n12];
            n10 = 2;
        }
        catch (NumberFormatException numberFormatException) {
            return n13 != 0;
        }
        object2 = ((String)object2).substring(0, n10);
        int n14 = 16;
        n11 = (Byte.parseByte((String)object2, n14) & 0x7E) >> n12;
        int n15 = 32;
        if (n11 != n15) return n13 != 0;
        object2 = object[n10];
        object2 = ((String)object2).substring(0, n10);
        n11 = (Byte.parseByte((String)object2, n14) & 0x7E) >> n12;
        n15 = 33;
        if (n11 != n15) return n13 != 0;
        n11 = 3;
        object = object[n11];
        object = ((String)object).substring(0, n10);
        int n16 = (Byte.parseByte((String)object, n14) & 0x7E) >> n12;
        n11 = 34;
        if (n16 != n11) return n13 != 0;
        return n12 != 0;
    }
}

