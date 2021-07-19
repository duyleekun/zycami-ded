/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 */
package cn.leancloud;

import android.content.Context;
import android.os.Handler;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud$1;
import cn.leancloud.AVOSCloud$2;
import cn.leancloud.AVOSCloud$3;
import cn.leancloud.cache.AndroidSystemSetting;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.core.AVOSCloud$REGION;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppConfiguration$SchedulerCreator;
import cn.leancloud.core.AppRouter;
import cn.leancloud.core.RequestPaddingInterceptor;
import cn.leancloud.core.RequestSignature;
import cn.leancloud.internal.ThreadModel$MainThreadChecker;
import cn.leancloud.internal.ThreadModel$ThreadShuttle;
import cn.leancloud.logging.DefaultLoggerAdapter;
import cn.leancloud.logging.InternalLoggerAdapter;
import cn.leancloud.network.AndroidNetworkingDetector;
import cn.leancloud.network.NetworkingDetector;
import cn.leancloud.sign.NativeSignHelper;
import cn.leancloud.sign.SecureRequestSignature;
import cn.leancloud.util.AndroidMimeTypeDetector;
import cn.leancloud.util.AndroidUtil;
import cn.leancloud.utils.FileUtil$MimeTypeDetector;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.lang.reflect.Method;

public class AVOSCloud
extends cn.leancloud.core.AVOSCloud {
    private static Context context;
    public static Handler handler;

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static boolean hasCustomizedServerURL(String object) {
        AVOSCloud$REGION aVOSCloud$REGION = AVOSCloud$REGION.NorthAmerica;
        if (aVOSCloud$REGION != (object = AppRouter.getAppRegion(object)) && aVOSCloud$REGION != (object = cn.leancloud.core.AVOSCloud.getRegion())) {
            return AppRouter.getInstance().hasFrozenEndpoint();
        }
        return true;
    }

    public static void initialize(Context context, String string2, String string3) {
        Context context2 = context;
        int n10 = AVOSCloud.hasCustomizedServerURL(string2);
        if (n10 != 0) {
            String string4;
            Object object = handler;
            if (object == null && (n10 = AndroidUtil.isMainThread()) == 0) {
                object = new IllegalStateException("Please call AVOSCloud#initialize() in main thread.");
                throw object;
            }
            object = handler;
            if (object == null) {
                object = new Handler();
                handler = object;
            }
            object = new DefaultLoggerAdapter();
            AppConfiguration.setLogAdapter((InternalLoggerAdapter)object);
            object = new AndroidNetworkingDetector(context2);
            AppConfiguration.setGlobalNetworkingDetector((NetworkingDetector)object);
            object = new AndroidMimeTypeDetector();
            AppConfiguration.setMimeTypeDetector((FileUtil$MimeTypeDetector)object);
            object = new AVOSCloud$1();
            Object object2 = new AVOSCloud$2();
            AVCallback.setMainThreadChecker((ThreadModel$MainThreadChecker)object, (ThreadModel$ThreadShuttle)object2);
            object2 = LogUtil.getLogger(AVOSCloud.class);
            object = "[LeanCloud] initialize mainThreadChecker and threadShuttle within AVCallback.";
            ((AVLogger)object2).i((String)object);
            n10 = StringUtil.isEmpty(string2);
            StringBuilder stringBuilder = null;
            if (n10 != 0) {
                object = "";
                string4 = string2;
            } else {
                n10 = 8;
                string4 = string2;
                object = string2.substring(0, n10);
            }
            Class[] classArray = context.getFilesDir().getAbsolutePath();
            Object[] objectArray = context.getCacheDir().getAbsolutePath();
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("Paas");
            object3 = ((StringBuilder)object3).toString();
            String string5 = context2.getDir((String)object3, 0).getAbsolutePath();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)objectArray);
            String string6 = "/";
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("avfile");
            String string7 = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)objectArray);
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("CommandCache");
            String string8 = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)objectArray);
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("Analysis");
            String string9 = ((StringBuilder)object3).toString();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)objectArray);
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("PaasKeyValueCache");
            String string10 = ((StringBuilder)object3).toString();
            object = new AndroidSystemSetting(context2);
            object3 = string5;
            string6 = string7;
            String string11 = string9;
            objectArray = string9;
            string9 = object;
            AppConfiguration.configCacheSettings((String)classArray, string5, string7, string10, string8, string11, (SystemSetting)object);
            AppConfiguration.setApplicationPackageName(context.getPackageName());
            object = new StringBuilder();
            ((StringBuilder)object).append("docDir=");
            ((StringBuilder)object).append(string5);
            ((StringBuilder)object).append(", fileDir=");
            ((StringBuilder)object).append(string7);
            ((StringBuilder)object).append(", cmdDir=");
            ((StringBuilder)object).append(string8);
            classArray = ", statDir=";
            ((StringBuilder)object).append((String)classArray);
            ((StringBuilder)object).append(string11);
            object = ((StringBuilder)object).toString();
            ((AVLogger)object2).d((String)object);
            object = new AVOSCloud$3();
            int n11 = 1;
            AppConfiguration.config(n11 != 0, (AppConfiguration$SchedulerCreator)object);
            cn.leancloud.core.AVOSCloud.initialize(string2, string3);
            object = context.getClassLoader();
            string4 = "cn.leancloud.im.AndroidInitializer";
            object = ((ClassLoader)object).loadClass(string4);
            string4 = "init";
            classArray = new Class[n11];
            object3 = Context.class;
            classArray[0] = object3;
            object = ((Class)object).getDeclaredMethod(string4, classArray);
            string4 = null;
            objectArray = new Object[n11];
            objectArray[0] = context2;
            ((Method)object).invoke(null, objectArray);
            object = "succeed to call cn.leancloud.im.AndroidInitializer#init(Context)";
            try {
                ((AVLogger)object2).d((String)object);
            }
            catch (Exception exception) {
                stringBuilder = new StringBuilder();
                string4 = "failed to call AndroidInitializer#init(Context), cause:";
                stringBuilder.append(string4);
                String string12 = exception.getMessage();
                stringBuilder.append(string12);
                string12 = stringBuilder.toString();
                ((AVLogger)object2).d(string12);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = "invalid AndroidInitializer, init(Context) method not found.";
                ((AVLogger)object2).d((String)object);
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = "not found class: cn.leancloud.im.AndroidInitializer.";
                ((AVLogger)object2).d((String)object);
            }
            AVOSCloud.setContext(context);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Please call AVOSCloud#initialize(context, appid, appkey, serverURL) instead of AVOSCloud#initialize(context, appid, appkey), or call AVOSCloud#setServer(service, host) at first.");
        throw illegalStateException;
    }

    public static void initialize(Context context, String string2, String string3, String string4) {
        cn.leancloud.core.AVOSCloud.setServerURLs(string4);
        AVOSCloud.initialize(context, string2, string3);
    }

    public static void initializeSecurely(Context context, String string2, String object) {
        cn.leancloud.core.AVOSCloud.setServerURLs((String)object);
        NativeSignHelper.initialize(context);
        object = new SecureRequestSignature();
        RequestPaddingInterceptor.changeRequestSignature((RequestSignature)object);
        AVOSCloud.initialize(context, string2, null);
    }

    public static void setContext(Context context) {
        AVOSCloud.context = context;
    }
}

