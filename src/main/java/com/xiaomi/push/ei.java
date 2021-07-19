/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ac;
import com.xiaomi.push.ad;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.az;
import com.xiaomi.push.dq;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.if;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ei
extends ai$a {
    private Context a;
    private SharedPreferences a;
    private ak a;

    public ei(Context object) {
        SharedPreferences sharedPreferences;
        this.a = object;
        this.a = sharedPreferences = object.getSharedPreferences("mipush_extra", 0);
        object = ak.a(object);
        this.a = object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List a(File var1_1) {
        var2_7 = dq.a().a();
        var2_7 = var2_7 == null ? "" : var2_7.a();
        var3_8 = TextUtils.isEmpty((CharSequence)var2_7);
        var4_9 = 0;
        var5_10 = null;
        if (var3_8) {
            return null;
        }
        var6_11 = new ArrayList<Object>();
        var7_12 = 4;
        var8_13 = new byte[var7_12];
        var9_14 = dv.a;
        synchronized (var9_14) {
            block37: {
                block36: {
                    block38: {
                        var11_16 = this.a;
                        var11_16 = var11_16.getExternalFilesDir(null);
                        var12_17 = "push_cdata.lock";
                        var10_15 = new File((File)var11_16, (String)var12_17);
                        y.a((File)var10_15);
                        var12_17 = "rw";
                        var11_16 = new RandomAccessFile((File)var10_15, (String)var12_17);
                        var10_15 = var11_16.getChannel();
                        var10_15 = var10_15.lock();
                        try {
                            var12_17 = new FileInputStream((File)var1_1);
                        }
                        catch (Throwable var1_3) {
                            var12_17 = null;
                        }
                        while (true) {
                            block34: {
                                var13_18 = var12_17.read(var8_13);
                                if (var13_18 == var7_12 && (var14_19 = var12_17.read((byte[])(var5_10 = (Object)new byte[var13_18 = ac.a(var8_13)]))) == var13_18) break block34;
                                if (var10_15 != null && (var13_18 = (int)var10_15.isValid()) != 0) {
                                    var10_15.release();
                                }
lbl34:
                                // 4 sources

                                while (true) {
                                    y.a((Closeable)var12_17);
lbl36:
                                    // 2 sources

                                    while (true) {
                                        y.a((Closeable)var11_16);
                                        return var6_11;
                                    }
                                    break;
                                }
                            }
                            var1_1 = du.a((String)var2_7, (byte[])var5_10);
                            if (var1_1 == null || (var4_9 = ((Object)var1_1).length) == 0) continue;
                            var5_10 = new hu();
                            iw.a((ix)var5_10, (byte[])var1_1);
                            var6_11.add(var5_10);
                            continue;
                            break;
                        }
                        catch (Throwable var1_2) {
                        }
                        var5_10 = var10_15;
                        break block38;
                        catch (Exception v0) {
                            var12_17 = null;
lbl57:
                            // 2 sources

                            while (true) {
                                var5_10 = var10_15;
                                break block36;
                                break;
                            }
                        }
                        catch (Throwable var1_6) {
                            var11_16 = null;
                            var12_17 = null;
                        }
lbl64:
                        // 1 sources

                        while (true) {
                            var11_16 = null;
                            var12_17 = null;
                            break block36;
                            break;
                        }
                        catch (Exception v1) {
                            ** continue;
                        }
                        catch (Throwable var1_5) {
                            var12_17 = null;
                        }
                        catch (Exception v2) {
                            var12_17 = null;
                            break block36;
                        }
                    }
                    if (var5_10 != null && (var15_20 = var5_10.isValid())) {
                        var5_10.release();
                    }
lbl80:
                    // 4 sources

                    while (true) {
                        y.a(var12_17);
                        y.a((Closeable)var11_16);
                        throw var1_4;
                    }
                }
                if (var5_10 != null && (var13_18 = var5_10.isValid()) != 0) {
                    ** try [egrp 9[TRYBLOCK] [54 : 388->393)] { 
lbl87:
                    // 1 sources

                    break block37;
                } else lbl-1000:
                // 3 sources

                {
                    while (true) {
                        y.a((Closeable)var12_17);
                        ** continue;
                        break;
                    }
                }
lbl91:
                // 1 sources

                catch (IOException v3) {
                    ** GOTO lbl-1000
                }
                catch (IOException v4) {
                    ** continue;
                }
            }
            var5_10.release();
            ** continue;
            catch (Exception v5) {
                ** continue;
            }
            catch (IOException v6) {
                ** continue;
            }
        }
    }

    private void a() {
        SharedPreferences.Editor editor = this.a.edit();
        long l10 = System.currentTimeMillis() / 1000L;
        editor.putLong("last_upload_data_timestamp", l10);
        editor.commit();
    }

    private boolean a() {
        Context context = this.a;
        boolean bl2 = az.d(context);
        if (bl2) {
            return false;
        }
        context = this.a;
        bl2 = az.f(context);
        boolean bl3 = true;
        if (bl2 && !(bl2 = this.c())) {
            return bl3;
        }
        context = this.a;
        bl2 = az.g(context);
        if (bl2 && !(bl2 = this.b())) {
            return bl3;
        }
        context = this.a;
        bl2 = az.h(context);
        if (bl2) {
            return bl3;
        }
        return false;
    }

    private boolean b() {
        ak ak2 = this.a;
        int n10 = hr.L.a();
        boolean bl2 = true;
        int n11 = ak2.a(n10, bl2);
        n10 = 0;
        if (n11 == 0) {
            return false;
        }
        ak2 = this.a;
        int n12 = hr.M.a();
        int n13 = 432000;
        n11 = ak2.a(n12, n13);
        n12 = 86400;
        n11 = Math.max(n12, n11);
        SharedPreferences sharedPreferences = this.a;
        long l10 = -1;
        String string2 = "last_upload_data_timestamp";
        long l11 = sharedPreferences.getLong(string2, l10);
        long l12 = System.currentTimeMillis();
        long l13 = 1000L;
        long l14 = (l11 = Math.abs(l12 / l13 - l11)) - (l12 = (long)n11);
        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n11 <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    private boolean c() {
        ak ak2 = this.a;
        int n10 = hr.J.a();
        boolean bl2 = true;
        int n11 = ak2.a(n10, bl2);
        n10 = 0;
        if (n11 == 0) {
            return false;
        }
        ak2 = this.a;
        int n12 = hr.K.a();
        int n13 = 259200;
        n11 = ak2.a(n12, n13);
        n12 = 86400;
        n11 = Math.max(n12, n11);
        SharedPreferences sharedPreferences = this.a;
        long l10 = -1;
        String string2 = "last_upload_data_timestamp";
        long l11 = sharedPreferences.getLong(string2, l10);
        long l12 = System.currentTimeMillis();
        long l13 = 1000L;
        long l14 = (l11 = Math.abs(l12 / l13 - l11)) - (l12 = (long)n11);
        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n11 <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public int a() {
        return 1;
    }

    public void run() {
        Object object = this.a.getExternalFilesDir(null);
        Object object2 = "push_cdata.data";
        File file = new File((File)object, (String)object2);
        object = this.a;
        Object object3 = az.c((Context)object);
        if (object3 == 0) {
            long l10;
            long l11 = file.length();
            long l12 = l11 - (l10 = 1863680L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 > 0) {
                file.delete();
            }
            return;
        }
        object3 = this.a();
        if (object3 != 0) {
            return;
        }
        object3 = file.exists();
        if (object3 == 0) {
            return;
        }
        object = this.a(file);
        int n10 = ad.a((Collection)object);
        if (n10 == 0) {
            int n11;
            n10 = object.size();
            if (n10 > (n11 = 4000)) {
                n11 = n10 + -4000;
                object = object.subList(n11, n10);
            }
            object2 = new if();
            ((if)object2).a((List)object);
            object = y.a(iw.a((ix)object2));
            n11 = 0;
            String string2 = "-1";
            object2 = new il(string2, false);
            Object object4 = hw.q.a;
            ((il)object2).c((String)object4);
            ((il)object2).a((byte[])object);
            object = dq.a().a();
            if (object != null) {
                object4 = hm.i;
                object.a((il)object2, (hm)((Object)object4), null);
            }
            this.a();
        }
        file.delete();
    }
}

