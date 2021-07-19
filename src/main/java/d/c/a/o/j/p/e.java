/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.c.a.o.j.p;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import d.c.a.o.b;
import d.c.a.o.j.p.a;
import d.c.a.o.j.p.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class e {
    private static final String f = "ThumbStreamOpener";
    private static final a g;
    private final a a;
    private final d b;
    private final d.c.a.o.k.x.b c;
    private final ContentResolver d;
    private final List e;

    static {
        a a10;
        g = a10 = new a();
    }

    public e(List list, a a10, d d10, d.c.a.o.k.x.b b10, ContentResolver contentResolver) {
        this.a = a10;
        this.b = d10;
        this.c = b10;
        this.d = contentResolver;
        this.e = list;
    }

    public e(List list, d d10, d.c.a.o.k.x.b b10, ContentResolver contentResolver) {
        a a10 = g;
        this(list, a10, d10, b10, contentResolver);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private String b(Uri object) {
        void var1_4;
        d d10;
        block20: {
            d d11;
            block21: {
                String string2;
                block19: {
                    block17: {
                        block18: {
                            string2 = f;
                            d10 = null;
                            d11 = this.b;
                            d11 = d11.a((Uri)object);
                            if (d11 == null) break block17;
                            boolean bl2 = d11.moveToFirst();
                            if (!bl2) break block17;
                            bl2 = false;
                            Object var6_9 = null;
                            try {
                                object = d11.getString(0);
                                if (d11 == null) break block18;
                            }
                            catch (SecurityException securityException) {
                                break block19;
                            }
                            d11.close();
                        }
                        return object;
                    }
                    if (d11 != null) {
                        d11.close();
                    }
                    return null;
                    catch (Throwable throwable) {
                        break block20;
                    }
                    catch (SecurityException securityException) {
                        d11 = null;
                    }
                }
                int n10 = 3;
                n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0);
                if (n10 == 0) break block21;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "Failed to query for thumbnail for Uri: ";
                stringBuilder.append(string3);
                stringBuilder.append(object);
                object = stringBuilder.toString();
                try {
                    void var6_12;
                    Log.d((String)string2, (String)object, (Throwable)var6_12);
                }
                catch (Throwable throwable) {
                    d10 = d11;
                }
            }
            if (d11 != null) {
                d11.close();
            }
            return null;
        }
        if (d10 != null) {
            d10.close();
        }
        throw var1_4;
    }

    private boolean c(File file) {
        a a10;
        long l10;
        long l11;
        long l12;
        int n10;
        a a11 = this.a;
        boolean bl2 = a11.a(file);
        if (bl2 && (n10 = (l12 = (l11 = 0L) - (l10 = (a10 = this.a).c(file))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            file = null;
        }
        return n10 != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(Uri object) {
        Throwable throwable2;
        InputStream inputStream;
        block12: {
            String string2;
            block13: {
                int n10;
                string2 = f;
                inputStream = null;
                try {
                    Object object2 = this.d;
                    inputStream = object2.openInputStream(object);
                    object2 = this.e;
                    d.c.a.o.k.x.b b10 = this.c;
                    n10 = d.c.a.o.b.b((List)object2, inputStream, b10);
                    if (inputStream == null) return n10;
                }
                catch (Throwable throwable2) {
                    break block12;
                }
                catch (NullPointerException nullPointerException) {
                    break block13;
                }
                catch (IOException iOException) {
                    // empty catch block
                    break block13;
                }
                try {
                    inputStream.close();
                    return n10;
                }
                catch (IOException iOException) {
                    return n10;
                }
            }
            int n11 = 3;
            {
                n11 = (int)(Log.isLoggable((String)string2, (int)n11) ? 1 : 0);
                if (n11 != 0) {
                    void var4_8;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "Failed to open uri: ";
                    stringBuilder.append(string3);
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    Log.d((String)string2, (String)object, (Throwable)var4_8);
                }
                if (inputStream == null) return -1;
            }
            try {
                inputStream.close();
                return -1;
            }
            catch (IOException iOException) {
                return -1;
            }
        }
        if (inputStream == null) throw throwable2;
        try {}
        catch (IOException iOException) {
            throw throwable2;
        }
        inputStream.close();
        throw throwable2;
    }

    public InputStream d(Uri object) {
        Object object2 = this.b((Uri)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        FileNotFoundException fileNotFoundException = null;
        if (bl2) {
            return null;
        }
        a a10 = this.a;
        bl2 = this.c((File)(object2 = a10.b((String)object2)));
        if (!bl2) {
            return null;
        }
        object2 = Uri.fromFile((File)object2);
        try {
            a10 = this.d;
        }
        catch (NullPointerException nullPointerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NPE opening uri: ");
            stringBuilder.append(object);
            stringBuilder.append(" -> ");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            fileNotFoundException = new FileNotFoundException((String)object);
            throw (FileNotFoundException)fileNotFoundException.initCause(nullPointerException);
        }
        return a10.openInputStream((Uri)object2);
    }
}

