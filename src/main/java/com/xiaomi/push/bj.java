/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.bc;
import com.xiaomi.push.bf;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bj {
    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Build.VERSION.RELEASE;
        stringBuilder.append(string2);
        stringBuilder.append("-");
        string2 = Build.VERSION.INCREMENTAL;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String a(Context object) {
        Object object2 = bm.a((Context)object);
        String string2 = "sp_client_report_status";
        String string3 = "sp_client_report_key";
        String string4 = "";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((bm)object2).a(string2, string3, string4)));
        if (bl2) {
            int n10 = 20;
            object2 = bf.a(n10);
            object = bm.a((Context)object);
            ((bm)object).a(string2, string3, (String)object2);
        }
        return object2;
    }

    public static void a(Context context, String string2) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        String string3 = context.getPackageName();
        intent.putExtra("pkgname", string3);
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", string2);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context object, String object2, String object3) {
        if ((object3 = object.getExternalFilesDir((String)object3)) == null) return;
        boolean bl2 = ((File)object3).exists();
        if (!bl2) {
            ((File)object3).mkdirs();
        }
        if ((object = object.getExternalFilesDir((String)object2)) == null) return;
        int n10 = ((File)object).exists();
        if (n10 == 0) {
            ((File)object).mkdirs();
            return;
        }
        object2 = new bk();
        if ((object = ((File)object).listFiles((FilenameFilter)object2)) == null) return;
        n10 = ((Object)object).length;
        if (n10 <= 0) {
            return;
        }
        long l10 = System.currentTimeMillis();
        n10 = ((Object)object).length;
        int n11 = 0;
        FileLock fileLock = null;
        boolean bl3 = false;
        Object object4 = null;
        Object object5 = null;
        while (n11 < n10) {
            block38: {
                boolean bl4;
                block30: {
                    void var0_4;
                    block34: {
                        Object object6;
                        block33: {
                            block37: {
                                block36: {
                                    block35: {
                                        block32: {
                                            block31: {
                                                Object object7 = object[n11];
                                                if (object7 == null) break block30;
                                                object6 = ((File)object7).getAbsolutePath();
                                                boolean bl5 = TextUtils.isEmpty((CharSequence)object6);
                                                if (bl5) break block30;
                                                Object object8 = new StringBuilder();
                                                String string2 = ((File)object7).getAbsolutePath();
                                                ((StringBuilder)object8).append(string2);
                                                string2 = ".lock";
                                                ((StringBuilder)object8).append(string2);
                                                object8 = ((StringBuilder)object8).toString();
                                                object6 = new File((String)object8);
                                                y.a((File)object6);
                                                object8 = "rw";
                                                object5 = new RandomAccessFile((File)object6, (String)object8);
                                                object4 = ((RandomAccessFile)object5).getChannel();
                                                fileLock = ((FileChannel)object4).lock();
                                                object4 = ((File)object3).getAbsolutePath();
                                                object8 = new StringBuilder();
                                                ((StringBuilder)object8).append((String)object4);
                                                object4 = File.separator;
                                                ((StringBuilder)object8).append((String)object4);
                                                object4 = ((File)object7).getName();
                                                ((StringBuilder)object8).append((String)object4);
                                                ((StringBuilder)object8).append(l10);
                                                object4 = ((StringBuilder)object8).toString();
                                                object8 = new File((String)object4);
                                                try {
                                                    y.b((File)object7, (File)object8);
                                                }
                                                catch (IOException iOException) {
                                                    iOException.printStackTrace();
                                                    ((File)object7).delete();
                                                    ((File)object8).delete();
                                                }
                                                ((File)object7).delete();
                                                if (fileLock == null || !(bl3 = fileLock.isValid())) break block31;
                                                try {
                                                    fileLock.release();
                                                }
                                                catch (IOException iOException) {
                                                    b.a(iOException);
                                                }
                                            }
                                            y.a((Closeable)object5);
                                            break block36;
                                            catch (Exception exception) {
                                                break block32;
                                            }
                                            catch (Throwable throwable) {
                                                break block33;
                                            }
                                            catch (Exception exception) {
                                                object5 = object4;
                                                object4 = exception;
                                                break block32;
                                            }
                                            catch (Throwable throwable) {
                                                break block34;
                                            }
                                            catch (Exception exception) {
                                                object6 = object5;
                                                object5 = object4;
                                                object4 = exception;
                                            }
                                        }
                                        b.a((Throwable)object4);
                                        if (fileLock == null || !(bl3 = fileLock.isValid())) break block35;
                                        try {
                                            fileLock.release();
                                        }
                                        catch (IOException iOException) {
                                            b.a(iOException);
                                        }
                                    }
                                    y.a((Closeable)object5);
                                    if (object6 == null) break block37;
                                }
                                ((File)object6).delete();
                            }
                            object4 = object5;
                            object5 = object6;
                            break block38;
                            catch (Throwable throwable) {
                                object4 = object5;
                            }
                        }
                        object5 = object6;
                    }
                    if (fileLock != null && (n10 = (int)(fileLock.isValid() ? 1 : 0)) != 0) {
                        try {
                            fileLock.release();
                        }
                        catch (IOException iOException) {
                            b.a(iOException);
                        }
                    }
                    y.a(object4);
                    if (object5 == null) throw var0_4;
                    ((File)object5).delete();
                    throw var0_4;
                }
                if (fileLock != null && (bl4 = fileLock.isValid())) {
                    try {
                        fileLock.release();
                    }
                    catch (IOException iOException) {
                        b.a(iOException);
                    }
                }
                y.a(object4);
                if (object5 != null) {
                    ((File)object5).delete();
                }
            }
            ++n11;
        }
    }

    public static void a(Context context, List object) {
        int n10;
        if (object != null && (n10 = object.size()) > 0 && (n10 = (int)(bj.a(context) ? 1 : 0)) != 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                String string2 = (String)object.next();
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) continue;
                bj.a(context, string2);
            }
        }
    }

    public static boolean a(Context context) {
        context = context.getApplicationContext().getPackageManager();
        boolean bl2 = false;
        String string2 = "com.xiaomi.xmsf";
        try {
            context = context.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return false;
        }
        int n10 = context.versionCode;
        int n11 = 108;
        if (n10 >= n11) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean a(Context object, String string2) {
        File file = new File(string2);
        object = a.a((Context)object).a();
        long l10 = ((Config)object).getMaxFileLength();
        boolean bl2 = file.exists();
        boolean bl3 = false;
        boolean bl4 = true;
        if (bl2) {
            try {
                long l11 = file.length();
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 > 0) {
                }
                break block5;
            }
            catch (Exception exception) {
                b.a(exception);
            }
        } else {
            block5: {
                y.a(file);
            }
            bl3 = bl4;
        }
        return bl3;
    }

    public static byte[] a(String object) {
        object = Arrays.copyOf(bc.a((String)object), 16);
        object[0] = 68;
        object[15] = 84;
        return object;
    }

    public static File[] a(Context object, String object2) {
        if ((object = object.getExternalFilesDir((String)object2)) != null) {
            object2 = new bl();
            return ((File)object).listFiles((FilenameFilter)object2);
        }
        return null;
    }
}

