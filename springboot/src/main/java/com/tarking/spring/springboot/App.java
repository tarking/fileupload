package com.tarking.spring.springboot;

import com.tarking.spring.springboot.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tuojinguo on 2018/2/26.
 * 1、SpringBootApplication等于@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
 */

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class App {

    /*@Bean
    public Runnable createRunnale(){
        return () -> {
            System.out.println("Spring boot is run");
        };
    }

    public static void main(String[] args) {
        //1.使用静态方法
        //ConfigurableApplicationContext context = SpringApplication.run(App.class,args);

        //2.使用构造函数
        ConfigurableApplicationContext context = new SpringApplication(App.class).run(args);

        context.getBean(Runnable.class).run();
        System.out.println(context.getBean(User.class));
        //根据名称获取
        System.out.println(context.getBean("createList"));
        //根据类型获取，如果同类型的有多个，则不能根据类型获取
        //NoUniqueBeanDefinitionException: No qualifying bean of type [java.util.List] is defined: expected single matching bean but found 2: createList,updateList
        //System.out.println(context.getBean(List.class));
        System.out.println(context.getBean("updateList"));
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                //-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }

    @Bean
    CommandLineRunner init(final StorageService storageService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                storageService.deleteAll();
                storageService.init();
            }
        };
    }
}
