package gr.aueb.mscis.educore.app.config;

import gr.aueb.mscis.educore.auth.web.AuthenticationFilter;
import gr.aueb.mscis.educore.web.mapper.DtoToDomainMapper;
import gr.aueb.mscis.educore.web.mapper.DtoToDomainMapperImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationResourceConfig extends ResourceConfig {

    public ApplicationResourceConfig(){
        this.packages("gr.aueb.mscis.educore");

        doRegister();
    }

    private void doRegister(){
        this.register(new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(new DtoToDomainMapperImpl()).to(DtoToDomainMapper.class);
            }
        });
        this.register(AuthenticationFilter.class);
    }
}
