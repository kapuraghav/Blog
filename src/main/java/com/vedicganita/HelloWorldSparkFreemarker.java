package com.vedicganita;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


public class HelloWorldSparkFreemarker {

	public static void main(String[] args) throws IOException {
	Configuration cfg = new Configuration();
	final Template template = cfg.getTemplate("Template/template.ftl");
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> helomap = new HashMap <String, Object>();
				helomap.put("name", "Raghav");
				helomap.put("message", "Hello World");
					List<String> countries = new ArrayList();
					countries.add("India");
					countries.add("paksitan");
					countries.add("shri lanka");
				helomap.put("countries", countries);
				StringWriter out = new StringWriter();
				try {
					template.process(helomap, out);
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return out;
			}
		});
	
	}

}
