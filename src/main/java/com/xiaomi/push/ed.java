/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ac;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.dq;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.ho;
import com.xiaomi.push.hu;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class ed
extends ai$a {
    public int a;
    public Context a;

    public ed(Context context, int n10) {
        this.a = n10;
        this.a = context;
    }

    public static void a(Context context, hu hu2) {
        Object object = dq.a().a();
        object = object == null ? "" : object.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        String string2 = hu2.a();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        ed.a(context, hu2, (String)object);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(Context object, hu object2, String object3) {
        object2 = iw.a((ix)object2);
        if ((object2 = (Object)du.b((String)object3, (byte[])object2)) == null) return;
        int n10 = ((Object)object2).length;
        if (n10 == 0) {
            return;
        }
        object3 = dv.a;
        synchronized (object3) {
            void var1_6;
            Object object4;
            block32: {
                block33: {
                    block30: {
                        block25: {
                            Throwable throwable2;
                            block31: {
                                boolean bl2;
                                Object object5;
                                block28: {
                                    void var1_8;
                                    block29: {
                                        Object object6;
                                        block27: {
                                            block26: {
                                                int n11 = 0;
                                                object5 = null;
                                                object4 = object.getExternalFilesDir(null);
                                                Object object7 = "push_cdata.lock";
                                                object6 = new File((File)object4, (String)object7);
                                                y.a((File)object6);
                                                object7 = "rw";
                                                object4 = new RandomAccessFile((File)object6, (String)object7);
                                                object6 = ((RandomAccessFile)object4).getChannel();
                                                object6 = ((FileChannel)object6).lock();
                                                object = object.getExternalFilesDir(null);
                                                Object object8 = "push_cdata.data";
                                                object7 = new File((File)object, (String)object8);
                                                boolean bl3 = true;
                                                object8 = new FileOutputStream((File)object7, bl3);
                                                object = new BufferedOutputStream((OutputStream)object8);
                                                n11 = ((Object)object2).length;
                                                object5 = ac.a(n11);
                                                ((FilterOutputStream)object).write((byte[])object5);
                                                ((FilterOutputStream)object).write((byte[])object2);
                                                ((BufferedOutputStream)object).flush();
                                                if (object6 == null) break block25;
                                                try {
                                                    boolean bl4 = ((FileLock)object6).isValid();
                                                    if (!bl4) break block25;
                                                    ((FileLock)object6).release();
                                                    break block25;
                                                }
                                                catch (Throwable throwable2) {
                                                    break block31;
                                                }
                                                catch (Throwable throwable3) {
                                                    break block26;
                                                }
                                                catch (IOException iOException) {
                                                    break block27;
                                                }
                                                catch (Throwable throwable4) {
                                                    object = null;
                                                }
                                            }
                                            object5 = object6;
                                            break block28;
                                            catch (IOException iOException) {
                                                object = null;
                                            }
                                        }
                                        object5 = object6;
                                        break block29;
                                        catch (Throwable throwable5) {
                                            object = null;
                                            break block28;
                                        }
                                        catch (IOException iOException) {
                                            object = null;
                                            break block29;
                                        }
                                        catch (Throwable throwable6) {
                                            object = null;
                                            object4 = null;
                                            break block28;
                                        }
                                        catch (IOException iOException) {
                                            object = null;
                                            object4 = null;
                                        }
                                    }
                                    var1_8.printStackTrace();
                                    if (object5 == null) break block30;
                                    boolean bl5 = ((FileLock)object5).isValid();
                                    if (!bl5) break block30;
                                    ((FileLock)object5).release();
                                    break block30;
                                    catch (Throwable throwable7) {
                                        // empty catch block
                                    }
                                }
                                if (object5 == null || !(bl2 = ((FileLock)object5).isValid())) break block32;
                                try {
                                    ((FileLock)object5).release();
                                    break block32;
                                }
                                catch (IOException iOException) {}
                            }
                            throw throwable2;
                            catch (IOException iOException) {}
                        }
                        y.a((Closeable)object);
                        break block33;
                        catch (IOException iOException) {}
                    }
                    y.a((Closeable)object);
                }
                y.a((Closeable)object4);
                return;
            }
            y.a((Closeable)object);
            y.a((Closeable)object4);
            throw var1_6;
        }
    }

    public abstract ho a();

    public abstract String a();

    public boolean a() {
        Context context = this.a;
        String string2 = String.valueOf(this.a());
        long l10 = this.a;
        return du.a(context, string2, l10);
    }

    public boolean b() {
        return true;
    }

    public void run() {
        boolean bl2 = this.a();
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DC run job mutual: ");
            int n10 = this.a();
            stringBuilder.append(n10);
            b.a(stringBuilder.toString());
            return;
        }
        Object object = dq.a().a();
        object = object == null ? "" : object.a();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            return;
        }
        bl3 = this.b();
        if (!bl3) {
            return;
        }
        Object object2 = this.a();
        boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (bl4) {
            return;
        }
        hu hu2 = new hu();
        hu2.a((String)object2);
        long l10 = System.currentTimeMillis();
        hu2.a(l10);
        object2 = this.a();
        hu2.a((ho)((Object)object2));
        ed.a(this.a, hu2, (String)object);
    }
}

