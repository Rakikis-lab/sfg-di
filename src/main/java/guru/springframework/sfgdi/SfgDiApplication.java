package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        /*
        An ApplicationContext allows us to access the Spring components as beans.  However, this returns them as type
        java.lang.Object so we need to cast them to the correct class before we use them.
         */
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        /*
        Note that we haven't used the "new" command to instantiate an object of this type.  Instead Spring has found it
        from the @Component annotation (a subset of @Component) and instantiated it for us using the default no args
        constructor.
         */
        MyController myController = (MyController) ctx.getBean("myController");

        String greeting = myController.sayHello();

        System.out.println(greeting);
    }

}
