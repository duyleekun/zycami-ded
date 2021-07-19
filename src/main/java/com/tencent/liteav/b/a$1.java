/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.b.a;
import com.tencent.liteav.b.a$a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.io.File;

public class a$1
extends Handler {
    public final /* synthetic */ a a;

    public a$1(a a10, Looper looper) {
        this.a = a10;
        super(looper);
    }

    public void handleMessage(Message object) {
        Object object2 = com.tencent.liteav.b.a.a(this.a);
        if (object2 != null) {
            int n10 = ((Message)object).what;
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    Object object3;
                    block13: {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("record complete. errcode = ");
                        n11 = ((Message)object).arg1;
                        ((StringBuilder)object2).append(n11);
                        ((StringBuilder)object2).append(", errmsg = ");
                        String string2 = (String)((Message)object).obj;
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(", outputPath = ");
                        string2 = com.tencent.liteav.b.a.b((a)this.a).f;
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(", coverImage = ");
                        string2 = com.tencent.liteav.b.a.b((a)this.a).g;
                        ((StringBuilder)object2).append(string2);
                        object2 = ((StringBuilder)object2).toString();
                        string2 = "TXCStreamRecord";
                        TXCLog.d(string2, (String)object2);
                        n10 = ((Message)object).arg1;
                        if (n10 == 0 && (object2 = com.tencent.liteav.b.a.b((a)this.a).g) != null && (n10 = (int)(((String)(object2 = com.tencent.liteav.b.a.b((a)this.a).g)).isEmpty() ? 1 : 0)) == 0 && (n10 = (int)(g.a((String)(object2 = com.tencent.liteav.b.a.b((a)this.a).f), (String)(object3 = com.tencent.liteav.b.a.b((a)this.a).g)) ? 1 : 0)) == 0) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("saveVideoThumb error. sourcePath = ");
                            object3 = com.tencent.liteav.b.a.b((a)this.a).f;
                            ((StringBuilder)object2).append((String)object3);
                            ((StringBuilder)object2).append(", coverImagePath = ");
                            object3 = com.tencent.liteav.b.a.b((a)this.a).g;
                            ((StringBuilder)object2).append((String)object3);
                            object2 = ((StringBuilder)object2).toString();
                            TXCLog.e(string2, (String)object2);
                        }
                        if ((n10 = ((Message)object).arg1) != 0) {
                            object3 = this.a;
                            object3 = com.tencent.liteav.b.a.b((a)object3);
                            object3 = ((a$a)object3).f;
                            object2 = new File((String)object3);
                            boolean bl2 = ((File)object2).exists();
                            if (!bl2) break block13;
                            try {
                                ((File)object2).delete();
                            }
                            catch (Exception exception) {
                                object3 = "delete file failed.";
                                TXCLog.e(string2, (String)object3, exception);
                            }
                        }
                    }
                    object2 = com.tencent.liteav.b.a.a(this.a);
                    n11 = ((Message)object).arg1;
                    object = (String)((Message)object).obj;
                    object3 = com.tencent.liteav.b.a.b((a)this.a).f;
                    String string3 = com.tencent.liteav.b.a.b((a)this.a).g;
                    object2.a(n11, (String)object, (String)object3, string3);
                }
            } else {
                object2 = com.tencent.liteav.b.a.a(this.a);
                object = (Long)((Message)object).obj;
                long l10 = (Long)object;
                object2.a(l10);
            }
        }
    }
}

