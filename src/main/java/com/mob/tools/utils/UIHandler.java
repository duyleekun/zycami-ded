/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Base64
 */
package com.mob.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.UIHandler$1;
import com.mob.tools.utils.UIHandler$InnerObj;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Random;

public class UIHandler {
    private static Handler handler;

    public static /* synthetic */ void access$000(Message message) {
        UIHandler.handleMessage(message);
    }

    private static Message getShellMessage(int n10, Handler.Callback callback) {
        Message message = new Message();
        message.what = n10;
        return UIHandler.getShellMessage(message, callback);
    }

    private static Message getShellMessage(Message message, Handler.Callback callback) {
        Message message2 = new Message();
        UIHandler$InnerObj uIHandler$InnerObj = new UIHandler$InnerObj(message, callback);
        message2.obj = uIHandler$InnerObj;
        return message2;
    }

    private static void handleMessage(Message object) {
        object = (UIHandler$InnerObj)object.obj;
        Message message = object.msg;
        object = object.callback;
        if (object != null) {
            object.handleMessage(message);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void prepare() {
        Class<UIHandler> clazz = UIHandler.class;
        synchronized (clazz) {
            Handler handler = UIHandler.handler;
            if (handler == null) {
                UIHandler.reset();
                UIHandler.printPray();
            }
            return;
        }
    }

    private static void printPray() {
        Object object = "MAAlDCUQMAAwADAAJQwlEAAKJQwlGCUUJQAlACUAJRglFCUQAAolAjAAMAAwADAAMAAwADAAJQIACiUCMAAwADAAJQAwADAAMAAlAgAKJQIwACUsJRgwACUUJSwwACUCAAolAjAAMAAwADAAMAAwADAAJQIACiUCMAAwADAAJTQwADAAMAAlAgAKJQIwADAAMAAwADAAMAAwACUCAAolFCUAJRAwADAAMAAlDCUAJRgACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlAgAKMAAwACUCMAAwADAAJQIwADAAMAAwAABDAG8AZABlACAAaQBzACAAZgBhAHIAIABhAHcAYQB5ACAAZgByAG8AbQAgAGIAdQBnACAAdwBpAHQAaAAgAHQAaABlACAAYQBuAGkAbQBhAGwAIABwAHIAbwB0AGUAYwB0AGkAbgBnAAowADAAJQIwADAAMAAlAjAAMAAwADAAeV5RfU/dT1H/DE7jeAFl4ABCAFUARwAKMAAwACUCMAAwADAAJQIACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlFCUAJQAlACUQAAowADAAJQIwADAAMAAwADAAMAAwACUcJRAACjAAMAAlAjAAMAAwADAAMAAwADAAJRwlGAAKMAAwACUUJRAlECUMJQAlLCUQJQwlGAAKMAAwADAAJQIlJCUkMAAlAiUkJSQACjAAMAAwACUUJRglGDAAJRQlGCUY";
        Object object2 = "MAAlDCUQMAAwADAAJQwlEAAKJQwlGCUUJQAlACUAJRglFCUQAAolAjAAMAAwADAAMAAwADAAJQIACiUCMAAwADAAJQAwADAAMAAlAgAKJQIwAP8eMAAwADAA/xwwACUCAAolAjAAMAAwADAAMAAwADAAJQIACiUCMAAgJjAA/z4wACAmMAAlAgAKJQIwADAAMAAwADAAMAAwACUCAAolFCUAJRAwADAAMAAlDCUAJRgACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlAgAKMAAwACUCMAAwADAAJQIwADAAMAAwAABDAG8AZABlACAAaQBzACAAZgBhAHIAIABhAHcAYQB5ACAAZgByAG8AbQAgAGIAdQBnACAAdwBpAHQAaAAgAHQAaABlACAAYQBuAGkAbQBhAGwAIABwAHIAbwB0AGUAYwB0AGkAbgBnAAowADAAJQIwADAAMAAlAjAAMAAwADAAeV5RfU/dT1H/DE7jeAFl4ABCAFUARwAKMAAwACUCMAAwADAAJQIACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlFCUAJQAlACUQAAowADAAJQIwADAAMAAwADAAMAAwACUcJRAACjAAMAAlAjAAMAAwADAAMAAwADAAJRwlGAAKMAAwACUUJRAlECUMJQAlLCUQJQwlGAAKMAAwADAAJQIlJCUkMAAlAiUkJSQACjAAMAAwACUUJRglGDAAJRQlGCUY";
        CharSequence charSequence = "MAAlDCUQMAAwADAAJQwlEP8LMAD/CwAKJQwlGCUUJQAlACUAJRglFCUQMAD/CzAA/wsACiUCMAAwADAAMAAwADAAMAAlAgAKJQIwADAAMAAlADAAMAAwACUCMAD/C/8LMAD/CzAA/wswAP8LAAolAiWIJYgliCAVJYgliCWIJQIwAP8LAAolAjAAMAAwADAAMAAwADAAJQIwAP8LAAolAjAAMAAwACU0MAAwADAAJQIACiUCMAAwADAAMAAwADAAMAAlAjAA/wswAP8LAAolFCUAJRAwADAAMAAlDCUAJRgACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlAjAA/wswAP8LMAD/CzAA/wsACjAAMAAlAjAAMAAwACUCAAowADAAJQIwADAAMAAlAjAA/wswADAAAEMAbwBkAGUAIABpAHMAIABmAGEAcgAgAGEAdwBhAHkAIABmAHIAbwBtACAAYgB1AGcAIAB3AGkAdABoACAAdABoAGUAIABhAG4AaQBtAGEAbAAgAHAAcgBvAHQAZQBjAHQAaQBuAGcACjAAMAAlAjAAMAAwACUCMAAwADAAMAB5XlF9T91PUf8MTuN4AWXgAEIAVQBHAAowADAAJQIwADAAMAAlAjAAMAD/CwAKMAAwACUCMAAwADAAJRQlACUAJQAlEDAA/wswAP8LAAowADAAJQIwADAAMAAwADAAMAAwACUcJRAACjAAMAAlAjAAMAAwADAAMAAwADAAJRwlGAAKMAAwACUUJRAlECUMJQAlLCUQJQwlGDAA/wswAP8LMAD/CzAA/wsACjAAMAAwACUCJSQlJDAAJQIlJCUkAAowADAAMAAlFCUYJRgwACUUJRglGDAA/wswAP8LMAD/CzAA/ws=";
        object = new String[]{object, object2, charSequence};
        object2 = new Random();
        int n10 = ((Random)object2).nextInt();
        n10 = Math.abs(n10);
        n10 %= 3;
        object = object[n10];
        n10 = 2;
        object = Base64.decode((String)object, (int)n10);
        object = ByteBuffer.wrap((byte[])object);
        object = ((ByteBuffer)object).asCharBuffer();
        object = ((CharBuffer)object).toString();
        object2 = MobLog.getInstance();
        charSequence = new StringBuilder();
        String string2 = "\n";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        charSequence = null;
        charSequence = new Object[]{};
        try {
            ((NLog)object2).d(object, (Object[])charSequence);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    private static void reset() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        UIHandler$1 uIHandler$1 = new UIHandler$1();
        UIHandler.handler = handler = new Handler(looper, (Handler.Callback)uIHandler$1);
    }

    public static boolean sendEmptyMessage(int n10, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        Message message = UIHandler.getShellMessage(n10, callback);
        return handler.sendMessage(message);
    }

    public static boolean sendEmptyMessageAtTime(int n10, long l10, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        Message message = UIHandler.getShellMessage(n10, callback);
        return handler.sendMessageAtTime(message, l10);
    }

    public static boolean sendEmptyMessageDelayed(int n10, long l10, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        Message message = UIHandler.getShellMessage(n10, callback);
        return handler.sendMessageDelayed(message, l10);
    }

    public static boolean sendMessage(Message message, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        message = UIHandler.getShellMessage(message, callback);
        return handler.sendMessage(message);
    }

    public static boolean sendMessageAtFrontOfQueue(Message message, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        message = UIHandler.getShellMessage(message, callback);
        return handler.sendMessageAtFrontOfQueue(message);
    }

    public static boolean sendMessageAtTime(Message message, long l10, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        message = UIHandler.getShellMessage(message, callback);
        return handler.sendMessageAtTime(message, l10);
    }

    public static boolean sendMessageDelayed(Message message, long l10, Handler.Callback callback) {
        UIHandler.prepare();
        Handler handler = UIHandler.handler;
        message = UIHandler.getShellMessage(message, callback);
        return handler.sendMessageDelayed(message, l10);
    }
}

