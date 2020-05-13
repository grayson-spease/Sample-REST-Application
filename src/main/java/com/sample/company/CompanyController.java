package com.sample.company;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyPresenter companyPresenter;
    private final CompanyRepository companyRepository;

    @ApiOperation(value = "Returns company data")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully company data"),
        @ApiResponse(code = 404, message = "No data found for the company"),
        @ApiResponse(code = 500, message = "Failed to retrieve company data")
    })
    @RequestMapping(method = RequestMethod.GET, path = "/company/{companyId}")
    public ResponseEntity<CompanyResource> getCompanyData(@PathVariable int companyId) {
        CompanyDao companyDao = companyRepository.findByCompanyId(companyId).orElse(new CompanyDao());
        CompanyResource companyResource = companyPresenter.getCompanyData(companyDao);

        if (companyResource == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(companyResource);
        }
    }
}
