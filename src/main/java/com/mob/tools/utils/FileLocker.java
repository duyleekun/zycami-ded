/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.mob.tools.utils;

import android.os.SystemClock;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class FileLocker {
    private FileOutputStream fos;
    private FileLock lock;

    private boolean getLock(boolean bl2) {
        FileLock fileLock;
        this.lock = bl2 ? (fileLock = this.fos.getChannel().lock()) : (fileLock = this.fos.getChannel().tryLock());
        fileLock = this.lock;
        if (fileLock != null) {
            bl2 = true;
        } else {
            bl2 = false;
            fileLock = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void lock(Runnable runnable, boolean bl2) {
        synchronized (this) {
            boolean bl3;
            bl3 = this.lock(bl3);
            if (bl3 && runnable != null) {
                runnable.run();
            }
            return;
        }
    }

    public boolean lock(boolean bl2) {
        synchronized (this) {
            long l10 = bl2 ? 1000L : 500L;
            long l11 = 16;
            bl2 = this.lock(bl2, l10, l11);
            return bl2;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean lock(boolean bl2, long l10, long l11) {
        synchronized (this) {
            FileOutputStream fileOutputStream = this.fos;
            if (fileOutputStream == null) {
                return false;
            }
            try {
                return this.getLock(bl2);
            }
            catch (Throwable throwable) {
                int n10;
                NLog nLog;
                Object object;
                long l12 = 0L;
                long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (l13 <= 0 || (l13 = (long)(throwable instanceof OverlappingFileLockException)) == false) {
                    object = MobLog.getInstance();
                    ((NLog)object).w(throwable);
                } else {
                    long l14 = SystemClock.elapsedRealtime() + l10;
                    while (true) {
                        Object object2;
                        if ((object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) > 0) {
                            Thread.sleep(l11);
                        } else {
                            bl2 = false;
                            object = null;
                            break;
                            catch (Throwable throwable2) {}
                        }
                        try {
                            l10 = SystemClock.elapsedRealtime();
                            l10 = l14 - l10;
                            bl2 = this.getLock(bl2);
                        }
                        catch (Throwable throwable3) {
                            object2 = throwable3 instanceof OverlappingFileLockException;
                            if (object2 != false) {
                                object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                                if (object2 > 0) continue;
                                NLog nLog2 = MobLog.getInstance();
                                String string2 = "OverlappingFileLockException and timeout";
                                nLog2.w(string2);
                                continue;
                            }
                            nLog = MobLog.getInstance();
                            nLog.w(throwable);
                            l10 = -1;
                            continue;
                        }
                        break;
                    }
                    n10 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                    if (n10 > 0) {
                        return bl2;
                    }
                }
                object = this.lock;
                n10 = 0;
                nLog = null;
                if (object != null) {
                    try {
                        ((FileLock)object).release();
                    }
                    catch (Throwable throwable4) {}
                    this.lock = null;
                }
                if ((object = this.fos) == null) return false;
                try {
                    ((FileOutputStream)object).close();
                }
                catch (Throwable throwable5) {}
                this.fos = null;
                return false;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        synchronized (this) {
            FileOutputStream fileOutputStream = this.fos;
            if (fileOutputStream == null) {
                return;
            }
            this.unlock();
            try {
                fileOutputStream = this.fos;
                fileOutputStream.close();
            }
            catch (Throwable throwable) {}
            fileOutputStream = null;
            this.fos = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setLockFile(String object) {
        synchronized (this) {
            block7: {
                try {
                    FileOutputStream fileOutputStream;
                    this.fos = fileOutputStream = new FileOutputStream((String)object);
                }
                catch (Throwable throwable) {
                    object = this.fos;
                    if (object == null) break block7;
                    try {
                        ((FileOutputStream)object).close();
                    }
                    catch (Throwable throwable2) {}
                    object = null;
                    this.fos = null;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unlock() {
        synchronized (this) {
            FileLock fileLock = this.lock;
            if (fileLock == null) {
                return;
            }
            try {
                fileLock.release();
            }
            catch (Throwable throwable) {}
            fileLock = null;
            this.lock = null;
            return;
        }
    }
}

