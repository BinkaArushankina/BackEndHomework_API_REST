package de.ait.timepad.dto.events;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "data for add event")
public class NewEventDto {

    @Schema(description = "event name", example = "Party")
    @NotNull
    @NotBlank
    private String name;

    @Schema(description = "user id", example = "1")
    @NotNull
    private Long aboutUserId;

    @Schema(description = "event date YYYY-MM-DD", example = "2022-02-02")
    @NotNull
    @NotBlank
    private String publishDate;
}
