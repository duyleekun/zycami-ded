/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package cn.leancloud.push;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.codec.Base64Decoder;
import cn.leancloud.push.NotifyUtil;
import cn.leancloud.push.PushService;

public final class NotifyUtil$1
extends Handler {
    public NotifyUtil$1(Looper looper) {
        super(looper);
    }

    /*
     * Loose catch block
     */
    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1024;
        if (n10 == n11 && (object = AVOSCloud.getContext()) != null) {
            this.removeMessages(n11);
            object = NotifyUtil.access$000();
            object = object.iterator();
            while (true) {
                n11 = (int)(object.hasNext() ? 1 : 0);
                if (n11 == 0) break;
                {
                    catch (Exception exception) {}
                }
                Object object2 = object.next();
                object2 = (String)object2;
                object2 = Base64Decoder.decode(object2);
                Object object3 = AVOSCloud.getContext();
                object3 = object3.getPackageName();
                boolean bl2 = ((String)object3).equals(object2);
                if (bl2) continue;
                object3 = new Intent();
                Object object4 = PushService.class;
                object4 = ((Class)object4).getName();
                object3.setClassName(object2, (String)object4);
                object4 = "com.avos.avoscloud.notify.action";
                object3.setAction((String)object4);
                object4 = NotifyUtil.access$100();
                CharSequence charSequence = new StringBuilder();
                String string2 = "try to start:";
                charSequence.append(string2);
                charSequence.append((String)object2);
                object2 = " from:";
                charSequence.append((String)object2);
                object2 = AVOSCloud.getContext();
                object2 = object2.getPackageName();
                charSequence.append((String)object2);
                object2 = charSequence.toString();
                ((AVLogger)object4).d((String)object2);
                object2 = AVOSCloud.getContext();
                try {
                    object2.startService((Intent)object3);
                    continue;
                }
                catch (Exception exception) {
                    object3 = NotifyUtil.access$100();
                    object4 = new StringBuilder();
                    charSequence = "failed to startService. cause: ";
                    ((StringBuilder)object4).append((String)charSequence);
                    object2 = exception.getMessage();
                    ((StringBuilder)object4).append((String)object2);
                    object2 = ((StringBuilder)object4).toString();
                    ((AVLogger)object3).e((String)object2);
                    continue;
                }
                break;
            }
            NotifyUtil.access$200();
        }
    }
}

