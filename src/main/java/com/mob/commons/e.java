/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.ResHelper;
import java.io.File;

public class e {
    public static final Object a;

    static {
        Object object;
        a = object = new Object();
    }

    public static File a(String object) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            Context context = MobSDK.getContext();
            object = ResHelper.getDataCacheFile(context, (String)object);
            return object;
        }
    }

    public static boolean a(File file, LockAction lockAction) {
        return e.a(file, true, lockAction);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(File object, boolean bl2, LockAction lockAction) {
        try {
            Object object2 = ((File)object).getParentFile();
            boolean bl3 = ((File)object2).exists();
            if (!bl3) {
                object2 = ((File)object).getParentFile();
                ((File)object2).mkdirs();
            }
            if (!(bl3 = ((File)object).exists())) {
                ((File)object).createNewFile();
            }
            object = ((File)object).getAbsolutePath();
            object2 = e.b((String)object);
            synchronized (object2) {
                FileLocker fileLocker = new FileLocker();
                fileLocker.setLockFile((String)object);
                boolean bl4 = fileLocker.lock(bl2);
                if (!bl4) return false;
                bl4 = lockAction.run(fileLocker);
                if (bl4) return true;
                fileLocker.release();
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
            return true;
        }
        return true;
    }

    private static String b(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            String string3 = "comm/locks/.dhlock";
            boolean bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.mrlock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.rc_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.artc_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.lesd_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.dic_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.pkgs_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.pkg_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.ss_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.im_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.mph_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.gm_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.cz_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.du_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.bs_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.dy_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.at_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.bt_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.bts_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
            string3 = "comm/locks/.dvcv_lock";
            bl3 = string2.endsWith(string3);
            if (bl3) {
                return string3;
            }
        }
        return string2;
    }
}

