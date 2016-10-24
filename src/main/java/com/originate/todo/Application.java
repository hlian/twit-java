package com.originate.todo;

import java.util.ArrayList;
import java.util.HashMap;

public class Application extends ro.pippo.core.Application {
    @Override
    protected void onInit() {
        HashMap<String, Object> h = new HashMap<String, Object>() {{
                ArrayList<String> tweets = new ArrayList<String>() {{
                        add("oh my");
                }};
                put("tweets", tweets);
        }};
		GET("/", (routeContext) -> routeContext.render("home", h));
	}
}
