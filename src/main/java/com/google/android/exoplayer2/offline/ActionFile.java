/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadRequest$Builder;
import com.google.android.exoplayer2.offline.DownloadRequest$UnsupportedRequestException;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class ActionFile {
    private static final String DOWNLOAD_TYPE_DASH = "dash";
    private static final String DOWNLOAD_TYPE_HLS = "hls";
    private static final String DOWNLOAD_TYPE_PROGRESSIVE = "progressive";
    private static final String DOWNLOAD_TYPE_SS = "ss";
    private static final int VERSION;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        AtomicFile atomicFile;
        this.atomicFile = atomicFile = new AtomicFile(file);
    }

    private static String generateDownloadId(Uri uri, String string2) {
        if (string2 == null) {
            string2 = uri.toString();
        }
        return string2;
    }

    /*
     * Unable to fully structure code
     */
    private static String inferMimeType(String var0) {
        block8: {
            block5: {
                block6: {
                    block7: {
                        var1_1 = var0.hashCode();
                        var2_2 = 3680;
                        var3_3 = 2;
                        var4_4 = 1;
                        if (var1_1 == var2_2) break block5;
                        var2_2 = 103407;
                        if (var1_1 == var2_2) break block6;
                        var2_2 = 3075986;
                        if (var1_1 == var2_2) break block7;
                        var2_2 = 1131547531;
                        if (var1_1 != var2_2 || (var6_9 = (int)var0.equals(var5_5 = "progressive")) == 0) ** GOTO lbl-1000
                        var6_9 = 3;
                        break block8;
                    }
                    var5_6 = "dash";
                    var6_9 = (int)var0.equals(var5_6);
                    if (var6_9 == 0) ** GOTO lbl-1000
                    var6_9 = 0;
                    var0 = null;
                    break block8;
                }
                var5_7 = "hls";
                var6_9 = (int)var0.equals(var5_7);
                if (var6_9 == 0) ** GOTO lbl-1000
                var6_9 = var4_4;
                break block8;
            }
            var5_8 = "ss";
            var6_9 = var0.equals(var5_8);
            if (var6_9 != 0) {
                var6_9 = var3_3;
            } else lbl-1000:
            // 4 sources

            {
                var6_9 = -1;
            }
        }
        if (var6_9 != 0) {
            if (var6_9 != var4_4) {
                if (var6_9 != var3_3) {
                    return "video/x-unknown";
                }
                return "application/vnd.ms-sstr+xml";
            }
            return "application/x-mpegURL";
        }
        return "application/dash+xml";
    }

    private static DownloadRequest readDownloadRequest(DataInputStream object) {
        String string2;
        int n10;
        byte[] byArray;
        String string3 = ((DataInputStream)object).readUTF();
        int n11 = ((DataInputStream)object).readInt();
        Uri uri = Uri.parse((String)((DataInputStream)object).readUTF());
        boolean bl2 = ((DataInputStream)object).readBoolean();
        int n12 = ((DataInputStream)object).readInt();
        String string4 = null;
        if (n12 != 0) {
            byArray = new byte[n12];
            ((DataInputStream)object).readFully(byArray);
        } else {
            n12 = 0;
            byArray = null;
        }
        int n13 = 1;
        if (n11 == 0 && (n10 = (string2 = DOWNLOAD_TYPE_PROGRESSIVE).equals(string3)) != 0) {
            n10 = n13;
        } else {
            n10 = 0;
            string2 = null;
        }
        ArrayList<StreamKey> arrayList = new ArrayList<StreamKey>();
        if (n10 == 0) {
            n10 = ((DataInputStream)object).readInt();
            for (int i10 = 0; i10 < n10; ++i10) {
                StreamKey streamKey = ActionFile.readKey(string3, n11, (DataInputStream)object);
                arrayList.add(streamKey);
            }
        }
        if (n11 >= (n10 = 2) || (n10 = (int)((string2 = DOWNLOAD_TYPE_DASH).equals(string3) ? 1 : 0)) == 0 && (n10 = (int)((string2 = DOWNLOAD_TYPE_HLS).equals(string3) ? 1 : 0)) == 0 && (n10 = (int)((string2 = DOWNLOAD_TYPE_SS).equals(string3) ? 1 : 0)) == 0) {
            n13 = 0;
        }
        if (n13 == 0 && (n13 = (int)(((DataInputStream)object).readBoolean() ? 1 : 0)) != 0) {
            string4 = ((DataInputStream)object).readUTF();
        }
        object = n11 < (n13 = 3) ? ActionFile.generateDownloadId(uri, string4) : ((DataInputStream)object).readUTF();
        if (!bl2) {
            DownloadRequest$Builder downloadRequest$Builder = new DownloadRequest$Builder((String)object, uri);
            object = ActionFile.inferMimeType(string3);
            return downloadRequest$Builder.setMimeType((String)object).setStreamKeys(arrayList).setCustomCacheKey(string4).setData(byArray).build();
        }
        object = new DownloadRequest$UnsupportedRequestException();
        throw object;
    }

    private static StreamKey readKey(String string2, int n10, DataInputStream dataInputStream) {
        int n11;
        int n12;
        Object object = DOWNLOAD_TYPE_HLS;
        boolean bl2 = ((String)object).equals(string2);
        if ((bl2 || (n12 = (int)(((String)(object = DOWNLOAD_TYPE_SS)).equals(string2) ? 1 : 0)) != 0) && n10 == 0) {
            n12 = 0;
            string2 = null;
            n10 = dataInputStream.readInt();
            n11 = dataInputStream.readInt();
        } else {
            n12 = dataInputStream.readInt();
            n10 = dataInputStream.readInt();
            n11 = dataInputStream.readInt();
        }
        object = new StreamKey(n12, n10, n11);
        return object;
    }

    public void delete() {
        this.atomicFile.delete();
    }

    public boolean exists() {
        return this.atomicFile.exists();
    }

    /*
     * Unable to fully structure code
     */
    public DownloadRequest[] load() {
        block23: {
            var1_1 = this.exists();
            var2_2 = null;
            if (!var1_1) {
                return new DownloadRequest[0];
            }
            var1_1 = false;
            var3_4 = null;
            var4_5 = this.atomicFile;
            var3_4 = var4_5.openRead();
            var4_5 = new DataInputStream(var3_4);
            var5_6 = var4_5.readInt();
            if (var5_6 > 0) break block23;
            var5_6 = var4_5.readInt();
            var6_7 = new ArrayList<DownloadRequest>();
            block20: for (var7_9 = 0; var7_9 < var5_6; ++var7_9) {
                var8_10 = ActionFile.readDownloadRequest((DataInputStream)var4_5);
                var6_7.add(var8_10);
lbl25:
                // 2 sources

                continue block20;
            }
            try {
                var2_2 = new DownloadRequest[]{};
            }
lbl29:
            // 14 sources

            catch (Throwable var2_3) {
                Util.closeQuietly(var3_4);
                throw var2_3;
            }
            var2_2 = var6_7.toArray(var2_2);
            ** try [egrp 11[TRYBLOCK] [14 : 118->122)] { 
lbl35:
            // 1 sources

            Util.closeQuietly(var3_4);
            return var2_2;
        }
        var9_11 = 44;
        var6_8 = new StringBuilder(var9_11);
        var4_5 = "Unsupported action file version: ";
        var6_8.append((String)var4_5);
        var6_8.append(var5_6);
        var4_5 = var6_8.toString();
        var2_2 = new IOException((String)var4_5);
        throw var2_2;
        catch (DownloadRequest$UnsupportedRequestException v0) {
            ** continue;
        }
    }
}

