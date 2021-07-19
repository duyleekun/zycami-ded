/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$AndroidVersion;
import cn.leancloud.Messages$AndroidVersion$Builder;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$DeviceType;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$LoginCommand;
import cn.leancloud.Messages$LoginCommand$Builder;
import cn.leancloud.Messages$SemanticVersion;
import cn.leancloud.Messages$SemanticVersion$Builder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfo$Builder;
import cn.leancloud.Messages$SystemInfoOrBuilder;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.im.SystemReporter$SystemInfo;

public class LoginPacket
extends CommandPacket {
    private SystemReporter$SystemInfo systemInfo = null;

    public LoginPacket() {
        this.setCmd("login");
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$CommandType.login;
        messages$GenericCommand$Builder.setCmd((Messages$CommandType)object);
        object = this.systemInfo;
        if (object != null) {
            object = Messages$LoginCommand.newBuilder();
            Messages$SystemInfoOrBuilder messages$SystemInfoOrBuilder = Messages$SystemInfo.newBuilder();
            boolean bl2 = this.systemInfo.isRunOnEmulator();
            Object object2 = messages$SystemInfoOrBuilder.setIsEmulator(bl2);
            Object object3 = Messages$DeviceType.android;
            ((Messages$SystemInfo$Builder)object2).setDeviceType((Messages$DeviceType)object3);
            object2 = Messages$AndroidVersion.newBuilder();
            int n10 = this.systemInfo.getOsAPILevel();
            object3 = String.valueOf(n10);
            object2 = ((Messages$AndroidVersion$Builder)object2).setApiLevel((String)object3);
            object3 = this.systemInfo.getOsCodeName();
            object2 = ((Messages$AndroidVersion$Builder)object2).setCodename((String)object3);
            messages$SystemInfoOrBuilder.setAndroidVersion((Messages$AndroidVersion$Builder)object2);
            object2 = new StringBuilder();
            object3 = this.systemInfo.getManufacturer();
            ((StringBuilder)object2).append((String)object3);
            object3 = "/";
            ((StringBuilder)object2).append((String)object3);
            String string2 = this.systemInfo.getBrand();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append((String)object3);
            object3 = this.systemInfo.getModel();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object3 = Messages$SemanticVersion.newBuilder();
            object2 = ((Messages$SemanticVersion$Builder)object3).setBuild((String)object2).build();
            messages$SystemInfoOrBuilder.setOsVersion((Messages$SemanticVersion)object2);
            messages$SystemInfoOrBuilder = messages$SystemInfoOrBuilder.build();
            ((Messages$LoginCommand$Builder)object).setSystemInfo((Messages$SystemInfo)messages$SystemInfoOrBuilder);
            messages$GenericCommand$Builder.setLoginMessage((Messages$LoginCommand$Builder)object);
        }
        return messages$GenericCommand$Builder;
    }

    public void setSystemInfo(SystemReporter$SystemInfo systemReporter$SystemInfo) {
        this.systemInfo = systemReporter$SystemInfo;
    }
}

