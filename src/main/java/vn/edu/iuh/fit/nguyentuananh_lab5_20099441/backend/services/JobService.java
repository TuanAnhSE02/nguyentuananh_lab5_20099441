package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Job;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Page<Job> getAll(int pageNo, int pageSize, String sortBy, String sortDirection, long comId){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        List<Job> jobs =  jobRepository.findAllByCompany_Id(comId);
        return new PageImpl<>(jobs, pageable, jobs.size());
    }
}
