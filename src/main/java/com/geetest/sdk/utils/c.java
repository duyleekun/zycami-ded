/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import com.geetest.sdk.utils.c$a;
import com.geetest.sdk.utils.c$b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class c {
    private c() {
    }

    public /* synthetic */ c(c$a c$a) {
        this();
    }

    public static c a() {
        return c$b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream == null) {
            return "";
        }
        int n11 = 512;
        byte[] byArray = new byte[n11];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int n10;
            do {
                if ((n10 = bufferedInputStream.read(byArray)) <= 0) continue;
                String string2 = new String(byArray, 0, n10);
                stringBuilder.append(string2);
            } while (n10 >= n11);
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return stringBuilder.toString();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(String var1_1) {
        var2_7 = null;
        var3_8 = Runtime.getRuntime();
        var4_9 = "sh";
        var3_8 = var3_8.exec((String)var4_9);
        var5_10 = var3_8.getOutputStream();
        var4_9 = new BufferedOutputStream((OutputStream)var5_10);
        var6_11 = var3_8.getInputStream();
        var5_10 = new BufferedInputStream(var6_11);
        ** try [egrp 3[TRYBLOCK] [17, 16 : 53->95)] { 
lbl13:
        // 1 sources

        ** GOTO lbl54
lbl14:
        // 1 sources

        catch (Exception v0) {
            ** GOTO lbl19
        }
lbl-1000:
        // 1 sources

        {
            block37: {
                block36: {
                    block35: {
                        while (true) {
                            var4_9 = null;
                            var5_10 = null;
lbl19:
                            // 3 sources

                            while (true) {
                                if (var4_9 != null) {
                                    var4_9.close();
                                }
lbl23:
                                // 4 sources

                                while (true) {
                                    if (var5_10 != null) {
                                        var5_10.close();
                                    }
lbl27:
                                    // 4 sources

                                    while (true) {
                                        if (var3_8 == null) return null;
                                        var3_8.destroy();
                                        return null;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        catch (Exception v1) {
                            ** continue;
                        }
lbl33:
                        // 2 sources

                        while (true) {
                            if (var5_10 != null) {
                                var5_10.close();
                            }
lbl37:
                            // 4 sources

                            while (true) {
                                if (var3_8 == null) throw var1_4;
                                var3_8.destroy();
                                throw var1_4;
                            }
                            break;
                        }
lbl41:
                        // 1 sources

                        while (true) {
                            var5_10.close();
lbl44:
                            // 2 sources

                            while (true) {
                                if (var3_8 == null) return var1_1;
                                var3_8.destroy();
                                return var1_1;
                            }
                            break;
                        }
                        catch (Throwable var1_3) {
                            var5_10 = null;
                            break block35;
                        }
                        catch (Exception v2) {
                            var5_10 = null;
                            ** continue;
                        }
lbl54:
                        // 1 sources

                        var1_1 = var1_1.getBytes();
                        var4_9.write((byte[])var1_1);
                        var7_12 = 10;
                        var4_9.write(var7_12);
                        var4_9.flush();
                        var4_9.close();
                        var3_8.waitFor();
                        var1_1 = c.a((BufferedInputStream)var5_10);
                        {
                            var4_9.close();
                            ** continue;
                        }
lbl65:
                        // 1 sources

                        catch (Throwable var1_2) {}
                    }
                    var2_7 = var4_9;
                    break block37;
                    catch (Throwable var1_5) {
                        break block36;
                    }
                    catch (Throwable var1_6) {
                        var3_8 = null;
                    }
                }
                var5_10 = null;
            }
            if (var2_7 == null) ** GOTO lbl33
            {
                var2_7.close();
                ** continue;
            }
            catch (Exception v3) {}
            return null;
        }
        catch (IOException v4) {
            ** continue;
        }
        catch (IOException v5) {
            ** continue;
        }
        catch (IOException v6) {
            ** continue;
        }
        catch (IOException v7) {
            ** continue;
        }
    }
}

