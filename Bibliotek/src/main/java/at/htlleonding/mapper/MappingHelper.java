package at.htlleonding.mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.LinkedList;

@ApplicationScoped
public class MappingHelper {
    @Inject
    protected ObjectMapper om;

}
