/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.story.track;

import com.zhiyun.cama.camera.story.track.TrackDescriptionBean$Description;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean$IconBean;

public class TrackDescriptionBean {
    private Description description;
    private TrackDescriptionBean$IconBean icon;
    private String name;
    private int trackId;
    private String trackName;

    public Description getDescription() {
        return this.description;
    }

    public TrackDescriptionBean$IconBean getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public String getTrackName() {
        return this.trackName;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setIcon(TrackDescriptionBean$IconBean trackDescriptionBean$IconBean) {
        this.icon = trackDescriptionBean$IconBean;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setTrackId(int n10) {
        this.trackId = n10;
    }

    public void setTrackName(String string2) {
        this.trackName = string2;
    }
}

