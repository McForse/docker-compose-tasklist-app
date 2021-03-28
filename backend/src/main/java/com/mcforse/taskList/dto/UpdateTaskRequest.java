package com.mcforse.taskList.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateTaskRequest {
    @NotNull
    private Long id;
    @NotNull
    private Boolean complete;
}
