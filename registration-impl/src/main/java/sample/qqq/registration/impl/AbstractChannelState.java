package sample.qqq.registration.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;
import sample.cargotracker.registration.api.Cargo;
import sample.cargotracker.registration.impl.CargoState;

import java.time.LocalDateTime;

/**
 * The state for the cargo entity.
 */
@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = CargoState.class)
public interface AbstractChannelState {


    @Value.Parameter
     Cargo getCargo();

    @Value.Parameter
     LocalDateTime getTimestamp();
}
