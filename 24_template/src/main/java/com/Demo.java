package com;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("static/template.html");

        VelocityContext context = new VelocityContext();
        context.put("name", "ZZAX");

        StringWriter writer = new StringWriter();
        template.merge( context, writer );

        System.out.println(writer.toString());
    }
}
