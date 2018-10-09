package ru.degtyar.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private ExpressionParser parser = new SpelExpressionParser();
    private Expression exp = parser.parseExpression("'LogAspect'");

    @Before("execution(* ru.degtyar.springboot..*(..))")
    public void loggingBefore(JoinPoint joinPoint) {
        System.out.println(exp.getValue() + " Before execution of point : " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("Before execution of method : " + joinPoint.getSignature().getName());
    }
}
