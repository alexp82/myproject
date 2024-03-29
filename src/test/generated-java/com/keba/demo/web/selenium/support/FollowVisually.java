/*
 * (c) Copyright 2005-2014 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/FollowVisually.p.vm.java
 */
package com.keba.demo.web.selenium.support;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
@Documented
public @interface FollowVisually {
    public static enum FollowLevel {
        INFO, DEBUG, TRACE
    }

    long driverWaitBeforeStopInSeconds() default 5;

    long waitAfterClickInMs() default 250;

    long waitAfterClearInMs() default 250;

    long waitAfterStepInMs() default 1500;

    long waitAfterFillInMs() default 250;

    long waitAfterNotificationInMs() default 1000;

    FollowLevel level() default com.keba.demo.web.selenium.support.FollowVisually.FollowLevel.INFO;
}
