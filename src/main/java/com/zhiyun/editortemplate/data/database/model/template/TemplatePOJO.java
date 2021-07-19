/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template;

import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.j.e.f.c.b.a;
import d.v.j.e.f.c.b.b;
import d.v.j.e.f.c.b.c;
import d.v.j.e.f.c.b.d;
import d.v.j.e.f.c.b.e;
import d.v.j.e.f.c.b.f;
import d.v.j.e.f.c.b.h;
import d.v.j.e.f.c.b.i;
import d.v.j.e.f.c.b.j;
import d.v.j.g.d0.g;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TemplatePOJO
implements g {
    private Draft draft;
    private DownloadEvent mDownloadEvent;
    private TemplateData mTemplateData;
    private Script script;
    private List scriptTrackPOJOList;
    private Template template;
    private TemplateGlobal templateGlobal;
    private List templateMusicList;
    private List templateRecordingList;
    private List templateStickerList;
    private List templateVideoList;
    private Withdraw withdraw;

    public TemplatePOJO() {
    }

    public TemplatePOJO(TemplateData templateData) {
        this.mTemplateData = templateData;
    }

    public TemplatePOJO(TemplateData templateData, Draft draft, Withdraw withdraw, Template template, Script script, TemplateGlobal templateGlobal, List list, List list2, List list3, List list4) {
        this.mTemplateData = templateData;
        this.template = template;
        this.script = script;
        this.draft = draft;
        this.withdraw = withdraw;
        this.templateGlobal = templateGlobal;
        this.templateVideoList = list;
        this.templateStickerList = list2;
        this.templateMusicList = list3;
        this.scriptTrackPOJOList = list4;
    }

    public TemplatePOJO(TemplateData templateData, Template template) {
        this.mTemplateData = templateData;
        this.template = template;
    }

    public TemplatePOJO(TemplateData templateData, Template template, Draft draft, Withdraw withdraw, Script script, TemplateGlobal templateGlobal) {
        this.mTemplateData = templateData;
        this.template = template;
        this.draft = draft;
        this.withdraw = withdraw;
        this.script = script;
        this.templateGlobal = templateGlobal;
    }

    public TemplatePOJO(TemplateData templateData, Script script) {
        this.mTemplateData = templateData;
        this.script = script;
    }

    private /* synthetic */ void a(TemplatePOJO object, List collector) {
        object = ((TemplatePOJO)object).templateVideoList.stream();
        collector = a.a;
        object = object.map(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.setTemplateVideoList((List)object);
    }

    private /* synthetic */ void c(TemplatePOJO object, List collector) {
        object = ((TemplatePOJO)object).templateStickerList.stream();
        collector = b.a;
        object = object.map(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.setTemplateStickerList((List)object);
    }

    private /* synthetic */ void e(TemplatePOJO object, List collector) {
        object = ((TemplatePOJO)object).templateMusicList.stream();
        collector = h.a;
        object = object.map(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.setTemplateMusicList((List)object);
    }

    private /* synthetic */ void g(TemplatePOJO object, List collector) {
        object = ((TemplatePOJO)object).templateRecordingList.stream();
        collector = i.a;
        object = object.map(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.setTemplateRecordingList((List)object);
    }

    private /* synthetic */ void i(TemplatePOJO object, List collector) {
        object = ((TemplatePOJO)object).scriptTrackPOJOList.stream();
        collector = j.a;
        object = object.map(collector);
        collector = Collectors.toList();
        object = object.collect(collector);
        this.setScriptTrackPOJOList((List)object);
    }

    public /* synthetic */ void b(TemplatePOJO templatePOJO, List list) {
        this.a(templatePOJO, list);
    }

    public TemplatePOJO clone() {
        return this.cloneObject().cloneTemplateIndex(this).cloneTemplateConfig(this).cloneTemplateTrackConfig(this);
    }

    public TemplatePOJO cloneObject() {
        TemplatePOJO templatePOJO = new TemplatePOJO();
        TemplateData templateData = this.mTemplateData.clone();
        templatePOJO.setTemplateData(templateData);
        return templatePOJO;
    }

    public TemplatePOJO cloneTemplateConfig(TemplatePOJO templatePOJO) {
        Object object = templatePOJO.templateGlobal;
        object = object == null ? null : ((TemplateGlobal)object).clone();
        this.setTemplateGlobal((TemplateGlobal)object);
        object = Optional.ofNullable(templatePOJO.templateVideoList);
        Consumer consumer = new f(this, templatePOJO);
        ((Optional)object).ifPresent(consumer);
        object = Optional.ofNullable(templatePOJO.templateStickerList);
        consumer = new c(this, templatePOJO);
        ((Optional)object).ifPresent(consumer);
        object = Optional.ofNullable(templatePOJO.templateMusicList);
        consumer = new d(this, templatePOJO);
        ((Optional)object).ifPresent(consumer);
        object = Optional.ofNullable(templatePOJO.templateRecordingList);
        consumer = new e(this, templatePOJO);
        ((Optional)object).ifPresent(consumer);
        return this;
    }

    public TemplatePOJO cloneTemplateIndex(TemplatePOJO object) {
        Object object2 = ((TemplatePOJO)object).draft;
        Template template = null;
        object2 = object2 == null ? null : ((Draft)object2).clone();
        this.setDraft((Draft)object2);
        object2 = ((TemplatePOJO)object).withdraw;
        object2 = object2 == null ? null : ((Withdraw)object2).clone();
        this.setWithdraw((Withdraw)object2);
        object2 = ((TemplatePOJO)object).script;
        object2 = object2 == null ? null : ((Script)object2).clone();
        this.setScript((Script)object2);
        object = ((TemplatePOJO)object).template;
        if (object != null) {
            template = ((Template)object).clone();
        }
        this.setTemplate(template);
        return this;
    }

    public TemplatePOJO cloneTemplateTrackConfig(TemplatePOJO templatePOJO) {
        Optional<List> optional = Optional.ofNullable(templatePOJO.scriptTrackPOJOList);
        d.v.j.e.f.c.b.g g10 = new d.v.j.e.f.c.b.g(this, templatePOJO);
        optional.ifPresent(g10);
        return this;
    }

    public /* synthetic */ void d(TemplatePOJO templatePOJO, List list) {
        this.c(templatePOJO, list);
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
            object = (TemplatePOJO)object;
            object3 = this.mTemplateData;
            object2 = ((TemplatePOJO)object).mTemplateData;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.template, object2 = ((TemplatePOJO)object).template)) && (bl4 = Objects.equals(object3 = this.script, object2 = ((TemplatePOJO)object).script)) && (bl4 = Objects.equals(object3 = this.draft, object2 = ((TemplatePOJO)object).draft)) && (bl4 = Objects.equals(object3 = this.withdraw, object2 = ((TemplatePOJO)object).withdraw)) && (bl4 = Objects.equals(object3 = this.templateGlobal, object2 = ((TemplatePOJO)object).templateGlobal)) && (bl4 = Objects.equals(object3 = this.templateVideoList, object2 = ((TemplatePOJO)object).templateVideoList)) && (bl4 = Objects.equals(object3 = this.templateStickerList, object2 = ((TemplatePOJO)object).templateStickerList)) && (bl4 = Objects.equals(object3 = this.templateMusicList, object2 = ((TemplatePOJO)object).templateMusicList)) && (bl4 = Objects.equals(object3 = this.templateRecordingList, object2 = ((TemplatePOJO)object).templateRecordingList)) && (bl4 = Objects.equals(object3 = this.scriptTrackPOJOList, object2 = ((TemplatePOJO)object).scriptTrackPOJOList)) && (bl3 = Objects.equals(object3 = this.mDownloadEvent, object = ((TemplatePOJO)object).mDownloadEvent)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public /* synthetic */ void f(TemplatePOJO templatePOJO, List list) {
        this.e(templatePOJO, list);
    }

    public DownloadEvent getDownloadEvent() {
        return this.mDownloadEvent;
    }

    public Draft getDraft() {
        return this.draft;
    }

    public Script getScript() {
        return this.script;
    }

    public List getScriptTrackPOJOList() {
        return this.scriptTrackPOJOList;
    }

    public Template getTemplate() {
        return this.template;
    }

    public TemplateData getTemplateData() {
        return this.mTemplateData;
    }

    public TemplateGlobal getTemplateGlobal() {
        return this.templateGlobal;
    }

    public List getTemplateMusicList() {
        return this.templateMusicList;
    }

    public List getTemplateRecordingList() {
        return this.templateRecordingList;
    }

    public List getTemplateStickerList() {
        return this.templateStickerList;
    }

    public List getTemplateVideoList() {
        return this.templateVideoList;
    }

    public Withdraw getWithdraw() {
        return this.withdraw;
    }

    public /* synthetic */ void h(TemplatePOJO templatePOJO, List list) {
        this.g(templatePOJO, list);
    }

    public int hashCode() {
        Object object = this.mTemplateData;
        object = this.template;
        object = this.script;
        object = this.draft;
        object = this.withdraw;
        object = this.templateGlobal;
        object = this.templateVideoList;
        object = this.templateStickerList;
        object = this.templateMusicList;
        object = this.templateRecordingList;
        object = this.scriptTrackPOJOList;
        object = this.mDownloadEvent;
        Object[] objectArray = new Object[]{object, object, object, object, object, object, object, object, object, object, object, object};
        return Objects.hash(objectArray);
    }

    public /* synthetic */ void j(TemplatePOJO templatePOJO, List list) {
        this.i(templatePOJO, list);
    }

    public void setDownloadEvent(DownloadEvent downloadEvent) {
        this.mDownloadEvent = downloadEvent;
    }

    public void setDraft(Draft draft) {
        this.draft = draft;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public void setScriptTrackPOJOList(List list) {
        this.scriptTrackPOJOList = list;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public void setTemplateData(TemplateData templateData) {
        this.mTemplateData = templateData;
    }

    public void setTemplateGlobal(TemplateGlobal templateGlobal) {
        this.templateGlobal = templateGlobal;
    }

    public void setTemplateMusicList(List list) {
        this.templateMusicList = list;
    }

    public void setTemplateRecordingList(List list) {
        this.templateRecordingList = list;
    }

    public void setTemplateStickerList(List list) {
        this.templateStickerList = list;
    }

    public void setTemplateVideoList(List list) {
        this.templateVideoList = list;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplatePOJO{mTemplateData=");
        Object object = this.mTemplateData;
        stringBuilder.append(object);
        stringBuilder.append(", template=");
        object = this.template;
        stringBuilder.append(object);
        stringBuilder.append(", script=");
        object = this.script;
        stringBuilder.append(object);
        stringBuilder.append(", draft=");
        object = this.draft;
        stringBuilder.append(object);
        stringBuilder.append(", withdraw=");
        object = this.withdraw;
        stringBuilder.append(object);
        stringBuilder.append(", templateGlobal=");
        object = this.templateGlobal;
        stringBuilder.append(object);
        stringBuilder.append(", templateVideoList=");
        object = this.templateVideoList;
        stringBuilder.append(object);
        stringBuilder.append(", templateStickerList=");
        object = this.templateStickerList;
        stringBuilder.append(object);
        stringBuilder.append(", templateMusicList=");
        object = this.templateMusicList;
        stringBuilder.append(object);
        stringBuilder.append(", templateRecordingList=");
        object = this.templateRecordingList;
        stringBuilder.append(object);
        stringBuilder.append(", scriptTrackPOJOList=");
        object = this.scriptTrackPOJOList;
        stringBuilder.append(object);
        stringBuilder.append(", mDownloadEvent=");
        object = this.mDownloadEvent;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

