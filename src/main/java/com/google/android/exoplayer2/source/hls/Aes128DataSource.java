/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes128DataSource
implements DataSource {
    private CipherInputStream cipherInputStream;
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final DataSource upstream;

    public Aes128DataSource(DataSource dataSource, byte[] byArray, byte[] byArray2) {
        this.upstream = dataSource;
        this.encryptionKey = byArray;
        this.encryptionIv = byArray2;
    }

    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    public void close() {
        Object object = this.cipherInputStream;
        if (object != null) {
            this.cipherInputStream = null;
            object = this.upstream;
            object.close();
        }
    }

    public Cipher getCipherInstance() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    public final Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public final Uri getUri() {
        return this.upstream.getUri();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long open(DataSpec object) {
        void var1_7;
        block6: {
            void var1_4;
            Object object2;
            block7: {
                Object object4;
                Object object3;
                try {
                    object2 = this.getCipherInstance();
                    object3 = this.encryptionKey;
                    object4 = new SecretKeySpec((byte[])object3, "AES");
                }
                catch (NoSuchPaddingException noSuchPaddingException) {
                    break block6;
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    // empty catch block
                    break block6;
                }
                object3 = new IvParameterSpec;
                byte[] byArray = this.encryptionIv;
                object3(byArray);
                int n10 = 2;
                try {
                    ((Cipher)object2).init(n10, (Key)object4, (AlgorithmParameterSpec)object3);
                }
                catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                    break block7;
                }
                catch (InvalidKeyException invalidKeyException) {
                    // empty catch block
                    break block7;
                }
                object3 = this.upstream;
                object4 = new DataSourceInputStream((DataSource)object3, (DataSpec)object);
                this.cipherInputStream = object = new CipherInputStream((InputStream)object4, (Cipher)object2);
                ((DataSourceInputStream)object4).open();
                return -1;
            }
            object2 = new RuntimeException((Throwable)var1_4);
            throw object2;
        }
        RuntimeException runtimeException = new RuntimeException((Throwable)var1_7);
        throw runtimeException;
    }

    public final int read(byte[] byArray, int n10, int n11) {
        Assertions.checkNotNull(this.cipherInputStream);
        CipherInputStream cipherInputStream = this.cipherInputStream;
        int n12 = cipherInputStream.read(byArray, n10, n11);
        if (n12 < 0) {
            n12 = -1;
        }
        return n12;
    }
}

