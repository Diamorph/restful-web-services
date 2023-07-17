package com.diamorph.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // query params as Version Identifier

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // header as Version Identifier

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Headers() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Headers() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Accept header as Version Identifier

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1RequestHeaders() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2RequestHeaders() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


}
