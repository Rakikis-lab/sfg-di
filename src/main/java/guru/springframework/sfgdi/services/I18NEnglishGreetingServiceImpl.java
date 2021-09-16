package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/*
The @Profile annotation assigns this bean to the specified profile, the active profile is set with the
spring.profiles.active property in the resources/application.properties.
If no profile is active Spring will ignore the @Profile annotations and load all beans into the context which can cause
issue where Spring is not able to determine which bean to inject.  If a profile is active then only beans with that
profile (or no profile) will be loaded into the context for the injection to choose from.
 */
@Profile("EN")
//Here we label the service to allow a @Qualifier annotation to choose between a subset of the possible beans.
@Service("i18nService")
public class I18NEnglishGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
