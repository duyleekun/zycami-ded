/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource$ContentDataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class ContentDataSource
extends BaseDataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public ContentDataSource(Context context) {
        super(false);
        context = context.getContentResolver();
        this.resolver = context;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Throwable throwable4222222;
        Throwable throwable22222222;
        boolean bl2;
        block19: {
            Throwable throwable32222222;
            bl2 = false;
            this.uri = null;
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.inputStream = null;
            {
                catch (Throwable throwable22222222) {
                    break block19;
                }
                catch (IOException iOException) {}
                {
                    ContentDataSource$ContentDataSourceException contentDataSource$ContentDataSourceException = new ContentDataSource$ContentDataSourceException(iOException);
                    throw contentDataSource$ContentDataSourceException;
                }
            }
            fileInputStream = this.assetFileDescriptor;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.assetFileDescriptor = null;
            bl2 = this.opened;
            if (!bl2) return;
            this.opened = false;
            this.transferEnded();
            return;
            {
                catch (Throwable throwable32222222) {
                }
                catch (IOException iOException) {}
                {
                    ContentDataSource$ContentDataSourceException contentDataSource$ContentDataSourceException = new ContentDataSource$ContentDataSourceException(iOException);
                    throw contentDataSource$ContentDataSourceException;
                }
            }
            this.assetFileDescriptor = null;
            bl2 = this.opened;
            if (!bl2) throw throwable32222222;
            this.opened = false;
            this.transferEnded();
            throw throwable32222222;
        }
        this.inputStream = null;
        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.assetFileDescriptor = null;
        bl2 = this.opened;
        if (!bl2) throw throwable22222222;
        this.opened = false;
        this.transferEnded();
        throw throwable22222222;
        {
            catch (Throwable throwable4222222) {
            }
            catch (IOException iOException) {}
            {
                ContentDataSource$ContentDataSourceException contentDataSource$ContentDataSourceException = new ContentDataSource$ContentDataSourceException(iOException);
                throw contentDataSource$ContentDataSourceException;
            }
        }
        this.assetFileDescriptor = null;
        bl2 = this.opened;
        if (!bl2) throw throwable4222222;
        this.opened = false;
        this.transferEnded();
        throw throwable4222222;
    }

    public Uri getUri() {
        return this.uri;
    }

    /*
     * Unable to fully structure code
     */
    public long open(DataSpec var1_1) {
        block33: {
            block34: {
                block37: {
                    block35: {
                        block36: {
                            try {
                                var2_3 = var1_1.uri;
                            }
                            catch (IOException var1_2) {
                                var2_3 = new ContentDataSource$ContentDataSourceException(var1_2);
                                throw var2_3;
                            }
                            this.uri = var2_3;
                            this.transferInitializing((DataSpec)var1_1);
                            var3_4 = this.resolver;
                            var4_5 = "r";
                            var3_4 = var3_4.openAssetFileDescriptor((Uri)var2_3, (String)var4_5);
                            this.assetFileDescriptor = var3_4;
                            if (var3_4 == null) break block33;
                            var4_5 = var3_4.getFileDescriptor();
                            var2_3 = new FileInputStream((FileDescriptor)var4_5);
                            this.inputStream = var2_3;
                            var5_6 = var3_4.getStartOffset();
                            var7_7 = var1_1.position + var5_6;
                            var7_7 = var2_3.skip(var7_7) - var5_6;
                            var5_6 = var1_1.position;
                            var9_8 = var7_7 == var5_6 ? 0 : (var7_7 < var5_6 ? -1 : 1);
                            if (var9_8 != false) break block34;
                            var5_6 = var1_1.length;
                            var10_9 = -1;
                            var12_10 = var5_6 == var10_9 ? 0 : (var5_6 < var10_9 ? -1 : 1);
                            if (var12_10 == false) ** GOTO lbl40
                            this.bytesRemaining = var5_6;
                            break block35;
lbl40:
                            // 1 sources

                            var13_11 = var3_4.getLength();
                            var15_12 = var13_11 == var10_9 ? 0 : (var13_11 < var10_9 ? -1 : 1);
                            var16_13 = 0L;
                            if (var15_12 != false) break block36;
                            var2_3 = var2_3.getChannel();
                            var13_11 = var2_3.size();
                            var15_12 = var13_11 == var16_13 ? 0 : (var13_11 < var16_13 ? -1 : 1);
                            if (var15_12 != false) ** GOTO lbl53
                            this.bytesRemaining = var10_9;
                            break block35;
lbl53:
                            // 1 sources

                            var18_14 = var2_3.position();
                            var13_11 -= var18_14;
                            this.bytesRemaining = var13_11;
                            var20_15 = var13_11 == var16_13 ? 0 : (var13_11 < var16_13 ? -1 : 1);
                            if (var20_15 >= 0) break block35;
                            var1_1 = new EOFException();
                            throw var1_1;
                        }
                        var13_11 -= var7_7;
                        this.bytesRemaining = var13_11;
                        var20_16 = var13_11 == var16_13 ? 0 : (var13_11 < var16_13 ? -1 : 1);
                        if (var20_16 < 0) break block37;
                    }
                    this.opened = true;
                    this.transferStarted((DataSpec)var1_1);
                    return this.bytesRemaining;
                }
                var1_1 = new EOFException();
                throw var1_1;
            }
            var1_1 = new EOFException();
            throw var1_1;
        }
        var2_3 = String.valueOf(var2_3);
        var3_4 = String.valueOf(var2_3);
        var21_17 = var3_4.length() + 36;
        var4_5 = new StringBuilder(var21_17);
        var3_4 = "Could not open file descriptor for: ";
        var4_5.append((String)var3_4);
        var4_5.append((String)var2_3);
        var2_3 = var4_5.toString();
        var1_1 = new FileNotFoundException((String)var2_3);
        throw var1_1;
    }

    public int read(byte[] object, int n10, int n11) {
        int n12;
        long l10;
        long l11;
        block11: {
            Object object2;
            if (n11 == 0) {
                return 0;
            }
            l11 = this.bytesRemaining;
            long l12 = 0L;
            Object object3 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            int n13 = -1;
            if (object3 == false) {
                return n13;
            }
            l10 = -1;
            long l13 = l11 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false) {
                long l14 = n11;
                l11 = Math.min(l11, l14);
                n11 = (int)l11;
            }
            try {
                object2 = this.inputStream;
            }
            catch (IOException iOException) {
                ContentDataSource$ContentDataSourceException contentDataSource$ContentDataSourceException = new ContentDataSource$ContentDataSourceException(iOException);
                throw contentDataSource$ContentDataSourceException;
            }
            object2 = Util.castNonNull(object2);
            object2 = (FileInputStream)object2;
            n12 = ((FileInputStream)object2).read((byte[])object, n10, n11);
            if (n12 != n13) break block11;
            long l15 = this.bytesRemaining;
            long l16 = l15 - l10;
            n12 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n12 == 0) {
                return n13;
            }
            object = new ContentDataSource$ContentDataSourceException;
            EOFException eOFException = new EOFException();
            object(eOFException);
            throw object;
        }
        long l17 = this.bytesRemaining;
        long l18 = l17 - l10;
        Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object4 != false) {
            l11 = n12;
            this.bytesRemaining = l17 -= l11;
        }
        this.bytesTransferred(n12);
        return n12;
    }
}

