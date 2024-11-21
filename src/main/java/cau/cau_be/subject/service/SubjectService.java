package cau.cau_be.subject.service;

import cau.cau_be.subject.dto.response.SubjectResponse;
import cau.cau_be.subject.repository.SubjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

  private final SubjectRepository subjectRepository;

  public SubjectService(SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
  }

  public List<SubjectResponse> getSubjectList() {
    return subjectRepository.findAll().stream()
        .map(subject -> new SubjectResponse(subject.getId(), subject.getName())).toList();
  }
}
