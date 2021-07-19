/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.tencent.qq;

import android.content.Context;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.e;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;

public class e$1
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ int h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ int l;
    public final /* synthetic */ e m;

    public e$1(e e10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n10, String string9, String string10, String string11, int n11) {
        this.m = e10;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = string7;
        this.g = string8;
        this.h = n10;
        this.i = string9;
        this.j = string10;
        this.k = string11;
        this.l = n11;
    }

    /*
     * Loose catch block
     */
    public void run() {
        e$1 e$1 = this;
        String string2 = "ShareSDK";
        Object object = null;
        int n10 = 1;
        Object object2 = this.m;
        object2 = cn.sharesdk.tencent.qq.e.a((e)object2);
        Object object3 = this.a;
        object2 = BitmapHelper.downloadBitmap((Context)object2, (String)object3);
        object3 = SSDKLog.b();
        Object object4 = new Object[n10];
        CharSequence charSequence = new StringBuilder();
        String string3 = " QQ ShareActivity path: ";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)object2);
        charSequence = ((StringBuilder)charSequence).toString();
        object4[0] = charSequence;
        try {
            ((NLog)object3).d(string2, object4);
        }
        catch (Throwable throwable) {
            object3 = SSDKLog.b();
            object4 = new Object[n10];
            charSequence = new StringBuilder();
            string3 = " QQ ShareActivity path catch ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(throwable);
            charSequence = ((StringBuilder)charSequence).toString();
            object4[0] = charSequence;
            ((NLog)object3).d(string2, object4);
            object3 = SSDKLog.b();
            ((NLog)object3).d(throwable);
            object2 = null;
        }
        Object object5 = object2;
        object3 = e$1.m;
        object4 = e$1.b;
        charSequence = e$1.c;
        string3 = e$1.d;
        String string4 = e$1.a;
        String string5 = e$1.e;
        String string6 = e$1.f;
        String string7 = e$1.g;
        int n11 = e$1.h;
        String string8 = e$1.i;
        object2 = e$1.j;
        object = e$1.k;
        n10 = e$1.l;
        cn.sharesdk.tencent.qq.e.a((e)object3, (String)object4, (String)charSequence, string3, string4, (String)object5, string5, string6, string7, n11, string8, (String)object2, (String)object, n10);
        {
            catch (Throwable throwable) {
                SSDKLog.b().d(throwable);
                object = SSDKLog.b();
                n10 = 1;
                Object[] objectArray = new Object[n10];
                object3 = new StringBuilder();
                object4 = " QQ ShareActivity run catch ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(throwable);
                String string9 = ((StringBuilder)object3).toString();
                object3 = null;
                objectArray[0] = string9;
                ((NLog)object).d(string2, objectArray);
            }
        }
    }
}

