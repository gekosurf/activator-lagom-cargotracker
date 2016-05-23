package sample.qqq.registration.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.lightbend.lagom.javadsl.persistence.AggregateEvent;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.serialization.Jsonable;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;
import sample.cargotracker.registration.api.Cargo;

/**
 * This interface defines all the events that the Cargo entity supports.
 *
 * By convention, the events should be inner classes of the interface, which makes it simple to get a
 * complete picture of what events an entity has.
 */
public interface DistributionChannelEvent extends Jsonable , AggregateEvent<DistributionChannelEvent> {

    /**
     * An event that represents a new cargo registration                                .
     */
    @Immutable
    @ImmutableStyle
    @JsonDeserialize(as = sample.cargotracker.registration.impl.CargoRegistered.class)
    interface AbstractCargoRegistered extends DistributionChannelEvent {

        @Override
        default public AggregateEventTag<DistributionChannelEvent> aggregateTag() {
            return DistributionChannelEventTag.INSTANCE;
        }


        @Value.Parameter
        String getId();

        @Value.Parameter
        Cargo getCargo();
    }
}
