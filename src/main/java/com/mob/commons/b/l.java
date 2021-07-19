/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mob.commons.b.c;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.b.l$a;
import com.mob.commons.k;
import java.lang.reflect.Method;

public class l
extends f {
    private l$a c = null;
    private l$a d = null;
    private l$a e = null;
    private String f = "11154";

    public l(Context context) {
        super(context);
    }

    private String a(String object, String string2) {
        int n10;
        Object[] objectArray;
        Object object2 = String.class;
        Object object3 = "android.os.SystemProperties";
        try {
            object3 = Class.forName((String)object3);
            objectArray = "get";
            n10 = 2;
        }
        catch (Throwable throwable) {
            com.mob.commons.b.c.a().a(throwable);
            return string2;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        int n11 = 1;
        classArray[n11] = object2;
        object2 = ((Class)object3).getMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        objectArray[0] = object;
        object = "unknown";
        objectArray[n11] = object;
        object = ((Method)object2).invoke(object3, objectArray);
        return (String)object;
    }

    public static /* synthetic */ void a(l l10, boolean bl2, int n10) {
        l10.a(bl2, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl2, int n10) {
        try {
            String string2 = this.a(n10);
            if (n10 == 0) {
                this.a(string2);
                return;
            }
            int n11 = 2;
            if (n10 == n11) {
                this.b(string2);
                return;
            }
            n11 = 1;
            if (n10 != n11) return;
            this.c(string2);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    private String b(int n10) {
        CharSequence charSequence;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n10 = 0;
                    charSequence = null;
                } else {
                    charSequence = new StringBuilder();
                    n11 = 97;
                    String string2 = k.a(n11);
                    ((StringBuilder)charSequence).append(string2);
                    string2 = this.f;
                    ((StringBuilder)charSequence).append(string2);
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            } else {
                charSequence = new StringBuilder();
                n11 = 96;
                String string3 = k.a(n11);
                ((StringBuilder)charSequence).append(string3);
                string3 = this.f;
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
            }
        } else {
            n10 = 95;
            charSequence = k.a(n10);
        }
        return charSequence;
    }

    private void c(int n10) {
        Uri uri = null;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                l$a l$a;
                n11 = 2;
                if (n10 == n11 && (l$a = this.e) == null) {
                    this.e = l$a = new l$a(this, n11);
                    l$a = this.a.getContentResolver();
                    Uri uri2 = Uri.parse((String)this.b(n11));
                    l$a l$a2 = this.e;
                    l$a.registerContentObserver(uri2, false, l$a2);
                }
            } else {
                l$a l$a = this.d;
                if (l$a == null) {
                    this.d = l$a = new l$a(this, n11);
                    l$a = this.a.getContentResolver();
                    Uri uri3 = Uri.parse((String)this.b(n11));
                    l$a l$a3 = this.d;
                    l$a.registerContentObserver(uri3, false, l$a3);
                }
            }
        } else {
            l$a l$a = this.c;
            if (l$a == null) {
                this.c = l$a = new l$a(this, 0);
                l$a = this.a.getContentResolver();
                uri = Uri.parse((String)this.b(0));
                l$a l$a4 = this.c;
                l$a.registerContentObserver(uri, n11 != 0, l$a4);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String a(int var1_1) {
        block34: {
            block35: {
                block32: {
                    block33: {
                        var2_2 = this.b(var1_1);
                        var3_3 = null;
                        if (var2_2 == null) {
                            return null;
                        }
                        var4_5 = Uri.parse((String)var2_2);
                        var2_2 = this.a;
                        var5_6 /* !! */  = var2_2.getContentResolver();
                        var2_2 = var5_6 /* !! */ .query((Uri)var4_5, null, null, null, null);
                        if (var2_2 == null) break block32;
                        var6_10 = var2_2.moveToNext();
                        if (var6_10 == 0) break block32;
                        var5_6 /* !! */  = "value";
                        var6_10 = var2_2.getColumnIndex((String)var5_6 /* !! */ );
                        var3_3 = var2_2.getString(var6_10);
                        if (var2_2 == null) break block33;
                        var2_2.close();
                    }
lbl26:
                    // 2 sources

                    while (true) {
                        this.c(var1_1);
lbl29:
                        // 2 sources

                        return var3_3;
                        break;
                    }
                    catch (Throwable var5_7) {}
                    break block35;
                }
                if (var2_2 == null) ** GOTO lbl38
lbl35:
                // 2 sources

                while (true) {
                    var2_2.close();
lbl38:
                    // 4 sources

                    while (true) {
                        this.c(var1_1);
                        break block34;
                        break;
                    }
                    break;
                }
                catch (Throwable var5_8) {
                    var2_2 = null;
                }
            }
            var4_5 = com.mob.commons.b.c.a();
            var4_5.a(var5_9);
            if (var2_2 == null) ** GOTO lbl38
            ** continue;
            catch (Throwable v0) {}
        }
        return null;
        catch (Throwable var3_4) {
            if (var2_2 != null) {
                var2_2.close();
            }
lbl58:
            // 4 sources

            while (true) {
                this.c(var1_1);
lbl61:
                // 2 sources

                throw var3_4;
            }
        }
        catch (Throwable v1) {
            ** continue;
        }
        catch (Throwable v2) {
            ** continue;
        }
        catch (Throwable v3) {
            ** continue;
        }
        {
            catch (Throwable v4) {
                ** continue;
            }
            catch (Throwable v5) {
                ** continue;
            }
        }
    }

    public f$c c() {
        String string2;
        f$c f$c = new f$c();
        f$c.b = string2 = this.a(0);
        f$c.e = string2 = this.a(1);
        f$c.c = string2 = this.a(2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            f$c.c = string2 = this.i();
        }
        return f$c;
    }

    public boolean h() {
        synchronized (this) {
            String string2 = "1";
            int n10 = 94;
            String string3 = k.a(n10);
            String string4 = "0";
            string3 = this.a(string3, string4);
            boolean bl2 = string2.equals(string3);
            return bl2;
        }
    }
}

