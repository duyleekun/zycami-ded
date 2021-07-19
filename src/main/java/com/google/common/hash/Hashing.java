/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Crc32cHashFunction;
import com.google.common.hash.FarmHashFingerprint64;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing$ChecksumType;
import com.google.common.hash.Hashing$ConcatenatedHashFunction;
import com.google.common.hash.Hashing$LinearCongruentialGenerator;
import com.google.common.hash.Hashing$Md5Holder;
import com.google.common.hash.Hashing$Sha1Holder;
import com.google.common.hash.Hashing$Sha256Holder;
import com.google.common.hash.Hashing$Sha384Holder;
import com.google.common.hash.Hashing$Sha512Holder;
import com.google.common.hash.MacHashFunction;
import com.google.common.hash.Murmur3_128HashFunction;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.hash.SipHashFunction;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.spec.SecretKeySpec;

public final class Hashing {
    public static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();

    private Hashing() {
    }

    public static HashFunction adler32() {
        return Hashing$ChecksumType.ADLER_32.hashFunction;
    }

    public static int checkPositiveAndMakeMultipleOf32(int n10) {
        boolean bl2 = n10 > 0;
        Preconditions.checkArgument(bl2, "Number of bits must be positive");
        return n10 + 31 & 0xFFFFFFE0;
    }

    public static HashCode combineOrdered(Iterable object) {
        boolean bl2;
        Object object2 = object.iterator();
        boolean bl3 = object2.hasNext();
        Object object3 = "Must be at least 1 hash code to combine.";
        Preconditions.checkArgument(bl3, object3);
        object2 = (HashCode)object2.next();
        int n10 = ((HashCode)object2).bits() / 8;
        byte[] byArray = new byte[n10];
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object3 = ((HashCode)object.next()).asBytes();
            int n11 = ((Object)object3).length;
            n11 = n11 == n10 ? 1 : 0;
            String string2 = "All hashcodes must have the same bit length.";
            Preconditions.checkArgument(n11 != 0, string2);
            for (int i10 = 0; i10 < (n11 = ((Object)object3).length); ++i10) {
                n11 = byArray[i10] * 37;
                Object object4 = object3[i10];
                byArray[i10] = n11 = (int)((byte)(n11 ^ object4));
            }
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    public static HashCode combineUnordered(Iterable object) {
        boolean bl2;
        Object object2 = object.iterator();
        boolean bl3 = object2.hasNext();
        Object object3 = "Must be at least 1 hash code to combine.";
        Preconditions.checkArgument(bl3, object3);
        object2 = (HashCode)object2.next();
        int n10 = ((HashCode)object2).bits() / 8;
        byte[] byArray = new byte[n10];
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object3 = ((HashCode)object.next()).asBytes();
            int n11 = ((Object)object3).length;
            n11 = n11 == n10 ? 1 : 0;
            String string2 = "All hashcodes must have the same bit length.";
            Preconditions.checkArgument(n11 != 0, string2);
            for (int i10 = 0; i10 < (n11 = ((Object)object3).length); ++i10) {
                n11 = byArray[i10];
                Object object4 = object3[i10];
                byArray[i10] = n11 = (int)((byte)(n11 + object4));
            }
        }
        return HashCode.fromBytesNoCopy(byArray);
    }

    public static HashFunction concatenating(HashFunction object, HashFunction hashFunctionArray, HashFunction ... hashFunctionArray2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(object);
        arrayList.add(hashFunctionArray);
        object = Arrays.asList(hashFunctionArray2);
        arrayList.addAll((Collection<Object>)object);
        hashFunctionArray = new HashFunction[]{};
        hashFunctionArray = arrayList.toArray(hashFunctionArray);
        object = new Hashing$ConcatenatedHashFunction(hashFunctionArray, null);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public static HashFunction concatenating(Iterable object) {
        void var4_7;
        HashFunction[] hashFunctionArray;
        boolean bl2;
        Preconditions.checkNotNull(object);
        HashFunction[] hashFunctionArray2 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            hashFunctionArray = (HashFunction[])object.next();
            hashFunctionArray2.add(hashFunctionArray);
        }
        int bl3 = hashFunctionArray2.size();
        bl2 = false;
        hashFunctionArray = null;
        if (bl3 > 0) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            object = null;
        }
        int n10 = hashFunctionArray2.size();
        Preconditions.checkArgument((boolean)var4_7, "number of hash functions (%s) must be > 0", n10);
        hashFunctionArray = new HashFunction[]{};
        hashFunctionArray2 = hashFunctionArray2.toArray(hashFunctionArray);
        object = new Hashing$ConcatenatedHashFunction(hashFunctionArray2, null);
        return object;
    }

    public static int consistentHash(long l10, int n10) {
        Hashing$LinearCongruentialGenerator hashing$LinearCongruentialGenerator;
        boolean bl2;
        int n11 = 0;
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            hashing$LinearCongruentialGenerator = null;
        }
        String string2 = "buckets must be positive: %s";
        Preconditions.checkArgument(bl2, string2, n10);
        hashing$LinearCongruentialGenerator = new Hashing$LinearCongruentialGenerator(l10);
        while (true) {
            double d10 = n11 + 1;
            double d11 = hashing$LinearCongruentialGenerator.nextDouble();
            int n12 = (int)(d10 /= d11);
            if (n12 < 0 || n12 >= n10) break;
            n11 = n12;
        }
        return n11;
    }

    public static int consistentHash(HashCode hashCode, int n10) {
        return Hashing.consistentHash(hashCode.padToLong(), n10);
    }

    public static HashFunction crc32() {
        return Hashing$ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    public static HashFunction goodFastHash(int n10) {
        HashFunction hashFunction;
        int n11;
        if ((n10 = Hashing.checkPositiveAndMakeMultipleOf32(n10)) == (n11 = 32)) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        n11 = 128;
        if (n10 <= n11) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        n10 = (n10 + 127) / n11;
        HashFunction[] hashFunctionArray = new HashFunction[n10];
        hashFunctionArray[0] = hashFunction = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int n12 = GOOD_FAST_HASH_SEED;
        for (int i10 = 1; i10 < n10; ++i10) {
            HashFunction hashFunction2;
            int n13 = 1500450271;
            hashFunctionArray[i10] = hashFunction2 = Hashing.murmur3_128(n12 += n13);
        }
        Hashing$ConcatenatedHashFunction hashing$ConcatenatedHashFunction = new Hashing$ConcatenatedHashFunction(hashFunctionArray, null);
        return hashing$ConcatenatedHashFunction;
    }

    public static HashFunction hmacMd5(Key key) {
        String string2 = Hashing.hmacToString("hmacMd5", key);
        MacHashFunction macHashFunction = new MacHashFunction("HmacMD5", key, string2);
        return macHashFunction;
    }

    public static HashFunction hmacMd5(byte[] byArray) {
        byArray = (byte[])Preconditions.checkNotNull(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "HmacMD5");
        return Hashing.hmacMd5(secretKeySpec);
    }

    public static HashFunction hmacSha1(Key key) {
        String string2 = Hashing.hmacToString("hmacSha1", key);
        MacHashFunction macHashFunction = new MacHashFunction("HmacSHA1", key, string2);
        return macHashFunction;
    }

    public static HashFunction hmacSha1(byte[] byArray) {
        byArray = (byte[])Preconditions.checkNotNull(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "HmacSHA1");
        return Hashing.hmacSha1(secretKeySpec);
    }

    public static HashFunction hmacSha256(Key key) {
        String string2 = Hashing.hmacToString("hmacSha256", key);
        MacHashFunction macHashFunction = new MacHashFunction("HmacSHA256", key, string2);
        return macHashFunction;
    }

    public static HashFunction hmacSha256(byte[] byArray) {
        byArray = (byte[])Preconditions.checkNotNull(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "HmacSHA256");
        return Hashing.hmacSha256(secretKeySpec);
    }

    public static HashFunction hmacSha512(Key key) {
        String string2 = Hashing.hmacToString("hmacSha512", key);
        MacHashFunction macHashFunction = new MacHashFunction("HmacSHA512", key, string2);
        return macHashFunction;
    }

    public static HashFunction hmacSha512(byte[] byArray) {
        byArray = (byte[])Preconditions.checkNotNull(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "HmacSHA512");
        return Hashing.hmacSha512(secretKeySpec);
    }

    private static String hmacToString(String string2, Key key) {
        Object[] objectArray = new Object[3];
        objectArray[0] = string2;
        string2 = key.getAlgorithm();
        objectArray[1] = string2;
        string2 = key.getFormat();
        objectArray[2] = string2;
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", objectArray);
    }

    public static HashFunction md5() {
        return Hashing$Md5Holder.MD5;
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction murmur3_128(int n10) {
        Murmur3_128HashFunction murmur3_128HashFunction = new Murmur3_128HashFunction(n10);
        return murmur3_128HashFunction;
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    public static HashFunction murmur3_32(int n10) {
        Murmur3_32HashFunction murmur3_32HashFunction = new Murmur3_32HashFunction(n10);
        return murmur3_32HashFunction;
    }

    public static HashFunction sha1() {
        return Hashing$Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Hashing$Sha256Holder.SHA_256;
    }

    public static HashFunction sha384() {
        return Hashing$Sha384Holder.SHA_384;
    }

    public static HashFunction sha512() {
        return Hashing$Sha512Holder.SHA_512;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static HashFunction sipHash24(long l10, long l11) {
        SipHashFunction sipHashFunction = new SipHashFunction(2, 4, l10, l11);
        return sipHashFunction;
    }
}

