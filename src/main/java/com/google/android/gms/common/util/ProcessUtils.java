/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 */
package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.util.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class ProcessUtils {
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    public static String getMyProcessName() {
        String string2 = zza;
        if (string2 == null) {
            int n10 = zzb;
            if (n10 == 0) {
                zzb = n10 = Process.myPid();
            }
            n10 = zzb;
            zza = string2 = ProcessUtils.zza(n10);
        }
        return zza;
    }

    private static BufferedReader zza(String string2) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            FileReader fileReader = new FileReader(string2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String zza(int n10) {
        void var1_4;
        Object object;
        String string2;
        block7: {
            string2 = null;
            if (n10 <= 0) {
                return null;
            }
            int n11 = 25;
            StringBuilder stringBuilder = new StringBuilder(n11);
            String string3 = "/proc/";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            object = "/cmdline";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object = ProcessUtils.zza((String)object);
            try {
                string3 = ((BufferedReader)object).readLine();
                string2 = string3.trim();
            }
            catch (Throwable throwable) {
                break block7;
            }
            IOUtils.closeQuietly((Closeable)object);
            return string2;
            catch (Throwable throwable) {
                n10 = 0;
                object = null;
            }
        }
        IOUtils.closeQuietly(object);
        throw var1_4;
        catch (IOException iOException) {
            block8: {
                n10 = 0;
                object = null;
                break block8;
                catch (IOException iOException2) {}
            }
            IOUtils.closeQuietly(object);
        }
        return string2;
    }
}

