/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVFile;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import cn.leancloud.im.v2.messages.AVIMFileMessageAccessor;
import cn.leancloud.json.JSONObject;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AVIMImageMessage
extends AVIMFileMessage {
    public static final String IMAGE_HEIGHT = "height";
    public static final String IMAGE_WIDTH = "width";

    public AVIMImageMessage() {
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMImageMessage(AVFile aVFile) {
        super(aVFile);
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMImageMessage(File file) {
        super(file);
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMImageMessage(String string2) {
        super(string2);
        this.setHasAdditionalMetaAttr(true);
    }

    private static int parseIntValue(Object object) {
        if (object != null) {
            boolean bl2 = object instanceof Integer;
            if (!bl2 && !(bl2 = object instanceof Long)) {
                bl2 = object instanceof Double;
                if (bl2) {
                    return (int)((Double)object).doubleValue();
                }
                bl2 = object instanceof BigDecimal;
                if (bl2) {
                    return ((BigDecimal)object).intValue();
                }
            } else {
                return (Integer)object;
            }
        }
        return 0;
    }

    public Map getFileMetaData() {
        String string2;
        boolean bl2;
        Object object = this.file;
        if (object == null) {
            object = new HashMap();
            this.file = object;
        }
        if (bl2 = (object = this.file).containsKey(string2 = "metaData")) {
            return (Map)this.file.get(string2);
        }
        object = this.localFile;
        if (object != null) {
            object = AVIMFileMessageAccessor.getImageMeta(object);
            Long l10 = this.localFile.length();
            object.put("size", l10);
            this.file.put(string2, object);
            return object;
        }
        object = this.actualFile;
        if (object != null) {
            object = ((AVFile)object).getMetaData();
            this.file.put(string2, object);
            return object;
        }
        return null;
    }

    public int getHeight() {
        String string2;
        boolean bl2;
        Map map = this.getFileMetaData();
        if (map != null && (bl2 = map.containsKey(string2 = IMAGE_HEIGHT))) {
            return AVIMImageMessage.parseIntValue(map.get(string2));
        }
        return 0;
    }

    public String getQueryName() {
        return "?imageInfo";
    }

    public int getWidth() {
        String string2;
        boolean bl2;
        Map map = this.getFileMetaData();
        if (map != null && (bl2 = map.containsKey(string2 = IMAGE_WIDTH))) {
            return AVIMImageMessage.parseIntValue(map.get(string2));
        }
        return 0;
    }

    public void parseAdditionalMetaData(Map map, JSONObject serializable) {
        if (map != null && serializable != null) {
            Object object;
            String string2 = "format";
            boolean bl2 = serializable.containsKey(string2);
            if (bl2) {
                object = serializable.getString(string2);
                map.put(string2, object);
            }
            if (bl2 = serializable.containsKey(string2 = IMAGE_HEIGHT)) {
                object = serializable.getInteger(string2);
                map.put(string2, object);
            }
            if (bl2 = serializable.containsKey(string2 = IMAGE_WIDTH)) {
                serializable = serializable.getInteger(string2);
                map.put(string2, serializable);
            }
        }
    }
}

