/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Pair
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.al;
import com.xiaomi.push.al$b;
import com.xiaomi.push.dn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dm
implements LoggerInterface {
    private static al a;
    public static String a;
    private static final SimpleDateFormat a;
    private static List a;
    private Context a;
    private String b;
    private String c = "";

    static {
        ArrayList arrayList = new ArrayList("yyyy-MM-dd HH:mm:ss aaa");
        a = arrayList;
        arrayList = new ArrayList(true);
        a = arrayList;
        a = "/MiPushLog";
        arrayList = new ArrayList();
        a = Collections.synchronizedList(arrayList);
    }

    public dm(Context object) {
        this.a = object;
        Context context = object.getApplicationContext();
        if (context != null) {
            this.a = object = object.getApplicationContext();
        }
        object = this.a.getPackageName();
        this.b = object;
    }

    public static /* synthetic */ String a(dm dm2) {
        return dm2.b;
    }

    public static /* synthetic */ List a() {
        return a;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        void var1_14;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl2;
        String string2;
        block41: {
            boolean bl3;
            block43: {
                Object object5;
                block42: {
                    long l10;
                    Object object6;
                    boolean bl4;
                    block40: {
                        boolean bl5;
                        object5 = "log1.txt";
                        string2 = "";
                        bl2 = false;
                        object4 = null;
                        object3 = this.c;
                        boolean bl6 = TextUtils.isEmpty((CharSequence)object3);
                        if (bl6) {
                            object3 = this.a;
                            if ((object3 = object3.getExternalFilesDir(null)) != null) {
                                object2 = new StringBuilder();
                                object3 = ((File)object3).getAbsolutePath();
                                ((StringBuilder)object2).append((String)object3);
                                ((StringBuilder)object2).append(string2);
                                this.c = object3 = ((StringBuilder)object2).toString();
                            }
                        }
                        object2 = new StringBuilder();
                        object = this.c;
                        ((StringBuilder)object2).append((String)object);
                        object = a;
                        ((StringBuilder)object2).append((String)object);
                        object2 = ((StringBuilder)object2).toString();
                        object3 = new File((String)object2);
                        bl4 = ((File)object3).exists();
                        if (!(bl4 && (bl4 = ((File)object3).isDirectory()) || (bl4 = ((File)object3).mkdirs()))) {
                            object5 = this.b;
                            object3 = "Create mipushlog directory fail.";
                            Log.w((String)object5, (String)object3);
                            return;
                        }
                        object = "log.lock";
                        object2 = new File((File)object3, (String)object);
                        boolean bl7 = ((File)object2).exists();
                        if (!bl7 || (bl7 = ((File)object2).isDirectory())) {
                            ((File)object2).createNewFile();
                        }
                        object6 = "rw";
                        object = new RandomAccessFile((File)object2, (String)object6);
                        object2 = ((RandomAccessFile)object).getChannel();
                        object2 = ((FileChannel)object2).lock();
                        Object object7 = new File((File)object3, (String)object5);
                        boolean bl8 = true;
                        Object object8 = new FileOutputStream((File)object7, bl8);
                        Object object9 = new OutputStreamWriter((OutputStream)object8);
                        object6 = new BufferedWriter((Writer)object9);
                        while (!(bl5 = (object9 = a).isEmpty())) {
                            object9 = a;
                            object8 = null;
                            object9 = object9.remove(0);
                            object9 = (Pair)object9;
                            object8 = ((Pair)object9).first;
                            object8 = (String)object8;
                            object7 = ((Pair)object9).second;
                            String string3 = "\n";
                            if (object7 != null) {
                                object7 = new StringBuilder();
                                ((StringBuilder)object7).append((String)object8);
                                ((StringBuilder)object7).append(string3);
                                object8 = ((StringBuilder)object7).toString();
                                object7 = new StringBuilder();
                                ((StringBuilder)object7).append((String)object8);
                                object9 = ((Pair)object9).second;
                                object9 = (Throwable)object9;
                                object9 = Log.getStackTraceString((Throwable)object9);
                                ((StringBuilder)object7).append((String)object9);
                                object8 = ((StringBuilder)object7).toString();
                            }
                            object9 = new StringBuilder();
                            ((StringBuilder)object9).append((String)object8);
                            ((StringBuilder)object9).append(string3);
                            object9 = ((StringBuilder)object9).toString();
                            ((Writer)object6).write((String)object9);
                        }
                        ((BufferedWriter)object6).flush();
                        ((BufferedWriter)object6).close();
                        object6 = new File((File)object3, (String)object5);
                        long l11 = ((File)object6).length();
                        long l12 = 0x100000L;
                        l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (l10 < 0) break block40;
                        object9 = "log0.txt";
                        object5 = new File((File)object3, (String)object9);
                        bl6 = ((File)object5).exists();
                        if (bl6 && (bl6 = ((File)object5).isFile())) {
                            ((File)object5).delete();
                        }
                        ((File)object6).renameTo((File)object5);
                    }
                    if (object2 != null && (l10 = (long)((FileLock)object2).isValid()) != false) {
                        try {
                            ((FileLock)object2).release();
                        }
                        catch (IOException iOException) {
                            object4 = this.b;
                            Log.e((String)object4, (String)string2, (Throwable)iOException);
                        }
                    }
                    ((RandomAccessFile)object).close();
                    return;
                    catch (Throwable throwable) {
                        object4 = object6;
                        break block41;
                    }
                    catch (Exception exception) {
                        object4 = object6;
                        break block42;
                    }
                    catch (Exception exception) {
                        break block42;
                    }
                    catch (Throwable throwable) {
                        bl4 = false;
                        object2 = null;
                        break block41;
                    }
                    catch (Exception exception) {
                        bl4 = false;
                        object2 = null;
                        break block42;
                    }
                    catch (Throwable throwable) {
                        boolean bl9 = false;
                        object2 = null;
                        boolean bl10 = false;
                        object = null;
                        break block41;
                    }
                    catch (Exception exception) {
                        boolean bl11 = false;
                        object2 = null;
                        boolean bl12 = false;
                        object = null;
                    }
                }
                object3 = this.b;
                Log.e((String)object3, (String)string2, (Throwable)object5);
                if (object4 == null) break block43;
                try {
                    ((BufferedWriter)object4).close();
                }
                catch (IOException iOException) {
                    object4 = this.b;
                    Log.e((String)object4, (String)string2, (Throwable)iOException);
                }
            }
            if (object2 != null && (bl3 = ((FileLock)object2).isValid())) {
                try {
                    ((FileLock)object2).release();
                }
                catch (IOException iOException) {
                    object4 = this.b;
                    Log.e((String)object4, (String)string2, (Throwable)iOException);
                }
            }
            if (object == null) return;
            try {
                ((RandomAccessFile)object).close();
                return;
            }
            catch (IOException iOException) {
                object4 = this.b;
                Log.e((String)object4, (String)string2, (Throwable)iOException);
            }
            return;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object4 != null) {
            try {
                ((BufferedWriter)object4).close();
            }
            catch (IOException iOException) {
                object3 = this.b;
                Log.e((String)object3, (String)string2, (Throwable)iOException);
            }
        }
        if (object2 != null && (bl2 = ((FileLock)object2).isValid())) {
            try {
                ((FileLock)object2).release();
            }
            catch (IOException iOException) {
                object3 = this.b;
                Log.e((String)object3, (String)string2, (Throwable)iOException);
            }
        }
        if (object == null) throw var1_14;
        try {
            ((RandomAccessFile)object).close();
            throw var1_14;
        }
        catch (IOException iOException) {
            object3 = this.b;
            Log.e((String)object3, (String)string2, (Throwable)iOException);
        }
        throw var1_14;
    }

    public static /* synthetic */ void a(dm dm2) {
        dm2.a();
    }

    public final void log(String string2) {
        this.log(string2, null);
    }

    public final void log(String object, Throwable object2) {
        List list = a;
        Object[] objectArray = new Object[3];
        Object object3 = a;
        Date date = new Date();
        objectArray[0] = object3 = ((DateFormat)object3).format(date);
        objectArray[1] = object3 = this.b;
        objectArray[2] = object;
        object = String.format("%1$s %2$s %3$s ", objectArray);
        Pair pair = new Pair(object, object2);
        list.add(pair);
        object = a;
        object2 = new dn(this);
        ((al)object).a((al$b)object2);
    }

    public final void setTag(String string2) {
        this.b = string2;
    }
}

