package ps.exalt.training.serverpool.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;
import ps.exalt.training.serverpool.models.ApplicationEntity;

import java.util.List;

@Repository
public interface ApplicationRepository extends AerospikeRepository<ApplicationEntity, Integer> {
}
