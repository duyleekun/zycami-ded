/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectResp
implements IMessageEntity {
    public List protocolVersion;
    public String sessionId;

    public ConnectResp() {
        Integer n10;
        int n11 = 2;
        Integer[] integerArray = new Integer[n11];
        int n12 = 1;
        integerArray[0] = n10 = Integer.valueOf(n12);
        Object object = n11;
        integerArray[n12] = object;
        this.protocolVersion = object = Arrays.asList(integerArray);
    }

    public String toString() {
        char c10;
        StringBuilder stringBuilder = new StringBuilder("protocol version:");
        Iterator iterator2 = this.protocolVersion.iterator();
        while ((c10 = iterator2.hasNext()) != '\u0000') {
            Integer n10 = (Integer)iterator2.next();
            stringBuilder.append(n10);
            c10 = ',';
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }
}

