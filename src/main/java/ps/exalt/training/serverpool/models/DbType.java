package ps.exalt.training.serverpool.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
