package at.htlleonding.logic.model.controller;

import at.htlleonding.dto.AuthorDto;
import at.htlleonding.dto.MediaDto;
import at.htlleonding.dto.xml.WorksOfAuthorDto;
import at.htlleonding.logic.LibraryMgmtLogic;
import at.htlleonding.mapper.model.AuthorMappingHelper;
import at.htlleonding.repository.model.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.Reader;
import java.io.StringReader;

@ApplicationScoped
public class AuthorLogic extends LibraryMgmtLogic {

    @Inject
    AuthorRepository authorRepository;
    @Inject
    AuthorMappingHelper mappingHelper;

    public void insert(AuthorDto dto){
        var entity =  mappingHelper.fromDto(dto);
        crudOperations.add(entity);
    }
    public AuthorDto getById(int id){
        var entity = authorRepository.findById(id);
        return mappingHelper.toDto(entity);
    }
    public AuthorDto getByName(String firstname, String lastname){
        var entity = authorRepository.findByName(firstname, lastname);
        return mappingHelper.toDto(entity);
    }
    public void createXML(WorksOfAuthorDto[] targets) throws BuisnessLogicException {
        for (var target: targets) {
            createXML(target);
        }
    }
    public void createXML(WorksOfAuthorDto target) throws BuisnessLogicException {

        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        StringBuilder sb = new StringBuilder();
        try {
            sb.append(xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(target));
            var result = sb.toString();
            System.out.println(result);

            Reader reader = new StringReader(result);
            var result2 = (WorksOfAuthorDto)xmlMapper.readValue(reader, WorksOfAuthorDto.class);
            WriteAllLines("AuthorMedia.xml", result);

        }
        catch (Exception e) {
            throw new BuisnessLogicException("fail");
        }
    }
}
