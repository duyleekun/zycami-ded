/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import d.v.j.e.f.c.c.a;
import d.v.j.e.f.c.c.b;
import d.v.j.e.f.c.c.c;
import d.v.j.e.f.c.c.d;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ScriptTrackPOJO {
    private ScriptTrack scriptTrack;
    private List scriptTrackMetaDataList;
    private List scriptTrackPointList;

    public static /* synthetic */ void a(ScriptTrackPOJO scriptTrackPOJO, List object) {
        object = object.stream();
        Object object2 = a.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        scriptTrackPOJO.setScriptTrackPointList((List)object);
    }

    public static /* synthetic */ void b(ScriptTrackPOJO scriptTrackPOJO, List object) {
        object = object.stream();
        Object object2 = d.a;
        object = object.map(object2);
        object2 = Collectors.toList();
        object = (List)object.collect(object2);
        scriptTrackPOJO.setScriptTrackMetaDataList((List)object);
    }

    public ScriptTrackPOJO clone() {
        ScriptTrackPOJO scriptTrackPOJO = new ScriptTrackPOJO();
        ScriptTrack scriptTrack = this.scriptTrack;
        scriptTrack = scriptTrack == null ? null : scriptTrack.clone();
        Optional<List> optional = Optional.ofNullable(this.scriptTrackPointList);
        Consumer consumer = new b(scriptTrackPOJO);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(this.scriptTrackMetaDataList);
        consumer = new c(scriptTrackPOJO);
        optional.ifPresent(consumer);
        scriptTrackPOJO.setScriptTrack(scriptTrack);
        return scriptTrackPOJO;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ScriptTrackPOJO)object;
            object3 = this.scriptTrack;
            object2 = ((ScriptTrackPOJO)object).scriptTrack;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.scriptTrackPointList, object2 = ((ScriptTrackPOJO)object).scriptTrackPointList)) && (bl3 = Objects.equals(object3 = this.scriptTrackMetaDataList, object = ((ScriptTrackPOJO)object).scriptTrackMetaDataList)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ScriptTrack getScriptTrack() {
        return this.scriptTrack;
    }

    public List getScriptTrackMetaDataList() {
        return this.scriptTrackMetaDataList;
    }

    public List getScriptTrackPointList() {
        return this.scriptTrackPointList;
    }

    public int hashCode() {
        Object object = this.scriptTrack;
        object = this.scriptTrackPointList;
        object = this.scriptTrackMetaDataList;
        Object[] objectArray = new Object[]{object, object, object};
        return Objects.hash(objectArray);
    }

    public void setScriptTrack(ScriptTrack scriptTrack) {
        this.scriptTrack = scriptTrack;
    }

    public void setScriptTrackMetaDataList(List list) {
        this.scriptTrackMetaDataList = list;
    }

    public void setScriptTrackPointList(List list) {
        this.scriptTrackPointList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptTrackPOJO{scriptTrack=");
        Object object = this.scriptTrack;
        stringBuilder.append(object);
        stringBuilder.append(", scriptTrackPointList=");
        object = this.scriptTrackPointList;
        stringBuilder.append(object);
        stringBuilder.append(", scriptTrackMetaDataList=");
        object = this.scriptTrackMetaDataList;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

