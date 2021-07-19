/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package d.v.d.h;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import d.v.d.h.f;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final a b;
    private Map a;

    static {
        a a10;
        b = a10 = new a();
    }

    private a() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public static a b() {
        return b;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private void c(byte[] object) {
        void var2_9;
        Object object2;
        block51: {
            block54: {
                block52: {
                    void var2_11;
                    block53: {
                        ByteArrayInputStream byteArrayInputStream;
                        block50: {
                            block49: {
                                String string2 = "Make";
                                Object object3 = "Model";
                                Object object4 = "ImageWidth";
                                Object object5 = "ImageLength";
                                Object object6 = "FocalLength";
                                Object object7 = "ExposureTime";
                                Object object8 = "DateTime";
                                Object object9 = "Orientation";
                                object2 = null;
                                byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                                object = new BufferedInputStream;
                                ((BufferedInputStream)object)(byteArrayInputStream);
                                object2 = new ExifInterface((InputStream)object);
                                int n10 = 1;
                                n10 = ((ExifInterface)object2).getAttributeInt((String)object9, n10);
                                Map map = this.a;
                                map.clear();
                                map = this.a;
                                StringBuilder stringBuilder = new StringBuilder();
                                String string3 = "";
                                stringBuilder.append(string3);
                                stringBuilder.append(n10);
                                String string4 = stringBuilder.toString();
                                map.put(object9, string4);
                                object9 = this.a;
                                string4 = ((ExifInterface)object2).getAttribute((String)object8);
                                object9.put(object8, string4);
                                object8 = this.a;
                                object9 = ((ExifInterface)object2).getAttribute((String)object7);
                                object8.put(object7, object9);
                                object7 = this.a;
                                object8 = ((ExifInterface)object2).getAttribute((String)object6);
                                object7.put(object6, object8);
                                object6 = this.a;
                                object7 = ((ExifInterface)object2).getAttribute((String)object5);
                                object6.put(object5, object7);
                                object5 = this.a;
                                object6 = ((ExifInterface)object2).getAttribute((String)object4);
                                object5.put(object4, object6);
                                object4 = this.a;
                                object5 = ((ExifInterface)object2).getAttribute((String)object3);
                                object4.put(object3, object5);
                                object3 = this.a;
                                object4 = ((ExifInterface)object2).getAttribute(string2);
                                object3.put(string2, object4);
                                try {
                                    byteArrayInputStream.close();
                                }
                                catch (IOException iOException) {
                                    iOException.printStackTrace();
                                }
                                ((BufferedInputStream)object).close();
                                catch (Throwable throwable) {
                                    break block49;
                                }
                                catch (IOException iOException) {
                                    break block50;
                                }
                                catch (Throwable throwable) {
                                    object = null;
                                }
                            }
                            object2 = byteArrayInputStream;
                            break block51;
                            catch (IOException iOException) {
                                object = null;
                            }
                        }
                        object2 = byteArrayInputStream;
                        break block53;
                        catch (Throwable throwable) {
                            object = null;
                            break block51;
                        }
                        catch (IOException iOException) {
                            object = null;
                        }
                    }
                    var2_11.printStackTrace();
                    if (object2 == null) break block52;
                    try {
                        ((ByteArrayInputStream)object2).close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                if (object == null) break block54;
                try {
                    ((BufferedInputStream)object).close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            return;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object2 != null) {
            try {
                ((ByteArrayInputStream)object2).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        if (object != null) {
            try {
                ((BufferedInputStream)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        throw var2_9;
    }

    public int a() {
        return Integer.parseInt((String)this.a.get("Orientation"));
    }

    public void d(String string2, int n10) {
        synchronized (this) {
            int n11;
            CharSequence charSequence;
            Object object;
            block15: {
                object = this.a;
                object.clear();
                object = this.a;
                charSequence = "Model";
                object.put(charSequence, string2);
                n11 = 0;
                string2 = null;
                int n12 = 90;
                if (n10 != n12) {
                    n12 = 180;
                    if (n10 != n12) {
                        n12 = 270;
                        if (n10 == n12) {
                            n11 = 8;
                        }
                    } else {
                        n11 = 3;
                    }
                    break block15;
                }
                n11 = 6;
            }
            Map map = this.a;
            object = "Orientation";
            charSequence = new StringBuilder();
            String string3 = "";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(n11);
            string2 = ((StringBuilder)charSequence).toString();
            map.put(object, string2);
            return;
        }
    }

    public void e(byte[] byArray) {
        synchronized (this) {
            this.c(byArray);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(Context object, Uri object2) {
        synchronized (this) {
            Throwable throwable2;
            InputStream inputStream;
            block11: {
                boolean bl2;
                inputStream = null;
                object = object.getContentResolver();
                inputStream = object.openInputStream((Uri)object2);
                object = new ExifInterface(inputStream);
                object2 = this.a;
                object2 = object2.entrySet();
                object2 = object2.iterator();
                while (bl2 = object2.hasNext()) {
                    Object object3 = object2.next();
                    object3 = (Map.Entry)object3;
                    Object object4 = object3.getKey();
                    object4 = (String)object4;
                    object3 = object3.getValue();
                    object3 = (String)object3;
                    ((ExifInterface)object).setAttribute((String)object4, (String)object3);
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = "PhotoExif key=";
                    stringBuilder.append(string2);
                    stringBuilder.append((String)object4);
                    object4 = ",value=";
                    stringBuilder.append((String)object4);
                    stringBuilder.append((String)object3);
                    object3 = stringBuilder.toString();
                    f.a(object3);
                }
                ((ExifInterface)object).saveAttributes();
                if (inputStream == null) return;
                {
                    catch (Throwable throwable2) {
                        break block11;
                    }
                    catch (IOException iOException) {}
                    {
                        object2 = new StringBuilder();
                        String string3 = "PhotoExif error =";
                        ((StringBuilder)object2).append(string3);
                        String string4 = iOException.toString();
                        ((StringBuilder)object2).append(string4);
                        string4 = ((StringBuilder)object2).toString();
                        f.a(string4);
                        if (inputStream == null) return;
                    }
                }
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
                return;
            }
            if (inputStream == null) throw throwable2;
            try {
                inputStream.close();
                throw throwable2;
            }
            catch (IOException iOException) {
                throw throwable2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g(String object) {
        synchronized (this) {
            ExifInterface exifInterface = new ExifInterface((String)object);
            object = this.a;
            object = object.entrySet();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    exifInterface.saveAttributes();
                    return;
                }
                Object object2 = object.next();
                object2 = (Map.Entry)object2;
                Object object3 = object2.getKey();
                object3 = (String)object3;
                object2 = object2.getValue();
                object2 = (String)object2;
                exifInterface.setAttribute((String)object3, (String)object2);
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "PhotoExif key=";
                stringBuilder.append(string2);
                stringBuilder.append((String)object3);
                object3 = ",value=";
                stringBuilder.append((String)object3);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                f.a(object2);
            }
        }
    }
}

