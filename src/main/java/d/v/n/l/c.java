/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package d.v.n.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zhiyun.live.R$string;
import d.v.e.f;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.n.l.c$a;
import d.v.n.l.c$b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c {
    private static volatile c f;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    public static final int j = 4;
    private final String a;
    private c$a b;
    private final Uri c;
    private final Uri d;
    private c$b e;

    private c() {
        String string2;
        Context context = d.v.e.f.a().c();
        this.a = string2 = k2.s("LiveCover").getAbsolutePath();
        File file = new File(string2, "cover.jpg");
        string2 = Uri.fromFile((File)file);
        this.d = string2;
        string2 = file.getPath();
        context = s1.n0(context, string2);
        this.c = context;
    }

    private void a(Activity object, Uri object2, Uri object3) {
        int n10;
        int n11;
        Object object4 = object2.getPath();
        if (object4 != null && (n11 = this.d((Uri)object2)) == 0) {
            long l10;
            long l11;
            long l12;
            object4 = object2.getPath();
            String string2 = "";
            object4 = ((String)object4).replace("/file", string2);
            Object object5 = new File((String)object4);
            n11 = 0x200000;
            boolean bl2 = ((File)object5).exists();
            if (bl2 && (n11 = (int)((l12 = (l11 = ((File)object5).length()) - (l10 = (long)n11)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) {
                object = ((File)object5).getPath();
                boolean bl3 = ((String)object).endsWith((String)(object2 = "jpeg"));
                if (bl3) {
                    object2 = this.a;
                    object3 = "cover.jpg";
                    object = new File((String)object2, (String)object3);
                    s1.d((File)object5, (File)object);
                    object2 = this.e;
                    object = Uri.fromFile((File)object);
                    object2.a((Uri)object);
                } else {
                    object = this.e;
                    object2 = Uri.fromFile((File)object5);
                    object.a((Uri)object2);
                }
                return;
            }
            object4 = this.e;
            n10 = R$string.live_cover_tip;
            object5 = d.v.f.i.g.m((Context)object, n10);
            object4.b((String)object5);
        }
        object4 = new Intent("com.android.camera.action.CROP");
        object4.setDataAndType((Uri)object2, "image/*");
        object4.putExtra("crop", "true");
        int n12 = this.b.a;
        object4.putExtra("aspectX", n12);
        n12 = this.b.b;
        object4.putExtra("aspectY", n12);
        n12 = this.b.c;
        object4.putExtra("outputX", n12);
        n12 = this.b.d;
        object4.putExtra("outputY", n12);
        object4.putExtra("outputFormat", "JPEG");
        n10 = 1;
        object4.putExtra("noFaceDetection", n10 != 0);
        object4.addFlags(2);
        object4.addFlags(n10);
        object4.putExtra("output", (Parcelable)object3);
        object4.putExtra("return-data", false);
        object.startActivityForResult((Intent)object4, 3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c c() {
        Object object = f;
        if (object != null) return f;
        object = c.class;
        synchronized (object) {
            c c10 = f;
            if (c10 != null) return f;
            f = c10 = new c();
            return f;
        }
    }

    private boolean d(Uri uri) {
        String string2;
        String string3 = d.v.e.f.a().c().getContentResolver().getType(uri);
        boolean bl2 = TextUtils.equals((CharSequence)string3, (CharSequence)(string2 = "image/gif"));
        if (bl2) {
            return true;
        }
        return uri.toString().toLowerCase().endsWith(".gif");
    }

    public static boolean e(int n10) {
        int n11;
        int n12 = 1;
        if (n12 != n10 && (n11 = 2) != n10 && (n11 = 3) != n10) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private void h(Activity activity) {
        s1.d0(this.a);
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        activity.startActivityForResult(intent, 2);
    }

    private void j(Activity activity) {
        s1.d0(this.a);
        Intent intent = new Intent();
        intent.addFlags(2);
        int n10 = 1;
        intent.addFlags(n10);
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        Uri uri = this.c;
        intent.putExtra("output", (Parcelable)uri);
        activity.startActivityForResult(intent, n10);
    }

    public void b(int n10) {
        int n11;
        if (n10 > 0 && n10 < (n11 = 100)) {
            Object object = this.d;
            object = object.getPath();
            FileInputStream fileInputStream = new FileInputStream((String)object);
            fileInputStream = BitmapFactory.decodeStream((InputStream)fileInputStream);
            Object object2 = this.d;
            object2 = object2.getPath();
            FileOutputStream fileOutputStream = new FileOutputStream((String)object2);
            object = new BufferedOutputStream(fileOutputStream);
            fileOutputStream = Bitmap.CompressFormat.JPEG;
            n10 += -1;
            try {
                fileInputStream.compress((Bitmap.CompressFormat)fileOutputStream, n10, (OutputStream)object);
                ((BufferedOutputStream)object).flush();
                ((FilterOutputStream)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public void f(Activity object, int n10, int n11, Intent intent) {
        if (object == null) {
            return;
        }
        int n12 = -1;
        if (n11 != n12) {
            object.finish();
            return;
        }
        n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 != n11) {
            n11 = 2;
            f10 = 2.8E-45f;
            if (n10 != n11) {
                int n13 = 3;
                float f11 = 4.2E-45f;
                if (n10 == n13) {
                    n13 = 4;
                    f11 = 5.6E-45f;
                    Object object2 = this.b;
                    n10 = ((c$a)object2).e;
                    if (n13 == n10 && (object = this.d.getPath()) != null) {
                        long l10;
                        long l11;
                        long l12;
                        object2 = this.d.getPath();
                        object = new File((String)object2);
                        n10 = 0x200000;
                        float f12 = 2.938736E-39f;
                        n11 = (int)(((File)object).exists() ? 1 : 0);
                        if (n11 != 0 && (n11 = (int)((l12 = (l11 = ((File)object).length()) - (l10 = (long)n10)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
                            f12 = n10;
                            n11 = 1120403456;
                            f10 = 100.0f;
                            f12 *= f10;
                            l11 = ((File)object).length();
                            f11 = l11;
                            n13 = (int)(f12 /= f11);
                            this.b(n13);
                        }
                    }
                    if ((object = this.e) != null) {
                        if (intent != null && (n13 = (int)(TextUtils.isEmpty((CharSequence)(object = intent.getAction())) ? 1 : 0)) == 0) {
                            object = this.e;
                            object2 = Uri.parse((String)intent.getAction());
                            object.a((Uri)object2);
                        } else {
                            object = this.e;
                            object2 = this.d;
                            object.a((Uri)object2);
                        }
                    }
                }
            } else {
                Object object3 = intent.getData();
                n11 = (int)(TextUtils.isEmpty((CharSequence)(object3 = s1.F((Context)object, object3))) ? 1 : 0);
                if (n11 != 0) {
                    object = this.e;
                    if (object != null) {
                        object3 = this.d;
                        object.a((Uri)object3);
                    }
                } else {
                    object3 = s1.n0((Context)object, (String)object3);
                    Uri uri = this.d;
                    this.a((Activity)object, (Uri)object3, uri);
                }
            }
        } else {
            Uri uri = this.c;
            Uri uri2 = this.d;
            this.a((Activity)object, uri, uri2);
        }
    }

    public void g(c$b c$b) {
        this.e = c$b;
    }

    public void i(Activity activity, c$a c$a) {
        this.b = c$a;
        this.h(activity);
    }

    public void k(Activity activity, c$a c$a) {
        this.b = c$a;
        this.j(activity);
    }
}

