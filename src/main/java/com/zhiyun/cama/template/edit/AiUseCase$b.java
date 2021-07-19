/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import com.zhiyun.cama.template.edit.AiUseCase;
import e.a.y0.e;
import java.util.List;
import java.util.function.Consumer;
import m.a.a;

public class AiUseCase$b
extends e {
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ Consumer c;
    public final /* synthetic */ AiUseCase d;

    public AiUseCase$b(AiUseCase aiUseCase, Consumer consumer, Consumer consumer2) {
        this.d = aiUseCase;
        this.b = consumer;
        this.c = consumer2;
    }

    public void b(List list) {
        Consumer consumer = this.b;
        if (consumer != null) {
            consumer.accept(list);
        }
    }

    public void onError(Throwable throwable) {
        m.a.a.j(throwable);
        Consumer consumer = this.c;
        if (consumer != null) {
            consumer.accept(throwable);
        }
    }
}

