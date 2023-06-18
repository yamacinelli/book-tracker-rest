package yamacinelli.booktracker.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yamacinelli.booktracker.dto.BookDto;
import yamacinelli.booktracker.dto.FavoriteDto;
import yamacinelli.booktracker.service.FavoriteService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/{userId}")
    public ResponseEntity<FavoriteDto> saveFavorite(@Valid @PathVariable Integer userId, @RequestBody BookDto dto) {
        return ResponseEntity.ok(favoriteService.existFavorite(userId, dto));
    }
}
