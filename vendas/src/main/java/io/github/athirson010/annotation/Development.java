package io.github.athirson010.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Profile("development")
public @interface Development {
    //Essa é uma classe de Anotação para o profile de development, é possivel adicionar somente em classes
}
