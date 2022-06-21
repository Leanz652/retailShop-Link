package ar.edu.redLink.retailShop.app;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ImageController {


    @Autowired
    ImageRepository imageRepository;
    
    @Autowired
    ProductoRepoREST repoProducto;
    
    @Autowired
    VendedorRepoREST repoVendedor;
   
    
	@Transactional
    @PostMapping("/upload/image") public ResponseEntity<Object>
	  uplaodImage(@RequestParam("image") MultipartFile
	  file) throws IOException {
	  
    	
    	Image imagenProducto = new Image();
    	imagenProducto = Image.builder() .name(file.getOriginalFilename())
    			  .type(file.getContentType())
    			  .image(ImageUtility.compressImage(file.getBytes())).build();
	  imageRepository.save(imagenProducto); 
	   
	  return ResponseEntity.ok(null); }
    
   

    @GetMapping(path = {"/get/image/info/{id}"})
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {

        final Optional<Image> dbImage = imageRepository.findById(id);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    
    @GetMapping(path = {"/get/image/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {

        final Optional<Image> dbImage = imageRepository.findById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
