package com.mcforse.taskList.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddTaskRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String note;
}
