package sample.qqq.registration.impl;

import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;

/**
 * Register a common event tag
 */
public class DistributionChannelEventTag {

    public static final AggregateEventTag<DistributionChannelEvent> INSTANCE =
            AggregateEventTag.of(DistributionChannelEvent.class);

}
