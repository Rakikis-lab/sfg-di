package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
The @Configuration annotation indicates that this class contains some configuration methods which show how to configure
beans for use in the Spring context.
 */
@Configuration
/*
The @PropertySource annotation brings in a properties file.  With Spring the resources folder is added to the classpath
so this path style takes advantage of that.
 */
@PropertySource("classpath:datasource.properties")
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

    @Bean
    /*
    The @Value annotation allows us to get a property from one of the properties files included in the class with the
    @PropertySource annotation.  It will then apply it to the variable that follows.  Note the use of the ${} that
    surrounds the property name.  This is necessary otherwise the variables will be set to the contents of the String
    rather than having the String evaluated and the property returned.
    The @Value annotation will also pick up environment variables with the same name as the property but with the "."
    replaced with a "_", for example "GURU_USERNAME" although it isn't case-sensitive.
    It will also pick up command line arguments with the same name proceeded by "--", for example "--guru.password".
    The order that properties are set is:
      From a file
      From the environment
      From the command line
    With entries further down this list overwriting entries from higher up with the same name.
     */
    FakeDataSource fakeDataSource(@Value("${guru.userName}") String userName,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcUrl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);

        return fakeDataSource;
    }
}
