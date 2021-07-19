/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelUuid
 *  android.util.SparseArray
 */
package d.n.a.q0.x;

import android.os.ParcelUuid;
import android.util.SparseArray;
import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.v.s;
import d.n.a.r0.c;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class a0 {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final int f = 6;
    private static final int g = 7;
    private static final int h = 8;
    private static final int i = 9;
    private static final int j = 10;
    private static final int k = 22;
    private static final int l = 255;
    public static final ParcelUuid m = ParcelUuid.fromString((String)"00000000-0000-1000-8000-00805F9B34FB");
    public static final int n = 2;
    public static final int o = 4;
    public static final int p = 16;
    private static final String q = "%08x-0000-1000-8000-00805f9b34fb";

    private static byte[] a(byte[] byArray, int n10, int n11) {
        byte[] byArray2 = new byte[n11];
        System.arraycopy(byArray, n10, byArray2, 0, n11);
        return byArray2;
    }

    private static int d(byte[] byArray, int n10, int n11, int n12, List list) {
        while (n11 > 0) {
            ParcelUuid parcelUuid = a0.e(a0.a(byArray, n10, n12));
            list.add(parcelUuid);
            n11 -= n12;
            n10 += n12;
        }
        return n10;
    }

    private static ParcelUuid e(byte[] object) {
        if (object != null) {
            long l10;
            long l11;
            int n10;
            int n11 = ((byte[])object).length;
            int n12 = 16;
            int n13 = 2;
            if (n11 != n13 && n11 != (n10 = 4) && n11 != n12) {
                object = new IllegalArgumentException;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("uuidBytes length invalid - ");
                stringBuilder.append(n11);
                String string2 = stringBuilder.toString();
                ((IllegalArgumentException)object)(string2);
                throw object;
            }
            n10 = 0;
            int n14 = 8;
            if (n11 == n12) {
                object = ByteBuffer.wrap((byte[])object);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                object = ((ByteBuffer)object).order(byteOrder);
                long l12 = ((ByteBuffer)object).getLong(n14);
                long l13 = ((ByteBuffer)object).getLong(0);
                UUID uUID = new UUID(l12, l13);
                object = new ParcelUuid(uUID);
                return object;
            }
            int n15 = 1;
            if (n11 == n13) {
                n11 = object[0] & 0xFF;
                l11 = n11;
                int n16 = (object[n15] & 0xFF) << n14;
                l10 = n16;
                l11 += l10;
            } else {
                long l14 = object[0] & 0xFF;
                long l15 = (object[n15] & 0xFF) << n14;
                l14 += l15;
                l11 = (object[n13] & 0xFF) << n12;
                l14 += l11;
                n11 = 3;
                int n17 = (object[n11] & 0xFF) << 24;
                l11 = (long)n17 + l14;
            }
            object = m;
            l10 = object.getUuid().getMostSignificantBits();
            l11 = object.getUuid().getLeastSignificantBits();
            UUID uUID = new UUID(l10 += (l11 <<= 32), l11);
            object = new ParcelUuid(uUID);
            return object;
        }
        object = new IllegalArgumentException;
        object = new IllegalArgumentException("uuidBytes cannot be null");
        throw object;
    }

    public List b(byte[] object) {
        int n10;
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        object = ((ByteBuffer)object).order(byteOrder);
        block5: while ((n11 = ((Buffer)object).remaining()) > (n10 = 2) && (n11 = ((ByteBuffer)object).get() & 0xFF) != 0) {
            Object object2;
            int n12 = ((ByteBuffer)object).get();
            String string2 = q;
            int n13 = 1;
            switch (n12) {
                default: {
                    n11 += -1;
                    n10 = ((Buffer)object).remaining();
                    n11 = Math.min(n11, n10);
                    n10 = ((Buffer)object).position() + n11;
                    ((ByteBuffer)object).position(n10);
                    continue block5;
                }
                case 6: 
                case 7: {
                    while (n11 >= (n10 = 16)) {
                        long l10 = ((ByteBuffer)object).getLong();
                        long l11 = ((ByteBuffer)object).getLong();
                        UUID uUID = new UUID(l11, l10);
                        arrayList.add(uUID);
                        n11 += -16;
                    }
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
                        n11 += -4;
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
                n11 += -2;
            }
        }
        return arrayList;
    }

    public c c(byte[] byArray) {
        Object object;
        Object object2;
        Object object3;
        int n10;
        s s10 = null;
        if (byArray == null) {
            return null;
        }
        Object object4 = new ArrayList();
        int n11 = -1 << -1;
        SparseArray sparseArray = new SparseArray();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object5 = null;
        int n12 = -1;
        int n13 = n11;
        int n14 = 0;
        Object[] objectArray = null;
        while (true) {
            block37: {
                int n15;
                int n16;
                int n17;
                block35: {
                    block36: {
                        n11 = byArray.length;
                        if (n14 >= n11) break;
                        n11 = n14 + 1;
                        n14 = byArray[n14];
                        n17 = 255;
                        if ((n14 &= n17) == 0) break;
                        n14 += -1;
                        n10 = n11 + 1;
                        n11 = byArray[n11] & n17;
                        n16 = 22;
                        n15 = 2;
                        if (n11 == n16) break block35;
                        if (n11 == n17) break block36;
                        switch (n11) {
                            default: {
                                break;
                            }
                            case 10: {
                                n13 = n11 = byArray[n10];
                                break;
                            }
                            case 8: 
                            case 9: {
                                object5 = new String;
                                object3 = a0.a(byArray, n10, n14);
                                object5((byte[])object3);
                                break;
                            }
                            case 6: 
                            case 7: {
                                n11 = 16;
                                a0.d(byArray, n10, n14, n11, (List)object4);
                                break;
                            }
                            case 4: 
                            case 5: {
                                n11 = 4;
                                a0.d(byArray, n10, n14, n11, (List)object4);
                                break;
                            }
                            case 2: 
                            case 3: {
                                a0.d(byArray, n10, n14, n15, (List)object4);
                                break;
                            }
                            case 1: {
                                n12 = n11 = byArray[n10] & n17;
                                break;
                            }
                        }
                        break block37;
                    }
                    n11 = n10 + 1;
                    n11 = (byArray[n11] & n17) << 8;
                    n16 = byArray[n10];
                    n11 += (n17 &= n16);
                    n17 = n10 + 2;
                    n16 = n14 + -2;
                    object2 = a0.a(byArray, n17, n16);
                    sparseArray.put(n11, object2);
                    break block37;
                }
                object3 = a0.a(byArray, n10, n15);
                object3 = a0.e((byte[])object3);
                n17 = n10 + 2;
                n16 = n14 + -2;
                object2 = a0.a(byArray, n17, n16);
                hashMap.put(object3, object2);
            }
            n14 += n10;
        }
        try {
            n14 = (int)(object4.isEmpty() ? 1 : 0);
            if (n14 != 0) {
                n10 = 0;
                object = null;
            } else {
                object = object4;
            }
            object2 = s10;
        }
        catch (Exception exception) {
            s s11;
            object4 = d.n.a.q0.t.b.a(byArray);
            objectArray = new Object[]{object4};
            d.n.a.q0.p.e(exception, "Unable to parse scan record: %s", objectArray);
            object3 = s11;
            object5 = byArray;
            s11 = new s(null, null, null, -1, -1 << -1, null, byArray);
            return s11;
        }
        s10 = new s((List)object, sparseArray, hashMap, n12, n13, (String)object5, byArray);
        return s10;
    }

    public Set f(UUID[] object) {
        if (object == null) {
            object = new UUID[]{};
        }
        object = Arrays.asList(object);
        HashSet hashSet = new HashSet(object);
        return hashSet;
    }
}

