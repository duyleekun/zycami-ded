/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.util.AttributeSet
 *  android.util.Log
 */
package com.meishe.cafconvertor.webpcoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.meishe.cafconvertor.webpcoder.FrameSequence;
import com.meishe.cafconvertor.webpcoder.WebpImageView$a;
import com.meishe.cafconvertor.webpcoder.WebpImageView$b;
import d.m.a.g.a;
import d.m.a.g.a$g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebpImageView
extends AppCompatImageView
implements a$g {
    private a a;
    private WebpImageView$a b;
    private WebpImageView$b c;

    public WebpImageView(Context object) {
        super((Context)object);
        super();
        this.b = object;
    }

    public WebpImageView(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super();
        this.b = object;
    }

    private byte[] b(InputStream inputStream) {
        int n10;
        int n11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = -1) != (n10 = inputStream.read(byArray))) {
            n11 = 0;
            byteArrayOutputStream.write(byArray, 0, n10);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void a(int n10, Bitmap bitmap, long l10) {
        WebpImageView$b webpImageView$b = this.c;
        if (webpImageView$b != null) {
            webpImageView$b.a(n10, bitmap, l10);
        }
    }

    public void c() {
        Object object = this.a;
        if (object != null) {
            ((a)object).l();
        }
        if ((object = this.b) != null) {
            ((WebpImageView$a)object).c();
            object = null;
            this.b = null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(int n10, int n11) {
        Throwable throwable2222222;
        Object object;
        String string2;
        String string3;
        block10: {
            String string4;
            StringBuilder stringBuilder;
            block11: {
                string3 = "io not closed in right way : ";
                string2 = "WebpImageView";
                object = null;
                Object object2 = this.getResources();
                object = object2.openRawResource(n10);
                Object object3 = this.b((InputStream)object);
                object3 = FrameSequence.d((byte[])object3);
                ((FrameSequence)object3).l(n11);
                WebpImageView$a webpImageView$a = this.b;
                object2 = new a((FrameSequence)object3, webpImageView$a);
                this.a = object2;
                ((a)object2).A(this);
                object3 = this.a;
                ((a)object3).w(n11);
                if (object == null) return;
                {
                    catch (Throwable throwable2222222) {
                        break block10;
                    }
                    catch (Exception exception) {}
                    {
                        stringBuilder = new StringBuilder();
                        String string5 = "error happens when get FrameSequenceDrawable : ";
                        stringBuilder.append(string5);
                        String string6 = exception.getMessage();
                        stringBuilder.append(string6);
                        string6 = stringBuilder.toString();
                        Log.e((String)string2, (String)string6);
                        if (object == null) return;
                    }
                    try {
                        ((InputStream)object).close();
                        return;
                    }
                    catch (IOException iOException) {
                        stringBuilder = new StringBuilder();
                        break block11;
                    }
                }
                try {
                    ((InputStream)object).close();
                    return;
                }
                catch (IOException iOException) {
                    stringBuilder = new StringBuilder();
                }
            }
            stringBuilder.append(string3);
            string4 = ((Throwable)((Object)string4)).getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return;
        }
        if (object == null) throw throwable2222222;
        try {
            ((InputStream)object).close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            String string7 = iOException.getMessage();
            ((StringBuilder)object).append(string7);
            string7 = ((StringBuilder)object).toString();
            Log.e((String)string2, (String)string7);
        }
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(InputStream var1_1, int var2_7) {
        block10: {
            var3_8 = "io not closed in right way : ";
            var4_9 = "WebpImageView";
            var5_10 = this.b(var1_1);
            var5_10 = FrameSequence.d((byte[])var5_10);
            var5_10.l(var2_7);
            var7_15 = this.b;
            this.a = var6_13 = new a((FrameSequence)var5_10, var7_15);
            var6_13.A(this);
            var5_10 = this.a;
            var5_10.w(var2_7);
            if (var1_1 == null) return;
            {
                catch (Throwable var8_17) {
                    break block10;
                }
                catch (Exception var8_18) {}
                {
                    var5_11 = new StringBuilder();
                    var6_14 = "error happens when get FrameSequenceDrawable : ";
                    var5_11.append(var6_14);
                    var8_16 = var8_18.getMessage();
                    var5_11.append((String)var8_16);
                    var8_16 = var5_11.toString();
                    Log.e((String)var4_9, (String)var8_16);
                    if (var1_1 == null) return;
                }
                try {
                    var1_1.close();
                    return;
                }
                catch (IOException var1_4) {
                    var8_16 = new StringBuilder();
                    ** GOTO lbl39
                }
            }
            try {
                var1_1.close();
                return;
            }
            catch (IOException var1_2) {
                var8_16 = new StringBuilder();
lbl39:
                // 2 sources

                var8_16.append(var3_8);
                var1_3 = var1_3.getMessage();
                var8_16.append(var1_3);
                var1_3 = var8_16.toString();
                Log.e((String)var4_9, (String)var1_3);
                return;
            }
        }
        if (var1_1 == null) throw var8_17;
        try {
            var1_1.close();
            throw var8_17;
        }
        catch (IOException var1_5) {
            var5_12 = new StringBuilder();
            var5_12.append(var3_8);
            var1_6 = var1_5.getMessage();
            var5_12.append(var1_6);
            var1_6 = var5_12.toString();
            Log.e((String)var4_9, (String)var1_6);
        }
        throw var8_17;
    }

    public void g() {
        a a10 = this.a;
        if (a10 != null) {
            this.setImageDrawable(a10);
            a10 = this.a;
            a10.start();
        }
    }

    public int getCount() {
        a a10 = this.a;
        if (a10 != null) {
            return a10.q();
        }
        return -1;
    }

    public void h() {
        a a10 = this.a;
        if (a10 != null) {
            a10.stop();
        }
    }

    public void setOnWebpFrameCallback(WebpImageView$b webpImageView$b) {
        this.c = webpImageView$b;
    }
}

