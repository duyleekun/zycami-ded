/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryVersion {
    private static final GmsLogger zza;
    private static LibraryVersion zzb;
    private ConcurrentHashMap zzc;

    static {
        Object object = new GmsLogger("LibraryVersion", "");
        zza = object;
        zzb = object = new LibraryVersion();
    }

    public LibraryVersion() {
        ConcurrentHashMap concurrentHashMap;
        this.zzc = concurrentHashMap = new ConcurrentHashMap();
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getVersion(String var1_1) {
        block13: {
            block14: {
                block15: {
                    var2_5 = "Failed to get app version for libraryName: ";
                    var3_6 = "LibraryVersion";
                    Preconditions.checkNotEmpty(var1_1, "Please provide a valid libraryName");
                    var4_7 = this.zzc;
                    var5_10 = var4_7.containsKey(var1_1);
                    if (var5_10) {
                        return (String)this.zzc.get(var1_1);
                    }
                    var4_7 = new Properties();
                    var6_11 = null;
                    var7_12 = "/%s.properties";
                    var8_13 = 1;
                    try {
                        var9_14 = new Object[var8_13];
                        var10_15 = 0;
                        var11_16 = null;
                        var9_14[0] = var1_1;
                        var7_12 = String.format((String)var7_12, (Object[])var9_14);
                        var9_14 = LibraryVersion.class;
                        var7_12 = var9_14.getResourceAsStream((String)var7_12);
                        if (var7_12 != null) {
                        }
                        ** GOTO lbl49
                    }
                    catch (Throwable var1_3) {
                        break block13;
                    }
                    catch (IOException var4_9) {
                        var7_12 = null;
                        ** GOTO lbl-1000
                    }
                    try {
                        block16: {
                            var4_7.load((InputStream)var7_12);
                            var9_14 = "version";
                            var6_11 = var4_7.getProperty((String)var9_14, null);
                            var4_7 = LibraryVersion.zza;
                            var9_14 = String.valueOf(var1_1);
                            var8_13 = var9_14.length() + 12;
                            var11_16 = String.valueOf(var6_11);
                            var10_15 = var11_16.length();
                            var11_16 = new StringBuilder(var8_13 += var10_15);
                            var11_16.append(var1_1);
                            var9_14 = " version is ";
                            var11_16.append((String)var9_14);
                            var11_16.append((String)var6_11);
                            var9_14 = var11_16.toString();
                            var4_7.v(var3_6, (String)var9_14);
                            break block16;
lbl49:
                            // 1 sources

                            var4_7 = LibraryVersion.zza;
                            var9_14 = String.valueOf(var1_1);
                            var10_15 = var9_14.length();
                            var9_14 = var10_15 != 0 ? var2_5.concat((String)var9_14) : new String((String)var2_5);
                            var4_7.w(var3_6, (String)var9_14);
                        }
                        if (var7_12 == null) break block14;
                    }
                    catch (Throwable var1_2) {
                        var6_11 = var7_12;
                        break block13;
                    }
                    catch (IOException var4_8) {
                        var12_17 = var7_12;
                        var7_12 = var6_11;
                        var6_11 = var12_17;
                        ** GOTO lbl-1000
                    }
                    IOUtils.closeQuietly((Closeable)var7_12);
                    break block14;
lbl-1000:
                    // 2 sources

                    {
                        var9_14 = LibraryVersion.zza;
                        var11_16 = String.valueOf(var1_1);
                        var13_18 = var11_16.length();
                        if (var13_18 != 0) {
                            var2_5 = var2_5.concat((String)var11_16);
                        } else {
                            var11_16 = new String((String)var2_5);
                            var2_5 = var11_16;
                        }
                        var9_14.e(var3_6, (String)var2_5, (Throwable)var4_7);
                        if (var6_11 == null) break block15;
                    }
                    IOUtils.closeQuietly((Closeable)var6_11);
                }
                var6_11 = var7_12;
            }
            if (var6_11 == null) {
                var2_5 = LibraryVersion.zza;
                var4_7 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used";
                var2_5.d(var3_6, (String)var4_7);
                var6_11 = "UNKNOWN";
            }
            this.zzc.put(var1_1, var6_11);
            return var6_11;
        }
        if (var6_11 != null) {
            IOUtils.closeQuietly(var6_11);
        }
        throw var1_4;
    }
}

