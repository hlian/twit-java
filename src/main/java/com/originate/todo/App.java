package com.originate.todo;

import org.sql2o.*;

import ro.pippo.core.Pippo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Pippo pippo = new Pippo(new Application());
		pippo.start();
	}
	/*
	Sql2o sql;
	public App() {
		sql = new Sql2o("jdbc:sqlite:temp.db", null, null);
		try (Connection conn = sql.open()) {
			Integer i = conn.createQuery("select count(*) from sqlite_master where type = 'table' and name = 'tweets'").executeScalar(Integer.class);
			if (i == 0) {
				conn.createQuery("create table tweets (id integer, tweet string)").executeUpdate();
			}
		}
	}
    
	private void go() {
		Pippo pippo = new Pippo();
		pippo.GET("/", (routeContext) -> { 
			try (Connection conn = sql.open()) {
			  routeContext.send("Hello World!" + conn.createQuery("select count(id) from tweets").executeScalar(Integer.class).toString());
			}
		});
		pippo.start();
        } */
}
