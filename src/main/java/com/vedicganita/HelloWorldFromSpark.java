package com.vedicganita;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldFromSpark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Some Text as an Object shows Up";
			}
		});

	}

}
