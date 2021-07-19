/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cx;
import com.xiaomi.push.ej$a;
import com.xiaomi.push.he;
import com.xiaomi.push.service.ae;
import com.xiaomi.push.service.be;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ad {
    private static long a;
    private static ThreadPoolExecutor a;
    private static final Pattern a;

    static {
        ThreadPoolExecutor threadPoolExecutor;
        a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        a = 0L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        a = threadPoolExecutor = new ThreadPoolExecutor(1, 1, 20, timeUnit, linkedBlockingQueue);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(String object) {
        BufferedReader bufferedReader;
        block7: {
            Comparable<File> comparable = new Comparable<File>((String)object);
            object = null;
            Object object2 = new FileReader((File)comparable);
            bufferedReader = new BufferedReader((Reader)object2);
            try {
                comparable = new Comparable<File>();
                while ((object2 = bufferedReader.readLine()) != null) {
                    String string2 = "\n";
                    ((StringBuilder)comparable).append(string2);
                    ((StringBuilder)comparable).append((String)object2);
                }
                object = ((StringBuilder)comparable).toString();
            }
            catch (Throwable throwable) {
                break block7;
            }
            y.a(bufferedReader);
            return object;
            catch (Throwable throwable) {
                bufferedReader = null;
                object = throwable;
            }
        }
        y.a(bufferedReader);
        throw object;
        catch (Exception exception) {
            block8: {
                bufferedReader = null;
                break block8;
                catch (Exception exception2) {}
            }
            y.a(bufferedReader);
            return null;
        }
    }

    public static void a() {
        int n10;
        long l10 = System.currentTimeMillis();
        Object object = a;
        int n11 = ((ThreadPoolExecutor)object).getActiveCount();
        if (n11 > 0) {
            long l11 = a;
            long l12 = 1800000L;
            long l13 = (l11 = l10 - l11) - l12;
            n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n11 < 0) {
                return;
            }
        }
        if ((n11 = (int)(((he)(object = he.a())).a() ? 1 : 0)) != 0 && (object = be.a().a()) != null && (n10 = ((ej$a)object).e()) > 0) {
            a = l10;
            List list = ((ej$a)object).a();
            boolean bl2 = true;
            ad.a(list, bl2);
        }
    }

    public static void a(List list, boolean bl2) {
        ThreadPoolExecutor threadPoolExecutor = a;
        ae ae2 = new ae(list, bl2);
        threadPoolExecutor.execute(ae2);
    }

    public static /* synthetic */ boolean a(String string2) {
        return ad.b(string2);
    }

    public static void b() {
        int n10;
        String string2;
        CharSequence charSequence;
        String string3 = ad.a("/proc/self/net/tcp");
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            charSequence = new StringBuilder();
            string2 = "dump tcp for uid = ";
            ((StringBuilder)charSequence).append(string2);
            n10 = Process.myUid();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            b.a((String)charSequence);
            b.a(string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = ad.a("/proc/self/net/tcp6"))))) {
            charSequence = new StringBuilder();
            string2 = "dump tcp6 for uid = ";
            ((StringBuilder)charSequence).append(string2);
            n10 = Process.myUid();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            b.a((String)charSequence);
            b.a(string3);
        }
    }

    private static boolean b(String string2) {
        CharSequence charSequence;
        Object object;
        Object object2;
        long l10 = System.currentTimeMillis();
        try {
            object2 = new StringBuilder();
            object = "ConnectivityTest: begin to connect to ";
        }
        catch (Throwable throwable) {
            charSequence = new StringBuilder();
            charSequence.append("ConnectivityTest: could not connect to:");
            charSequence.append(string2);
            charSequence.append(" exception: ");
            string2 = throwable.getClass().getSimpleName();
            charSequence.append(string2);
            charSequence.append(" description: ");
            string2 = throwable.getMessage();
            charSequence.append(string2);
            b.d(charSequence.toString());
            return false;
        }
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        b.a((String)object2);
        object2 = new Socket();
        int bl2 = 5222;
        object = cx.a(string2, bl2);
        int n10 = 5000;
        ((Socket)object2).connect((SocketAddress)object, n10);
        boolean bl3 = true;
        ((Socket)object2).setTcpNoDelay(bl3);
        long l11 = System.currentTimeMillis() - l10;
        CharSequence throwable = new StringBuilder();
        charSequence = "ConnectivityTest: connect to ";
        throwable.append((String)charSequence);
        throwable.append(string2);
        charSequence = " in ";
        throwable.append((String)charSequence);
        throwable.append(l11);
        throwable = throwable.toString();
        b.a((String)throwable);
        ((Socket)object2).close();
        return bl3;
    }
}

