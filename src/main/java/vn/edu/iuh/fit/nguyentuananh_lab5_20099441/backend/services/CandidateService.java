package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Candidate;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories.CandidateRepository;



@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    // Constructor injection
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

}
