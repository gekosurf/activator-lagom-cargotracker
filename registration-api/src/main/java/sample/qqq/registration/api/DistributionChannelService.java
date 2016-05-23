package sample.qqq.registration.api;

import akka.Done;
import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;
import org.pcollections.PSequence;

import static com.lightbend.lagom.javadsl.api.Service.*;

/**
 * Created by craigknell on 23/05/2016.
 */
public interface DistributionChannelService extends Service {

    /**
     * Example: curl -H "Content-Type: application/json" -X POST -d
     * '{
     * "cargo": {
     * "id": 1,
     * "name": "laptop",
     * "description": "macbook",
     * "owner": "Clark Kent",
     * "destination": "Metropolis"
     * }
     * }' http://localhost:9000/api/distributionChannel
     */
    ServiceCall<NotUsed, sample.qqq.registration.api.Channel, Done> register();

    ServiceCall<NotUsed, NotUsed, Source<sample.qqq.registration.api.Channel, ?>> getLiveRegistrations();

    ServiceCall<NotUsed, NotUsed, PSequence<sample.qqq.registration.api.Channel>> getAllRegistrations();

    ServiceCall<String, NotUsed, sample.qqq.registration.api.Channel> getRegistration();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return
                named("distributionChannelService").with(
                restCall(Method.POST, "/api/distributionChannel", register()),
                pathCall("/api/distributionChannel/live", getLiveRegistrations()),
                restCall(Method.GET, "/api/distributionChannel/all", getAllRegistrations()),
                restCall(Method.GET, "/api/distributionChannel/:id", getRegistration())
        ).withAutoAcl(true);
        // @formatter:on
    }
}
