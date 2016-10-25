package com.originate.todo;

import ro.pippo.core.Pippo;

class App {
    public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Pippo pippo = new Pippo(new Application());
        pippo.addPublicResourceRoute();
		pippo.start();
	}
}
