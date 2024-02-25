package gr.aueb.mscis.educore.web;

import gr.aueb.mscis.educore.web.mapper.DtoToDomainMapper;

import javax.inject.Inject;

public class AbstractResource {
    @Inject
    protected DtoToDomainMapper mapper;
}
