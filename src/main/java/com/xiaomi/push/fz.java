/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.cv;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gv;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class fz
extends fs {
    public Exception a;
    public Socket a = null;
    public XMPushService b;
    private int c;
    public String c = null;
    private String d;
    public volatile long e;
    public volatile long f;
    public volatile long g;

    public fz(XMPushService xMPushService, ft ft2) {
        super(xMPushService, ft2);
        long l10;
        this.e = l10 = 0L;
        this.f = l10;
        this.g = l10;
        this.b = xMPushService;
    }

    private void a(ft ft2) {
        String string2 = ft2.c();
        int n10 = ft2.a();
        this.a(string2, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(String var1_1, int var2_2) {
        block53: {
            var3_3 = this;
            var4_4 = var1_1;
            var5_14 = var2_2;
            var6_15 = "\n";
            var7_16 = " err:";
            var8_17 = " port:";
            var9_18 = "SMACK: Could not connect to ";
            var10_19 = "SMACK: Could not connect to:";
            this.a = null;
            var11_20 = new ArrayList();
            var12_21 = new Comparable<StringBuilder>();
            var13_22 = "get bucket for host : ";
            var12_21.append((String)var13_22);
            var12_21.append(var1_1);
            var14_23 = com.xiaomi.channel.commonutils.logger.b.a(var12_21.toString());
            var15_24 = this.a(var1_1);
            var12_21 = var14_23;
            com.xiaomi.channel.commonutils.logger.b.a((Integer)var12_21);
            var14_23 = 1;
            if (var15_24 != null) {
                var11_20 = var15_24.a((boolean)var14_23);
            }
            if (var16_25 = var11_20.isEmpty()) {
                var11_20.add(var4_4);
            }
            var3_3.g = var17_26 = 0L;
            var19_27 = az.a((Context)var3_3.b);
            var20_28 /* !! */  = new StringBuilder();
            var11_20 = var11_20.iterator();
            var21_29 = 0;
            var4_4 = null;
            var16_25 = false;
            var13_22 = null;
            var22_30 = 0.0f;
            while ((var21_29 = var11_20.hasNext()) != 0) {
                block61: {
                    block58: {
                        block56: {
                            block60: {
                                block57: {
                                    block59: {
                                        block55: {
                                            block54: {
                                                block52: {
                                                    block51: {
                                                        var4_4 = var11_20.next();
                                                        var23_31 /* !! */  = var4_4;
                                                        var23_31 /* !! */  = var4_4;
                                                        var24_32 = System.currentTimeMillis();
                                                        var3_3.a = var21_29 = var3_3.a + var14_23;
                                                        var4_4 = new StringBuilder();
                                                        var26_33 = "begin to connect to ";
                                                        var4_4.append((String)var26_33);
                                                        var4_4.append(var23_31 /* !! */ );
                                                        var4_4 = var4_4.toString();
                                                        com.xiaomi.channel.commonutils.logger.b.a((String)var4_4);
                                                        var4_4 = this.a();
                                                        var3_3.a = var4_4;
                                                        var4_4 = cx.a(var23_31 /* !! */ , var5_14);
                                                        var26_33 = var3_3.a;
                                                        var14_23 = 8000;
                                                        var26_33.connect((SocketAddress)var4_4, var14_23);
                                                        var4_4 = "tcp connected";
                                                        com.xiaomi.channel.commonutils.logger.b.a((String)var4_4);
                                                        var4_4 = var3_3.a;
                                                        var14_23 = 1;
                                                        var4_4.setTcpNoDelay((boolean)var14_23);
                                                        var3_3.d = var23_31 /* !! */ ;
                                                        this.a();
                                                        var17_26 = System.currentTimeMillis() - var24_32;
                                                        var3_3.a = var17_26;
                                                        var3_3.b = var19_27;
                                                        if (var15_24 == null) break block51;
                                                        var27_34 = 0L;
                                                        var13_22 = var15_24;
                                                        var26_33 = var23_31 /* !! */ ;
                                                        var29_35 = var11_20;
                                                        var12_21 = var20_28 /* !! */ ;
                                                        var11_20 = var23_31 /* !! */ ;
                                                        var30_36 = var17_26;
                                                        var32_37 = var15_24;
                                                        var33_38 = var19_27;
                                                        var34_39 = var27_34;
                                                        var15_24.b(var23_31 /* !! */ , var17_26, var27_34);
                                                        break block52;
                                                    }
                                                    var29_35 = var11_20;
                                                    var12_21 = var20_28 /* !! */ ;
                                                    var11_20 = var23_31 /* !! */ ;
                                                    var32_37 = var15_24;
                                                    var33_38 = var19_27;
                                                }
                                                var17_26 = SystemClock.elapsedRealtime();
                                                var3_3.g = var17_26;
                                                var4_4 = new StringBuilder();
                                                var13_22 = "connected to ";
                                                var4_4.append((String)var13_22);
                                                var4_4.append((String)var11_20);
                                                var13_22 = " in ";
                                                var4_4.append((String)var13_22);
                                                var17_26 = var3_3.a;
                                                var4_4.append(var17_26);
                                                var4_4 = var4_4.toString();
                                                try {
                                                    com.xiaomi.channel.commonutils.logger.b.a((String)var4_4);
                                                    var36_40 = true;
                                                    var37_41 = 1.4E-45f;
                                                    break block53;
                                                }
                                                catch (Throwable var4_5) {
                                                    break block54;
                                                }
                                                catch (Exception var4_6) {
                                                    var15_24 = var33_38;
                                                    break block55;
                                                }
                                                catch (Throwable var4_7) {
                                                    var29_35 = var11_20;
                                                    var12_21 = var20_28 /* !! */ ;
                                                    var11_20 = var23_31 /* !! */ ;
                                                    var32_37 = var15_24;
                                                    var33_38 = var19_27;
                                                }
                                            }
                                            var36_40 = true;
                                            var37_41 = 1.4E-45f;
                                            break block59;
                                            catch (Exception var4_8) {
                                                var29_35 = var11_20;
                                                var12_21 = var20_28 /* !! */ ;
                                                var11_20 = var23_31 /* !! */ ;
                                                var32_37 = var15_24;
                                                var15_24 = var19_27;
                                            }
                                        }
                                        var36_40 = true;
                                        var37_41 = 1.4E-45f;
                                        break block56;
                                        catch (Exception var4_9) {
                                            var29_35 = var11_20;
                                            var12_21 = var20_28 /* !! */ ;
                                            var11_20 = var23_31 /* !! */ ;
                                            var32_37 = var15_24;
                                            var36_40 = var16_25;
                                            var37_41 = var22_30;
                                            var15_24 = var19_27;
                                            break block56;
                                        }
                                        catch (Throwable var4_10) {
                                            var29_35 = var11_20;
                                            var12_21 = var20_28 /* !! */ ;
                                            var11_20 = var23_31 /* !! */ ;
                                            var32_37 = var15_24;
                                            var33_38 = var19_27;
                                            var36_40 = var16_25;
                                            var37_41 = var22_30;
                                        }
                                    }
                                    var26_33 = "abnormal exception";
                                    var13_22 = new Exception((String)var26_33, (Throwable)var4_4);
                                    try {
                                        var3_3.a = var13_22;
                                        com.xiaomi.channel.commonutils.logger.b.a((Throwable)var4_4);
                                        if (var36_40) break block57;
                                        var4_4 = new StringBuilder();
                                        var4_4.append(var10_19);
                                    }
                                    catch (Throwable var4_11) {
                                        var15_24 = var33_38;
                                    }
                                    var4_4.append((String)var11_20);
                                    com.xiaomi.channel.commonutils.logger.b.d(var4_4.toString());
                                    var12_21.append(var9_18);
                                    var12_21.append((String)var11_20);
                                    var12_21.append((String)var8_17);
                                    var12_21.append(var5_14);
                                    var12_21.append((String)var7_16);
                                    var4_4 = var3_3.a.getClass().getSimpleName();
                                    var12_21.append((String)var4_4);
                                    var12_21.append(var6_15);
                                    var4_4 = var3_3.a;
                                    hg.a((String)var11_20, (Exception)var4_4);
                                    if (var32_37 != null) {
                                        var17_26 = System.currentTimeMillis();
                                        var30_36 = var17_26 - var24_32;
                                        var34_39 = 0L;
                                        var4_4 = var3_3.a;
                                        var13_22 = var32_37;
                                        var26_33 = var11_20;
                                        var32_37.b((String)var11_20, var30_36, var34_39, (Exception)var4_4);
                                    }
                                    var4_4 = az.a((Context)var3_3.b);
                                    var15_24 = var33_38;
                                    var21_29 = (int)TextUtils.equals((CharSequence)var33_38, (CharSequence)var4_4);
                                    if (var21_29 == 0) {
                                        break block53;
                                    }
                                    break block60;
                                }
                                var15_24 = var33_38;
                            }
                            while (true) {
                                var11_20 = var15_24;
                                break block58;
                                break;
                            }
                            break block61;
                        }
                        try {
                            var3_3.a = var4_4;
                            if (var36_40) ** continue;
                            var4_4 = new StringBuilder();
                            var4_4.append(var10_19);
                        }
                        catch (Throwable var4_13) {
                            // empty catch block
                        }
                        var4_4.append((String)var11_20);
                        com.xiaomi.channel.commonutils.logger.b.d(var4_4.toString());
                        var12_21.append(var9_18);
                        var12_21.append((String)var11_20);
                        var12_21.append((String)var8_17);
                        var12_21.append(var5_14);
                        var12_21.append((String)var7_16);
                        var4_4 = var3_3.a.getClass().getSimpleName();
                        var12_21.append((String)var4_4);
                        var12_21.append(var6_15);
                        var4_4 = var3_3.a;
                        hg.a((String)var11_20, (Exception)var4_4);
                        if (var32_37 != null) {
                            var17_26 = System.currentTimeMillis();
                            var30_36 = var17_26 - var24_32;
                            var38_42 = 0L;
                            var4_4 = var3_3.a;
                            var13_22 = var32_37;
                            var26_33 = var11_20;
                            var11_20 = var15_24;
                            var34_39 = var38_42;
                            var32_37.b((String)var26_33, var30_36, var38_42, (Exception)var4_4);
                        } else {
                            var11_20 = var15_24;
                        }
                        var4_4 = az.a((Context)var3_3.b);
                        var21_29 = (int)TextUtils.equals((CharSequence)var11_20, (CharSequence)var4_4);
                        if (var21_29 == 0) break block53;
                    }
                    var16_25 = var36_40;
                    var22_30 = var37_41;
                    var19_27 = var11_20;
                    var20_28 /* !! */  = var12_21;
                    var15_24 = var32_37;
                    var11_20 = var29_35;
                    var14_23 = 1;
                    continue;
                }
                if (!var36_40) {
                    var13_22 = new StringBuilder();
                    var13_22.append(var10_19);
                    var13_22.append((String)var11_20);
                    var10_19 = var13_22.toString();
                    com.xiaomi.channel.commonutils.logger.b.d(var10_19);
                    var12_21.append(var9_18);
                    var12_21.append((String)var11_20);
                    var12_21.append((String)var8_17);
                    var12_21.append(var5_14);
                    var12_21.append((String)var7_16);
                    var40_43 = var3_3.a.getClass().getSimpleName();
                    var12_21.append((String)var40_43);
                    var12_21.append(var6_15);
                    var40_43 = var3_3.a;
                    hg.a((String)var11_20, (Exception)var40_43);
                    if (var32_37 != null) {
                        var30_36 = System.currentTimeMillis() - var24_32;
                        var41_44 = 0L;
                        var7_16 = var3_3.a;
                        var13_22 = var32_37;
                        var26_33 = var11_20;
                        var8_17 = var15_24;
                        var34_39 = var41_44;
                        var32_37.b((String)var11_20, var30_36, var41_44, (Exception)var7_16);
                    } else {
                        var8_17 = var15_24;
                    }
                    var40_43 = az.a((Context)var3_3.b);
                    var5_14 = (int)TextUtils.equals((CharSequence)var8_17, (CharSequence)var40_43);
                    if (var5_14 == 0) break block53;
                }
                throw var4_4;
            }
            var12_21 = var20_28 /* !! */ ;
            var36_40 = var16_25;
            var37_41 = var22_30;
        }
        var4_4 = cz.a();
        var4_4.c();
        if (var36_40) {
            return;
        }
        var40_43 = var12_21.toString();
        var4_4 = new gd((String)var40_43);
        throw var4_4;
    }

    public cv a(String string2) {
        Object object = cz.a();
        gc gc2 = null;
        boolean bl2 = ((cv)(object = ((cz)object).a(string2, false))).b();
        if (!bl2) {
            gc2 = new gc(this, string2);
            gv.a(gc2);
        }
        return object;
    }

    public String a() {
        return this.d;
    }

    public Socket a() {
        Socket socket = new Socket();
        return socket;
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a() {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, Exception exception) {
        synchronized (this) {
            long l10;
            int n11 = this.b();
            int n12 = 2;
            if (n11 == n12) {
                return;
            }
            this.a(n12, n10, exception);
            Object object = "";
            ((fs)this).a = object;
            try {
                object = this.a;
                ((Socket)object).close();
            }
            catch (Throwable throwable) {}
            this.e = l10 = 0L;
            this.f = l10;
            return;
        }
    }

    public void a(Exception exception) {
        block3: {
            block2: {
                long l10 = SystemClock.elapsedRealtime();
                long l11 = this.g;
                long l12 = (l10 -= l11) - (l11 = 300000L);
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object >= 0) break block2;
                Object object2 = this.b;
                object = az.b((Context)object2);
                if (object == false) break block3;
                object = this.c + 1;
                this.c = (int)object;
                int n10 = 2;
                if (object < n10) break block3;
                object2 = this.a();
                CharSequence charSequence = new StringBuilder();
                String string2 = "max short conn time reached, sink down current host:";
                charSequence.append(string2);
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)charSequence);
                l11 = 0L;
                this.a((String)object2, l11, exception);
            }
            this.c = 0;
        }
    }

    public void a(String object, long l10, Exception exception) {
        String string2 = ft.a();
        cz cz2 = cz.a();
        cv cv2 = cz2.a(string2, false);
        if (cv2 != null) {
            long l11 = 0L;
            cv2.b((String)object, l10, l11, exception);
            object = cz.a();
            ((cz)object).c();
        }
    }

    public abstract void a(boolean var1);

    public void a(fl[] object) {
        object = new gd("Don't support send Blob");
        throw object;
    }

    public void b(int n10, Exception exception) {
        long l10;
        long l11;
        long l12;
        int n11;
        this.a(n10, exception);
        if ((exception != null || n10 == (n11 = 18)) && (n10 = (int)((l12 = (l11 = this.g) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            this.a(exception);
        }
    }

    public void b(boolean bl2) {
        long l10 = System.currentTimeMillis();
        this.a(bl2);
        if (!bl2) {
            XMPushService xMPushService = this.b;
            int n10 = 13;
            ga ga2 = new ga(this, n10, l10);
            l10 = 10000L;
            xMPushService.a(ga2, l10);
        }
    }

    public String c() {
        return ((fs)this).a;
    }

    public void c(int n10, Exception exception) {
        XMPushService xMPushService = this.b;
        gb gb2 = new gb(this, 2, n10, exception);
        xMPushService.a(gb2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e() {
        synchronized (this) {
            try {
                try {
                    boolean bl2 = this.c();
                    if (!bl2 && !(bl2 = this.b())) {
                        bl2 = false;
                        ft ft2 = null;
                        Object var3_6 = null;
                        this.a(0, 0, null);
                        ft2 = ((fs)this).a;
                        this.a(ft2);
                        return;
                    }
                    String string2 = "WARNING: current xmpp has connected";
                    com.xiaomi.channel.commonutils.logger.b.a(string2);
                    return;
                }
                catch (IOException iOException) {
                    gd gd2 = new gd(iOException);
                    throw gd2;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void f() {
        long l10;
        this.e = l10 = SystemClock.elapsedRealtime();
    }

    public void g() {
        long l10;
        this.f = l10 = SystemClock.elapsedRealtime();
    }
}

