package db;

import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;
import org.neo4j.rest.graphdb.query.QueryEngine;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;
import org.neo4j.rest.graphdb.util.QueryResult;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class DbOperation {

    private String url;
    private String userName;
    private String password;

    public DbOperation() {
    }

    public DbOperation(String uri, String userName, String password) {
        this.url = uri;
        this.userName = userName;
        this.password = password;
    }

    public void getNodes() {
        RestAPI graphDb = new RestAPIFacade(url, userName, password);
        QueryEngine engine = new RestCypherQueryEngine(graphDb);

        QueryResult<Map<String, Object>> result = engine.query("start n=node(*) return count(n) as total", Collections.EMPTY_MAP);
        Iterator<Map<String, Object>> iterator = result.iterator();
        System.out.println("Querying");
        if (iterator.hasNext()) {
            Map<String, Object> node = iterator.next();
            // do something
        }
    }
}
