package com.hexagonal.apphexa.domain.ports.out;

import com.hexagonal.apphexa.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
