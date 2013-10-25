package com.vedicganita;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarkerStyle {
	public static void main(String[] args) throws TemplateException {
		Configuration cfg = new Configuration();
		try {
			Template template = cfg.getTemplate("Resource/some.ftl");
			Template template1 = cfg.getTemplate("Template/template.ftl");
			Map<String, Object> helomap = new HashMap <String, Object>();
			helomap.put("name", "Raghav");
			helomap.put("message", "Hello World");
				List<String> countries = new ArrayList();
				countries.add("India");
				countries.add("paksitan");
				countries.add("Nepal");
			helomap.put("countries", countries);
			StringWriter out = new StringWriter();
			StringWriter out1 = new StringWriter();
			template.process(helomap, out);
			template1.process(helomap, out1);
			System.out.print(out);
			System.out.print(out1);
			out.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
