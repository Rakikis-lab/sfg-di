package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
The @Primary annotation tells Spring to use this bean when there is a choice of which to inject.  The @Qualifier
annotation does have precedence over this, however.
 */
@Primary
@Service
public class PrimaryGreetingServiceImpl implements GreetingService {
        @Override
        public String sayGreeting() {
            return "Hello World - Primary";
        }
}
