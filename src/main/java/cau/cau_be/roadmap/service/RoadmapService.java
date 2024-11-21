package cau.cau_be.roadmap.service;

import cau.cau_be.common.entity.Order;
import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.roadmap.dto.response.RoadmapElementResponse;
import cau.cau_be.roadmap.entity.Roadmap;
import cau.cau_be.roadmap.repository.RoadmapRepository;
import cau.cau_be.tech.entity.Tech;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class RoadmapService {

  private final RoadmapRepository roadmapRepository;

  public RoadmapService(RoadmapRepository roadmapRepository) {
    this.roadmapRepository = roadmapRepository;
  }

  public List<RoadmapElementResponse> getJobRoadmap(JobIdRequest jobIdRequest) {
    Roadmap roadmap = getValidatedRoadmap(jobIdRequest);
    List<Order> orders = roadmap.getOrders();
    orders.sort(Comparator.comparingInt(Order::getOrder));

    return getRoadmapResponse(orders);
  }

  private List<RoadmapElementResponse> getRoadmapResponse(List<Order> orders) {
    List<RoadmapElementResponse> roadmapResponse = new ArrayList<>();

    for (Order order : orders) {
      Tech tech = order.getTech();
      List<String> relatedSubjects = tech.getTechSubjects().stream()
          .map(techSubject -> techSubject.getSubject().getName()).toList();

      roadmapResponse.add(new RoadmapElementResponse(tech.getId(), tech.getName(), order.getOrder(),
          relatedSubjects));
    }

    return roadmapResponse;
  }

  private Roadmap getValidatedRoadmap(JobIdRequest jobIdRequest) {
    return roadmapRepository.findByJobId(jobIdRequest.id())
        .orElseThrow(() -> new NoSuchElementException(
            ErrorMessage.NOT_FOUND_ROADMAP.getErrorMessage()));
  }
}
