package ps.exalt.training.serverpool.models;

import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 * Represents an application which is to be allocated on a server.
 */
public class ApplicationEntity {

    @Id
    private Integer id;
    @NotBlank(message = "You must specify the name.")
    private String name;
    @NotNull(message = "You must specify the storage.")
//    @Positive(message = "Storage should be greater than zero.")
    @Max(value = 100, message = "Storage cannot be more than 100GB")
    private Integer storage;
    private Integer serverId;
    @NotNull (message = "You must specify the dBtype.")
    private DbType dbType;

//    public ApplicationEntity(
//        @NotBlank(message = "You must specify the name.") String name,
//        @NotNull(message = "You must specify the storage.") @Positive(message = "Storage should be greater than zero.") @Max(value = 100, message = "Storage cannot be more than 100GB") Integer storage,
//        @NotNull(message = "You must specify the dBtype.") DbType dbType) {
//        this.name = name;
//        this.storage = storage;
//        this.dbType = dbType;
//    }

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    //endregion


    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", storage=" + storage +
                ", serverId=" + serverId +
                ", dbType=" + dbType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationEntity that = (ApplicationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(storage, that.storage) &&
                Objects.equals(serverId, that.serverId) &&
                dbType == that.dbType;
    }
}
