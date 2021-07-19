/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileUtil$a
implements Runnable {
    public final /* synthetic */ File a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public FileUtil$a(File file, long l10, String string2) {
        this.a = file;
        this.b = l10;
        this.c = string2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public void run() {
        boolean bl2;
        boolean bl3;
        Object object = this.a;
        String string2 = "FileUtil";
        if (object == null) {
            HMSLog.e(string2, "In writeFile Failed to get local file.");
            return;
        }
        if ((object = ((File)object).getParentFile()) != null && ((bl3 = ((File)object).mkdirs()) || (bl2 = ((File)object).isDirectory()))) {
            void var2_5;
            block33: {
                block31: {
                    Object object2;
                    block32: {
                        RandomAccessFile randomAccessFile;
                        Object object3;
                        block30: {
                            String string3;
                            long l10;
                            block28: {
                                block29: {
                                    bl2 = false;
                                    object = null;
                                    object3 = this.a;
                                    l10 = ((File)object3).length();
                                    long l11 = this.b;
                                    long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                                    string3 = "rw";
                                    if (l12 <= 0) break block28;
                                    object3 = this.a;
                                    object3 = ((File)object3).getCanonicalPath();
                                    object2 = this.a;
                                    boolean bl4 = ((File)object2).delete();
                                    if (bl4) break block29;
                                    object2 = "last file delete failed.";
                                    HMSLog.e(string2, (String)object2);
                                }
                                File file = new File((String)object3);
                                object = object2 = new RandomAccessFile(file, string3);
                                break block30;
                            }
                            File file = this.a;
                            randomAccessFile = new RandomAccessFile(file, string3);
                            randomAccessFile.seek(l10);
                            object = randomAccessFile;
                        }
                        object3 = new StringBuilder();
                        object2 = this.c;
                        ((StringBuilder)object3).append((String)object2);
                        object2 = "line.separator";
                        object2 = System.getProperty((String)object2);
                        ((StringBuilder)object3).append((String)object2);
                        object3 = ((StringBuilder)object3).toString();
                        try {
                            ((RandomAccessFile)object).writeBytes((String)object3);
                            break block31;
                        }
                        catch (IOException iOException) {
                            break block32;
                        }
                        catch (Throwable throwable) {
                            object = randomAccessFile;
                            break block33;
                        }
                        catch (IOException iOException) {
                            object = randomAccessFile;
                        }
                    }
                    object2 = "writeFile exception:";
                    try {
                        void var5_11;
                        HMSLog.e(string2, (String)object2, (Throwable)var5_11);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                IOUtils.closeQuietly((Closeable)object);
                return;
            }
            IOUtils.closeQuietly((Closeable)object);
            throw var2_5;
        }
        HMSLog.e(string2, "In writeFile, Failed to create directory.");
    }
}

