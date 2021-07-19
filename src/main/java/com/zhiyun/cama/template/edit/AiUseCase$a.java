/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import androidx.core.util.Pair;
import com.zhiyun.cama.template.edit.AiUseCase;
import e.a.y0.e;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import m.a.a;

public class AiUseCase$a
extends e {
    public final /* synthetic */ BiConsumer b;
    public final /* synthetic */ Consumer c;
    public final /* synthetic */ AiUseCase d;

    public AiUseCase$a(AiUseCase aiUseCase, BiConsumer biConsumer, Consumer consumer) {
        this.d = aiUseCase;
        this.b = biConsumer;
        this.c = consumer;
    }

    public void b(Pair object) {
        BiConsumer biConsumer = this.b;
        if (biConsumer != null) {
            Object object2 = ((Pair)object).first;
            object = ((Pair)object).second;
            biConsumer.accept(object2, object);
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

