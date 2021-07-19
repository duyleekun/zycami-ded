/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.h;

import com.baidu.location.h.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class d {
    public static d c;
    public String a = "firll.dat";
    public int b = 3164;
    public int d = 0;
    public int e = 20;
    public int f = 40;
    public int g = 60;
    public int h = 80;
    public int i = 100;

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long a(int n10) {
        void var11_11;
        long l10;
        Object object;
        long l11;
        block24: {
            block23: {
                RandomAccessFile randomAccessFile;
                block22: {
                    String string2 = l.j();
                    l11 = -1;
                    if (string2 == null) {
                        return l11;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    string2 = File.separator;
                    ((StringBuilder)object).append(string2);
                    string2 = this.a;
                    ((StringBuilder)object).append(string2);
                    string2 = ((StringBuilder)object).toString();
                    object = null;
                    String string3 = "rw";
                    randomAccessFile = new RandomAccessFile(string2, string3);
                    l10 = n10;
                    randomAccessFile.seek(l10);
                    n10 = randomAccessFile.readInt();
                    l10 = randomAccessFile.readLong();
                    int n11 = randomAccessFile.readInt();
                    if (n10 != n11) break block22;
                    randomAccessFile.close();
                    return l10;
                }
                try {
                    randomAccessFile.close();
                    return l11;
                }
                catch (IOException iOException) {
                    return l11;
                }
                catch (Throwable throwable) {
                    object = randomAccessFile;
                    break block23;
                }
                catch (Exception exception) {
                    object = randomAccessFile;
                    break block24;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (object != null) {
                ((RandomAccessFile)object).close();
            }
            throw var11_11;
            catch (Exception exception) {}
        }
        if (object != null) {
            ((RandomAccessFile)object).close();
        }
        return l11;
        catch (IOException iOException) {
            return l10;
        }
        catch (IOException iOException) {
            throw var11_11;
        }
    }

    public static d a() {
        d d10 = c;
        if (d10 == null) {
            c = d10 = new d();
        }
        return c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(int n10, long l10) {
        String string2 = l.j();
        if (string2 == null) {
            return;
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        string2 = File.separator;
        ((StringBuilder)object).append(string2);
        string2 = this.a;
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        String string3 = "rw";
        try {
            object = new RandomAccessFile(string2, string3);
        }
        catch (Exception exception) {
            return;
        }
        long l11 = n10;
        ((RandomAccessFile)object).seek(l11);
        n10 = this.b;
        ((RandomAccessFile)object).writeInt(n10);
        ((RandomAccessFile)object).writeLong(l10);
        n10 = this.b;
        ((RandomAccessFile)object).writeInt(n10);
        ((RandomAccessFile)object).close();
    }

    public void a(long l10) {
        int n10 = this.d;
        this.a(n10, l10);
    }

    public long b() {
        int n10 = this.d;
        return this.a(n10);
    }

    public void b(long l10) {
        int n10 = this.e;
        this.a(n10, l10);
    }

    public long c() {
        int n10 = this.e;
        return this.a(n10);
    }

    public void c(long l10) {
        int n10 = this.g;
        this.a(n10, l10);
    }

    public long d() {
        int n10 = this.g;
        return this.a(n10);
    }
}

