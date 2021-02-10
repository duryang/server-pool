package ps.exalt.training.serverpool.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a server in the server pool.
 */
public class ServerEntity {
    @Id
    private Integer id;
    private DbType dbType;
    private final Integer maxStorage = 100;
    private Integer usedStorage = 0;
    private Integer freeStorage = 100;
    private List<Long> applicationIds;

    public ServerEntity(DbType dbType) {
        this.dbType = dbType;
        this.applicationIds = new ArrayList<Long>();
    }

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public Integer getMaxStorage() {
        return maxStorage;
    }

    public Integer getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(Integer usedStorage) {
        this.usedStorage = usedStorage;
    }

    public Integer getFreeStorage() {
        return freeStorage;
    }

    public void setFreeStorage(Integer freeStorage) {
        this.freeStorage = freeStorage;
    }

    public List<Long> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(List<Long> applicationIds) {
        this.applicationIds = applicationIds;
    }

    // endregion

    @Override
    public String toString() {
        return "ServerEntity{" +
                "id=" + id +
                ", dbType=" + dbType +
                ", maxStorage=" + maxStorage +
                ", usedStorage=" + usedStorage +
                ", freeStorage=" + freeStorage +
                ", applicationIds=" + applicationIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerEntity that = (ServerEntity) o;
        return Objects.equals(id, that.id) &&
                dbType == that.dbType &&
                Objects.equals(maxStorage, that.maxStorage) &&
                Objects.equals(usedStorage, that.usedStorage) &&
                Objects.equals(freeStorage, that.freeStorage) &&
                Objects.equals(applicationIds, that.applicationIds);
    }
}
