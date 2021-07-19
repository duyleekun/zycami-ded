/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.baidu.location.indoor.mapversion;

import android.os.Build;
import com.baidu.location.indoor.mapversion.IndoorJni;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static Lock a;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        a = reentrantLock;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a() {
        var0 = com.baidu.location.indoor.mapversion.a.a;
        var0.lock();
        IndoorJni.stopPdr();
        var0 = com.baidu.location.indoor.mapversion.a.a;
        var0.unlock();
        return;
        {
            catch (Exception var0_2) {}
            {
                var0_2.printStackTrace();
            }
        }
        ** finally { 
lbl11:
        // 1 sources

        com.baidu.location.indoor.mapversion.a.a.unlock();
        throw var0_1;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(int var0, float[] var1_1, long var2_2) {
        var4_3 = a.class;
        synchronized (var4_3) {
            block11: {
                var5_4 = com.baidu.location.indoor.mapversion.a.a;
                var5_4.lock();
                var6_5 = com.baidu.location.indoor.mapversion.a.b();
                if (var6_5 != 0 && var1_1 != null && (var6_5 = ((Object)var1_1).length) >= (var7_6 = 3)) {
                    var6_5 = 0;
                    var5_4 = null;
                    var8_7 = var1_1[0];
                    var6_5 = 1;
                    var9_8 = var1_1[var6_5];
                    var6_5 = 2;
                    var10_9 = var1_1[var6_5];
                    var7_6 = var0;
                    IndoorJni.phs(var0, (float)var8_7, (float)var9_8, (float)var10_9, var2_2);
                }
                var11_10 = com.baidu.location.indoor.mapversion.a.a;
lbl18:
                // 2 sources

                while (true) {
                    var11_10.unlock();
                    break;
                }
                {
                    catch (Throwable var11_11) {
                        break block11;
                    }
                    catch (Exception var11_12) {}
                    {
                        var11_12.printStackTrace();
                        var11_10 = com.baidu.location.indoor.mapversion.a.a;
                        ** continue;
                    }
                }
                return;
            }
            var1_1 = com.baidu.location.indoor.mapversion.a.a;
            var1_1.unlock();
            throw var11_11;
        }
    }

    public static boolean b() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            return false;
        }
        return IndoorJni.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static float[] c() {
        Throwable throwable2222222;
        Object object = a;
        object.lock();
        object = IndoorJni.pgo();
        Lock lock = a;
        lock.unlock();
        return object;
        {
            catch (Throwable throwable2222222) {
            }
            catch (Exception exception) {}
            {
                exception.printStackTrace();
                a.unlock();
                return null;
            }
        }
        a.unlock();
        throw throwable2222222;
    }
}

