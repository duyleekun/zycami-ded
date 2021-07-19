/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import java.util.List;

public class TrackListBean {
    private List trackList;

    public TrackListBean(List list) {
        this.trackList = list;
    }

    public List getTrackList() {
        return this.trackList;
    }

    public void setTrackList(List list) {
        this.trackList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackEditorConfigData{, pointsName=");
        List list = this.trackList;
        stringBuilder.append(list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

