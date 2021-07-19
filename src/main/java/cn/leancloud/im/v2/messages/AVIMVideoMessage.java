/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVFile;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import cn.leancloud.im.v2.messages.AVIMFileMessageAccessor;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.AVUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AVIMVideoMessage
extends AVIMFileMessage {
    public AVIMVideoMessage() {
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMVideoMessage(AVFile aVFile) {
        super(aVFile);
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMVideoMessage(File file) {
        super(file);
        this.setHasAdditionalMetaAttr(true);
    }

    public AVIMVideoMessage(String string2) {
        super(string2);
        this.setHasAdditionalMetaAttr(true);
    }

    public double getDuration() {
        String string2;
        boolean bl2;
        Map map = this.getFileMetaData();
        if (map != null && (bl2 = map.containsKey(string2 = "duration"))) {
            return ((Number)map.get(string2)).doubleValue();
        }
        return 0.0;
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
            object = AVIMFileMessageAccessor.mediaInfo(object);
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

    public String getQueryName() {
        return "?avinfo";
    }

    public void parseAdditionalMetaData(Map map, JSONObject serializable) {
        String string2;
        if (map != null && serializable != null && (serializable = serializable.getJSONObject(string2 = "format")) != null) {
            boolean bl2;
            Object object = "format_name";
            int n10 = serializable.containsKey(object);
            if (n10 != 0) {
                object = serializable.getString((String)object);
                map.put(string2, object);
            }
            if (bl2 = serializable.containsKey(string2 = "duration")) {
                object = serializable.getDouble(string2);
                n10 = 2;
                double d10 = AVUtils.normalize2Double(n10, (Double)object);
                object = d10;
                map.put(string2, object);
            }
            if (bl2 = serializable.containsKey(string2 = "size")) {
                long l10 = serializable.getLong(string2);
                serializable = Long.valueOf(l10);
                map.put(string2, serializable);
            }
        }
    }
}

