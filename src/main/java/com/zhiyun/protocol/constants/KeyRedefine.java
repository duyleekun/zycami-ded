/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import java.util.Arrays;

public class KeyRedefine {
    private int KeyValue;
    private int[] keyEvents;
    private int keyGroup;
    private int keyType;

    public int[] getKeyEvents() {
        return this.keyEvents;
    }

    public int getKeyGroup() {
        return this.keyGroup;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public int getKeyValue() {
        return this.KeyValue;
    }

    public void setKeyEvents(int ... nArray) {
        this.keyEvents = nArray;
    }

    public void setKeyGroup(int n10) {
        this.keyGroup = n10;
    }

    public void setKeyType(int n10) {
        this.keyType = n10;
    }

    public void setKeyValue(int n10) {
        this.KeyValue = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyRedefine{keyType=");
        int n10 = this.keyType;
        stringBuilder.append(n10);
        stringBuilder.append(", keyGroup=");
        n10 = this.keyGroup;
        stringBuilder.append(n10);
        stringBuilder.append(", KeyValue=");
        n10 = this.KeyValue;
        stringBuilder.append(n10);
        stringBuilder.append(", keyEvents=");
        String string2 = Arrays.toString(this.keyEvents);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

