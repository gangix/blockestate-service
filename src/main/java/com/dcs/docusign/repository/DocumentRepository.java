package com.dcs.docusign.repository;

import com.dcs.docusign.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findByEnvelopeId(String envelopeId);
}
