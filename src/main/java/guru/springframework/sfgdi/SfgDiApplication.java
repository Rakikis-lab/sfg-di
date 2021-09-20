package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
The @SpringBootApplication annotation states that this class and the package it is in, are the top level of a Spring
Boot application, making the package this class is in a "base package".  This has implications for component scanning,
the scanner will look in base packages and the packages they contain.
The @ComponentScan annotation can be used to adjust this behaviour by adding in new base packages to scan.  This is done
as a comma seperated list of Strings inside a {}.  Note that when this is used, it doesn't add new base packages it SETS
them, so if you do not include the current package it will be removed!!  For example
@ComponentScan(basePackages = {"guru.springframework.sfgdi", "another.package", "yet.another.package"}
 */
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
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

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
