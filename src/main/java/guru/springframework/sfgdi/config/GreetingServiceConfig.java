package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
The @Configuration annotation indicates that this class contains some configuration methods which show how to configure
beans for use in the Spring context.
 */
@Configuration
public class GreetingServiceConfig {
    /*
    The @Bean annotation shows that the method will return a configured bean for use in the Spring context.  This is
    not typically done with your own code - with annotations being preferred, but more done with third party libraries.
    Where we want to bring them into the Spring context, as we don't own the code we cannot annotate it, but we can
    declare parts of it as beans.
    It is possible to supply a name for the bean with a tag (see @Bean source for examples) however by default it will
    take the method name as its own.  Note we don't just have to instantly return the beans we can configure them
    however we want prior to returning.
    When configuring a bean we can use the @Primary and @Profile annotations on the method returning the bean in
    exactly the same way as we would on the class if we were using the annotations "normally".
     */
    @Bean
    ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }
}
