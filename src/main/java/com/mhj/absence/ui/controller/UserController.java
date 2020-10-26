package com.mhj.absence.ui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@Api(value = "Users", description = "Users API entry point")
public class UserController {

    @ApiOperation(value = "Get all users in the system,This ")
    @ApiResponses(value = {@ApiResponse(code = 100, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 200, message = "OK")})

    @GetMapping(produces = {"application/json"}, path = "users")
    public ResponseEntity getAllBudgets(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
