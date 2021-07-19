/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package cn.leancloud.push;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.codec.Base64Encoder;
import cn.leancloud.json.JSON;
import cn.leancloud.push.NotifyUtil$1;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class NotifyUtil {
    private static AVLogger LOGGER;
    public static final int SERVICE_RESTART = 1024;
    public static final String SERVICE_RESTART_ACTION = "com.avos.avoscloud.notify.action";
    public static Handler notifyHandler;
    public static HandlerThread thread;

    static {
        Object object;
        LOGGER = LogUtil.getLogger(NotifyUtil.class);
        thread = object = new HandlerThread("com.avos.avoscloud.notify");
        object.start();
        Looper looper = thread.getLooper();
        object = new NotifyUtil$1(looper);
        notifyHandler = object;
    }

    public static /* synthetic */ Set access$000() {
        return NotifyUtil.getRegisteredApps();
    }

    public static /* synthetic */ AVLogger access$100() {
        return LOGGER;
    }

    public static /* synthetic */ void access$200() {
        NotifyUtil.registerApp();
    }

    private static File getRegisterAppsFile() {
        Object object = new StringBuilder();
        Object object2 = Environment.getExternalStorageDirectory();
        ((StringBuilder)object).append(object2);
        object2 = "/Android/data/leancloud/";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        CharSequence charSequence = "dontpanic.cp";
        File file = new File((String)object, (String)charSequence);
        boolean bl2 = file.exists();
        if (bl2) {
            return file;
        }
        charSequence = new StringBuilder();
        File file2 = Environment.getExternalStorageDirectory();
        ((StringBuilder)charSequence).append(file2);
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ((StringBuilder)charSequence).toString();
        object = new File((String)object2);
        ((File)object).mkdirs();
        return file;
    }

    private static Set getRegisteredApps() {
        Object object;
        Object object2 = AVOSCloud.getContext();
        if (object2 == null) {
            return null;
        }
        object2 = NotifyUtil.getRegisterAppsFile();
        HashSet hashSet = new HashSet();
        boolean bl2 = ((File)object2).exists();
        if (bl2 && !(bl2 = StringUtil.isEmpty((String)(object2 = ((PersistenceUtil)(object = PersistenceUtil.sharedInstance())).readContentFromFile((File)object2))))) {
            object = Set.class;
            object2 = JSON.parseObject((String)object2, (Class)object);
            object2 = (Collection)object2;
            try {
                hashSet.addAll(object2);
            }
            catch (Exception exception) {
                object = LOGGER;
                String string2 = "getRegisteredApps";
                ((AVLogger)object).e(string2, exception);
            }
        }
        return hashSet;
    }

    private static void registerApp() {
        Object object;
        Object object2 = NotifyUtil.getRegisteredApps();
        if (object2 != null && (object = AVOSCloud.getContext()) != null) {
            object = Base64Encoder.encode(AVOSCloud.getContext().getPackageName());
            object2.add(object);
            object = PersistenceUtil.sharedInstance();
            object2 = JSON.toJSONString(object2);
            File file = NotifyUtil.getRegisterAppsFile();
            ((PersistenceUtil)object).saveContentToFile((String)object2, file);
        }
    }
}

