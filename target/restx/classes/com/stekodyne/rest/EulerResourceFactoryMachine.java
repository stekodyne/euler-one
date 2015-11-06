package com.stekodyne.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import com.stekodyne.rest.EulerResource;

@Machine
public class EulerResourceFactoryMachine extends SingleNameFactoryMachine<com.stekodyne.rest.EulerResource> {
    public static final Name<com.stekodyne.rest.EulerResource> NAME = Name.of(com.stekodyne.rest.EulerResource.class, "EulerResource");

    public EulerResourceFactoryMachine() {
        super(0, new StdMachineEngine<com.stekodyne.rest.EulerResource>(NAME, 0, BoundlessComponentBox.FACTORY) {


            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(

                ));
            }

            @Override
            protected com.stekodyne.rest.EulerResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new EulerResource(

                );
            }
        });
    }

}
