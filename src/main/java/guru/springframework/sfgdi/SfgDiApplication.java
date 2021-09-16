package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
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

        System.out.println("---------- Primary");
        System.out.println(myController.sayHello());

        System.out.println("---------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
