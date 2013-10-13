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
		cfg.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
		try {
			Template template = cfg.getTemplate("/some.ftl");
			Map<String, Object> helomap = new HashMap <String, Object>();
			helomap.put("name", "Raghav");
//				List<String> countries = new ArrayList();
//				countries.add("India");
//				countries.add("paksitan");
//				countries.add("Nepal");
//			helomap.put("countries", countries);
			StringWriter out = new StringWriter();
			template.process(helomap, out);
			out.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
