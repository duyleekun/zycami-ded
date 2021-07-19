/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import com.xiaomi.mipush.sdk.PushMessageHandler$a;
import java.util.ArrayList;
import java.util.List;

public class MiPushCommandMessage
implements PushMessageHandler$a {
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_COMMAND = "command";
    private static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
    private static final String KEY_REASON = "reason";
    private static final String KEY_RESULT_CODE = "resultCode";
    private static final long serialVersionUID = 1L;
    private String category;
    private String command;
    private List commandArguments;
    private String reason;
    private long resultCode;

    public static MiPushCommandMessage fromBundle(Bundle object) {
        long l10;
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        Object object2 = object.getString(KEY_COMMAND);
        miPushCommandMessage.command = object2;
        miPushCommandMessage.resultCode = l10 = object.getLong(KEY_RESULT_CODE);
        object2 = object.getString(KEY_REASON);
        miPushCommandMessage.reason = object2;
        miPushCommandMessage.commandArguments = object2 = object.getStringArrayList(KEY_COMMAND_ARGUMENTS);
        object = object.getString(KEY_CATEGORY);
        miPushCommandMessage.category = object;
        return miPushCommandMessage;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public List getCommandArguments() {
        return this.commandArguments;
    }

    public String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setCategory(String string2) {
        this.category = string2;
    }

    public void setCommand(String string2) {
        this.command = string2;
    }

    public void setCommandArguments(List list) {
        this.commandArguments = list;
    }

    public void setReason(String string2) {
        this.reason = string2;
    }

    public void setResultCode(long l10) {
        this.resultCode = l10;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Object object = this.command;
        bundle.putString(KEY_COMMAND, (String)object);
        long l10 = this.resultCode;
        String string2 = KEY_RESULT_CODE;
        bundle.putLong(string2, l10);
        object = this.reason;
        String string3 = KEY_REASON;
        bundle.putString(string3, (String)object);
        object = this.commandArguments;
        if (object != null) {
            object = (ArrayList)object;
            string3 = KEY_COMMAND_ARGUMENTS;
            bundle.putStringArrayList(string3, (ArrayList)object);
        }
        object = this.category;
        bundle.putString(KEY_CATEGORY, (String)object);
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("command={");
        Object object = this.command;
        stringBuilder.append((String)object);
        stringBuilder.append("}, resultCode={");
        long l10 = this.resultCode;
        stringBuilder.append(l10);
        stringBuilder.append("}, reason={");
        object = this.reason;
        stringBuilder.append((String)object);
        stringBuilder.append("}, category={");
        object = this.category;
        stringBuilder.append((String)object);
        stringBuilder.append("}, commandArguments={");
        object = this.commandArguments;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

