/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.net.InetAddresses$TeredoInfo;
import com.google.common.primitives.Ints;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;

public final class InetAddresses {
    private static final Inet4Address ANY4;
    private static final int IPV4_PART_COUNT = 4;
    private static final Splitter IPV4_SPLITTER;
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV6_SPLITTER;
    private static final Inet4Address LOOPBACK4;

    static {
        IPV4_SPLITTER = Splitter.on('.').limit(4);
        IPV6_SPLITTER = Splitter.on(':').limit(10);
        LOOPBACK4 = (Inet4Address)InetAddresses.forString("127.0.0.1");
        ANY4 = (Inet4Address)InetAddresses.forString("0.0.0.0");
    }

    private InetAddresses() {
    }

    public static /* synthetic */ Inet4Address access$000() {
        return ANY4;
    }

    private static InetAddress bytesToInetAddress(byte[] byArray) {
        try {
            return InetAddress.getByAddress(byArray);
        }
        catch (UnknownHostException unknownHostException) {
            AssertionError assertionError = new AssertionError((Object)unknownHostException);
            throw assertionError;
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(InetAddresses.getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] nArray) {
        int n10;
        int n11;
        int n12 = -1;
        int n13 = n12;
        int n14 = n12;
        int n15 = n12;
        for (n11 = 0; n11 < (n10 = nArray.length + 1); ++n11) {
            n10 = nArray.length;
            if (n11 < n10 && (n10 = nArray[n11]) == 0) {
                if (n15 >= 0) continue;
                n15 = n11;
                continue;
            }
            if (n15 < 0) continue;
            n10 = n11 - n15;
            if (n10 > n13) {
                n14 = n15;
                n13 = n10;
            }
            n15 = n12;
        }
        n11 = 2;
        if (n13 >= n11) {
            Arrays.fill(nArray, n14, n13 += n14, n12);
        }
    }

    private static String convertDottedQuadToHex(String object) {
        int n10 = ((String)object).lastIndexOf(58);
        int n11 = 1;
        String string2 = ((String)object).substring(0, n10 += n11);
        if ((object = (Object)InetAddresses.textToNumericFormatV4(((String)object).substring(n10))) == null) {
            return null;
        }
        n10 = (object[0] & 0xFF) << 8;
        n11 = object[n11] & 0xFF;
        String string3 = Integer.toHexString(n10 | n11);
        n11 = (object[2] & 0xFF) << 8;
        object = Integer.toHexString(object[3] & 0xFF | n11);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(":");
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        byte by2;
        byte by3;
        byte[] byArray = inetAddress.getAddress();
        int n10 = byArray.length;
        byte by4 = 1;
        n10 -= by4;
        while (n10 >= 0 && (by3 = byArray[n10]) == 0) {
            byArray[n10] = by3 = -1;
            n10 += -1;
        }
        by3 = n10 >= 0 ? by4 : (byte)0;
        Preconditions.checkArgument(by3 != 0, "Decrementing %s would wrap.", (Object)inetAddress);
        byArray[n10] = by2 = (byte)(byArray[n10] - by4);
        return InetAddresses.bytesToInetAddress(byArray);
    }

    public static InetAddress forString(String string2) {
        Object[] objectArray = InetAddresses.ipStringToBytes(string2);
        if (objectArray != null) {
            return InetAddresses.bytesToInetAddress(objectArray);
        }
        objectArray = new Object[1];
        objectArray[0] = (byte)string2;
        throw InetAddresses.formatIllegalArgumentException("'%s' is not an IP string literal.", objectArray);
    }

    public static InetAddress forUriString(String string2) {
        Object[] objectArray = InetAddresses.forUriStringNoThrow(string2);
        if (objectArray != null) {
            return objectArray;
        }
        objectArray = new Object[]{string2};
        throw InetAddresses.formatIllegalArgumentException("Not a valid URI IP literal: '%s'", objectArray);
    }

    /*
     * WARNING - void declaration
     */
    private static InetAddress forUriStringNoThrow(String object) {
        void var2_8;
        int n10;
        boolean bl2;
        Preconditions.checkNotNull(object);
        String string2 = "[";
        boolean n11 = ((String)object).startsWith(string2);
        if (n11 && (bl2 = ((String)object).endsWith(string2 = "]"))) {
            int n12 = ((String)object).length();
            n10 = 1;
            int n13 = n12 - n10;
            object = ((String)object).substring(n10, n13);
            int n14 = 16;
        } else {
            int n15 = 4;
        }
        object = InetAddresses.ipStringToBytes((String)object);
        if (object != null && (n10 = ((Object)object).length) == var2_8) {
            return InetAddresses.bytesToInetAddress((byte[])object);
        }
        return null;
    }

    private static IllegalArgumentException formatIllegalArgumentException(String string2, Object ... objectArray) {
        string2 = String.format(Locale.ROOT, string2, objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        return illegalArgumentException;
    }

    /*
     * WARNING - void declaration
     */
    private static InetAddress fromBigInteger(BigInteger bigInteger, boolean bl2) {
        void var1_5;
        Object[] objectArray;
        int n10 = bigInteger.signum();
        int n11 = 1;
        if (n10 >= 0) {
            n10 = n11;
        } else {
            n10 = 0;
            objectArray = null;
        }
        Object object = "BigInteger must be greater than or equal to 0";
        Preconditions.checkArgument(n10 != 0, object);
        if (bl2) {
            int n12 = 16;
        } else {
            int n13 = 4;
        }
        objectArray = bigInteger.toByteArray();
        object = new byte[var1_5];
        int n14 = objectArray.length - var1_5;
        n14 = Math.max(0, n14);
        int n15 = objectArray.length - n14;
        void var8_12 = var1_5 - n15;
        for (int i10 = 0; i10 < n14; ++i10) {
            byte by2 = objectArray[i10];
            if (by2 == 0) {
                continue;
            }
            objectArray = new Object[2];
            Integer n16 = (int)var1_5;
            objectArray[0] = (byte)n16;
            objectArray[n11] = (byte)bigInteger;
            throw InetAddresses.formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", objectArray);
        }
        System.arraycopy(objectArray, n14, object, (int)var8_12, n15);
        try {
            return InetAddress.getByAddress((byte[])object);
        }
        catch (UnknownHostException unknownHostException) {
            AssertionError assertionError = new AssertionError((Object)unknownHostException);
            throw assertionError;
        }
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address)InetAddresses.fromBigInteger(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address)InetAddresses.fromBigInteger(bigInteger, true);
    }

    public static Inet4Address fromInteger(int n10) {
        return InetAddresses.getInet4Address(Ints.toByteArray(n10));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] byArray) {
        int n10;
        int n11 = byArray.length;
        byte[] byArray2 = new byte[n11];
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray.length - i10 + -1;
            byArray2[i10] = n10 = byArray[n10];
        }
        return InetAddress.getByAddress(byArray2);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        boolean bl2 = InetAddresses.is6to4Address(inet6Address);
        String string2 = InetAddresses.toAddrString(inet6Address);
        Preconditions.checkArgument(bl2, "Address '%s' is not a 6to4 address.", (Object)string2);
        return InetAddresses.getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress object) {
        long l10;
        int n10;
        byte by2;
        byte by3;
        byte by4;
        byte by5;
        byte[] byArray;
        int n11;
        block8: {
            n11 = object instanceof Inet4Address;
            if (n11 != 0) {
                return (Inet4Address)object;
            }
            byArray = ((InetAddress)object).getAddress();
            by5 = 0;
            while (true) {
                by4 = 15;
                by3 = 1;
                if (by5 >= by4) break;
                by2 = byArray[by5];
                if (by2 != 0) {
                    by5 = 0;
                    break block8;
                }
                ++by5;
            }
            by5 = by3;
        }
        if (by5 != 0 && (by2 = byArray[by4]) == by3) {
            return LOOPBACK4;
        }
        if (by5 != 0 && (n11 = byArray[by4]) == 0) {
            return ANY4;
        }
        n11 = (int)(InetAddresses.hasEmbeddedIPv4ClientAddress((Inet6Address)(object = (Inet6Address)object)) ? 1 : 0);
        if (n11 != 0) {
            object = InetAddresses.getEmbeddedIPv4ClientAddress((Inet6Address)object);
            n10 = ((Inet4Address)object).hashCode();
            l10 = n10;
        } else {
            object = ((Inet6Address)object).getAddress();
            n11 = 8;
            object = ByteBuffer.wrap((byte[])object, 0, n11);
            l10 = ((ByteBuffer)object).getLong();
        }
        object = Hashing.murmur3_32().hashLong(l10);
        n10 = ((HashCode)object).asInt() | 0xE0000000;
        n11 = -1;
        if (n10 == n11) {
            n10 = -2;
        }
        return InetAddresses.getInet4Address(Ints.toByteArray(n10));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        boolean bl2 = InetAddresses.isCompatIPv4Address(inet6Address);
        String string2 = InetAddresses.toAddrString(inet6Address);
        Preconditions.checkArgument(bl2, "Address '%s' is not IPv4-compatible.", (Object)string2);
        return InetAddresses.getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address object) {
        boolean bl2 = InetAddresses.isCompatIPv4Address((Inet6Address)object);
        if (bl2) {
            return InetAddresses.getCompatIPv4Address((Inet6Address)object);
        }
        bl2 = InetAddresses.is6to4Address((Inet6Address)object);
        if (bl2) {
            return InetAddresses.get6to4IPv4Address((Inet6Address)object);
        }
        bl2 = InetAddresses.isTeredoAddress((Inet6Address)object);
        if (bl2) {
            return InetAddresses.getTeredoInfo((Inet6Address)object).getClient();
        }
        Object[] objectArray = new Object[]{object = InetAddresses.toAddrString((InetAddress)object)};
        throw InetAddresses.formatIllegalArgumentException("'%s' has no embedded IPv4 address.", objectArray);
    }

    private static Inet4Address getInet4Address(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 4;
        n10 = n10 == n11 ? 1 : 0;
        n11 = byArray.length;
        Preconditions.checkArgument(n10 != 0, "Byte array has invalid length for an IPv4 address: %s != 4.", n11);
        return (Inet4Address)InetAddresses.bytesToInetAddress(byArray);
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        boolean bl2 = InetAddresses.isIsatapAddress(inet6Address);
        String string2 = InetAddresses.toAddrString(inet6Address);
        Preconditions.checkArgument(bl2, "Address '%s' is not an ISATAP address.", (Object)string2);
        return InetAddresses.getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static InetAddresses$TeredoInfo getTeredoInfo(Inet6Address object) {
        int n10 = InetAddresses.isTeredoAddress((Inet6Address)object);
        Object object2 = InetAddresses.toAddrString((InetAddress)object);
        String string2 = "Address '%s' is not a Teredo address.";
        Preconditions.checkArgument(n10 != 0, string2, object2);
        object = ((Inet6Address)object).getAddress();
        n10 = 4;
        int n11 = 8;
        Inet4Address inet4Address = InetAddresses.getInet4Address(Arrays.copyOfRange((byte[])object, n10, n11));
        object2 = ByteStreams.newDataInput((byte[])object, n11);
        n11 = object2.readShort();
        int n12 = -1;
        n11 &= n12;
        int n13 = ~ByteStreams.newDataInput((byte[])object, 10).readShort();
        n12 &= n13;
        int n14 = 16;
        object = Arrays.copyOfRange((byte[])object, 12, n14);
        InetAddresses$TeredoInfo inetAddresses$TeredoInfo = null;
        for (n13 = 0; n13 < (n14 = ((Object)object).length); ++n13) {
            n14 = (byte)(~object[n13]);
            object[n13] = n14;
        }
        object = InetAddresses.getInet4Address((byte[])object);
        inetAddresses$TeredoInfo = new InetAddresses$TeredoInfo(inet4Address, (Inet4Address)object, n12, n11);
        return inetAddresses$TeredoInfo;
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        boolean bl2;
        boolean bl3 = InetAddresses.isCompatIPv4Address(inet6Address);
        if (!(bl3 || (bl3 = InetAddresses.is6to4Address(inet6Address)) || (bl2 = InetAddresses.isTeredoAddress(inet6Address)))) {
            bl2 = false;
            inet6Address = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static String hextetsToIPv6String(int[] nArray) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder(39);
        int n11 = 0;
        String string2 = null;
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            n10 = n10 >= 0 ? 1 : 0;
            if (n10 != 0) {
                if (n11 != 0) {
                    n11 = 58;
                    stringBuilder.append((char)n11);
                }
                n11 = nArray[i10];
                string2 = Integer.toHexString(n11);
                stringBuilder.append(string2);
            } else if (i10 == 0 || n11 != 0) {
                string2 = "::";
                stringBuilder.append(string2);
            }
            n11 = n10;
        }
        return stringBuilder.toString();
    }

    public static InetAddress increment(InetAddress inetAddress) {
        byte by2;
        byte by3;
        byte[] byArray = inetAddress.getAddress();
        int n10 = byArray.length;
        byte by4 = 1;
        n10 -= by4;
        while (true) {
            byte by5;
            byte by6;
            by3 = 0;
            if (n10 < 0 || (by6 = byArray[n10]) != (by5 = -1)) break;
            byArray[n10] = 0;
            n10 += -1;
        }
        if (n10 >= 0) {
            by3 = by4;
        }
        Preconditions.checkArgument(by3 != 0, "Incrementing %s would wrap.", (Object)inetAddress);
        byArray[n10] = by2 = (byte)(byArray[n10] + by4);
        return InetAddresses.bytesToInetAddress(byArray);
    }

    /*
     * Unable to fully structure code
     */
    private static byte[] ipStringToBytes(String var0) {
        block12: {
            var1_1 = 0;
            var2_2 = false;
            var3_3 = false;
            while (true) {
                var4_4 = var0.length();
                var5_5 = -1;
                if (var1_1 >= var4_4) break;
                var4_4 = var0.charAt(var1_1);
                var6_6 = 46;
                var7_7 = true;
                if (var4_4 == var6_6) {
                    var2_2 = var7_7;
                } else {
                    var6_6 = 58;
                    if (var4_4 == var6_6) {
                        if (var2_2) {
                            return null;
                        }
                        var3_3 = var7_7;
                    } else {
                        var6_6 = 37;
                        if (var4_4 != var6_6) {
                            var6_6 = 16;
                            if ((var4_4 = Character.digit((char)var4_4, var6_6)) == var5_5) {
                                return null;
                            } else {
                                ** GOTO lbl26
                            }
                        }
                        break block12;
                    }
                }
lbl26:
                // 4 sources

                ++var1_1;
            }
            var1_1 = var5_5;
        }
        if (var3_3) {
            if (var2_2 && (var0 = InetAddresses.convertDottedQuadToHex(var0)) == null) {
                return null;
            }
            if (var1_1 != var5_5) {
                var0 = var0.substring(0, var1_1);
            }
            return InetAddresses.textToNumericFormatV6(var0);
        }
        if (var2_2) {
            return InetAddresses.textToNumericFormatV4(var0);
        }
        return null;
    }

    public static boolean is6to4Address(Inet6Address object) {
        Object object2;
        object = ((Inet6Address)object).getAddress();
        int n10 = 0;
        Object object3 = object[0];
        int n11 = 1;
        int n12 = 32;
        if (object3 == n12 && (object2 = object[n11]) == (object3 = (Object)2)) {
            n10 = n11;
        }
        return n10 != 0;
    }

    public static boolean isCompatIPv4Address(Inet6Address object) {
        Object object2;
        int n10;
        Object object3;
        Object object4;
        Object object5;
        boolean n102 = ((Inet6Address)object).isIPv4CompatibleAddress();
        if (!n102) {
            return false;
        }
        object = ((Inet6Address)object).getAddress();
        Object object6 = object[12];
        boolean bl2 = true;
        if (object6 == false && (object5 = object[13]) == false && (object4 = object[14]) == false && ((object3 = object[n10 = 15]) == false || (object2 = object[n10]) == bl2)) {
            return false;
        }
        return bl2;
    }

    public static boolean isInetAddress(String object) {
        boolean bl2;
        if ((object = (Object)InetAddresses.ipStringToBytes((String)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isIsatapAddress(Inet6Address object) {
        Object object2;
        Object object3 = InetAddresses.isTeredoAddress((Inet6Address)object);
        boolean bl2 = false;
        if (object3 != 0) {
            return false;
        }
        object = ((Inet6Address)object).getAddress();
        object3 = object[8];
        int n10 = 3;
        if ((object3 |= n10) != n10) {
            return false;
        }
        object3 = object[9];
        if (object3 == 0 && (object3 = object[10]) == (n10 = 94) && (object2 = object[11]) == (object3 = -2)) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isMappedIPv4Address(String object) {
        Object object2;
        Object object3;
        if ((object = (Object)InetAddresses.ipStringToBytes((String)object)) != null && (object3 = ((Object)object).length) == (object2 = 16)) {
            for (object3 = 0; object3 < (object2 = 10); ++object3) {
                object2 = object[object3];
                if (object2 == 0) continue;
                return false;
            }
            while (object2 < (object3 = 12)) {
                object3 = object[object2];
                Object object4 = -1;
                if (object3 != object4) {
                    return false;
                }
                ++object2;
            }
            return true;
        }
        return false;
    }

    public static boolean isMaximum(InetAddress object) {
        Object object2;
        object = ((InetAddress)object).getAddress();
        for (int i10 = 0; i10 < (object2 = ((Object)object).length); ++i10) {
            object2 = object[i10];
            Object object3 = -1;
            if (object2 == object3) continue;
            return false;
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address object) {
        Object object2;
        object = ((Inet6Address)object).getAddress();
        int n10 = 0;
        Object object3 = object[0];
        int n11 = 1;
        int n12 = 32;
        if (object3 == n12 && (object3 = object[n11]) == n11 && (object3 = object[2]) == false && (object2 = object[object3 = (Object)3]) == false) {
            n10 = n11;
        }
        return n10 != 0;
    }

    public static boolean isUriInetAddress(String object) {
        boolean bl2;
        if ((object = InetAddresses.forUriStringNoThrow((String)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static short parseHextet(String object) {
        char c10;
        int n10 = Integer.parseInt((String)object, 16);
        if (n10 <= (c10 = (char)-1)) {
            return (short)n10;
        }
        object = new NumberFormatException();
        throw object;
    }

    private static byte parseOctet(String object) {
        int n10;
        String string2;
        int n11;
        int n12 = Integer.parseInt((String)object);
        if (n12 <= (n11 = 255) && ((n11 = (int)(((String)object).startsWith(string2 = "0") ? 1 : 0)) == 0 || (n10 = ((String)object).length()) <= (n11 = 1))) {
            return (byte)n12;
        }
        object = new NumberFormatException();
        throw object;
    }

    private static byte[] textToNumericFormatV4(String iterator2) {
        int n10;
        int n11 = 4;
        byte[] byArray = new byte[n11];
        Splitter splitter = IPV4_SPLITTER;
        iterator2 = splitter.split((CharSequence)((Object)iterator2));
        try {
            iterator2 = iterator2.iterator();
            n10 = 0;
            splitter = null;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        while (true) {
            byte by2 = iterator2.hasNext();
            if (by2 == 0) break;
            Object object = iterator2.next();
            object = (String)object;
            int n12 = n10 + 1;
            by2 = InetAddresses.parseOctet(object);
            byArray[n10] = by2;
            n10 = n12;
            continue;
            break;
        }
        if (n10 != n11) {
            byArray = null;
        }
        return byArray;
    }

    private static byte[] textToNumericFormatV6(String object) {
        int n10;
        Object object2 = IPV6_SPLITTER;
        int n11 = (object = ((Splitter)object2).splitToList((CharSequence)object)).size();
        if (n11 >= (n10 = 3) && (n11 = object.size()) <= (n10 = 9)) {
            int n12;
            int n13;
            String string2;
            int n14;
            int n15;
            n11 = -1;
            for (n15 = n10 = 1; n15 < (n14 = object.size() - n10); ++n15) {
                string2 = (String)object.get(n15);
                n14 = string2.length();
                if (n14 != 0) continue;
                if (n11 >= 0) {
                    return null;
                }
                n11 = n15;
            }
            n15 = 0;
            if (n11 >= 0) {
                String string3;
                n14 = object.size() - n11 - n10;
                String string4 = (String)object.get(0);
                n13 = string4.length();
                if (n13 == 0) {
                    n13 = n11 + -1;
                    if (n13 != 0) {
                        return null;
                    }
                } else {
                    n13 = n11;
                }
                if ((n12 = (string3 = (String)Iterables.getLast((Iterable)object)).length()) == 0 && (n14 += -1) != 0) {
                    return null;
                }
            } else {
                n13 = object.size();
                n14 = 0;
                string2 = null;
            }
            n12 = n13 + n14;
            n12 = 8 - n12;
            if (!(n11 < 0 ? n12 == 0 : n12 >= n10)) {
                return null;
            }
            n11 = 16;
            object2 = ByteBuffer.allocate(n11);
            String string5 = null;
            for (n10 = 0; n10 < n13; ++n10) {
                Object object3 = object.get(n10);
                object3 = (String)object3;
                short s10 = InetAddresses.parseHextet(object3);
                ((ByteBuffer)object2).putShort(s10);
                continue;
            }
            string5 = null;
            for (n10 = 0; n10 < n12; ++n10) {
                ((ByteBuffer)object2).putShort((short)0);
                continue;
            }
            while (n14 > 0) {
                try {
                    n10 = object.size() - n14;
                }
                catch (NumberFormatException numberFormatException) {
                    return null;
                }
                string5 = (String)object.get(n10);
                string5 = string5;
                n10 = InetAddresses.parseHextet(string5);
                ((ByteBuffer)object2).putShort((short)n10);
                n14 += -1;
            }
            return ((ByteBuffer)object2).array();
        }
        return null;
    }

    public static String toAddrString(InetAddress object) {
        Preconditions.checkNotNull(object);
        int n10 = object instanceof Inet4Address;
        if (n10 != 0) {
            return ((InetAddress)object).getHostAddress();
        }
        Preconditions.checkArgument(object instanceof Inet6Address);
        object = ((InetAddress)object).getAddress();
        n10 = 8;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = i10 * 2;
            Object object2 = object[by2];
            ++by2;
            byte by2 = (byte)object[by2];
            by2 = (byte)Ints.fromBytes((byte)0, (byte)0, (byte)object2, by2);
            nArray[i10] = by2;
        }
        InetAddresses.compressLongestRunOfZeroes(nArray);
        return InetAddresses.hextetsToIPv6String(nArray);
    }

    public static BigInteger toBigInteger(InetAddress object) {
        object = ((InetAddress)object).getAddress();
        BigInteger bigInteger = new BigInteger(1, (byte[])object);
        return bigInteger;
    }

    public static String toUriString(InetAddress object) {
        boolean bl2 = object instanceof Inet6Address;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            object = InetAddresses.toAddrString((InetAddress)object);
            stringBuilder.append((String)object);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return InetAddresses.toAddrString((InetAddress)object);
    }
}

