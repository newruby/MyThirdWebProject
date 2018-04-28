package com.ty.model;

/**
 * creted by TY on 2018/4/27.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
* @Component 等价于<bean id = 'strudent' class = "...Student">
*/

@Component("sb")
class Student{  //调用者？？
    void say(){
        System.out.println("student");
    }
}

@Component("p")
class Person{

    @Resource(name = "sb")
    private Student student;

    void say(){
        this.student.say();
    }
}


class AtInterfaceTest {
    public static  void  main(String[] args){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("ss.xml");
        Person p = (Person) ctx.getBean("p");
        p.say();
    }
}
