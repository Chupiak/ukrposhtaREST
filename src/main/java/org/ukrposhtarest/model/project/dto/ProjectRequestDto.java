package org.ukrposhtarest.model.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class ProjectRequestDto {
    private List<Long> programmerIds;
    private List<Long> managerIds;
}
