package ar.edu.redLink.retailShop.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageUploadResponse {
    private String message;
    private Long id;

    public ImageUploadResponse(String message, Long id) {
        this.message = message;
        this.id = id;	
    }

}
