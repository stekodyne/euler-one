package com.stekodyne.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Optional;
import static com.google.common.base.Preconditions.checkNotNull;

import restx.common.Types;
import restx.*;
import restx.entity.*;
import restx.http.*;
import restx.factory.*;
import restx.security.*;
import static restx.security.Permissions.*;
import restx.description.*;
import restx.converters.MainStringConverter;
import static restx.common.MorePreconditions.checkPresent;

import javax.validation.Validator;
import static restx.validation.Validations.checkValid;

import java.io.IOException;
import java.io.PrintWriter;

@Component(priority = 0)

public class EulerResourceRouter extends RestxRouter {

    public EulerResourceRouter(
                    final EulerResource resource,
                    final EntityRequestBodyReaderRegistry readerRegistry,
                    final EntityResponseWriterRegistry writerRegistry,
                    final MainStringConverter converter,
                    final Optional<Validator> validator,
                    final RestxSecurityManager securityManager) {
        super(
            "default", "EulerResourceRouter", new RestxRoute[] {
        new StdEntityRoute<Void, com.stekodyne.domain.Message>("default#EulerResource#calculateEuler1",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<com.stekodyne.domain.Message>build(com.stekodyne.domain.Message.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/euler/1"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<com.stekodyne.domain.Message> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.calculateEuler1(
                        /* [QUERY] upto */ converter.convert(checkPresent(request.getQueryParam("upto"), "query param upto is required"), int.class)
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription upto = new OperationParameterDescription();
                upto.name = "upto";
                upto.paramType = OperationParameterDescription.ParamType.query;
                upto.dataType = "int";
                upto.schemaKey = "int";
                upto.required = true;
                operation.parameters.add(upto);


                operation.responseClass = "Message";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "com.stekodyne.domain.Message";
                operation.sourceLocation = "com.stekodyne.rest.EulerResource#calculateEuler1(int)";
            }
        },
        });
    }

}
