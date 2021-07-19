/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package cn.leancloud.im;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.leancloud.AVOSCloud;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.utils.StringUtil;
import java.io.Serializable;
import java.util.HashMap;

public class IntentUtil {
    public static final String CALLBACK_RESULT_KEY = "callbackHashMap";

    private static boolean isOperationValid(Conversation$AVIMOperation conversation$AVIMOperation) {
        int n10;
        Conversation$AVIMOperation conversation$AVIMOperation2;
        int n11;
        if (conversation$AVIMOperation != null && (n11 = (conversation$AVIMOperation2 = Conversation$AVIMOperation.CONVERSATION_UNKNOWN).getCode()) != (n10 = conversation$AVIMOperation.getCode())) {
            n10 = 1;
        } else {
            n10 = 0;
            conversation$AVIMOperation = null;
        }
        return n10 != 0;
    }

    public static void sendIMLocalBroadcast(String string2, String string3, int n10, Bundle bundle, Conversation$AVIMOperation conversation$AVIMOperation) {
        IntentUtil.sendIMLocalBroadcast(string2, string3, n10, bundle, null, conversation$AVIMOperation);
    }

    private static void sendIMLocalBroadcast(String object, String string2, int n10, Bundle bundle, Throwable throwable, Conversation$AVIMOperation object2) {
        boolean bl2 = IntentUtil.isOperationValid(object2);
        if (bl2) {
            object2 = object2.getOperation();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            Intent intent = new Intent(string3);
            string3 = "callbackclient";
            intent.putExtra(string3, (String)object);
            boolean bl3 = StringUtil.isEmpty(string2);
            if (!bl3) {
                object = "callbackconversation";
                intent.putExtra((String)object, string2);
            }
            if (throwable != null) {
                object = "callbackException";
                intent.putExtra((String)object, (Serializable)throwable);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if ((object = AVOSCloud.getContext()) != null) {
                object = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
                ((LocalBroadcastManager)object).sendBroadcast(intent);
            }
        }
    }

    public static void sendIMLocalBroadcast(String string2, String string3, int n10, Conversation$AVIMOperation conversation$AVIMOperation) {
        IntentUtil.sendIMLocalBroadcast(string2, string3, n10, null, null, conversation$AVIMOperation);
    }

    public static void sendIMLocalBroadcast(String string2, String string3, int n10, Throwable throwable, Conversation$AVIMOperation conversation$AVIMOperation) {
        IntentUtil.sendIMLocalBroadcast(string2, string3, n10, null, throwable, conversation$AVIMOperation);
    }

    public static void sendLiveQueryLocalBroadcast(int n10, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "live_query_";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        Object object = stringBuilder.toString();
        Intent intent = new Intent((String)object);
        if (throwable != null) {
            object = "callbackException";
            intent.putExtra((String)object, (Serializable)throwable);
        }
        if ((object = AVOSCloud.getContext()) != null) {
            object = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
            ((LocalBroadcastManager)object).sendBroadcast(intent);
        }
    }

    public static void sendMap2LocalBroadcase(String object, String string2, int n10, HashMap hashMap, Throwable throwable, Conversation$AVIMOperation object2) {
        boolean bl2 = IntentUtil.isOperationValid(object2);
        if (bl2) {
            object2 = object2.getOperation();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            Intent intent = new Intent(string3);
            string3 = "callbackclient";
            intent.putExtra(string3, (String)object);
            boolean bl3 = StringUtil.isEmpty(string2);
            if (!bl3) {
                object = "callbackconversation";
                intent.putExtra((String)object, string2);
            }
            if (throwable != null) {
                object = "callbackException";
                intent.putExtra((String)object, (Serializable)throwable);
            }
            if (hashMap != null) {
                object = CALLBACK_RESULT_KEY;
                intent.putExtra((String)object, (Serializable)hashMap);
            }
            if ((object = AVOSCloud.getContext()) != null) {
                object = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
                ((LocalBroadcastManager)object).sendBroadcast(intent);
            }
        }
    }

    public static Intent setupIntentFlags(Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 > n11) {
            n10 = 32;
            intent.setFlags(n10);
        }
        return intent;
    }
}

