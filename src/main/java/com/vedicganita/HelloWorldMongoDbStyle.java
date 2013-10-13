package com.vedicganita;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HelloWorldMongoDbStyle {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		MongoClient	client = new MongoClient(new ServerAddress("localhost", 27017));
		 DB database = client.getDB("blog");
		DBCollection collection = database.getCollection("test");
		DBObject object = collection.findOne();
		System.out.println(object);
	}

}
