/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1;

import d.v.y.d.a;
import d.v.y.d.g;
import d.v.y.d.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class c {
    public static Map a(byte[] object, int n10) {
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        int n11 = ((byte[])object).length - n10;
        if ((n10 = ((byte[])(object = a.e((byte[])object, n10, n11))).length) >= (n11 = 2)) {
            object = ByteBuffer.wrap((byte[])object);
            Object object2 = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order((ByteOrder)object2);
            block0: while (true) {
                int n12;
                n10 = ((Buffer)object).limit();
                n11 = ((Buffer)object).position();
                if ((n10 = n10 - n11 + -1) <= 0) break;
                n10 = ((ByteBuffer)object).get();
                ((ByteBuffer)object).mark();
                do {
                    n11 = ((Buffer)object).limit();
                    n12 = ((Buffer)object).position();
                    if ((n11 -= n12) <= 0) continue block0;
                } while ((n11 = (int)((ByteBuffer)object).get()) != 0);
                n11 = ((Buffer)object).position();
                ((ByteBuffer)object).reset();
                n12 = ((Buffer)object).position();
                byte[] byArray = new byte[n11 -= n12];
                ((ByteBuffer)object).get(byArray);
                Charset charset = Charset.defaultCharset();
                String string2 = new String(byArray, 0, n11 += -1, charset);
                object2 = n10;
                hashMap.put(object2, string2);
            }
        }
        return hashMap;
    }

    public static byte[] b(Map iterator2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        iterator2 = iterator2.entrySet();
        try {
            iterator2 = iterator2.iterator();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            Object object = iterator2.next();
            object = (Map.Entry)object;
            Object object2 = object.getKey();
            object2 = (Integer)object2;
            byte by2 = ((Integer)object2).byteValue();
            byteArrayOutputStream.write(by2);
            object = object.getValue();
            object = (String)object;
            object = k.h(object);
            byteArrayOutputStream.write((byte[])object);
            bl2 = false;
            object = null;
            byteArrayOutputStream.write(0);
            continue;
            break;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Map c(byte[] object, int n10) {
        HashMap<Object, String> hashMap = new HashMap<Object, String>();
        int n11 = ((byte[])object).length - n10;
        if ((n10 = ((byte[])(object = a.e((byte[])object, n10, n11))).length) >= (n11 = 2)) {
            object = ByteBuffer.wrap((byte[])object);
            Object object2 = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order((ByteOrder)object2);
            block0: while (true) {
                int n12;
                n10 = ((Buffer)object).limit();
                n11 = ((Buffer)object).position();
                if ((n10 = n10 - n11 + -1) <= 0) break;
                n10 = ((ByteBuffer)object).getShort();
                ((ByteBuffer)object).mark();
                do {
                    n11 = ((Buffer)object).limit();
                    n12 = ((Buffer)object).position();
                    if ((n11 -= n12) <= 0) continue block0;
                } while ((n11 = (int)((ByteBuffer)object).get()) != 0);
                n11 = ((Buffer)object).position();
                ((ByteBuffer)object).reset();
                n12 = ((Buffer)object).position();
                byte[] byArray = new byte[n11 -= n12];
                ((ByteBuffer)object).get(byArray);
                Charset charset = Charset.defaultCharset();
                String string2 = new String(byArray, 0, n11 += -1, charset);
                object2 = (short)n10;
                hashMap.put(object2, string2);
            }
        }
        return hashMap;
    }

    public static g d(short s10, String string2) {
        if (string2 != null) {
            return g.a(s10, string2);
        }
        return g.a((short)0, "");
    }
}

