package net.url.shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDto {

    private Long id;
    private String fullLink;
    private String shortLink;
    private Boolean isExpired;
}
