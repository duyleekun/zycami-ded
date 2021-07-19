/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapFactory
 */
package com.zhiyun.renderengine.business.display;

import android.graphics.BitmapFactory;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.c.e.c$a;
import d.v.b0.c.e.d;
import d.v.b0.j.b;
import java.io.IOException;
import java.io.InputStream;

public class DisplayRender$e
extends d {
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$e(DisplayRender displayRender) {
        this.b = displayRender;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable2222222;
        InputStream inputStream;
        block12: {
            inputStream = null;
            long l10 = System.currentTimeMillis();
            Object object = this.b;
            object = DisplayRender.u((DisplayRender)object);
            object = object.getResources();
            object = object.getAssets();
            Object object2 = this.a;
            object2 = ((c$a)object2).b;
            inputStream = object.open((String)object2);
            object = BitmapFactory.decodeStream((InputStream)inputStream);
            object2 = new StringBuilder();
            String string2 = "DisplayRender load bitmap costom: ";
            ((StringBuilder)object2).append(string2);
            long l11 = System.currentTimeMillis() - l10;
            {
                catch (Throwable throwable2222222) {
                    break block12;
                }
                catch (Exception exception) {}
                {
                    StringBuilder stringBuilder = new StringBuilder();
                    object = "DisplayRender businessLutRunnable open Assets exception:";
                    stringBuilder.append((String)object);
                    String string3 = exception.toString();
                    stringBuilder.append(string3);
                    string3 = stringBuilder.toString();
                    d.v.b0.j.b.b(string3);
                    if (inputStream == null) return;
                }
                try {}
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    return;
                }
                inputStream.close();
                return;
            }
            {
                ((StringBuilder)object2).append(l11);
                Object object3 = " ms";
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
                d.v.b0.j.b.c((String)object3);
                if (object != null) {
                    object3 = this.a;
                    ((c$a)object3).e = object;
                    object3 = this.b;
                    if ((object3 = DisplayRender.q((DisplayRender)object3)) != null) {
                        object3 = this.b;
                        object3 = DisplayRender.v((DisplayRender)object3);
                        Object object4 = this.a;
                        ((d)object3).a = object4;
                        object3 = this.b;
                        object3 = DisplayRender.q((DisplayRender)object3);
                        object4 = this.b;
                        object4 = DisplayRender.v((DisplayRender)object4);
                        object3.post((Runnable)object4);
                    }
                }
                if (inputStream == null) return;
            }
            {
                inputStream.close();
                return;
            }
        }
        if (inputStream == null) throw throwable2222222;
        try {
            inputStream.close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw throwable2222222;
    }
}

