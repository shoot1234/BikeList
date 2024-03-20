package jp.co.planaria.sample.motocatalog.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class EventLogFilter {
  
  @Before("execution(* jp.co.planaria.sample.motocatalog..*Controller.*(..))")//AOPのアノテーション
  public void beforeLog(JoinPoint joinPoint) {
    //Controllerのメソッド呼び出しに前処理として実行される
    log.info(String.format("%s START", joinPoint.toShortString()));
  }

  @After("execution(* jp.co.planaria.sample.motocatalog..*Controller.*(..))")
  public void afterLog(JoinPoint joinPoint) {
    //Controllerのメソッド呼び出しに後処理として実行される
    log.info(String.format("%s END", joinPoint.toShortString()));
  }
}
