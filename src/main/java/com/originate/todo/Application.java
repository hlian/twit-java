package com.originate.todo;

import java.util.*;
import org.sql2o.*;

class Application extends ro.pippo.core.Application {
    Sql2o sql;
    Application() {
        sql = new Sql2o("jdbc:sqlite:twit.sqlite", null, null);
    }

    @Override
    protected void onInit() {
        scheme();

		GET("/", routeContext -> {
            HashMap<String, Object> map = new HashMap<>();
            try (Connection conn = sql.open()) {
                List<Tweet> tweets = conn.createQuery("SELECT id, tweet FROM tweets ORDER BY id DESC").executeAndFetch(Tweet.class);
                map.put("tweets", tweets);
            }
            routeContext.render("home", map);
        });

        POST("/api/tweets", routeContext -> {
            String tweet = routeContext.getParameter("tweet").toString();
            assert tweet != null;
            try (Connection conn = sql.open()) {
                conn.createQuery("INSERT INTO tweets VALUES (null, :tweet)").addParameter("tweet", imgify(tweet)).executeUpdate();
            }
            routeContext.redirect("/");
        });
	}

    private void scheme() {
        try (Connection conn = sql.open()) {
			Integer i = conn.createQuery("select count(*) from sqlite_master where type = 'table' and name = 'tweets'").executeScalar(Integer.class);
            if (i == 0) {
                conn.createQuery("create table tweets (id integer primary key, tweet string);").executeUpdate();
            }
        }
    }

    /**
     * @param raw The tweet in question
     * @return The tweet, but with image URLs as <img> tags
     */
    private String imgify(String raw) {
        // TODO
        return raw;
    }

    // https://s-media-cache-ak0.pinimg.com/originals/da/b4/8e/dab48eacb31d8e38ecf9f433af7db5a5.gif
    // http://24.media.tumblr.com/5f6067b3b3bf9f2019294ea52fbd8b0b/tumblr_myyrcmoMBN1s5bh5uo1_500.gif
}
