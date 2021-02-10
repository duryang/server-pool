package ps.exalt.training.serverpool.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.training.serverpool.models.ServerEntity;

import java.util.List;

@Repository
public interface ServerRepository extends AerospikeRepository<ServerEntity, Integer> {
}
