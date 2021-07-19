/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AesFlushingCipher(int n10, byte[] object, long l10, long l11) {
        void var19_24;
        Object object2 = "AES/CTR/NoPadding";
        try {
            void var3_5;
            void var5_6;
            int n11;
            this.cipher = object2 = Cipher.getInstance((String)object2);
            this.blockSize = n11 = ((Cipher)object2).getBlockSize();
            byte[] byArray = new byte[n11];
            this.zerosBlock = byArray;
            byArray = new byte[n11];
            this.flushedBlock = byArray;
            long l12 = n11;
            l12 = var5_6 / l12;
            long l13 = n11;
            int n12 = (int)(var5_6 %= l13);
            String string2 = ((Cipher)object2).getAlgorithm();
            String string3 = "/";
            String[] stringArray = Util.splitAtFirst(string2, string3);
            string3 = null;
            String string4 = stringArray[0];
            SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])object, string4);
            byte[] byArray2 = this.getInitializationVector((long)var3_5, l12);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray2);
            ((Cipher)object2).init(n10, (Key)secretKeySpec, ivParameterSpec);
            if (n12 != 0) {
                byte[] byArray3 = new byte[n12];
                this.updateInPlace(byArray3, 0, n12);
            }
            return;
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
        }
        catch (InvalidKeyException invalidKeyException) {
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        RuntimeException runtimeException = new RuntimeException((Throwable)var19_24);
        throw runtimeException;
    }

    private byte[] getInitializationVector(long l10, long l11) {
        return ByteBuffer.allocate(16).putLong(l10).putLong(l11).array();
    }

    private int nonFlushingUpdate(byte[] byArray, int n10, int n11, byte[] byArray2, int n12) {
        Cipher cipher;
        try {
            cipher = this.cipher;
        }
        catch (ShortBufferException shortBufferException) {
            RuntimeException runtimeException = new RuntimeException(shortBufferException);
            throw runtimeException;
        }
        return cipher.update(byArray, n10, n11, byArray2, n12);
    }

    public void update(byte[] byArray, int n10, int n11, byte[] byArray2, int n12) {
        byte[] byArray3;
        int n13;
        int n14;
        byte[] byArray4;
        int n15;
        int n16 = n10;
        while ((n10 = this.pendingXorBytes) > 0) {
            n15 = byArray[n16];
            byArray4 = this.flushedBlock;
            n14 = this.blockSize - n10;
            n13 = byArray4[n14];
            byArray2[n12] = n15 = (byte)(n15 ^ n13);
            ++n12;
            ++n16;
            this.pendingXorBytes = n10 += -1;
            if ((n11 += -1) != 0) continue;
            return;
        }
        byArray4 = byArray;
        n14 = n11;
        int n17 = n12;
        int n18 = this.nonFlushingUpdate(byArray, n16, n11, byArray2, n12);
        if (n11 == n18) {
            return;
        }
        n10 = this.blockSize;
        n15 = 0;
        n13 = 1;
        if ((n11 -= n18) < n10) {
            n10 = n13;
        } else {
            n10 = 0;
            byArray3 = null;
        }
        Assertions.checkState(n10 != 0);
        n12 += n18;
        this.pendingXorBytes = n17 = this.blockSize - n11;
        byte[] byArray5 = this.zerosBlock;
        byte[] byArray6 = this.flushedBlock;
        n18 = this.nonFlushingUpdate(byArray5, 0, n17, byArray6, 0);
        n10 = this.blockSize;
        if (n18 != n10) {
            n13 = 0;
            byArray4 = null;
        }
        Assertions.checkState(n13 != 0);
        while (n15 < n11) {
            n18 = n12 + 1;
            byArray3 = this.flushedBlock;
            byArray2[n12] = n10 = byArray3[n15];
            ++n15;
            n12 = n18;
        }
    }

    public void updateInPlace(byte[] byArray, int n10, int n11) {
        this.update(byArray, n10, n11, byArray, n10);
    }
}

