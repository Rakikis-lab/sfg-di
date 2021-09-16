package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    /*
    The @Autowired annotation tells the Spring context that this variable (or what ever it is applied to) should be
    autowired (automatically instantiated) by Spring's dependency injection facilities.  It will require a @Component or
    a subset of a @Component of that type to be declared so the context knows what can be injected into it.
     */
    @Autowired
    @Qualifier("propertyGreetingServiceImpl")
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
