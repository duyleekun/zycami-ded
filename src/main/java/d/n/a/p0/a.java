/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.p0;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class a {
    private static final String a = "%08x-0000-1000-8000-00805f9b34fb";

    public List a(byte[] object) {
        int n10;
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        object = ((ByteBuffer)object).order(byteOrder);
        block5: while ((n11 = ((Buffer)object).remaining()) > (n10 = 2) && (n11 = (int)((ByteBuffer)object).get()) != 0) {
            Object object2;
            int n12 = ((ByteBuffer)object).get();
            String string2 = a;
            int n13 = 1;
            switch (n12) {
                default: {
                    n10 = ((Buffer)object).position() + n11 - n13;
                    ((ByteBuffer)object).position(n10);
                    continue block5;
                }
                case 4: 
                case 5: {
                    while (n11 >= (n10 = 4)) {
                        Object object3 = new Object[n13];
                        n12 = ((ByteBuffer)object).getInt();
                        object2 = n12;
                        object3[0] = object2;
                        object3 = UUID.fromString(String.format(string2, object3));
                        arrayList.add(object3);
                        n11 = (byte)(n11 + -4);
                    }
                }
                case 6: 
                case 7: {
                    while (n11 >= (n10 = 16)) {
                        long l10 = ((ByteBuffer)object).getLong();
                        long l11 = ((ByteBuffer)object).getLong();
                        UUID uUID = new UUID(l11, l10);
                        arrayList.add(uUID);
                        n11 = (byte)(n11 + -16);
                    }
                    continue block5;
                }
                case 2: 
                case 3: 
            }
            while (n11 >= n10) {
                object2 = new Object[n13];
                short s10 = ((ByteBuffer)object).getShort();
                Short s11 = s10;
                object2[0] = s11;
                object2 = UUID.fromString(String.format(string2, object2));
                arrayList.add(object2);
                n11 = (byte)(n11 + -2);
            }
        }
        return arrayList;
    }

    public Set b(UUID[] object) {
        if (object == null) {
            object = new UUID[]{};
        }
        object = Arrays.asList(object);
        HashSet hashSet = new HashSet(object);
        return hashSet;
    }
}

