package com.rolan.examples.spel;

import com.rolan.examples.spel.collections.RefDataBean;
import com.rolan.examples.spel.expressions.SimpleBean;
import com.rolan.examples.spel.inject.Author;
import com.rolan.examples.spel.operators.Operators;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class App {

    private ApplicationContext context;

    public App(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        App app = new App(new ClassPathXmlApplicationContext("applicationContext.xml"));
        app.beanReference();
        app.operatorsExample();
        app.collectionsExample();
        app.expressionParserExample();
    }

    public void beanReference() {
        Author author = context.getBean("authorBean", Author.class);
        System.out.println("-------- Simple beans reference example ------------------");
        System.out.println(author);
    }

    public void operatorsExample() {
        Operators operators = context.getBean("operatorsBean", Operators.class);
        System.out.println("-------- Operators example ----------------");
        System.out.println(operators);
    }

    public void collectionsExample() {
        RefDataBean refDataBean = context.getBean("refDataBean", RefDataBean.class);
        System.out.println("-------- Collections example ----------------");
        System.out.println(refDataBean);
    }

    public void expressionParserExample() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello world'");
        String value = expression.getValue(String.class);
        System.out.println("-------- Expression example ----------------");
        System.out.println("Simple text: " + value);

        Expression ex2 = parser.parseExpression("100 * 2");
        int msg3 = (Integer) ex2.getValue();
        System.out.println("100 * 2: " + msg3);

        SimpleBean simple = context.getBean("simpleBean", SimpleBean.class);
        StandardEvaluationContext context = new StandardEvaluationContext(simple);
        Expression ex3 = parser.parseExpression("email");
        String emailValue = ex3.getValue(context, String.class);
        System.out.println("Email from simple bean: " + emailValue);


    }
}
