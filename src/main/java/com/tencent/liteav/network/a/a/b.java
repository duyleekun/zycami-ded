/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class b {
    private static String a(DataInputStream object, byte[] object2) {
        int n10;
        int n11 = ((DataInputStream)object).readUnsignedByte();
        int n12 = n11 & 0xC0;
        if (n12 == (n10 = 192)) {
            n11 = (n11 & 0x3F) << 8;
            int n13 = ((DataInputStream)object).readUnsignedByte();
            object = new HashSet();
            Integer n14 = n11 += n13;
            ((HashSet)object).add(n14);
            return b.a((byte[])object2, n11, (HashSet)object);
        }
        if (n11 == 0) {
            return "";
        }
        Object object3 = new byte[n11];
        ((DataInputStream)object).readFully((byte[])object3);
        String string2 = new String((byte[])object3);
        object3 = IDN.toUnicode(string2);
        object = b.a(object, (byte[])object2);
        int n15 = ((String)object).length();
        if (n15 > 0) {
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(".");
            ((StringBuilder)object2).append((String)object);
            object3 = ((StringBuilder)object2).toString();
        }
        return object3;
    }

    private static String a(byte[] object, int n10, HashSet object2) {
        int n11 = object[n10] & 0xFF;
        int n12 = n11 & 0xC0;
        String string2 = "";
        int n13 = 192;
        if (n12 == n13) {
            n11 = (n11 & 0x3F) << 8;
            ++n10;
            n10 = object[n10] & 0xFF;
            Integer n14 = n11 += n10;
            if ((n10 = (int)(((HashSet)object2).contains(n14) ? 1 : 0)) == 0) {
                n14 = n11;
                ((HashSet)object2).add(n14);
                return b.a((byte[])object, n11, (HashSet)object2);
            }
            object = new a(string2, "Cyclic offsets detected.");
            throw object;
        }
        if (n11 == 0) {
            return string2;
        }
        String string3 = new String((byte[])object, ++n10, n11);
        n10 += n11;
        if ((n10 = ((String)(object = (Object)b.a((byte[])object, n10, (HashSet)object2))).length()) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            object2 = ".";
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            string3 = stringBuilder.toString();
        }
        return string3;
    }

    private static void a(DataInputStream dataInputStream, byte[] byArray, int n10) {
        while (true) {
            int n11 = n10 + -1;
            if (n10 <= 0) break;
            b.a(dataInputStream, byArray);
            dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            n10 = n11;
        }
    }

    private static void a(OutputStream outputStream, String stringArray) {
        String string2 = "[.\u3002\uff0e\uff61]";
        stringArray = stringArray.split(string2);
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte[] byArray = IDN.toASCII(stringArray[i10]).getBytes();
            int n11 = byArray.length;
            outputStream.write(n11);
            n11 = byArray.length;
            outputStream.write(byArray, 0, n11);
        }
        outputStream.write(0);
    }

    public static byte[] a(String string2, int n10) {
        AssertionError assertionError;
        int n11 = 512;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n11);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        com.tencent.liteav.network.a.b.a a10 = new com.tencent.liteav.network.a.b.a();
        int n12 = 8;
        a10.a(n12);
        n10 = (short)n10;
        try {
            dataOutputStream.writeShort(n10);
            n10 = (short)a10.a();
        }
        catch (IOException iOException) {
            assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
        dataOutputStream.writeShort(n10);
        n10 = 1;
        dataOutputStream.writeShort(n10);
        n10 = 0;
        assertionError = null;
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        dataOutputStream.writeShort(0);
        dataOutputStream.flush();
        b.b(byteArrayOutputStream, string2);
        return byteArrayOutputStream.toByteArray();
    }

    public static e[] a(byte[] object, int n10, String string2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        Object object2 = new DataInputStream(byteArrayInputStream);
        int n11 = ((DataInputStream)object2).readUnsignedShort();
        if (n11 == n10) {
            n10 = ((DataInputStream)object2).readUnsignedShort();
            n11 = n10 >> 8;
            int n12 = 1;
            if ((n11 &= n12) == n12) {
                n11 = n12;
            } else {
                n11 = 0;
                byteArrayInputStream = null;
            }
            n10 = n10 >> 7 & n12;
            if (n10 != n12) {
                n12 = 0;
            }
            if (n12 != 0 && n11 != 0) {
                n10 = ((DataInputStream)object2).readUnsignedShort();
                int n13 = ((DataInputStream)object2).readUnsignedShort();
                ((DataInputStream)object2).readUnsignedShort();
                ((DataInputStream)object2).readUnsignedShort();
                b.a((DataInputStream)object2, object, n10);
                return b.b((DataInputStream)object2, object, n13);
            }
            object = new a;
            object(string2, "the dns server cant support recursion ");
            throw object;
        }
        object = new a;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("the answer id ");
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(" is not match ");
        ((StringBuilder)object2).append(n10);
        String string3 = ((StringBuilder)object2).toString();
        object(string2, string3);
        throw object;
    }

    private static e b(DataInputStream object, byte[] object2) {
        b.a((DataInputStream)object, object2);
        int n10 = ((DataInputStream)object).readUnsignedShort();
        ((DataInputStream)object).readUnsignedShort();
        int n11 = ((DataInputStream)object).readUnsignedShort();
        long l10 = (long)n11 << 16;
        long l11 = ((DataInputStream)object).readUnsignedShort();
        l10 += l11;
        int n12 = ((DataInputStream)object).readUnsignedShort();
        int n13 = 1;
        if (n10 != n13) {
            n13 = 5;
            if (n10 != n13) {
                boolean bl2 = false;
                object2 = null;
                for (n13 = 0; n13 < n12; ++n13) {
                    ((DataInputStream)object).readByte();
                }
                object = null;
            } else {
                object = b.a((DataInputStream)object, object2);
            }
        } else {
            int n14 = 4;
            object2 = new byte[n14];
            ((DataInputStream)object).readFully((byte[])object2);
            object = InetAddress.getByAddress(object2).getHostAddress();
        }
        if (object != null) {
            object2 = new e;
            n12 = (int)l10;
            long l12 = System.currentTimeMillis() / 1000L;
            object2((String)object, n10, n12, l12);
            return object2;
        }
        object = new UnknownHostException("no record");
        throw object;
    }

    private static void b(OutputStream outputStream, String string2) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        b.a(outputStream, string2);
        int n10 = 1;
        dataOutputStream.writeShort(n10);
        dataOutputStream.writeShort(n10);
    }

    private static e[] b(DataInputStream dataInputStream, byte[] byArray, int n10) {
        e[] eArray = new e[n10];
        int n11 = 0;
        while (true) {
            e e10;
            int n12 = n10 + -1;
            if (n10 <= 0) break;
            n10 = n11 + 1;
            eArray[n11] = e10 = b.b(dataInputStream, byArray);
            n11 = n10;
            n10 = n12;
        }
        return eArray;
    }
}

