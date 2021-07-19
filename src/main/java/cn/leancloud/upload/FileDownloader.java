/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.e;
import g.z;
import g.z$a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileDownloader {
    private static final int READ_BUF_SIZE = 8192;
    private static final AVLogger gLogger = LogUtil.getLogger(FileDownloader.class);

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AVException downloadFileFromNetwork(String var1_1, File var2_3) {
        var3_9 = new a0$a();
        var3_9.B((String)var1_1);
        var1_1 = this.getHttpClient();
        var3_9 = var3_9.b();
        var1_1 = var1_1.a((a0)var3_9);
        var1_1 = FirebasePerfOkHttpClient.execute((e)var1_1);
        var4_10 = var1_1.v0();
        var1_1 = var1_1.r0();
        var1_1 = var1_1.byteStream();
        var5_11 = var4_10 / 100;
        var6_12 = 2;
        if (var5_11 != var6_12 || var1_1 == null) ** GOTO lbl46
        var4_10 = 8192;
        var3_9 = new byte[var4_10];
        var7_13 = PersistenceUtil.sharedInstance();
        var8_14 = var2_3.getAbsolutePath();
        var7_13 = var7_13.getLock((String)var8_14);
        var7_13 = var7_13.writeLock();
        var6_12 = (int)var7_13.tryLock();
        var9_15 = null;
        if (var6_12 == 0) ** GOTO lbl-1000
        var8_14 = new FileOutputStream((File)var2_3, false);
        var10_16 = var1_1.read((byte[])var3_9);
        while (var10_16 > 0) {
            var8_14.write((byte[])var3_9, 0, var10_16);
            var10_16 = var1_1.read((byte[])var3_9);
        }
        var1_1.close();
        ** GOTO lbl51
        {
            catch (IOException v0) {}
        }
        catch (Throwable var2_4) {
            var9_15 = var8_14;
            ** GOTO lbl72
        }
        catch (Exception var2_5) {
            var9_15 = var8_14;
            ** GOTO lbl-1000
        }
lbl-1000:
        // 1 sources

        {
            var1_1 = FileDownloader.gLogger;
            var2_3 = "failed to lock writeLocker, skip to save network streaming to local cache.";
            var1_1.w((String)var2_3);
            return var9_15;
lbl46:
            // 1 sources

            var1_1 = "status code is invalid";
            var9_15 = new AVException(var4_10, (String)var1_1);
            var1_1 = FileDownloader.gLogger;
            var1_1.w((Throwable)var9_15);
            return var9_15;
lbl51:
            // 2 sources

            try {
                var8_14.close();
            }
            catch (IOException v1) {}
            var7_13.unlock();
            return var9_15;
        }
lbl59:
        // 4 sources

        catch (IOException var1_2) {
            return new AVException(var1_2);
        }
        {
            block30: {
                block29: {
                    block28: {
                        catch (Throwable var2_6) {
                            break block28;
                        }
                        catch (Exception var2_7) {
                            // empty catch block
                        }
lbl-1000:
                        // 2 sources

                        {
                            var3_9 = FileDownloader.gLogger;
                            var3_9.w((Throwable)var2_3);
                            var3_9 = new AVException((Throwable)var2_3);
                        }
                        try {
                            var1_1.close();
                            break block29;
                        }
                        catch (IOException v2) {}
                    }
                    var1_1.close();
                    break block30;
                }
                if (var9_15 != null) {
                    try {
                        var9_15.close();
                    }
                    catch (IOException v3) {}
                }
                var7_13.unlock();
                return var3_9;
                catch (IOException v4) {}
            }
            if (var9_15 != null) {
                try {
                    var9_15.close();
                }
                catch (IOException v5) {}
            }
            ** try [egrp 12[TRYBLOCK] [35 : 268->321)] { 
lbl95:
            // 1 sources

            var7_13.unlock();
            throw var2_8;
        }
    }

    private z getHttpClient() {
        z$a z$a = new z$a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z$a = z$a.k(15, timeUnit);
        long l10 = 10;
        return z$a.j0(l10, timeUnit).R0(l10, timeUnit).f();
    }

    public AVException execute(String object, File serializable) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            serializable = new IllegalArgumentException("url is null");
            object = new AVException((Throwable)serializable);
            return object;
        }
        bl2 = serializable.exists();
        if (bl2) {
            serializable = new FileNotFoundException("local file is not existed.");
            object = new AVException((Throwable)serializable);
            return object;
        }
        return this.downloadFileFromNetwork((String)object, (File)serializable);
    }
}

