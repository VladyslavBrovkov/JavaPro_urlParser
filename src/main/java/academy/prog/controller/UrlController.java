package academy.prog.controller;

import academy.prog.models.DTO.ServiceResponse;
import academy.prog.models.DTO.UrlDTO;
import academy.prog.models.DTO.UrlResultDTO;
import academy.prog.models.DTO.UrlStatDTO;
import academy.prog.service.UrlService;
import org.springframework.boot.Banner;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<Object> shorten(@RequestBody UrlDTO urlDTO) {
        long id = urlService.saveUrl(urlDTO);
        if (id != -1) {
            return new ResponseEntity<>(new ServiceResponse<>("success", id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ServiceResponse<>("duplicate", id), HttpStatus.OK);
        }
    }

    @GetMapping("/my/{id}")
    public ResponseEntity<Object> redirect(@PathVariable("id") Long id) {
        var url = urlService.getUrl(id);
        if (url != null){
            return new ResponseEntity<>(new ServiceResponse<>("success", url), HttpStatus.OK);
        } else
            return new ResponseEntity<>(new ServiceResponse<>("empty", null), HttpStatus.OK);
    }

    @GetMapping("/admin/stat")
    public ResponseEntity<Object> stat() {
        List<UrlStatDTO> list = new ArrayList<>();
        list.addAll(urlService.getStatistics());
        ServiceResponse<List<UrlStatDTO>> response = new ServiceResponse("success", list);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
