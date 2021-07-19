/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Commands$1;
import com.mob.tools.java8.Commands$When$1;
import com.mob.tools.java8.Commands$When$2;
import com.mob.tools.java8.Commands$When$3;
import com.mob.tools.java8.Commands$When$4;
import com.mob.tools.java8.Commands$When$5;
import com.mob.tools.java8.Commands$When$6;
import com.mob.tools.java8.Commands$When$7;
import com.mob.tools.java8.Commands$When$8;
import com.mob.tools.java8.Commands$When$9;
import com.mob.tools.java8.Commands$When$Then;
import com.mob.tools.java8.Commands$When$WhenCondition;
import com.mob.tools.java8.MapFlow$MapItem;
import java.util.Iterator;
import java.util.LinkedList;

public class Commands$When {
    private LinkedList cases;
    private Object target;

    private Commands$When(Object linkedList) {
        this.target = linkedList;
        this.cases = linkedList = new LinkedList();
    }

    public /* synthetic */ Commands$When(Object object, Commands$1 commands$1) {
        this(object);
    }

    private void evaluate(Commands$When$Then commands$When$Then) {
        boolean bl2;
        Iterator iterator2 = this.cases.iterator();
        while (bl2 = iterator2.hasNext()) {
            MapFlow$MapItem mapFlow$MapItem = (MapFlow$MapItem)iterator2.next();
            Commands$When$WhenCondition commands$When$WhenCondition = (Commands$When$WhenCondition)mapFlow$MapItem.key;
            Object object = this.target;
            boolean bl3 = commands$When$WhenCondition.when(object);
            if (!bl3) continue;
            ((Commands$When$Then)mapFlow$MapItem.value).then();
            return;
        }
        if (commands$When$Then != null) {
            commands$When$Then.then();
        }
    }

    public void evaluate() {
        this.evaluate(null);
    }

    public Commands$When is(Object object, Commands$When$Then commands$When$Then) {
        Commands$When$2 commands$When$2 = new Commands$When$2(this, object);
        return this.meetCondition(commands$When$2, commands$When$Then);
    }

    public Commands$When isGreaterThan(double d10, Commands$When$Then commands$When$Then) {
        Commands$When$8 commands$When$8 = new Commands$When$8(this, d10);
        return this.meetCondition(commands$When$8, commands$When$Then);
    }

    public Commands$When isInRange(double d10, double d11, Commands$When$Then commands$When$Then) {
        Commands$When$6 commands$When$6 = new Commands$When$6(this, d10, d11);
        return this.meetCondition(commands$When$6, commands$When$Then);
    }

    public Commands$When isInstanceOf(Class clazz, Commands$When$Then commands$When$Then) {
        Commands$When$4 commands$When$4 = new Commands$When$4(this, clazz);
        return this.meetCondition(commands$When$4, commands$When$Then);
    }

    public Commands$When isLessThan(double d10, Commands$When$Then commands$When$Then) {
        Commands$When$9 commands$When$9 = new Commands$When$9(this, d10);
        return this.meetCondition(commands$When$9, commands$When$Then);
    }

    public Commands$When isNot(Object object, Commands$When$Then commands$When$Then) {
        Commands$When$3 commands$When$3 = new Commands$When$3(this, object);
        return this.meetCondition(commands$When$3, commands$When$Then);
    }

    public Commands$When isNotInRage(double d10, double d11, Commands$When$Then commands$When$Then) {
        Commands$When$7 commands$When$7 = new Commands$When$7(this, d10, d11);
        return this.meetCondition(commands$When$7, commands$When$Then);
    }

    public Commands$When isNotInstanceOf(Class clazz, Commands$When$Then commands$When$Then) {
        Commands$When$5 commands$When$5 = new Commands$When$5(this, clazz);
        return this.meetCondition(commands$When$5, commands$When$Then);
    }

    public Commands$When isNotNull(Commands$When$Then commands$When$Then) {
        return this.isNot(null, commands$When$Then);
    }

    public Commands$When isNull(Commands$When$Then commands$When$Then) {
        return this.is(null, commands$When$Then);
    }

    public Commands$When meetCondition(Commands$When$WhenCondition object, Commands$When$Then commands$When$Then) {
        LinkedList linkedList = this.cases;
        object = MapFlow$MapItem.of(object, commands$When$Then);
        linkedList.add(object);
        return this;
    }

    public Commands$When meetCondition(boolean bl2, Commands$When$Then commands$When$Then) {
        Commands$When$1 commands$When$1 = new Commands$When$1(this, bl2);
        return this.meetCondition(commands$When$1, commands$When$Then);
    }

    public void orElse(Commands$When$Then commands$When$Then) {
        this.evaluate(commands$When$Then);
    }
}

