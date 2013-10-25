package com.vedicganita;

import java.io.IOException;
import java.io.StringWriter;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.gridfs.GridFS;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AllOfThemTogether {

	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		final Template template = cfg.getTemplate("Template/template.ftl");
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		final DB database = client.getDB("blog");
		final DBCollection collection = database.getCollection("test");
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter out = new StringWriter();
				DBObject mongoObject = collection.findOne();
				try {
					template.process(mongoObject, out);
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
