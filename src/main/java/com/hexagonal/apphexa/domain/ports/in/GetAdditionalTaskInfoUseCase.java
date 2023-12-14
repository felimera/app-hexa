package com.hexagonal.apphexa.domain.ports.in;

import com.hexagonal.apphexa.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
