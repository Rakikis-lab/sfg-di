package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

//Removed the @Service annotation to demonstrate Java based configuration with the @Configuration annotation.
public class ConstructorGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
