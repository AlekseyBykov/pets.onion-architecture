//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.controllers;

import alekseybykov.portfolio.component.dto.*;
import alekseybykov.portfolio.component.entities.FileTransferObject;
import alekseybykov.portfolio.component.entities.WhitePapper;
import alekseybykov.portfolio.component.mappings.WhitePapperMapper;
import alekseybykov.portfolio.component.services.whitepapper.WhitePapperService;
import alekseybykov.portfolio.component.utils.FileValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-08-25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/white-pappers")
@Api(tags = "whitepappers", description = "Controller for working with whitepappers")
public class WhitePapperController {

    private final WhitePapperService whitePapperService;
    private final WhitePapperMapper whitePapperMapper;
    private final FileValidator fileValidator;

    @ApiOperation(value = "Upload file with metadata")
    @PostMapping("/upload")
    @SneakyThrows
    public ResponseEntity<FileUploadDto> uploadWhitePapper(
            @ApiParam("Whitepapper's file")
            @RequestPart(name = "file") MultipartFile file,
            @ApiParam("Name of whitepapper")
            @RequestParam(name = "name") String name,
            @ApiParam("Type of whitepapper")
            @RequestParam(name = "type") String type,
            @ApiParam("Registration number of whitepapper")
            @RequestParam(name = "registrationNumber") String registrationNumber,
            @ApiParam("Registration date of whitepapper")
            @RequestParam(name = "registrationDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationDate,
            @ApiParam("Identifier of the scope of whitepapper")
            @RequestParam(name = "scopeId") Long scopeId,
            @ApiParam("Name of the scope of whitepapper")
            @RequestParam(name = "scopeName") String scopeName) {
        fileValidator.validate(file);
        ScopeDto scopeDto = ScopeDto.builder().id(scopeId).name(scopeName).build();
        WhitePapperMetadataDto whitePapperMetadataDto = WhitePapperMetadataDto.builder().name(name).type(type)
                .registrationNumber(registrationNumber).registrationDate(registrationDate)
                .scope(scopeDto).build();

        FileTransferObject fileTransferObject = FileTransferObject.builder()
                .fileName(file.getOriginalFilename())
                .stream(file.getInputStream()).build();

        Long id = whitePapperService.upload(fileTransferObject,
                whitePapperMapper.toEntity(whitePapperMetadataDto));
        return ResponseEntity.ok(FileUploadDto.builder().id(id).build());
    }

    @PostMapping()
    @ApiOperation(value = "Deleting white pappers by dentifiers")
    public void deleteByIds(@ApiParam("list of white pappers") @RequestBody IdsDto idsDto) {
        whitePapperService.deleteByIds(idsDto.getIds());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Getting all the white pappers in the system")
    public List<WhitepapperItemDto> findAll() {
        List<WhitePapper> data = whitePapperService.findAll();
        return whitePapperMapper.toListDto(data);
    }
}
