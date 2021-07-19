/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.geetest.sdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.geetest.sdk.utils.l$b$a;
import com.geetest.sdk.utils.l$b$b;
import com.geetest.sdk.utils.m;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class l$b {
    private static String d = "";
    private HandlerThread a;
    private Handler b;
    private SimpleDateFormat c;

    public l$b() {
        SimpleDateFormat simpleDateFormat;
        Locale locale = Locale.US;
        this.c = simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
    }

    public static /* synthetic */ String a(SimpleDateFormat simpleDateFormat, long l10, String string2, String string3) {
        return l$b.b(simpleDateFormat, l10, string2, string3);
    }

    public static /* synthetic */ SimpleDateFormat a(l$b l$b) {
        return l$b.c;
    }

    public static /* synthetic */ void a(l$b l$b, String string2) {
        l$b.a(string2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String object) {
        Object object2;
        block20: {
            block19: {
                block18: {
                    block17: {
                        void var1_4;
                        block16: {
                            object2 = l$b.e();
                            Object object3 = new File((String)object2);
                            boolean bl2 = ((File)object3).exists();
                            if (!bl2) {
                                ((File)object3).mkdirs();
                            }
                            bl2 = false;
                            object2 = null;
                            String string2 = "sensebot_log.txt";
                            File file = new File((File)object3, string2);
                            boolean bl3 = true;
                            FileOutputStream fileOutputStream = new FileOutputStream(file, bl3);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            object3 = "utf-8";
                            object = ((String)object).getBytes((String)object3);
                            bufferedOutputStream.write((byte[])object);
                            try {
                                bufferedOutputStream.close();
                                return;
                            }
                            catch (Exception exception) {
                                return;
                            }
                            catch (Throwable throwable) {
                                object2 = bufferedOutputStream;
                                break block16;
                            }
                            catch (Exception exception) {
                                object2 = bufferedOutputStream;
                                break block17;
                            }
                            catch (UnsupportedEncodingException unsupportedEncodingException) {
                                object2 = bufferedOutputStream;
                                break block18;
                            }
                            catch (FileNotFoundException fileNotFoundException) {
                                object2 = bufferedOutputStream;
                                break block19;
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                        if (object2 == null) throw var1_4;
                        try {
                            ((FilterOutputStream)object2).close();
                        }
                        catch (Exception exception) {
                            throw var1_4;
                        }
                        throw var1_4;
                        catch (Exception exception) {}
                    }
                    if (object2 == null) return;
                    break block20;
                    catch (UnsupportedEncodingException unsupportedEncodingException) {}
                }
                if (object2 == null) return;
                break block20;
                catch (FileNotFoundException fileNotFoundException) {}
            }
            if (object2 == null) return;
        }
        ((FilterOutputStream)object2).close();
    }

    private static String b(SimpleDateFormat object, long l10, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date(l10);
        object = ((DateFormat)object).format(date);
        stringBuilder.append((String)object);
        stringBuilder.append('\t');
        stringBuilder.append(string2);
        char c10 = '\n';
        stringBuilder.append(c10);
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }

    public static /* synthetic */ boolean c() {
        return l$b.d();
    }

    private static boolean d() {
        long l10;
        Object object = l$b.e();
        File file = new File((String)object);
        boolean bl2 = file.exists();
        if (!bl2) {
            return false;
        }
        String string2 = "sensebot_log.txt";
        object = new File(file, string2);
        Object object2 = ((File)object).exists();
        if (object2 == 0) {
            return false;
        }
        long l11 = ((File)object).length();
        long l12 = l11 - (l10 = 0xA00000L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            return false;
        }
        return ((File)object).delete();
    }

    private static String e() {
        CharSequence charSequence = d;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            String string2 = m.a();
            ((StringBuilder)charSequence).append(string2);
            string2 = File.separator;
            ((StringBuilder)charSequence).append(string2);
            string2 = "Geetest";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            d = charSequence;
        }
        return d;
    }

    public void a() {
        synchronized (this) {
            Handler handler = this.b;
            handler = handler.obtainMessage();
            int n10 = 1;
            handler.what = n10;
            Handler handler2 = this.b;
            handler2.sendMessage((Message)handler);
            return;
        }
    }

    public void a(String string2, String string3) {
        synchronized (this) {
            Handler handler = this.b;
            handler = handler.obtainMessage();
            l$b$b l$b$b = null;
            handler.what = 0;
            l$b$b = new l$b$b(null);
            long l10 = System.currentTimeMillis();
            l$b$b.a = l10;
            l$b$b.b = string2;
            l$b$b.c = string3;
            handler.obj = l$b$b;
            string2 = this.b;
            string2.sendMessage((Message)handler);
            return;
        }
    }

    public void b() {
        synchronized (this) {
            String string2 = "Geetest Thread";
            Object object = new HandlerThread(string2);
            this.a = object;
            object.start();
            string2 = this.a;
            string2 = string2.getLooper();
            object = new l$b$a(this, (Looper)string2);
            this.b = object;
            return;
        }
    }
}

