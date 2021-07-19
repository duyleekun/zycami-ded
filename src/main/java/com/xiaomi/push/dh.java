/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.service.be;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dh {
    private static String a = "/MiPushLog";
    private int a;
    private final SimpleDateFormat a;
    private ArrayList a;
    private boolean a;
    private int b;
    private String b;
    private String c;

    public dh() {
        Cloneable cloneable;
        this.a = cloneable = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.b = 0x200000;
        this.a = cloneable;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        boolean bl2;
        int n10;
        int n11 = 4096;
        char[] cArray = new char[n11];
        int n12 = bufferedReader.read(cArray);
        boolean bl3 = false;
        while (n12 != (n10 = -1) && bl3 != (bl2 = true)) {
            int n13;
            String string2 = new String(cArray, 0, n12);
            Matcher matcher = pattern.matcher(string2);
            int n14 = 0;
            for (int i10 = 0; i10 < n12 && (i10 = (int)(matcher.find(i10) ? 1 : 0)) != 0; i10 += n13) {
                String string3;
                i10 = matcher.start();
                n13 = this.b.length() + i10;
                String string4 = string2.substring(i10, n13);
                boolean bl4 = this.a;
                if (!bl4) {
                    string3 = this.b;
                    n13 = string4.compareTo(string3);
                    if (n13 >= 0) {
                        this.a = bl2;
                        n14 = i10;
                    }
                } else {
                    string3 = this.c;
                    n13 = string4.compareTo(string3);
                    if (n13 > 0) {
                        bl3 = bl2;
                        n12 = i10;
                        break;
                    }
                }
                if ((n13 = string2.indexOf(10, i10)) != n10) continue;
                string4 = this.b;
                n13 = string4.length();
            }
            if ((n10 = (int)(this.a ? 1 : 0)) != 0) {
                this.a = n10 = this.a + (n12 -= n14);
                bufferedWriter.write(cArray, n14, n12);
                if (bl3 || (n12 = this.a) > (n10 = this.b)) break;
            }
            n12 = bufferedReader.read(cArray);
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private void a(File object) {
        void var1_6;
        Closeable closeable;
        Closeable closeable2;
        block61: {
            block63: {
                String string2;
                block62: {
                    Serializable serializable;
                    String string3;
                    block65: {
                        block64: {
                            BufferedWriter bufferedWriter;
                            block60: {
                                block59: {
                                    block58: {
                                        string3 = "LOG: filter error = ";
                                        serializable = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
                                        closeable2 = null;
                                        closeable = new FileOutputStream((File)object);
                                        Object object2 = new OutputStreamWriter((OutputStream)closeable);
                                        bufferedWriter = new BufferedWriter((Writer)object2);
                                        object = new StringBuilder();
                                        object2 = "model :";
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = Build.MODEL;
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = "; os :";
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = Build.VERSION.INCREMENTAL;
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = "; uid :";
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = be.a();
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = "; lng :";
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = Locale.getDefault();
                                        object2 = ((Locale)object2).toString();
                                        ((StringBuilder)object).append((String)object2);
                                        object2 = "; sdk :";
                                        ((StringBuilder)object).append((String)object2);
                                        int n10 = 39;
                                        ((StringBuilder)object).append(n10);
                                        object2 = "; andver :";
                                        ((StringBuilder)object).append((String)object2);
                                        n10 = Build.VERSION.SDK_INT;
                                        ((StringBuilder)object).append(n10);
                                        object2 = "\n";
                                        ((StringBuilder)object).append((String)object2);
                                        object = ((StringBuilder)object).toString();
                                        bufferedWriter.write((String)object);
                                        object = null;
                                        this.a = 0;
                                        object = this.a;
                                        object = ((ArrayList)object).iterator();
                                        while (true) {
                                            n10 = (int)(object.hasNext() ? 1 : 0);
                                            if (n10 == 0) break;
                                            object2 = object.next();
                                            object2 = (File)object2;
                                            FileInputStream fileInputStream = new FileInputStream((File)object2);
                                            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                                            closeable = new BufferedReader(inputStreamReader);
                                            try {
                                                this.a((BufferedReader)closeable, bufferedWriter, (Pattern)serializable);
                                                ((BufferedReader)closeable).close();
                                                closeable2 = closeable;
                                            }
                                            catch (Throwable throwable) {
                                                break block58;
                                            }
                                            catch (IOException iOException) {
                                                break block59;
                                            }
                                            catch (FileNotFoundException fileNotFoundException) {
                                                break block60;
                                            }
                                        }
                                        object = cz.a();
                                        object = ((cz)object).c();
                                        try {
                                            bufferedWriter.write((String)object);
                                        }
                                        catch (Throwable throwable) {
                                            closeable = closeable2;
                                        }
                                        y.a(bufferedWriter);
                                        y.a(closeable2);
                                        break block63;
                                    }
                                    closeable2 = bufferedWriter;
                                    break block61;
                                    catch (IOException iOException) {
                                        closeable = closeable2;
                                    }
                                }
                                closeable2 = bufferedWriter;
                                break block64;
                                catch (FileNotFoundException fileNotFoundException) {
                                    closeable = closeable2;
                                }
                            }
                            closeable2 = bufferedWriter;
                            break block65;
                            catch (Throwable throwable) {
                                closeable = null;
                                break block61;
                            }
                            catch (IOException iOException) {
                                closeable = null;
                            }
                        }
                        serializable = new StringBuilder();
                        ((StringBuilder)serializable).append(string3);
                        string2 = ((Throwable)((Object)string2)).getMessage();
                        ((StringBuilder)serializable).append(string2);
                        string2 = ((StringBuilder)serializable).toString();
                        break block62;
                        catch (FileNotFoundException fileNotFoundException) {
                            closeable = null;
                        }
                    }
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append(string3);
                    string2 = ((Throwable)((Object)string2)).getMessage();
                    ((StringBuilder)serializable).append(string2);
                    string2 = ((StringBuilder)serializable).toString();
                }
                try {
                    com.xiaomi.channel.commonutils.logger.b.c(string2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                y.a(closeable2);
                y.a(closeable);
            }
            return;
        }
        y.a(closeable2);
        y.a(closeable);
        throw var1_6;
    }

    public dh a(File file) {
        boolean bl2 = file.exists();
        if (bl2) {
            ArrayList arrayList = this.a;
            arrayList.add(file);
        }
        return this;
    }

    public dh a(Date object, Date object2) {
        boolean bl2 = ((Date)object).after((Date)object2);
        if (bl2) {
            SimpleDateFormat simpleDateFormat = this.a;
            this.b = object2 = simpleDateFormat.format((Date)object2);
            object2 = this.a;
            object = ((DateFormat)object2).format((Date)object);
        } else {
            SimpleDateFormat simpleDateFormat = this.a;
            this.b = object = simpleDateFormat.format((Date)object);
            object = this.a.format((Date)object2);
        }
        this.c = object;
        return this;
    }

    public File a(Context object, Date object2, Date date, File comparable) {
        CharSequence charSequence;
        Object object3 = object.getPackageName();
        boolean bl2 = "com.xiaomi.xmsf".equalsIgnoreCase((String)object3);
        if (bl2) {
            object = object.getFilesDir();
            object3 = new File((File)object, "xmsf.log.1");
            this.a((File)object3);
            charSequence = "xmsf.log";
            object3 = new File((File)object, (String)charSequence);
            this.a((File)object3);
        } else {
            charSequence = new StringBuilder();
            object = object.getExternalFilesDir(null);
            ((StringBuilder)charSequence).append(object);
            object = a;
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            object3 = new File((String)object);
            object = new File((File)object3, "log0.txt");
            this.a((File)object);
            charSequence = "log1.txt";
            object = new File((File)object3, (String)charSequence);
            this.a((File)object);
            object = object3;
        }
        boolean bl3 = ((File)object).isDirectory();
        if (!bl3) {
            return null;
        }
        object3 = new StringBuilder();
        long l10 = ((Date)object2).getTime();
        ((StringBuilder)object3).append(l10);
        ((StringBuilder)object3).append("-");
        l10 = date.getTime();
        ((StringBuilder)object3).append(l10);
        charSequence = ".zip";
        ((StringBuilder)object3).append((String)charSequence);
        object3 = ((StringBuilder)object3).toString();
        object = new File((File)comparable, (String)object3);
        bl2 = ((File)object).exists();
        if (bl2) {
            return null;
        }
        this.a((Date)object2, date);
        long l11 = System.currentTimeMillis();
        object3 = new File((File)comparable, "log.txt");
        this.a((File)object3);
        comparable = new Comparable<File>();
        charSequence = "LOG: filter cost = ";
        ((StringBuilder)comparable).append((String)charSequence);
        l10 = System.currentTimeMillis() - l11;
        ((StringBuilder)comparable).append(l10);
        object2 = ((StringBuilder)comparable).toString();
        com.xiaomi.channel.commonutils.logger.b.c((String)object2);
        boolean bl4 = ((File)object3).exists();
        if (bl4) {
            l11 = System.currentTimeMillis();
            y.a((File)object, (File)object3);
            comparable = new Comparable<File>();
            charSequence = "LOG: zip cost = ";
            ((StringBuilder)comparable).append((String)charSequence);
            l10 = System.currentTimeMillis() - l11;
            ((StringBuilder)comparable).append(l10);
            object2 = ((StringBuilder)comparable).toString();
            com.xiaomi.channel.commonutils.logger.b.c((String)object2);
            ((File)object3).delete();
            bl4 = ((File)object).exists();
            if (bl4) {
                return object;
            }
        }
        return null;
    }

    public void a(int n10) {
        if (n10 != 0) {
            this.b = n10;
        }
    }
}

