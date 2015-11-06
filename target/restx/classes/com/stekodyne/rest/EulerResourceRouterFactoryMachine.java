package com.stekodyne.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import com.stekodyne.rest.EulerResourceRouter;

@Machine
public class EulerResourceRouterFactoryMachine extends SingleNameFactoryMachine<com.stekodyne.rest.EulerResourceRouter> {
    public static final Name<com.stekodyne.rest.EulerResourceRouter> NAME = Name.of(com.stekodyne.rest.EulerResourceRouter.class, "EulerResourceRouter");

    public EulerResourceRouterFactoryMachine() {
        super(0, new StdMachineEngine<com.stekodyne.rest.EulerResourceRouter>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<com.stekodyne.rest.EulerResource> resource = Factory.Query.byClass(com.stekodyne.rest.EulerResource.class).mandatory();
private final Factory.Query<restx.entity.EntityRequestBodyReaderRegistry> readerRegistry = Factory.Query.byClass(restx.entity.EntityRequestBodyReaderRegistry.class).mandatory();
private final Factory.Query<restx.entity.EntityResponseWriterRegistry> writerRegistry = Factory.Query.byClass(restx.entity.EntityResponseWriterRegistry.class).mandatory();
private final Factory.Query<restx.converters.MainStringConverter> converter = Factory.Query.byClass(restx.converters.MainStringConverter.class).mandatory();
private final Factory.Query<javax.validation.Validator> validator = Factory.Query.byClass(javax.validation.Validator.class).optional();
private final Factory.Query<restx.security.RestxSecurityManager> securityManager = Factory.Query.byClass(restx.security.RestxSecurityManager.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
resource,
readerRegistry,
writerRegistry,
converter,
validator,
securityManager
                ));
            }

            @Override
            protected com.stekodyne.rest.EulerResourceRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new EulerResourceRouter(
satisfiedBOM.getOne(resource).get().getComponent(),
satisfiedBOM.getOne(readerRegistry).get().getComponent(),
satisfiedBOM.getOne(writerRegistry).get().getComponent(),
satisfiedBOM.getOne(converter).get().getComponent(),
satisfiedBOM.getOneAsComponent(validator),
satisfiedBOM.getOne(securityManager).get().getComponent()
                );
            }
        });
    }

}
