package com.vedicganita_week2;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class InsertTest {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient	client = new MongoClient(new ServerAddress("localhost", 27017));
		DB database = client.getDB("blog");
		DBCollection collection = database.getCollection("test");

	        DBObject doc = new BasicDBObject("name", "Andrew Erlichson")
	                .append("company", "10gen");

	        try {
	            collection.insert(doc);      // first insert
	            System.out.println(doc);
	            doc.removeField("_id");  // remove the "_id" field
	            System.out.println(doc);
	            collection.insert(doc);      // second insert
	            System.out.println(doc);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
