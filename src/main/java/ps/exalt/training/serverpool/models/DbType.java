package ps.exalt.training.serverpool.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of the database on which a given application is designed to operate.
 */
public enum DbType {
    SQL_SERVER("sql_server"),
    ORACLE("oracle"),
    MYSQL("mysql"),
    AEROSPIKE("aerospike"),
    MONGO("mongo");

    private String key;

    DbType(String key) {
        this.key = key;
    }

    @JsonCreator
    public static DbType fromString(String key) {
        return key == null
                ? null
                : DbType.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return key;
    }
}
