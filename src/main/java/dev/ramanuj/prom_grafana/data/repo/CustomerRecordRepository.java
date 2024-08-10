package dev.ramanuj.prom_grafana.data.repo;

import dev.ramanuj.prom_grafana.data.entity.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRecordRepository extends JpaRepository<CustomerRecord, UUID> {
}
