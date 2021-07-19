/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.cache.CachedContent;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CachedContentIndex$LegacyStorage
implements CachedContentIndex$Storage {
    private static final int FLAG_ENCRYPTED_INDEX = 1;
    private static final int VERSION = 2;
    private static final int VERSION_METADATA_INTRODUCED = 2;
    private final AtomicFile atomicFile;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private boolean changed;
    private final Cipher cipher;
    private final boolean encrypt;
    private final SecureRandom random;
    private final SecretKeySpec secretKeySpec;

    /*
     * WARNING - void declaration
     */
    public CachedContentIndex$LegacyStorage(File file, byte[] object, boolean bl2) {
        SecretKeySpec secretKeySpec;
        SecureRandom secureRandom;
        Cipher cipher;
        block10: {
            boolean bl3;
            boolean bl4 = false;
            cipher = null;
            boolean bl5 = true;
            if (object == null && bl2) {
                bl3 = false;
                secureRandom = null;
            } else {
                bl3 = bl5;
            }
            Assertions.checkState(bl3);
            bl3 = false;
            secureRandom = null;
            if (object != null) {
                void var1_4;
                int n10 = ((byte[])object).length;
                int n11 = 16;
                if (n10 == n11) {
                    bl4 = bl5;
                }
                Assertions.checkArgument(bl4);
                cipher = CachedContentIndex.access$000();
                String string2 = "AES";
                try {
                    secretKeySpec = new SecretKeySpec((byte[])object, string2);
                    break block10;
                }
                catch (NoSuchPaddingException noSuchPaddingException) {
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    // empty catch block
                }
                object = new IllegalStateException;
                super((Throwable)var1_4);
                throw object;
            }
            boolean bl6 = bl2 ^ true;
            Assertions.checkArgument(bl6);
            bl4 = false;
            cipher = null;
            bl5 = false;
            secretKeySpec = null;
        }
        this.encrypt = bl2;
        this.cipher = cipher;
        this.secretKeySpec = secretKeySpec;
        if (bl2) {
            secureRandom = new SecureRandom();
        }
        this.random = secureRandom;
        object = new AtomicFile;
        super(file);
        this.atomicFile = object;
    }

    private int hashCachedContent(CachedContent object, int n10) {
        int n11;
        int n12 = ((CachedContent)object).id * 31;
        String string2 = ((CachedContent)object).key;
        int n13 = string2.hashCode();
        n12 += n13;
        n13 = 2;
        if (n10 < n13) {
            object = ((CachedContent)object).getMetadata();
            long l10 = ContentMetadata.getContentLength((ContentMetadata)object);
            n12 *= 31;
            n13 = 32;
            long l11 = l10 >>> n13;
            n11 = (int)(l10 ^= l11);
        } else {
            n12 *= 31;
            object = ((CachedContent)object).getMetadata();
            n11 = ((DefaultContentMetadata)object).hashCode();
        }
        return n12 + n11;
    }

    private CachedContent readCachedContent(int n10, DataInputStream object) {
        DefaultContentMetadata defaultContentMetadata;
        int n11 = ((DataInputStream)object).readInt();
        String string2 = ((DataInputStream)object).readUTF();
        int n12 = 2;
        if (n10 < n12) {
            long l10 = ((DataInputStream)object).readLong();
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, l10);
            defaultContentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
        } else {
            defaultContentMetadata = CachedContentIndex.access$100((DataInputStream)object);
        }
        object = new CachedContent(n11, string2, defaultContentMetadata);
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean readFile(HashMap var1_1, SparseArray var2_7) {
        block21: {
            block20: {
                block18: {
                    block23: {
                        block19: {
                            var3_9 = this.atomicFile;
                            var4_10 = var3_9.exists();
                            var5_11 = 1;
                            if (var4_10 == 0) {
                                return (boolean)var5_11;
                            }
                            var4_10 = 0;
                            var3_9 = null;
                            var7_13 = this.atomicFile;
                            var7_13 = var7_13.openRead();
                            var6_12 = new BufferedInputStream((InputStream)var7_13);
                            var7_13 = new DataInputStream(var6_12);
                            try {
                                var4_10 = var7_13.readInt();
                                if (var4_10 < 0 || var4_10 > (var8_14 = 2)) break block18;
                                var9_15 = var7_13.readInt() & var5_11;
                                if (var9_15 != 0) {
                                    var10_16 = this.cipher;
                                    if (var10_16 != null) break block19;
                                }
                                ** GOTO lbl52
                            }
                            catch (Throwable var1_5) {
                                var3_9 = var7_13;
                                break block20;
                            }
                            catch (IOException v0) {
                                var3_9 = var7_13;
                                break block21;
                            }
                            Util.closeQuietly((Closeable)var7_13);
                            return false;
                        }
                        var9_15 = 16;
                        {
                            block22: {
                                var10_16 = new byte[var9_15];
                                var7_13.readFully((byte[])var10_16);
                                var11_17 = new IvParameterSpec((byte[])var10_16);
                                try {
                                    var10_16 = this.cipher;
                                    var12_18 = this.secretKeySpec;
                                    var12_18 = Util.castNonNull(var12_18);
                                    var12_18 = (Key)var12_18;
                                    var10_16.init(var8_14, (Key)var12_18, (AlgorithmParameterSpec)var11_17);
                                    var11_17 = this.cipher;
                                    var10_16 = new CipherInputStream(var6_12, (Cipher)var11_17);
                                    var13_19 = new DataInputStream((InputStream)var10_16);
                                    var7_13 = var13_19;
                                    break block22;
                                }
                                catch (InvalidAlgorithmParameterException var1_2) {
                                }
                                catch (InvalidKeyException var1_3) {
                                    // empty catch block
                                }
                                var2_8 = new IllegalStateException((Throwable)var1_4);
                                throw var2_8;
lbl52:
                                // 1 sources

                                var14_20 = this.encrypt;
                                if (var14_20 != 0) {
                                    this.changed = var5_11;
                                }
                            }
                            var14_20 = var7_13.readInt();
                            var13_19 = null;
                            var9_15 = 0;
                            var10_16 = null;
                            for (var8_14 = 0; var8_14 < var14_20; var9_15 += var17_23, ++var8_14) {
                                var11_17 = this.readCachedContent(var4_10, (DataInputStream)var7_13);
                                var12_18 = var11_17.key;
                                var1_1.put(var12_18, var11_17);
                                var15_21 = var11_17.id;
                                var16_22 = var11_17.key;
                                var2_8.put(var15_21, var16_22);
                                var17_23 = this.hashCachedContent((CachedContent)var11_17, var4_10);
                            }
                            var18_24 = var7_13.readInt();
                            var19_25 = var7_13.read();
                            if (var19_25 == (var4_10 = -1)) {
                                var19_25 = var5_11;
                            } else {
                                var19_25 = 0;
                                var2_8 = null;
                            }
                            if (var18_24 != var9_15 || var19_25 == 0) break block23;
                        }
                        Util.closeQuietly((Closeable)var7_13);
                        return (boolean)var5_11;
                    }
                    Util.closeQuietly((Closeable)var7_13);
                    return false;
                }
                Util.closeQuietly((Closeable)var7_13);
                return false;
                catch (Throwable var1_6) {
                    // empty catch block
                }
            }
            if (var3_9 != null) {
                Util.closeQuietly((Closeable)var3_9);
            }
            throw var1_7;
            catch (IOException v1) {}
        }
        if (var3_9 != null) {
            Util.closeQuietly((Closeable)var3_9);
        }
        return false;
    }

    private void writeCachedContent(CachedContent cachedContent, DataOutputStream dataOutputStream) {
        int n10 = cachedContent.id;
        dataOutputStream.writeInt(n10);
        String string2 = cachedContent.key;
        dataOutputStream.writeUTF(string2);
        CachedContentIndex.access$200(cachedContent.getMetadata(), dataOutputStream);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void writeFile(HashMap object) {
        void var1_7;
        Object object2;
        block13: {
            int n10;
            Object object3;
            Object object4;
            object2 = null;
            try {
                object4 = this.atomicFile;
                object4 = ((AtomicFile)object4).startWrite();
                object3 = this.bufferedOutputStream;
                if (object3 == null) {
                    object3 = new ReusableBufferedOutputStream((OutputStream)object4);
                    this.bufferedOutputStream = object3;
                } else {
                    ((ReusableBufferedOutputStream)object3).reset((OutputStream)object4);
                }
                object4 = this.bufferedOutputStream;
                object3 = new DataOutputStream((OutputStream)object4);
                n10 = 2;
            }
            catch (Throwable throwable) {
                // empty catch block
                break block13;
            }
            try {
                int n11;
                block14: {
                    Object object5;
                    ((DataOutputStream)object3).writeInt(n10);
                    int n12 = this.encrypt;
                    int n13 = 1;
                    n11 = 0;
                    if (n12 != 0) {
                        n12 = n13;
                    } else {
                        n12 = 0;
                        object5 = null;
                    }
                    ((DataOutputStream)object3).writeInt(n12);
                    n12 = (int)(this.encrypt ? 1 : 0);
                    if (n12 != 0) {
                        void var1_4;
                        n12 = 16;
                        object5 = new byte[n12];
                        Object object6 = this.random;
                        object6 = Util.castNonNull(object6);
                        object6 = (SecureRandom)object6;
                        ((SecureRandom)object6).nextBytes((byte[])object5);
                        ((FilterOutputStream)object3).write((byte[])object5);
                        object6 = new IvParameterSpec((byte[])object5);
                        try {
                            object5 = this.cipher;
                            object5 = Util.castNonNull(object5);
                            object5 = (Cipher)object5;
                            Object object7 = this.secretKeySpec;
                            object7 = Util.castNonNull(object7);
                            object7 = (Key)object7;
                            ((Cipher)object5).init(n13, (Key)object7, (AlgorithmParameterSpec)object6);
                            ((DataOutputStream)object3).flush();
                            object6 = this.cipher;
                            CipherOutputStream cipherOutputStream = new CipherOutputStream((OutputStream)object4, (Cipher)object6);
                            object3 = object5 = new DataOutputStream(cipherOutputStream);
                            break block14;
                        }
                        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                        }
                        catch (InvalidKeyException invalidKeyException) {
                            // empty catch block
                        }
                        object2 = new IllegalStateException((Throwable)var1_4);
                        throw object2;
                    }
                }
                int n14 = ((HashMap)object).size();
                ((DataOutputStream)object3).writeInt(n14);
                object = ((HashMap)object).values();
                object = object.iterator();
                while ((n14 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object4 = object.next();
                    object4 = (CachedContent)object4;
                    this.writeCachedContent((CachedContent)object4, (DataOutputStream)object3);
                    n14 = this.hashCachedContent((CachedContent)object4, n10);
                    n11 += n14;
                }
                ((DataOutputStream)object3).writeInt(n11);
                object = this.atomicFile;
                ((AtomicFile)object).endWrite((OutputStream)object3);
            }
            catch (Throwable throwable) {
                object2 = object3;
                break block13;
            }
            Util.closeQuietly(null);
            return;
        }
        Util.closeQuietly(object2);
        throw var1_7;
    }

    public void delete() {
        this.atomicFile.delete();
    }

    public boolean exists() {
        return this.atomicFile.exists();
    }

    public void initialize(long l10) {
    }

    public void load(HashMap object, SparseArray sparseArray) {
        Assertions.checkState(this.changed ^ true);
        boolean bl2 = this.readFile((HashMap)object, sparseArray);
        if (!bl2) {
            ((HashMap)object).clear();
            sparseArray.clear();
            object = this.atomicFile;
            ((AtomicFile)object).delete();
        }
    }

    public void onRemove(CachedContent cachedContent, boolean bl2) {
        this.changed = true;
    }

    public void onUpdate(CachedContent cachedContent) {
        this.changed = true;
    }

    public void storeFully(HashMap hashMap) {
        this.writeFile(hashMap);
        this.changed = false;
    }

    public void storeIncremental(HashMap hashMap) {
        boolean bl2 = this.changed;
        if (!bl2) {
            return;
        }
        this.storeFully(hashMap);
    }
}

