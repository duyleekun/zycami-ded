/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.types.AVGeoPoint;
import java.util.Map;

public class AVIMLocationMessage
extends AVIMTypedMessage {
    public Map attrs;
    public AVGeoPoint location;
    public String text;

    public Map getAttrs() {
        return this.attrs;
    }

    public AVGeoPoint getLocation() {
        return this.location;
    }

    public String getText() {
        return this.text;
    }

    public void setAttrs(Map map) {
        this.attrs = map;
    }

    public void setLocation(AVGeoPoint aVGeoPoint) {
        this.location = aVGeoPoint;
    }

    public void setText(String string2) {
        this.text = string2;
    }
}

